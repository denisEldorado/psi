/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.service.orm.impl;

import org.muhia.app.psi.portal.service.orm.IVerificationTokensService;
import org.muhia.app.psi.orm.model.VerificationTokens;
import org.muhia.app.psi.orm.repo.VerificationTokensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VerificationTokensService implements IVerificationTokensService {

    @Autowired
    private VerificationTokensRepository verificationTokensRepository;

    @Override
    public VerificationTokens getVerificationToken(String token) {
        return verificationTokensRepository.findVerificationTokensByToken(token).map(v -> v).orElse(null);
    }

}
