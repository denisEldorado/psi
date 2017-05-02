/**
 * 
 * Aug 14, 2016
 */
package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.Principals;
import org.muhia.app.psi.orm.model.PrincipalsContributions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 *
 */
@Repository
public interface PrincipalsContributionsRepository extends JpaRepository<PrincipalsContributions, Long> {
	@Query("SELECT sum(p.amount) FROM PrincipalsContributions p WHERE p.principal = :principal  ORDER BY p.createdon DESC")
        Long  totalPrincipalContributionsByPrincipal (@Param(value="principal") Principals Principal);
        
        @Query("SELECT p FROM PrincipalsContributions p WHERE p.principal = :principal ORDER BY p.createdon DESC")
        Collection<PrincipalsContributions> findPrincipalsContributionsByPrincipal (@Param(value="principal") Principals Principal);

    @Query("SELECT p FROM PrincipalsContributions p WHERE p.principal = :principal AND p.status=:status ORDER BY p.createdon DESC")
    Collection<PrincipalsContributions> findPrincipalsContributionsByPrincipalAndStatus (@Param(value="principal") Principals Principal, @Param(value="status") int status);
    @Query("SELECT p FROM PrincipalsContributions p")
    Page<PrincipalsContributions> findAllPaged(Pageable pageable);
//	PrincipalsContributions findbyOrganizationAndStatus(String organization, int status);
}
