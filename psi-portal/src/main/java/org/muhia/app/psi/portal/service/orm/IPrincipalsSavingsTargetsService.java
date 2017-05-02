/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.service.orm;

import java.util.Collection;
import org.muhia.app.psi.orm.model.Principals;
import org.muhia.app.psi.orm.model.PrincipalsSavingsTarget;
import org.muhia.app.psi.orm.model.ServiceRequests;

/**
 *
 * @author mathenge
 */
public interface IPrincipalsSavingsTargetsService {
    Collection<PrincipalsSavingsTarget> listAllSavings();
    Collection<PrincipalsSavingsTarget> findByPrincipal (Principals principal);
    PrincipalsSavingsTarget findById(Long id);
    PrincipalsSavingsTarget createSavingsTarget (PrincipalsSavingsTarget target);
    PrincipalsSavingsTarget updateSavingsTarget (PrincipalsSavingsTarget target);
    void deleteSavingsTarget(Long id);
    void transferSavingsAsPertarget();
    PrincipalsSavingsTarget findBySr(ServiceRequests sr);
    
    
}
