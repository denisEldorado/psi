
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.controllers.api;

import org.muhia.app.psi.config.order.properties.OrderProcessingProperties;
import org.muhia.app.psi.orm.model.Principals;
import org.muhia.app.psi.orm.model.PrincipalsLoans;
import org.muhia.app.psi.portal.PortalApplication;
import org.muhia.app.psi.portal.controllers.LoanController;
import org.muhia.app.psi.portal.eventbus.DashboardEvent;
import org.muhia.app.psi.portal.service.orm.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
public class LoanApiController {

    private final IPrincipalsLoansService loansService;
    private final IPrincipalsService principalsService;
    private final IPrincipalsContributionsService contributionService;
    private final IInterestRateService interestRateService;
    private final IPaybackPeriodService paybackService;
    private final IPrincipalsService principalService;

    private final OrderProcessingProperties orderProcessingProperties;

    @Autowired
    public LoanApiController(IPrincipalsLoansService loansService, IPrincipalsService principalsService, IPrincipalsContributionsService contributionService, IInterestRateService interestRateService, IPaybackPeriodService paybackService, IPrincipalsService principalService, OrderProcessingProperties orderProcessingProperties) {
        this.loansService = loansService;
        this.principalsService = principalsService;
        this.contributionService = contributionService;
        this.interestRateService = interestRateService;
        this.paybackService = paybackService;
        this.principalService = principalService;
        this.orderProcessingProperties = orderProcessingProperties;
    }


