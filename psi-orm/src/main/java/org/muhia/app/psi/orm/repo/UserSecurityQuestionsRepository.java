/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.orm.repo;

import java.util.Optional;
import org.muhia.app.psi.orm.model.DefineSecurityQuestions;
import org.muhia.app.psi.orm.model.Principals;
import org.muhia.app.psi.orm.model.UserSecurityQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@Repository
public interface UserSecurityQuestionsRepository extends JpaRepository<UserSecurityQuestions, Long> {

    UserSecurityQuestions findUserSecurityQuestionsByQuestionsAndUserId(DefineSecurityQuestions question, Principals userId);

    Optional<UserSecurityQuestions> findUserSecurityQuestionsByQuestionsAndUserIdAndAnswer(DefineSecurityQuestions questions, Principals userId, String answer);
    
    Optional<UserSecurityQuestions> findUserSecurityQuestionsByUserIdAndStatus(Principals userId, int status);
    
}
