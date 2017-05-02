/**
 * Aug 14, 2016
 */
package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.WalletTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@Repository
public interface WalletTypesRepository extends JpaRepository<WalletTypes, Long> {
    Optional<WalletTypes> findWalletTypesByTypeName(String typeName);

    Optional<WalletTypes> findWalletTypesById(Long id);

}
