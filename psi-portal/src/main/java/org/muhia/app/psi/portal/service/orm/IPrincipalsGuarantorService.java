
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.service.orm;

import java.util.Collection;
import java.util.Optional;
import org.muhia.app.psi.orm.model.Principals;
import org.muhia.app.psi.orm.model.PrincipalsGuarantor;
import org.muhia.app.psi.orm.model.PrincipalsLoans;

/**
 *
 * @author mathenge
 */
public interface IPrincipalsGuarantorService {
    PrincipalsGuarantor savePrincipalGuarantors (PrincipalsGuarantor guarantor);
    //Optional<Collection <PrincipalsGuarantor>> listPrincipalGuarantorsByStatus (int status);
    Collection<PrincipalsGuarantor> listPrincipalGuarantors ();
    void deletePrincipalGuarantors(PrincipalsGuarantor guarantor);
    PrincipalsGuarantor updatePrincipalGuarantors(PrincipalsGuarantor guarantor);
    PrincipalsGuarantor findPrincipalGuarantorsById(Long id);
    Collection<PrincipalsGuarantor> findPrincipalGuarantorsByPrincipal(Principals principal);
    Collection<PrincipalsGuarantor> listGuaranteeRequest(Principals guarantor);
    Collection<PrincipalsGuarantor> findPrincipalGuarantorByloan(Principals principal, PrincipalsLoans loan);
    Optional<PrincipalsGuarantor> findGuarantorRequestPerLoan(Principals principal, PrincipalsLoans loan,Principals guarantor);
    boolean isGuaranteedAmountEnough(PrincipalsGuarantor guarantee);
}

