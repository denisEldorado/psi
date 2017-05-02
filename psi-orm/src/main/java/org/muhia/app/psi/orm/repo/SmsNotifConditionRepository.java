/**
 * Aug 14, 2016
 */
package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.SmsNotifCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@Repository
public interface SmsNotifConditionRepository extends JpaRepository<SmsNotifCondition, Long> {


}
