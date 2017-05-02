package org.muhia.app.psi.config.order.properties;

/*
 
  Copyright 2015-2016 the original author or authors.
 
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
 
       http://www.apache.org/licenses/LICENSE-2.0
 
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
 
 
  Generated on 03-Nov-16 14:17 
 
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Locale;

/*
  @author Kenneth Muhia <muhia@muhia.org> on 03-Nov-16. 
  for package org.muhia.app.psi.config
*/
@Configuration
@PropertySource(value = "file:${CONFIG_PATH}/order-processing.properties")
public class OrderProcessingProperties {
    @Value("${org.muhia.psi.order.config.orderSubmittedStatus}")
    int orderSubmittedStatus;
    @Value("${org.muhia.psi.order.config.orderInitiatedStatus}")
    int orderInitiatedStatus;

    @Value("${org.muhia.psi.order.config.orderProcessedStatus}")
    int orderProcessedStatus;
    @Value("${org.muhia.psi.order.config.orderFailedStatus}")
    int orderFailedStatus;
    @Value("${org.muhia.psi.order.config.orderPendingStatus}")
    int orderPendingStatus;
    @Value("${org.muhia.psi.order.config.srInitiatedStatus}")
    private int srInitiatedStatus;
    @Value("${org.muhia.psi.order.config.srSubmittedStatus}")
    private int srSubmittedStatus;
    @Value("${org.muhia.psi.order.config.srPendingStatus}")
    private int srPendingStatus;
    @Value("${org.muhia.psi.order.config.srProcessedStatus}")
    private int srProcessedStatus;
    @Value("${org.muhia.psi.order.config.srFailedStatus}")
    private int srFailedStatus;
    @Value("${org.muhia.psi.order.config.srRenewableTrue}")
    private int srRenewableTrue;
    @Value("${org.muhia.psi.order.config.srRenewableFalse}")
    private int srRenewableFalse;
    @Value("${org.muhia.psi.order.config.defaultSrPriority}")
    private Integer defaultSrPriority;
    @Value("${org.muhia.psi.order.config.messages.sr.methodnameKeyword}")
    private String methodnameKeyword;
    @Value("${org.muhia.psi.order.config.messages.sr.srIdKeyword}")
    private String srIdKeyword;
    @Value("${org.muhia.psi.order.config.srReprocessFailed}")
    private Integer srReprocessFailed;
    @Value("${org.muhia.psi.order.config.orderReprocessFailed}")
    private Integer orderReprocessFailed;

    @Value("${org.muhia.app.psi.config.order.sr.cellphonenumberKeyword}")
    private String cellphonenumberKeyword;

    @Value("${org.muhia.psi.order.config.fullnameKeyword}")
    private String fullnameKeyword;
    @Value("${org.muhia.app.psi.config.order.sr.order.organization.keyword}")
    private String orderOrganizationKeyword;


    @Value("${org.muhia.psi.order.config.idnumbertypeKeyword}")
    private String idnumbertypeKeyword;

    @Value("${org.muhia.psi.order.config.idnumberKeyword}")
    private String idnumberKeyword;

    @Value("${org.muhia.psi.ussd.response.message.productidKeyword}")
    private String productidKeyword;

    @Value("${org.muhia.psi.ussd.response.message.membershipnoKeyword}")
    private String membershipnoKeyword;

    @Value("${org.muhia.psi.ussd.response.message.duplicateRegistration}")
    private String duplicateRegistration;

    @Value("${org.muhia.psi.ussd.response.message.oldOtpPinKeyword}")
    private
    String oldOtpPinKeyword;
    @Value("${org.muhia.psi.ussd.response.message.newOtpPinKeyword}")
    private String newOtpPinKeyword;
    @Value("${org.muhia.psi.ussd.response.message.confirmNewOtpPinKeyword}")
    private String confirmNewOtpPinKeyword;
    @Value("${org.muhia.psi.ussd.response.message.kycValidationFailedMessage}")
    private String kycValidationFailedMessage;
    @Value("${org.muhia.psi.order.config.format.transactionNo}")
    private String transactionNoFormatString;
    @Value("${org.muhia.psi.order.config.format.membershipNo}")
    private String membershipNoFormatString;
    @Value("${org.muhia.psi.order.config.format.locale.language}")
    private String lang;
    @Value("${org.muhia.psi.order.config.format.locale.country}")
    private String country;

