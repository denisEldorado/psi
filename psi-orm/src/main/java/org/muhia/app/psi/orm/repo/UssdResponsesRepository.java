/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.orm.repo;

import java.util.Optional;
import org.muhia.app.psi.orm.model.UssdRequests;
import org.muhia.app.psi.orm.model.UssdResponses;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Kenneth Muhia <muhia@muhia.org>
 */
public interface UssdResponsesRepository extends JpaRepository<UssdResponses, Long> {

    Optional<UssdResponses> findUssdResponsesByRequestIdAndStatus(UssdRequests requestId, String status);

}
