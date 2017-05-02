package org.muhia.app.psi.portal.service.orchestrate.impl;

import org.hibernate.exception.ConstraintViolationException;
import org.muhia.app.psi.config.CustomUtilities;
import org.muhia.app.psi.config.integ.properties.ObopayKeProperties;
import org.muhia.app.psi.config.menu.ussd.MenuMessages;
import org.muhia.app.psi.config.order.properties.OrderProcessingProperties;
import org.muhia.app.psi.config.org.properties.OrganizationProperties;
import org.muhia.app.psi.config.security.HashingImplementation;
import org.muhia.app.psi.config.security.properties.UserAccountStatus;
import org.muhia.app.psi.config.sms.properties.SmsKannelConnectorProperties;
import org.muhia.app.psi.orm.model.*;
import org.muhia.app.psi.portal.service.orchestrate.IIprsMethods;
import org.muhia.app.psi.portal.service.orchestrate.IServiceProvisioningActions;
import org.muhia.app.psi.portal.service.orm.*;
import org.muhia.app.psi.portal.service.sms.ISmsBrokerService;
import org.muhia.app.psi.portal.validation.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ValidationException;
import java.sql.Time;
import java.text.MessageFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
  Copyright 2015-2016 the original author or authors.
  <p>
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
  <p>
  http://www.apache.org/licenses/LICENSE-2.0
  <p>
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
  <p>
  <p>
  Generated on 29-Oct-16 10:11
 */

/**
 * @author Kenneth Muhia <muhia@muhia.org> on 29-Oct-16. for package
 *         org.muhia.app.psi.portal.service.orchestrate.impl
 */
@Service
public class ServiceProvisioningActions implements IServiceProvisioningActions {

    private final MenuMessages menuMessages;

    private final IPrincipalsService principalsService;

    private final IPrincipalTypesService principalTypesService;

    private final ITitlesService titlesService;

    private final ISmsBrokerService smsBrokerService;

    private final IWorkOrderProcessingService workOrderProcessingService;

    private final CustomUtilities utilities;

    private final SmsKannelConnectorProperties smsKannelConnectorProperties;

    private final OrderProcessingProperties orderProcessingProperties;
    private final IIprsMethods iprsMethods;

    private final AuthenticationManager authenticationManager;

    private final IBankingOperationsService bankingOperationsService;

    private final IInterestRateService interestRateService;

    private final IPaybackPeriodService payBackPeriodService;

    private final IPrincipalsLoansService loansService;

    private final IPrincipalsGuarantorService guarantorService;

    private final IPrincipalsSavingsTargetsService savingsTargetService;

    private final ISavingsTargetIntervalService savingsIntervalService;

    private final ISavingsTargetTypeService savingsTypeService;
    private final UserAccountStatus accountStatus;
    private final IRegistrationDetailsService registrationDetailsService;
    private final HashingImplementation hasher;


    private final IPrincipalsContributionsService contributionService;

    private final ObopayKeProperties keProperties;


    private final IMaxLimitService maxlimitService;
    private final ISmsNotificationService smsNotificationService;

    private final OrganizationProperties organizationProperties;
    private final IVerificationTokensService verificationTokensService;
    private final IUssdRequestsProcessorService requestService;

    @Autowired
    public ServiceProvisioningActions(MenuMessages menuMessages, IIprsMethods iprsMethods, IBankingOperationsService bankingOperationsService, IPrincipalsLoansService loansService, ISavingsTargetTypeService savingsTypeService, IPrincipalsSavingsTargetsService savingsTargetService, IPrincipalsService principalsService, IPrincipalTypesService principalTypesService, IPaybackPeriodService payBackPeriodService, ISmsNotificationService smsNotificationService, ITitlesService titlesService, ISmsBrokerService smsBrokerService, IWorkOrderProcessingService workOrderProcessingService, CustomUtilities utilities, IPrincipalsGuarantorService guarantorService, ISavingsTargetIntervalService savingsIntervalService, IMaxLimitService maxlimitService, OrganizationProperties organizationProperties, IVerificationTokensService verificationTokensService, ObopayKeProperties keProperties, IInterestRateService interestRateService, SmsKannelConnectorProperties smsKannelConnectorProperties, OrderProcessingProperties orderProcessingProperties, IUssdRequestsProcessorService requestService, AuthenticationManager authenticationManager, UserAccountStatus accountStatus, IRegistrationDetailsService registrationDetailsService, HashingImplementation hasher, IPrincipalsContributionsService contributionService) {
        this.menuMessages = menuMessages;
        this.iprsMethods = iprsMethods;
        this.bankingOperationsService = bankingOperationsService;
        this.loansService = loansService;
        this.savingsTypeService = savingsTypeService;
        this.savingsTargetService = savingsTargetService;
        this.principalsService = principalsService;
        this.principalTypesService = principalTypesService;
        this.payBackPeriodService = payBackPeriodService;
        this.smsNotificationService = smsNotificationService;
        this.titlesService = titlesService;
        this.smsBrokerService = smsBrokerService;
        this.workOrderProcessingService = workOrderProcessingService;
        this.utilities = utilities;
        this.guarantorService = guarantorService;
        this.savingsIntervalService = savingsIntervalService;
        this.maxlimitService = maxlimitService;
        this.organizationProperties = organizationProperties;
        this.verificationTokensService = verificationTokensService;
        this.keProperties = keProperties;
        this.interestRateService = interestRateService;
        this.smsKannelConnectorProperties = smsKannelConnectorProperties;
        this.orderProcessingProperties = orderProcessingProperties;
        this.requestService = requestService;
        this.authenticationManager = authenticationManager;
        this.accountStatus = accountStatus;
        this.registrationDetailsService = registrationDetailsService;
        this.hasher = hasher;
        this.contributionService = contributionService;
    }


    private List<String> fetchMessageParameters(SmsNotification notification) {
        List<String> results = new ArrayList<>();
        Optional<SmsNotification> optionalSmsNotification = Optional.ofNullable(notification);
        optionalSmsNotification.ifPresent(smsNotification -> {
            if (smsNotification.getPlaceHolder1() != null) {
                results.add(0, smsNotification.getPlaceHolder1());
            }
            if (smsNotification.getPlaceHolder2() != null) {
                results.add(1, smsNotification.getPlaceHolder2());
            }
            if (smsNotification.getPlaceHolder3() != null) {
                results.add(2, smsNotification.getPlaceHolder3());
            }
            if (smsNotification.getPlaceHolder4() != null) {
                results.add(3, smsNotification.getPlaceHolder4());
            }
            if (smsNotification.getPlaceHolder5() != null) {
                results.add(4, smsNotification.getPlaceHolder5());
            }
        });

        return results;
    }


    /*
     * TO DO check if number exists on mobile money
     */
    private String inviteRafiki(String phonenumber) {
        String results = "";
        if (existsOnMobileMoney(phonenumber)) {
            results = phonenumber;

        }
        return results;
    }

    @Transactional
    @Override
    public Map<?, ?> maishaBankLoanRequest(Map<String, String> serviceOrderInfo, ServiceRequests sr) {
        Map<String, Object> results = new HashMap<>();

        try {
            String phonenumber = serviceOrderInfo.get(orderProcessingProperties.getCellphonenumberKeyword());
            Map<String, Object> finalResults = results;
            principalsService.findUserByPhone(phonenumber).ifPresent(p -> {
                /**
                 * Do we have an accountnumber?
                 */


                if (!bankingOperationsService.findBankAccountsByUserId(p).isPresent()) {
                    /**
                     * Create a bank account for the user on correct Bank
                     */
                    ProductsMaster product = sr.getOrderNumber().getProductId();
                    bankingOperationsService.findBankChargesByProductId(product).ifPresent(bankCharges -> bankingOperationsService.findBanksByBankCharges(bankCharges).ifPresent(banks -> bankingOperationsService.findAccountTypesByAcctypecode(orderProcessingProperties.getMaishaLoansAccountType()).ifPresent(accountTypes -> bankingOperationsService.findBankBranchesById(orderProcessingProperties.getMaishaLoansBankBranchId()).ifPresent(bankBranches -> bankingOperationsService.findCurrenciesByCurrencycode(orderProcessingProperties.getKeMaishaLoansCurrencyCode()).ifPresent(currencies -> {
                        BankAccounts accounts = new BankAccounts();
                        accounts.setBankCode(banks);
                        accounts.setAccType(accountTypes);
                        accounts.setAccBalance(0L);
                        accounts.setApprovedBy(String.format("%s %s", menuMessages.getAppName(), menuMessages.getAppNameUser()));
                        accounts.setApprovedDate(new Time(new Date().getTime()));
                        accounts.setBranchCode(bankBranches);
                        accounts.setCreatedby(String.format("%s %s", menuMessages.getAppName(), menuMessages.getAppNameUser()));
                        accounts.setCreatedon(new Time(new Date().getTime()));
                        accounts.setCurrencyCode(currencies);
                        accounts.setUserId(p);
                        accounts.setIsActive(menuMessages.getStatusActive());
                        accounts.setAccNumber(String.format("%s-%s", orderProcessingProperties.getKeMaishaLoansAccountNumberPrefix(), p.getMembershipNo()));
                        accounts = bankingOperationsService.saveBankAccounts(accounts);
                        finalResults.putIfAbsent("BankAccount", accounts);
                        /**
                         * Create TransactionRequest
                         */
                        final TransactionRequests[] requests = {new TransactionRequests()};
                        BankAccounts finalAccounts = accounts;
                        bankingOperationsService.findTransactionCategoriesByTrantype(orderProcessingProperties.getMaishaLoansTransactionTypeName()).ifPresent(transactionCategories -> {
                            Long loanAmount = Long.valueOf(serviceOrderInfo.get(orderProcessingProperties.getKeMaishaLoanAmountKeyword()));
                            Long loanDuration = Long.valueOf(serviceOrderInfo.get(orderProcessingProperties.getKeMaishaLoanDurationKeyword()));
                            double loanCharges = bankCharges.getChargeType().getChargeTypeCode().equals(orderProcessingProperties.getKeMaishaBankChargesPercentageKeyword()) ? bankCharges.getChargeAmount() * 0.01 * loanAmount : bankCharges.getChargeAmount();
                            requests[0].setTrancategory(transactionCategories);
                            requests[0].setAccountnumber(finalAccounts);
                            requests[0].setCustomername(p.getFullname());
                            requests[0].setToaccount(p.getCellphonenumber());
                            requests[0].setFromaccount(orderProcessingProperties.getMaishaLoansFromAccountNumber());
                            requests[0].setTranamount(loanAmount);
                            requests[0].setRecordDate(new Date());
                            requests[0].setTeller(String.format("%s %s", menuMessages.getAppName(), menuMessages.getAppNameUser()));
                            requests[0].setApprovedby(String.format("%s %s", menuMessages.getAppName(), menuMessages.getAppNameUser()));
                            requests[0].setApprover(String.format("%s %s", menuMessages.getAppName(), menuMessages.getAppNameUser()));
                            requests[0].setCurrencycode(currencies);
                            requests[0].setNarration(orderProcessingProperties.getKeMaishaLoanNarration());
                            requests[0].setStatus(String.valueOf(orderProcessingProperties.getRequestStatusInitiated()));
                            requests[0].setTransactionStatus(orderProcessingProperties.getRequestStatusInitiated());
                            requests[0].setProvisioningRetries(orderProcessingProperties.getRequestProvisioningRetries());
                            requests[0].setCreatedBy(String.format("%s %s", menuMessages.getAppName(), menuMessages.getAppNameUser()));
                            requests[0].setCreatedon(new Date());
                            requests[0].setTransactionDuration(loanDuration);
                            requests[0].setTransactionCharges(loanCharges);
                            requests[0] = bankingOperationsService.saveTransactionRequests(requests[0]);
                            finalResults.putIfAbsent("requests", requests[0]);


                        });


                    })))));


                } else {
                    bankingOperationsService.findBankAccountsByUserId(p).ifPresent(bankAccounts -> {

                    });

                }
            });


        } catch (Exception e) {
            results = finaliseAndGenerateSmsMessage(e, sr, serviceOrderInfo);
        }
        return results;
    }

