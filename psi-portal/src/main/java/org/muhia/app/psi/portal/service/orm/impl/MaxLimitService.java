/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.service.orm.impl;

import org.muhia.app.psi.orm.model.MaxLimit;
import org.muhia.app.psi.orm.repo.MaxLimitRepository;
import org.muhia.app.psi.portal.service.orm.IMaxLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mathenge
 */
@Service
public class MaxLimitService implements IMaxLimitService{

    private final MaxLimitRepository maxlimitRepo;

    @Autowired
    public MaxLimitService(MaxLimitRepository maxlimitRepo) {
        this.maxlimitRepo = maxlimitRepo;
    }

    @Override
    public MaxLimit getActiveLimit(int status) {
        return maxlimitRepo.findActiveLimit(status);
    }
    
}
