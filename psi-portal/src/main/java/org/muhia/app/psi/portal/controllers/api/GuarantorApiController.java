
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.controllers.api;

import org.muhia.app.psi.portal.PortalApplication;
import org.muhia.app.psi.portal.controllers.GuarantorController;
import org.muhia.app.psi.portal.eventbus.DashboardEvent;
import org.muhia.app.psi.portal.service.AsyncBean;
import org.muhia.app.psi.portal.service.orm.*;
import org.muhia.app.psi.config.order.properties.OrderProcessingProperties;
import org.muhia.app.psi.orm.model.Principals;
import org.muhia.app.psi.orm.model.PrincipalsGuarantor;
import org.muhia.app.psi.orm.model.PrincipalsLoans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author mathenge
 */
@RestController
public class GuarantorApiController {

    private final IPrincipalsGuarantorService guarantorService;

    private final IPrincipalsService principalsService;

    private final AsyncBean asyncBean;

    private final IPrincipalsContributionsService contributionService;

    private final IPrincipalsLoansService loansService;


    private final OrderProcessingProperties orderProcessingProperties;

    @Autowired
    public GuarantorApiController(IPrincipalsGuarantorService guarantorService, IPrincipalsService principalsService, AsyncBean asyncBean, IPrincipalsContributionsService contributionService, IPrincipalsLoansService loansService, OrderProcessingProperties orderProcessingProperties) {
        this.guarantorService = guarantorService;
        this.principalsService = principalsService;
        this.asyncBean = asyncBean;
        this.contributionService = contributionService;
        this.loansService = loansService;
        this.orderProcessingProperties = orderProcessingProperties;
    }


    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    @RequestMapping(value = "/api/guarantors", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, List<Map<String, String>>> list(HttpServletRequest request) {

        Principal principal = request.getUserPrincipal();
        Principals loggedInUser = principalsService.findByLoginName(principal.getName());
        Collection<PrincipalsGuarantor> guarantors = guarantorService.findPrincipalGuarantorsByPrincipal(loggedInUser);
        List<Map<String, String>> mapList = new ArrayList<>();
        Map<String, List<Map<String, String>>> returnMap = new HashMap<>();
        guarantors.stream().map((g) -> {
            Map<String, String> gMap = new HashMap<>();
            gMap.put("id", g.getId().toString());
            gMap.put("amountrequested", Integer.toString(g.getAmmountrequested()));
            gMap.put("amountguaranteed", Integer.toString(g.getAmmountguaranteed()));
            gMap.put("approveddeclinedon", g.getApproveddeclinedon() == null ? "null" : g.getApproveddeclinedon().toString());
            gMap.put("guarantor", g.getGuarantor().getFullname());
            gMap.put("guarantorphone", g.getGuarantor().getCellphonenumber());
            gMap.put("status", Integer.toString(g.getStatus()));

            return gMap;
        }).forEach(mapList::add);
        returnMap.put("guarantors", mapList);
        return returnMap;
    }

    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    @RequestMapping(value = "/api/guarantors", method = RequestMethod.POST)
    public String create(PrincipalsGuarantor guarantor, @RequestParam("phonenumber") String phonenumber, @RequestParam("amountrequested") final int amountrequested,
                         final BindingResult result,
                         final RedirectAttributes redirect, Principal principal, @RequestParam("loanid") final Long loanid) {
//        if(result.hasErrors()){
//            Logger.getLogger(GuarantorController.class.getName()).info(String.format("Do you hav errors?"));
//            return new ModelAndView("pg/request", "formErrors", result.getAllErrors());
//        }
        PrincipalsLoans loan = loansService.findLoanById(loanid);
//        if (guarantors == null) {
//            // no user with that email found
//            redirect.addFlashAttribute("globalMessage", "No user found");
//            //return new ModelAndView("redirect:/guarantors/request/{id}", "id", loan);
//        }
        Principals loggedInUser = principalsService.findByLoginName(principal.getName());

        //check whether guarantor  request already  sent
//        Optional<PrincipalsGuarantor> previousrequest = guarantorService.findGuarantorRequestPerLoan(loggedInUser, loan, guarantors);
//        if (previousrequest.isPresent()) {
//            redirect.addFlashAttribute("globalMessage", "Request to member already sent");
//            //return new ModelAndView("redirect:/guarantors/request/{id}", "id", loan);
//
//        }
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
                return "false";
            }
        } catch (Exception e) {
            Logger.getLogger(GuarantorController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            //redirectAttributes.addFlashAttribute("Error", "An error occurred while processing you registration");
            //return new ModelAndView("pg/request", "formErrors", result.getAllErrors());
        }
        redirect.addFlashAttribute("globalMessage", "Successfully requested a new guarantor");
        return "true";
        //return new ModelAndView("redirect:/guarantors");

    }

    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    @RequestMapping(value = "/api/guarantors/request/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, List<Map<String, String>>> createForm(@PathVariable("id") final Long id, Principal principal) {
        PrincipalsLoans loan = loansService.findLoanById(id);
        Principals loggedInUser = principalsService.findByLoginName(principal.getName());
        double maxlimit = contributionService.getMaxLimit(loggedInUser);
        final Collection<PrincipalsGuarantor> guarantors = guarantorService.findPrincipalGuarantorByloan(loggedInUser, loan);
        final Collection<PrincipalsGuarantor> users = guarantorService.findPrincipalGuarantorsByPrincipal(loggedInUser);
        final Map<String, String> model = new HashMap<>();
        final Map<String, String> remMap = new HashMap<>();
        double remaining;
        if (guarantors.isEmpty()) {
            remaining = loan.getAmountloaned() - maxlimit;
        } else {
            AtomicLong total = new AtomicLong(0);
            guarantors.forEach(amount -> {
                total.addAndGet(amount.getAmmountrequested());
            });
            remaining = loan.getAmountloaned() - (maxlimit + total.get());
//            if (remaining <= 0) {
//                //return new ModelAndView("redirect:/guarantors");
//            }
        }
        Map<String, List<Map<String, String>>> returnMap = new HashMap<>();
        List<Map<String, String>> loanMap = new ArrayList<>();
        List<Map<String, String>> userMap = new ArrayList<>();
        List<Map<String, String>> remainingMap = new ArrayList<>();
        model.put("loanid", loan.getId().toString());
        loanMap.add(model);
        remMap.put("remaining", Double.toString(remaining));
        remainingMap.add(remMap);
        users.stream().map((u) -> {
            Map<String, String> uMap = new HashMap<>();
            uMap.put("name", u.getGuarantor().getFullname());
            uMap.put("phone", u.getGuarantor().getCellphonenumber());
            return uMap;
        }).forEach(userMap::add);
        returnMap.put("loan", loanMap);
        returnMap.put("guarantors", userMap);
        returnMap.put("remaining", remainingMap);

        return returnMap;

    }