    @Value("${org.muhia.app.psi.config.order.sr.phonenumber}")
    private String phonenumberKeyword;
    @Value("${org.muhia.app.psi.config.order.sr.loanid}")
    private String loanIdKeyword;
    @Value("${org.muhia.app.psi.config.order.sr.amountrequested}")
    private String amountRequestedKeyword;
    @Value("${org.muhia.app.psi.config.order.sr.amountloaned}")
    private String amountLoanedKeyword;
    @Value("${org.muhia.app.psi.config.order.sr.orderNumber}")
    private String orderNumberKeyword;
    @Value("${org.muhia.app.psi.config.order.sr.amountapproved}")
    private String amountApprovedKeyword;
    @Value("${org.muhia.app.psi.config.order.sr.amount}")
    private String amountKeyword;
    @Value("${org.muhia.app.psi.config.order.sr.type}")
    private String typeKeyword;
    @Value("${org.muhia.app.psi.config.order.sr.target}")
    private String targetKeyword;
    @Value("${org.muhia.app.psi.config.order.sr.lenderphone}")
    private String lenderPhoneKeyword;
    @Value("${org.muhia.app.psi.config.order.sr.daily}")
    private String dailyKeyword;
    @Value("${org.muhia.app.psi.config.order.sr.weekly}")
    private String weeklyKeyword;
    @Value("${org.muhia.app.psi.config.order.sr.monthly}")
    private String monthlyKeyword;
    @Value("${org.muhia.app.psi.config.order.sr.interval}")
    private String intervalKeyword;

    @Value("${org.muhia.app.psi.config.order.sr.requestid}")
    private String requestIdKeyword;
    private Locale locale;
    @Value("${org.muhia.psi.ussd.response.message.forbiddenKeyword}")
    private String forbiddenKeyword;
    @Value("${org.muhia.psi.ussd.response.message.forbiddenMessage}")
    private String forbiddenMessage;
    @Value("${org.muhia.psi.ussd.response.message.errorcodeKeyword}")
    private String errorcodeKeyword;
    @Value("${org.muhia.psi.ussd.response.message.resultCodeKeyword}")
    private String resultCodeKeyword;
    @Value("${org.muhia.psi.ussd.response.message.userNotFoundMessage}")
    private String userNotFoundMessage;
    @Value("${org.muhia.psi.ussd.response.message.tokenKeyword}")
    private String tokenKeyword;
    @Value("${org.muhia.psi.ussd.response.message.tokenExpiredMessage}")
    private String tokenExpiredMessage;
    @Value("${org.muhia.psi.ussd.response.message.tokenInvalidMessage}")
    private String tokenInvalidMessage;
    @Value("${org.muhia.psi.ussd.response.message.ussdCodeKeyword}")
    private String ussdCodeKeyword;
    @Value("${org.muhia.psi.ussd.response.message.subnoKeyword}")
    private String subnoKeyword;
    @Value("${org.muhia.psi.ussd.response.message.codestatusKeyword}")
    private String codestatusKeyword;
    @Value("${org.muhia.psi.ussd.response.message.admintaskKeyword}")
    private String admintaskKeyword;
    @Value("${org.muhia.psi.ussd.response.message.verificationTokenKeyword}")
    private String verificationTokenKeyword;

    @Value("${org.muhia.app.psi.config.order.pending}")
    private int pendingStatus;
    @Value("${org.muhia.app.psi.config.order.paid}")
    private int paidStatus;
    @Value("${org.muhia.app.psi.config.order.loanApproved}")
    private int loanApprovedStatus;
    @Value("${org.muhia.app.psi.config.order.guarantorApproved}")
    private int guarantorApprovedStatus;
    @Value("${org.muhia.app.psi.config.order.addGuarantors}")
    private int guarantorStatus;
    @Value("${org.muhia.app.psi.config.order.guarantorDeclined}")
    private int guarantorDeclinedStatus;
    @Value("${org.muhia.app.psi.config.order.loanDeclined}")
    private int loanDeclinedStatus;
    @Value("${org.muhia.app.psi.config.order.sr.interest}")
    private String interestKeyword;

    @Value("${org.muhia.app.psi.config.order.sr.targetId}")
    private String targetIdKeyword;

