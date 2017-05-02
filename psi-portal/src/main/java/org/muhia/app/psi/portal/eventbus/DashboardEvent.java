package org.muhia.app.psi.portal.eventbus;


import org.apache.http.HttpStatus;
import org.muhia.app.psi.orm.model.*;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

/*
 * Event bus events used for the UI are listed here as inner classes.
 */
@Component
public abstract class DashboardEvent {
    public static final class TokenResetRequestReceivedEvent {
        private String subno;
        private String code;
        private int status;
        private String output;
        private HttpHeaders httpHeaders;

        public TokenResetRequestReceivedEvent(String subno, String code, int status) {
            this.subno = subno;
            this.code = code;
            this.status = status;
        }

        public String getSubno() {
            return subno;
        }

        public void setSubno(String subno) {
            this.subno = subno;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getOutput() {
            return output;
        }

        public void setOutput(String output) {
            this.output = output;
        }

        public HttpHeaders getHttpHeaders() {
            return httpHeaders;
        }

        public void setHttpHeaders(HttpHeaders httpHeaders) {
            this.httpHeaders = httpHeaders;
        }
    }
    public static final class WhitelistSubscriberRequestReceivedEvent {
        private String subno;
        private String code;
        private int status;
        private String output;
        private HttpHeaders httpHeaders;

        public WhitelistSubscriberRequestReceivedEvent(String subno,String code, int status, HttpHeaders httpHeaders){
            this.setSubno(subno);
            this.setCode(code);
            this.setStatus(status);
            this.setHttpHeaders(httpHeaders);
            this.setOutput(null);
        }

        String getSubno() {
            return subno;
        }

        void setSubno(String subno) {
            this.subno = subno;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public HttpHeaders getHttpHeaders() {
            return httpHeaders;
        }

        void setHttpHeaders(HttpHeaders httpHeaders) {
            this.httpHeaders = httpHeaders;
        }

        public String getOutput() {
            return output;
        }

        public void setOutput(String output) {
            this.output = output;
        }
    }

    public static final class ReverseHasherAdminTaskRequestReceivedEvent {
        private String input;
        private String output;
        private HttpHeaders httpHeaders;

        public ReverseHasherAdminTaskRequestReceivedEvent(String input, String output, HttpHeaders httpHeaders) {
            this.setInput(input);
            this.setOutput(output);
            this.setHttpHeaders(httpHeaders);
        }

        public String getInput() {
            return input;
        }

        public void setInput(String input) {
            this.input = input;
        }

        public String getOutput() {
            return output;
        }

        public void setOutput(String output) {
            this.output = output;
        }

        public HttpHeaders getHttpHeaders() {
            return httpHeaders;
        }

        void setHttpHeaders(HttpHeaders httpHeaders) {
            this.httpHeaders = httpHeaders;
        }
    }
    public static final class HasherAdminTaskRequestReceivedEvent {
        private String input;
        private String output;
        private HttpHeaders httpHeaders;

        public HasherAdminTaskRequestReceivedEvent(String input, String output, HttpHeaders httpHeaders) {
            this.setInput(input);
            this.setOutput(output);
            this.setHttpHeaders(httpHeaders);
        }


        public String getInput() {
            return input;
        }

        public void setInput(String input) {
            this.input = input;
        }

        public String getOutput() {
            return output;
        }

        public void setOutput(String output) {
            this.output = output;
        }

        public HttpHeaders getHttpHeaders() {
            return httpHeaders;
        }

        void setHttpHeaders(HttpHeaders httpHeaders) {
            this.httpHeaders = httpHeaders;
        }
    }

    public static final class ProcessPendingServiceRequestsEvent {
        private final ServiceRequests serviceRequests;

        public ProcessPendingServiceRequestsEvent(ServiceRequests serviceRequests) {
            this.serviceRequests = serviceRequests;

        }

        ServiceRequests getServiceRequests() {
            return serviceRequests;
        }
    }

    public static final class ServiceActivationEvent {

        private final OrderMaster order;
        private final Map<?, ?> orderMap;

