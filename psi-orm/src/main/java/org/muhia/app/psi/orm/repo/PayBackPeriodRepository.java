
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.PayBackPeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mathenge
 */
@Repository
public interface PayBackPeriodRepository extends JpaRepository<PayBackPeriod,Long>{
    @Query("SELECT  p FROM PayBackPeriod p WHERE p.deactivatedon IS NULL")
    PayBackPeriod activePeriod();
    
}