    @Value("${org.muhia.app.psi.config.order.deactivatedStatus}")
    private int savingsDeactivatedStatus;
    @Value("${org.muhia.app.psi.config.order.sr.order.firstname.keyword}")
    private String orderFirstnameKeyword;
    @Value("${org.muhia.app.psi.config.order.sr.order.middlename.keyword}")
    private String orderMiddlenameKeyword;
    @Value("${org.muhia.app.psi.config.order.sr.order.lastname.keyword}")
    private String orderLastnameKeyword;
    @Value("${org.muhia.app.psi.config.order.sr.order.accepted.terms.keyword}")
    private String orderAcceptedTermsKeyword;
    @Value("${org.muhia.app.psi.config.order.sr.order.declined.terms.keyword}")
    private String orderDeclinedTermsKeyword;
    @Value("${org.muhia.app.psi.config.order.sr.order.accepted.terms.value}")
    private int orderAcceptedTermsValue;
    @Value("${org.muhia.app.psi.config.order.sr.order.declined.terms.value}")
    private int orderDeclinedTermsValue;
    @Value("${org.muhia.app.psi.config.order.sr.order.termsaccepted.date.keyword}")
    private String orderTermsacceptedDateKeyword;
    @Value("${org.muhia.app.psi.config.order.sr.order.termsaccepted.date.sdf}")
    private String orderTermsacceptedDateSdf;
    @Value("${org.muhia.app.psi.config.order.sr.order.userregistration.initial.status}")
    private int orderUserregistrationInitialStatus;
    @Value("${org.muhia.app.psi.config.order.sr.order.userregistration.failure.status}")
    private int orderUserregistrationFailureStatus;
    @Value("${org.muhia.app.psi.config.order.sr.order.userregistration.iprsnok.status}")
    private int orderUserregistrationIprsNokStatus;
    @Value("${org.muhia.app.psi.config.order.sr.order.userregistration.iprsok.status}")
    private int orderUserregistrationIprsOkStatus;
    @Value("${org.muhia.app.psi.config.order.sr.order.userregistration.success.status}")
    private int orderUserregistrationSuccessStatus;
    @Value("${org.muhia.app.psi.config.order.sr.order.userregistration.keyword}")
    private String orderUserregistrationKeyword;
    @Value("${org.muhia.app.psi.config.order.sr.order.kyc.validation.module.name}")
    private String kycValidationModuleName;
    @Value("${org.muhia.app.psi.config.order.maisha.loans.account.type.name}")
    private String maishaLoansAccountType;
    @Value("${org.muhia.app.psi.config.order.maisha.loans.from.account.number}")
    private String maishaLoansFromAccountNumber;
    @Value("${org.muhia.app.psi.config.order.maisha.loans.transaction.type.name}")
    private String maishaLoansTransactionTypeName;
    @Value("${org.muhia.app.psi.config.order.maisha.loans.bank.id}")
    private Long maishaLoansBankId;
    @Value("${org.muhia.app.psi.config.order.maisha.loans.bank.branch.id}")
    private Long maishaLoansBankBranchId;
    @Value("${org.muhia.app.psi.config.order.ke.maisha.loans.currency.code}")
    private String keMaishaLoansCurrencyCode;
    @Value("${org.muhia.app.psi.config.order.maisha.loans.account.number.prefix}")
    private String keMaishaLoansAccountNumberPrefix;
    @Value("${org.muhia.app.psi.config.order.ke.maisha.loan.amount.keyword}")
    private String keMaishaLoanAmountKeyword;
    @Value("${org.muhia.app.psi.config.order.ke.maisha.loan.narration}")
    private String keMaishaLoanNarration;
    @Value("${org.muhia.app.psi.config.order.ke.maisha.loan.duration.keyword}")
    private String keMaishaLoanDurationKeyword;
    @Value("${org.muhia.app.psi.config.order.ke.maisha.loan.rate.keyword}")
    private String keMaishaLoanRateKeyword;
    @Value("${org.muhia.app.psi.config.order.ke.maisha.bank.charges.percentage.keyword}")
    private String keMaishaBankChargesPercentageKeyword;
    @Value("${org.muhia.psi.order.config.order.transaction.request.provisioning.retries}")
    private int requestProvisioningRetries;


