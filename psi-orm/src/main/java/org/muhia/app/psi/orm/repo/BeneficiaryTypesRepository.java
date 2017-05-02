/**
 *
 * Aug 14, 2016
 */
package org.muhia.app.psi.orm.repo;

import java.util.Collection;
import org.muhia.app.psi.orm.model.BeneficiaryTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 *
 */
@Repository
public interface BeneficiaryTypesRepository extends JpaRepository<BeneficiaryTypes, Long> {
//	BeneficiaryTypes findbyOrganizationAndStatus(String organization, int status);

    Collection<BeneficiaryTypes> findBeneficiaryTypesByStatus(int status);
}
