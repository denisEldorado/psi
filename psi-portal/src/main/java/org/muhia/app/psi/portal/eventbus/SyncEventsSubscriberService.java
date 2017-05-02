/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.eventbus;

import com.google.common.eventbus.Subscribe;
import org.hibernate.exception.ConstraintViolationException;
import org.muhia.app.psi.config.CustomUtilities;
import org.muhia.app.psi.config.mail.properties.MailerProperties;
import org.muhia.app.psi.config.menu.ussd.MenuMessages;
import org.muhia.app.psi.config.org.properties.OrganizationProperties;
import org.muhia.app.psi.config.security.HashingImplementation;
import org.muhia.app.psi.config.security.properties.UserAccountStatus;
import org.muhia.app.psi.infra.dto.MailDTO;
import org.muhia.app.psi.orm.model.*;
import org.muhia.app.psi.portal.PortalApplication;
import org.muhia.app.psi.portal.service.mail.IFreemarkerMailService;
import org.muhia.app.psi.portal.service.orm.*;
import org.muhia.app.psi.portal.service.sms.ISmsBrokerService;
import org.muhia.app.psi.portal.service.ussd.IUssdMenuProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@Service
public class SyncEventsSubscriberService {


    private final AuthenticationManager authenticationManager;
    private final MailerProperties mailerProperties;
    private final OrganizationProperties op;
    private final MenuMessages menuMessages;
    private final IUssdRequestsProcessorService requestService;
    private final IUssdMenuProcessorService menuProcessorService;

    private final IUserBeneficiariesService userBeneficiariesService;
    private final IPasswordResetTokenService passwordResetTokenService;
    private final PasswordEncoder passwordEncoder;
    private final HashingImplementation hashingImplementation;
    private final IPrincipalsService principalsService;
    private final IFreemarkerMailService mailService;
    private final ISmsBrokerService smsBrokerService;
    private final UserAccountStatus accountStatus;
    private final CustomUtilities utilities;
    private final IUssdPrePostProcessor prePostProcessor;


    @Autowired
    public SyncEventsSubscriberService(SyncEventBusService service, HashingImplementation hashingImplementation, IPrincipalsService principalsService, MailerProperties mailerProperties, AuthenticationManager authenticationManager, OrganizationProperties op, IUssdMenuProcessorService menuProcessorService, IFreemarkerMailService mailService, MenuMessages menuMessages, ISmsBrokerService smsBrokerService, IUssdRequestsProcessorService requestService, UserAccountStatus accountStatus, IUserBeneficiariesService userBeneficiariesService, IPasswordResetTokenService passwordResetTokenService, PasswordEncoder passwordEncoder, CustomUtilities utilities, IUssdPrePostProcessor prePostProcessor) {
        this.menuProcessorService = menuProcessorService;
        this.prePostProcessor = prePostProcessor;
        service.register(SyncEventsSubscriberService.this);

        this.hashingImplementation = hashingImplementation;
        this.principalsService = principalsService;
        this.mailerProperties = mailerProperties;
        this.authenticationManager = authenticationManager;
        this.op = op;

        this.mailService = mailService;
        this.menuMessages = menuMessages;
        this.smsBrokerService = smsBrokerService;
        this.requestService = requestService;
        this.accountStatus = accountStatus;
        this.userBeneficiariesService = userBeneficiariesService;
        this.passwordResetTokenService = passwordResetTokenService;
        this.passwordEncoder = passwordEncoder;
        this.utilities = utilities;
    }

    private Map<String, String> extractMapFromSessionId(String sessionId) {
        Map<String, String> results = new HashMap<>();

        Optional<Collection<UssdRequests>> sessionRequests = requestService.findUssdRequestsBySessionIdAndStatusAndVarFld4Exists(sessionId, menuMessages.getUssdSuccessStatus());

        try {

            sessionRequests.ifPresent(sr -> sr.forEach(u -> {

                if (u.getVarFld4() != null || u.getVarFld4().length() > 1) {
                    results.put(u.getVarFld4(), u.getVarFld3() == null || u.getVarFld3().length() < 1 ? "" : u.getVarFld3());
                }
                if (u.getVarFld8() != null) {
                    results.put(u.getVarFld8(), u.getVarFld7() == null || u.getVarFld7().length() < 1 ? "" : u.getVarFld7());
                }
                if (u.getVarFld10() != null) {
                    results.put(u.getVarFld10(), u.getVarFld9() == null || u.getVarFld9().length() < 1 ? "" : u.getVarFld9());
                }
            }));

        } catch (Exception e) {
            Logger.getLogger(SyncEventsSubscriberService.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return results;
    }


    private String displayUssdMenu(Collection<UssdMenuImsiCodeVw> menuItems, String parentId, String sessionId) {
        String results;
        final String[] methodResults = new String[1];
        final String[] methodName = new String[1];
        List<String> paramStr = new ArrayList<>();


        try {
            StringBuilder builder = new StringBuilder();
            /*
             * Filter menuItems by parentId
			 */
            final AtomicInteger counter = new AtomicInteger();

            List<UssdMenuImsiCodeVw> filteredMenuItems = menuItems.stream().filter(m -> m.getMenuKey().equals(parentId)).collect(Collectors.toList());
            //
            // * Do we have a productId somewhere on the filtered items
            //
            List<UssdMenuImsiCodeVw> vws = menuItems.stream().filter(mi -> parentId.equals(mi.getMenuKey()) && menuMessages.getProductIdKeyword().equals(mi.getMenuCondition())).collect(Collectors.toList());
            if (!vws.isEmpty()) {
                UssdMenuImsiCodeVw mvw = vws.get(0);

                try {
                    Long productId = Long.valueOf(mvw.getMenuParameter());
                    Optional<ProductParameters> productParameters = Optional.ofNullable(requestService.findProductParametersByProductId(productId));
                    productParameters.ifPresent(pParams -> {
                        if (pParams.getPlaceHolder1() != null) {
                            paramStr.add(0, pParams.getPlaceHolder1Desc() == null ? pParams.getPlaceHolder1() : pParams.getPlaceHolder1() + pParams.getPlaceHolder1Desc());
                        }
                        if (pParams.getPlaceHolder2() != null) {
                            paramStr.add(1, pParams.getPlaceHolder2Desc() == null ? pParams.getPlaceHolder2() : pParams.getPlaceHolder2() + pParams.getPlaceHolder2Desc());
                        }
                        if (pParams.getPlaceHolder3() != null) {
                            paramStr.add(2, pParams.getPlaceHolder3Desc() == null ? pParams.getPlaceHolder3() : pParams.getPlaceHolder3() + pParams.getPlaceHolder3Desc());
                        }
                        if (pParams.getPlaceHolder4() != null) {
                            paramStr.add(3, pParams.getPlaceHolder4Desc() == null ? pParams.getPlaceHolder4() : pParams.getPlaceHolder4() + pParams.getPlaceHolder4Desc());
                        }
                        if (pParams.getPlaceHolder5() != null) {
                            paramStr.add(4, pParams.getPlaceHolder5Desc() == null ? pParams.getPlaceHolder5() : pParams.getPlaceHolder5() + pParams.getPlaceHolder5Desc());
                        }
                        if (pParams.getPlaceHolder6() != null) {
                            paramStr.add(5, pParams.getPlaceHolder6Desc() == null ? pParams.getPlaceHolder6() : pParams.getPlaceHolder6() + pParams.getPlaceHolder6Desc());
                        }
                        if (pParams.getPlaceHolder7() != null) {
                            paramStr.add(6, pParams.getPlaceHolder7Desc() == null ? pParams.getPlaceHolder7() : pParams.getPlaceHolder7() + pParams.getPlaceHolder7Desc());
                        }
                        if (pParams.getPlaceHolder8() != null) {
                            paramStr.add(7, pParams.getPlaceHolder8Desc() == null ? pParams.getPlaceHolder8() : pParams.getPlaceHolder8() + pParams.getPlaceHolder8Desc());
                        }
                        if (pParams.getPlaceHolder9() != null) {
                            paramStr.add(8, pParams.getPlaceHolder9Desc() == null ? pParams.getPlaceHolder9() : pParams.getPlaceHolder9() + pParams.getPlaceHolder9Desc());
                        }
                        if (pParams.getPlaceHolder10() != null) {
                            paramStr.add(9, pParams.getPlaceHolder10Desc() == null ? pParams.getPlaceHolder10() : pParams.getPlaceHolder10() + pParams.getPlaceHolder10Desc());
                        }

                    });

                } catch (NumberFormatException e) {
                    /*
                     * Invalid Product Id
					 */
                    Logger.getLogger(SyncEventsSubscriberService.class.getName()).log(Level.SEVERE, "{0} we have a none numeric productId {1}", new Object[]{e.getMessage(), mvw.getMenuParameter()});
                }
            }

            if (filteredMenuItems.size() > 0) {
                filteredMenuItems.forEach(um -> {
                    Logger.getLogger(this.getClass().getName()).log(Level.INFO, MessageFormat.format("building variables {0} ", um.getTextVar1()));

                    /**
                     * Add Pre-Processor and Post-Processor parameters for consideration to parameters
                     */
                    if (um.getPreProcessingInfo() != null) {
                        Map<String, String> methodParameters = new HashMap<>();
                        String[] preParts = um.getPreProcessingInfo().split(",");
                        methodName[0] = preParts[0] != null ? preParts[0] : "";

                        for (int i = 1; i < preParts.length; i++) {
                            String[] nameValuePair = preParts[i].split("=");
                            methodParameters.putIfAbsent(nameValuePair[0], nameValuePair[1]);
                        }

                        try {
                            Method method = prePostProcessor.getClass().getMethod(methodName[0], Map.class);
                            methodResults[0] = String.valueOf(method.invoke(prePostProcessor, methodParameters));


                        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, String.format("Reflection failure [Message = %s]", e.getMessage()));
                        }

                    }

                    if (um.getMenuIsChoice() != null && um.getMenuIsChoice().equals(menuMessages.getIsChoiceYes())) {
                        builder.append(counter.incrementAndGet()).append(menuMessages.getNumTextSeparator()).append(um.getTextVar1()).append(menuMessages.getEolChar());
                    } else {
                        builder.append(um.getTextVar1()).append(menuMessages.getEolChar());
                    }


                });

//                 if (!params.equals(null) && params.length > 0) {
//                 results = addParametersToMessage(builder.toString(), params,
//                 sessionId);
//                 } else {
//                 results = builder.toString();
//                 }
                try {
                    List<String> tempList = paramStr.stream().map(s -> {
                        if (s.equals(methodName[0])) return methodResults[0];
                        else return s;
                    }).collect(Collectors.toList());
                    if (!tempList.isEmpty()) {
                        results = addParametersToMessage(builder.toString(), tempList.toArray(), sessionId);
                    } else {

                        if (paramStr.isEmpty()) {
                            results = builder.toString();
                        } else {
                            results = addParametersToMessage(builder.toString(), paramStr.toArray(), sessionId);
                        }
                    }

                } catch (ArrayIndexOutOfBoundsException e) {
                    if (paramStr.isEmpty()) {
                        results = builder.toString();
                    } else {
                        results = addParametersToMessage(builder.toString(), paramStr.toArray(), sessionId);
                    }
                }

                try {
                    /**
                     * TODO: To be removed once we figure out why I have a problem with the last input
                     */
                    Comparator<UssdRequests> comparator = Comparator.comparing(UssdRequests::getRequestDate);
                    UssdRequests maxRequest = requestService.findUssdRequestsBySessionIdAndStatus(sessionId, menuMessages.getUssdSuccessStatus()).stream().filter(ur -> ur.getStatus().equals(menuMessages.getUssdSuccessStatus())).sorted(comparator.reversed()).collect(Collectors.toList()).get(0);
                    String selection = menuItems.stream().filter(m -> maxRequest.getVarFld1().equals(m.getMenuKey()) && m.getMenuIsChoice().equals(menuMessages.getIsChoiceYes())).findAny().orElse(null).getTextVar1();
                    selection = selection == null ? maxRequest.getRequestInput() : selection;
                    for (Object anInput : paramStr) {
                        if (results.contains(anInput.toString())) {
                            results = results.replace(anInput.toString(), selection);
                        }
                    }
                } catch (IndexOutOfBoundsException | NullPointerException e) {
                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage());
                }


            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, MessageFormat.format("filtered items ni zero {0} ", parentId));
//                filteredMenuItems = menuItems.stream().filter(m -> m.getMenuKey().equals(menuMessages.getDisplayMissingMenuMessage())).collect(Collectors.toList());

                results = builder.append(menuItems.stream().filter(m -> m.getMenuKey().equals(menuMessages.getDisplayMissingMenuMessage())).collect(Collectors.toList()).get(0).getTextVar1()).append(menuMessages.getEolChar()).toString();

            }

        } catch (Exception e) {
            Logger.getLogger(SyncEventsSubscriberService.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            results = menuMessages.getGeneralExceptionMessage();
        }

        return results;
    }

