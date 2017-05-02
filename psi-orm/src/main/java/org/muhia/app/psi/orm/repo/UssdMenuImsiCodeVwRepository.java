/**
 * Aug 14, 2016
 */
package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.UssdMenuImsiCodeVw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@Repository
public interface UssdMenuImsiCodeVwRepository extends JpaRepository<UssdMenuImsiCodeVw, Long> {
    Optional<UssdMenuImsiCodeVw> findUssdMenuImsiCodeVwByMenuKey(String menuKey);

    Optional<UssdMenuImsiCodeVw> findUssdMenuImsiCodeVwById(Long id);

}
