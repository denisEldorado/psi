/**
 * Aug 14, 2016
 */
package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.ExchangeRates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@Repository
public interface ExchangeRatesRepository extends JpaRepository<ExchangeRates, Long> {
    Optional<ExchangeRates> findExchangeRatesByExchangeRate(long exchangeRate);

    Optional<ExchangeRates> findExchangeRatesById(Long id);

}
