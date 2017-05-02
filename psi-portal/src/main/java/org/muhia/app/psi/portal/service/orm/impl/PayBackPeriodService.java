/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.service.orm.impl;

import org.muhia.app.psi.portal.service.orm.IPaybackPeriodService;
import org.muhia.app.psi.orm.model.PayBackPeriod;
import org.muhia.app.psi.orm.repo.PayBackPeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mathenge
 */
@Service
public class PayBackPeriodService implements IPaybackPeriodService {
    
    @Autowired
    PayBackPeriodRepository paybackRepo;

    @Override
    public PayBackPeriod findActivePayBackPeriod() {
        return paybackRepo.activePeriod();
    }
    
}
