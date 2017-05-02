/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.UssdRequests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

/**
 *
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@Repository
public interface UssdRequestsRepository extends JpaRepository<UssdRequests, Long> {

    Optional<UssdRequests> findUssdRequestsByTransactionidAndStatus(String transactionId, String status);
    
    @Query(value="SELECT u FROM UssdRequests u WHERE u.sessionid = :sessionid and u.transactionid = :transactionId and u.id in(Select max(uu.id) FROM UssdRequests uu WHERE uu.sessionid = :sessionid and uu.transactionid = :transactionId)")
    Optional<UssdRequests> findOneUssdRequestsBySessionidAndTransactionid(@Param("sessionid")String sessionid,@Param("transactionId")String transactionId);
    
    Optional<Collection<UssdRequests>> findUssdRequestsBySessionid(String sessionid);

    Optional<Collection<UssdRequests>> findUssdRequestsBySessionidAndStatus(String sessionid, String status);

    @Query(value="SELECT u FROM UssdRequests u WHERE u.sessionid = :sessionid and u.status = :status and u.varFld4 is not null")
    Optional<Collection<UssdRequests>> findUssdRequestsBySessionidAndStatusAndVarFld4Exists(@Param("sessionid") String sessionid, @Param("status") String status);
}
