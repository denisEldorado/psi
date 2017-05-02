/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.service.orm.impl;

import org.muhia.app.psi.portal.service.orm.ISmsNotificationService;
import org.muhia.app.psi.orm.model.SmsNotification;
import org.muhia.app.psi.orm.repo.SmsNotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mathenge
 */
@Service
public class SmsNotificationService implements ISmsNotificationService {
    @Autowired
    private SmsNotificationRepository smsRepo;

    @Override
    public SmsNotification createSmsNotication(SmsNotification sms) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SmsNotification findById(Long id) {
        return smsRepo.findOne(id);
    }
    
    
}
