/**
 * Aug 14, 2016
 */
package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.BankBranches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@Repository
public interface BankBranchesRepository extends JpaRepository<BankBranches, Long> {
    Optional<BankBranches> findBankBranchesByBranchname(String branchname);

    Optional<BankBranches> findBankBranchesById(Long id);

}
