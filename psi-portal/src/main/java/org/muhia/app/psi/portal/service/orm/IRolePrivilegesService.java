package org.muhia.app.psi.portal.service.orm;

import org.muhia.app.psi.orm.model.RolePrivileges;

import java.util.List;

/**
 * Created by ngatia on 1/24/17.
 */
public interface IRolePrivilegesService {
    List<RolePrivileges> getAll();

    void save(RolePrivileges rolePrivileges);
}
