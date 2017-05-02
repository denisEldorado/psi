
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.controllers;

import org.muhia.app.psi.config.order.properties.OrderProcessingProperties;
import org.muhia.app.psi.orm.model.Principals;
import org.muhia.app.psi.orm.model.PrincipalsLoans;
import org.muhia.app.psi.portal.PortalApplication;
import org.muhia.app.psi.portal.eventbus.DashboardEvent;
import org.muhia.app.psi.portal.service.orm.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mathenge
 */
@RestController

public class LoanController {

    @Autowired
    IPrincipalsLoansService loansService;

    @Autowired
    IPrincipalsService principalService;

    @Autowired
    IPrincipalsContributionsService contributionService;

    @Autowired
    IInterestRateService interestRateService;

    @Autowired
    IPaybackPeriodService paybackService;

    @Autowired
    private OrderProcessingProperties orderProcessingProperties;


    /*
        DONE: Seems to be in every controller why not put it in a service
     */


    //list all loans for a principal
    @PreAuthorize("hasAnyRole('UI_USER','USSD_USER')")
    @RequestMapping(value = "/loans", method = RequestMethod.GET)
    public ModelAndView listLoans(Principal principal) {

        Principals loggedInUser = principalService.findByLoginName(principal.getName());
        final Collection<PrincipalsLoans> loans = this.loansService.findLoanByPrincipal(loggedInUser);
        loans.stream().filter((loan) -> (loan.getLoanedapprovedon() != null)).forEachOrdered((loan) -> {
            Date deadline = loansService.addPayBackDays(loan.getLoanedapprovedon(), paybackService.findActivePayBackPeriod().getPaybackperiod().intValue());
            loan.setLoanedapprovedon(deadline);
        });
        return new ModelAndView("loans/list", "loans", loans);

    }

    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    //create form to borrow loan
    @RequestMapping(value = "/loans/borrow", method = RequestMethod.GET)
    public ModelAndView getCreateForm(Principal principal, @ModelAttribute PrincipalsLoans loan) {

        Principals loggedInUser = principalService.findByLoginName(principal.getName());
        final Collection<PrincipalsLoans> loans = this.loansService.findLoanByPrincipal(loggedInUser);
        final Map<String, Object> model = new HashMap<>();
        model.put("loans", loans);

        double maxlimit = contributionService.getMaxLimit(loggedInUser);
        model.put("loan", new PrincipalsLoans());
        model.put("maxlimit", maxlimit);

        return new ModelAndView("loans/borrow", model);

    }

