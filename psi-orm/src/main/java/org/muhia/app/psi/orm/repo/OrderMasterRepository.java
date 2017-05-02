package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

/**
 * Created by KennethKZMMuhia on 24-Oct-16.
 */
@Repository
public interface OrderMasterRepository extends JpaRepository<OrderMaster, Long> {

    @Query("select o from OrderMaster o where o.subno = :subno and o.transactionStatus = :transactionStatus and o.submittedDate >= trunc(:today)")
    Optional<Collection<OrderMaster>> findOrderMasterBySubnoAndTransactionStatus(@Param("subno") String subno, @Param("transactionStatus") int transactionStatus, @Param("today") Date today);

    Optional<Collection<OrderMaster>> findOrderMasterByTransactionStatus(int transactionStatus);
}
