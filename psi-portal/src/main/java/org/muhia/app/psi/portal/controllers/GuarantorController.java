
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.controllers;

import org.muhia.app.psi.config.order.properties.OrderProcessingProperties;
import org.muhia.app.psi.orm.model.Principals;
import org.muhia.app.psi.orm.model.PrincipalsGuarantor;
import org.muhia.app.psi.orm.model.PrincipalsLoans;
import org.muhia.app.psi.portal.PortalApplication;
import org.muhia.app.psi.portal.eventbus.DashboardEvent;
import org.muhia.app.psi.portal.service.AsyncBean;
import org.muhia.app.psi.portal.service.orm.IPrincipalsContributionsService;
import org.muhia.app.psi.portal.service.orm.IPrincipalsGuarantorService;
import org.muhia.app.psi.portal.service.orm.IPrincipalsLoansService;
import org.muhia.app.psi.portal.service.orm.IPrincipalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author mathenge
 */
@RestController

public class GuarantorController {

    private final IPrincipalsGuarantorService guarantorService;
    private final IPrincipalsService principalsService;
    private final AsyncBean asyncBean;
    private final IPrincipalsContributionsService contributionService;
    private final IPrincipalsLoansService loansService;

    private final OrderProcessingProperties orderProcessingProperties;

    @Autowired
    public GuarantorController(IPrincipalsGuarantorService guarantorService, IPrincipalsService principalsService, AsyncBean asyncBean, IPrincipalsContributionsService contributionService, IPrincipalsLoansService loansService, OrderProcessingProperties orderProcessingProperties) {
        this.guarantorService = guarantorService;
        this.principalsService = principalsService;
        this.asyncBean = asyncBean;
        this.contributionService = contributionService;
        this.loansService = loansService;
        this.orderProcessingProperties = orderProcessingProperties;
    }


    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")

    @RequestMapping(value = "/guarantors", method = RequestMethod.GET)

    public ModelAndView list(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        Principals loggedInUser = principalsService.findByLoginName(principal.getName());
        Collection<PrincipalsGuarantor> guarantors = guarantorService.findPrincipalGuarantorsByPrincipal(loggedInUser);

        return new ModelAndView("pg/list", "guarantors", guarantors);

    }

    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")