    @PreAuthorize("hasAnyRole('UI_USER','USSD_USER')")
    //posting a loan request 
    @RequestMapping(value = "/loans/borrow", method = RequestMethod.POST)
    public ModelAndView processLoanRequest(PrincipalsLoans loan, @RequestParam("amountloaned") final long amountloaned, BindingResult result, Principal principal,
            final RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            if (!(result.getFieldError("id") != null && result.getErrorCount() == 1)) {
                return new ModelAndView("loans/borrow", "formErrors", result.getAllErrors());
            }
        }
        return Optional.ofNullable(loan).map((PrincipalsLoans l) -> {

            try {
                Principals loggedInUser = principalService.findByLoginName(principal.getName());
                Collection<PrincipalsLoans> previousLoan = loansService.findLoanByPrincipal(loggedInUser);

                // checking if you have an unpaid loan
                boolean notpaid = false;
                if (!previousLoan.isEmpty()) {

                    for (PrincipalsLoans prev : previousLoan) {
                        if (prev.getStatus() != orderProcessingProperties.getPaidStatus()) {
                            notpaid = true;
                        }
                    }
                }
                if(notpaid){
                    redirectAttributes.addFlashAttribute("message", "You have a previous unpaid loan");
                    return new ModelAndView("loans/borrow");

                }
                Map<String, String> productParamsMap = new HashMap<>();
                productParamsMap.put(orderProcessingProperties.getProductidKeyword(), "4");
                productParamsMap.put(orderProcessingProperties.getAmountLoanedKeyword(), Long.toString(amountloaned));
                productParamsMap.put("loginname", principal.getName());
                productParamsMap.put(orderProcessingProperties.getCellphonenumberKeyword(), loggedInUser.getCellphonenumber());

                DashboardEvent.LoanRequestedCompletedEvent loanRequestEvent = new DashboardEvent.LoanRequestedCompletedEvent(productParamsMap);
                PortalApplication.dashBoardEventBusService().post(loanRequestEvent);
                double maxlimit = contributionService.getMaxLimit(loggedInUser);

                if (maxlimit < amountloaned) {
                    redirectAttributes.addFlashAttribute("message", "Loan needs guarantors");
                    return new ModelAndView("redirect:/home");
                }

                redirectAttributes.addFlashAttribute("message", "loan request successful");
                return new ModelAndView("redirect:/home");
            } catch (Exception e) {
                Logger.getLogger(LoanController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
                return new ModelAndView("loans/borrow", "formErrors", result.getAllErrors());
            }
        }).orElse(new ModelAndView("loans/borrow", "loans/borrow", result.getAllErrors()));
    }

    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    @RequestMapping(value = "loans/rafiki/request", method = RequestMethod.GET)
    public ModelAndView createRafikiForm() {
        final Map<String, Object> model = new HashMap<>();

        model.put("loan", new PrincipalsLoans());

        return new ModelAndView("loans/rafiki", model);
    }

    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    //posting a loan request 
    @RequestMapping(value = "/loans/rafiki/request", method = RequestMethod.POST)
    public ModelAndView processLoanRequestFromRafiki(PrincipalsLoans loan,
            @RequestParam("amountloaned") final long amountloaned,
            @RequestParam("phonenumber") final String phonenumber,
            BindingResult result, Principal principal,
            final RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            if (!(result.getFieldError("id") != null && result.getErrorCount() == 1)) {
                return new ModelAndView("loans/rafiki", "formErrors", result.getAllErrors());
            }
        }
        return Optional.ofNullable(loan).map((PrincipalsLoans l) -> {

            try {
                Principals loggedInUser = principalService.findByLoginName(principal.getName());
                Map<String, String> productParamsMap = new HashMap<>();
                productParamsMap.put(orderProcessingProperties.getProductidKeyword(), "8");
                productParamsMap.put(orderProcessingProperties.getAmountLoanedKeyword(), Long.toString(amountloaned));

                productParamsMap.put(orderProcessingProperties.getCellphonenumberKeyword(), loggedInUser.getCellphonenumber());
                productParamsMap.put(orderProcessingProperties.getLenderPhoneKeyword(), phonenumber);
                DashboardEvent.RafikiLoanRequestcreatedEvent loanRequestEvent = new DashboardEvent.RafikiLoanRequestcreatedEvent(productParamsMap);
                PortalApplication.dashBoardEventBusService().post(loanRequestEvent);

                redirectAttributes.addFlashAttribute("message", "loan request successful");
                return new ModelAndView("redirect:/home");
            } catch (Exception e) {
                Logger.getLogger(LoanController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
                return new ModelAndView("loans/rafiki", "formErrors", result.getAllErrors());
            }
        }).orElse(new ModelAndView("loans/rafiki", "loans/rafiki", result.getAllErrors()));
    }

    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    @RequestMapping(value = "/loans/rafiki", method = RequestMethod.GET)
    public ModelAndView getLoanRequests(Principal principal) {
        Principals loggedInUser = principalService.findByLoginName(principal.getName());
        Collection<PrincipalsLoans> loanRequests = this.loansService.findLoanByLender(loggedInUser);
        final Map<String, Object> model = new HashMap<>();
        model.put("requests", loanRequests);

        return new ModelAndView("loans/approve", model);

    }

    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    @RequestMapping(value = "/loans/rafiki/deny/{id}", method = RequestMethod.GET)
    public ModelAndView denyLoanRequest(
            @PathVariable("id") final Long id,
            final RedirectAttributes redirectAttributes) {
        PrincipalsLoans denied = this.loansService.findLoanById(id);
        try {

            Map<String, String> productParamsMap = new HashMap<>();
            productParamsMap.put(orderProcessingProperties.getProductidKeyword(), "10");
            productParamsMap.put("amountdeclined", Long.toString(denied.getAmountloaned()));

            productParamsMap.put(orderProcessingProperties.getCellphonenumberKeyword(), denied.getLender().getCellphonenumber());
            productParamsMap.put("loaneephone", denied.getPrincipal().getCellphonenumber());
            productParamsMap.put(orderProcessingProperties.getLoanIdKeyword(), Long.toString(id));
            DashboardEvent.RafikiLoanDeniedEvent loanRequestEvent = new DashboardEvent.RafikiLoanDeniedEvent(productParamsMap);
            PortalApplication.dashBoardEventBusService().post(loanRequestEvent);

            redirectAttributes.addFlashAttribute("message", "loan request is being processed");
            return new ModelAndView("redirect:/loans");
        } catch (Exception e) {
            Logger.getLogger(LoanController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ModelAndView("redirect:/loans");
        }

    }

    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    @RequestMapping(value = "/loans/rafiki/approve/{id}", method = RequestMethod.GET)
    public ModelAndView approveForm(@PathVariable("id") final Long id) {
        PrincipalsLoans approvedLoan = this.loansService.findLoanById(id);
        Map<String, Object> model = new HashMap<>();
        model.put("approved", approvedLoan);
        return new ModelAndView("loans/approveForm", model);

    }

    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    @RequestMapping(value = "/loans/rafiki/approve", method = RequestMethod.POST)
    public ModelAndView approveLoan(PrincipalsLoans approvedloan,
            Principal principal,
            @RequestParam("amountapproved") final int amountapproved,
            @RequestParam("interest") final Boolean interest,
            final RedirectAttributes redirectAttributes,
            @RequestParam("id") final Long id) {
        PrincipalsLoans approved = this.loansService.findLoanById(id);
        try {

            Map<String, String> productParamsMap = new HashMap<>();
            productParamsMap.put(orderProcessingProperties.getProductidKeyword(), "9");
            productParamsMap.put(orderProcessingProperties.getAmountApprovedKeyword(), Long.toString(approved.getAmountloaned()));

            productParamsMap.put(orderProcessingProperties.getCellphonenumberKeyword(), approved.getLender().getCellphonenumber());
            productParamsMap.put("loaneephone", approved.getPrincipal().getCellphonenumber());
            productParamsMap.put(orderProcessingProperties.getLoanIdKeyword(), Long.toString(id));
            productParamsMap.put(orderProcessingProperties.getInterestKeyword(), Boolean.toString(interest));
            DashboardEvent.RafikiLoanApprovedEvent loanRequestEvent = new DashboardEvent.RafikiLoanApprovedEvent(productParamsMap);
            PortalApplication.dashBoardEventBusService().post(loanRequestEvent);

            redirectAttributes.addFlashAttribute("message", "loan approve successful");
            return new ModelAndView("redirect:/loans");
        } catch (Exception e) {
            Logger.getLogger(LoanController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ModelAndView("redirect:/loans");
        }

    }

}
