/**
 * Aug 14, 2016
 */
package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.MobileMoneyResponses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@Repository
public interface MobileMoneyResponsesRepository extends JpaRepository<MobileMoneyResponses, Long> {
    Optional<MobileMoneyResponses> findMobileMoneyResponsesByProvider(String provider);
    Optional<MobileMoneyResponses> findMobileMoneyResponsesById(Long id);

}
