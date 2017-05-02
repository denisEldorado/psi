/**
 * 
 * Aug 14, 2016
 */
package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.PrincipalsBanking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 *
 */
@Repository
public interface PrincipalsBankingRepository extends JpaRepository<PrincipalsBanking, Long> {
	
//	PrincipalsBanking findbyOrganizationAndStatus(String organization, int status);
}