    //list all loans for a principal
    @PreAuthorize("hasAnyRole('UI_USER','USSD_USER')")
    @RequestMapping(value = "/api/loans", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, List<Map<String, String>>> listLoans(Principal principal) {

        Principals loggedInUser = principalsService.findByLoginName(principal.getName());
        final Collection<PrincipalsLoans> loans = this.loansService.findLoanByPrincipal(loggedInUser);
        loans.stream().filter((loan) -> (loan.getLoanedapprovedon() != null)).forEachOrdered((loan) -> {
            Date deadline = loansService.addPayBackDays(loan.getLoanedapprovedon(), paybackService.findActivePayBackPeriod().getPaybackperiod().intValue());
            loan.setLoanedapprovedon(deadline);
        });

        List<Map<String, String>> mapList = new ArrayList<>();
        Map<String, List<Map<String, String>>> returnMap = new HashMap<>();
        loans.stream().map((l) -> {
            Map<String, String> lMap = new HashMap<>();

            lMap.put("id", l.getId().toString());
            lMap.put("createdon", l.getCreatedon().toString());
            lMap.put("amountloaned", l.getAmountloaned() == null ? "null" : l.getAmountloaned().toString());
            lMap.put("paybackamount", l.getPaybackamount() == null ? "null" : l.getPaybackamount().toString());
            lMap.put("approveddeclinedon", l.getLoanedapprovedon() == null ? "null" : l.getLoanedapprovedon().toString());
            lMap.put("lender", l.getLender() == null ? "null" : l.getLender().getFullname());
            lMap.put("status", Integer.toString(l.getStatus()));

            return lMap;
        }).forEach(mapList::add);
        returnMap.put("loans", mapList);
        return returnMap;

    }

    @PreAuthorize("hasAnyRole('UI_USER','USSD_USER')")
    //create form to borrow loan
    @RequestMapping(value = "/api/loans/borrow", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Map<String, String>> getCreateForm(Principal principal, @ModelAttribute PrincipalsLoans loan) {

        Principals loggedInUser = principalsService.findByLoginName(principal.getName());
        final Collection<PrincipalsLoans> loans = this.loansService.findLoanByPrincipal(loggedInUser);

        final Map<String, String> model = new HashMap<>();


        double maxlimit = contributionService.getMaxLimit(loggedInUser);

        model.put("maxlimit", Double.toString(maxlimit));

        return new ResponseEntity<>(model, HttpStatus.OK);

    }

    @PreAuthorize("hasAnyRole('UI_USER','USSD_USER')")
    //posting a loan request 
    @RequestMapping(value = "/api/loans/borrow", method = RequestMethod.POST)
    public String processLoanRequest(PrincipalsLoans loan, @RequestParam("amountloaned") final long amountloaned, BindingResult result, Principal principal,
            final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            if (!(result.getFieldError("id") != null && result.getErrorCount() == 1)) {

                return "false";
            }
        }

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
                return  "You have not paid your previous loan";

            }
            Map<String, String> productParamsMap = new HashMap<>();
            productParamsMap.put(orderProcessingProperties.getProductidKeyword(), "4");
            productParamsMap.put(orderProcessingProperties.getAmountLoanedKeyword(), Long.toString(amountloaned));
            productParamsMap.put("loginname", principal.getName());
            productParamsMap.put(orderProcessingProperties.getCellphonenumberKeyword(), loggedInUser.getCellphonenumber());

            DashboardEvent.LoanRequestedCompletedEvent loanRequestEvent = new DashboardEvent.LoanRequestedCompletedEvent(productParamsMap);
            PortalApplication.dashBoardEventBusService().post(loanRequestEvent);

            redirectAttributes.addFlashAttribute("message", "loan request successful");
            return "true";
        } catch (Exception e) {
            Logger.getLogger(LoanController.class.getName()).log(Level.SEVERE, e.getMessage(), e);

            return "false";
        }

    }

    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")

    @RequestMapping(value = "/api/loans/rafiki", method = RequestMethod.GET)
    public Map<String, List<Map<String, String>>> getLoanRequests(Principal principal) {
        Principals loggedInUser = principalService.findByLoginName(principal.getName());
        Collection<PrincipalsLoans> loanRequests = this.loansService.findLoanByLender(loggedInUser);
//        final Map<String, Object> model = new HashMap<>();
        List<Map<String, String>> mapList = new ArrayList<>();
        Map<String, List<Map<String, String>>> returnMap = new HashMap<>();
        loanRequests.stream().map((l) -> {
            Map<String, String> loanMap = new HashMap<>();
            loanMap.put("id", l.getId().toString());
            loanMap.put("amountloaned", l.getAmountloaned().toString());
            loanMap.put("created_at", l.getCreatedon().toString());
            loanMap.put("loanee", l.getPrincipal().getFullname());
            loanMap.put("phone", l.getPrincipal().getCellphonenumber());
            return loanMap;

        }).forEach(mapList::add);
        returnMap.put("requests", mapList);
        return returnMap;

    }

    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    @RequestMapping(value = "/api/loans/rafiki/request", method = RequestMethod.POST)
    public String processLoanRequestFromRafiki(PrincipalsLoans loan,
            @RequestParam("amountloaned") final long amountloaned,
            @RequestParam("phonenumber") final String phonenumber,
            BindingResult result, Principal principal,
            final RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            if (!(result.getFieldError("id") != null && result.getErrorCount() == 1)) {
                return "false";
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
                return "true";
            } catch (Exception e) {
                Logger.getLogger(LoanController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
                return "false";
            }
        }).orElse("false");
    }

    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    @RequestMapping(value = "/api/loans/rafiki/deny/{id}", method = RequestMethod.GET)
    public String denyLoanRequest(
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

            redirectAttributes.addFlashAttribute("message", "loan request successful");
            return "true";
        } catch (Exception e) {
            Logger.getLogger(LoanController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return "false";
        }

    }

    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    @RequestMapping(value = "/api/loans/rafiki/approve/{id}", method = RequestMethod.GET)
    public Map<String, String> approveForm(@PathVariable("id") final Long id) {
        PrincipalsLoans approvedLoan = this.loansService.findLoanById(id);
        Map<String, String> model = new HashMap<>();

        model.put("id", approvedLoan.getId().toString());
        model.put("amountloaned", approvedLoan.getAmountloaned().toString());

        return model;

    }

    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    @RequestMapping(value = "/api/loans/rafiki/approve", method = RequestMethod.POST)
    public String approveLoan(PrincipalsLoans approvedloan,
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
            return "true";
        } catch (Exception e) {
            Logger.getLogger(LoanController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return "false";
        }

    }

}
