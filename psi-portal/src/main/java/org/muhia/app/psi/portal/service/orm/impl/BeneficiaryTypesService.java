/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.service.orm.impl;

import org.muhia.app.psi.portal.service.orm.IBeneficiaryTypesService;
import org.muhia.app.psi.orm.model.BeneficiaryTypes;
import org.muhia.app.psi.orm.repo.BeneficiaryTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class BeneficiaryTypesService implements IBeneficiaryTypesService {

    @Autowired
    private BeneficiaryTypesRepository beneficiaryTypesRepository;

    @Override
    public Collection<BeneficiaryTypes> listBeneficiaryTypesByStatus(int status) {
        return beneficiaryTypesRepository.findBeneficiaryTypesByStatus(status);

    }

    @Override
    public void deleteBeneficiaryTypes(BeneficiaryTypes beneficiaries) {
        beneficiaryTypesRepository.delete(beneficiaries);
    }

    @Override
    public BeneficiaryTypes updateBeneficiaryTypes(BeneficiaryTypes beneficiaries) {
        return beneficiaryTypesRepository.save(beneficiaries);
    }

    @Override
    public BeneficiaryTypes findBeneficiaryTypesById(Long id) {
        return beneficiaryTypesRepository.findOne(id);
    }

    @Override
    public BeneficiaryTypes saveBeneficiaryTypes(BeneficiaryTypes beneficiaries) {
        return beneficiaryTypesRepository.save(beneficiaries);
    }

}
