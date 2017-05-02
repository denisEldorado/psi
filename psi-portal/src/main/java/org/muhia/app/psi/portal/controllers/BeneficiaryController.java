/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.controllers;

import org.muhia.app.psi.portal.PortalApplication;
import org.muhia.app.psi.portal.eventbus.DashboardEvent;
import org.muhia.app.psi.orm.model.BeneficiaryTypes;
import org.muhia.app.psi.orm.model.Principals;
import org.muhia.app.psi.orm.model.UserBeneficiaries;
import org.muhia.app.psi.orm.repo.BeneficiaryTypesRepository;
import org.muhia.app.psi.orm.repo.PrincipalsRepository;
import org.muhia.app.psi.orm.repo.UserBeneficiariesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ngatia
 */
@Controller
public class BeneficiaryController {
    
    @Autowired
    UserBeneficiariesRepository userBeneficiariesRepository;
    
    @Autowired
    PrincipalsRepository principalsRepository;
    
    @Autowired
    BeneficiaryTypesRepository beneficiaryTypesRepository;

    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    @RequestMapping(
            value="/beneficiary",
            method=RequestMethod.GET,
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    public ModelAndView getBeneficiaries(Principal principal) {
        Principals principals=principalsRepository.findByLoginName(principal.getName());
        final Iterable<UserBeneficiaries> userBeneficiaries=userBeneficiariesRepository.findUserBeneficiariesByPrincipalAndStatus(principals,"1");
        return new ModelAndView("beneficiary/list", "beneficiaries", userBeneficiaries);
    }
    
    
    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    @RequestMapping(
            value="/beneficiary",
            method=RequestMethod.POST
    )
    public ModelAndView saveUserBeneficiary(
            @Valid final UserBeneficiaries userBeneficiaries,final BindingResult result,Principal principal,
            final RedirectAttributes redirectAttributes){
        
        final ModelAndView errorModel = new ModelAndView("/beneficiary/create", "userBeneficiaries", userBeneficiaries);
        if (result.hasErrors()) {
            if(!(result.getFieldError("id")!=null && result.getErrorCount()==1)){
                return errorModel;
            }
        }
        return Optional.ofNullable(userBeneficiaries).map((UserBeneficiaries userBen) -> {

            try {
                Principals principals=principalsRepository.findByLoginName(principal.getName());
                DashboardEvent.RegisterBeneficiaryEvent registerBeneficiaryEvent = new DashboardEvent.RegisterBeneficiaryEvent(userBen,principals);
                PortalApplication.dashBoardEventBusService().post(registerBeneficiaryEvent);
                redirectAttributes.addFlashAttribute("message", "Beneficiary saved successfully");
                return new ModelAndView("redirect:/beneficiary");
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("error", "An error occured while saving the Beneficiary");
                Logger.getLogger(BeneficiaryController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
                return errorModel;
            }
        }).orElse(errorModel);
        
    }
    
    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    @RequestMapping(
            value="/beneficiary/{id}",
            method=RequestMethod.POST
    )
    public ModelAndView updateBeneficiary(@PathVariable("id") Long id,
                        @Valid final UserBeneficiaries userBeneficiaries,
                        final BindingResult result,
                        Principal principal,
                        final RedirectAttributes redirectAttributes){
        final ModelAndView errorModel = new ModelAndView("/beneficiary/edit", "userBeneficiaries", userBeneficiaries);
        if (result.hasErrors()) {
            return errorModel;
        }
        return Optional.ofNullable(userBeneficiaries).map((UserBeneficiaries userBen) -> {

            try {
                Principals principals=principalsRepository.findByLoginName(principal.getName());
                DashboardEvent.EditBeneficiaryEvent editBeneficiaryEvent = new DashboardEvent.EditBeneficiaryEvent(userBeneficiaries,id,principals);
                PortalApplication.dashBoardEventBusService().post(editBeneficiaryEvent);
                redirectAttributes.addFlashAttribute("message", "Beneficiary saved successfully");
                return new ModelAndView("redirect:/beneficiary");
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("error", "An error occured while saving the Beneficiary");
                Logger.getLogger(BeneficiaryController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
                return errorModel;
            }
        }).orElse(errorModel);
    }
    
    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    @RequestMapping(
            value="/beneficiary/delete/{id}"
    )
    public ModelAndView deleteBeneficiary(@PathVariable("id") Long id,Principal principal,
                                    final RedirectAttributes redirectAttributes){
        try {
            Principals principals=principalsRepository.findByLoginName(principal.getName());
            DashboardEvent.DeleteBeneficiaryEvent deleteBeneficiaryEvent = new DashboardEvent.DeleteBeneficiaryEvent(id,principals);
            PortalApplication.dashBoardEventBusService().post(deleteBeneficiaryEvent);
            redirectAttributes.addFlashAttribute("message", "Beneficiary Deleted successfully");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "An error occurred");
            Logger.getLogger(BeneficiaryController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return new ModelAndView("redirect:/beneficiary");
    }
    
    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    @RequestMapping(
            value="/beneficiary/{id}",
            method=RequestMethod.GET 
    )
    
    public ModelAndView getBeneficiary(@PathVariable Long id){
        UserBeneficiaries userBeneficiaries=userBeneficiariesRepository.findOne(id);
        return new ModelAndView("beneficiary/view","beneficiary",userBeneficiaries);
    }
    
    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    @RequestMapping(value = "/newbeneficiary")
    public ModelAndView createBeneficiaryForm() {
        List<BeneficiaryTypes> beneficiaryTypes=beneficiaryTypesRepository.findAll();
        Map<String, Object> model = new HashMap<>();
        model.put("userBeneficiaries", new UserBeneficiaries());
        model.put("beneficiaryTypes",beneficiaryTypes);
        return new ModelAndView("/beneficiary/create",model);
    }
    
    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    @RequestMapping(value="/editbeneficiary/{id}")
    public ModelAndView editBeneficiaryForm(@PathVariable("id") Long id) {
        Map<String, Object> model = new HashMap<>();
        List<BeneficiaryTypes> beneficiaryTypes=beneficiaryTypesRepository.findAll();
        UserBeneficiaries userBeneficiaries=userBeneficiariesRepository.findOne(id);
        model.put("userBeneficiaries",userBeneficiaries);
        model.put("beneficiaryTypes",beneficiaryTypes);
        return new ModelAndView("/beneficiary/edit",model);
    } 
    
}