    private String addParametersToMessage(String message, Object[] input, String sessionId) {
        Map<String, String> paramsMap = extractMapFromSessionId(sessionId);
        MessageFormat formater = new MessageFormat(message);
        try {

            String results = formater.format(input);
            for (Map.Entry<String, String> entry : paramsMap.entrySet()) {
                results = results.replace(entry.getKey(), entry.getValue());
            }

            return results;
        } catch (NullPointerException e) {
            Logger.getLogger(SyncEventsSubscriberService.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return formater.format(input);
        }
    }


    private HttpHeaders setFlowContinueHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("charge", "N");
        httpHeaders.set("Expires", "-1");
        httpHeaders.set("Pragma", "no-cache");
        httpHeaders.set("Cache-Control", "max-age=0");
        httpHeaders.set("Freeflow", "FC");
//        httpHeaders.set("Content-Type", "text/xml");
        httpHeaders.set("Local-Redirect", "N");
        return httpHeaders;
    }

    private HttpHeaders setFlowBreakHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Expires", "-1");
        httpHeaders.set("charge", "N");
        httpHeaders.set("Pragma", "no-cache");
//        httpHeaders.set("Content-Type", "text/xml");
        httpHeaders.set("Cache-Control", "max-age=0");
        httpHeaders.set("Freeflow", "FB");
        httpHeaders.set("Local-Redirect", "N");
        return httpHeaders;
    }

    @Subscribe
    public void handleTokenResetRequestReceivedEvent(DashboardEvent.TokenResetRequestReceivedEvent e) {
        try {
            e.setOutput(menuMessages.getUssdFailureStatus());
            e.getHttpHeaders().set("TaskResponse", String.format("Subscriber: %s not found!", e.getCode()));
            principalsService.findUserByPhone(e.getSubno()).ifPresent(principals -> {
                String otp = principalsService.generateOneTimePin();
                Principals p = principalsService.changeUserPasswordAndEnableAccount(principals, otp, menuMessages.getAppName());
                Logger.getLogger(this.getClass().getName()).log(Level.FINE, String.format("Token reset for user %s to %s", p.getLoginName(), otp));
                e.setOutput(menuMessages.getUssdSuccessStatus());
                e.getHttpHeaders().set("TaskResponse", "Success " + otp);

            });

        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            e.setOutput(ex.getMessage());

        }
    }


    @Subscribe
    public void handleWhitelistSubscriberRequestReceivedEvent(DashboardEvent.WhitelistSubscriberRequestReceivedEvent e) {
        try {
            e.setOutput(menuMessages.getUssdFailureStatus());
            e.getHttpHeaders().set("TaskResponse", String.format("Shortcode: %s not found!", e.getCode()));
            /*
                TODO: No need to check the status here
             */
            requestService.findUssdCodesByUssdCodeAndStatus(e.getCode(), menuMessages.getUssdCodeTest()).ifPresent(ussdCodes -> {
                SubscriberWhitelist whitelist = new SubscriberWhitelist();

                whitelist.setCode(ussdCodes);
                /*
                  TODO: Validate subscriber number for length and append country code when needed
                 */
                whitelist.setSubno(e.getSubno());
                whitelist.setStatus(e.getStatus());
                whitelist = requestService.saveSubscriberWhitelist(whitelist);
                e.setOutput(menuMessages.getUssdSuccessStatus());
                e.getHttpHeaders().set("TaskResponse", "Success " + whitelist.toString());
            });

        } catch (ConstraintViolationException | DataIntegrityViolationException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            e.setOutput(menuMessages.getSubscriberWhitelistedErrorMessage());
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            e.setOutput(ex.getMessage());
        }
    }

    @Subscribe
    public void handleReverseHasherAdminTaskRequestReceivedEvent(DashboardEvent.ReverseHasherAdminTaskRequestReceivedEvent e) {
        try {
            e.setOutput(menuMessages.getUssdResponseCodeDefault());
            e.getHttpHeaders().set("TaskResponse", hashingImplementation.getDecryptedValue(e.getInput()));

        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            e.setOutput(ex.getMessage());

        }

    }

    @Subscribe
    public void handleHasherAdminTaskRequestReceivedEvent(DashboardEvent.HasherAdminTaskRequestReceivedEvent e) {
        try {
            e.setOutput(menuMessages.getUssdResponseCodeDefault());
            e.getHttpHeaders().set("TaskResponse", hashingImplementation.getEncryptedValue(e.getInput()));

        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            e.setOutput(ex.getMessage());

        }

    }


    @Subscribe
    void handleUssdRequestReceivedEvent(DashboardEvent.UssdRequestReceivedEvent e) {
        try {
            /*
             Transform input to code for the the session, to enable us to support multiple codes on the same UssdCode
             */
            Collection<UssdRequests> sessionIdUssdRequests = requestService.findUssdRequestsBySessionId(e.getUssdRequests().getSessionid());
            if (e.getUssdRequests().getNewrequest().equals(menuMessages.getNewRequestVar())) {
                e.getUssdRequests().setCode(e.getUssdRequests().getRequestInput());
            } else {

                e.getUssdRequests().setCode(sessionIdUssdRequests.isEmpty() ? e.getUssdRequests().getCode() : ((UssdRequests) sessionIdUssdRequests.toArray()[0]).getCode());
            }
            if (!menuProcessorService.isSubscriberWhitelistedForCode(e.getUssdRequests())) {
                /**
                 * Subscriber not allowed to access UssdCode
                 */
                Logger.getLogger(SyncEventBusService.class.getName()).log(Level.SEVERE, "Unauthorised access to a test short code detected [sessionid={0}, msisdn={2}, transactionid={1}]", new Object[]{e.getUssdRequests().getSessionid(), e.getUssdRequests().getTransactionid(), e.getUssdRequests().getMsisdn()});
                UssdResponses responses = menuProcessorService.processUssdRequestAndLogResponse(e.getUssdRequests(), menuMessages.getUssdNotAllowedResponse(), menuMessages.getUssdNotAllowedResponse(), menuMessages.getUssdNotAllowedResponse(), menuMessages.getEndOfSessionFalseVar(), Integer.valueOf(menuMessages.getValidUssdReponseCode()), setFlowBreakHeaders());
                e.setMessages(responses.getResponseBody());
                e.setResponseHeaders(setFlowBreakHeaders());
                e.setUssdResponses(responses);
                e.setUssdRequests(responses.getRequestId());
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("Response generated [Session = %s, Transaction= %s, Body= %s ]", responses.getRequestId().getSessionid(), responses.getRequestId().getTransactionid(), responses.getResponseBody()));


            } else {
                if (!menuProcessorService.isImsiInAllowedRange(e.getUssdRequests())) {
                    /**
                     * Subscriber's IMSI not in allowed range
                     */
                    Logger.getLogger(SyncEventBusService.class.getName()).log(Level.SEVERE, "Access to a short code by an invalid IMSI detected [sessionid={0}, msisdn={2}, transactionid={1}]", new Object[]{e.getUssdRequests().getSessionid(), e.getUssdRequests().getTransactionid(), e.getUssdRequests().getMsisdn()});
                    UssdResponses responses = menuProcessorService.processUssdRequestAndLogResponse(e.getUssdRequests(), menuMessages.getUssdNotAllowedResponse(), menuMessages.getUssdNotAllowedResponse(), menuMessages.getUssdNotAllowedResponse(), menuMessages.getEndOfSessionFalseVar(), Integer.valueOf(menuMessages.getValidUssdReponseCode()), setFlowBreakHeaders());
                    e.setMessages(responses.getResponseBody());
                    e.setResponseHeaders(setFlowBreakHeaders());
                    e.setUssdResponses(responses);
                    e.setUssdRequests(responses.getRequestId());
                    Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("Response generated [Session = %s, Transaction= %s, Body= %s ]", responses.getRequestId().getSessionid(), responses.getRequestId().getTransactionid(), responses.getResponseBody()));

                } else {
                    if (requestService.findUssdRequestBySessionIdAndTransactionId(e.getUssdRequests().getSessionid(), e.getUssdRequests().getTransactionid()) != null) {
                        /**
                         * Duplicate request received
                         */
                        Logger.getLogger(SyncEventBusService.class.getName()).log(Level.SEVERE, "Duplicate transactionId received [sessionid={0}, transactionid={1}]", new Object[]{e.getUssdRequests().getSessionid(), e.getUssdRequests().getTransactionid()});
                        UssdResponses responses = menuProcessorService.processUssdRequestAndLogResponse(e.getUssdRequests(), menuMessages.getDuplicateRequestMessage(), menuMessages.getUssdFailureStatus(), menuMessages.getUssdNotAllowedResponse(), menuMessages.getEndOfSessionFalseVar(), Integer.valueOf(menuMessages.getValidUssdReponseCode()), setFlowContinueHeaders());
                        e.setMessages(responses.getResponseBody());
                        e.setResponseHeaders(setFlowContinueHeaders());
                        e.setUssdResponses(responses);
                        e.setUssdRequests(responses.getRequestId());
                        Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("Response generated [Session = %s, Transaction= %s, Body= %s ]", responses.getRequestId().getSessionid(), responses.getRequestId().getTransactionid(), responses.getResponseBody()));
                    } else {
                        /**
                         * Not A duplicate request
                         */
                        Collection<UssdMenuImsiCodeVw> ussdMenuImsiCodeVws = requestService.findUssdMenuImsiCodeVwByCodeAndStatus(e.getUssdRequests().getCode(), menuMessages.getUssdCodeActive());
                        if (!menuProcessorService.isRequestUserRegistered(e.getUssdRequests())) {
                            /**
                             * FTU Menus
                             * Display the entrypoint so that the user registers
                             * TODO: Do we need to send a text informing subscriber to register or do we just keep replaying the entryPoint Menu?
                             * Is the next menu for FirstTimeUsage?
                             */
                            Collection<UssdMenuImsiCodeVw> ftuMenus = ussdMenuImsiCodeVws.stream().filter(ussdMenuImsiCodeVw -> menuMessages.getMenuIsFtuValue() == ussdMenuImsiCodeVw.getFtu()).collect(Collectors.toList());
                            if (e.getUssdRequests().getNewrequest().equals(menuMessages.getNewRequestVar())) {
                                /**
                                 *   New request serve up the main menu
                                 */

                                UssdResponses responses = menuProcessorService.processUssdRequestAndLogResponse(e.getUssdRequests(), displayUssdMenu(ftuMenus, menuMessages.getEntryPointVar(), e.getUssdRequests().getSessionid()), menuMessages.getUssdSuccessStatus(), menuMessages.getEntryPointVar(), menuMessages.getEndOfSessionFalseVar(), Integer.valueOf(menuMessages.getValidUssdReponseCode()), setFlowContinueHeaders());
                                e.setMessages(responses.getResponseBody());
                                e.setResponseHeaders(setFlowContinueHeaders());
                                e.setUssdResponses(responses);
                                e.setUssdRequests(responses.getRequestId());
                                Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("Response generated [Session = %s, Transaction= %s, Body= %s ]", responses.getRequestId().getSessionid(), responses.getRequestId().getTransactionid(), responses.getResponseBody()));
                            } else {
//                                e.setUssdRequests(menuProcessorService.logUssdRequest(e.getUssdRequests()));
                                Comparator<UssdRequests> comparator = Comparator.comparing(UssdRequests::getRequestDate);
                                UssdRequests prevSelectedRequest = sessionIdUssdRequests.stream().filter(ur -> ur.getStatus().equals(menuMessages.getUssdSuccessStatus())).sorted(comparator.reversed()).collect(Collectors.toList()).get(0);
                                String parentId = prevSelectedRequest.getVarFld1();

                                List<UssdMenuImsiCodeVw> ftuPrevSelectedMenu = ftuMenus.stream().filter(um -> parentId.equals(um.getMenuKey())).collect(Collectors.toList());
                                List<UssdMenuImsiCodeVw> ftuSelectedChoices;
                                try {
                                    ftuSelectedChoices = ftuMenus.stream().filter(um -> parentId.equals(um.getMenuKey()) && um.getMenuIsChoice().equals(menuMessages.getIsChoiceYes())).collect(Collectors.toList());
                                } catch (NullPointerException ex) {
                                    /**
                                     * Happens when transitioning from choices to choices
                                     */
                                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessages());
                                    ftuSelectedChoices = ftuMenus.stream().filter(um -> parentId.equals(um.getMenuKey()) && um.getMenuIsChoice().equals(menuMessages.getIsChoiceNo())).collect(Collectors.toList());


                                }
                                List<UssdMenuImsiCodeVw> ftuSelectedNonChoices;
                                try {
                                    ftuSelectedNonChoices = ftuMenus.stream().filter(um -> parentId.equals(um.getMenuKey()) && um.getMenuIsChoice().equals(menuMessages.getIsChoiceNo())).collect(Collectors.toList());

                                } catch (Exception ex) {
                                    /**
                                     * Happens when transitioning from choices to choices
                                     */
                                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessages());
                                    ftuSelectedNonChoices = ftuSelectedChoices;

                                }


                                UssdMenuImsiCodeVw ftuSelectedOne;
                                int ftuInput;
                                if (ftuSelectedChoices.isEmpty()) {
                                    /**
                                     * No choices lets Consider as non-choiceslets pick up parameters based on conditions
                                     */
                                    ftuSelectedOne = ftuSelectedNonChoices.get(0);

                                } else {
                                    try {
                                        ftuInput = Integer.parseInt(e.getUssdRequests().getRequestInput());
                                        int finalFtuInput = ftuInput;

                                        ftuSelectedOne = ftuSelectedChoices.get(finalFtuInput - 1);
                                    } catch (NumberFormatException | IndexOutOfBoundsException ex) {
                                        ftuSelectedOne = ftuSelectedChoices.get(0);
                                    }
                                }
                                Optional<UssdMenuImsiCodeVw> ftuOptSelectedOne = ftuSelectedOne == null ? ftuMenus.stream().filter(umisv -> menuMessages.getEntryPointVar().equals(umisv.getMenuKey())).findFirst() : Optional.of(ftuSelectedOne);
                                ftuOptSelectedOne.ifPresent(menu -> {
                                    String ftumenuParameter;
                                    String ftucondition;
                                    String ftusessionEnd;
                                    try {
                                        ftucondition = menu.getMenuCondition();
                                    } catch (Exception ex) {
                                        ftucondition = "";
                                    }
                                    try {
                                        ftumenuParameter = menu.getMenuParameter();
                                    } catch (Exception ex) {
                                        ftumenuParameter = "";
                                    }
                                    try {
                                        ftusessionEnd = ftuMenus.stream().filter(u -> menu.getMenuNextId().equals(u.getMenuKey())).collect(Collectors.toList()).get(0).getMenuSessionEnd();
                                    } catch (Exception ex) {
                                        ftusessionEnd = menuMessages.getEndOfSessionFalseVar();
                                    }

                                    e.getUssdRequests().setVarFld5(ftumenuParameter);
                                    e.getUssdRequests().setVarFld2(ftuPrevSelectedMenu.stream().filter(pm -> parentId.equals(pm.getMenuKey()) && pm.getMenuParameter() != null).findFirst().orElse(new UssdMenuImsiCodeVw()).getMenuParameter());
                                    e.getUssdRequests().setVarFld3(ftucondition != null && ftumenuParameter != null ? ftumenuParameter : (ftucondition == null ? menuMessages.getMsisdnKeyword() == null : ftucondition.equals(menuMessages.getMsisdnKeyword())) ? e.getUssdRequests().getMsisdn() : e.getUssdRequests().getRequestInput());
                                    e.getUssdRequests().setVarFld4(ftucondition);
                                    e.getUssdRequests().setVarFld6(ftusessionEnd);
                                    e.setUssdRequests(menuProcessorService.logUssdRequest(e.getUssdRequests()));
                                    UssdResponses responses = menuProcessorService.processUssdRequestAndLogResponse(e.getUssdRequests(), displayUssdMenu(ftuMenus, menu.getMenuNextId(), e.getUssdRequests().getSessionid()), menuMessages.getUssdSuccessStatus(), menu.getMenuNextId(), menuMessages.getEndOfSessionFalseVar(), Integer.valueOf(menuMessages.getValidUssdReponseCode()), setFlowContinueHeaders());
                                    e.setMessages(responses.getResponseBody());
                                    e.setResponseHeaders(setFlowContinueHeaders());
                                    e.setUssdResponses(responses);
                                    e.setUssdRequests(responses.getRequestId());
                                    Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("Response generated [Session = %s, Transaction= %s, Body= %s, Message = %s]", responses.getRequestId().getSessionid(), responses.getRequestId().getTransactionid(), responses.getResponseBody(), "None secure First Time Usage flow"));

                                });

                            }


                        } else {
                            /**
                             * Registered subscriber menus
                             */

                            principalsService.findUserByPhone(e.getUssdRequests().getMsisdn()).ifPresent(principals -> {
                                String loginNextMenu;
                                if (principals.getStatus() == accountStatus.getAccountsLocked()) {
                                    if (sessionIdUssdRequests.isEmpty()) {
                                        /**
                                         *   New request serve up the main menu
                                         */
//
                                        e.getUssdRequests().setVarFld3(e.getUssdRequests().getMsisdn());
                                        e.getUssdRequests().setVarFld4(menuMessages.getMsisdnKeyword());
                                        UssdResponses responses = menuProcessorService.processUssdRequestAndLogResponse(e.getUssdRequests(), displayUssdMenu(ussdMenuImsiCodeVws, menuMessages.getFirstTimeVar(), e.getUssdRequests().getSessionid()), menuMessages.getUssdSuccessStatus(), menuMessages.getFirstTimeVar(), menuMessages.getEndOfSessionFalseVar(), Integer.valueOf(menuMessages.getValidUssdReponseCode()), setFlowContinueHeaders());
                                        e.setMessages(responses.getResponseBody());
                                        e.setResponseHeaders(setFlowContinueHeaders());
                                        e.setUssdResponses(responses);
                                        e.setUssdRequests(responses.getRequestId());
                                        Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("Response generated [Session = %s, Transaction= %s, Body= %s, Message = %s]", responses.getRequestId().getSessionid(), responses.getRequestId().getTransactionid(), responses.getResponseBody(), "Account locked Password change required"));


                                    } else {
                                        Comparator<UssdRequests> comparator = Comparator.comparing(UssdRequests::getRequestDate);
                                        UssdRequests prevSelectedRequest = sessionIdUssdRequests.stream().filter(ur -> ur.getStatus().equals(menuMessages.getUssdSuccessStatus())).sorted(comparator.reversed()).collect(Collectors.toList()).get(0);
                                        String parentId = prevSelectedRequest.getVarFld1();
                                        List<UssdMenuImsiCodeVw> prevSelectedMenu = ussdMenuImsiCodeVws.stream().filter(um -> parentId.equals(um.getMenuKey())).collect(Collectors.toList());
                                        /**
                                         * Are we in the change password process?
                                         */
                                        List<String> resetMenus = Arrays.asList(menuMessages.getMenuTokenresetProcessItems());
                                        if (resetMenus.contains(parentId)) {
                                            /**
                                             * Determine and display the next menu
                                             */
                                            List<UssdMenuImsiCodeVw> resetSelectedChoices = ussdMenuImsiCodeVws.stream().filter(um -> parentId.equals(um.getMenuKey()) && um.getMenuIsChoice().equals(menuMessages.getIsChoiceYes())).collect(Collectors.toList());
                                            List<UssdMenuImsiCodeVw> resetSelectedNonChoices = ussdMenuImsiCodeVws.stream().filter(um -> parentId.equals(um.getMenuKey()) && um.getMenuIsChoice().equals(menuMessages.getIsChoiceNo())).collect(Collectors.toList());
                                            UssdMenuImsiCodeVw resetSelectedOne;
                                            int input;
                                            if (resetSelectedChoices.isEmpty()) {
                                                /**
                                                 * No choices lets Consider as non-choiceslets pick up parameters based on conditions
                                                 */

                                                resetSelectedOne = resetSelectedNonChoices.get(0);
                                            } else {
                                                try {
                                                    input = Integer.parseInt(e.getUssdRequests().getRequestInput());
                                                    resetSelectedOne = resetSelectedChoices.get(input - 1);
                                                } catch (NumberFormatException | IndexOutOfBoundsException ex) {

                                                    resetSelectedOne = resetSelectedChoices.get(0);
                                                }
                                            }


                                            Optional<UssdMenuImsiCodeVw> optSelectedResetMenu = resetSelectedOne == null ? ussdMenuImsiCodeVws.stream().filter(umisv -> menuMessages.getEntryPointVar().equals(umisv.getMenuKey())).findFirst() : Optional.of(resetSelectedOne);
                                            optSelectedResetMenu.ifPresent(menu -> {
                                                String resetCondition;
                                                String resetMenuParameter;
                                                String resetSessionEnd;
                                                try {
                                                    resetMenuParameter = menu.getMenuParameter();
                                                } catch (Exception ex) {
                                                    resetMenuParameter = "";
                                                }
                                                try {
                                                    resetCondition = menu.getMenuCondition();
                                                } catch (Exception ex) {
                                                    resetCondition = "";
                                                }

                                                try {
                                                    resetSessionEnd = ussdMenuImsiCodeVws.stream().filter(u -> menu.getMenuNextId().equals(u.getMenuKey())).collect(Collectors.toList()).get(0).getMenuSessionEnd();
                                                } catch (Exception ex) {
                                                    resetSessionEnd = menuMessages.getEndOfSessionFalseVar();
                                                }

                                                e.getUssdRequests().setVarFld2(prevSelectedMenu.stream().filter(pm -> parentId.equals(pm.getMenuKey()) && pm.getMenuParameter() != null).findFirst().orElse(new UssdMenuImsiCodeVw()).getMenuParameter());
                                                e.getUssdRequests().setVarFld3(resetCondition != null && resetMenuParameter != null ? resetMenuParameter : (resetCondition == null ? menuMessages.getMsisdnKeyword() == null : resetCondition.equals(menuMessages.getMsisdnKeyword())) ? e.getUssdRequests().getMsisdn() : e.getUssdRequests().getRequestInput());
                                                e.getUssdRequests().setVarFld4(resetCondition);
                                                e.getUssdRequests().setVarFld5(resetMenuParameter);
                                                e.getUssdRequests().setVarFld6(resetSessionEnd);
                                                e.setUssdRequests(menuProcessorService.logUssdRequest(e.getUssdRequests()));
                                                UssdResponses responses = menuProcessorService.processUssdRequestAndLogResponse(e.getUssdRequests(), displayUssdMenu(ussdMenuImsiCodeVws, menu.getMenuNextId(), e.getUssdRequests().getSessionid()), menuMessages.getUssdSuccessStatus(), menu.getMenuNextId(), menuMessages.getEndOfSessionFalseVar(), Integer.valueOf(menuMessages.getValidUssdReponseCode()), setFlowContinueHeaders());
                                                e.setMessages(responses.getResponseBody());
                                                e.setResponseHeaders(setFlowContinueHeaders());
                                                e.setUssdResponses(responses);
                                                e.setUssdRequests(responses.getRequestId());
                                                Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("Response generated [Session = %s, Transaction= %s, Body= %s, Message = %s]", responses.getRequestId().getSessionid(), responses.getRequestId().getTransactionid(), responses.getResponseBody(), "Secured flow"));
                                            });

                                        } else {
                                            /**
                                             * Not the password reset process
                                             */
                                            e.getUssdRequests().setVarFld14(prevSelectedRequest.getVarFld14());
                                            e.getUssdRequests().setVarFld15(prevSelectedRequest.getVarFld15());

                                            loginNextMenu = menuMessages.getFirstTimeVar();
                                            e.getUssdRequests().setVarFld3(menuMessages.getMsisdnKeyword());
                                            e.getUssdRequests().setVarFld4(prevSelectedMenu.get(0).getMenuCondition());
                                            e.getUssdRequests().setVarFld5(prevSelectedMenu.get(0).getMenuParameter());
                                            e.getUssdRequests().setVarFld6(prevSelectedMenu.get(0).getMenuSessionEnd());
                                            e.getUssdRequests().setVarFld2(prevSelectedMenu.stream().filter(pm -> parentId.equals(pm.getMenuKey()) && pm.getMenuParameter() != null).findFirst().orElse(new UssdMenuImsiCodeVw()).getMenuParameter());

                                            e.getUssdRequests().setVarFld14(prevSelectedRequest.getVarFld14());
                                            e.getUssdRequests().setVarFld15(prevSelectedRequest.getVarFld15());


                                            UssdResponses responses = menuProcessorService.processUssdRequestAndLogResponse(e.getUssdRequests(), displayUssdMenu(ussdMenuImsiCodeVws, loginNextMenu, e.getUssdRequests().getSessionid()), menuMessages.getUssdSuccessStatus(), menuMessages.getFirstTimeVar(), menuMessages.getEndOfSessionFalseVar(), Integer.valueOf(menuMessages.getValidUssdReponseCode()), setFlowContinueHeaders());
                                            e.setMessages(responses.getResponseBody());
                                            e.setResponseHeaders(setFlowContinueHeaders());
                                            e.setUssdResponses(responses);
                                            e.setUssdRequests(responses.getRequestId());
                                            Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("Response generated [Session = %s, Transaction= %s, Body= %s, Message = %s]", responses.getRequestId().getSessionid(), responses.getRequestId().getTransactionid(), responses.getResponseBody(), "Account locked Password change required"));

                                        }


                                    }


                                } else {
                                    /**
                                     * Is the next menu secure?
                                     */
                                    Comparator<UssdRequests> comparator = Comparator.comparing(UssdRequests::getRequestDate);
                                    UssdRequests prevSelectedRequest;


                                    if (sessionIdUssdRequests.isEmpty()) {


                                        Stream<UssdMenuImsiCodeVw> entryPointMenu = ussdMenuImsiCodeVws.stream().filter(menu -> menu.getMenuKey().equals(menuMessages.getMenuRegisteredUserEntrypoint()) && menu.getSecureMenu().equals(menuMessages.getMenuSecureYesKeyword()));

                                        if (entryPointMenu.count() > 0) {
                                            /**
                                             * NextMenu is Secure display login dialog and log entrypoint for next call, Log NextMenu to VarFld15
                                             */
                                            e.getUssdRequests().setVarFld3(e.getUssdRequests().getMsisdn());
                                            e.getUssdRequests().setVarFld4(menuMessages.getMsisdnKeyword());
                                            e.getUssdRequests().setVarFld15(menuMessages.getMenuRegisteredUserEntrypoint());
                                            e.setUssdRequests(menuProcessorService.logUssdRequest(e.getUssdRequests()));
                                            UssdResponses responses = menuProcessorService.processUssdRequestAndLogResponse(e.getUssdRequests(), displayUssdMenu(ussdMenuImsiCodeVws, menuMessages.getInputPasswordDialogKeyword(), e.getUssdRequests().getSessionid()), menuMessages.getUssdSuccessStatus(), menuMessages.getInputPasswordDialogKeyword(), menuMessages.getEndOfSessionFalseVar(), Integer.valueOf(menuMessages.getValidUssdReponseCode()), setFlowContinueHeaders());


                                            e.setMessages(responses.getResponseBody());
                                            e.setResponseHeaders(setFlowContinueHeaders());
                                            e.setUssdResponses(responses);
                                            e.setUssdRequests(responses.getRequestId());
                                            Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("Response generated [Session = %s, Transaction= %s, Body= %s, Message = %s]", responses.getRequestId().getSessionid(), responses.getRequestId().getTransactionid(), responses.getResponseBody(), "Not a new request and session does not exists"));

                                        } else {
                                            /**
                                             *   New request serve up the main menu
                                             */
                                            e.getUssdRequests().setVarFld3(e.getUssdRequests().getMsisdn());
                                            e.getUssdRequests().setVarFld4(menuMessages.getMsisdnKeyword());
                                            UssdResponses responses = menuProcessorService.processUssdRequestAndLogResponse(e.getUssdRequests(), displayUssdMenu(ussdMenuImsiCodeVws, menuMessages.getMenuRegisteredUserEntrypoint(), e.getUssdRequests().getSessionid()), menuMessages.getUssdSuccessStatus(), menuMessages.getMenuRegisteredUserEntrypoint(), menuMessages.getEndOfSessionFalseVar(), Integer.valueOf(menuMessages.getValidUssdReponseCode()), setFlowContinueHeaders());
                                            e.setMessages(responses.getResponseBody());
                                            e.setResponseHeaders(setFlowContinueHeaders());
                                            e.setUssdResponses(responses);
                                            e.setUssdRequests(responses.getRequestId());
                                            Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("Response generated [Session = %s, Transaction= %s, Body= %s, Message = %s]", responses.getRequestId().getSessionid(), responses.getRequestId().getTransactionid(), responses.getResponseBody(), "Account locked Password change required"));

                                        }


                                    } else {
                                        prevSelectedRequest = sessionIdUssdRequests.stream().filter(ur -> ur.getStatus().equals(menuMessages.getUssdSuccessStatus())).sorted(comparator.reversed()).collect(Collectors.toList()).get(0);
                                        String parentId = prevSelectedRequest.getVarFld1();
                                        List<UssdMenuImsiCodeVw> prevSelectedMenu = ussdMenuImsiCodeVws.stream().filter(um -> parentId.equals(um.getMenuKey())).collect(Collectors.toList());
                                        final String parentIdBeforeLoginRequest = prevSelectedRequest.getVarFld15() == null ? parentId : prevSelectedRequest.getVarFld15();
                                        List<UssdMenuImsiCodeVw> selectedChoices = ussdMenuImsiCodeVws.stream().filter(um -> parentIdBeforeLoginRequest.equals(um.getMenuKey()) && um.getMenuIsChoice().equals(menuMessages.getIsChoiceYes())).collect(Collectors.toList());
                                        List<UssdMenuImsiCodeVw> selectedNonChoices = ussdMenuImsiCodeVws.stream().filter(um -> parentIdBeforeLoginRequest.equals(um.getMenuKey()) && um.getMenuIsChoice().equals(menuMessages.getIsChoiceNo())).collect(Collectors.toList());
                                        UssdMenuImsiCodeVw selectedOne;
                                        String nextMenuKey = "";
                                        int input;
                                        List<UssdMenuImsiCodeVw> nextMenuList;
                                        if (selectedChoices.isEmpty()) {
                                            /**
                                             * No choices lets Consider as non-choiceslets pick up parameters based on conditions
                                             */
                                            nextMenuKey = selectedNonChoices.get(0).getMenuNextId();
                                            nextMenuList = ussdMenuImsiCodeVws.stream().filter(nmu -> selectedNonChoices.get(0).getMenuNextId().equals(nmu.getMenuKey())).collect(Collectors.toList());
                                            selectedOne = selectedNonChoices.get(0);
                                        } else {
                                            try {
                                                input = Integer.parseInt(e.getUssdRequests().getRequestInput());
                                                int finalInput = input;
                                                nextMenuList = ussdMenuImsiCodeVws.stream().filter(nmu -> selectedChoices.get(finalInput - 1).getMenuNextId().equals(nmu.getMenuKey())).collect(Collectors.toList());

                                                nextMenuKey = selectedChoices.get(input - 1).getMenuNextId();
                                                selectedOne = selectedChoices.get(input - 1);
                                            } catch (NumberFormatException | IndexOutOfBoundsException ex) {
                                                nextMenuList = ussdMenuImsiCodeVws.stream().filter(nmu -> selectedChoices.get(0).getMenuNextId().equals(nmu.getMenuKey())).collect(Collectors.toList());
                                                selectedOne = selectedChoices.get(0);
                                            }
                                        }

                                        if (prevSelectedMenu.stream().filter(ps -> menuMessages.getInputPasswordDialogKeyword().equals(ps.getMenuKey())).count() > 0) {
                                            try {
                                                Authentication auth = menuProcessorService.authenticateUssdRequest(principals.getCellphonenumber(), e.getUssdRequests().getRequestInput());
                                                if (!auth.isAuthenticated()) {
                                                    throw new BadCredentialsException("Username and/Password is not recognised");
                                                } else {
                                                    /**
                                                     * Authenticated OK
                                                     * TODO: Do we need correct roles here?, What will they be?
                                                     */
                                                    UssdSessions sessions = new UssdSessions();
                                                    sessions.setCreationDate(new Date());
                                                    sessions.setSessionId(e.getUssdRequests().getSessionid());
                                                    sessions.setStatus(menuMessages.getStatusActive());
                                                    sessions.setUserId(principals);
                                                    requestService.saveUssdSessions(sessions);

                                                    if (nextMenuList.stream().filter(nmu -> menuMessages.getMenuSecureYesKeyword().equals(nmu.getSecureMenu())).count() > 0) {
                                                        /**
                                                         * Valid session exists
                                                         */

                                                        /**
                                                         *TODO: Check if the session has expired
                                                         *TODO: Login method may need to be external in case I need to call it several times
                                                         */
                                                        Calendar cal = Calendar.getInstance();

                                                        if (utilities.calculateExpiryDate(sessions.getCreationDate(), menuMessages.getSessionExpiryMinutes()).getTime() - cal.getTime().getTime() <= 0) {
                                                            /**
                                                             *Session expired
                                                             */
                                                            e.getUssdRequests().setVarFld14(sessions.toString());
                                                            e.getUssdRequests().setVarFld15(nextMenuKey);

                                                            UssdResponses responses = menuProcessorService.processUssdRequestAndLogResponse(e.getUssdRequests(), displayUssdMenu(ussdMenuImsiCodeVws, menuMessages.getInputPasswordDialogKeyword(), e.getUssdRequests().getSessionid()), menuMessages.getUssdSuccessStatus(), menuMessages.getInputPasswordDialogKeyword(), menuMessages.getEndOfSessionFalseVar(), Integer.valueOf(menuMessages.getValidUssdReponseCode()), setFlowContinueHeaders());
                                                            /**
                                                             Log Next Menu to VarFld15
                                                             */
                                                            e.setMessages(responses.getResponseBody());
                                                            e.setResponseHeaders(setFlowContinueHeaders());
                                                            e.setUssdResponses(responses);
                                                            e.setUssdRequests(responses.getRequestId());
                                                            Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("Response generated [Session = %s, Transaction= %s, Body= %s, Message = %s]", responses.getRequestId().getSessionid(), responses.getRequestId().getTransactionid(), responses.getResponseBody(), "Session expired"));

                                                        } else {
                                                            /**
                                                             * Determine and display the menu before the input dialog request
                                                             */


                                                            Optional<UssdMenuImsiCodeVw> optSelectedOne = selectedOne == null ? ussdMenuImsiCodeVws.stream().filter(umisv -> menuMessages.getEntryPointVar().equals(umisv.getMenuKey())).findFirst() : Optional.of(selectedOne);

                                                            optSelectedOne.ifPresent(menu -> {
                                                                String condition;
                                                                String menuParameter;
                                                                String sessionEnd;
                                                                try {
                                                                    condition = menu.getMenuCondition();
                                                                } catch (Exception ex) {
                                                                    condition = "";
                                                                }
                                                                try {
                                                                    menuParameter = menu.getMenuParameter();
                                                                } catch (Exception ex) {
                                                                    menuParameter = "";
                                                                }
                                                                try {
                                                                    sessionEnd = ussdMenuImsiCodeVws.stream().filter(u -> menu.getMenuNextId().equals(u.getMenuKey())).collect(Collectors.toList()).get(0).getMenuSessionEnd();
                                                                } catch (Exception ex) {
                                                                    sessionEnd = menuMessages.getEndOfSessionFalseVar();
                                                                }

                                                                e.getUssdRequests().setVarFld2(prevSelectedMenu.stream().filter(pm -> parentId.equals(pm.getMenuKey()) && pm.getMenuParameter() != null).findFirst().orElse(new UssdMenuImsiCodeVw()).getMenuParameter());
                                                                e.getUssdRequests().setVarFld3(condition != null && menuParameter != null ? menuParameter : (condition == null ? menuMessages.getMsisdnKeyword() == null : condition.equals(menuMessages.getMsisdnKeyword())) ? e.getUssdRequests().getMsisdn() : e.getUssdRequests().getRequestInput());
                                                                e.getUssdRequests().setVarFld4(condition);
                                                                e.getUssdRequests().setVarFld5(menuParameter);
                                                                e.getUssdRequests().setVarFld6(sessionEnd);
                                                                e.setUssdRequests(menuProcessorService.logUssdRequest(e.getUssdRequests()));
                                                                UssdResponses responses = menuProcessorService.processUssdRequestAndLogResponse(e.getUssdRequests(), displayUssdMenu(ussdMenuImsiCodeVws, parentIdBeforeLoginRequest, e.getUssdRequests().getSessionid()), menuMessages.getUssdSuccessStatus(), parentIdBeforeLoginRequest, menuMessages.getEndOfSessionFalseVar(), Integer.valueOf(menuMessages.getValidUssdReponseCode()), setFlowContinueHeaders());
                                                                e.setMessages(responses.getResponseBody());
                                                                e.setResponseHeaders(setFlowContinueHeaders());
                                                                e.setUssdResponses(responses);
                                                                e.setUssdRequests(responses.getRequestId());
                                                                Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("Response generated [Session = %s, Transaction= %s, Body= %s, Message = %s]", responses.getRequestId().getSessionid(), responses.getRequestId().getTransactionid(), responses.getResponseBody(), "Secured flow"));
                                                            });
                                                        }

                                                    } else {
                                                        /**
                                                         * No secure menu detected, determine the next menu
                                                         */
                                                        Optional<UssdMenuImsiCodeVw> optSelectedOne = selectedOne == null ? ussdMenuImsiCodeVws.stream().filter(umisv -> menuMessages.getEntryPointVar().equals(umisv.getMenuKey())).findFirst() : Optional.of(selectedOne);
                                                        optSelectedOne.ifPresent(menu -> {
                                                            String condition;
                                                            String menuParameter;
                                                            String sessionEnd;
                                                            try {
                                                                condition = menu.getMenuCondition();
                                                            } catch (Exception ex) {
                                                                condition = "";
                                                            }
                                                            try {
                                                                menuParameter = menu.getMenuParameter();
                                                            } catch (Exception ex) {
                                                                menuParameter = "";
                                                            }
                                                            try {
                                                                sessionEnd = ussdMenuImsiCodeVws.stream().filter(u -> menu.getMenuNextId().equals(u.getMenuKey())).collect(Collectors.toList()).get(0).getMenuSessionEnd();
                                                            } catch (Exception ex) {
                                                                sessionEnd = menuMessages.getEndOfSessionFalseVar();
                                                            }

                                                            e.getUssdRequests().setVarFld5(menuParameter);
                                                            e.getUssdRequests().setVarFld2(prevSelectedMenu.stream().filter(pm -> parentId.equals(pm.getMenuKey()) && pm.getMenuParameter() != null).findFirst().orElse(new UssdMenuImsiCodeVw()).getMenuParameter());
                                                            e.getUssdRequests().setVarFld3(condition != null && menuParameter != null ? menuParameter : (condition == null ? menuMessages.getMsisdnKeyword() == null : condition.equals(menuMessages.getMsisdnKeyword())) ? e.getUssdRequests().getMsisdn() : e.getUssdRequests().getRequestInput());
                                                            e.getUssdRequests().setVarFld4(condition);
                                                            e.getUssdRequests().setVarFld6(sessionEnd);
                                                            e.setUssdRequests(menuProcessorService.logUssdRequest(e.getUssdRequests()));
                                                            UssdResponses responses = menuProcessorService.processUssdRequestAndLogResponse(e.getUssdRequests(), displayUssdMenu(ussdMenuImsiCodeVws, menu.getMenuNextId(), e.getUssdRequests().getSessionid()), menuMessages.getUssdSuccessStatus(), menu.getMenuNextId(), menuMessages.getEndOfSessionFalseVar(), Integer.valueOf(menuMessages.getValidUssdReponseCode()), setFlowContinueHeaders());
                                                            e.setMessages(responses.getResponseBody());
                                                            e.setResponseHeaders(setFlowContinueHeaders());
                                                            e.setUssdResponses(responses);
                                                            e.setUssdRequests(responses.getRequestId());
                                                            Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("Response generated [Session = %s, Transaction= %s, Body= %s, Message = %s]", responses.getRequestId().getSessionid(), responses.getRequestId().getTransactionid(), responses.getResponseBody(), "None secure flow"));

                                                        });
                                                    }

                                                }


                                            } catch (AuthenticationException exp) {
                                                /**
                                                 * Login failed for whatever reason
                                                 */
                                                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, exp.getMessage());
                                                int failedLogins;
                                                try {
                                                    failedLogins = prevSelectedRequest.getVarFld13() == null ? 1 : Integer.valueOf(prevSelectedRequest.getVarFld13()) + 1;
                                                } catch (NumberFormatException ex) {
                                                    failedLogins = 1;
                                                }
                                                e.getUssdRequests().setVarFld3(menuMessages.getMsisdnKeyword());
                                                e.getUssdRequests().setVarFld4(prevSelectedMenu.get(0).getMenuCondition());
                                                e.getUssdRequests().setVarFld5(prevSelectedMenu.get(0).getMenuParameter());
                                                e.getUssdRequests().setVarFld6(prevSelectedMenu.get(0).getMenuSessionEnd());
                                                e.getUssdRequests().setVarFld2(prevSelectedMenu.stream().filter(pm -> parentId.equals(pm.getMenuKey()) && pm.getMenuParameter() != null).findFirst().orElse(new UssdMenuImsiCodeVw()).getMenuParameter());
                                                e.getUssdRequests().setVarFld13(String.valueOf(failedLogins));
                                                e.getUssdRequests().setVarFld14(prevSelectedRequest.getVarFld14());
                                                e.getUssdRequests().setVarFld15(prevSelectedRequest.getVarFld15());
                                                loginNextMenu = failedLogins >= menuMessages.getMaxFailedLoginAttempts() ? menuMessages.getMenuExceededLoginattemptsMessage() : menuMessages.getInputPasswordDialogKeyword();

                                                UssdResponses responses = menuProcessorService.processUssdRequestAndLogResponse(e.getUssdRequests(), loginNextMenu, menuMessages.getUssdSuccessStatus(), menuMessages.getEntryPointVar(), menuMessages.getEndOfSessionFalseVar(), Integer.valueOf(menuMessages.getValidUssdReponseCode()), failedLogins >= menuMessages.getMaxFailedLoginAttempts() ? setFlowBreakHeaders() : setFlowContinueHeaders());
                                                e.setMessages(responses.getResponseBody());
                                                e.setResponseHeaders(failedLogins >= menuMessages.getMaxFailedLoginAttempts() ? setFlowBreakHeaders() : setFlowContinueHeaders());
                                                e.setUssdResponses(responses);
                                                e.setUssdRequests(responses.getRequestId());
                                                Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("Response generated [Session = %s, Transaction= %s, Body= %s, Message = %s]", responses.getRequestId().getSessionid(), responses.getRequestId().getTransactionid(), responses.getResponseBody(), "Unknown Authentication issue detected"));

                                            }
                                        } else {
                                            /**
                                             * Previous menu was not Login Dialog, determine next menu
                                             * If secure does a valid session exst?
                                             */


                                            if (nextMenuList.stream().filter(nmu -> menuMessages.getMenuSecureYesKeyword().equals(nmu.getSecureMenu())).count() > 0) {
                                                /**
                                                 * next menu is secure, check if we have a valid Session
                                                 */
                                                Optional<UssdSessions> ussdSessions = requestService.findUssdSessionsBySessionIdAndUserId(e.getUssdRequests().getSessionid(), principals);
                                                if (!ussdSessions.isPresent()) {
                                                    /**
                                                     Request for the users password and autheticate
                                                     */
                                                    e.getUssdRequests().setVarFld15(nextMenuKey);
                                                    e.setUssdRequests(menuProcessorService.logUssdRequest(e.getUssdRequests()));
                                                    UssdResponses responses = menuProcessorService.processUssdRequestAndLogResponse(e.getUssdRequests(), displayUssdMenu(ussdMenuImsiCodeVws, menuMessages.getInputPasswordDialogKeyword(), e.getUssdRequests().getSessionid()), menuMessages.getUssdSuccessStatus(), menuMessages.getInputPasswordDialogKeyword(), menuMessages.getEndOfSessionFalseVar(), Integer.valueOf(menuMessages.getValidUssdReponseCode()), setFlowContinueHeaders());
                                                    /**
                                                     Log Next Menu to VarFld15
                                                     */

                                                    e.setMessages(responses.getResponseBody());
                                                    e.setResponseHeaders(setFlowContinueHeaders());
                                                    e.setUssdResponses(responses);
                                                    e.setUssdRequests(responses.getRequestId());
                                                    Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("Response generated [Session = %s, Transaction= %s, Body= %s, Message = %s]", responses.getRequestId().getSessionid(), responses.getRequestId().getTransactionid(), responses.getResponseBody(), "Not a new request and session does not exists"));
                                                } else {
                                                    /**
                                                     * Valid session exists
                                                     */
                                                    String finalNextMenuKey = nextMenuKey;
                                                    UssdMenuImsiCodeVw finalSelectedOne = selectedOne;
                                                    ussdSessions.ifPresent(us -> {
                                                        /**
                                                         *TODO: Check if the session has expired
                                                         *TODO: Login method may need to be external in case I need to call it several times
                                                         */
                                                        Calendar noLoginDialogSecureCal = Calendar.getInstance();

                                                        if (utilities.calculateExpiryDate(us.getCreationDate(), menuMessages.getSessionExpiryMinutes()).getTime() - noLoginDialogSecureCal.getTime().getTime() <= 0) {
                                                            /**
                                                             *Session expired
                                                             */
                                                            e.getUssdRequests().setVarFld15(finalNextMenuKey);
                                                            e.getUssdRequests().setVarFld14(us.toString());
                                                            UssdResponses responses = menuProcessorService.processUssdRequestAndLogResponse(e.getUssdRequests(), displayUssdMenu(ussdMenuImsiCodeVws, menuMessages.getInputPasswordDialogKeyword(), e.getUssdRequests().getSessionid()), menuMessages.getUssdSuccessStatus(), menuMessages.getInputPasswordDialogKeyword(), menuMessages.getEndOfSessionFalseVar(), Integer.valueOf(menuMessages.getValidUssdReponseCode()), setFlowContinueHeaders());
                                                            /**
                                                             Log Next Menu to VarFld15
                                                             */
                                                            e.setMessages(responses.getResponseBody());
                                                            e.setResponseHeaders(setFlowContinueHeaders());
                                                            e.setUssdResponses(responses);
                                                            e.setUssdRequests(responses.getRequestId());
                                                            Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("Response generated [Session = %s, Transaction= %s, Body= %s, Message = %s]", responses.getRequestId().getSessionid(), responses.getRequestId().getTransactionid(), responses.getResponseBody(), "Session expired"));

                                                        } else {
                                                            /**
                                                             * Determine and display the next menu
                                                             */
                                                            Optional<UssdMenuImsiCodeVw> secureNoLoginDialogOptSelectedOne = finalSelectedOne == null ? ussdMenuImsiCodeVws.stream().filter(umisv -> menuMessages.getEntryPointVar().equals(umisv.getMenuKey())).findFirst() : Optional.of(finalSelectedOne);

                                                            secureNoLoginDialogOptSelectedOne.ifPresent(menu -> {
                                                                String secureNoLoginDialogCondition;
                                                                String secureNoLoginDialogMenuParameter;
                                                                String secureNoLoginDialogSessionEnd;
                                                                try {
                                                                    secureNoLoginDialogCondition = menu.getMenuCondition();
                                                                } catch (Exception ex) {
                                                                    secureNoLoginDialogCondition = "";
                                                                }
                                                                try {
                                                                    secureNoLoginDialogMenuParameter = menu.getMenuParameter();
                                                                } catch (Exception ex) {
                                                                    secureNoLoginDialogMenuParameter = "";
                                                                }
                                                                try {
                                                                    secureNoLoginDialogSessionEnd = ussdMenuImsiCodeVws.stream().filter(u -> menu.getMenuNextId().equals(u.getMenuKey())).collect(Collectors.toList()).get(0).getMenuSessionEnd();
                                                                } catch (Exception ex) {
                                                                    secureNoLoginDialogSessionEnd = menuMessages.getEndOfSessionFalseVar();
                                                                }

                                                                e.getUssdRequests().setVarFld2(prevSelectedMenu.stream().filter(pm -> parentId.equals(pm.getMenuKey()) && pm.getMenuParameter() != null).findFirst().orElse(new UssdMenuImsiCodeVw()).getMenuParameter());
                                                                e.getUssdRequests().setVarFld3(secureNoLoginDialogCondition != null && secureNoLoginDialogMenuParameter != null ? secureNoLoginDialogMenuParameter : (secureNoLoginDialogCondition == null ? menuMessages.getMsisdnKeyword() == null : secureNoLoginDialogCondition.equals(menuMessages.getMsisdnKeyword())) ? e.getUssdRequests().getMsisdn() : e.getUssdRequests().getRequestInput());
                                                                e.getUssdRequests().setVarFld4(secureNoLoginDialogCondition);
                                                                e.getUssdRequests().setVarFld5(secureNoLoginDialogMenuParameter);
                                                                e.getUssdRequests().setVarFld6(secureNoLoginDialogSessionEnd);
                                                                e.setUssdRequests(menuProcessorService.logUssdRequest(e.getUssdRequests()));
                                                                UssdResponses responses = menuProcessorService.processUssdRequestAndLogResponse(e.getUssdRequests(), displayUssdMenu(ussdMenuImsiCodeVws, menu.getMenuNextId(), e.getUssdRequests().getSessionid()), menuMessages.getUssdSuccessStatus(), menu.getMenuNextId(), menuMessages.getEndOfSessionFalseVar(), Integer.valueOf(menuMessages.getValidUssdReponseCode()), setFlowContinueHeaders());
                                                                e.setMessages(responses.getResponseBody());
                                                                e.setResponseHeaders(setFlowContinueHeaders());
                                                                e.setUssdResponses(responses);
                                                                e.setUssdRequests(responses.getRequestId());
                                                                Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("Response generated [Session = %s, Transaction= %s, Body= %s, Message = %s]", responses.getRequestId().getSessionid(), responses.getRequestId().getTransactionid(), responses.getResponseBody(), "Secured flow"));

                                                            });

                                                        }

                                                    });
                                                }
                                            } else {
                                                /**
                                                 * No secure menu detected, determine the next menu
                                                 */
                                                Optional<UssdMenuImsiCodeVw> nonSecureNoLoginDialogOptSelectedOne = selectedOne == null ? ussdMenuImsiCodeVws.stream().filter(umisv -> menuMessages.getEntryPointVar().equals(umisv.getMenuKey())).findFirst() : Optional.of(selectedOne);
                                                nonSecureNoLoginDialogOptSelectedOne.ifPresent(menu -> {
                                                    String nonSecureNoLoginDialogMenuParameter;
                                                    String nonSecureNoLoginDialogCondition;
                                                    String nonSecureNoLoginDialogSessionEnd;
                                                    try {
                                                        nonSecureNoLoginDialogCondition = menu.getMenuCondition();
                                                    } catch (Exception ex) {
                                                        nonSecureNoLoginDialogCondition = "";
                                                    }
                                                    try {
                                                        nonSecureNoLoginDialogMenuParameter = menu.getMenuParameter();
                                                    } catch (Exception ex) {
                                                        nonSecureNoLoginDialogMenuParameter = "";
                                                    }
                                                    try {
                                                        nonSecureNoLoginDialogSessionEnd = ussdMenuImsiCodeVws.stream().filter(u -> menu.getMenuNextId().equals(u.getMenuKey())).collect(Collectors.toList()).get(0).getMenuSessionEnd();
                                                    } catch (Exception ex) {
                                                        nonSecureNoLoginDialogSessionEnd = menuMessages.getEndOfSessionFalseVar();
                                                    }

                                                    e.getUssdRequests().setVarFld5(nonSecureNoLoginDialogMenuParameter);
                                                    e.getUssdRequests().setVarFld2(prevSelectedMenu.stream().filter(pm -> parentId.equals(pm.getMenuKey()) && pm.getMenuParameter() != null).findFirst().orElse(new UssdMenuImsiCodeVw()).getMenuParameter());
                                                    e.getUssdRequests().setVarFld3(nonSecureNoLoginDialogCondition != null && nonSecureNoLoginDialogMenuParameter != null ? nonSecureNoLoginDialogMenuParameter : (nonSecureNoLoginDialogCondition == null ? menuMessages.getMsisdnKeyword() == null : nonSecureNoLoginDialogCondition.equals(menuMessages.getMsisdnKeyword())) ? e.getUssdRequests().getMsisdn() : e.getUssdRequests().getRequestInput());
                                                    e.getUssdRequests().setVarFld4(nonSecureNoLoginDialogCondition);
                                                    e.getUssdRequests().setVarFld6(nonSecureNoLoginDialogSessionEnd);
                                                    e.setUssdRequests(menuProcessorService.logUssdRequest(e.getUssdRequests()));
                                                    UssdResponses responses = menuProcessorService.processUssdRequestAndLogResponse(e.getUssdRequests(), displayUssdMenu(ussdMenuImsiCodeVws, menu.getMenuNextId(), e.getUssdRequests().getSessionid()), menuMessages.getUssdSuccessStatus(), menu.getMenuNextId(), menuMessages.getEndOfSessionFalseVar(), Integer.valueOf(menuMessages.getValidUssdReponseCode()), setFlowContinueHeaders());
                                                    e.setMessages(responses.getResponseBody());
                                                    e.setResponseHeaders(setFlowContinueHeaders());
                                                    e.setUssdResponses(responses);
                                                    e.setUssdRequests(responses.getRequestId());
                                                    Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("Response generated [Session = %s, Transaction= %s, Body= %s, Message = %s]", responses.getRequestId().getSessionid(), responses.getRequestId().getTransactionid(), responses.getResponseBody(), "None secure flow"));

                                                });
                                            }
                                        }


                                    }

                                }


                            });

                        }


                    }
                }
            }

            if (e.getUssdRequests().getVarFld6() != null && e.getUssdRequests().getVarFld6().equals(menuMessages.getSessionEndVar())) {
            /*
             * DONE: Time for an Async Eventbus Create RequestProcessing Event
			 * Check for the SessionEnd Flag and end the session Create SR/WR
			 * Request
			 */
                // OrderMaster orderMaster = new OrderMaster();
                Map<String, String> productParamsMap = extractMapFromSessionId(e.getUssdRequests().getSessionid());

                PortalApplication.asyncEventbusService().post(new DashboardEvent.UssdOrderCreationRequestedEvent(productParamsMap, e.getUssdRequests(), e.getMessages()));

            }


        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
