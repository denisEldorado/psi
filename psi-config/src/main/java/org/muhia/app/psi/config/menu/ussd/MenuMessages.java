package org.muhia.app.psi.config.menu.ussd;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author KennethKZMMuhia
 */
@Configuration
@PropertySource(value = "file:${CONFIG_PATH}/ussd-menu-messages.properties")
public class MenuMessages {
    @Value("${org.muhia.psi.ussd.response.message.duplicateRequestMessage}")
    String duplicateRequestMessage;
    @Value("${org.muhia.psi.ussd.response.message.missingParameterMessage}")
    String missingParameterMessage;
    @Value("${org.muhia.psi.ussd.response.message.generalExceptionMessage}")
    String generalExceptionMessage;
    @Value("${org.muhia.psi.ussd.response.message.typeMismatchMessage}")
    String typeMismatchMessage;
    @Value("${org.muhia.psi.ussd.response.message.notOnWhitelistMessage}")
    String notOnWhitelistMessage;
    @Value("${org.muhia.psi.ussd.response.message.invalidInputMessage}")
    String invalidInputMessage;
    @Value("${org.muhia.psi.ussd.response.message.newRequestVar}")
    String newRequestVar;
    @Value("${org.muhia.psi.ussd.response.message.entryPointVar}")
    String entryPointVar;
    @Value("${org.muhia.psi.ussd.response.message.firstTimeVar}")
    String firstTimeVar;
    @Value("${org.muhia.psi.ussd.response.message.logInVar}")
    String logInVar;
    @Value("${org.muhia.psi.ussd.response.message.oldRequestVar}")
    String oldRequestVar;
    @Value("${org.muhia.psi.ussd.response.message.endOfSessionFalseVar}")
    String endOfSessionFalseVar;
    @Value("${org.muhia.psi.ussd.response.message.endOfSessionTrueVar}")
    String endOfSessionTrueVar;
    @Value("${org.muhia.psi.ussd.response.message.validUssdReponseStatus}")
    String validUssdReponseStatus;
    @Value("${org.muhia.psi.ussd.response.message.invalidUssdReponseStatus}")
    String invalidUssdReponseStatus;
    @Value("${org.muhia.psi.ussd.response.message.validUssdReponseCode}")
    String validUssdReponseCode;
    @Value("${org.muhia.psi.ussd.response.message.invalidUssdReponseCode}")
    String invalidUssdReponseCode;
    @Value("${org.muhia.psi.ussd.response.message.badRequestMessage}")
    String badRequestMessage;
    @Value("${org.muhia.psi.ussd.response.message.isChoiceYes}")
    String isChoiceYes;
    @Value("${org.muhia.psi.ussd.response.message.isChoiceNo}")
    String isChoiceNo;
    @Value("${org.muhia.psi.ussd.response.message.numTextSeparator}")
    String numTextSeparator;
    @Value("${org.muhia.psi.ussd.response.message.eolChar}")
    String eolChar;
    @Value("${org.muhia.psi.ussd.response.message.nextPageChar}")
    String nextPageChar;
    @Value("${org.muhia.psi.ussd.response.message.prevPageChar}")
    String prevPageChar;
    @Value("${org.muhia.psi.ussd.response.message.goBackMessage}")
    String goBackMessage;
    @Value("${org.muhia.psi.ussd.response.message.goPrevMessage}")
    String goPrevMessage;
    @Value("${org.muhia.psi.ussd.response.message.goBackVar}")
    String goBackVar;
    @Value("${org.muhia.psi.ussd.response.message.goPrevVar}")
    String goPrevVar;
    @Value("${org.muhia.psi.ussd.response.message.ussdSuccessStatus}")
    String ussdSuccessStatus;
    @Value("${org.muhia.psi.ussd.response.message.ussdSuccessProcessStatus}")
    String ussdSuccessProcessStatus;
    @Value("${org.muhia.psi.ussd.response.message.ussdResponseCodeDeleted}")
    String ussdResponseCodeDeleted;
    @Value("${org.muhia.psi.ussd.response.message.ussdFailureStatus}")
    String ussdFailureStatus;
    @Value("${org.muhia.psi.ussd.response.message.ussdInternalServerErrorStatus}")
    String ussdInternalServerErrorStatus;
    @Value("${org.muhia.psi.ussd.response.message.ussdWrongNumberFormatStatus}")
    String ussdWrongNumberFormatStatus;
    @Value("${org.muhia.psi.ussd.response.message.ussdResponseCodeDefault}")
    String ussdResponseCodeDefault;
    @Value("${org.muhia.psi.ussd.response.message.ussdNotAllowedResponse}")
    String ussdNotAllowedResponse;
    @Value("${org.muhia.psi.ussd.response.message.ussdInvalidInputVar}")
    String ussdInvalidInputVar;
    @Value("${org.muhia.psi.ussd.response.message.credentialsVar}")
    String credentialsVar;
    @Value("${org.muhia.psi.ussd.response.message.credentialVar}")
    String credentialVar;
    @Value("${org.muhia.app.psi.config.ussd.menu.registered.user.entrypoint}")
    private String menuRegisteredUserEntrypoint;
    @Value("${org.muhia.psi.ussd.response.message.sessionEndVar}")
    private String sessionEndVar;
    @Value("${org.muhia.psi.ussd.response.actions.processKeyword}")
    private String processKeyword;
    @Value("${org.muhia.psi.ussd.response.actions.productKeyword}")
    private String productKeyword;
    @Value("${org.muhia.psi.ussd.response.actions.separator.keywordVar}")
    private String separatorKeywordVar;
    @Value("${org.muhia.psi.ussd.response.message.appNameUser}")
    private String appNameUser;
    @Value("${org.muhia.psi.ussd.response.message.ussdUserType}")
    private String ussdUserType;
    @Value("${org.muhia.psi.ussd.response.message.ussdUserRole}")
    private String ussdUserRole;
    @Value("${org.muhia.psi.ussd.response.message.appName}")
    private String appName;
    @Value("${org.muhia.psi.ussd.response.message.appEmail}")
    private String appEmail;
    @Value("${org.muhia.psi.ussd.response.message.fullNameKeyword}")
    private String fullNameKeyword;
    @Value("${org.muhia.psi.ussd.response.message.otpKeyword}")
    private String otpKeyword;
    @Value("${org.muhia.psi.ussd.response.message.userParameterKey}")
    private String userParameterKey;
    @Value("${org.muhia.psi.ussd.response.message.roleParameterKey}")
    private String roleParameterKey;
    @Value("${org.muhia.psi.ussd.response.message.smsParameterKey}")
    private String smsParameterKey;
    @Value("${org.muhia.psi.ussd.response.message.msisdnKeyword}")
    private String msisdnKeyword;
    @Value("${org.muhia.psi.ussd.response.message.saccoParameterKey}")
    private String saccoParameterKey;
    @Value("${org.muhia.psi.ussd.response.actions.productIdKeyword}")
    private String productIdKeyword;
    @Value("${org.muhia.psi.ussd.response.actions.initWorkOrderStatus}")
    private String initWorkOrderStatus;
    @Value("${org.muhia.psi.ussd.response.actions.testStatusKeyword}")
    private int testStatusKeyword;
    @Value("${org.muhia.psi.ussd.response.actions.adminRoleKeyword}")
    private String adminRoleKeyword;
    @Value("${org.muhia.psi.spring.ussd.code.status.active}")
    private int ussdCodeActive;
    @Value("${org.muhia.psi.spring.ussd.code.status.inactive}")
    private int ussdCodeInactive;
    @Value("${org.muhia.psi.spring.ussd.code.status.test}")
    private int ussdCodeTest;
    @Value("${org.muhia.psi.spring.sms.code.status.active}")
    private int smsCodeActive;
    @Value("${org.muhia.psi.spring.sms.code.status.inactive}")
    private int smsCodeInactive;
    @Value("${org.muhia.psi.spring.sms.code.status.test}")
    private int smsCodeTest;
    @Value("${org.muhia.psi.spring.sms.code.status.subscriberWhitelistedErrorMessage}")
    private String subscriberWhitelistedErrorMessage;
    @Value("${org.muhia.psi.spring.default.code.status.active}")
    private int statusActive;
    @Value("${org.muhia.psi.spring.default.code.status.inactive}")
    private int statusInactive;
    @Value("${org.muhia.psi.ussd.response.actions.adminTasksKeyword}")
    private String adminTasksKeyword;
    @Value("${org.muhia.psi.ussd.response.actions.viewLoan}")
    private String viewLoanKey;
    @Value("${org.muhia.psi.ussd.response.actions.approveLoan}")
    private String approveLoanKey;
    @Value("${org.muhia.psi.ussd.response.actions.viewLoanMenu}")
    private String viewLoanMenu;
    @Value("${org.muhia.psi.ussd.response.actions.approveLoanMenu}")
    private String approveLoanMenuText;
    @Value("${org.muhia.psi.ussd.response.actions.noLoanText}")
    private String noLoanText;
    @Value("${org.muhia.psi.ussd.response.actions.imsiPrefix}")
    private String imsiPrefix;
    @Value("${org.muhia.psi.ussd.response.actions.saccoAccount}")
    private String saccoAccount;
    @Value("${org.muhia.psi.ussd.response.actions.noLoan}")
    private String noLoanKey;
    @Value("${org.muhia.psi.ussd.response.actions.approveDeclineLoan}")
    private String approveDeclineLoanKey;
    @Value("${org.muhia.psi.ussd.response.actions.addGuarantor}")
    private String addGuarantorKey;
    @Value("${org.muhia.psi.ussd.response.actions.approveGuarantor}")
    private String approveGuarantorKey;
    @Value("${org.muhia.psi.ussd.response.actions.noGuarantorText}")
    private String noGuarantorText;
    @Value("${org.muhia.psi.ussd.response.actions.guaranteeRequests}")
    private String guaranteeRequestsText;
    @Value("${org.muhia.psi.ussd.response.actions.approveDeclineGuarantor}")
    private String approveDeclineGuarantorKey;
    @Value("${org.muhia.psi.ussd.response.actions.saccoViewTargets}")
    private String saccoViewTargetsKey;
    @Value("${org.muhia.psi.ussd.response.actions.noTarget}")
    private String noTargetText;
    @Value("${org.muhia.psi.ussd.response.actions.viewTargets}")
    private String viewTargetsText;
    @Value("${org.muhia.psi.ussd.response.actions.loaneephone}")
    private String loaneePhoneParameter;
    @Value("${org.muhia.psi.ussd.response.actions.guaranteephone}")
    private String guaranteePhoneParameter;
    @Value("${org.muhia.psi.spring.default.code.status.active}")
    private String activeStatus;
    @Value("${org.muhia.psi.spring.default.code.status.menu.secure.no.keyword}")
    private String menuSecureNoKeyword;
    @Value("${org.muhia.psi.spring.default.code.status.menu.secure.yes.keyword}")
    private String menuSecureYesKeyword;
    @Value("${org.muhia.psi.config.menu.ussd.input.password.dialog.keyword}")
    private String inputPasswordDialogKeyword;
    @Value("${org.muhia.psi.config.menu.ussd.missing.value.message}")
    private String missingValueMessage;
    @Value("${org.muhia.psi.config.menu.ussd.max.failed.login.attempts}")
    private int maxFailedLoginAttempts;
    @Value("${org.muhia.psi.config.menu.ussd.session.expiry.minutes}")
    private int sessionExpiryMinutes;
    @Value("${org.muhia.psi.config.menu.ussd.display.default.error.message}")
    private String displayDefaultErrorMessage;
    @Value("${org.muhia.psi.config.menu.ussd.display.missing.menu.message}")
    private String displayMissingMenuMessage;
    @Value("${org.muhia.app.psi.config.ussd.menu.is.ftu.value}")
    private int menuIsFtuValue;
    @Value("${org.muhia.app.psi.config.ussd.menu.not.ftu.value}")
    private int menuNotFtuValue;
    @Value("${org.muhia.app.psi.config.ussd.menu.exceeded.loginattempts.message}")
    private String menuExceededLoginattemptsMessage;
    @Value("${org.muhia.app.psi.config.ussd.menu.tokenreset.process.items}") private  String[] menuTokenresetProcessItems;
    @Value("${org.muhia.psi.spring.default.code.status.menu.loan.rate.query.keyword}")
    private String loanRateQueryKeyword;