    //function to load guarantor requests
    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    @RequestMapping(value = "/api/guarantors/approve", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, List<Map<String, String>>> listRequests(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        Principals loggedInUser = principalsService.findByLoginName(principal.getName());
        Collection<PrincipalsGuarantor> guarantees = guarantorService.listGuaranteeRequest(loggedInUser);
        List<Map<String, String>> returnList = new ArrayList<>();
        Map<String, List<Map<String, String>>> returnMap = new HashMap<>();
        guarantees.stream().map((g) -> {
            Map<String, String> gMap = new HashMap<>();
            gMap.put("id", g.getId().toString());
            gMap.put("guaranteename", g.getPrincipal().getFullname());
            gMap.put("guaranteephone", g.getPrincipal().getCellphonenumber());
            gMap.put("amountrequested", Integer.toString(g.getAmmountrequested()));
            gMap.put("amountguaranteed", Integer.toString(g.getAmmountguaranteed()));
            gMap.put("status", Integer.toString(g.getStatus()));
            return gMap;
        }).forEach(returnList::add);
        returnMap.put("guarantees", returnList);
        return returnMap;
    }

    //Decline a guarantee request 
    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    @RequestMapping(value = "/api/guarantors/request/decline/{id}", method = RequestMethod.GET)
    public String decline(@PathVariable("id") final Long id) {
        PrincipalsGuarantor request = guarantorService.findPrincipalGuarantorsById(id);
        request.setStatus(3);
        DashboardEvent.GuarantorDeclineCompletedEvent declineEvent = new DashboardEvent.GuarantorDeclineCompletedEvent(request);
        PortalApplication.dashBoardEventBusService().post(declineEvent);
        return "true";

    }

    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    @RequestMapping(value = "/api/guarantors/request/approve/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String approve(@PathVariable("id") final Long id) {
        PrincipalsGuarantor request = guarantorService.findPrincipalGuarantorsById(id);
        request.setStatus(4);
        request.setAmmountguaranteed(request.getAmmountrequested());
        request.setApproveddeclinedon(new Date());
        //guarantorService.savePrincipalGuarantors(request);
        if (guarantorService.isGuaranteedAmountEnough(request)) {
            request.getLoan().setLoanedapprovedon(new Date());
        }
        DashboardEvent.GuarantorApproveCompletedEvent approveEvent = new DashboardEvent.GuarantorApproveCompletedEvent(request);
        PortalApplication.dashBoardEventBusService().post(approveEvent);
        return "true";

    }

    //When someone guarantees you for less
    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    @RequestMapping(value = "/api/guarantors/partial/approve/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> approveLess(@PathVariable("id") final Long id) {
        PrincipalsGuarantor guarantee = guarantorService.findPrincipalGuarantorsById(id);

        Map<String, String> gMap = new HashMap<>();
        gMap.put("amountrequested", Integer.toString(guarantee.getAmmountrequested()));
        gMap.put("id", guarantee.getId().toString());
        return gMap;

    }

    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    @RequestMapping(value = "/api/guarantors/approve/partial/{id}", method = RequestMethod.POST)
    public String approveLess(@PathVariable("id") final Long id, @RequestParam("amountguaranteed") final int amountguaranteed) {
        PrincipalsGuarantor request = guarantorService.findPrincipalGuarantorsById(id);
        request.setStatus(4);
        request.setAmmountguaranteed(amountguaranteed);
        request.setApproveddeclinedon(new Date());
        //PrincipalsGuarantor partial=guarantorService.savePrincipalGuarantors(request);
        Logger.getLogger(GuarantorController.class.getName()).info(String.format("Amount = %S", request.getAmmountguaranteed()));
        DashboardEvent.GuarantorApproveCompletedEvent approveEvent = new DashboardEvent.GuarantorApproveCompletedEvent(request);
        PortalApplication.dashBoardEventBusService().post(approveEvent);
        return "true";

    }

}
