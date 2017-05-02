/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.controllers;

import org.muhia.app.psi.portal.PortalApplication;
import org.muhia.app.psi.portal.eventbus.DashboardEvent;
import org.muhia.app.psi.portal.service.orm.IPrincipalsSavingsTargetsService;
import org.muhia.app.psi.portal.service.orm.IPrincipalsService;
import org.muhia.app.psi.portal.service.orm.ISavingsTargetIntervalService;
import org.muhia.app.psi.portal.service.orm.ISavingsTargetTypeService;
import org.muhia.app.psi.config.order.properties.OrderProcessingProperties;
import org.muhia.app.psi.orm.model.Principals;
import org.muhia.app.psi.orm.model.PrincipalsSavingsTarget;
import org.muhia.app.psi.orm.model.SavingsInterval;
import org.muhia.app.psi.orm.model.SavingsTargetType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mathenge
 */
@Controller

public class SavingsTargetController {

    @Autowired
    private IPrincipalsSavingsTargetsService savingsTargetService;

    @Autowired
    private IPrincipalsService principalService;

    @Autowired
    private ISavingsTargetTypeService savingsTargetTypeService;

    @Autowired
    private ISavingsTargetIntervalService savingsTargetIntervalService;
    @Autowired
    private OrderProcessingProperties orderProcessingProperties;

    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    @RequestMapping(value = "/savings", method = RequestMethod.GET)
    public ModelAndView listSavingsTarget(Principal principal) {

        Principals loggedInUser = principalService.findByLoginName(principal.getName());
        Collection<PrincipalsSavingsTarget> savingsTarget = savingsTargetService.findByPrincipal(loggedInUser);
        HashMap<String, Object> model = new HashMap<>();
        model.put("targets", savingsTarget);
        return new ModelAndView("target/list", model);
    }

    @RequestMapping(value = "/savings/create", method = RequestMethod.GET)
    public ModelAndView createForm() {
        HashMap<String, Object> model = new HashMap<>();
        Collection<SavingsInterval> intervals = savingsTargetIntervalService.listAllIntervals();
        Collection<SavingsTargetType> types = savingsTargetTypeService.listTargetTypes();
        PrincipalsSavingsTarget savingsTarget = new  PrincipalsSavingsTarget();
        model.put("intervals", intervals);
        model.put("types", types);
        model.put("savingsTarget",savingsTarget);

        return new ModelAndView("target/create",model);

    }

    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    @RequestMapping(value = "/savings", method = RequestMethod.POST)
    public ModelAndView createSavingsTarget(PrincipalsSavingsTarget target,Principal principal, 
             @RequestParam("type") final Long type,
             @RequestParam("amount") final int amount,
             @RequestParam("target") final int targetSaving,
             @RequestParam("interval") final Long interval,
            final RedirectAttributes redirectAttributes,BindingResult result) {
        if (result.hasErrors()) {
            if (!(result.getFieldError("id") != null && result.getErrorCount() == 1)) {
                return new ModelAndView("target/create", "formErrors", result.getAllErrors());
            }
        }
        return Optional.ofNullable(target).map((PrincipalsSavingsTarget l) -> {

            try {
                Principals loggedInUser = principalService.findByLoginName(principal.getName());
                Map<String, String> productParamsMap = new HashMap<>();
                productParamsMap.put(orderProcessingProperties.getProductidKeyword(), "7");
                productParamsMap.put(orderProcessingProperties.getTypeKeyword(), Long.toString(type));
                productParamsMap.put(orderProcessingProperties.getIntervalKeyword(),Long.toString(interval) );
                productParamsMap.put(orderProcessingProperties.getAmountKeyword(),Integer.toString(amount));
                productParamsMap.put(orderProcessingProperties.getTargetKeyword(),Integer.toString(targetSaving));
                productParamsMap.put(orderProcessingProperties.getCellphonenumberKeyword(), loggedInUser.getCellphonenumber());
                
                DashboardEvent.SavingsTargetcreatedEvent targetRequestedEvent = new DashboardEvent.SavingsTargetcreatedEvent(productParamsMap);
                PortalApplication.dashBoardEventBusService().post(targetRequestedEvent);
                

                redirectAttributes.addFlashAttribute("message", "target successfully created");
                return new ModelAndView("redirect:/home");
            } catch (Exception e) {
                Logger.getLogger(LoanController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
                return new ModelAndView("target/create", "formErrors", result.getAllErrors());
            }
        }).orElse(new ModelAndView("target/create", "loans/borrow", result.getAllErrors()));
            
        
        
        

    }
    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    @RequestMapping(value = "/savings/deactivate/{id}")
    public ModelAndView deactivateSavingsTarget(Principal principal,@PathVariable("id") Long id,final RedirectAttributes redirectAttributes) {

        Principals loggedInUser = principalService.findByLoginName(principal.getName());

        HashMap<String, String> productParamMap = new HashMap<>();
        productParamMap.put(orderProcessingProperties.getProductidKeyword(),"11");
        productParamMap.put(orderProcessingProperties.getTargetIdKeyword(),id.toString());
        productParamMap.put(orderProcessingProperties.getCellphonenumberKeyword(),loggedInUser.getCellphonenumber().toString());
        //TODO remove in template definition
        productParamMap.put(orderProcessingProperties.getTargetKeyword(),"not need");
        DashboardEvent.savingsTargetDeactivateEvent deactivateEvent = new DashboardEvent.savingsTargetDeactivateEvent(productParamMap);
        PortalApplication.dashBoardEventBusService().post(deactivateEvent);
        redirectAttributes.addFlashAttribute("message", "Your deactivation request is being processed");

        return new ModelAndView("redirect:/home");
    }

}
