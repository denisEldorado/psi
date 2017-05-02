/**
 * Aug 14, 2016
 */
package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.BankAccounts;
import org.muhia.app.psi.orm.model.Principals;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@Repository
public interface BankAccountsRepository extends CrudRepository<BankAccounts, Long> {

    Optional<BankAccounts> findBankAccountsByAccNumber(String accNumber);

    Optional<BankAccounts> findBankAccountsByUserId(Principals userId);

    Optional<BankAccounts> findBankAccountsById(Long id);

}
