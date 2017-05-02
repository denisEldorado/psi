/**
 * Aug 14, 2016
 */
package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.Currencies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@Repository
public interface CurrenciesRepository extends JpaRepository<Currencies, Long> {
    Optional<Currencies> findCurrenciesByCurrencycode(String currencycode);

    Optional<Currencies> findCurrenciesById(Long id);

}
