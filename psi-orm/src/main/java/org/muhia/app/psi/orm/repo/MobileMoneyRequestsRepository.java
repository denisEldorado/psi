/**
 * Aug 14, 2016
 */
package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.MobileMoneyRequests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@Repository
public interface MobileMoneyRequestsRepository extends JpaRepository<MobileMoneyRequests, Long> {
    Optional<MobileMoneyRequests> findMobileMoneyRequestsByProvider(String provider);

    Optional<MobileMoneyRequests> findMobileMoneyRequestsById(Long id);

}