    @Value("${org.muhia.psi.order.config.order.transaction.request.status.initiated}")
    private int requestStatusInitiated;
    @Value("${org.muhia.psi.order.config.order.transaction.request.status.prepared.init}")
    private int requestStatusPreparedInit;
    @Value("${org.muhia.psi.order.config.order.transaction.request.status.prepared.working}")
    private int requestStatusPreparedWorking;
    @Value("${org.muhia.psi.order.config.order.transaction.request.status.prepared.success}")
    private int requestStatusPreparedSuccess;
    @Value("${org.muhia.psi.order.config.order.transaction.request.status.prepared.fail}")
    private int requestStatusPreparedFail;
    @Value("${org.muhia.psi.order.config.order.transaction.request.status.provisioned.init}")
    private int requestStatusProvisionedInit;
    @Value("${org.muhia.psi.order.config.order.transaction.request.status.provisioned.working}")
    private int requestStatusProvisionedWorking;
    @Value("${org.muhia.psi.order.config.order.transaction.request.status.provisioned.success}")
    private int requestStatusProvisionedSuccess;
    @Value("${org.muhia.psi.order.config.order.transaction.request.status.provisioned.fail}")
    private int requestStatusProvisionedFail;
    @Value("${org.muhia.psi.order.config.order.transaction.request.status.accounting.init}")
    private int requestStatusAccountingInit;
    @Value("${org.muhia.psi.order.config.order.transaction.request.status.accounting.working}")
    private int requestStatusAccountingWorking;
    @Value("${org.muhia.psi.order.config.order.transaction.request.status.accounting.success}")
    private int requestStatusAccountingSuccess;
    @Value("${org.muhia.psi.order.config.order.transaction.request.status.accounting.fail}")
    private int requestStatusAccountingFail;
    @Value("${org.muhia.psi.order.config.order.transaction.request.status.glupdate.init}")
    private int requestStatusGlupdateInit;
    @Value("${org.muhia.psi.order.config.order.transaction.request.status.glupdate.working}")
    private int requestStatusGlupdateWorking;
    @Value("${org.muhia.psi.order.config.order.transaction.request.status.glupdate.success}")
    private int requestStatusGlupdateSuccess;
    @Value("${org.muhia.psi.order.config.order.transaction.request.status.glupdate.fail}")
    private int requestStatusGlupdateFail;
    @Value("${org.muhia.psi.order.config.order.transaction.request.status.crbaupdate.init}")
    private int requestStatusCrbaupdateInit;
    @Value("${org.muhia.psi.order.config.order.transaction.request.status.crbaupdate.working}")
    private int requestStatusCrbaupdateWorking;
    @Value("${org.muhia.psi.order.config.order.transaction.request.status.crbaupdate.success}")
    private int requestStatusCrbaupdateSuccess;
    @Value("${org.muhia.psi.order.config.order.transaction.request.status.crbaupdate.fail}")
    private int requestStatusCrbaupdateFail;




    public int getOrderInitiatedStatus() {
        return orderInitiatedStatus;
    }


    public int getOrderSubmittedStatus() {
        return orderSubmittedStatus;
    }


    public int getOrderProcessedStatus() {
        return orderProcessedStatus;
    }


    public int getOrderFailedStatus() {
        return orderFailedStatus;
    }


    public int getSrInitiatedStatus() {
        return srInitiatedStatus;
    }

    public int getSrSubmittedStatus() {
        return srSubmittedStatus;
    }

    public int getSrProcessedStatus() {
        return srProcessedStatus;
    }

    public int getSrFailedStatus() {
        return srFailedStatus;
    }

    public int getSrRenewableTrue() {
        return srRenewableTrue;
    }

    public int getSrRenewableFalse() {
        return srRenewableFalse;
    }

    public Integer getDefaultSrPriority() {
        return defaultSrPriority;
    }

    public String getMethodnameKeyword() {
        return methodnameKeyword;
    }

    public String getSrIdKeyword() {
        return srIdKeyword;
    }

    public Integer getsrReprocessFailed() {
        return srReprocessFailed;
    }

    public Integer getSrReprocessFailed() {
        return srReprocessFailed;
    }

    public Integer getOrderReprocessFailed() {
        return orderReprocessFailed;
    }

    public String getCellphonenumberKeyword() {
        return cellphonenumberKeyword;
    }

    public String getFullnameKeyword() {
        return fullnameKeyword;
    }

    public String getIdnumbertypeKeyword() {
        return idnumbertypeKeyword;
    }

    public String getIdnumberKeyword() {
        return idnumberKeyword;
    }