    @RequestMapping(value = "/guarantors", method = RequestMethod.POST)
    public ModelAndView create(PrincipalsGuarantor guarantor, @RequestParam("phonenumber") String phonenumber, @RequestParam("amountrequested") final int amountrequested,
                               final BindingResult result,
                               final RedirectAttributes redirect, Principal principal, @RequestParam("loanid") final Long loanid) {
//        if(result.hasErrors()){
//            Logger.getLogger(GuarantorController.class.getName()).info(String.format("Do you hav errors?"));
//            return new ModelAndView("pg/request", "formErrors", result.getAllErrors());
//        }
//        Principals guarantors = principalsService.findByLoginName(emailaddress);
//
        PrincipalsLoans loan = loansService.findLoanById(loanid);
//        if (guarantors == null) {
//            // no user with that email found
//            
//            redirect.addFlashAttribute("globalMessage", "No user found");
//            return new ModelAndView("redirect:/guarantors/request/{id}", "id", loan);
//        }
        Principals loggedInUser = principalsService.findByLoginName(principal.getName());

        Map<String, String> productParamsMap = new HashMap<>();
        productParamsMap.put(orderProcessingProperties.getProductidKeyword(), "3");
        productParamsMap.put(orderProcessingProperties.getAmountRequestedKeyword(), Integer.toString(amountrequested));
        productParamsMap.put(orderProcessingProperties.getPhonenumberKeyword(), phonenumber);
        productParamsMap.put(orderProcessingProperties.getCellphonenumberKeyword(), loggedInUser.getCellphonenumber());
        productParamsMap.put(orderProcessingProperties.getLoanIdKeyword(), Long.toString(loanid));
        try {
            DashboardEvent.GuarantorRequestedCompletedEvent guarantorRequestEvent = new DashboardEvent.GuarantorRequestedCompletedEvent(productParamsMap);
            PortalApplication.dashBoardEventBusService().post(guarantorRequestEvent);

            double maxlimit = contributionService.getMaxLimit(loggedInUser);
            double remaining = loan.getAmountloaned() - (amountrequested + maxlimit);
            if (remaining > 0) {
                return new ModelAndView("redirect:/guarantors/request/{id}", "id", loan);
            }
        } catch (Exception e) {
            Logger.getLogger(GuarantorController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            //redirectAttributes.addFlashAttribute("Error", "An error occurred while processing you registration");
            //return new ModelAndView("pg/request", "formErrors", result.getAllErrors());
        }
        redirect.addFlashAttribute("globalMessage", "Successfully requested a new guarantor");
        //return new ResponseEntity<PrincipalsGuarantor>(guarantor, HttpStatus.OK);
        return new ModelAndView("redirect:/home");

    }

    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")

    @RequestMapping(value = "/guarantors/request/{id}", method = RequestMethod.GET)
    public ModelAndView createForm(Principal principal, @PathVariable("id") final Long loanid) {

        Principals loggedInUser = principalsService.findByLoginName(principal.getName());

        PrincipalsLoans loan = loansService.findLoanById(loanid);
        Logger.getLogger(GuarantorController.class.getName()).info(String.format("emailaddress %s", loan));

        double maxlimit = contributionService.getMaxLimit(loggedInUser);
        final Collection<PrincipalsGuarantor> guarantors = guarantorService.findPrincipalGuarantorByloan(loggedInUser, loan);
        final Collection<PrincipalsGuarantor> users = guarantorService.findPrincipalGuarantorsByPrincipal(loggedInUser);
        final Map<String, Object> model = new HashMap<>();
        double remaining = 0;
        if (guarantors.isEmpty()) {
            remaining = loan.getAmountloaned() - maxlimit;
        } else {
            int total = 0;
            total = guarantors.stream().map((amount) -> amount.getAmmountrequested()).reduce(total, Integer::sum);
            remaining = loan.getAmountloaned() - (maxlimit + total);
            if (remaining <= 0) {
                return new ModelAndView("redirect:/home");
            }
        }

        //model.put("principalsGuarantor",new PrincipalsGuarantor());
        model.put("users", users);
        model.put("remaining", remaining);
        model.put("loan", loan);
        return new ModelAndView("pg/request", model);
        //return new ResponseEntity<Collection<Principals>>(users,HttpStatus.OK);
    }

    //function to load guarantor requests
    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")

    @RequestMapping(value = "/guarantors/approve", method = RequestMethod.GET)
    public ModelAndView listRequests(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        Principals loggedInUser = principalsService.findByLoginName(principal.getName());
        Collection<PrincipalsGuarantor> guarantees = guarantorService.listGuaranteeRequest(loggedInUser);

        return new ModelAndView("pg/approveRequest", "guarantees", guarantees);
    }

    //Decline a guarantee request 
    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")

    @RequestMapping(value = "/guarantors/request/decline/{id}", method = RequestMethod.GET)
    public ModelAndView decline(@PathVariable("id") final Long id) {
        PrincipalsGuarantor request = guarantorService.findPrincipalGuarantorsById(id);

        DashboardEvent.GuarantorDeclineCompletedEvent declineEvent = new DashboardEvent.GuarantorDeclineCompletedEvent(request);
        PortalApplication.dashBoardEventBusService().post(declineEvent);
        return new ModelAndView("redirect:/guarantors/approve");

    }

    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")

    @RequestMapping(value = "/guarantors/request/approve/{id}", method = RequestMethod.GET)
    public ModelAndView approve(@PathVariable("id") final Long id) {
        PrincipalsGuarantor request = guarantorService.findPrincipalGuarantorsById(id);
        request.setAmmountguaranteed(request.getAmmountrequested());
        DashboardEvent.GuarantorApproveCompletedEvent approveEvent = new DashboardEvent.GuarantorApproveCompletedEvent(request);
        PortalApplication.dashBoardEventBusService().post(approveEvent);
        return new ModelAndView("redirect:/guarantors/approve");

    }

    //When someone guarantees you for less
    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")

    @RequestMapping(value = "/guarantors/partial/approve/{id}", method = RequestMethod.GET)
    ModelAndView approveLess(@PathVariable("id") final Long id) {
        PrincipalsGuarantor guarantee = guarantorService.findPrincipalGuarantorsById(id);

        return new ModelAndView("pg/approvePartial", "guarantee", guarantee);

    }

    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    @RequestMapping(value = "/guarantors/approve/partial/{id}", method = RequestMethod.POST)
    ModelAndView approveLess(@PathVariable("id") final Long id, @RequestParam("amountguaranteed") final int amountguaranteed) {
        PrincipalsGuarantor request = guarantorService.findPrincipalGuarantorsById(id);
        request.setAmmountguaranteed(amountguaranteed);

        Logger.getLogger(GuarantorController.class.getName()).info(String.format("Amount = %S", request.getAmmountguaranteed()));
        DashboardEvent.GuarantorApproveCompletedEvent approveEvent = new DashboardEvent.GuarantorApproveCompletedEvent(request);
        PortalApplication.dashBoardEventBusService().post(approveEvent);
        return new ModelAndView("redirect:/guarantors/approve");

    }
}
