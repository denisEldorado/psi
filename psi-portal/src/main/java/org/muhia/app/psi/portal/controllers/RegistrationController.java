/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.controllers;

import org.muhia.app.psi.portal.PortalApplication;
import org.muhia.app.psi.portal.eventbus.DashboardEvent;
import org.muhia.app.psi.portal.service.orm.*;
import org.muhia.app.psi.portal.storage.StorageService;

import org.muhia.app.psi.portal.validation.EmailExistsException;
import org.muhia.app.psi.orm.model.PasswordResetTokens;
import org.muhia.app.psi.orm.model.Principals;
import org.muhia.app.psi.orm.model.UserSecurityQuestions;
import org.muhia.app.psi.orm.repo.UserSecurityQuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@RestController
public class RegistrationController {

    @Autowired
    IPasswordResetTokenService passwordResetTokenService;
    @Autowired
    UserSecurityQuestionsRepository userSecurityQuestionsRepository;
    @Autowired
    private IDefineSecurityQuestionsService securityQuestionsService;
    @Autowired
    private ITitlesService titlesService;
    @Autowired
    private IPrincipalsService principalsService;
    @Autowired
    private IPrincipalTypesService pTypeService;
    
    private final StorageService storageService;

    @Autowired
    public RegistrationController(StorageService storageService) {
        this.storageService = storageService;
    }

    @RequestMapping(value = "/portal/signup")
    public ModelAndView registrationForm() {
        final Map<String, Object> model = new HashMap<>();
        model.put("user", new Principals());
        model.put("titles", titlesService.findTitlesByStatusActive(1));

        model.put("questions", securityQuestionsService.listActiveDefineSecurityQuestions(1));

        return new ModelAndView("registrationPage", model);

    }

