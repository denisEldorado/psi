/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.Principals;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@Repository
public interface PrincipalsRepository extends PagingAndSortingRepository<Principals, Long> {

    @Query("SELECT p FROM Principals p WHERE p.emailaddress = :emailaddress")
    Principals findByEmailaddress(@Param("emailaddress") String emailaddress);

    @Query("SELECT p FROM Principals p WHERE p.loginName = :loginName")
    Principals findByLoginName(@Param("loginName") String loginName);

    @Query("SELECT p FROM Principals p WHERE p.loginName = :loginName")
    Optional<Principals> findPrincipalsByLoginName(@Param("loginName") String loginName);

    Optional<Principals> findPrincipalsByLoginNameAndStatus(String loginName, int status);

    @Query(
            value="SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY p.createdon DESC) AS RN, p.* FROM adm_Principals p) AS g WHERE RN between ?#{ #pageable.offset} and ?#{#pageable.offset + #pageable.pageSize}, ORDER BY 1=1",
            countQuery="SELECT count(p.ID) FROM adm_Principals p",
            nativeQuery = true
    )
    Page<Principals> findPagedPrincipals(Pageable p);
    
    @Query("SELECT p FROM Principals p WHERE p.cellphonenumber = :cellphonenumber")
    Optional<Principals> findByCellPhoneNumber(@Param("cellphonenumber") String cellphonenumber);

}
