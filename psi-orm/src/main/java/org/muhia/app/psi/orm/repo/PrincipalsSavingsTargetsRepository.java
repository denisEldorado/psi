/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.orm.repo;

import java.util.Collection;

import org.muhia.app.psi.orm.model.Principals;
import org.muhia.app.psi.orm.model.PrincipalsSavingsTarget;
import org.muhia.app.psi.orm.model.ServiceRequests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author mathenge
 */
public interface PrincipalsSavingsTargetsRepository extends JpaRepository<PrincipalsSavingsTarget,Long> {
    @Query("SELECT p FROM PrincipalsSavingsTarget p WHERE p.principal =:principal ORDER BY p.createdon DESC")
    Collection<PrincipalsSavingsTarget> findSavingsTargetByPrincipal(@Param(value = "principal") Principals principal);
    @Query("SELECT p FROM PrincipalsSavingsTarget p WHERE p.servicerequest = :serviceRequest ORDER BY p.createdon DESC")
    PrincipalsSavingsTarget findByServiceRequest(@Param(value="serviceRequest") ServiceRequests serviceRequest);
}
