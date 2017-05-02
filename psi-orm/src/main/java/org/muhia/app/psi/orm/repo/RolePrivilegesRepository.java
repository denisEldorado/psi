package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.RolePrivileges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ngatia on 1/24/17.
 */
@Repository
@Transactional
public interface RolePrivilegesRepository extends JpaRepository<RolePrivileges, Long> {

}