    /**
     * @return the duplicateRequestMessage
     */
    public String getDuplicateRequestMessage() {
        return duplicateRequestMessage;
    }

    /**
     * @return the missingParameterMessage
     */
    public String getMissingParameterMessage() {
        return missingParameterMessage;
    }

    /**
     * @return the generalExceptionMessage
     */
    public String getGeneralExceptionMessage() {
        return generalExceptionMessage;
    }

    /**
     * @return the typeMismatchMessage
     */
    public String getTypeMismatchMessage() {
        return typeMismatchMessage;
    }

    /**
     * @return the notOnWhitelistMessage
     */
    public String getNotOnWhitelistMessage() {
        return notOnWhitelistMessage;
    }

    /**
     * @return the invalidInputMessage
     */
    public String getInvalidInputMessage() {
        return invalidInputMessage;
    }

    /**
     * @return the entryPointVar
     */
    public String getEntryPointVar() {
        return entryPointVar;
    }

    /**
     * @return the newRequestVar
     */
    public String getNewRequestVar() {
        return newRequestVar;
    }

    /**
     * @return the oldRequestVar
     */
    public String getOldRequestVar() {
        return oldRequestVar;
    }

    /**
     * @return the endOfSessionFalseVar
     */
    public String getEndOfSessionFalseVar() {
        return endOfSessionFalseVar;
    }

