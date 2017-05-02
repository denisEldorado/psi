/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.service.orm.impl;

import java.util.Collection;
import org.muhia.app.psi.portal.service.orm.IObaPayErrorCodesService;
import org.muhia.app.psi.orm.model.ObaPayErrorCode;
import org.muhia.app.psi.orm.repo.ObapayErrorCodesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mathenge
 */
@Service
public class ObaPayErrorCodesService implements IObaPayErrorCodesService {
    
    @Autowired
    private ObapayErrorCodesRepository obapayRepo;

    @Override
    public Collection<ObaPayErrorCode> listErrorCodes() {
        return obapayRepo.findAll();
    }
    
}
