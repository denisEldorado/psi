/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.controllers.api;

import org.muhia.app.psi.portal.PortalApplication;
import org.muhia.app.psi.portal.controllers.BeneficiaryController;
import org.muhia.app.psi.portal.eventbus.DashboardEvent;
import org.muhia.app.psi.portal.service.orm.IBeneficiaryTypesService;
import org.muhia.app.psi.portal.service.orm.IPrincipalsService;
import org.muhia.app.psi.portal.service.orm.IUserBeneficiariesService;
import org.muhia.app.psi.orm.model.BeneficiaryTypes;
import org.muhia.app.psi.orm.model.Principals;
import org.muhia.app.psi.orm.model.UserBeneficiaries;
import org.muhia.app.psi.orm.repo.PrincipalsRepository;
import org.muhia.app.psi.orm.repo.UserBeneficiariesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ngatia
 */
@RestController
public class BeneficiaryApiController {

    @Autowired
    UserBeneficiariesRepository userBeneficiariesRepository;

    @Autowired
    PrincipalsRepository principalsRepository;

    @Autowired
    IUserBeneficiariesService userBeneficiariesService;

    @Autowired
    IPrincipalsService principalsService;

    @Autowired
    IBeneficiaryTypesService beneficiaryTypesService;


    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    @RequestMapping(
            value = "/api/beneficiary",
            method = RequestMethod.GET
    )
    public Map<String, List<Map<String, String>>> getBeneficiaries(Principal principal) {
        Principals principals = principalsService.findByLoginName(principal.getName());
        Collection<UserBeneficiaries> userBeneficiaries = userBeneficiariesService.findByPrincipalsAndStatus(principals, "1");
        List<Map<String, String>> mapList = new ArrayList<>();
        userBeneficiaries.stream().map((userben) -> {
            // do some work here on intValue
            Map<String, String> bens = new HashMap<>();
            bens.put("id", Long.toString(userben.getId()));
            bens.put("beneficiary", userben.getBeneficiary());
            bens.put("beneficiaryPhone", userben.getBeneficiaryTelephone());
            bens.put("beneficaryEmail", userben.getBeneficiaryEmail());
            bens.put("beneficaryIdNumber", userben.getBeneficiaryIdNumber());
            bens.put("beneficaryPercentage", Long.toString(userben.getBeneficiaryPercentage()));
            bens.put("relationship", userben.getRelationship().getTypename());
            return bens;
        }).forEach(mapList::add);
        Map<String, List<Map<String, String>>> returnMap = new HashMap<>();
        returnMap.put("beneficiaries", mapList);
        return returnMap;
    }

    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    @RequestMapping(
            value = "/api/beneficiary",
            method = RequestMethod.POST
    )
    public String saveUserBeneficiary(
            Principal principal,
            @RequestParam String beneficiary,
            @RequestParam String beneficiaryIdNumber,
            @RequestParam String beneficiaryEmail,
            @RequestParam String beneficiaryTelephone,
            @RequestParam int beneficiaryPercentage,
            @RequestParam Long relationship) {

        UserBeneficiaries userBeneficiaries = new UserBeneficiaries();
        userBeneficiaries.setBeneficiary(beneficiary);
        userBeneficiaries.setBeneficiaryIdNumber(beneficiaryIdNumber);
        userBeneficiaries.setBeneficiaryTelephone(beneficiaryTelephone);
        userBeneficiaries.setBeneficiaryPercentage(new Long(beneficiaryPercentage));
        userBeneficiaries.setBeneficiaryEmail(beneficiaryEmail);
        userBeneficiaries.setRelationship(beneficiaryTypesService.findBeneficiaryTypesById(relationship));
        try {
            Principals principals = principalsService.findByLoginName(principal.getName());
            DashboardEvent.RegisterBeneficiaryEvent registerBeneficiaryEvent = new DashboardEvent.RegisterBeneficiaryEvent(userBeneficiaries, principals);
            PortalApplication.dashBoardEventBusService().post(registerBeneficiaryEvent);
            return "true";
        } catch (Exception e) {
            Logger.getLogger(BeneficiaryController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return "false";
        }

    }

    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    @RequestMapping(
            value = "/api/beneficiary/{id}",
            method = RequestMethod.POST
    )
    public String updateBeneficiary(@PathVariable("id") Long id,
                                    Principal principal,
                                    @RequestParam String beneficiary,
                                    @RequestParam String beneficiaryIdNumber,
                                    @RequestParam String beneficiaryEmail,
                                    @RequestParam String beneficiaryTelephone,
                                    @RequestParam int beneficiaryPercentage,
                                    @RequestParam Long relationship) {

        UserBeneficiaries userBeneficiaries = new UserBeneficiaries();
        userBeneficiaries.setBeneficiary(beneficiary);
        userBeneficiaries.setBeneficiaryIdNumber(beneficiaryIdNumber);
        userBeneficiaries.setBeneficiaryTelephone(beneficiaryTelephone);
        userBeneficiaries.setBeneficiaryPercentage(new Long(beneficiaryPercentage));
        userBeneficiaries.setBeneficiaryEmail(beneficiaryEmail);
        userBeneficiaries.setId(id);
        userBeneficiaries.setRelationship(beneficiaryTypesService.findBeneficiaryTypesById(relationship));
        try {
            Principals principals = principalsRepository.findByLoginName(principal.getName());
            DashboardEvent.EditBeneficiaryEvent editBeneficiaryEvent = new DashboardEvent.EditBeneficiaryEvent(userBeneficiaries, id, principals);
            PortalApplication.dashBoardEventBusService().post(editBeneficiaryEvent);
            return "true";
        } catch (Exception e) {
            Logger.getLogger(BeneficiaryController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return "false";
        }
    }

    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    @RequestMapping(
            value = "/api/beneficiary/delete/{id}"
    )
    public ResponseEntity<UserBeneficiaries> deleteBeneficiary(@PathVariable("id") Long id, Principal principal) {
        try {
            Principals principals = principalsRepository.findByLoginName(principal.getName());
            DashboardEvent.DeleteBeneficiaryEvent deleteBeneficiaryEvent = new DashboardEvent.DeleteBeneficiaryEvent(id, principals);
            PortalApplication.dashBoardEventBusService().post(deleteBeneficiaryEvent);
        } catch (Exception e) {
            Logger.getLogger(BeneficiaryController.class.getName()).log(Level.SEVERE, e.getMessage(), e);

        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    @RequestMapping(
            value = "/api/beneficiary/{id}",
            method = RequestMethod.GET
    )

    public ResponseEntity<Map<String, String>> getBeneficiary(@PathVariable Long id) {
        UserBeneficiaries userBeneficiaries = userBeneficiariesRepository.findOne(id);
        Map<String, String> beneficiaryMap = new HashMap<>();
        beneficiaryMap.put("name", userBeneficiaries.getBeneficiary());
        beneficiaryMap.put("idNumber", userBeneficiaries.getBeneficiaryIdNumber());
        beneficiaryMap.put("phone", userBeneficiaries.getBeneficiaryTelephone());
        beneficiaryMap.put("email", userBeneficiaries.getBeneficiaryEmail());
        beneficiaryMap.put("percentage", Long.toString(userBeneficiaries.getBeneficiaryPercentage()));
        beneficiaryMap.put("relationship", userBeneficiaries.getRelationship().getTypename());
        beneficiaryMap.put("relationshipId", Long.toString(userBeneficiaries.getRelationship().getId()));
        return new ResponseEntity<>(beneficiaryMap, HttpStatus.OK);
    }


    @PreAuthorize("hasAnyRole('USSD_USER','UI_USER')")
    @RequestMapping(
            value = "/api/beneficiarytypes",
            method = RequestMethod.GET
    )
    public List<Map<String, String>> getBeneficiaryTypes() {
        Collection<BeneficiaryTypes> beneficiaryTypes = beneficiaryTypesService.listBeneficiaryTypesByStatus(1);
        List<Map<String, String>> mapList = new ArrayList<>();
        beneficiaryTypes.stream().map((benType) -> {
            Map<String, String> types = new HashMap<>();
            types.put("relationshipId", Long.toString(benType.getId()));
            types.put("relationship", benType.getTypename());
            return types;
        }).forEach(mapList::add);
        return mapList;
    }
}