    @Override
    @Transactional
    public Map<?, ?> maishaBankMemberRegistration(Map<String, String> serviceOrderInfo, ServiceRequests sr) {
        Map<String, Object> results = new HashMap<>();
        final RegistrationDetails[] details = {new RegistrationDetails()};
        try {
            final String[] organizationName = {""};
            String[] registrationDocumentType = {""};
            Collection<UssdRequests> sessionUssdRequests = requestService.findUssdRequestsBySessionId(sr.getOrderNumber().getRemoteSessionId());
            /**
             * TODO: Externalise default Organozation
             */
            final Long[] orgId = {1L};
            sessionUssdRequests.stream().filter(u -> !u.getCode().isEmpty()).findFirst().ifPresent(ussdRequests -> requestService.fetchUssdCodesByUssdCode(ussdRequests.getCode()).ifPresent(ussdCodes -> orgId[0] = ussdCodes.getOrganization().getId()));

            orgId[0] = serviceOrderInfo.get(orderProcessingProperties.getOrderOrganizationKeyword()) == null ? orgId[0] : Long.valueOf(Long.parseLong(serviceOrderInfo.get(orderProcessingProperties.getOrderOrganizationKeyword())));
            registrationDetailsService
                    .findOrganizationsById(
                            orgId[0])
                    .ifPresent(organizations -> registrationDetailsService
                            .findFirstRegistrationDocsByDocuments(
                                    serviceOrderInfo.get(orderProcessingProperties.getIdnumbertypeKeyword()))
                            .ifPresent(registrationDocs -> {
                                details[0].setServiceRequest(sr);
                                details[0].setUserMsisdn(serviceOrderInfo.get(orderProcessingProperties.getCellphonenumberKeyword()));
                                details[0].setAcceptedTerms(Integer.valueOf(serviceOrderInfo.get(orderProcessingProperties.getOrderAcceptedTermsKeyword())));
//                                SimpleDateFormat sdf = new SimpleDateFormat(orderProcessingProperties.getOrderTermsacceptedDateSdf());
//                                ParsePosition pos = new ParsePosition(0);
//                                Date acceptedTermsDate = new Date();
                                details[0].setAcceptedTermsDate(new Date());
                                /**
                                 * TODO: Ensure that session_id is indexed, check for performance constraints here, also explore caching.
                                 * TODO: Test for a scenario where accepted terms is not agreed(1)
                                 */
                                requestService.findUssdRequestsBySessionId(sr.getOrderNumber().getRemoteSessionId()).stream().filter(u -> u.getVarFld4() != null).filter(u -> u.getVarFld4().equals(orderProcessingProperties.getOrderAcceptedTermsKeyword())).findFirst().ifPresent(ussdRequests -> {
                                    details[0].setAcceptedTermsDate(ussdRequests.getRequestDate());
                                });


                                details[0].setFirstName(serviceOrderInfo.get(orderProcessingProperties.getOrderFirstnameKeyword()));
                                details[0].setLastName(serviceOrderInfo.get(orderProcessingProperties.getOrderLastnameKeyword()));
                                details[0].setMiddleName(serviceOrderInfo.get(orderProcessingProperties.getOrderMiddlenameKeyword()));
                                organizationName[0] = organizations.getOrganization();
                                registrationDocumentType[0] = registrationDocs.getDocuments();
                                details[0].setOrganisation(organizations);
                                details[0].setUserIdDocType(registrationDocs);
                                details[0].setUserIdNumber(serviceOrderInfo.get(orderProcessingProperties.getIdnumberKeyword()));
                                details[0].setRegistrationDate(new Date());
                                String otp = principalsService.generateOneTimePin();
                                details[0].setUserPin(hasher.getEncryptedValue(otp));
                                details[0].setUserRegistrationStatus(orderProcessingProperties.getOrderUserregistrationInitialStatus());
                                details[0].setVersion(orderProcessingProperties.getOrderUserregistrationInitialStatus());
                                details[0].setCreatedby(menuMessages.getAppName() + " " + menuMessages.getAppNameUser());
                                details[0].setCreatedon(new Date());
                                /**
                                 Save details currently input before validation
                                 */
                                final RegistrationDetails[] tmpDetails = {registrationDetailsService.save(details[0])};
                                /**
                                 Invoke IPRS Check for details entered;
                                 */
                                tmpDetails[0] = compareIprsWithDetails(tmpDetails[0]);
                                /**
                                 IPRS check ok, proceed to enable the user to login
                                 */
                                AtomicInteger iprsStatus = new AtomicInteger(0);
                                registrationDetailsService.findRegistrationDetailsByServiceRequestAndUserRegistrationStatus(sr, orderProcessingProperties.getOrderUserregistrationIprsOkStatus()).ifPresent(registrationDetails -> {
                                    Principals p = new Principals();
                                    p.setCellphonenumber(registrationDetails.getUserMsisdn());
                                    p.setCreatedon(new Date());
                                    p.setCreatedby(menuMessages.getAppNameUser());
                                    p.setCredentials(registrationDetails.getUserPin());
                                    serviceOrderInfo.put(menuMessages.getOtpKeyword(), hasher.getDecryptedValue(registrationDetails.getUserPin()));
                                    p.setEmailaddress(menuMessages.getAppEmail());
                                    String mname = registrationDetails.getMiddleName().length() > 1 ? registrationDetails.getMiddleName() + " " : "";
                                    p.setFullname(registrationDetails.getFirstName() + " " + mname + registrationDetails.getLastName());
                                    //p.setStatus(10);
                                    p.setStatus(accountStatus.getAccountsLocked());
                                    p.setLoginName(registrationDetails.getUserMsisdn());
                                    p.setPrefferredName(registrationDetails.getFirstName() + " " + mname + registrationDetails.getLastName());
                                    // p.setMembershipno(serviceOrderInfo.get(orderProcessingProperties.getMembershipnoKeyword()==null?principalsService.generateMembershipNo():serviceOrderInfo.get(orderProcessingProperties.getMembershipnoKeyword())));
                                    String membershipno = serviceOrderInfo.get(orderProcessingProperties.getMembershipnoKeyword()) == null ? principalsService.generateMembershipNo() : serviceOrderInfo.get(orderProcessingProperties.getMembershipnoKeyword());
                                    p.setPrincipalType(principalTypesService.findPrincipalTypesByPrincipalType(menuMessages.getUssdUserType()));
                                    p.setMembershipNo(membershipno);
                                    p.setTitle(titlesService.findTitleById(Long.valueOf("1")));
                                    p.setRegistrationDetails(registrationDetails);

                                    UserRoles roles = new UserRoles(p, principalsService.findRolesByRolename(menuMessages.getUssdUserRole()), 1);

                                    try {
                                        p = principalsService.registerNewUser(p);
                                        iprsStatus.addAndGet(1);
                                        results.put(menuMessages.getUserParameterKey(), p);
                                        roles = principalsService.saveUserRoles(roles);
                                        results.putIfAbsent(menuMessages.getRoleParameterKey(), roles);
                                        List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getSuccessSms());
                                        String successSmsStr = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getSuccessSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);
                                        registrationDetails.setLoginActivationDate(new Date());
                                        registrationDetails.setUserRegistrationStatus(orderProcessingProperties.getOrderUserregistrationSuccessStatus());


                                        successSmsStr = successSmsStr.replace(menuMessages.getFullNameKeyword(), p.getFullname());
                                        successSmsStr = successSmsStr.replace(menuMessages.getOtpKeyword(), otp);

                                        String senderCode = sr.getOrderNumber().getProductId().getSuccessSms().getSender() != null ? sr.getOrderNumber().getProductId().getSuccessSms().getSender() : smsKannelConnectorProperties.getSender();
                                        SmsRegistry smsRegistry = smsBrokerService.registerSmsForSending(successSmsStr, p.getCellphonenumber(), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
                                        results.put(menuMessages.getSmsParameterKey(), smsRegistry);

                                        sr.setStatus(orderProcessingProperties.getSrProcessedStatus());
                                    } catch (EmailExistsException e) {
                                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage());
                                        sr.setStatus(orderProcessingProperties.getSrFailedStatus());
                                        sr.setResponseMessage(e.getMessage());
                                        List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getFailureSms());
                                        registrationDetails.setUserRegistrationStatus(orderProcessingProperties.getOrderUserregistrationFailureStatus());
                                        registrationDetails.setModifiedby("Subscriber Validation Failed");
                                        registrationDetails.setModifiedOn(new Date());
                                        iprsStatus.addAndGet(3);

                                        /**
                                         * Format SMS
                                         */
                                        String failureSmsStr = utilities.addParametersToMessage(orderProcessingProperties.getDuplicateRegistration(), placeHolders.toArray(), serviceOrderInfo);
                                        String senderCode = sr.getOrderNumber().getProductId().getFailureSms().getSender() != null ? sr.getOrderNumber().getProductId().getFailureSms().getSender() : smsKannelConnectorProperties.getSender();

                                        SmsRegistry smsRegistry = smsBrokerService.registerSmsForSending(failureSmsStr, p.getCellphonenumber(), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
                                        results.putIfAbsent(menuMessages.getSmsParameterKey(), smsRegistry);
                                    } catch (NumberFormatException e) {
                                        registrationDetails.setUserRegistrationStatus(orderProcessingProperties.getOrderUserregistrationIprsNokStatus());
                                        registrationDetails.setModifiedby("Invalid Msisdn");
                                        registrationDetails.setModifiedOn(new Date());
                                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                                        sr.setStatus(orderProcessingProperties.getSrFailedStatus());
                                        sr.setResponseMessage(e.getMessage());

                                        /**
                                         * Format SMS
                                         */
                                        List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getFailureSms());

                                        String failureSmsStr = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getFailureSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);
                                        String senderCode = sr.getOrderNumber().getProductId().getFailureSms().getSender() != null ? sr.getOrderNumber().getProductId().getFailureSms().getSender() : smsKannelConnectorProperties.getSender();

                                        SmsRegistry smsRegistry = smsBrokerService.registerSmsForSending(failureSmsStr, p.getCellphonenumber(), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
                                        iprsStatus.addAndGet(4);
                                        results.putIfAbsent(menuMessages.getSmsParameterKey(), smsRegistry);
                                    }
                                    details[0] = registrationDetailsService.save(registrationDetails);

                                });
                                if (iprsStatus.equals(new AtomicInteger(0))) {
                                    /**
                                     * IPRS Registration failed
                                     */

                                    sr.setStatus(orderProcessingProperties.getSrFailedStatus());

                                    List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getFailureSms());
                                    details[0].setUserRegistrationStatus(orderProcessingProperties.getOrderUserregistrationFailureStatus());
                                    details[0].setModifiedby("Subscriber IPRS Validation Failed");
                                    details[0].setModifiedOn(new Date());

                                    /**
                                     * Format SMS
                                     */
                                    String failureSmsStr = utilities.addParametersToMessage(orderProcessingProperties.getDuplicateRegistration(), placeHolders.toArray(), serviceOrderInfo);
                                    String senderCode = sr.getOrderNumber().getProductId().getFailureSms().getSender() != null ? sr.getOrderNumber().getProductId().getFailureSms().getSender() : smsKannelConnectorProperties.getSender();
                                    sr.setResponseMessage(failureSmsStr);
                                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, failureSmsStr);

                                    SmsRegistry smsRegistry = smsBrokerService.registerSmsForSending(failureSmsStr, details[0].getUserMsisdn(), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
                                    results.putIfAbsent(menuMessages.getSmsParameterKey(), smsRegistry);
                                }

                            }));

            /**
             * TODO: Consider making use of the Strings above Registration Docs/Organization to ensure that setup is correctly done
             */

            results.putIfAbsent(orderProcessingProperties.getOrderUserregistrationKeyword(), details[0]);
            results.putIfAbsent("sr", workOrderProcessingService.saveServiceRequest(sr));

