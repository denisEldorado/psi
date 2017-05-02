
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.service.orm.impl;

import org.muhia.app.psi.portal.service.orm.IPrincipalsContributionsService;
import org.muhia.app.psi.portal.service.orm.IPrincipalsGuarantorService;
import org.muhia.app.psi.orm.model.Principals;
import org.muhia.app.psi.orm.model.PrincipalsGuarantor;
import org.muhia.app.psi.orm.model.PrincipalsLoans;
import org.muhia.app.psi.orm.repo.PrincipalsGuarantorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/**
 *
 * @author mathenge
 */
@Service
public class PrincipalGuarantorsService implements IPrincipalsGuarantorService {
    
    @Autowired
    private PrincipalsGuarantorRepository guarantorRepository ;

    @Autowired
    private IPrincipalsContributionsService contributionService;

    @Override
    public PrincipalsGuarantor savePrincipalGuarantors(PrincipalsGuarantor guarantor) {
        return guarantorRepository.save(guarantor);
    }

//    @Override
//    public Optional<Collection<PrincipalsGuarantor>> listPrincipalGuarantorsByStatus(int status) {
//        return  guarantorRepository.listPrincipalGuarantorsByStatus(status);
//    }

    @Override
    public void deletePrincipalGuarantors(PrincipalsGuarantor guarantor) {
        guarantorRepository.delete(guarantor);
    }

    @Override
    public PrincipalsGuarantor updatePrincipalGuarantors(PrincipalsGuarantor guarantor) {
        return  guarantorRepository.save(guarantor);
    }

    @Override
    public PrincipalsGuarantor findPrincipalGuarantorsById(Long id) {
        return  guarantorRepository.findOne(id);
    }

    @Override
    public Collection<PrincipalsGuarantor> listPrincipalGuarantors() {
        return guarantorRepository.findAll();
    }

    @Override
    public Collection<PrincipalsGuarantor> findPrincipalGuarantorsByPrincipal(Principals principal) {
        return guarantorRepository.findPrincipalGuarantorsByPrincipal(principal);
    }

    @Override
    public Collection<PrincipalsGuarantor> listGuaranteeRequest(Principals guarantor) {
        return guarantorRepository.listGuaranteeRequest(guarantor);
    }

    @Override
    public Collection<PrincipalsGuarantor> findPrincipalGuarantorByloan(Principals principal, PrincipalsLoans loan) {
        return guarantorRepository.getLoanGuarantorRequestPerLoan(principal, loan);
    }

    @Override
    public Optional<PrincipalsGuarantor> findGuarantorRequestPerLoan(Principals principal, PrincipalsLoans loan, Principals guarantor) {
        return guarantorRepository.isRequestSent(principal, loan, guarantor);
    }

    @Override
    public boolean isGuaranteedAmountEnough(PrincipalsGuarantor guarantee) {
        double maxlimit = contributionService.getMaxLimit(guarantee.getPrincipal());
        final Collection<PrincipalsGuarantor> loanrequest = findPrincipalGuarantorByloan(guarantee.getPrincipal(), guarantee.getLoan());
        int total = 0;
        for (PrincipalsGuarantor amount : loanrequest) {
            total += amount.getAmmountguaranteed();
        }
        double remaining = guarantee.getLoan().getPaybackamount() - (total + maxlimit);
        return remaining <= 0;
    }


}

