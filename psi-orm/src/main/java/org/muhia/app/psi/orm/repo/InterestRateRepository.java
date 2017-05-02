
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.InterestRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author mathenge
 */
public interface InterestRateRepository extends JpaRepository<InterestRate,Long> {
    @Query("SELECT  p FROM InterestRate p WHERE p.deactivateddate IS NULL")
    InterestRate activeRate();
}

