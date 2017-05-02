/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.orm.repo;


import org.muhia.app.psi.orm.model.Principals;
import org.muhia.app.psi.orm.model.PrincipalsLoans;
import org.muhia.app.psi.orm.model.ServiceRequests;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 *
 * @author mathenge
 */
@Repository
public interface PrincipalLoansRepository extends JpaRepository<PrincipalsLoans,Long> {
    @Query("SELECT p FROM PrincipalsLoans p WHERE p.principal = :principal ORDER BY p.createdon DESC")
    Collection<PrincipalsLoans> findPrincipalLoansByPrincipal(@Param(value = "principal") Principals principal);
    
    @Query("SELECT p FROM PrincipalsLoans p WHERE p.lender = :principal ORDER BY p.createdon DESC")
    Collection<PrincipalsLoans> findPrincipalLoansByLender(@Param(value="principal") Principals principal);
    @Query("SELECT p FROM PrincipalsLoans p WHERE p.sr = :serviceRequest")
    PrincipalsLoans findByServiceRequest(@Param(value="serviceRequest") ServiceRequests sr);

    @Query("SELECT p FROM PrincipalsLoans p")
    Page<PrincipalsLoans> findAllPaged(Pageable pageable);
}
