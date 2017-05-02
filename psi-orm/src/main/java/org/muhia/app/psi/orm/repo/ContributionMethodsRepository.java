/**
 * 
 * Aug 14, 2016
 */
package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.ContributionMethods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 *
 */
@Repository
public interface ContributionMethodsRepository extends JpaRepository<ContributionMethods, Long> {
	
//	ContributionMethods findbyOrganizationAndStatus(String organization, int status);
    @Query("SELECT p FROM ContributionMethods p WHERE p.status=:status")
    ContributionMethods findByUniqueStatus(@Param("status") int status);
}
