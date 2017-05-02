/**
 * Aug 14, 2016
 */
package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.BankCharges;
import org.muhia.app.psi.orm.model.Banks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@Repository
public interface BanksRepository extends JpaRepository<Banks, Long> {
    Optional<Banks> findBanksByBankname(String bankname);

    Optional<Banks> findBanksByBankCharges(BankCharges bankCharges);

    Optional<Banks> findBanksById(Long id);

}
