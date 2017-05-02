/**
 * 
 * Aug 14, 2016
 */
package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.RegisteredSaccos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;


/**
 * @author Kenneth Muhia <muhia@muhia.org>
 *
 */
@Repository
public interface RegisteredSaccosRepository extends JpaRepository<RegisteredSaccos, Long> {

    Optional<Collection<RegisteredSaccos>> findRegistredSaccosById(Long Id);

    Optional<Collection<RegisteredSaccos>> findRegistredSaccosBySacco(String sacco);

    @Query("Select r from RegisteredSaccos r where r.sacco = :sacco")
    Optional<RegisteredSaccos> findFirstRegistredSaccosBySacco(@Param("sacco") String sacco);
}
