/**
 * Aug 14, 2016
 */
package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.TransactionCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@Repository
public interface TransactionCategoriesRepository extends JpaRepository<TransactionCategories, Long> {
    Optional<TransactionCategories> findTransactionCategoriesByTrantype(String trantype);
    Optional<TransactionCategories> findTransactionCategoriesById(Long id);

}
