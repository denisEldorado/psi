/**
 * Aug 14, 2016
 */
package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.UsercreateRequests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@Repository
public interface UsercreateRequestsRepository extends JpaRepository<UsercreateRequests, Long> {
    Optional<UsercreateRequests> findUsercreateRequestsByAuthKey(String authKey);

    Optional<UsercreateRequests> findUsercreateRequestsByCreateid(Long createid);

}
