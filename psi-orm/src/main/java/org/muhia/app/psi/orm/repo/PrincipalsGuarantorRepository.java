/**
 * 
 * Aug 14, 2016
 */
package org.muhia.app.psi.orm.repo;

import java.util.Collection;
import java.util.Optional;
import org.muhia.app.psi.orm.model.Principals;
import org.muhia.app.psi.orm.model.PrincipalsGuarantor;
import org.muhia.app.psi.orm.model.PrincipalsLoans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 *
 */
@Repository
public interface PrincipalsGuarantorRepository extends JpaRepository<PrincipalsGuarantor, Long> {
	
//	PrincipalsGuarantor findbyOrganizationAndStatus(String organization, int status);
        @Query("SELECT u FROM PrincipalsGuarantor u WHERE u.principal = :principal ORDER BY u.createdon DESC")
        Collection<PrincipalsGuarantor> findPrincipalGuarantorsByPrincipal(@Param(value = "principal") Principals principal);
        @Query("SELECT u FROM PrincipalsGuarantor u WHERE u.status = :status")
        Optional<Collection<PrincipalsGuarantor>> listPrincipalGuarantorsByStatus(@Param(value = "status") int status);
        
        //I will use this to list requests
        @Query("SELECT u FROM PrincipalsGuarantor u WHERE u.guarantor = :guarantor ORDER BY u.createdon DESC")
        Collection<PrincipalsGuarantor> listGuaranteeRequest(@Param(value="guarantor") Principals guarantor);
        
        @Query("SELECT u FROM PrincipalsGuarantor u WHERE u.principal = :principal AND u.loan=:loan")
        Collection<PrincipalsGuarantor> getLoanGuarantorRequestPerLoan(@Param(value = "principal") Principals principal,@Param(value = "loan") PrincipalsLoans loan);
        
        @Query("SELECT u FROM PrincipalsGuarantor u WHERE u.principal = :principal AND u.loan=:loan AND u.guarantor=:guarantor ")
        Optional<PrincipalsGuarantor> isRequestSent(@Param(value = "principal") Principals principal,@Param(value = "loan") PrincipalsLoans loan,@Param(value="guarantor") Principals guarantor);
}
