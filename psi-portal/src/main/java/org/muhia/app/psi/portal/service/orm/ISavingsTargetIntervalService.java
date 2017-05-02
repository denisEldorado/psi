/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.service.orm;

import java.util.Collection;
import org.muhia.app.psi.orm.model.SavingsInterval;

/**
 *
 * @author mathenge
 */
public interface ISavingsTargetIntervalService {
    Collection<SavingsInterval> listAllIntervals();
    SavingsInterval findById(Long id);
    SavingsInterval saveSavingsInterval (SavingsInterval interval);
    SavingsInterval updateSavingsInterval (SavingsInterval interval);
    void deleteSavingsInterval (Long id);
    
}