        public ServiceActivationEvent(OrderMaster order) {
            this.order = order;
            this.orderMap = new HashMap<>();
        }

        ServiceActivationEvent(OrderMaster order, Map<String, String> orderMap) {
            this.order = order;
            this.orderMap = orderMap;
        }

        public OrderMaster getOrder() {
            return order;
        }

        public Map<?, ?> getOrderMap() {
            return orderMap;
        }
    }

    public static final class SmsOrderCreationRequestEvent {
        private SmsRegistry smsRegistry;
        private String messages;
        private ProductsMaster productsMaster;
        private Map<String, String> productParamsMap;

        public SmsOrderCreationRequestEvent(SmsRegistry smsRegistry, String messages, ProductsMaster productsMaster) {
            this.smsRegistry = smsRegistry;
            this.messages = messages;
            this.productsMaster = productsMaster;
            this.productParamsMap = null;
        }

        public SmsOrderCreationRequestEvent(SmsRegistry smsRegistry, String messages, ProductsMaster productsMaster, Map<String, String> productParamsMap) {
            this.smsRegistry = smsRegistry;
            this.messages = messages;
            this.productsMaster = productsMaster;
            this.productParamsMap = productParamsMap;
        }


        SmsRegistry getSmsRegistry() {
            return smsRegistry;
        }

        public void setSmsRegistry(SmsRegistry smsRegistry) {
            this.smsRegistry = smsRegistry;
        }

        public String getMessages() {
            return messages;
        }

        public void setMessages(String messages) {
            this.messages = messages;
        }

        ProductsMaster getProductsMaster() {
            return productsMaster;
        }

        public void setProductsMaster(ProductsMaster productsMaster) {
            this.productsMaster = productsMaster;
        }

        public Map<String, String> getProductParamsMap() {
            return productParamsMap;
        }

        public void setProductParamsMap(Map<String, String> productParamsMap) {
            this.productParamsMap = productParamsMap;
        }
    }


    public static final class UssdOrderCreationRequestedEvent {

        //        private final OrderMaster orderMaster;
        private final UssdRequests ussdRequests;
        private final String messages;

        private final Map<String, String> productParamsMap;

        UssdOrderCreationRequestedEvent(Map<String, String> productParamsMap, UssdRequests ussdRequests, String messages) {
//            this.orderMaster = orderMaster;
            this.ussdRequests = ussdRequests;
            this.messages = messages;
            this.productParamsMap = productParamsMap;
        }

        UssdRequests getUssdRequests() {
            return ussdRequests;
        }

        public String getMessages() {
            return messages;
        }

        public Map<String, String> getProductParamsMap() {
            return productParamsMap;
        }
    }


    public static final class UserLoginRequestedEvent {

        private final String userName, password;
        private final boolean rememberMe;
        private boolean success;

        public UserLoginRequestedEvent(final String userName, final String password) {
            this.userName = userName;
            this.password = password;
            this.rememberMe = false;
            this.success = false;
        }

        public UserLoginRequestedEvent(final String userName, final String password, boolean rememberMe) {
            this.userName = userName;
            this.password = password;
            this.rememberMe = rememberMe;
            this.success = false;
        }

        String getUserName() {
            return userName;
        }

        public String getPassword() {
            return password;
        }

        /**
         * @return the rememberMe
         */
        public boolean isRememberMe() {
            return rememberMe;
        }

        /**
         * @return the success
         */
        public boolean isSuccess() {
            return success;
        }

        /**
         * @param success the success to set
         */
        public void setSuccess(boolean success) {
            this.success = success;
        }
    }


    public static class UssdRequestProcessingSubmitEvent {

        private UssdRequests requests;
        private String methodName;
        private String messages;

        public UssdRequestProcessingSubmitEvent(UssdRequests requests, String methodName, String messages) {
            this.requests = requests;
            this.methodName = methodName;
            this.messages = messages;

        }

        /**
         * @return the requests
         */
        public UssdRequests getRequests() {
            return requests;
        }

        /**
         * @param requests the requests to set
         */
        public void setRequests(UssdRequests requests) {
            this.requests = requests;
        }

