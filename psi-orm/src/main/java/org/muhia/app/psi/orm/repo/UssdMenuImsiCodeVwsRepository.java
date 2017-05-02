/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.UssdMenuImsiCodeVw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Optional;

/**
 *
 * @author Kenneth Muhia <muhia@muhia.org>
 */
public interface UssdMenuImsiCodeVwsRepository extends JpaRepository<UssdMenuImsiCodeVw, Long> {

//    Optional<Collection<UssdMenuImsiCodeVw>> findUssdMenuImsiCodeVwByCode(String code);
//    @Query(value = )
    Optional<Collection<UssdMenuImsiCodeVw>> findUssdMenuImsiCodeVwByUssdCode(String ussdCode);
    @Query("SELECT u FROM UssdMenuImsiCodeVw u WHERE u.ussdCode = :code AND u.status = :status ")
    Optional<Collection<UssdMenuImsiCodeVw>> findUssdMenuImsiCodeVwByUssdCodeAndStatus(@Param("code") String ussdCode,@Param("status") int status);

    @Query("SELECT u FROM UssdMenuImsiCodeVw u WHERE u.menuKey = :menuKey and u.menuParameter like :menuParameter and u.id in (Select min(uu.id) from UssdMenuImsiCodeVw  uu WHERE uu.menuKey = :menuKey and uu.menuParameter like :menuParameter)")
    Optional<UssdMenuImsiCodeVw> findUssdMenuImsiCodeVwByMenuKeyAndByMenuParameter(@Param("menuKey") String menuKey, @Param("menuParameter") String menuParameter);

    Optional<UssdMenuImsiCodeVw> findUssdMenuImsiCodeVwByMenuKeyAndMenuCondition(String menuKey, String menuCondition);

    Optional<UssdMenuImsiCodeVw> findUssdMenuImsiCodeVwByMenuKey(String menuKey);
}
