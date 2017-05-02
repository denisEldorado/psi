/**
 * Aug 14, 2016
 */
package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.AccountTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@Repository
public interface AccountTypesRepository extends JpaRepository<AccountTypes, Long> {
    Optional<AccountTypes> findAccountTypesByAcctypecode(String acctypecode);
    Optional<AccountTypes> findAccountTypesById(Long id);

}
