
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.service.orm;

import org.muhia.app.psi.orm.model.Principals;
import org.muhia.app.psi.orm.model.PrincipalsLoans;
import org.muhia.app.psi.orm.model.ServiceRequests;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.Date;

/**
 *
 * @author mathenge
 */
public interface IPrincipalsLoansService {
    Collection<PrincipalsLoans> listPrincipalLoans();
    PrincipalsLoans findLoanById(Long id);
    void deletePrincipalLoan (Long id);
    PrincipalsLoans updatePrincipalsLoan(PrincipalsLoans loan);
    PrincipalsLoans savePrincipalsLoan(PrincipalsLoans loan);
    Collection<PrincipalsLoans> findLoanByPrincipal(Principals principal);
    Collection<PrincipalsLoans> findLoanByLender(Principals principal);
    Collection<PrincipalsLoans> findAll();
    PrincipalsLoans findBySr(ServiceRequests sr);
    Date addPayBackDays(Date date, int days);
    void payLoan();

    Page<PrincipalsLoans> findAllPaged(Pageable pageable);
    
    
    
}

