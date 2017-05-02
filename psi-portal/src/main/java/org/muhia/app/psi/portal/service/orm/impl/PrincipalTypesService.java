/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.service.orm.impl;

import org.muhia.app.psi.portal.service.orm.IPrincipalTypesService;
import org.muhia.app.psi.orm.model.PrincipalTypes;
import org.muhia.app.psi.orm.repo.PrincipalTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PrincipalTypesService implements IPrincipalTypesService {

    @Autowired
    private PrincipalTypesRepository principalTypesRepository;

    @Override
    public PrincipalTypes findPrincipalTypesById(Long id) {
        return principalTypesRepository.findOne(id);
    }

    @Override
    public PrincipalTypes findPrincipalTypesByPrincipalType(String principalType) {
        return principalTypesRepository.findPrincipalTypesByPrincipalType(principalType).map(pt -> pt).orElse(principalTypesRepository.findOne(Long.valueOf("1")));
    }

}
