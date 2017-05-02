/**
 * 
 * Aug 14, 2016
 */
package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.RegistrationDocs;
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
public interface RegistrationDocsRepository extends JpaRepository<RegistrationDocs, Long> {
    Optional<Collection<RegistrationDocs>> findRegistrationDocsByDocuments(String documents);

    @Query("SELECT distinct r FROM RegistrationDocs r WHERE r.documents = :documents")
    Optional<RegistrationDocs> findFirstRegistrationDocsByDocuments(@Param("documents") String documents);
	

}