        /**
         * @return the methodName
         */
        public String getMethodName() {
            return methodName;
        }

        /**
         * @param methodName the methodName to set
         */
        public void setMethodName(String methodName) {
            this.methodName = methodName;
        }

        /**
         * @return the messages
         */
        public String getMessages() {
            return messages;
        }

        /**
         * @param messages the messages to set
         */
        public void setMessages(String messages) {
            this.messages = messages;
        }
    }

    public static class UssdRequestReceivedEvent {

        final StringBuilder requestParameters;
        private UssdRequests ussdRequests;
        private UssdResponses ussdResponses;
        private String messages;
        private HttpHeaders responseHeaders;
        private HttpStatus httpStatus;

        public UssdRequestReceivedEvent(UssdRequests ussdRequests, String messages, HttpHeaders responseHeaders, StringBuilder requestParameters) {
            this.ussdRequests = ussdRequests;
            this.messages = messages;
            this.responseHeaders = responseHeaders;
            this.httpStatus = null;
            this.requestParameters = requestParameters;
            this.ussdResponses = null;

        }

        public UssdRequestReceivedEvent(UssdRequests ussdRequests, UssdResponses ussdResponses, String messages, HttpHeaders responseHeaders, StringBuilder requestParameters) {
            this.ussdRequests = ussdRequests;
            this.messages = messages;
            this.responseHeaders = responseHeaders;
            this.httpStatus = null;
            this.requestParameters = requestParameters;
            this.ussdResponses = ussdResponses;

        }

        /**
         * @return the ussdRequests
         */
        UssdRequests getUssdRequests() {
            return ussdRequests;
        }

        /**
         * @param ussdRequests the ussdRequests to set
         */
        void setUssdRequests(UssdRequests ussdRequests) {
            this.ussdRequests = ussdRequests;
        }

        /**
         * @return the messages
         */
        public String getMessages() {
            return messages;
        }

        /**
         * @param messages the messages to set
         */
        public void setMessages(String messages) {
            this.messages = messages;
        }

        /**
         * @return the httpHeaders
         */
        public HttpHeaders getResponseHeaders() {
            return responseHeaders;
        }

        /**
         * @param responseHeaders the httpHeaders to set
         */
        void setResponseHeaders(HttpHeaders responseHeaders) {
            this.responseHeaders = responseHeaders;
        }

        public HttpStatus getHttpStatus() {
            return httpStatus;
        }

        /**
         * @return the requestParameters
         */
        StringBuilder getRequestParameters() {
            return requestParameters;
        }

        public UssdResponses getUssdResponses() {
            return ussdResponses;
        }

        void setUssdResponses(UssdResponses ussdResponses) {
            this.ussdResponses = ussdResponses;
        }
    }

    public static class PrincipalsRegstrationConfirmationEvent {

        private final String token;

        private final RedirectAttributes redirectAttributes;

        public PrincipalsRegstrationConfirmationEvent(final String token, RedirectAttributes redirectAttributes) {
            this.token = token;
            this.redirectAttributes = redirectAttributes;
        }

        /**
         * @return the token
         */
        public String getToken() {
            return token;
        }

        /**
         * @return the session
         */
        public RedirectAttributes getRedirectAttributes() {
            return redirectAttributes;
        }
    }

    public static class RegistrationCompletedEvent {

        private String appUrl;
        private Principals user;

        public RegistrationCompletedEvent(String url, Principals user) {
            this.appUrl = url;
            this.user = user;
        }

        /**
         * @return the appUrl
         */
        String getAppUrl() {
            return appUrl;
        }

        /**
         * @param appUrl the appUrl to set
         */
        public void setAppUrl(String appUrl) {
            this.appUrl = appUrl;
        }

        /**
         * @return the user
         */
        public Principals getUser() {
            return user;
        }

        /**
         * @param user the user to set
         */
        public void setUser(Principals user) {
            this.user = user;
        }

    }

    public static class GuarantorRequestedCompletedEvent {

        Map<String, String> productParamsMap = new HashMap<>();

