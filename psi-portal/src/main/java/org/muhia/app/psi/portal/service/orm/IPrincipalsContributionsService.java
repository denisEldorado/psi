/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.service.orm;

import org.muhia.app.psi.orm.model.Principals;
import org.muhia.app.psi.orm.model.PrincipalsContributions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;

/**
 *
 * @author mathenge
 */
public interface IPrincipalsContributionsService {
    
    Collection<PrincipalsContributions> listContributions ();
    Collection<PrincipalsContributions> listContributionsByPrincipal (Principals principal);
    PrincipalsContributions  findContributionById(Long id);
    PrincipalsContributions  savePrincipalContribution(PrincipalsContributions contribution);
    PrincipalsContributions  updatePrincipalContribution(PrincipalsContributions contribution);
    void deletePrincipalContribution (Long id);
    
    Long totalPrincipalContribution(Principals principal);
    double getMaxLimit(Principals principal);

    Page<PrincipalsContributions> findAllPaged(Pageable pageable);
    Collection<PrincipalsContributions> listContributionsByPrincipalAndStatus (Principals principal,int status);

    
}
