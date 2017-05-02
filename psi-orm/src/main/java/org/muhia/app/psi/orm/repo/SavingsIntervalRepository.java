/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.SavingsInterval;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mathenge
 */
public interface SavingsIntervalRepository extends JpaRepository<SavingsInterval,Long> {
    
    
}
