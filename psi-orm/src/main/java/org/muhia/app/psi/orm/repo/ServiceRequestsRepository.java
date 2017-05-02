/**
 * 
 * Aug 14, 2016
 */
package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.OrderMaster;
import org.muhia.app.psi.orm.model.ServiceRequests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 *
 */
@Repository
public interface ServiceRequestsRepository extends JpaRepository<ServiceRequests, Long> {


    Optional<ServiceRequests> findServiceRequestsByOrderNumber(OrderMaster orderNumber);

    Optional<ServiceRequests> findServiceRequestById(Long id);

    Optional<ServiceRequests> findServiceRequestByIdAndStatus(Long id, int status);

    Optional<ServiceRequests> findServiceRequestsByOrderNumberAndStatus(OrderMaster order, int status);

    Optional<Collection<ServiceRequests>> findServiceRequestsByStatus(int status);
}
