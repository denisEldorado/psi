/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@Repository
@Transactional
public interface RolesRepository extends JpaRepository<Roles, Long> {

    @Query(value = "SELECT r FROM Roles r where id between :min and :max")
    Optional<List<Roles>> getRolesByIdBetweenMinAndMax(@Param("min") long min, @Param("max") long max);
    
    @Query("SELECT r FROM Roles r")
    Optional<List<Roles>> listAllRoles();

    Roles findRolesByRolename(String rolename);
}
