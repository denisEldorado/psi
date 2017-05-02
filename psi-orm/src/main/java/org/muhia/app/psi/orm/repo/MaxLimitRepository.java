/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.MaxLimit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author mathenge
 */
public interface MaxLimitRepository extends JpaRepository<MaxLimit, Long> {
    @Query("SELECT m FROM MaxLimit m WHERE m.status=:status")
    MaxLimit findActiveLimit(@Param("status") int status);
}
