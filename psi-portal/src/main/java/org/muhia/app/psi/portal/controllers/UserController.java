/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.controllers;

import org.muhia.app.psi.portal.PortalApplication;
import org.muhia.app.psi.portal.eventbus.DashboardEvent;
import org.muhia.app.psi.portal.service.AsyncBean;
import org.muhia.app.psi.portal.service.orm.IPrincipalsService;

import org.muhia.app.psi.portal.validation.EmailExistsException;
import org.muhia.app.psi.orm.model.Principals;
import org.muhia.app.psi.orm.repo.PrincipalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@Controller
@RequestMapping(path = {"/users"})
public class UserController {

    @Autowired
    PrincipalsRepository principalsRepository;

    @Autowired
    IPrincipalsService iPrincipalsService;

    @Autowired
    AsyncBean asyncBean;

//    @RequestMapping
//   // public ResponseEntity<Collection<Principals>> list() {
//    public ModelAndView list (){
//        final Collection<Principals> users = this.principalsRepository.findAll();
//
//        asyncBean.asyncMethod();
//        return new ModelAndView("tl/list", "users", users);
//        //return new ResponseEntity<Collection<Principals>>(users,HttpStatus.OK);
//
//    }

    @RequestMapping("{id}")
    public ModelAndView view(@PathVariable("id") final Principals user) {
        return new ModelAndView("tl/view", "users", user);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView create(@Valid final Principals user, final BindingResult result, final RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return new ModelAndView("tl/form", "formErrors", result.getAllErrors());
        }
        try {
            iPrincipalsService.registerNewUser(user);
        } catch (EmailExistsException e) {
            result.addError(new FieldError("user", "email", e.getMessage()));
            return new ModelAndView("tl/form", "user", user);
        }
        redirect.addFlashAttribute("globalMessage", "Successfully created a new user");
        return new ModelAndView("redirect:/users/{user.id}", "user.id", user.getId());
    }

    @RequestMapping(value = "delete/{id}")
    public ModelAndView delete(@PathVariable("id") final Long id) {
        this.principalsRepository.delete(id);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "modify/{id}", method = RequestMethod.GET)
    public ModelAndView modifyForm(@PathVariable("id") final Principals user) {
        return new ModelAndView("tl/form", "user", user);
    }

    // the form

    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String createForm(@ModelAttribute final Principals user) {
        return "tl/form";
    }
    
    @PreAuthorize("hasRole(UI_USER)")
    @RequestMapping(
            value="modify/{id}",
            method=RequestMethod.POST
            )
    public ModelAndView modifyUser(
            @Valid Principals user,
            final BindingResult result,
            Principal principal,
            final RedirectAttributes redirectAttributes){
        
        final ModelAndView errorModel = new ModelAndView("/profile/profile","user",user);
//        if (result.hasErrors()) {
//            return errorModel;
//        }
        return Optional.ofNullable(user).map((Principals p) -> {

            try {
                DashboardEvent.ModifyUserEvent modifyUserEvent= new DashboardEvent.ModifyUserEvent(p,redirectAttributes);
                PortalApplication.dashBoardEventBusService().post(modifyUserEvent);
                redirectAttributes.addFlashAttribute("message", "Profile modified successfully");
                return new ModelAndView("redirect:/profile","user",p);
            } catch (Exception e) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
                return errorModel;
            }
        }).orElse(errorModel);
    }

}
