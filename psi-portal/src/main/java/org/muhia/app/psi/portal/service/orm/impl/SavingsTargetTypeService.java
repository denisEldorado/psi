/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.service.orm.impl;

import java.util.Collection;
import org.muhia.app.psi.portal.service.orm.ISavingsTargetTypeService;
import org.muhia.app.psi.orm.model.SavingsTargetType;
import org.muhia.app.psi.orm.repo.SavingsTargetTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mathenge
 */
@Service
public class SavingsTargetTypeService implements ISavingsTargetTypeService {
    
    @Autowired
    private SavingsTargetTypesRepository savingsTargetTypesRepo;

    @Override
    public Collection<SavingsTargetType> listTargetTypes() {
        return savingsTargetTypesRepo.findAll();
    }

    @Override
    public SavingsTargetType findById(Long id) {
        return savingsTargetTypesRepo.findOne(id);
    }

    @Override
    public SavingsTargetType saveTargetType(SavingsTargetType type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SavingsTargetType updateTargetType(SavingsTargetType type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteTargetType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
