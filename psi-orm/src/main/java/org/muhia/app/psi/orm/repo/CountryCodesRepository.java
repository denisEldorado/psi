/**
 * Aug 14, 2016
 */
package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.CountryCodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@Repository
public interface CountryCodesRepository extends JpaRepository<CountryCodes, Long> {
    Optional<CountryCodes> findCountryCodesByCountryDesc(String countryDesc);

    Optional<CountryCodes> findCountryCodesByCountryId(Long countryId);

}
