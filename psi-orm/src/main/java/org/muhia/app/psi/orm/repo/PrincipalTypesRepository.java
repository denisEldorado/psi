/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.PrincipalTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@Repository
public interface PrincipalTypesRepository extends JpaRepository<PrincipalTypes, Long>{

    Optional<PrincipalTypes> findPrincipalTypesByPrincipalType(String principalType);
}