        public GuarantorRequestedCompletedEvent(Map<String, String> guarantor) {
            this.productParamsMap = guarantor;
        }

        Map<String, String> getGuarantorRequestedEvent() {
            return productParamsMap;
        }
    }

    public static class LoanRequestedCompletedEvent {

        Map<String, String> productParamsMap = new HashMap<>();

        public LoanRequestedCompletedEvent(Map<String, String> productParamsMap) {
            this.productParamsMap = productParamsMap;
        }

        Map<String, String> getLoanRequestedEvent() {
            return this.productParamsMap;
        }
    }

    public static class GuarantorApproveCompletedEvent {

        private final PrincipalsGuarantor request;

        public GuarantorApproveCompletedEvent(PrincipalsGuarantor guarantor) {
            this.request = guarantor;
        }

        PrincipalsGuarantor getGuarantorApproveDeclineEvent() {
            return request;
        }
    }

    public static class GuarantorDeclineCompletedEvent {

        private final PrincipalsGuarantor request;

        public GuarantorDeclineCompletedEvent(PrincipalsGuarantor guarantor) {
            this.request = guarantor;
        }

        PrincipalsGuarantor getGuarantorApproveDeclineEvent() {
            return request;
        }
    }

    public static final class RegisterBeneficiaryEvent {

        private final UserBeneficiaries userBeneficiaries;
        private final Principals principals;

        public RegisterBeneficiaryEvent(UserBeneficiaries userBeneficiaries, Principals principals) {
            this.userBeneficiaries = userBeneficiaries;
            this.principals = principals;
        }

        public UserBeneficiaries getUserBeneficiaries() {
            return userBeneficiaries;
        }

        public Principals getPrincipals() {
            return principals;
        }

    }

    public static final class EditBeneficiaryEvent {

        private final UserBeneficiaries userBeneficiaries;
        private final Long id;
        private final Principals principals;

        public EditBeneficiaryEvent(UserBeneficiaries userBeneficiaries, Long id, Principals principals) {
            this.userBeneficiaries = userBeneficiaries;
            this.id = id;
            this.principals = principals;
        }

        public UserBeneficiaries getUserBeneficiaries() {
            return userBeneficiaries;
        }

        public Long getId() {
            return id;
        }

        public Principals getPrincipals() {
            return principals;
        }

    }

    public static final class DeleteBeneficiaryEvent {

        private final Long id;
        private final Principals principals;

        public DeleteBeneficiaryEvent(Long id, Principals principals) {
            this.id = id;
            this.principals = principals;
        }

        public Long getId() {
            return id;
        }

        public Principals getPrincipals() {
            return principals;
        }

    }

    public static final class ForgotPasswordEvent {
        private final Principals principals;
        private String appUrl;

        public ForgotPasswordEvent(Principals principals, String appUrl) {
            this.principals = principals;
            this.appUrl = appUrl;
        }

        public Principals getPrincipals() {
            return principals;
        }

        String getAppUrl() {
            return appUrl;
        }

        public void setAppUrl(String appUrl) {
            this.appUrl = appUrl;
        }

    }


    public static final class ForgotPasswordConfirmEvent {
        private final String token;
        private final RedirectAttributes redirectAttributes;
        private final String password;

        public ForgotPasswordConfirmEvent(String token, RedirectAttributes redirectAttributes, String password) {
            this.token = token;
            this.redirectAttributes = redirectAttributes;
            this.password = password;
        }

        public String getToken() {
            return token;
        }

        public RedirectAttributes getRedirectAttributes() {
            return redirectAttributes;
        }

        public String getPassword() {
            return password;
        }


    }


    public static final class ChangePasswordEvent {

        private final String newpassword;
        private final String oldpassword;
        private final String answer;
        private final RedirectAttributes redirectAttributes;
        private final Principals principals;
        private final UserSecurityQuestions userSecurityQuestions;