//
            UssdResponses responses = menuProcessorService.processUssdRequestAndLogResponse(e.getUssdRequests(), menuMessages.getGeneralExceptionMessage(), menuMessages.getUssdInternalServerErrorStatus(), ex.getMessage(), menuMessages.getEndOfSessionTrueVar(), Integer.valueOf(menuMessages.getInvalidUssdReponseCode()), setFlowBreakHeaders());
            e.setMessages(responses.getResponseBody());
            e.setResponseHeaders(setFlowBreakHeaders());
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("Response generated [Session = %s, Transaction= %s, Body= %s ]", responses.getRequestId().getSessionid(), responses.getRequestId().getTransactionid(), responses.getResponseBody()));

        }

    }


    @Subscribe
    public void onRegistrationCompletedEvent(final DashboardEvent.RegistrationCompletedEvent e) {
        final String token = UUID.randomUUID().toString();

//        String url = e.getAppUrl() + "/registrationConfirm?token=" + token;
//        String organization = op.getOrganizationName();
//        String usersName = e.getUser().getTitle().getTitle() + ". " + e.getUser().getFullname();
//        String emailBody = mailerProperties.getActivateAccountBody();
//        emailBody = emailBody.replaceAll("ORGANIZATION", organization).replaceAll("USERNAME", usersName).replaceAll("APP_URL", url);
        UserRoles roles = new UserRoles(e.getUser(), principalsService.findRolesByRolename("ROLE_UI_USER"), 1);
        principalsService.saveUserRoles(roles);
//        mailerProperties.setRecipientAddress(e.getUser().getEmailaddress());
//        mailerProperties.setSenderAddress(mailerProperties.getActivateAccounSender());
//        mailerProperties.setSubject(mailerProperties.getActivateAccounSubject());
//        mailerProperties.setBody(emailBody);
        VerificationTokens tokens = principalsService.createVerificationTokenForUser(e.getUser(), token, op.getValidationTokenExpiryMinutes());

        mailService.sendUserVerificationMail(e.getUser(), tokens.getToken());

//        final MimeMessage email = constructEmailMessage(mailerProperties);
//        try {
//            if (email == null) {
//                throw new NullPointerException("Email could not be sent");
//            }
//            mailSender.send(email);
//        } catch (NullPointerException | MailException ex) {
//            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
//
//        }

    }

    @Subscribe
    public void onUserLoginRequestedEvent(final DashboardEvent.UserLoginRequestedEvent event) {
        final SecurityContext securityContext = SecurityContextHolder.getContext();

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(event.getUserName(), event.getPassword());

        final Authentication authentication = authenticationManager.authenticate(token);

        securityContext.setAuthentication(token);

        // if (event.isRememberMe()) {
        //// HttpServletRequest request_ = ((VaadinServletRequest)
        // VaadinService.getCurrentRequest()).getHttpServletRequest();
        //// HttpServletResponse response = ((VaadinServletResponse)
        // VaadinService.getCurrentResponse()).getHttpServletResponse();
        ////
        //// request_.setAttribute(AbstractRememberMeServices.DEFAULT_PARAMETER,
        // event.isRememberMe());
        ////
        //// rememberMeServices.loginSuccess(request_, response,
        // authentication);
        //
        // }
        if (authentication.isAuthenticated()) {
            /*
             * TODO: Trace to see if we get correct values for Anonymous
			 */
            // VaadinSession.getCurrent().setAttribute(Principals.class,
            // service.findByLoginName(securityContext.getAuthentication().getName()));
            event.setSuccess(true);

        }

    }


    @Subscribe
    public void handleRegisterBeneficiaryEvent(DashboardEvent.RegisterBeneficiaryEvent event) {
        UserBeneficiaries userBeneficiaries = event.getUserBeneficiaries();
        userBeneficiaries.setPrincipal(event.getPrincipals());
        userBeneficiaries.setStatus("1");
        userBeneficiaries.setCreatedby(event.getPrincipals().getLoginName());
        userBeneficiaries.setCreatedon(new Date());
        userBeneficiaries.setModifiedby(event.getPrincipals().getLoginName());
        userBeneficiaries.setModifiedon(new Date());
        userBeneficiariesService.saveUserBeneficiaries(userBeneficiaries);
    }

    @Subscribe
    public void handleEditBeneficiaryEvent(DashboardEvent.EditBeneficiaryEvent event) {
        UserBeneficiaries userBeneficiaries = event.getUserBeneficiaries();
        userBeneficiaries.setPrincipal(event.getPrincipals());
        userBeneficiaries.setModifiedby(event.getPrincipals().getLoginName());
        userBeneficiaries.setModifiedon(new Date());
        userBeneficiariesService.updateUserBeneficiaries(userBeneficiaries);
    }

    @Subscribe
    public void handleDeleteBeneficiaryEvent(DashboardEvent.DeleteBeneficiaryEvent event) {
        Long id = event.getId();
        UserBeneficiaries userBeneficiaries = userBeneficiariesService.findUserBeneficiariesById(id);
        userBeneficiaries.setDeleteby(event.getPrincipals().getLoginName());
        userBeneficiaries.setDeletedon(new Date());
        userBeneficiaries.setStatus("5");
        userBeneficiariesService.updateUserBeneficiaries(userBeneficiaries);
    }

    @Subscribe
    public void handleForgotPasswordEvent(final DashboardEvent.ForgotPasswordEvent event) {
        final String token = UUID.randomUUID().toString();
//        String url = event.getAppUrl() + "/forgotPasswordConfirm?token=" + token;
//        String organization = op.getOrganizationName();
//        String usersName = event.getPrincipals().getTitle().getTitle() + ". " + event.getPrincipals().getFullname();
//        String emailBody = mailerProperties.getForgotPasswordBody();
//        emailBody = emailBody.replaceAll("ORGANIZATION", organization).replaceAll("USERNAME", usersName).replaceAll("APP_URL", url);

//        mailerProperties.setRecipientAddress(event.getPrincipals().getEmailaddress());
//        mailerProperties.setSenderAddress(mailerProperties.getActivateAccounSender());
//        mailerProperties.setSubject(mailerProperties.getForgotPasswordSubject());
//        mailerProperties.setBody(emailBody);
        PasswordResetTokens tokens = principalsService.createPasswordResetTokenForUser(event.getPrincipals(), token);

        mailService.sendResetPasswordMail(event.getPrincipals(), tokens.getToken());

//        final MimeMessage email = constructEmailMessage(mailerProperties);
//        try {
//            if (email == null) {
//                throw new NullPointerException("Email could not be sent");
//            }
//            mailSender.send(email);
//        } catch (NullPointerException | MailException ex) {
//            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
//        }

    }

    @Subscribe
    public void handleForgotPasswordConfirmEvent(DashboardEvent.ForgotPasswordConfirmEvent event) {
        PasswordResetTokens passwordResetTokens = passwordResetTokenService.getPasswordResetToken(event.getToken());
        if (passwordResetTokens == null) {
            event.getRedirectAttributes().addFlashAttribute("errorMessage", "Invalid account confirmation token.");
            throw new IllegalArgumentException("Invalid token");
        }
        final Principals user = passwordResetTokens.getUserId();
        final Calendar cal = Calendar.getInstance();
        if ((passwordResetTokens.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
            event.getRedirectAttributes().addFlashAttribute("errorMessage", "Your token has expired. Please request again.");
            throw new IllegalArgumentException("Expired token");
        }

        principalsService.changeUserPassword(user, event.getPassword());
    }

    @Subscribe
    public void handleChangePasswordEvent(DashboardEvent.ChangePasswordEvent event) {

        String hashedAnswer = hashingImplementation.getEncryptedValue(event.getAnswer());
        String principalAnswer = event.getUserSecurityQuestions().getAnswer();

        if (!principalAnswer.equals(hashedAnswer)) {
            event.getRedirectAttributes().addFlashAttribute("errorMessage", "Invalid old password");
            throw new IllegalArgumentException("Incorrect Answer");
        }

        if (!passwordEncoder.matches(event.getOldpassword(), event.getPrincipals().getCredentials())) {
            event.getRedirectAttributes().addFlashAttribute("errorMesssage", "Invalid old password");
            throw new IllegalArgumentException("Invalid old password");
        }
        event.getRedirectAttributes().addFlashAttribute("messsage", "Password Changed");
        principalsService.changeUserPassword(event.getPrincipals(), event.getNewpassword());
//        mailerProperties.setRecipientAddress(event.getPrincipals().getEmailaddress());
//        mailerProperties.setSenderAddress(mailerProperties.getActivateAccounSender());
//        mailerProperties.setSubject();
//        mailerProperties.setBody(mailerProperties.getPasswordResetBody());

        MailDTO dto = new MailDTO();
        dto.setSubject(mailerProperties.getForgotPasswordSubject());
        dto.setTo(event.getPrincipals().getEmailaddress());
        dto.setFrom(mailerProperties.getActivateAccounSender());
        mailService.sendContactMail(dto);
//        final MimeMessage email = constructEmailMessage(mailerProperties);
//        try {
//            if (email == null) {
//                throw new NullPointerException("Email could not be sent");
//            }
//            mailSender.send(email);
//        } catch (NullPointerException | MailException ex) {
//            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
//        }

    }

    @Subscribe
    public void handleModifyUserEvent(DashboardEvent.ModifyUserEvent event) {
        principalsService.saveRegisteredPrincipal(event.getPrincipals());
        event.getRedirectAttributes().addFlashAttribute("messsage", "Changed");
    }


    @Subscribe
    public void handleApiCompleteRegistrationEvent(DashboardEvent.ApiCompleteRegistrationEvent event) {

        Principals principals = event.getPrincipals();
        principals.setCredentials(passwordEncoder.encode(event.getCredentials()));
        principals.setLoginName(event.getUsername());
        principals.setEmailaddress(event.getEmail());
        principals.setStatus(1);
        try {
            principalsService.saveRegisteredPrincipal(principals);
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    @Subscribe
    public void handleSendBulkSmsEvent(DashboardEvent.SendBulkSmsEvent event) {
//        smsBrokerService.sendBulkSmsFromCsv(event.getSmscsv(),event.getSingle(),event.getMessage());
        smsBrokerService.sendBulkSmsFromCsvAfrica(event.getSmscsv(), event.getSingle(), event.getMessage());
    }
}
