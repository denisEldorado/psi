/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.service.orm.impl;

import java.util.Collection;
import org.muhia.app.psi.portal.service.orm.ISavingsTargetIntervalService;
import org.muhia.app.psi.orm.model.SavingsInterval;
import org.muhia.app.psi.orm.repo.SavingsIntervalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mathenge
 */
@Service
public class SavingsTargetIntervalService implements ISavingsTargetIntervalService {
    
    @Autowired
    private SavingsIntervalRepository savingsTargetRepo;

    @Override
    public Collection<SavingsInterval> listAllIntervals() {
        return savingsTargetRepo.findAll();
    }

    @Override
    public SavingsInterval findById(Long id) {
        return savingsTargetRepo.findOne(id);
    }

    @Override
    public SavingsInterval saveSavingsInterval(SavingsInterval interval) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SavingsInterval updateSavingsInterval(SavingsInterval interval) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteSavingsInterval(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