        public ChangePasswordEvent(String newpassword, String oldpassword, String answer, RedirectAttributes redirectAttributes, Principals principals, UserSecurityQuestions userSecurityQuestions) {
            this.newpassword = newpassword;
            this.oldpassword = oldpassword;
            this.answer = answer;
            this.redirectAttributes = redirectAttributes;
            this.principals = principals;
            this.userSecurityQuestions = userSecurityQuestions;
        }

        String getNewpassword() {
            return newpassword;
        }

        String getOldpassword() {
            return oldpassword;
        }

        public String getAnswer() {
            return answer;
        }

        public RedirectAttributes getRedirectAttributes() {
            return redirectAttributes;
        }

        public Principals getPrincipals() {
            return principals;
        }

        UserSecurityQuestions getUserSecurityQuestions() {
            return userSecurityQuestions;
        }

    }

    public static final class ModifyUserEvent {

        private final Principals principals;
        private final RedirectAttributes redirectAttributes;

        public ModifyUserEvent(Principals principals, RedirectAttributes redirectAttributes) {
            this.principals = principals;
            this.redirectAttributes = redirectAttributes;
        }

        public Principals getPrincipals() {
            return principals;
        }

        public RedirectAttributes getRedirectAttributes() {
            return redirectAttributes;
        }

    }

    public static final class SavingsTargetcreatedEvent {
        Map<String, String> productParamsMap = new HashMap<>();

        public SavingsTargetcreatedEvent(Map<String, String> target) {
            this.productParamsMap = target;

        }

        Map<String, String> getPrincipalsSavingsTarget() {
            return productParamsMap;
        }

    }

    public static final class ApiCompleteRegistrationEvent {
        private final String credentials;
        private final String username;
        private final String email;
        private final Principals principals;

        public ApiCompleteRegistrationEvent(String credentials, String username, String email, Principals principals) {
            this.credentials = credentials;
            this.username = username;
            this.email = email;
            this.principals = principals;
        }

        public String getCredentials() {
            return credentials;
        }

        public String getUsername() {
            return username;
        }

        public String getEmail() {
            return email;
        }

        public Principals getPrincipals() {
            return principals;
        }
    }

    public static final class RafikiLoanRequestcreatedEvent {
        Map<String, String> productParamsMap = new HashMap<>();

        public RafikiLoanRequestcreatedEvent(Map<String, String> target) {
            this.productParamsMap = target;

        }

        Map<String, String> getRafikiLoanRequest() {
            return productParamsMap;
        }

    }

    public static final class RafikiLoanDeniedEvent {
        Map<String, String> productParamsMap = new HashMap<>();

        public RafikiLoanDeniedEvent(Map<String, String> target) {
            this.productParamsMap = target;

        }

        Map<String, String> getRafikiLoanDenied() {
            return productParamsMap;
        }

    }
    public static final class savingsTargetDeactivateEvent {
        Map<String, String> productParamsMap = new HashMap<>();

        public savingsTargetDeactivateEvent(Map<String, String> target) {
            this.productParamsMap = target;

        }

        Map<String, String> getSavingsTargetDeactivate() {
            return productParamsMap;
        }

    }

    public static final class RafikiLoanApprovedEvent {
        Map<String, String> productParamsMap = new HashMap<>();

        public RafikiLoanApprovedEvent(Map<String, String> target) {
            this.productParamsMap = target;

        }

        Map<String, String> getRafikiLoanApprovedEvent() {
            return productParamsMap;
        }
    }

    public static final class ApiRegistrationEvent {
        Map<String, String> productParamsMap = new HashMap<>();

        public ApiRegistrationEvent(Map<String, String> target) {
            this.productParamsMap = target;

        }

        Map<String, String> getPrincipalDetails() {
            return productParamsMap;
        }
    }
    
    public static final class SendBulkSmsEvent{
        private final MultipartFile smscsv;
        private final Boolean single;
        private final String message;

        public SendBulkSmsEvent(MultipartFile smscsv,Boolean single,String message) {

            this.smscsv = smscsv;
            this.single=single;
            this.message=message;
        }

        public MultipartFile getSmscsv() {
            return smscsv;
        }

        public Boolean getSingle() {
            return single;
        }

        public String getMessage() {
            return message;
        }
    }
}
