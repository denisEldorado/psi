/**
 *
 * Aug 14, 2016
 */
package org.muhia.app.psi.orm.repo;

import java.util.Collection;
import java.util.Optional;

import org.muhia.app.psi.orm.model.Principals;
import org.muhia.app.psi.orm.model.UserBeneficiaries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 *
 */
@Repository
public interface UserBeneficiariesRepository extends JpaRepository<UserBeneficiaries, Long> {

//	UserBeneficiaries findbyOrganizationAndStatus(String organization, int status);
    @Query("SELECT u FROM UserBeneficiaries u WHERE u.principal = :principal")
    Collection<UserBeneficiaries> findUserBeneficiariesbyPrincipal(@Param(value = "principal") Principals principal);

    Collection<UserBeneficiaries> findUserBeneficiariesByBeneficiaryStartsWithIgnoreCase(String beneficiary);
    
    @Query("SELECT u FROM UserBeneficiaries u WHERE u.principal = :principal")
    Optional<Collection<UserBeneficiaries>> findUserBeneficiariesByPrincipal(@Param(value = "principal")Principals principal);
    
    @Query("SELECT u FROM UserBeneficiaries u WHERE u.principal = :principal AND u.status=:status")
    Collection<UserBeneficiaries> findUserBeneficiariesByPrincipalAndStatus(@Param(value = "principal")Principals principal,@Param(value = "status")String status);
    
    @Query("SELECT u FROM UserBeneficiaries u WHERE u.principal = :principal AND u.id=:id")
    Optional<UserBeneficiaries> findUserBeneficiariesByPrincipalAndId(@Param(value = "principal")Principals principal,@Param(value = "id")int id);
}
