package org.muhia.app.psi.portal.service.orm.impl;

import org.muhia.app.psi.portal.service.orm.IRolePrivilegesService;
import org.muhia.app.psi.orm.model.RolePrivileges;
import org.muhia.app.psi.orm.repo.RolePrivilegesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ngatia on 1/24/17.
 */
@Service
public class RolePrivilegeService implements IRolePrivilegesService {

    @Autowired
    RolePrivilegesRepository rolePrivilegesRepository;

    @Override
    public List<RolePrivileges> getAll() {
        return null;
    }

    @Override
    public void save(RolePrivileges rolePrivileges) {
        rolePrivilegesRepository.save(rolePrivileges);
    }
}
