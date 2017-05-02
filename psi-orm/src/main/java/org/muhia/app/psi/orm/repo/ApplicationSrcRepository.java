package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.ApplicationSrc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by KennethKZMMuhia on 24-Oct-16.
 */
@Repository
public interface ApplicationSrcRepository extends JpaRepository<ApplicationSrc, Long> {
    Optional<ApplicationSrc> findApplicationSrcByApplication(String appName);
}