    /**
     * @return the endOfSessionTrueVar
     */
    public String getEndOfSessionTrueVar() {
        return endOfSessionTrueVar;
    }

    /**
     * @return the validUssdReponseStatus
     */
    public String getValidUssdReponseStatus() {
        return validUssdReponseStatus;
    }

    /**
     * @return the invalidUssdReponseStatus
     */
    public String getInvalidUssdReponseStatus() {
        return invalidUssdReponseStatus;
    }

    /**
     * @return the validUssdReponseCode
     */
    public String getValidUssdReponseCode() {
        return validUssdReponseCode;
    }

    /**
     * @return the invalidUssdReponseCode
     */
    public String getInvalidUssdReponseCode() {
        return invalidUssdReponseCode;
    }

    /**
     * @return the badRequestMessage
     */
    public String getBadRequestMessage() {
        return badRequestMessage;
    }

    /**
     * @return the isChoiceYes
     */
    public String getIsChoiceYes() {
        return isChoiceYes;
    }

    /**
     * @return the isChoiceNo
     */
    public String getIsChoiceNo() {
        return isChoiceNo;
    }

    /**
     * @return the numTextSeparator
     */
    public String getNumTextSeparator() {
        return numTextSeparator;
    }

    /**
     * @return the eolChar
     */
    public String getEolChar() {
        return eolChar;
    }

