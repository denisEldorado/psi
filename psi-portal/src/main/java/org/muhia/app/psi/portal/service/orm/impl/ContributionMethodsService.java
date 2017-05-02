/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.service.orm.impl;

import java.util.Collection;
import org.muhia.app.psi.portal.service.orm.IContributionMethodsService;
import org.muhia.app.psi.orm.model.ContributionMethods;
import org.muhia.app.psi.orm.repo.ContributionMethodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mathenge
 */
@Service
public class ContributionMethodsService implements IContributionMethodsService {
    
    @Autowired
    private ContributionMethodsRepository methodsRepo;

    @Override
    public Collection<ContributionMethods> listCotributionMethods() {
        return methodsRepo.findAll();
    }

    @Override
    public ContributionMethods findByUniqueStatus(int status) {
        return methodsRepo.findByUniqueStatus(status);
    }
    
}