    @RequestMapping(value = "/registrationConfirm")
    public ModelAndView confirmAccountActivationByEmail(@RequestParam("token") final String token, final RedirectAttributes redirectAttributes) {
        try {
            DashboardEvent.PrincipalsRegstrationConfirmationEvent regstrationConfirmationEvent = new DashboardEvent.PrincipalsRegstrationConfirmationEvent(token, redirectAttributes);
            PortalApplication.dashBoardEventBusService().post(regstrationConfirmationEvent);
            redirectAttributes.addAllAttributes(regstrationConfirmationEvent.getRedirectAttributes().asMap());
        } catch (Exception e) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            redirectAttributes.addFlashAttribute("Error", "An error occurred while processing you registration");

        }
        return new ModelAndView("redirect:/index");
    }

    @RequestMapping(value = "/portal/user/register")
    public ModelAndView registerUser(@Valid final Principals user, @RequestParam final Long questionId,
                                     @RequestParam final Long titleId, @RequestParam String answer, final BindingResult result,
                                     final HttpServletRequest request, final RedirectAttributes redirectAttributes) {
        final ModelAndView errorModel = new ModelAndView("registrationPage", "user", user);
        if (result.hasErrors()) {
            if (!(result.getFieldError("id") != null && result.getErrorCount() == 1)) {
                return errorModel;
            }
        }
        return Optional.ofNullable(user).map((Principals p) -> {

            try {
                p.setPrincipalType(pTypeService.findPrincipalTypesById(Long.valueOf("1")));
                p.setTitle(titlesService.findTitleById(titleId));
                final Principals registered = principalsService.registerNewUser(p);
                securityQuestionsService.findDefineSecurityQuestionsByID(questionId).ifPresent(
                        questions -> principalsService.saveSecurityQuestionsForUser(registered, questions, answer));
                final String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort()
                        + request.getContextPath();

                PortalApplication.dashBoardEventBusService().post(new DashboardEvent.RegistrationCompletedEvent(appUrl, registered));

                redirectAttributes.addFlashAttribute("message", "You should receive a confirmation email shortly");
                return new ModelAndView("redirect:/index");
            } catch (EmailExistsException | Exception ex) {
                Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
                return errorModel;
            }
        }).orElse(errorModel);

    }

    @RequestMapping(value = "/portal/forgotpassword")
    public ModelAndView forgotPasswordForm() {
        return new ModelAndView("forgotPassword");
    }

    @RequestMapping(value = "/portal/forgotpassword",
            method = RequestMethod.POST)
    public ModelAndView forgotPassword(@RequestParam final String email, final RedirectAttributes redirectAttributes,
                                       final HttpServletRequest request) {
        Principals principals = principalsService.findUserByEmail(email);
        final String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort()
                + request.getContextPath();
        try {
            DashboardEvent.ForgotPasswordEvent forgotPasswordEvent = new DashboardEvent.ForgotPasswordEvent(principals, appUrl);
            PortalApplication.dashBoardEventBusService().post(forgotPasswordEvent);
            redirectAttributes.addFlashAttribute("message", "An email has been sent to your Account.");
        } catch (Exception e) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            redirectAttributes.addFlashAttribute("Error", "An error occurred while processing you registration");

        }
        return new ModelAndView("redirect:/index");
    }

    @RequestMapping(value = "/forgotpasswordconfirm")
    public ModelAndView confirmForgotPasswordForm(@RequestParam("token") final String token, final RedirectAttributes redirectAttributes) {
        PasswordResetTokens passwordResetTokens = passwordResetTokenService.getPasswordResetToken(token);
        try {
            if (passwordResetTokens == null) {
                redirectAttributes.addFlashAttribute("errorMessage", "Invalid token.");

            }
            final Calendar cal = Calendar.getInstance();
            if (((passwordResetTokens != null ? passwordResetTokens.getExpiryDate().getTime() : 0) - cal.getTime().getTime()) <= 0) {
                redirectAttributes.addFlashAttribute("errorMessage", "Your registration token has expired. Please register again.");
            }
            return new ModelAndView("forgotpasswordconfirm");

        } catch (NullPointerException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            redirectAttributes.addFlashAttribute("errorMessage", "Invalid token.");
            return new ModelAndView("/index");
        }

    }

    @RequestMapping(value = "/forgotpasswordconfirm",
            method = RequestMethod.POST)
    public ModelAndView confirmForgotPassword(@RequestParam("token") final String token, final RedirectAttributes redirectAttributes,
                                              @RequestParam final String password, @RequestParam final String passwordconfirmation) {
        if (!password.equals(passwordconfirmation)) {
            redirectAttributes.addFlashAttribute("error", "password confirmation failed");
            return new ModelAndView("forgotpasswordconfirm");
        }
        try {
            DashboardEvent.ForgotPasswordConfirmEvent forgotPasswordConfirmEvent = new DashboardEvent.ForgotPasswordConfirmEvent(token, redirectAttributes, password);
            PortalApplication.dashBoardEventBusService().post(forgotPasswordConfirmEvent);
            redirectAttributes.addFlashAttribute("message", "Password recovered. Login with your new password");
        } catch (Exception e) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, e.getMessage(), e);

        }
        return new ModelAndView("redirect:/index");
    }
    
    @RequestMapping(value="/profile")
    public ModelAndView changePasswordForm(Principal principal){
        Principals principals=principalsService.findByLoginName(principal.getName());
        Optional<UserSecurityQuestions> userSecurityBoolean=userSecurityQuestionsRepository.findUserSecurityQuestionsByUserIdAndStatus(principals,1);
        Map<String, Object> model = new HashMap<>();
        model.put("user", principals);
        if (userSecurityBoolean.isPresent()) {
            UserSecurityQuestions userSecurityQuestions = userSecurityBoolean.get();
            model.put("userSecurityQuestion", userSecurityQuestions);
        }
        return new ModelAndView("/profile/profile", model);
    }

    @RequestMapping(value = "/changepassword",
            method = RequestMethod.POST)
    public ModelAndView changePassword(Principal principal, @RequestParam final String newpassword,
                                       @RequestParam final String passwordconfirmation, RedirectAttributes redirectAttributes,
                                       @RequestParam final String answer, @RequestParam final String oldpassword) {

        final ModelAndView errorModel = new ModelAndView("redirect:/profile");
        if (!newpassword.equals(passwordconfirmation)) {
            redirectAttributes.addFlashAttribute("error", "password confirmation failed");
            return errorModel;
        }
        /*
            TODO: Lets discuss and understand the role of the model here
         */
        Map<String, Object> model = new HashMap<>();
        try {
            Principals principals = principalsService.findByLoginName(principal.getName());
            Optional<UserSecurityQuestions> userSecurityBoolean = userSecurityQuestionsRepository.findUserSecurityQuestionsByUserIdAndStatus(principals, 1);
            model.put("userSecurityQuestion", userSecurityBoolean.get());
            model.put("user", principals);
            DashboardEvent.ChangePasswordEvent changePasswordEvent = new DashboardEvent.ChangePasswordEvent(newpassword, oldpassword, answer, redirectAttributes, principals, userSecurityBoolean.get());
            PortalApplication.dashBoardEventBusService().post(changePasswordEvent);
            redirectAttributes.addFlashAttribute("message", "Password changed");
            return new ModelAndView("redirect:/profile");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "An error occured");
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return errorModel;
        }
    }
    
    
    @RequestMapping(value="/upload",
            method=RequestMethod.POST)
    public ModelAndView uploadPicture(Principal principal,@RequestParam("picture") MultipartFile pic,
                                   RedirectAttributes redirectAttributes,
                                   HttpServletRequest request){
        String pictoken= UUID.randomUUID().toString()+".png";
        Principals principals = principalsService.findByLoginName(principal.getName());
        
        try {
            if(ImageIO.read(pic.getInputStream()) != null){
                storageService.store(pic,pictoken);
                principals.setPicturepath(pictoken);
                DashboardEvent.ModifyUserEvent modifyUserEvent= new DashboardEvent.ModifyUserEvent(principals,redirectAttributes);
                PortalApplication.dashBoardEventBusService().post(modifyUserEvent);
                redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded " + pic.getOriginalFilename() + "!");
                request.getSession().setAttribute("picturepath",principals.getPicturepath());
            }else{
                redirectAttributes.addFlashAttribute("message",
                    pic.getOriginalFilename() + "is not an image file!");
            }
            
        }
        catch(Exception e){
            redirectAttributes.addFlashAttribute("message",
                "File not uploaded!");
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        
        return new ModelAndView("redirect:/profile");
    }

}
