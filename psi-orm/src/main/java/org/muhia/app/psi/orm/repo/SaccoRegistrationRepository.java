/**
 * Aug 14, 2016
 */
package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.Principals;
import org.muhia.app.psi.orm.model.SaccoRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;


/**
 * @author Kenneth Muhia <muhia@muhia.org>
 *
 */
@Repository
public interface SaccoRegistrationRepository extends JpaRepository<SaccoRegistration, Long> {

    Optional<Collection<SaccoRegistration>> findSaccoRegistrationByUserId(Principals userId);
}
