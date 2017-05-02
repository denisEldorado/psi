/**
 * Aug 14, 2016
 */
package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.BankCharges;
import org.muhia.app.psi.orm.model.ProductsMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@Repository
public interface BankChargesRepository extends JpaRepository<BankCharges, Long> {
    Optional<BankCharges> findBankChargesByProductId(ProductsMaster productsMaster);
    Optional<BankCharges> findBankChargesById(Long id);

}
