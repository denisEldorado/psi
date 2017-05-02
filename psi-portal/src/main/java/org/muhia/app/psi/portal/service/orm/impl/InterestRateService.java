/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.service.orm.impl;

import org.muhia.app.psi.portal.service.orm.IInterestRateService;
import org.muhia.app.psi.orm.model.InterestRate;
import org.muhia.app.psi.orm.repo.InterestRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mathenge
 */
@Service
public class InterestRateService implements IInterestRateService {
    
    @Autowired
    InterestRateRepository InterestRepo;

    @Override
    public InterestRate findActiveInterest() {
        return  InterestRepo.activeRate();
    }
    
}
