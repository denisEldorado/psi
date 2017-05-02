/**
 * Aug 14, 2016
 */
package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.MobileMoneyProviders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@Repository
public interface MobileMoneyProvidersRepository extends JpaRepository<MobileMoneyProviders, Long> {
    Optional<MobileMoneyProviders> findMobileMoneyProvidersByProvider(String provider);

    Optional<MobileMoneyProviders> findMobileMoneyProvidersById(Long id);

}
