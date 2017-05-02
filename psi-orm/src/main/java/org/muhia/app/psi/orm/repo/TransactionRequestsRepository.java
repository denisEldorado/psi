/**
 * Aug 14, 2016
 */
package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.ServiceRequests;
import org.muhia.app.psi.orm.model.TransactionRequests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@Repository
public interface TransactionRequestsRepository extends JpaRepository<TransactionRequests, Long> {
    Optional<TransactionRequests> findTransactionRequestsByTransactionStatus(int transactionStatus);

    Optional<TransactionRequests> findTransactionRequestsByServiceRequest(ServiceRequests serviceRequests);


}