    /**
     * @return the nextPageChar
     */
    public String getNextPageChar() {
        return nextPageChar;
    }

    /**
     * @return the prevPageChar
     */
    public String getPrevPageChar() {
        return prevPageChar;
    }

    /**
     * @return the goBackMessage
     */
    public String getGoBackMessage() {
        return goBackMessage;
    }

    /**
     * @return the goPrevMessage
     */
    public String getGoPrevMessage() {
        return goPrevMessage;
    }

    /**
     * @return the goBackVar
     */
    public String getGoBackVar() {
        return goBackVar;
    }

    /**
     * @return the goPrevVar
     */
    public String getGoPrevVar() {
        return goPrevVar;
    }

    /**
     * @return the ussdSuccessStatus
     */
    public String getUssdSuccessStatus() {
        return ussdSuccessStatus;
    }

    /**
     * @return the ussdSuccessProcessStatus
     */
    public String getUssdSuccessProcessStatus() {
        return ussdSuccessProcessStatus;
    }

    /**
     * @return the ussdResponseCodeDeleted
     */
    public String getUssdResponseCodeDeleted() {
        return ussdResponseCodeDeleted;
    }

    /**
     * @return the ussdFailureStatus
     */
    public String getUssdFailureStatus() {
        return ussdFailureStatus;
    }

    /**
     * @return the ussdInternalServerErrorStatus
     */
    public String getUssdInternalServerErrorStatus() {
        return ussdInternalServerErrorStatus;
    }

    /**
     * @return the ussdWrongNumberFormatStatus
     */
    public String getUssdWrongNumberFormatStatus() {
        return ussdWrongNumberFormatStatus;
    }

    /**
     * @return the ussdResponseCodeDefault
     */
    public String getUssdResponseCodeDefault() {
        return ussdResponseCodeDefault;
    }

