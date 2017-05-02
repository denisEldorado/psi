/**
 * Aug 14, 2016
 */
package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.SavingsTargetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@Repository
public interface SavingsTargetTypeRepository extends JpaRepository<SavingsTargetType, Long> {
    Optional<SavingsTargetType> findSavingsTargetTypeByType(String type);

    Optional<SavingsTargetType> findSavingsTargetTypeById(Long id);

}
