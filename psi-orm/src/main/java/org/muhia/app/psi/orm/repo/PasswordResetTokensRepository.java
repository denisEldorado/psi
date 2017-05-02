/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.PasswordResetTokens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@Repository
public interface PasswordResetTokensRepository extends JpaRepository<PasswordResetTokens, Long> {

    PasswordResetTokens findPasswordResetTokensByToken(String token);
}
