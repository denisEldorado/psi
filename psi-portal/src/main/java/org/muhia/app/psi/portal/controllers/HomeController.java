package org.muhia.app.psi.portal.controllers;

import org.muhia.app.psi.portal.service.orm.*;
import org.muhia.app.psi.orm.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * Created by mathenge on 1/13/17.
 */
@RestController

public class HomeController {
    @Autowired
    private IPrincipalsLoansService loansService;

    @Autowired
    private IPrincipalsService principalsService;

    @Autowired
    private ISavingsTargetTypeService savingsTargetTypeService;
    @Autowired
    private IPrincipalsSavingsTargetsService savingsTargetService;

    @Autowired
    private IPrincipalsGuarantorService guarantorService;

    @Autowired
    private IPrincipalsContributionsService contributionService;



    @PreAuthorize("hasAnyRole('UI_USER','USSD_USER')")
    @RequestMapping(value = "/home")
    public ModelAndView homeDashboard (Principal principal){

        Principals loggedInUser = principalsService.findByLoginName(principal.getName());

        Map<String,Object> model = new HashMap<>();
        Collection<PrincipalsLoans> loans = loansService.findLoanByPrincipal(loggedInUser).stream().limit(3).collect(Collectors.toSet());
        Collection<PrincipalsSavingsTarget> savingsTarget = savingsTargetService.findByPrincipal(loggedInUser).stream().limit(3).collect(Collectors.toSet());
        Collection<PrincipalsGuarantor> guarantors = guarantorService.findPrincipalGuarantorsByPrincipal(loggedInUser).stream().limit(3).collect(Collectors.toSet());
        Collection<PrincipalsContributions> contributecollection = contributionService.listContributionsByPrincipal(loggedInUser);
        AtomicLong total = new AtomicLong(0);
        contributecollection.forEach((amount)
                -> total.addAndGet(amount.getAmount()));

        model.put("loans",loans);
        model.put("savingsTargets",savingsTarget);
        model.put("total",total);
        model.put("guarantors",guarantors);
        model.put("contributions",contributecollection);


        return new ModelAndView("home",model);

    }
}
