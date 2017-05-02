/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.service.orm.impl;

import org.muhia.app.psi.config.order.properties.OrderProcessingProperties;
import org.muhia.app.psi.config.org.properties.OrganizationProperties;
import org.muhia.app.psi.config.security.HashingImplementation;
import org.muhia.app.psi.config.security.RandomPasswordGenerators;
import org.muhia.app.psi.config.security.properties.UserAccountStatus;
import org.muhia.app.psi.orm.model.*;
import org.muhia.app.psi.orm.repo.*;
import org.muhia.app.psi.portal.service.orm.IPrincipalsService;
import org.muhia.app.psi.portal.validation.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@Transactional
public class PrincipalsService implements IPrincipalsService {

    private final PrincipalsRepository principalsRepository;

//    private final PrincipalTypesRepository principalTypesRepository;

    private final VerificationTokensRepository verificationTokensRepository;

    private final PasswordResetTokensRepository passwordResetTokensRepository;
    private final UserSecurityQuestionsRepository securityQuestionsRepository;

    private final UserBeneficiariesRepository beneficiariesRepository;
    private final OrganizationProperties op;
    private final PasswordEncoder passwordEncoder;
    private final UserRolesRepository userRolesRepository;
    private final RolesRepository rolesRepository;
    private final HashingImplementation hashingImplementation;
    private final RandomPasswordGenerators passwordGenerators;
    private final UserAccountStatus accountStatus;
    private final OrderProcessingProperties orderProcessingProperties;

