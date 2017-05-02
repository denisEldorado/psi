/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.service.orm.impl;

import org.muhia.app.psi.portal.service.orm.ITitlesService;
import org.muhia.app.psi.orm.model.Titles;
import org.muhia.app.psi.orm.repo.TitlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
@Transactional
public class TitlesService implements ITitlesService {

    @Autowired
    private TitlesRepository titlesRepository;

    @Override
    public Optional<Collection<Titles>> findTitlesByStatus(int status) {
        return titlesRepository.findTitlesByStatus(status);
    }

    @Override
    public Titles findTitleById(Long id) {
        return titlesRepository.findTitlesById(id).map(t -> t).orElse(new Titles(id));
    }

    @Override
    public Collection<Titles> findTitlesByStatusActive(int status) {
        return titlesRepository.findTitlesByStatus(status).map(tt -> tt).orElse(new ArrayList<>());
    }

}
