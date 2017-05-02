/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.eventbus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.muhia.app.psi.portal.PortalApplication;
import org.muhia.app.psi.portal.service.orm.IPrincipalsService;
import org.muhia.app.psi.portal.service.orm.IUssdRequestsProcessorService;
import org.muhia.app.psi.config.menu.ussd.MenuMessages;
import org.muhia.app.psi.orm.model.ApplicationSrc;
import org.muhia.app.psi.orm.model.OrderMaster;
import org.muhia.app.psi.orm.model.Principals;
import org.muhia.app.psi.orm.model.UssdRequests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.MessageFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EvenbusSubscriberTests {

    @Autowired
    private SyncEventsSubscriberService service;

    @Autowired
    private IPrincipalsService principalsService;

    @Autowired
    private IUssdRequestsProcessorService requestService;

    @Autowired
    private MenuMessages menuMessages;

    private UssdRequests logUssdRequest(UssdRequests ussdRequests) {


        return requestService.saveUssdRequest(ussdRequests);

    }

    private boolean markSessionClosed(String sessionId) {
        boolean results = false;
        Optional<Collection<UssdRequests>> sessionRequests = Optional.ofNullable(requestService.findUssdRequestsBySessionId(sessionId));
        try {

            sessionRequests
                    .ifPresent(sr -> sr
                            .forEach(u -> {
//                            results.put(u.getVarFld2(), u.getVarFld3());
                                u.setStatus("30");
                                logUssdRequest(u);

                            }));
            results = true;
//            stream().forEach(u -> results.put(u.getVarFld2(), u.getVarFld3()));
        } catch (Exception e) {
            Logger.getLogger(SyncEventsSubscriberService.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }

        return results;
    }

    private Map<String, String> extractMapFromSessionId() {
        Map<String, String> results = new HashMap<>();

        Optional<Collection<UssdRequests>> sessionRequests = requestService.findUssdRequestsBySessionIdAndStatusAndVarFld4Exists("14383457558798499", menuMessages.getUssdSuccessStatus());

        try {

            sessionRequests
                    .ifPresent(sr -> sr
                            .forEach(u -> {
                        /*
                          Add Fields to Map
                         */
//                                if (u.getVarFld2() != null) {
//                                    results.put(u.getVarFld2() == null ? "" : u.getVarFld2(), u.getVarFld3() == null ? "" : u.getVarFld3());
//                                }
                                if (u.getVarFld4() != null || u.getVarFld4().length() > 1) {
                                    results.put(u.getVarFld4(), u.getVarFld3() == null || u.getVarFld3().length() < 1 ? "" : u.getVarFld3());
                                }
                            }));

        } catch (Exception e) {
            Logger.getLogger(SyncEventsSubscriberService.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return results;
    }

    @Test
    public void testRegisterSubscriber() {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Before");
        PortalApplication.dashBoardEventBusService().register(service);
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "After");

        Principals testUser = principalsService.findByLoginName("tester05");
        String url = "http://127.0.0.1/portal/registrationConfirm";

        Logger.getLogger(this.getClass().getName()).log(Level.INFO, MessageFormat.format("url is {0} using user {1}", url, testUser.getCellphonenumber()));

//        SecureAccessApplication.dashBoardEventBusService().post(new DashboardEvent.RegistrationCompletedEvent(url, testUser));

    }

    @Test
    public void testCreateWorkOrder() {
        OrderMaster orderMaster = new OrderMaster();
        Map<String, String> productParamsMap = extractMapFromSessionId();
        if (!productParamsMap.isEmpty()) {
            int i = 1;
            for (Map.Entry<String, String> entry : productParamsMap.entrySet()) {

                try {
                    if (entry.getKey().startsWith("PRODUCTID:")) {
                        orderMaster.setProductId(requestService.findProductMasterById(Long.valueOf(entry.getValue())));
                    } else {
                        switch (i) {
                            case 1:
                                orderMaster.setVarFld01(entry.getValue());
                                break;
                            case 2:
                                orderMaster.setVarFld02(entry.getValue());
                                break;
                            case 3:
                                orderMaster.setVarFld03(entry.getValue());
                                break;
                            case 4:
                                orderMaster.setVarFld04(entry.getValue());
                                break;
                            case 5:
                                orderMaster.setVarFld05(entry.getValue());
                                break;
                            case 6:
                                orderMaster.setVarFld06(entry.getValue());
                                break;
                            case 7:
                                orderMaster.setVarFld07(entry.getValue());
                                break;
                        }

                    }
                    i++;


                } catch (NumberFormatException ex) {
                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "{0} is an invalid ProductId {1}", new Object[]{entry.getValue(), ex.getMessage()});

                }

            }
            UssdRequests testUssdRequest = requestService.findUssdRequestByTransactionIdAndStatus("200220150731152915301394", "0");
            orderMaster.setEventbusSubmitDate(new Date());
            orderMaster.setSubmittedDate(new Date());
            orderMaster.setRemoteSessionId(testUssdRequest.getSessionid());
            orderMaster.setRequesterId(testUssdRequest.getId());
            ApplicationSrc applicationSrc = requestService.findApplicationSrcByApplication(menuMessages.getAppName());
            orderMaster.setRequestorApplicationId(applicationSrc);
            orderMaster.setRequestorApplicationUser(menuMessages.getAppNameUser());
            orderMaster.setSrcHostname(applicationSrc.getHostName());
            orderMaster.setSrcIp(applicationSrc.getHostIp());


            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "WR/SR created for sessionId +{0}", testUssdRequest.getSessionid());
//            SecureAccessApplication.asyncEventbusService().post(new DashboardEvent.UssdOrderCreationRequestedEvent(orderMaster, testUssdRequest, ""));
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Start Session finalise for sessionId +{0}", testUssdRequest.getSessionid());
            markSessionClosed(testUssdRequest.getSessionid());
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Session finalised for sessionId +{0}", testUssdRequest.getSessionid());

        }


    }

//    @Subscribe
//    public void SubscriptionTest(DashboardEvent.RegistrationCompletedEvent e) {
//        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "During subscription {0}", e.getUser().getEmailaddress());
//    }
}
