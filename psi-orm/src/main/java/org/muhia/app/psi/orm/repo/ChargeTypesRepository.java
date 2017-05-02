/**
 * Aug 14, 2016
 */
package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.ChargeTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@Repository
public interface ChargeTypesRepository extends JpaRepository<ChargeTypes, Long> {
    Optional<ChargeTypes> findChargeTypesByChargeTypeCode(String chargeTypeCode);

    Optional<ChargeTypes> findChargeTypesById(Long id);

}
