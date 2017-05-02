/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.Principals;
import org.muhia.app.psi.orm.model.Roles;
import org.muhia.app.psi.orm.model.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

/**
 *
 * @author Kenneth Muhia <muhia@muhia.org>
 */
public interface UserRolesRepository extends JpaRepository<UserRoles, Long> {

    Optional<Collection<UserRoles>> findUserRolesByUserid(Principals userid);

    Optional<UserRoles> findUserRolesByRoleid(Roles roles);
}