    /**
     * @return the ussdNotAllowedResponse
     */
    public String getUssdNotAllowedResponse() {
        return ussdNotAllowedResponse;
    }

    /**
     * @return the ussdInvalidInputVar
     */
    public String getUssdInvalidInputVar() {
        return ussdInvalidInputVar;
    }

    /**
     * @return the credentialsVar
     */
    public String getCredentialsVar() {
        return credentialsVar;
    }

    /**
     * @return the credentialVar
     */
    public String getCredentialVar() {
        return credentialVar;
    }

    /**
     * @return the processKeyword
     */
    public String getProcessKeyword() {
        return processKeyword;
    }

    /**
     * @return the productKeyword
     */
    public String getProductKeyword() {
        return productKeyword;
    }

    /**
     * @return the separatorKeywordVar
     */
    public String getSeparatorKeywordVar() {
        return separatorKeywordVar;
    }


    public String getSessionEndVar() {
        return sessionEndVar;
    }

    public String getAppNameUser() {
        return appNameUser;
    }

    public void setAppNameUser(String appNameUser) {
        this.appNameUser = appNameUser;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getUssdUserType() {
        return ussdUserType;
    }

    public String getUssdUserRole() {
        return ussdUserRole;
    }

    public String getAppEmail() {
        return appEmail;
    }

    public String getFullNameKeyword() {
        return fullNameKeyword;
    }

    public void setFullNameKeyword(String fullNameKeyword) {
        this.fullNameKeyword = fullNameKeyword;
    }

    public String getOtpKeyword() {
        return otpKeyword;
    }

    public void setOtpKeyword(String otpKeyword) {
        this.otpKeyword = otpKeyword;
    }

    public String getUserParameterKey() {
        return userParameterKey;
    }

    public void setUserParameterKey(String userParameterKey) {
        this.userParameterKey = userParameterKey;
    }

    public String getSmsParameterKey() {
        return smsParameterKey;
    }

    public void setSmsParameterKey(String smsParameterKey) {
        this.smsParameterKey = smsParameterKey;
    }

    public String getMsisdnKeyword() {
        return msisdnKeyword;
    }

    public void setMsisdnKeyword(String msisdnKeyword) {
        this.msisdnKeyword = msisdnKeyword;
    }

    public String getSaccoParameterKey() {
        return saccoParameterKey;
    }

    public void setSaccoParameterKey(String saccoParameterKey) {
        this.saccoParameterKey = saccoParameterKey;
    }

    public String getProductIdKeyword() {
        return productIdKeyword;
    }

    public void setProductIdKeyword(String productIdKeyword) {
        this.productIdKeyword = productIdKeyword;
    }

    public String getInitWorkOrderStatus() {
        return initWorkOrderStatus;
    }

    public void setInitWorkOrderStatus(String initWorkOrderStatus) {
        this.initWorkOrderStatus = initWorkOrderStatus;
    }

    public String getRoleParameterKey() {
        return roleParameterKey;
    }

    public String getFirstTimeVar() {
        return firstTimeVar;
    }

    public void setFirstTimeVar(String firstTimeVar) {
        this.firstTimeVar = firstTimeVar;
    }

    public String getLogInVar() {
        return logInVar;
    }

    public void setLogInVar(String logInVar) {
        this.logInVar = logInVar;
    }


    public int getTestStatusKeyword() {
        return testStatusKeyword;
    }

    public void setTestStatusKeyword(int testStatusKeyword) {
        this.testStatusKeyword = testStatusKeyword;
    }

    public String getAdminRoleKeyword() {
        return adminRoleKeyword;
    }

    public void setAdminRoleKeyword(String adminRoleKeyword) {
        this.adminRoleKeyword = adminRoleKeyword;
    }

    public int getUssdCodeActive() {
        return ussdCodeActive;
    }

    public void setUssdCodeActive(int ussdCodeActive) {
        this.ussdCodeActive = ussdCodeActive;
    }

    public int getUssdCodeInactive() {
        return ussdCodeInactive;
    }

    public void setUssdCodeInactive(int ussdCodeInactive) {
        this.ussdCodeInactive = ussdCodeInactive;
    }

    public int getUssdCodeTest() {
        return ussdCodeTest;
    }

    public void setUssdCodeTest(int ussdCodeTest) {
        this.ussdCodeTest = ussdCodeTest;
    }

    public int getSmsCodeActive() {
        return smsCodeActive;
    }

    public void setSmsCodeActive(int smsCodeActive) {
        this.smsCodeActive = smsCodeActive;
    }

    public int getSmsCodeInactive() {
        return smsCodeInactive;
    }

    public void setSmsCodeInactive(int smsCodeInactive) {
        this.smsCodeInactive = smsCodeInactive;
    }

    public int getSmsCodeTest() {
        return smsCodeTest;
    }

    public void setSmsCodeTest(int smsCodeTest) {
        this.smsCodeTest = smsCodeTest;
    }

    public String getSubscriberWhitelistedErrorMessage() {
        return subscriberWhitelistedErrorMessage;
    }

    public void setSubscriberWhitelistedErrorMessage(String subscriberWhitelistedErrorMessage) {
        this.subscriberWhitelistedErrorMessage = subscriberWhitelistedErrorMessage;
    }

    public int getStatusActive() {
        return statusActive;
    }

    public void setStatusActive(int statusActive) {
        this.statusActive = statusActive;
    }

    public String getAdminTasksKeyword() {
        return adminTasksKeyword;
    }

    public int getStatusInactive() {
        return statusInactive;
    }

    public String getViewLoanKey() {
        return viewLoanKey;
    }

    public String getApproveLoanKey() {
        return approveLoanKey;
    }

    public String getViewLoanMenu() {
        return viewLoanMenu;
    }

    public String getApproveLoanMenuText() {
        return approveLoanMenuText;
    }

    public String getNoLoanText() {
        return noLoanText;
    }

    public String getImsiPrefix() {
        return imsiPrefix;
    }

    public String getSaccoAccount() {
        return saccoAccount;
    }

    public String getNoLoanKey() {
        return noLoanKey;
    }

    public String getApproveDeclineLoanKey() {
        return approveDeclineLoanKey;
    }

    public String getAddGuarantorKey() {
        return addGuarantorKey;
    }

    public String getApproveGuarantorKey() {
        return approveGuarantorKey;
    }

    public String getNoGuarantorText() {
        return noGuarantorText;
    }

    public String getGuaranteeRequestsText() {
        return guaranteeRequestsText;
    }

    public String getApproveDeclineGuarantorKey() {
        return approveDeclineGuarantorKey;
    }

    public String getSaccoViewTargetsKey() {
        return saccoViewTargetsKey;
    }

    public String getNoTargetText() {
        return noTargetText;
    }

    public String getViewTargetsText() {
        return viewTargetsText;
    }

    public String getLoaneePhoneParameter() {
        return loaneePhoneParameter;
    }

    public String getGuaranteePhoneParameter() {
        return guaranteePhoneParameter;
    }

    public String getActiveStatus() {
        return activeStatus;
    }


    public String getMenuSecureNoKeyword() {
        return menuSecureNoKeyword;
    }

    public String getMenuSecureYesKeyword() {
        return menuSecureYesKeyword;
    }

    public void setMenuSecureYesKeyword(String menuSecureYesKeyword) {
        this.menuSecureYesKeyword = menuSecureYesKeyword;
    }

    public String getInputPasswordDialogKeyword() {
        return inputPasswordDialogKeyword;
    }

    public String getMissingValueMessage() {
        return missingValueMessage;
    }

    public int getMaxFailedLoginAttempts() {
        return maxFailedLoginAttempts;
    }

    public int getSessionExpiryMinutes() {
        return sessionExpiryMinutes;
    }

    public String getDisplayDefaultErrorMessage() {
        return displayDefaultErrorMessage;
    }


    public String getDisplayMissingMenuMessage() {
        return displayMissingMenuMessage;
    }


    public int getMenuIsFtuValue() {
        return menuIsFtuValue;
    }

    public int getMenuNotFtuValue() {
        return menuNotFtuValue;
    }

    public String getMenuExceededLoginattemptsMessage() {
        return menuExceededLoginattemptsMessage;
    }

    public String getMenuRegisteredUserEntrypoint() {
        return menuRegisteredUserEntrypoint;
    }

    public String[] getMenuTokenresetProcessItems() {
        return menuTokenresetProcessItems;
    }

    public String getLoanRateQueryKeyword() {
        return loanRateQueryKeyword;
    }
}