//            return results;


        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            sr.setStatus(orderProcessingProperties.getSrFailedStatus());
            sr.setResponseMessage(e.getMessage());
            List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getFailureSms());

            String failureSmsStr = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getFailureSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);
            String senderCode = sr.getOrderNumber().getProductId().getFailureSms().getSender() != null ? sr.getOrderNumber().getProductId().getFailureSms().getSender() : smsKannelConnectorProperties.getSender();

            SmsRegistry smsRegistry = smsBrokerService.registerSmsForSending(failureSmsStr, sr.getOrderNumber().getSubno(), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
            results.putIfAbsent(menuMessages.getSmsParameterKey(), smsRegistry);

        }

        return results;
    }

    private RegistrationDetails compareIprsWithDetails(RegistrationDetails tmpDetails) {
        /*
          TODO: IPRS Integration
         */
        return iprsMethods.validateKycInformation(tmpDetails);
    }

    @Override
    @Transactional
    public Map<?, ?> saccoMemberRegistration(Map<String, String> serviceOrderInfo, ServiceRequests sr) {
        Map<String, Object> results = new HashMap<>();
        // Map<String, String> smsInfoMap = new HashMap<>();
        Principals p = new Principals();
        results.putIfAbsent(p.getClass().getName(), p);


        return results;
    }

    /**
     * Checks that the cellphone number is registered to the same subscriber on
     * mobile money. *
     *
     * @param cellphonenumber Subscriber cellphone number
     * @return Validaton Status
     */
    @Override
    public boolean existsOnMobileMoney(String cellphonenumber) {
        /*
         * TODO: Implement Validation code
		 */
        return true;
    }

    @Override
    @Transactional
    public Map<?, ?> memberPasswordChange(Map<String, String> serviceOrderInfo, ServiceRequests sr) {
        Map<String, Object> results = new HashMap<>();

        try {
            /**
             * Check that passwords entered match
             *
             */
            String newPin, confirmNewPin;
            /**
             * TODO: Validate the new password based on some rules
             * TODO: Should we check history?
             * TODO: Externalise failure messages
             */
            newPin = serviceOrderInfo.get(orderProcessingProperties.getNewOtpPinKeyword()) != null ? serviceOrderInfo.get(orderProcessingProperties.getNewOtpPinKeyword()) : "";
            confirmNewPin = serviceOrderInfo.get(orderProcessingProperties.getConfirmNewOtpPinKeyword()) != null ? serviceOrderInfo.get(orderProcessingProperties.getConfirmNewOtpPinKeyword()) : "";

            if (!newPin.equals("")) {
                /**
                 * Empty new PIN received, fail the request
                 */
                throw new ValidationException("Empty PIN received");

            } else {
                if (!newPin.equals(confirmNewPin)) {
                    /**
                     * Passwords do not match
                     */
                    throw new ValidationException("Passwords do not match");
                }
                if (newPin.length() < 6) {
                    /**
                     * TODO: Externalize PIN length
                     * Too short
                     */
                    throw new ValidationException("Passwords do not meet the required length");

                }


            }
            Logger.getLogger(this.getClass().getName()).log(Level.FINE, MessageFormat.format("number {0} and pin {1}", sr.getOrderNumber().getSubno(), serviceOrderInfo.get("oldOtpPin")));

            /**
             * TODO: What should be done when an account is not enabled
             */
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(serviceOrderInfo.get(orderProcessingProperties.getCellphonenumberKeyword()), serviceOrderInfo.get(orderProcessingProperties.getOldOtpPinKeyword()));
            Authentication auth = authenticationManager.authenticate(token);
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, auth.getPrincipal().toString());


        } catch (ValidationException e) {
            List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getFailureSms());
            String failureSms = String.format("%s Message: %s", utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getFailureSms().getDescription(), placeHolders.toArray(), serviceOrderInfo), e.getMessage());

            String senderCode = sr.getOrderNumber().getProductId().getFailureSms().getSender() != null ? sr.getOrderNumber().getProductId().getSuccessSms().getSender() : smsKannelConnectorProperties.getSender();
            SmsRegistry smsRegistry = smsBrokerService.registerSmsForSending(failureSms, orderProcessingProperties.getCellphonenumberKeyword(), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
            results.putIfAbsent(menuMessages.getSmsParameterKey(), smsRegistry);

            sr.setStatus(orderProcessingProperties.getSrFailedStatus());
            sr.setResponseMessage(e.getMessage());

        } catch (LockedException e) {
            /*
            * TODO: Authentication exception thrown since the account is locked. find a way to remedy this*/
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);

            Optional<Principals> p = Optional.ofNullable(principalsService.findByLoginName(serviceOrderInfo.get(orderProcessingProperties.getCellphonenumberKeyword())));


            if (!p.isPresent()) {
                List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getSuccessSms());
                String failureSmsStr = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getFailureSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);
                String senderCode = sr.getOrderNumber().getProductId().getSuccessSms().getSender() != null ? sr.getOrderNumber().getProductId().getSuccessSms().getSender() : smsKannelConnectorProperties.getSender();
                SmsRegistry smsRegistry = smsBrokerService.registerSmsForSending(failureSmsStr, sr.getOrderNumber().getSubno(), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);


                results.putIfAbsent(menuMessages.getSmsParameterKey(), smsRegistry);

            } else {
                p.ifPresent(user -> {


                    user = principalsService.changeUserPasswordAndEnableAccount(user, serviceOrderInfo.get(orderProcessingProperties.getNewOtpPinKeyword()), menuMessages.getAppName() + " " + menuMessages.getAppNameUser());
                    results.putIfAbsent(menuMessages.getUserParameterKey(), user);
                    List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getSuccessSms());
                    String successSmsStr = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getSuccessSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);

                    String senderCode = sr.getOrderNumber().getProductId().getSuccessSms().getSender() != null ? sr.getOrderNumber().getProductId().getSuccessSms().getSender() : smsKannelConnectorProperties.getSender();
                    SmsRegistry smsRegistry = smsBrokerService.registerSmsForSending(successSmsStr, user.getCellphonenumber(), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);

                    results.putIfAbsent(menuMessages.getUserParameterKey(), user);
                    results.putIfAbsent(menuMessages.getSmsParameterKey(), smsRegistry);

                    sr.setStatus(orderProcessingProperties.getSrProcessedStatus());

                });
            }


        } catch (Exception e) {
            List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getFailureSms());
            String successSmsStr = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getFailureSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);

            String senderCode = sr.getOrderNumber().getProductId().getFailureSms().getSender() != null ? sr.getOrderNumber().getProductId().getSuccessSms().getSender() : smsKannelConnectorProperties.getSender();
            SmsRegistry smsRegistry = smsBrokerService.registerSmsForSending(successSmsStr, orderProcessingProperties.getCellphonenumberKeyword(), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
            results.putIfAbsent(menuMessages.getSmsParameterKey(), smsRegistry);

            sr.setStatus(orderProcessingProperties.getSrFailedStatus());
            sr.setResponseMessage(e.getMessage());

        }

        results.put("SR", workOrderProcessingService.saveServiceRequest(sr));

        return results;

    }

    @Override
    @Transactional
    public Map<?, ?> guarantorRequest(Map<String, String> serviceOrderInfo, ServiceRequests sr) {
        Map<String, Object> results = new HashMap<>();
        try {
            Optional<Principals> requestor = principalsService.findUserByPhone(sr.getOrderNumber().getSubno());
            Optional<Principals> guarantor = principalsService.findUserByPhone(serviceOrderInfo.get(orderProcessingProperties.getPhonenumberKeyword()));
            PrincipalsLoans loan = loansService.findLoanById(Long.decode(serviceOrderInfo.get(orderProcessingProperties.getLoanIdKeyword())));
            if (!guarantor.isPresent()) {
                String invitestatus = inviteRafiki(serviceOrderInfo.get(orderProcessingProperties.getPhonenumberKeyword()));
                results.putIfAbsent("rafiki", invitestatus);
            }
            requestor.ifPresent(r -> guarantor.ifPresent(gg -> {
                Optional<PrincipalsGuarantor> previousrequest = guarantorService.findGuarantorRequestPerLoan(r, loan, gg);
                if (previousrequest.isPresent()) {
                    // to do request already sent
                    sr.setStatus(orderProcessingProperties.getSrFailedStatus());
                    sr.setResponseMessage("Request already sent");
                    List<String> placeHolders = fetchMessageParameters(smsNotificationService.findById(23L));
                    String successSmsStr = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getSuccessSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);
                    /*

					 * Just in case something went wrong up here
                     */
                    successSmsStr = successSmsStr.replace(menuMessages.getFullNameKeyword(), r.getFullname());

                    String senderCode = smsKannelConnectorProperties.getSender();
                    SmsRegistry smsRegistry = smsBrokerService.registerSmsForSending(successSmsStr, r.getCellphonenumber(), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
                    results.put(menuMessages.getSmsParameterKey(), smsRegistry);

                } else {

                    PrincipalsGuarantor g = new PrincipalsGuarantor();
                    //g.setCreatedon(new Date());
                    g.setStatus(orderProcessingProperties.getPendingStatus());
                    g.setPrincipal(r);
                    g.setGuarantor(gg);
                    g.setLoan(loan);

                    g.setAmmountrequested(Integer.parseInt(serviceOrderInfo.get(orderProcessingProperties.getAmountRequestedKeyword())));

                    guarantorService.savePrincipalGuarantors(g);
                    sr.setStatus(orderProcessingProperties.getSrProcessedStatus());
                    List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getSuccessSms());

                    String successSmsStr = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getSuccessSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);

                    String senderCode = sr.getOrderNumber().getProductId().getSuccessSms().getSender() != null ? sr.getOrderNumber().getProductId().getSuccessSms().getSender() : smsKannelConnectorProperties.getSender();
                    SmsRegistry smsRegistry = smsBrokerService.registerSmsForSending(successSmsStr, serviceOrderInfo.get(orderProcessingProperties.getCellphonenumberKeyword()), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
                    results.put(menuMessages.getSmsParameterKey(), smsRegistry);
                }
            }));
        } catch (NumberFormatException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, String.format("NumberFormatException%s", e.getMessage()), e);
            sr.setStatus(orderProcessingProperties.getSrFailedStatus());
            sr.setResponseMessage(e.getMessage());

            /*
             * Format SMS
             */
            List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getFailureSms());

            String failureSmsStr = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getFailureSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);
            String senderCode = sr.getOrderNumber().getProductId().getFailureSms().getSender() != null ? sr.getOrderNumber().getProductId().getFailureSms().getSender() : smsKannelConnectorProperties.getSender();

            SmsRegistry smsRegistry = smsBrokerService.registerSmsForSending(failureSmsStr, sr.getOrderNumber().getSubno(), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
            results.putIfAbsent(menuMessages.getSmsParameterKey(), smsRegistry);
        }

        workOrderProcessingService.saveServiceRequest(sr);
        return results;

    }

    @Override
    @Transactional
    public Map<?, ?> loanRequest(Map<String, String> serviceOrderInfo, ServiceRequests sr) {
        Map<String, Object> results = new HashMap<>();
        try {
            Optional<Principals> loggedInUser = principalsService.findUserByPhone(sr.getOrderNumber().getSubno());

            loggedInUser.ifPresent(user -> {

                Logger.getLogger(this.getClass().getName()).log(Level.INFO, MessageFormat.format("charging value#: {0} ", sr.getChargingValue()));
                Collection<PrincipalsLoans> previousLoan = loansService.findLoanByPrincipal(user);

                // checking if you have an unpaid loan
                boolean notpaid = false;
                if (!previousLoan.isEmpty()) {

                    for (PrincipalsLoans loan : previousLoan) {
                        if (loan.getStatus() != 5) {
                            notpaid = true;
                        }
                    }
                }
                if (notpaid) {
                    // You have not paid previous loans
                    sr.setStatus(orderProcessingProperties.getSrFailedStatus());
                    sr.setResponseMessage("You have a loan which is not paid");

                    String successSmsStr = smsNotificationService.findById(22L).getDescription();
                    /*
                     * Just in case something went wrong up here
                     */
                    successSmsStr = successSmsStr.replace(menuMessages.getFullNameKeyword(), user.getFullname());

                    String senderCode = smsKannelConnectorProperties.getSender();
                    SmsRegistry smsRegistry = smsBrokerService.registerSmsForSending(successSmsStr, user.getCellphonenumber(), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
                    results.put(menuMessages.getSmsParameterKey(), smsRegistry);

                } else {
                    //check if the amount requested
                    /*
                    * TODO : externalize minimum amount
                     */
                    if (Integer.parseInt(serviceOrderInfo.get(orderProcessingProperties.getAmountLoanedKeyword())) < 1000) {

                        String senderCode = smsKannelConnectorProperties.getSender();
                        SmsRegistry smsRegistry = smsBrokerService.registerSmsForSending(smsNotificationService.findById(43L).getDescription(), user.getCellphonenumber(), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
                        results.put(menuMessages.getSmsParameterKey(), smsRegistry);
                    }
                    //loan request is above 1000
                    else {
                        PrincipalsLoans loan = new PrincipalsLoans();
                        InterestRate rate = this.interestRateService.findActiveInterest();
                        PayBackPeriod period = this.payBackPeriodService.findActivePayBackPeriod();
                        // the compound rate formulae
                        double amountloaned = Integer.parseInt(serviceOrderInfo.get(orderProcessingProperties.getAmountLoanedKeyword())) * (Math.pow(1 + (rate.getRate() / 100.0), (double) period.getPaybackperiod()));
                        Long payback = Math.round(amountloaned);
                        // remove our fee
                        //Long netpayback = payback - Long.decode(sr.getChargingValue());

                        loan.setPrincipal(user);
                        loan.setSr(sr);
                        loan.setAmountloaned(Long.decode(serviceOrderInfo.get(orderProcessingProperties.getAmountLoanedKeyword())));
                        loan.setInterest(rate);
                        //loan.setCreatedon(new Date());
                        loan.setMaxLimit(maxlimitService.getActiveLimit(1));
                        loan.setPaybackperiod(period);
                        loan.setPaybackamount(payback);
                    /*
                     * DONE: Do we need the fee?
                     */
                        //  double maxlimit = contributionService.getMaxLimit(user);
                    /*
                     * TODO: does the loan require guarantors?
                     */

//                        if (maxlimit >= Integer.parseInt(serviceOrderInfo.get(orderProcessingProperties.getAmountLoanedKeyword()))) {
//                            loan.setLoanapprovedon(new Date());
//                            loan.setStatus(orderProcessingProperties.getLoanApprovedStatus());
//
//                            workOrderProcessingService.createRecurringOrderRecordFromServiceRequest(sr, serviceOrderInfo.get(orderProcessingProperties.getAmountLoanedKeyword()), loansService.addPayBackDays(new Date(), period.getPaybackperiod().intValue()), sr.getOrderNumber().getProductId());
//
//                        }
//                        else {
//                            // requires guarantors
//                            loan.setStatus(orderProcessingProperties.getGuarantorStatus());
//                            // sms notification for adding guarantor
//                            List<String> placeHolders = fetchMessageParameters(smsNotificationService.findById(21L));
//                            String successSmsStr = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getSuccessSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);
//
//                            successSmsStr = successSmsStr.replace(menuMessages.getFullNameKeyword(), user.getFullname());
//
//                            String senderCode = smsKannelConnectorProperties.getSender();
//                            SmsRegistry smsRegistry = smsBrokerService.registerSmsForSending(successSmsStr, user.getCellphonenumber(), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
//                            results.put(menuMessages.getSmsParameterKey(), smsRegistry);
//
//                        }

                        loansService.savePrincipalsLoan(loan);
                        sr.setStatus(orderProcessingProperties.getSrProcessedStatus());
                        workOrderProcessingService.saveServiceRequest(sr);
                        List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getSuccessSms());

                        String successSmsStr = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getSuccessSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);

                        String senderCode = sr.getOrderNumber().getProductId().getSuccessSms().getSender() != null ? sr.getOrderNumber().getProductId().getSuccessSms().getSender() : smsKannelConnectorProperties.getSender();
                        SmsRegistry smsRegistry = smsBrokerService.registerSmsForSending(successSmsStr, serviceOrderInfo.get(orderProcessingProperties.getCellphonenumberKeyword()), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
                        results.put(menuMessages.getSmsParameterKey(), smsRegistry);

                    /*
                     * Process AM CashOutResponse
                     */
//                        if (maxlimit >= Integer.parseInt(serviceOrderInfo.get(orderProcessingProperties.getAmountLoanedKeyword()))) {
//                            try {
//
//                                workOrderProcessingService.airtelMoneyTransaction(netpayback, keProperties.getCashInTransactionCode(), serviceOrderInfo.get(orderProcessingProperties.getOrderNumberKeyword()) + principalsService.generateMembershipNo(), sr.getOrderNumber().getSubno());
//
//                            } catch (Exception e) {
//                                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
//
//                            }
//
//                        }

                    }


                }
            });
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            sr.setResponseMessage(e.getMessage());
            sr.setStatus(orderProcessingProperties.getSrFailedStatus());

            /*
             * Format SMS
             */
            List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getFailureSms());

            String failureSmsStr = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getFailureSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);
            String senderCode = sr.getOrderNumber().getProductId().getFailureSms().getSender() != null ? sr.getOrderNumber().getProductId().getFailureSms().getSender() : smsKannelConnectorProperties.getSender();

            SmsRegistry smsRegistry = smsBrokerService.registerSmsForSending(failureSmsStr, sr.getOrderNumber().getSubno(), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
            results.putIfAbsent(menuMessages.getSmsParameterKey(), smsRegistry);
        }

        workOrderProcessingService.saveServiceRequest(sr);
        return results;

    }

    @Override
    @Transactional
    public Map<?, ?> guaranteeApprove(Map<String, String> serviceOrderInfo, ServiceRequests sr) {
        Map<String, Object> results = new HashMap<>();

        PrincipalsGuarantor p = guarantorService.findPrincipalGuarantorsById(Long.decode(serviceOrderInfo.get("requestid")));
        try {

            p.setStatus(orderProcessingProperties.getGuarantorApprovedStatus());
            p.setApproveddeclinedon(new Date());
            p.setAmmountguaranteed(Integer.parseInt(serviceOrderInfo.get(orderProcessingProperties.getAmountApprovedKeyword())));
            guarantorService.updatePrincipalGuarantors(p);
            sr.setStatus(orderProcessingProperties.getSrProcessedStatus());
            workOrderProcessingService.saveServiceRequest(sr);

            /*

			 * We need to check if amount is enough to approve loan then give
			 * maxlimit + guarantor amount
             */
            if (guarantorService.isGuaranteedAmountEnough(p)) {
                int total = 0;
                final Collection<PrincipalsGuarantor> guarantors = guarantorService.findPrincipalGuarantorByloan(p.getPrincipal(), p.getLoan());
                for (PrincipalsGuarantor guarantor : guarantors) {
                    if (guarantor.getStatus() == orderProcessingProperties.getGuarantorApprovedStatus()) {
                        total = total + guarantor.getAmmountguaranteed();

                        String status = workOrderProcessingService.airtelMoneyTransaction((long) guarantor.getAmmountguaranteed(), keProperties.getCashOutTransactionCode(), serviceOrderInfo.get(orderProcessingProperties.getOrderNumberKeyword()) + principalsService.generateMembershipNo(), guarantor.getGuarantor().getCellphonenumber());

                        assert status != null;
                        if (status.equals("0")) {
                            PrincipalsLoans approvedLoan = loansService.findLoanById(p.getLoan().getId());
                            approvedLoan.setLoanedapprovedon(new Date());
                            approvedLoan.setStatus(3);
                            loansService.updatePrincipalsLoan(approvedLoan);
                            Long netTransactionAmount = approvedLoan.getAmountloaned() - Long.decode(sr.getChargingValue());
                            //
                            workOrderProcessingService.airtelMoneyTransaction(netTransactionAmount, keProperties.getCashInTransactionCode(), serviceOrderInfo.get(orderProcessingProperties.getOrderNumberKeyword()) + principalsService.generateMembershipNo(), approvedLoan.getPrincipal().getCellphonenumber());

                        }
                    }
                }

            }

            /*
             * Format SMS
             */
            List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getSuccessSms());
            String successSmsStr = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getSuccessSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);
            /*
             * Just in case something went wrong up here
             */
            successSmsStr = successSmsStr.replace(menuMessages.getFullNameKeyword(), p.getGuarantor().getFullname());
            // successSmsStr =
            // successSmsStr.replace(menuMessages.getOtpKeyword(), otp);

            String senderCode = sr.getOrderNumber().getProductId().getSuccessSms().getSender() != null ? sr.getOrderNumber().getProductId().getSuccessSms().getSender() : smsKannelConnectorProperties.getSender();
            SmsRegistry smsRegistry = smsBrokerService.registerSmsForSending(successSmsStr, p.getGuarantor().getCellphonenumber(), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
            results.put(menuMessages.getSmsParameterKey(), smsRegistry);
            /*
             * send sms to loanee of status of gauarantor request
             */
            String notifyLoaneeStr = smsNotificationService.findById(25L).getDescription();
            String notifyLoaneeSms = String.format(notifyLoaneeStr, sr.getOrderNumber().getSubno(), p.getAmmountrequested());
            SmsRegistry smsRegistry1 = smsBrokerService.registerSmsForSending(notifyLoaneeSms, p.getPrincipal().getCellphonenumber(), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
            results.put(menuMessages.getSmsParameterKey(), smsRegistry1);

            sr.setStatus(orderProcessingProperties.getSrProcessedStatus());

        } catch (NumberFormatException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            sr.setStatus(orderProcessingProperties.getSrFailedStatus());
            sr.setResponseMessage(e.getMessage());
            sr.setCommandscompletedDate(new Date());

            /*
             * Format SMS
             */
            List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getFailureSms());

            String failureSmsStr = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getFailureSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);
            String senderCode = sr.getOrderNumber().getProductId().getFailureSms().getSender() != null ? sr.getOrderNumber().getProductId().getFailureSms().getSender() : smsKannelConnectorProperties.getSender();

            smsBrokerService.registerSmsForSending(failureSmsStr, p.getGuarantor().getCellphonenumber(), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
        }
        workOrderProcessingService.saveServiceRequest(sr);

        return results;

    }

    @Override
    @Transactional
    public Map<?, ?> guaranteeDecline(Map<String, String> serviceOrderInfo, ServiceRequests sr) {
        Map<String, Object> results = new HashMap<>();
        // Map<String, String> smsInfoMap = new HashMap<>();
        PrincipalsGuarantor p = guarantorService.findPrincipalGuarantorsById(Long.decode(serviceOrderInfo.get(orderProcessingProperties.getRequestIdKeyword())));
        try {
            p.setStatus(orderProcessingProperties.getGuarantorDeclinedStatus());
            p.setApproveddeclinedon(new Date());

            guarantorService.updatePrincipalGuarantors(p);
            sr.setStatus(orderProcessingProperties.getSrProcessedStatus());
            workOrderProcessingService.saveServiceRequest(sr);
            /*
             * Format SMS
             */
            List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getSuccessSms());
            String successSmsStr = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getSuccessSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);
            /*
             * Just in case something went wrong up here
             */
            successSmsStr = successSmsStr.replace(menuMessages.getFullNameKeyword(), p.getGuarantor().getFullname());
            // successSmsStr =
            // successSmsStr.replace(menuMessages.getOtpKeyword(), otp);

            String senderCode = sr.getOrderNumber().getProductId().getSuccessSms().getSender() != null ? sr.getOrderNumber().getProductId().getSuccessSms().getSender() : smsKannelConnectorProperties.getSender();
            SmsRegistry smsRegistry = smsBrokerService.registerSmsForSending(successSmsStr, p.getGuarantor().getCellphonenumber(), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
            results.put(menuMessages.getSmsParameterKey(), smsRegistry);
            /*
             * send sms to loanee of status of gauarantor request
             */
            String notifyLoaneeStr = smsNotificationService.findById(25L).getDescription();
            String notifyLoaneeSms = String.format(notifyLoaneeStr, sr.getOrderNumber().getSubno(), p.getAmmountrequested());
            SmsRegistry smsRegistry1 = smsBrokerService.registerSmsForSending(notifyLoaneeSms, p.getPrincipal().getCellphonenumber(), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
            results.put(menuMessages.getSmsParameterKey(), smsRegistry1);

            sr.setStatus(orderProcessingProperties.getSrProcessedStatus());

        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            sr.setCommandscompletedDate(new Date());
            sr.setStatus(orderProcessingProperties.getSrFailedStatus());
            sr.setResponseMessage(e.getMessage());

            /*
             * Format SMS
             */
            List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getFailureSms());

            String failureSmsStr = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getFailureSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);
            String senderCode = sr.getOrderNumber().getProductId().getFailureSms().getSender() != null ? sr.getOrderNumber().getProductId().getFailureSms().getSender() : smsKannelConnectorProperties.getSender();

            smsBrokerService.registerSmsForSending(failureSmsStr, p.getGuarantor().getCellphonenumber(), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
        }
        workOrderProcessingService.saveServiceRequest(sr);

        return results;
    }

    @Override
    @Transactional
    public Map<?, ?> setSavingsTarget(Map<String, String> serviceOrderInfo, ServiceRequests sr) {
        Map<String, Object> results = new HashMap<>();
        Optional<Principals> loggedInUser = principalsService.findUserByPhone(sr.getOrderNumber().getSubno());

        loggedInUser.ifPresent(u -> {
            try {
                SavingsInterval interval = savingsIntervalService.findById(Long.decode(serviceOrderInfo.get(orderProcessingProperties.getIntervalKeyword())));
                SavingsTargetType type = savingsTypeService.findById(Long.decode(serviceOrderInfo.get(orderProcessingProperties.getTypeKeyword())));
                PrincipalsSavingsTarget target = new PrincipalsSavingsTarget();
                target.setAmount(Long.parseLong(serviceOrderInfo.get(orderProcessingProperties.getAmountKeyword())));
                target.setTarget(Long.parseLong(serviceOrderInfo.get(orderProcessingProperties.getTargetKeyword())));
                target.setInterval(interval);
                target.setType(type);
                target.setServicerequest(sr);
                target.setPrincipal(u);
                target.setStatus(menuMessages.getStatusActive());
                //target.setCreatedon(new Date());
                savingsTargetService.createSavingsTarget(target);
                sr.setStatus(orderProcessingProperties.getSrProcessedStatus());
                Date txnDate = new Date();
                // calculate next transaction date
                /*
                 * TODO: Externalise all String values, no hard-coding
                 */
                switch (target.getInterval().getInterval()) {
                    case "Daily":
                        txnDate = loansService.addPayBackDays(new Date(), 1);
                        break;
                    case "Weekly":
                        txnDate = loansService.addPayBackDays(new Date(), 7);
                        break;
                    case "Monthly":
                        /*
                            TODO: Why two lines?
                         */
                        txnDate = loansService.addPayBackDays(new Date(), 30);
                        txnDate = loansService.addPayBackDays(new Date(), 30);
                        break;
                    default:
                        break;
                }
                workOrderProcessingService.createRecurringOrderRecordFromServiceRequest(sr, serviceOrderInfo.get(orderProcessingProperties.getAmountKeyword()), txnDate, sr.getOrderNumber().getProductId());

                List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getSuccessSms());
                String successSmsStr = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getSuccessSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);
                /*
                 * Just in case something went wrong up here
                 */
                successSmsStr = successSmsStr.replace(menuMessages.getFullNameKeyword(), u.getFullname());
                // successSmsStr =
                // successSmsStr.replace(menuMessages.getOtpKeyword(), otp);

                String senderCode = sr.getOrderNumber().getProductId().getSuccessSms().getSender() != null ? sr.getOrderNumber().getProductId().getSuccessSms().getSender() : smsKannelConnectorProperties.getSender();
                SmsRegistry smsRegistry = smsBrokerService.registerSmsForSending(successSmsStr, u.getCellphonenumber(), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
                results.put(menuMessages.getSmsParameterKey(), smsRegistry);

                sr.setStatus(orderProcessingProperties.getSrProcessedStatus());
            } catch (NumberFormatException e) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                sr.setResponseMessage(e.getMessage());
                sr.setCommandscompletedDate(new Date());
                sr.setStatus(orderProcessingProperties.getSrFailedStatus());
                List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getFailureSms());

                String failureSmsStr = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getFailureSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);
                String senderCode = sr.getOrderNumber().getProductId().getFailureSms().getSender() != null ? sr.getOrderNumber().getProductId().getFailureSms().getSender() : smsKannelConnectorProperties.getSender();

                smsBrokerService.registerSmsForSending(failureSmsStr, u.getCellphonenumber(), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
            }

        });

        workOrderProcessingService.saveServiceRequest(sr);

        return results;

    }

    @Override
    @Transactional
    public Map<?, ?> rafikiLoanRequest(Map<String, String> serviceOrderInfo, ServiceRequests sr) {
        Map<String, Object> results = new HashMap<>();
        Optional<Principals> loggedInUser = principalsService.findUserByPhone(serviceOrderInfo.get(orderProcessingProperties.getCellphonenumberKeyword()));
        Optional<Principals> lender = principalsService.findUserByPhone(serviceOrderInfo.get(orderProcessingProperties.getLenderPhoneKeyword()));
        PrincipalsLoans loan = new PrincipalsLoans();
        if (!lender.isPresent()) {
            String invitestatus = inviteRafiki(serviceOrderInfo.get(orderProcessingProperties.getPhonenumberKeyword()));
            results.putIfAbsent("rafiki", invitestatus);
        }
        // InterestRate rate = this.interestRateService.findActiveInterest();
        PayBackPeriod period = this.payBackPeriodService.findActivePayBackPeriod();
        loggedInUser.ifPresent(u -> {
            loan.setPrincipal(u);
            loan.setAmountloaned(Long.decode(serviceOrderInfo.get(orderProcessingProperties.getAmountLoanedKeyword())));

            loan.setPrincipal(u);

            loan.setMaxLimit(maxlimitService.getActiveLimit(1));
            //loan.setCreatedon(new Date());

            loan.setPaybackperiod(period);
            lender.ifPresent(loan::setLender);
            loansService.updatePrincipalsLoan(loan);
            sr.setStatus(orderProcessingProperties.getSrProcessedStatus());
            List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getSuccessSms());

            String successSmsStr = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getSuccessSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);

            String senderCode = sr.getOrderNumber().getProductId().getSuccessSms().getSender() != null ? sr.getOrderNumber().getProductId().getSuccessSms().getSender() : smsKannelConnectorProperties.getSender();
            SmsRegistry smsRegistry = smsBrokerService.registerSmsForSending(successSmsStr, serviceOrderInfo.get(orderProcessingProperties.getCellphonenumberKeyword()), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
            results.put(menuMessages.getSmsParameterKey(), smsRegistry);
        });
        workOrderProcessingService.saveServiceRequest(sr);
        return results;
    }

    @Override
    @Transactional
    public Map<?, ?> rafikiLoanDecline(Map<String, String> serviceOrderInfo, ServiceRequests sr) {
        PrincipalsLoans deniedLoan = loansService.findLoanById(Long.decode(serviceOrderInfo.get(orderProcessingProperties.getLoanIdKeyword())));

        Map<String, Object> results = new HashMap<>();
        Optional<Principals> loggedInUser = principalsService.findUserByPhone(serviceOrderInfo.get(orderProcessingProperties.getCellphonenumberKeyword()));

        loggedInUser.ifPresent(u -> {

            try {

                deniedLoan.setLoanedapprovedon(new Date());
                deniedLoan.setStatus(orderProcessingProperties.getLoanDeclinedStatus());
                loansService.updatePrincipalsLoan(deniedLoan);
                sr.setStatus(orderProcessingProperties.getSrProcessedStatus());
                List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getSuccessSms());
                String successSmsStr = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getSuccessSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);
                /*
                 * Just in case something went wrong up here
                 */
                successSmsStr = successSmsStr.replace(menuMessages.getFullNameKeyword(), u.getFullname());
                // successSmsStr =
                // successSmsStr.replace(menuMessages.getOtpKeyword(), otp);

                String senderCode = sr.getOrderNumber().getProductId().getSuccessSms().getSender() != null ? sr.getOrderNumber().getProductId().getSuccessSms().getSender() : smsKannelConnectorProperties.getSender();
                SmsRegistry smsRegistry = smsBrokerService.registerSmsForSending(successSmsStr, u.getCellphonenumber(), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
                results.put(menuMessages.getSmsParameterKey(), smsRegistry);
                /*
                 * send sms to loanee of status of loan
                 */
                String notifyLoaneeStr = smsNotificationService.findById(24L).getDescription();
                String notifyLoaneeSms = String.format(notifyLoaneeStr, sr.getOrderNumber().getSubno(), deniedLoan.getPaybackamount());
                SmsRegistry smsRegistry1 = smsBrokerService.registerSmsForSending(notifyLoaneeSms, deniedLoan.getPrincipal().getCellphonenumber(), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
                results.put(menuMessages.getSmsParameterKey(), smsRegistry1);

            } catch (Exception e) {
                /*
                    TODO: Check during testing if below snippet can be used to replace duplicated code
                 */
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                Map<String, Object> data = finaliseAndGenerateSmsMessage(e, sr, serviceOrderInfo);
                SmsRegistry smsRegistry = smsBrokerService.registerSmsForSending(data.get("failureSmsStr").toString(), u.getCellphonenumber(), data.get("senderCode").toString(), smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), (ServiceRequests) data.get("sr"));
                results.put(menuMessages.getSmsParameterKey(), smsRegistry);
            }

        });

        workOrderProcessingService.saveServiceRequest(sr);
        return results;

    }

    private Map<String, Object> finaliseAndGenerateSmsMessage(Exception e, ServiceRequests serviceRequests, Map<String, String> serviceOrderInfo) {
        Map<String, Object> result = new HashMap<>();
        serviceRequests.setStatus(orderProcessingProperties.getSrFailedStatus());
        serviceRequests.setResponseMessage(e.getMessage());
        serviceRequests.setCommandscompletedDate(new Date());

        result.putIfAbsent("sr", serviceRequests);

        List<String> placeHolders = fetchMessageParameters(serviceRequests.getOrderNumber().getProductId().getFailureSms());

        String failureSmsStr = utilities.addParametersToMessage(serviceRequests.getOrderNumber().getProductId().getFailureSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);
        result.putIfAbsent("failureSmsStr", failureSmsStr);
        String senderCode = serviceRequests.getOrderNumber().getProductId().getFailureSms().getSender() != null ? serviceRequests.getOrderNumber().getProductId().getFailureSms().getSender() : smsKannelConnectorProperties.getSender();
        result.putIfAbsent("senderCode", senderCode);

        return result;
    }

    @Override
    @Transactional
    public Map<?, ?> rafikiLoanApprove(Map<String, String> serviceOrderInfo, ServiceRequests sr) {
        PrincipalsLoans approvedLoan = loansService.findLoanById(Long.decode(serviceOrderInfo.get(orderProcessingProperties.getLoanIdKeyword())));

        Map<String, Object> results = new HashMap<>();
        Optional<Principals> loggedInUser = principalsService.findUserByPhone(serviceOrderInfo.get(orderProcessingProperties.getCellphonenumberKeyword()));
        InterestRate rate = this.interestRateService.findActiveInterest();
        PayBackPeriod period = this.payBackPeriodService.findActivePayBackPeriod();
        loggedInUser.ifPresent(u -> {
            try {

                approvedLoan.setLoanedapprovedon(new Date());
                approvedLoan.setStatus(orderProcessingProperties.getLoanApprovedStatus());
                approvedLoan.setPaybackamount(Long.decode(serviceOrderInfo.get(orderProcessingProperties.getAmountApprovedKeyword())));

                if (Boolean.parseBoolean(serviceOrderInfo.get(orderProcessingProperties.getInterestKeyword()))) {
                    approvedLoan.setInterest(rate);
                    double amountloaned = Integer.parseInt(serviceOrderInfo.get(orderProcessingProperties.getAmountLoanedKeyword())) / (Math.pow(1 + (rate.getRate() / 100.0), (double) period.getPaybackperiod()));
                    Long payback = Math.round(amountloaned);
                    approvedLoan.setAmountloaned(payback);
                    workOrderProcessingService.createRecurringOrderRecordFromServiceRequest(sr, Double.toString(amountloaned), loansService.addPayBackDays(new Date(), period.getPaybackperiod().intValue()), sr.getOrderNumber().getProductId());

                } else {
                    approvedLoan.setAmountloaned(Long.decode(serviceOrderInfo.get(orderProcessingProperties.getAmountApprovedKeyword())));
                    workOrderProcessingService.createRecurringOrderRecordFromServiceRequest(sr, serviceOrderInfo.get(orderProcessingProperties.getAmountApprovedKeyword()), loansService.addPayBackDays(new Date(), period.getPaybackperiod().intValue()), sr.getOrderNumber().getProductId());

                    approvedLoan.setLoanedapprovedon(new Date());
                    approvedLoan.setStatus(orderProcessingProperties.getLoanApprovedStatus());
                    loansService.updatePrincipalsLoan(approvedLoan);
                    sr.setStatus(orderProcessingProperties.getSrProcessedStatus());
                    List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getSuccessSms());
                    String successSmsStr = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getSuccessSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);

                    successSmsStr = successSmsStr.replace(menuMessages.getFullNameKeyword(), u.getFullname());
                    // successSmsStr =
                    // successSmsStr.replace(menuMessages.getOtpKeyword(), otp);

                    String senderCode = sr.getOrderNumber().getProductId().getSuccessSms().getSender() != null ? sr.getOrderNumber().getProductId().getSuccessSms().getSender() : smsKannelConnectorProperties.getSender();
                    SmsRegistry smsRegistry = smsBrokerService.registerSmsForSending(successSmsStr, u.getCellphonenumber(), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
                    results.put(menuMessages.getSmsParameterKey(), smsRegistry);
                    /*
                 * send sms to loanee of status of loan
                     */
                    String notifyLoaneeStr = smsNotificationService.findById(25L).getDescription();
                    String notifyLoaneeSms = String.format(notifyLoaneeStr, sr.getOrderNumber().getSubno(), approvedLoan.getPaybackamount());
                    SmsRegistry smsRegistry1 = smsBrokerService.registerSmsForSending(notifyLoaneeSms, approvedLoan.getPrincipal().getCellphonenumber(), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
                    results.put(menuMessages.getSmsParameterKey(), smsRegistry1);

                    sr.setStatus(orderProcessingProperties.getSrProcessedStatus());
                    workOrderProcessingService.saveServiceRequest(sr);
                    try {

                        String status = workOrderProcessingService.airtelMoneyTransaction(approvedLoan.getAmountloaned() - Long.decode(sr.getChargingValue()), keProperties.getCashOutTransactionCode(), serviceOrderInfo.get(orderProcessingProperties.getOrderNumberKeyword()) + principalsService.generateMembershipNo(), sr.getOrderNumber().getSubno());

                        assert status != null;
                        if (status.equals("0")) {
                            //
                            workOrderProcessingService.airtelMoneyTransaction(approvedLoan.getAmountloaned() - Long.decode(sr.getChargingValue()), keProperties.getCashInTransactionCode(), serviceOrderInfo.get(orderProcessingProperties.getOrderNumberKeyword()) + principalsService.generateMembershipNo(), approvedLoan.getPrincipal().getCellphonenumber());

                        }

                    } catch (NumberFormatException e) {
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);

                    }
                }
            } catch (NumberFormatException e) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                /*
                    TODO: Check during testing if below snippet can be used to replace duplicated code
                 */
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                Map<String, Object> data = finaliseAndGenerateSmsMessage(e, sr, serviceOrderInfo);
                SmsRegistry smsRegistry = smsBrokerService.registerSmsForSending(data.get("failureSmsStr").toString(), u.getCellphonenumber(), data.get("senderCode").toString(), smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), (ServiceRequests) data.get("sr"));
                results.put(menuMessages.getSmsParameterKey(), smsRegistry);
            }

        });

        workOrderProcessingService.saveServiceRequest(sr);
        results.put(orderProcessingProperties.getSrIdKeyword(), sr);

        return results;
    }


    @Override
    public Map<?, ?> generateAdminTaskToken(Map<String, String> serviceOrderInfo, ServiceRequests sr) {
        /*
            DONE:Check that the msisdn has the role admintasks assigned
		 */
        Map<String, Object> results = new HashMap<>();
        String phonenumber = serviceOrderInfo.get(orderProcessingProperties.getCellphonenumberKeyword());
        try {
            /*
                TODO: What happens when ifpresent is false, figure out a way to return useful messages, maybe run this on Java 9 Pre-release?
             */
            Optional<Principals> principalsOptional = principalsService.findUserByPhone(phonenumber);
            principalsOptional.ifPresent(principals -> {
                Optional<UserRoles> userRolesOptional = principalsService.findUserRolesByRoleid(principalsService.findRolesByRolename(menuMessages.getAdminRoleKeyword()));

                userRolesOptional.ifPresent(userRoles -> {
                    if (!principals.getAdmUserRolesCollection().contains(userRoles)) {
                        serviceOrderInfo.put(orderProcessingProperties.getErrorcodeKeyword(), orderProcessingProperties.getForbiddenKeyword());

                        Logger.getLogger(this.getClass().getName()).log(Level.INFO, orderProcessingProperties.getForbiddenMessage() + " " + phonenumber);
                        sr.setStatus(orderProcessingProperties.getSrFailedStatus());
                        sr.setResponseMessage(orderProcessingProperties.getForbiddenMessage() + " " + phonenumber);
                        sr.setCommandscompletedDate(new Date());


                        List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getFailureSms());
                    /*
                        Send sms with forbiden message and close SR
                     */
                        String failurSms = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getFailureSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);
                        String senderCode = sr.getOrderNumber().getProductId().getFailureSms().getSender() != null ? sr.getOrderNumber().getProductId().getFailureSms().getSender() : smsKannelConnectorProperties.getSender();

                        SmsRegistry smsRegistry = smsBrokerService.registerSmsForSending(failurSms, phonenumber, senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
                        results.put(menuMessages.getSmsParameterKey(), smsRegistry);


                    } else {
                    /*
                        Generate OTP and save in Token_Verification Table, make it expire in 1h
                     */
                        String otp = principalsService.generateOneTimePin();
                        VerificationTokens tokens = principalsService.createVerificationTokenForUser(principals, otp, organizationProperties.getAdminValidationTokenExpiryMinutes());
                        serviceOrderInfo.put(orderProcessingProperties.getResultCodeKeyword(), tokens.getToken());
                        results.put(orderProcessingProperties.getVerificationTokenKeyword(), tokens);


                        List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getSuccessSms());
                    /*
                        Send sms with the token and close SR
                     */
                        String successSms = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getSuccessSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);
                        String senderCode = sr.getOrderNumber().getProductId().getSuccessSms().getSender() != null ? sr.getOrderNumber().getProductId().getSuccessSms().getSender() : smsKannelConnectorProperties.getSender();

                        SmsRegistry smsRegistry = smsBrokerService.registerSmsForSending(successSms, phonenumber, senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
                        results.put(menuMessages.getSmsParameterKey(), smsRegistry);
                        sr.setStatus(orderProcessingProperties.getSrProcessedStatus());

                        sr.setCommandscompletedDate(new Date());

                    }
                });

            });
        } catch (NullPointerException e) {
            /*
                Phone number possibly not registered
             */
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            sr.setStatus(orderProcessingProperties.getSrFailedStatus());
            sr.setResponseMessage(e.getMessage() + orderProcessingProperties.getUserNotFoundMessage());
            sr.setCommandscompletedDate(new Date());

            List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getFailureSms());

            String exceptionSmsStr = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getFailureSms().getDescription() + orderProcessingProperties.getUserNotFoundMessage(), placeHolders.toArray(), serviceOrderInfo);
            String senderCode = sr.getOrderNumber().getProductId().getFailureSms().getSender() != null ? sr.getOrderNumber().getProductId().getFailureSms().getSender() : smsKannelConnectorProperties.getSender();

            smsBrokerService.registerSmsForSending(exceptionSmsStr, phonenumber, senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);

        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            sr.setStatus(orderProcessingProperties.getSrFailedStatus());
            sr.setResponseMessage(e.getMessage());
            sr.setCommandscompletedDate(new Date());

            List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getFailureSms());

            String exceptionSmsStr = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getFailureSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);
            String senderCode = sr.getOrderNumber().getProductId().getFailureSms().getSender() != null ? sr.getOrderNumber().getProductId().getFailureSms().getSender() : smsKannelConnectorProperties.getSender();

            smsBrokerService.registerSmsForSending(exceptionSmsStr, phonenumber, senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);

        }
        workOrderProcessingService.saveServiceRequest(sr);
        results.put(orderProcessingProperties.getSrIdKeyword(), sr);
        return results;
    }

    @Override
    public Map<?, ?> whitelistSubscriberForShortcode(Map<String, String> serviceOrderInfo, ServiceRequests sr) {
        /*
            DONE:Check that the msisdn has the role admintasks assigned
		 */
        Map<String, Object> results = new HashMap<>();
        String phonenumber = serviceOrderInfo.get(orderProcessingProperties.getCellphonenumberKeyword());
        try {
            /*
                TODO: What happens when ifpresent is false, figure out a way to return useful messages, maybe run this on Java 9 Pre-release?
             */
            Optional<Principals> principalsOptional = principalsService.findUserByPhone(phonenumber);
            principalsOptional.ifPresent(principals -> {
                Optional<UserRoles> userRolesOptional = principalsService.findUserRolesByRoleid(principalsService.findRolesByRolename(menuMessages.getAdminRoleKeyword()));

                userRolesOptional.ifPresent(userRoles -> {
                    if (!principals.getAdmUserRolesCollection().contains(userRoles)) {
                        serviceOrderInfo.put(orderProcessingProperties.getErrorcodeKeyword(), orderProcessingProperties.getForbiddenKeyword());

                        Logger.getLogger(this.getClass().getName()).log(Level.INFO, orderProcessingProperties.getForbiddenMessage() + " " + phonenumber);
                        sr.setStatus(orderProcessingProperties.getSrFailedStatus());
                        sr.setResponseMessage(orderProcessingProperties.getForbiddenMessage() + " " + phonenumber);
                        sr.setCommandscompletedDate(new Date());


                        List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getFailureSms());
                    /*
                        Send sms with forbiden message and close SR
                     */
                        String failurSms = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getFailureSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);
                        String senderCode = sr.getOrderNumber().getProductId().getFailureSms().getSender() != null ? sr.getOrderNumber().getProductId().getFailureSms().getSender() : smsKannelConnectorProperties.getSender();

                        SmsRegistry smsRegistry = smsBrokerService.registerSmsForSending(failurSms, phonenumber, senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
                        results.put(menuMessages.getSmsParameterKey(), smsRegistry);


                    } else {
                    /*
                        TODO: Perform admintask actions
                        Validate token provided
                     */
                        Optional<VerificationTokens> tokens = Optional.ofNullable(verificationTokensService.getVerificationToken(serviceOrderInfo.get(orderProcessingProperties.getTokenKeyword())));
                        if (!tokens.isPresent()) {
                            serviceOrderInfo.put(orderProcessingProperties.getErrorcodeKeyword(), orderProcessingProperties.getTokenExpiredMessage());

                            Logger.getLogger(this.getClass().getName()).log(Level.INFO, orderProcessingProperties.getTokenExpiredMessage() + phonenumber);
                            sr.setStatus(orderProcessingProperties.getSrFailedStatus());
                            sr.setResponseMessage(orderProcessingProperties.getTokenExpiredMessage() + phonenumber);
                            sr.setCommandscompletedDate(new Date());


                            List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getFailureSms());
                    /*
                        Send sms with forbiden message and close SR
                     */
                            String failurSms = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getFailureSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);
                            String senderCode = sr.getOrderNumber().getProductId().getFailureSms().getSender() != null ? sr.getOrderNumber().getProductId().getFailureSms().getSender() : smsKannelConnectorProperties.getSender();

                            SmsRegistry smsRegistry = smsBrokerService.registerSmsForSending(failurSms, phonenumber, senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
                            results.put(menuMessages.getSmsParameterKey(), smsRegistry);

                        } else {
                            tokens.ifPresent(verificationTokens -> {
                                /*
                                    Token expired?
                                 */
                                final Calendar cal = Calendar.getInstance();
                                if ((verificationTokens.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
                                    serviceOrderInfo.put(orderProcessingProperties.getErrorcodeKeyword(), orderProcessingProperties.getTokenExpiredMessage());

                                    Logger.getLogger(this.getClass().getName()).log(Level.INFO, orderProcessingProperties.getTokenExpiredMessage() + phonenumber);
                                    sr.setStatus(orderProcessingProperties.getSrFailedStatus());
                                    sr.setResponseMessage(orderProcessingProperties.getTokenExpiredMessage() + phonenumber);
                                    sr.setCommandscompletedDate(new Date());


                                    List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getFailureSms());

                                    String failurSms = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getFailureSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);
                                    String senderCode = sr.getOrderNumber().getProductId().getFailureSms().getSender() != null ? sr.getOrderNumber().getProductId().getFailureSms().getSender() : smsKannelConnectorProperties.getSender();

                                    SmsRegistry smsRegistry = smsBrokerService.registerSmsForSending(failurSms, phonenumber, senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
                                    results.put(menuMessages.getSmsParameterKey(), smsRegistry);

                                } else {
                                    /*
                                        Does token belong to this number
                                     */
                                    if (!verificationTokens.getUserId().equals(principals)) {
                                        serviceOrderInfo.put(orderProcessingProperties.getErrorcodeKeyword(), orderProcessingProperties.getTokenInvalidMessage());

                                        Logger.getLogger(this.getClass().getName()).log(Level.INFO, orderProcessingProperties.getTokenInvalidMessage() + phonenumber);
                                        sr.setStatus(orderProcessingProperties.getSrFailedStatus());
                                        sr.setResponseMessage(orderProcessingProperties.getTokenInvalidMessage() + phonenumber);
                                        sr.setCommandscompletedDate(new Date());


                                        List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getFailureSms());
                                        /*
                                            Send sms with forbiden message and close SR
                                         */
                                        String failurSms = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getFailureSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);
                                        String senderCode = sr.getOrderNumber().getProductId().getFailureSms().getSender() != null ? sr.getOrderNumber().getProductId().getFailureSms().getSender() : smsKannelConnectorProperties.getSender();

                                        SmsRegistry smsRegistry = smsBrokerService.registerSmsForSending(failurSms, phonenumber, senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
                                        results.put(menuMessages.getSmsParameterKey(), smsRegistry);
                                    } else {
                                        requestService.findUssdCodesByUssdCodeAndStatus(serviceOrderInfo.get(orderProcessingProperties.getUssdCodeKeyword()), menuMessages.getUssdCodeTest()).ifPresent(ussdCodes -> {
                                            SubscriberWhitelist whitelist = new SubscriberWhitelist();

                                            whitelist.setCode(ussdCodes);
                                            /*
                                              TODO: Validate subscriber number for length and append country code when needed
                                             */
                                            whitelist.setSubno(serviceOrderInfo.get(orderProcessingProperties.getSubnoKeyword()));
                                            whitelist.setStatus(Integer.valueOf(serviceOrderInfo.get(orderProcessingProperties.getCodestatusKeyword())));
                                            whitelist.setCreatedon(new Date());
                                            whitelist.setCreatedby(principals.getCellphonenumber());

                                            whitelist = requestService.saveSubscriberWhitelist(whitelist);
                                            serviceOrderInfo.put(orderProcessingProperties.getResultCodeKeyword(), whitelist.toString());
                                            List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getSuccessSms());

                                            String successSms = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getSuccessSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);
                                            String senderCode = sr.getOrderNumber().getProductId().getSuccessSms().getSender() != null ? sr.getOrderNumber().getProductId().getSuccessSms().getSender() : smsKannelConnectorProperties.getSender();

                                            SmsRegistry smsRegistry = smsBrokerService.registerSmsForSending(successSms, phonenumber, senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
                                            results.put(menuMessages.getSmsParameterKey(), smsRegistry);

                                            sr.setStatus(orderProcessingProperties.getSrProcessedStatus());

                                            sr.setCommandscompletedDate(new Date());


                                        });


                                    }
                                }


                            });
                        }


                    }
                });

            });
        } catch (NullPointerException e) {
            /*
                Phone number possibly not registered
             */
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            sr.setStatus(orderProcessingProperties.getSrFailedStatus());
            sr.setResponseMessage(e.getMessage() + orderProcessingProperties.getUserNotFoundMessage());
            sr.setCommandscompletedDate(new Date());

            List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getFailureSms());

            String exceptionSmsStr = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getFailureSms().getDescription() + orderProcessingProperties.getUserNotFoundMessage(), placeHolders.toArray(), serviceOrderInfo);
            String senderCode = sr.getOrderNumber().getProductId().getFailureSms().getSender() != null ? sr.getOrderNumber().getProductId().getFailureSms().getSender() : smsKannelConnectorProperties.getSender();

            smsBrokerService.registerSmsForSending(exceptionSmsStr, phonenumber, senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);

        } catch (ConstraintViolationException | DataIntegrityViolationException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            sr.setStatus(orderProcessingProperties.getSrFailedStatus());
            sr.setResponseMessage(e.getMessage());
            sr.setCommandscompletedDate(new Date());

            List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getFailureSms());

            String exceptionSmsStr = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getFailureSms().getDescription() + menuMessages.getSubscriberWhitelistedErrorMessage(), placeHolders.toArray(), serviceOrderInfo);
            String senderCode = sr.getOrderNumber().getProductId().getFailureSms().getSender() != null ? sr.getOrderNumber().getProductId().getFailureSms().getSender() : smsKannelConnectorProperties.getSender();

            smsBrokerService.registerSmsForSending(exceptionSmsStr, phonenumber, senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);

        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            sr.setStatus(orderProcessingProperties.getSrFailedStatus());
            sr.setResponseMessage(e.getMessage());
            sr.setCommandscompletedDate(new Date());

            List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getFailureSms());

            String exceptionSmsStr = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getFailureSms().getDescription() + e.getMessage(), placeHolders.toArray(), serviceOrderInfo);
            String senderCode = sr.getOrderNumber().getProductId().getFailureSms().getSender() != null ? sr.getOrderNumber().getProductId().getFailureSms().getSender() : smsKannelConnectorProperties.getSender();

            smsBrokerService.registerSmsForSending(exceptionSmsStr, phonenumber, senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);

        }
        workOrderProcessingService.saveServiceRequest(sr);
        results.put(orderProcessingProperties.getSrIdKeyword(), sr);
        return results;
    }

    @Override
    public Map<?, ?> deactivateSavingsTarget(Map<String, String> serviceOrderInfo, ServiceRequests sr) {
        PrincipalsSavingsTarget deactivatedTarget = savingsTargetService.findById(Long.decode(serviceOrderInfo.get(orderProcessingProperties.getTargetIdKeyword())));
        Map<String, Object> results = new HashMap<>();
        Optional<Principals> loggedInUser = principalsService.findUserByPhone(serviceOrderInfo.get(orderProcessingProperties.getCellphonenumberKeyword()));

        loggedInUser.ifPresent(u -> {

            try {

                deactivatedTarget.setStatus(orderProcessingProperties.getSavingsDeactivatedStatus());
                savingsTargetService.updateSavingsTarget(deactivatedTarget);
                sr.setStatus(orderProcessingProperties.getSrProcessedStatus());
                List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getSuccessSms());
                String successSmsStr = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getSuccessSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);

                successSmsStr = successSmsStr.replace(menuMessages.getFullNameKeyword(), u.getFullname());

                String senderCode = sr.getOrderNumber().getProductId().getSuccessSms().getSender() != null ? sr.getOrderNumber().getProductId().getSuccessSms().getSender() : smsKannelConnectorProperties.getSender();
                SmsRegistry smsRegistry = smsBrokerService.registerSmsForSending(successSmsStr, u.getCellphonenumber(), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
                results.put(menuMessages.getSmsParameterKey(), smsRegistry);


            } catch (Exception e) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                sr.setStatus(orderProcessingProperties.getSrFailedStatus());
                sr.setResponseMessage(e.getMessage());

                /*
                 * Format SMS
                 */
                List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getFailureSms());

                String failureSmsStr = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getFailureSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);
                String senderCode = sr.getOrderNumber().getProductId().getFailureSms().getSender() != null ? sr.getOrderNumber().getProductId().getFailureSms().getSender() : smsKannelConnectorProperties.getSender();

                smsBrokerService.registerSmsForSending(failureSmsStr, u.getCellphonenumber(), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
            }

        });

        workOrderProcessingService.saveServiceRequest(sr);
        return results;
    }

    @Override
    public Map<?, ?> depositSavings(Map<String, String> serviceOrderInfo, ServiceRequests sr) {
        Map<String, Object> results = new HashMap<>();
        Optional<Principals> loggedInUser = principalsService.findUserByPhone(serviceOrderInfo.get(orderProcessingProperties.getCellphonenumberKeyword()));
        PrincipalsContributions contribution = new PrincipalsContributions();
        loggedInUser.ifPresent(u -> {

            try {
                /*
                 * TODO : will only persist after we get response from mobile money provider of a successful transaction
                * */

                contribution.setAmount(Long.decode(serviceOrderInfo.get("depositAmount")));
                contribution.setPrincipal(u);
                contribution.setContributedon(new Date());
                contribution.setStatus(1);
                contributionService.savePrincipalContribution(contribution);
                sr.setStatus(orderProcessingProperties.getSrProcessedStatus());
                List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getSuccessSms());
                String successSmsStr = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getSuccessSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);

                successSmsStr = successSmsStr.replace(menuMessages.getFullNameKeyword(), u.getFullname());

                String senderCode = sr.getOrderNumber().getProductId().getSuccessSms().getSender() != null ? sr.getOrderNumber().getProductId().getSuccessSms().getSender() : smsKannelConnectorProperties.getSender();
                SmsRegistry smsRegistry = smsBrokerService.registerSmsForSending(successSmsStr, u.getCellphonenumber(), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
                results.put(menuMessages.getSmsParameterKey(), smsRegistry);


            } catch (Exception e) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                sr.setStatus(orderProcessingProperties.getSrFailedStatus());
                sr.setResponseMessage(e.getMessage());

                /*
                 * Format SMS
                 */
                List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getFailureSms());

                String failureSmsStr = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getFailureSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);
                String senderCode = sr.getOrderNumber().getProductId().getFailureSms().getSender() != null ? sr.getOrderNumber().getProductId().getFailureSms().getSender() : smsKannelConnectorProperties.getSender();

                smsBrokerService.registerSmsForSending(failureSmsStr, u.getCellphonenumber(), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
            }

        });

        workOrderProcessingService.saveServiceRequest(sr);
        return results;


    }

    @Override
    public Map<?, ?> queryLoanLimit(Map<String, String> serviceOrderInfo, ServiceRequests sr) {
        return null;
    }

    @Override
    public Map<?, ?> withdrawSavings(Map<String, String> serviceOrderInfo, ServiceRequests sr) {
        Map<String, Object> results = new HashMap<>();
        Optional<Principals> loggedInUser = principalsService.findUserByPhone(serviceOrderInfo.get(orderProcessingProperties.getCellphonenumberKeyword()));
        PrincipalsContributions contribution = new PrincipalsContributions();
        loggedInUser.ifPresent(u -> {

            try {
                /*
                 * TODO : will only persist after we get response from mobile money provider of a successful transaction
                * */

                contribution.setAmount(Long.decode(serviceOrderInfo.get("withdrawAmount")));
                contribution.setPrincipal(u);
                contribution.setContributedon(new Date());
                /*
                * TODO : use same contribution table but differentiate btn deposit/ withdraw using status?
                * or create different table to log withdrawals
                *
                * */
                contribution.setStatus(2);
                contributionService.savePrincipalContribution(contribution);
                sr.setStatus(orderProcessingProperties.getSrProcessedStatus());
                List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getSuccessSms());
                String successSmsStr = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getSuccessSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);

                successSmsStr = successSmsStr.replace(menuMessages.getFullNameKeyword(), u.getFullname());

                String senderCode = sr.getOrderNumber().getProductId().getSuccessSms().getSender() != null ? sr.getOrderNumber().getProductId().getSuccessSms().getSender() : smsKannelConnectorProperties.getSender();
                SmsRegistry smsRegistry = smsBrokerService.registerSmsForSending(successSmsStr, u.getCellphonenumber(), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
                results.put(menuMessages.getSmsParameterKey(), smsRegistry);


            } catch (Exception e) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                sr.setStatus(orderProcessingProperties.getSrFailedStatus());
                sr.setResponseMessage(e.getMessage());

                /*
                 * Format SMS
                 */
                List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getFailureSms());

                String failureSmsStr = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getFailureSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);
                String senderCode = sr.getOrderNumber().getProductId().getFailureSms().getSender() != null ? sr.getOrderNumber().getProductId().getFailureSms().getSender() : smsKannelConnectorProperties.getSender();

                smsBrokerService.registerSmsForSending(failureSmsStr, u.getCellphonenumber(), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
            }

        });

        workOrderProcessingService.saveServiceRequest(sr);
        return results;
    }

    @Override
    public Map<?, ?> checkBalance(Map<String, String> serviceOrderInfo, ServiceRequests sr) {

        Map<String, Object> results = new HashMap<>();

        Optional<Principals> loggedInUser = principalsService.findUserByPhone(serviceOrderInfo.get(orderProcessingProperties.getCellphonenumberKeyword()));
        loggedInUser.ifPresent(u -> {

            try {
                int deposit = 0, withdrawals = 0, balance;



                /*
                * TODO : use same contribution table but differentiate btn deposit/ withdraw using status?
                * or create different table to log withdrawals
                *
                * */
                Collection<PrincipalsContributions> contribution = contributionService.listContributionsByPrincipal(u);
                for (PrincipalsContributions cont : contribution) {
                    if (cont.getStatus() == 1) {
                        deposit += cont.getAmount();
                    } else if (cont.getStatus() == 2) {
                        withdrawals += cont.getStatus();
                    }

                }
                balance = deposit - withdrawals;
                /*
                TODO : convert success and failure sms to functions to reduce size
                *
                *
                * */

                sr.setStatus(orderProcessingProperties.getSrProcessedStatus());
                List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getSuccessSms());
                /*
                TODO : externalise
                *
                *
                * */
                serviceOrderInfo.put("myBalance", Integer.toString(balance));
                String successSmsStr = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getSuccessSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);

                successSmsStr = successSmsStr.replace(menuMessages.getFullNameKeyword(), u.getFullname());

                String senderCode = sr.getOrderNumber().getProductId().getSuccessSms().getSender() != null ? sr.getOrderNumber().getProductId().getSuccessSms().getSender() : smsKannelConnectorProperties.getSender();
                SmsRegistry smsRegistry = smsBrokerService.registerSmsForSending(successSmsStr, u.getCellphonenumber(), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
                results.put(menuMessages.getSmsParameterKey(), smsRegistry);


            } catch (Exception e) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                sr.setStatus(orderProcessingProperties.getSrFailedStatus());
                sr.setResponseMessage(e.getMessage());

                /*
                 * Format SMS
                 */
                List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getFailureSms());

                String failureSmsStr = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getFailureSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);
                String senderCode = sr.getOrderNumber().getProductId().getFailureSms().getSender() != null ? sr.getOrderNumber().getProductId().getFailureSms().getSender() : smsKannelConnectorProperties.getSender();

                smsBrokerService.registerSmsForSending(failureSmsStr, u.getCellphonenumber(), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
            }

        });

        workOrderProcessingService.saveServiceRequest(sr);
        return results;
    }

    @Override
    public Map<?, ?> generateStatement(Map<String, String> serviceOrderInfo, ServiceRequests sr) {
        Map<String, Object> results = new HashMap<>();

        Optional<Principals> loggedInUser = principalsService.findUserByPhone(serviceOrderInfo.get(orderProcessingProperties.getCellphonenumberKeyword()));
        loggedInUser.ifPresent(u -> {

            try {
                int deposit = 0, withdrawals = 0, balance, totalLoan = 0;



                /*
                * TODO : use same contribution table but differentiate btn deposit/ withdraw using status?
                * or create different table to log withdrawals
                *
                * */
                Collection<PrincipalsContributions> contribution = contributionService.listContributionsByPrincipal(u);
                Collection<PrincipalsLoans> loans = loansService.findLoanByPrincipal(u);

                for (PrincipalsContributions cont : contribution) {
                    if (cont.getStatus() == 1) {
                        deposit += cont.getAmount();
                    } else if (cont.getStatus() == 2) {
                        withdrawals += cont.getAmount();
                    }

                }
                balance = deposit - withdrawals;
                for (PrincipalsLoans loan : loans) {
                    totalLoan += loan.getAmountloaned();
                }


                sr.setStatus(orderProcessingProperties.getSrProcessedStatus());
                List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getSuccessSms());
                serviceOrderInfo.put("deposits", Integer.toString(deposit));
                /**
                 * TODO : externalise
                 */
                serviceOrderInfo.put("withdrawals", Integer.toString(withdrawals));
                serviceOrderInfo.put("loans", Integer.toString(totalLoan));
                String successSmsStr = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getSuccessSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);

                successSmsStr = successSmsStr.replace(menuMessages.getFullNameKeyword(), u.getFullname());

                String senderCode = sr.getOrderNumber().getProductId().getSuccessSms().getSender() != null ? sr.getOrderNumber().getProductId().getSuccessSms().getSender() : smsKannelConnectorProperties.getSender();
                SmsRegistry smsRegistry = smsBrokerService.registerSmsForSending(successSmsStr, u.getCellphonenumber(), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
                results.put(menuMessages.getSmsParameterKey(), smsRegistry);


            } catch (Exception e) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                sr.setStatus(orderProcessingProperties.getSrFailedStatus());
                sr.setResponseMessage(e.getMessage());

                /**
                 * Format SMS
                 */
                List<String> placeHolders = fetchMessageParameters(sr.getOrderNumber().getProductId().getFailureSms());

                String failureSmsStr = utilities.addParametersToMessage(sr.getOrderNumber().getProductId().getFailureSms().getDescription(), placeHolders.toArray(), serviceOrderInfo);
                String senderCode = sr.getOrderNumber().getProductId().getFailureSms().getSender() != null ? sr.getOrderNumber().getProductId().getFailureSms().getSender() : smsKannelConnectorProperties.getSender();

                smsBrokerService.registerSmsForSending(failureSmsStr, u.getCellphonenumber(), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus(), sr);
            }

        });

        workOrderProcessingService.saveServiceRequest(sr);
        return results;
    }

    @Override
    public Map<?, ?> payLoan(Map<String, String> serviceOrderInfo, ServiceRequests sr) {
        return null;
    }


}
