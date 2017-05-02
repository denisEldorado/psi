/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.controllers.api;

import org.muhia.app.psi.config.order.properties.OrderProcessingProperties;
import org.muhia.app.psi.orm.model.Principals;
import org.muhia.app.psi.orm.model.PrincipalsSavingsTarget;
import org.muhia.app.psi.orm.model.SavingsInterval;
import org.muhia.app.psi.orm.model.SavingsTargetType;
import org.muhia.app.psi.portal.PortalApplication;
import org.muhia.app.psi.portal.controllers.LoanController;
import org.muhia.app.psi.portal.eventbus.DashboardEvent;
import org.muhia.app.psi.portal.service.orm.IPrincipalsSavingsTargetsService;
import org.muhia.app.psi.portal.service.orm.IPrincipalsService;
import org.muhia.app.psi.portal.service.orm.ISavingsTargetIntervalService;
import org.muhia.app.psi.portal.service.orm.ISavingsTargetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SavingsTargetApiController {

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
    @RequestMapping(value = "/api/savings", method = RequestMethod.GET)
    public Map<String,List<Map<String, String>>> listSavingsTarget(Principal principal) {

        Principals loggedInUser = principalService.findByLoginName(principal.getName());
        Collection<PrincipalsSavingsTarget> savingsTarget = savingsTargetService.findByPrincipal(loggedInUser);
        List<Map<String, String>> mapList =new ArrayList<>() ;
        Map<String,List<Map<String, String>>> returnMap = new HashMap<>();
        savingsTarget.stream().map((target) -> {
            // do some work here on intValue
            Map<String, String> bens = new HashMap<>();
            bens.put("id", target.getId().toString());
            bens.put("amount", Long.toString(target.getAmount()));
            bens.put("target", Long.toString(target.getTarget()));
            bens.put("status", Long.toString(target.getStatus()));
            bens.put("interval", target.getInterval().getInterval());
            bens.put("type", target.getType().getType());

            return bens;
        }).forEach((bens) -> {
            mapList.add(bens);
        });
         returnMap.put("savingsTarget", mapList);
         return returnMap;
       
    }

    @RequestMapping(value = "/api/savings/create", method = RequestMethod.GET)
    public Map<String, List<Map<String, String>>> createForm() {
        Collection<SavingsInterval> intervals = savingsTargetIntervalService.listAllIntervals();
        Collection<SavingsTargetType> types = savingsTargetTypeService.listTargetTypes();

        Map<String, List<Map<String, String>>> returnMap = new HashMap<>();

        List<Map<String, String>> intervalList = new ArrayList<>();
        List<Map<String, String>> typesList = new ArrayList<>();
        intervals.stream().map((interval) -> {
            Map<String, String> intMap = new HashMap<>();
            intMap.put("id", interval.getId().toString());
            intMap.put("interval", interval.getInterval());
            return intMap;
        }).forEach((intMap) -> {
            intervalList.add(intMap);
        });
        types.stream().map((type) -> {
            Map<String, String> intMap = new HashMap<>();
            intMap.put("id", type.getId().toString());
            intMap.put("type", type.getType());
            return intMap;
        }).forEach((intMap) -> {
            typesList.add(intMap);
        });
        returnMap.put("types", typesList);
        returnMap.put("intervals", intervalList);
        return returnMap;

    }

    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    @RequestMapping(value = "/api/savings", method = RequestMethod.POST)
    public String createSavingsTarget(PrincipalsSavingsTarget target, Principal principal,
            @RequestParam("type") final Long type,
            @RequestParam("amount") final int amount,
            @RequestParam("target") final int targetSaving,
            @RequestParam("interval") final Long interval,
            final RedirectAttributes redirectAttributes, BindingResult result) {
        if (result.hasErrors()) {
            if (!(result.getFieldError("id") != null && result.getErrorCount() == 1)) {
                return "false";
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

                redirectAttributes.addFlashAttribute("message", "target successfully created successful");
                return "true";
            } catch (Exception e) {
                Logger.getLogger(LoanController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
                return "false";
            }
        }).orElse("false");

    }

    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    @RequestMapping(value = "/api/savings/{id}", method = RequestMethod.GET)
    public Map<String,List<Map<String, String>>> getSavingsTarget(@PathVariable("id") final Long id) {
        PrincipalsSavingsTarget target = savingsTargetService.findById(id);
        List<Map<String, String>> mapList = new ArrayList<>();

        Map<String,List<Map<String, String>>> returnMap = new HashMap<>();

        Map<String, String> savingMap = new HashMap<>();
        savingMap.put("id", target.getId().toString());
        savingMap.put("amount", Long.toString(target.getAmount()));
        savingMap.put("target", Long.toString(target.getTarget()));
        savingMap.put("status", Long.toString(target.getStatus()));
        savingMap.put("interval", target.getInterval().getInterval());
        savingMap.put("type", target.getType().getType());

        mapList.add(savingMap);
        returnMap.put("savingTarget", mapList);
        return returnMap;
    }

    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    @RequestMapping(value = "/api/savings/deactivate/{id}")
    public String deactivateSavingsTarget(Principal principal,@PathVariable("id") Long id) {

        Principals loggedInUser = principalService.findByLoginName(principal.getName());

        HashMap<String, String> productParamMap = new HashMap<>();
        productParamMap.put(orderProcessingProperties.getProductidKeyword(),"11");
        productParamMap.put(orderProcessingProperties.getTargetIdKeyword(),id.toString());
        productParamMap.put(orderProcessingProperties.getCellphonenumberKeyword(),loggedInUser.getCellphonenumber().toString());
        DashboardEvent.savingsTargetDeactivateEvent deactivateEvent = new DashboardEvent.savingsTargetDeactivateEvent(productParamMap);
        PortalApplication.dashBoardEventBusService().post(deactivateEvent);

        return "true";
    }



}
