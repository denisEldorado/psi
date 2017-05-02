/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.orm.repo;

import java.util.Collection;
import java.util.Optional;
import org.muhia.app.psi.orm.model.Titles;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Kenneth Muhia <muhia@muhia.org>
 */
public interface TitlesRepository extends JpaRepository<Titles, Long> {

    Optional<Collection<Titles>> findTitlesByStatus(int status);

    Optional<Titles> findTitlesById(Long id);

}