    @Autowired
    public PrincipalsService(PrincipalsRepository principalsRepository, VerificationTokensRepository verificationTokensRepository, RandomPasswordGenerators passwordGenerators, PasswordResetTokensRepository passwordResetTokensRepository, HashingImplementation hashingImplementation, OrderProcessingProperties orderProcessingProperties, UserSecurityQuestionsRepository securityQuestionsRepository, UserBeneficiariesRepository beneficiariesRepository, UserAccountStatus accountStatus, UserRolesRepository userRolesRepository, RolesRepository rolesRepository, OrganizationProperties op, PasswordEncoder passwordEncoder) {

        this.principalsRepository = principalsRepository;

        this.verificationTokensRepository = verificationTokensRepository;
        this.passwordGenerators = passwordGenerators;
        this.passwordResetTokensRepository = passwordResetTokensRepository;
        this.hashingImplementation = hashingImplementation;
        this.orderProcessingProperties = orderProcessingProperties;

        this.securityQuestionsRepository = securityQuestionsRepository;
        this.beneficiariesRepository = beneficiariesRepository;

        this.accountStatus = accountStatus;
        this.userRolesRepository = userRolesRepository;
        this.rolesRepository = rolesRepository;
        this.op = op;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Principals registerNewUser(Principals user) throws EmailExistsException {

        if (user.getLoginName() == null | user.getLoginName().isEmpty()) {
            user.setLoginName(user.getEmailaddress());
        }
        if (loginNameIsInUse(user.getLoginName())) {
            throw new EmailExistsException("Login Name is already in use");

        }
        user.setCredentials(passwordEncoder.encode(user.getCredentials()));
        user.setPasswordsConfirmation(passwordEncoder.encode(""));
        user.setMembershipNo(generateMembershipNo());
        return principalsRepository.save(user);
    }

    private boolean loginNameIsInUse(final String loginName) {
        final Principals user = principalsRepository.findByLoginName(loginName);
        return user != null;
    }

    @Override
    public Principals findUserByEmail(String email) {
        return principalsRepository.findByEmailaddress(email);
    }

    @Override
    public Principals findByLoginName(String loginName) {
        return principalsRepository.findByLoginName(loginName);
    }

    @Override
    public PasswordResetTokens createPasswordResetTokenForUser(Principals user, String token) {
        final PasswordResetTokens passwordResetTokens = new PasswordResetTokens();
        passwordResetTokens.setUserId(user);
        passwordResetTokens.setToken(token);
        passwordResetTokens.setExpiryDate(calculateExpiryDate(op.getValidationTokenExpiryMinutes()));
        passwordResetTokens.setCreatedon(new Date());
        passwordResetTokens.setCreatedby("Initial Setup.");

        return passwordResetTokensRepository.save(passwordResetTokens);

    }

    @Override
    public void changeUserPassword(Principals user, String password) {
        user.setCredentials(passwordEncoder.encode(password));
        user.setModifiedby("Credentials Control");
        user.setModifiedon(new Date());
        principalsRepository.save(user);

    }

    @Override
    public Principals changeUserPasswordAndEnableAccount(Principals user, String password, String app) {
        user.setCredentials(passwordEncoder.encode(password));
        user.setStatus(accountStatus.getEnabled());
        user.setModifiedby("Enabled by Credentials Control" + app);
        user.setModifiedon(new Date());

        return principalsRepository.save(user);

    }

    @Override
    public void createVerificationTokenForUser(Principals user, String token) {
        final VerificationTokens verificationTokens = new VerificationTokens();
        verificationTokens.setUserId(user);
        verificationTokens.setToken(token);
        verificationTokens.setExpiryDate(calculateExpiryDate(op.getValidationTokenExpiryMinutes()));
        verificationTokens.setCreatedon(new Date());
        verificationTokens.setCreatedby("User Registration.");

        verificationTokensRepository.save(verificationTokens);
    }

    @Override
    public VerificationTokens createVerificationTokenForUser(Principals user, String token, int expiryMinutes) {
        final VerificationTokens verificationTokens = new VerificationTokens();
        verificationTokens.setUserId(user);
        verificationTokens.setToken(token);
        verificationTokens.setExpiryDate(calculateExpiryDate(expiryMinutes));
        verificationTokens.setCreatedon(new Date());
        verificationTokens.setCreatedby("OTP Generation.");


        return verificationTokensRepository.save(verificationTokens);

    }

    @Override
    public void saveRegisteredUser(Principals user) {
        principalsRepository.save(user);
    }


    private Date calculateExpiryDate(final int expiryTimeInMinutes) {
        /*
            DONE: Expiry date is not working
         */
        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(new Date().getTime());
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }

    @Override
    public UserSecurityQuestions saveSecurityQuestionsForUser(Principals user, DefineSecurityQuestions question, String answer) {
        return securityQuestionsRepository.save(new UserSecurityQuestions(user, hashingImplementation.getEncryptedValue(answer), question));
    }

    @Override
    public Optional<UserSecurityQuestions> findUserSecurityQuestionsByQuestionAndUserIdAndAnswer(Principals user, DefineSecurityQuestions question, String answer) {
        return securityQuestionsRepository.findUserSecurityQuestionsByQuestionsAndUserIdAndAnswer(question, user, hashingImplementation.getEncryptedValue(answer));
    }

    @Override
    public Principals saveRegisteredPrincipal(Principals user) {
        return principalsRepository.save(user);
    }

    @Override
    public Principals findPrincipalsById(Long id) {
        return principalsRepository.findOne(id);
    }

    /* (non-Javadoc)
     * @see org.muhia.app.rho.access.service.IPrincipalsService#listUserBeneficiariesByPrincipal(org.muhia.app.rho.orm.model.Principals)
     */
    @Override
    public Optional<Collection<UserBeneficiaries>> listUserBeneficiariesByPrincipal(Principals user) {
        return beneficiariesRepository.findUserBeneficiariesByPrincipal(user);
    }

    @Override
    public void changeUserPasswordBySelf(Principals user, String password, String changedBy, String oldPassword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<UserSecurityQuestions> findUserSecurityQuestionsByUser(Principals user, int status) {
        return securityQuestionsRepository.findUserSecurityQuestionsByUserIdAndStatus(user, status);
    }

    @Override
    public Collection<UserBeneficiaries> listUserBeneficiariesByPrincipals(Principals user) {
        return beneficiariesRepository.findUserBeneficiariesbyPrincipal(user);
    }

    @Override
    public Optional<Collection<UserRoles>> findUserRolesByUserid(Principals userid) {
        return userRolesRepository.findUserRolesByUserid(userid);
    }

    @Override
    public String generateOneTimePin() {
        if (!passwordGenerators.isDoShuffle()) {
            passwordGenerators.digits(6).shuffle();
        }
        return passwordGenerators.generateRandomString();
    }

    @Override
    public Roles findRolesByRolename(String rolename) {
        return rolesRepository.findRolesByRolename(rolename);
    }

    @Override
    public Optional<UserRoles> findUserRolesByRoleid(Roles roles) {
        return userRolesRepository.findUserRolesByRoleid(roles);
    }

    @Override
    public UserRoles saveUserRoles(UserRoles userRoles) {
        return userRolesRepository.save(userRoles);
    }

    @Override
    public Optional<Principals> findUserByPhone(String cellphonenumber) {
        return principalsRepository.findByCellPhoneNumber(cellphonenumber);
    }


    @Override
    public String generateMembershipNo() {
        String results = "";
        SimpleDateFormat sdf = new SimpleDateFormat(orderProcessingProperties.getMembershipNoFormatString(), orderProcessingProperties.getLocale());


        try {
            results = sdf.format(new Date());
            Logger.getLogger(this.getClass().getName()).log(Level.FINE, results);


        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }

        return results;
    }

    @Override
    public Iterable<Principals> findAllUsers() {
        return principalsRepository.findAll();
    }

    @Override
    public Page<Principals> listPrincipalsByPage(Integer pageNumber, Integer pageSize) {
        Sort sortByPostDateDesc = new Sort(Sort.Direction.DESC, "createdon");
        PageRequest pageRequest = new PageRequest(pageNumber, pageSize, sortByPostDateDesc);
        return principalsRepository.findAll(pageRequest);
    }
}