    public String getProductidKeyword() {
        return productidKeyword;
    }

    public String getMembershipnoKeyword() {
        return membershipnoKeyword;
    }

    public String getDuplicateRegistration() {
        return duplicateRegistration;
    }

    public String getOldOtpPinKeyword() {
        return oldOtpPinKeyword;
    }

    public String getNewOtpPinKeyword() {
        return newOtpPinKeyword;
    }

    public String getConfirmNewOtpPinKeyword() {
        return confirmNewOtpPinKeyword;
    }

    public String getKycValidationFailedMessage() {
        return kycValidationFailedMessage;
    }

    public String getTransactionNoFormatString() {
        return transactionNoFormatString;
    }

    public String getMembershipNoFormatString() {
        return membershipNoFormatString;
    }

    public Locale getLocale() {
        locale = new Locale(getLang(), getCountry());

        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhonenumberKeyword() {
        return phonenumberKeyword;
    }

    public String getLoanIdKeyword() {
        return loanIdKeyword;
    }

    public String getAmountRequestedKeyword() {
        return amountRequestedKeyword;
    }

    public String getAmountLoanedKeyword() {
        return amountLoanedKeyword;
    }

    public String getOrderNumberKeyword() {
        return orderNumberKeyword;
    }

    public String getAmountApprovedKeyword() {
        return amountApprovedKeyword;
    }

    public String getAmountKeyword() {
        return amountKeyword;
    }

    public String getTypeKeyword() {
        return typeKeyword;
    }

    public String getTargetKeyword() {
        return targetKeyword;
    }

    public String getLenderPhoneKeyword() {
        return lenderPhoneKeyword;
    }

    public String getDailyKeyword() {
        return dailyKeyword;
    }

    public String getWeeklyKeyword() {
        return weeklyKeyword;
    }

    public String getMonthlyKeyword() {
        return monthlyKeyword;
    }

    public String getIntervalKeyword() {
        return intervalKeyword;
    }

    public String getRequestIdKeyword() {
        return requestIdKeyword;
    }


    public String getForbiddenKeyword() {
        return forbiddenKeyword;
    }

    public void setForbiddenKeyword(String forbiddenKeyword) {
        this.forbiddenKeyword = forbiddenKeyword;
    }

    public String getErrorcodeKeyword() {
        return errorcodeKeyword;
    }

    public String getResultCodeKeyword() {
        return resultCodeKeyword;
    }

    public String getUserNotFoundMessage() {
        return userNotFoundMessage;
    }

    public String getTokenKeyword() {
        return tokenKeyword;
    }

    public String getTokenExpiredMessage() {
        return tokenExpiredMessage;
    }

    public String getTokenInvalidMessage() {
        return tokenInvalidMessage;
    }

    public String getUssdCodeKeyword() {
        return ussdCodeKeyword;
    }

    public String getSubnoKeyword() {
        return subnoKeyword;
    }

    public String getCodestatusKeyword() {
        return codestatusKeyword;
    }

    public String getAdmintaskKeyword() {
        return admintaskKeyword;
    }

    public String getForbiddenMessage() {
        return forbiddenMessage;
    }

    public String getVerificationTokenKeyword() {
        return verificationTokenKeyword;
    }

    public int getSrPendingStatus() {
        return srPendingStatus;
    }

    public int getOrderPendingStatus() {
        return orderPendingStatus;
    }

    public int getPendingStatus() {
        return pendingStatus;
    }

    public int getPaidStatus() {
        return paidStatus;
    }

    public int getLoanApprovedStatus() {
        return loanApprovedStatus;
    }

    public int getGuarantorApprovedStatus() {
        return guarantorApprovedStatus;
    }

    public int getGuarantorStatus() {
        return guarantorStatus;
    }

    public int getGuarantorDeclinedStatus() {
        return guarantorDeclinedStatus;
    }

    public int getLoanDeclinedStatus() {
        return loanDeclinedStatus;
    }

    public String getInterestKeyword() {
        return interestKeyword;
    }

    public String getTargetIdKeyword() {
        return targetIdKeyword;
    }

    public int getSavingsDeactivatedStatus() {
        return savingsDeactivatedStatus;
    }

    public String getOrderFirstnameKeyword() {
        return orderFirstnameKeyword;
    }

    public String getOrderMiddlenameKeyword() {
        return orderMiddlenameKeyword;
    }

    public String getOrderLastnameKeyword() {
        return orderLastnameKeyword;
    }


    public int getOrderAcceptedTermsValue() {
        return orderAcceptedTermsValue;
    }

    public int getOrderDeclinedTermsValue() {
        return orderDeclinedTermsValue;
    }

    public String getOrderAcceptedTermsKeyword() {
        return orderAcceptedTermsKeyword;
    }

    public String getOrderDeclinedTermsKeyword() {
        return orderDeclinedTermsKeyword;
    }

    public String getOrderTermsacceptedDateKeyword() {
        return orderTermsacceptedDateKeyword;
    }

    public String getOrderTermsacceptedDateSdf() {
        return orderTermsacceptedDateSdf;
    }

    public String getOrderOrganizationKeyword() {
        return orderOrganizationKeyword;
    }

    public int getOrderUserregistrationInitialStatus() {
        return orderUserregistrationInitialStatus;
    }

    public int getOrderUserregistrationFailureStatus() {
        return orderUserregistrationFailureStatus;
    }

    public int getOrderUserregistrationIprsNokStatus() {
        return orderUserregistrationIprsNokStatus;
    }

    public int getOrderUserregistrationIprsOkStatus() {
        return orderUserregistrationIprsOkStatus;
    }

    public int getOrderUserregistrationSuccessStatus() {
        return orderUserregistrationSuccessStatus;
    }

    public String getOrderUserregistrationKeyword() {
        return orderUserregistrationKeyword;
    }

    public String getKycValidationModuleName() {
        return kycValidationModuleName;
    }

    public String getMaishaLoansAccountType() {
        return maishaLoansAccountType;
    }

    public Long getMaishaLoansBankId() {
        return maishaLoansBankId;
    }

    public Long getMaishaLoansBankBranchId() {
        return maishaLoansBankBranchId;
    }

    public String getKeMaishaLoansCurrencyCode() {
        return keMaishaLoansCurrencyCode;
    }

    public String getKeMaishaLoansAccountNumberPrefix() {
        return keMaishaLoansAccountNumberPrefix;
    }

    public String getMaishaLoansTransactionTypeName() {
        return maishaLoansTransactionTypeName;
    }

    public String getMaishaLoansFromAccountNumber() {
        return maishaLoansFromAccountNumber;
    }

    public String getKeMaishaLoanAmountKeyword() {
        return keMaishaLoanAmountKeyword;
    }

    public String getKeMaishaLoanDurationKeyword() {
        return keMaishaLoanDurationKeyword;
    }

    public String getKeMaishaLoanRateKeyword() {
        return keMaishaLoanRateKeyword;
    }

    public String getKeMaishaBankChargesPercentageKeyword() {
        return keMaishaBankChargesPercentageKeyword;
    }

    public String getKeMaishaLoanNarration() {
        return keMaishaLoanNarration;
    }

    /**
     * Transaction Request status
     */
    public int getRequestStatusInitiated() {
        return requestStatusInitiated;
    }

    public int getRequestStatusPreparedInit() {
        return requestStatusPreparedInit;
    }

    public int getRequestStatusPreparedWorking() {
        return requestStatusPreparedWorking;
    }

    public int getRequestStatusPreparedSuccess() {
        return requestStatusPreparedSuccess;
    }

    public int getRequestStatusPreparedFail() {
        return requestStatusPreparedFail;
    }

    public int getRequestStatusProvisionedInit() {
        return requestStatusProvisionedInit;
    }

    public int getRequestStatusProvisionedWorking() {
        return requestStatusProvisionedWorking;
    }

    public int getRequestStatusProvisionedSuccess() {
        return requestStatusProvisionedSuccess;
    }

    public int getRequestStatusProvisionedFail() {
        return requestStatusProvisionedFail;
    }

    public int getRequestStatusAccountingInit() {
        return requestStatusAccountingInit;
    }

    public int getRequestStatusAccountingWorking() {
        return requestStatusAccountingWorking;
    }

    public int getRequestStatusAccountingSuccess() {
        return requestStatusAccountingSuccess;
    }

    public int getRequestStatusAccountingFail() {
        return requestStatusAccountingFail;
    }

    /**
     * Provisioning Retry Attempts
     */
    public int getRequestProvisioningRetries() {
        return requestProvisioningRetries;
    }
}
