/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.service.orm;

import org.muhia.app.psi.portal.validation.EmailExistsException;
import org.muhia.app.psi.orm.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 */
public interface IPrincipalsService {

    Principals registerNewUser(Principals user) throws EmailExistsException;

    Principals findUserByEmail(String email);
    Optional<Principals> findUserByPhone(String cellphonenumber);

    Principals findByLoginName(String loginName);


    PasswordResetTokens createPasswordResetTokenForUser(Principals user, String token);

    void changeUserPassword(Principals user, String password);

    Principals changeUserPasswordAndEnableAccount(Principals user, String password,String app);

    void changeUserPasswordBySelf(Principals user, String password, String changedBy, String oldPassword);

    void createVerificationTokenForUser(Principals user, String token);

    VerificationTokens createVerificationTokenForUser(Principals user, String token, int expiryMinutes);

    void saveRegisteredUser(Principals user);

    Principals saveRegisteredPrincipal(Principals user);

    UserSecurityQuestions saveSecurityQuestionsForUser(Principals user, DefineSecurityQuestions question, String answer);

    Optional<Collection<UserBeneficiaries>> listUserBeneficiariesByPrincipal(Principals user);

    Collection<UserBeneficiaries> listUserBeneficiariesByPrincipals(Principals user);

    Optional<UserSecurityQuestions> findUserSecurityQuestionsByQuestionAndUserIdAndAnswer(Principals user, DefineSecurityQuestions question, String answer);

    Optional<UserSecurityQuestions> findUserSecurityQuestionsByUser(Principals user, int status);

    Principals findPrincipalsById(Long id);

    Optional<Collection<UserRoles>> findUserRolesByUserid(Principals userid);

    String generateOneTimePin();

    Roles findRolesByRolename(String rolename);

    Optional<UserRoles> findUserRolesByRoleid(Roles roles);

    UserRoles saveUserRoles(UserRoles userRoles);
    
    String generateMembershipNo();

//    Date calculateExpiryDate(final int expiryTimeInMinutes);

    Iterable<Principals> findAllUsers();

    Page<Principals> listPrincipalsByPage(Integer pageNumber, Integer pageSize);
}
