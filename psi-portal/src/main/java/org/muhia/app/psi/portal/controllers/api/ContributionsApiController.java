/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.controllers.api;

import org.muhia.app.psi.portal.service.orm.IPrincipalsContributionsService;
import org.muhia.app.psi.portal.service.orm.IPrincipalsService;
import org.muhia.app.psi.orm.model.Principals;
import org.muhia.app.psi.orm.model.PrincipalsContributions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.*;

/**
 *
 * @author mathenge
 */
@RestController
public class ContributionsApiController {
    @Autowired
    IPrincipalsContributionsService contributionService;
    
    @Autowired
    IPrincipalsService principalsService;
    
    @PreAuthorize("hasAnyRole('UI_USER','USSD_USER')")
    @RequestMapping(value="/api/contributions", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
     Map<String,List<Map<String,String>>>  listPrincipalContributions(Principal principal){
        Principals loggedInUser = principalsService.findByLoginName(principal.getName());
        final Collection<PrincipalsContributions> contributecollection = this.contributionService.listContributionsByPrincipal(loggedInUser);
        //calculating amount you can borrow
         Map<String,String> map=new HashMap<>();
        int total = 0;
        for (PrincipalsContributions amount : contributecollection) {
            total =total+amount.getAmount().intValue();
        }

        Map<String,List<Map<String,String>>> returnMap = new HashMap<>();
        List<Map<String,String>> mapList = new ArrayList<>();
        List<Map<String,String>> contList = new ArrayList<>();

        contributecollection.stream().map((collection) -> {
            // do some work here on intValue
            Map<String,String> cons=new HashMap<>();
            cons.put("amount",Long.toString(collection.getAmount()));
            cons.put("contributedon",collection.getContributedon().toString());
            cons.put("contributionmethod",collection.getContributionMethod().getMethodname());
            
            
            return cons;
        }).forEach((cons) -> {
            mapList.add(cons);
        });
        map.put("total",Integer.toString(total));
        contList.add(map);
        returnMap.put("total", contList);
        returnMap.put("contributions", mapList);
        return returnMap;
        
    }
}
