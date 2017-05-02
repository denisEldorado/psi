/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.service.orm.impl;

import org.muhia.app.psi.portal.service.orm.IMaxLimitService;
import org.muhia.app.psi.portal.service.orm.IPrincipalsContributionsService;
import org.muhia.app.psi.orm.model.Principals;
import org.muhia.app.psi.orm.model.PrincipalsContributions;
import org.muhia.app.psi.orm.repo.PrincipalsContributionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author mathenge
 */
@Service
public class PrincipalsContributionsService implements IPrincipalsContributionsService {
    
    @Autowired
    PrincipalsContributionsRepository contributionRepo;
    @Autowired
    private IMaxLimitService maxlimitService;

    @Override
    public Collection<PrincipalsContributions> listContributions() {
        return contributionRepo.findAll();
    }

    @Override
    public Collection<PrincipalsContributions> listContributionsByPrincipal(Principals principal) {
        return contributionRepo.findPrincipalsContributionsByPrincipal(principal);
    }

    @Override
    public PrincipalsContributions findContributionById(Long id) {
        return contributionRepo.findOne(id);
    }

    @Override
    public PrincipalsContributions savePrincipalContribution(PrincipalsContributions contribution) {
        return contributionRepo.save(contribution);
    }

    @Override
    public PrincipalsContributions updatePrincipalContribution(PrincipalsContributions contribution) {
        return contributionRepo.save(contribution);
    }

    @Override
    public void deletePrincipalContribution(Long id) {
        contributionRepo.delete(id);
    }

    @Override
    public Long totalPrincipalContribution(Principals principal) {
//        return contributionRepo.totalPrincipalContributionsByPrincipal(principal);
    return null;
    }

    @Override
    public double getMaxLimit(Principals principal) {
        final Collection<PrincipalsContributions> contributecollection = contributionRepo.findPrincipalsContributionsByPrincipal(principal);
        //calculating amount you can borrow

        AtomicLong total = new AtomicLong(0);
        contributecollection.forEach((amount)
                -> total.addAndGet(amount.getAmount()));
        return maxlimitService.getActiveLimit(1).getMaxlimit() * total.get();
    }


    @Override
    public Page<PrincipalsContributions> findAllPaged(Pageable pageable) {
        return contributionRepo.findAllPaged(pageable);
    }

    @Override
    public Collection<PrincipalsContributions> listContributionsByPrincipalAndStatus(Principals principal, int status) {
        return contributionRepo.findPrincipalsContributionsByPrincipalAndStatus(principal,status);
    }
}
