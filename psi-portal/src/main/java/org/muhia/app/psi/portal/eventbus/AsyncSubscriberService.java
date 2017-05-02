/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.eventbus;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;
import org.muhia.app.psi.config.CustomUtilities;
import org.muhia.app.psi.config.menu.ussd.MenuMessages;
import org.muhia.app.psi.config.order.properties.OrderProcessingProperties;
import org.muhia.app.psi.config.sms.properties.SmsKannelConnectorProperties;
import org.muhia.app.psi.orm.model.*;
import org.muhia.app.psi.portal.PortalApplication;
import org.muhia.app.psi.portal.service.activation.IServiceActivator;
import org.muhia.app.psi.portal.service.orchestrate.IServiceProvisioningActions;
import org.muhia.app.psi.portal.service.orm.IUssdRequestsProcessorService;
import org.muhia.app.psi.portal.service.orm.IWorkOrderProcessingService;
import org.muhia.app.psi.portal.service.sms.ISmsBrokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author KennethKZMMuhia
 */
@Service
public class AsyncSubscriberService {

    private final IUssdRequestsProcessorService processorService;

    private final IWorkOrderProcessingService orderProcessingService;

    private final IUssdRequestsProcessorService requestService;

    private final MenuMessages menuMessages;

    private final CustomUtilities utilities;

    private final SmsKannelConnectorProperties smsKannelConnectorProperties;

    private final ISmsBrokerService smsBrokerService;

    private final IServiceActivator serviceActivator;

    private final IServiceProvisioningActions provisioningActions;

    private final OrderProcessingProperties orderProcessingProperties;

    @Autowired
    public AsyncSubscriberService(AsyncEventbusService asyncEventbusService, IWorkOrderProcessingService orderProcessingService, IUssdRequestsProcessorService requestService, MenuMessages menuMessages, CustomUtilities utilities, SmsKannelConnectorProperties smsKannelConnectorProperties, ISmsBrokerService smsBrokerService, IServiceActivator serviceActivator, IServiceProvisioningActions provisioningActions, OrderProcessingProperties orderProcessingProperties, IUssdRequestsProcessorService processorService) {

        this.orderProcessingService = orderProcessingService;
        this.requestService = requestService;
        this.menuMessages = menuMessages;
        this.utilities = utilities;
        this.smsKannelConnectorProperties = smsKannelConnectorProperties;
        this.smsBrokerService = smsBrokerService;
        this.serviceActivator = serviceActivator;
        this.provisioningActions = provisioningActions;
        this.orderProcessingProperties = orderProcessingProperties;
        asyncEventbusService.register(AsyncSubscriberService.this);
        this.processorService = processorService;
    }

    private void markSessionClosed(String sessionId) {
        Optional<Collection<UssdRequests>> sessionRequests = Optional.ofNullable(requestService.findUssdRequestsBySessionId(sessionId));
        try {

            sessionRequests.ifPresent(sr -> sr
                    .forEach(u -> {
//                            results.put(u.getVarFld2(), u.getVarFld3());
                        u.setStatus(menuMessages.getUssdSuccessProcessStatus());
                        requestService.saveUssdRequest(u);

                    }));
            //            stream().forEach(u -> results.put(u.getVarFld2(), u.getVarFld3()));
        } catch (Exception e) {
            Logger.getLogger(SyncEventsSubscriberService.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }

    }
//
    private void markSmsInByStatus(SmsRegistry smsRegistry, int status) {
        /*
            TODO: Cannot recall why we need this
         */
        smsRegistry.setDeliveryStatus(new Long(status));
        smsBrokerService.registerIncomingSms(smsRegistry);
    }
//
    private void markSessionByStatus(String sessionId, String status) {
        Optional<Collection<UssdRequests>> sessionRequests = Optional.ofNullable(requestService.findUssdRequestsBySessionId(sessionId));
        try {

            sessionRequests.ifPresent(sr -> sr
                    .forEach(u -> {
//                            results.put(u.getVarFld2(), u.getVarFld3());
                        u.setStatus(status);
                        requestService.saveUssdRequest(u);

                    }));
            //            stream().forEach(u -> results.put(u.getVarFld2(), u.getVarFld3()));
        } catch (Exception e) {
            Logger.getLogger(SyncEventsSubscriberService.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }

    }

    @AllowConcurrentEvents
    @Subscribe
    @Transactional
    public void handleSmsOrderCreationRequestEvent(DashboardEvent.SmsOrderCreationRequestEvent event) {
        try {

            Map<String, String> productParams = new HashMap<>();
            Optional<Collection<OrderMaster>> pendingOrdersForSubscriber = orderProcessingService.findOrderMasterBySubnoAndTransactionStatus(event.getSmsRegistry().getSubno(), Integer.valueOf(menuMessages.getInitWorkOrderStatus()));

            if (!pendingOrdersForSubscriber.orElse(null).isEmpty()) {
                /*
                                Notify subscriber that their pending transaction is still being processed
                 */
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, MessageFormat.format("Duplicate request detected for productid: {0} from {1} detected on sessionId: {2}", event.getProductsMaster().getId(), event.getSmsRegistry().getSubno(), event.getSmsRegistry().getMessageText()));
                markSmsInByStatus(event.getSmsRegistry(), smsKannelConnectorProperties.getSmsInInitResponseStatus());
                smsBrokerService.registerSmsForSending(menuMessages.getDuplicateRequestMessage(), event.getSmsRegistry().getSubno(), smsKannelConnectorProperties.getSender(), smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus());
            } else {
                Optional<ProductPrvTemplates> prvTemplates = Optional.ofNullable(orderProcessingService.findProductPrvTemplatesByProductIdAndStatus(event.getProductsMaster(), 1));
                prvTemplates.ifPresent(productPrvTemplates -> {

                    OrderMaster orderMaster = new OrderMaster();

                    orderMaster.setEventbusSubmitDate(new Date());
                    orderMaster.setSubno(event.getSmsRegistry().getSubno());
                    orderMaster.setTransactionStatus(orderProcessingProperties.getOrderInitiatedStatus());
                    orderMaster.setRemoteSessionId(event.getSmsRegistry().getId().toString());
                    ApplicationSrc applicationSrc = requestService.findApplicationSrcByApplication(smsKannelConnectorProperties.getAppName());
                    orderMaster.setSrcIp(applicationSrc.getHostIp());
                    orderMaster.setSrcHostname(applicationSrc.getHostName());
                    orderMaster.setProductId(event.getProductsMaster());
                    orderMaster.setSubmittedDate(new Date());
                    orderMaster.setRequestorApplicationId(applicationSrc);
                    orderMaster.setRequestorApplicationUser(smsKannelConnectorProperties.getAppUserName());
                    orderMaster.setRequesterId(event.getSmsRegistry().getId());

                    /*
                        DONE: How does the Map get created and data loaded?
                     */
                    orderMaster.setVarFld01(event.getProductParamsMap().get(productPrvTemplates.getVarFld01()));
                    orderMaster.setVarFld02(event.getProductParamsMap().get(productPrvTemplates.getVarFld02()));
                    orderMaster.setVarFld03(event.getProductParamsMap().get(productPrvTemplates.getVarFld03()));
                    orderMaster.setVarFld04(event.getProductParamsMap().get(productPrvTemplates.getVarFld04()));
                    orderMaster.setVarFld05(event.getProductParamsMap().get(productPrvTemplates.getVarFld05()));
                    orderMaster.setVarFld06(event.getProductParamsMap().get(productPrvTemplates.getVarFld06()));
                    orderMaster.setVarFld07(event.getProductParamsMap().get(productPrvTemplates.getVarFld07()));
                    orderMaster.setVarFld08(event.getProductParamsMap().get(productPrvTemplates.getVarFld08()));
                    orderMaster.setVarFld09(event.getProductParamsMap().get(productPrvTemplates.getVarFld09()));
                    orderMaster.setVarFld10(event.getProductParamsMap().get(productPrvTemplates.getVarFld10()));

                    orderMaster = orderProcessingService.createNewOrder(orderMaster);
                    Logger.getLogger(this.getClass().getName()).log(Level.INFO, MessageFormat.format("WorkOrder#: {0} created for smssessionId: {1}", orderMaster.getId(), event.getSmsRegistry().getId()));
                    PortalApplication.asyncEventbusService().post(new DashboardEvent.ServiceActivationEvent(orderMaster, productParams));
                    markSmsInByStatus(event.getSmsRegistry(), smsKannelConnectorProperties.getSmsInFinalStatus());
                });

            }

        } catch (NumberFormatException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            event.setMessages(e.getMessage());
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            event.setMessages(menuMessages.getGeneralExceptionMessage());
        }

    }

    @AllowConcurrentEvents
    @Subscribe
    public void handleUssdOrderCreationRequestedEvent(DashboardEvent.UssdOrderCreationRequestedEvent event) {
        try {
            /*
                Confirm that we have a product ID
             */
            Optional<String> productid = Optional.ofNullable(event.getProductParamsMap().get("productid"));

            productid.ifPresent(p -> {
                Optional<ProductsMaster> productsMaster = Optional.ofNullable(requestService.findProductMasterById(Long.valueOf(p)));

                productsMaster.ifPresent(product -> {
                    try {

                        Optional<ProductPrvTemplates> prvTemplates = Optional.ofNullable(orderProcessingService.findProductPrvTemplatesByProductIdAndStatus(product, 1));
                        prvTemplates.ifPresent(productPrvTemplates -> {
                            OrderMaster orderMaster = new OrderMaster();
                            orderMaster.setProductId(product);
                            orderMaster.setSubno(event.getProductParamsMap().get("cellphonenumber") == null ? "" : event.getProductParamsMap().get("cellphonenumber"));
                            orderMaster.setEventbusSubmitDate(new Date());
                            orderMaster.setSubmittedDate(new Date());
                            orderMaster.setRemoteSessionId(event.getUssdRequests().getSessionid());
                            orderMaster.setRequesterId(event.getUssdRequests().getId());
                            ApplicationSrc applicationSrc = requestService.findApplicationSrcByApplication(menuMessages.getAppName());
                            orderMaster.setRequestorApplicationId(applicationSrc);
                            orderMaster.setRequestorApplicationUser(menuMessages.getAppNameUser());
                            orderMaster.setSrcHostname(applicationSrc.getHostName());
                            orderMaster.setSrcIp(applicationSrc.getHostIp());
                            orderMaster.setTransactionStatus(orderProcessingProperties.getOrderInitiatedStatus());

                            orderMaster.setVarFld01(event.getProductParamsMap().get(productPrvTemplates.getVarFld01()));
                            orderMaster.setVarFld02(event.getProductParamsMap().get(productPrvTemplates.getVarFld02()));
                            orderMaster.setVarFld03(event.getProductParamsMap().get(productPrvTemplates.getVarFld03()));
                            orderMaster.setVarFld04(event.getProductParamsMap().get(productPrvTemplates.getVarFld04()));
                            orderMaster.setVarFld05(event.getProductParamsMap().get(productPrvTemplates.getVarFld05()));
                            orderMaster.setVarFld06(event.getProductParamsMap().get(productPrvTemplates.getVarFld06()));
                            orderMaster.setVarFld07(event.getProductParamsMap().get(productPrvTemplates.getVarFld07()));
                            orderMaster.setVarFld08(event.getProductParamsMap().get(productPrvTemplates.getVarFld08()));
                            orderMaster.setVarFld09(event.getProductParamsMap().get(productPrvTemplates.getVarFld09()));
                            orderMaster.setVarFld10(event.getProductParamsMap().get(productPrvTemplates.getVarFld10()));


                            /*
                        DONE: Have all UssdParameters passed on for
                             */
                            Optional<Collection<OrderMaster>> pendingOrdersForSubscriber = orderProcessingService.findOrderMasterBySubnoAndTransactionStatus(orderMaster.getSubno(), Integer.valueOf(menuMessages.getInitWorkOrderStatus()));

                            if (!pendingOrdersForSubscriber.orElse(null).isEmpty()) {
                                /*
                                Notify subscriber that their pending transaction is still being processed
                                 */
                                Logger.getLogger(this.getClass().getName()).log(Level.INFO, MessageFormat.format("Duplicate request detected for productid: {0} from {1} detected on sessionId: {2}", product, event.getProductParamsMap().get("cellphonenumber") == null ? "" : event.getProductParamsMap().get("cellphonenumber"), event.getUssdRequests().getSessionid()));
                                markSessionByStatus(event.getUssdRequests().getSessionid(), menuMessages.getDuplicateRequestMessage());
                                smsBrokerService.registerSmsForSending(menuMessages.getDuplicateRequestMessage(), event.getProductParamsMap().get("cellphonenumber"), smsKannelConnectorProperties.getSender(), smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus());
                            } else {
                                orderMaster = orderProcessingService.createNewOrder(orderMaster);
                                Logger.getLogger(this.getClass().getName()).log(Level.INFO, MessageFormat.format("WorkOrder#: {0} created for sessionId: {1}", orderMaster.getId(), event.getUssdRequests().getSessionid()));
                                PortalApplication.asyncEventbusService().post(new DashboardEvent.ServiceActivationEvent(orderMaster, event.getProductParamsMap()));
                                markSessionClosed(event.getUssdRequests().getSessionid());

                            }
                        });

                    } catch (Exception e) {

                        String[] placeHolders = new String[5];
                        Optional<SmsNotification> optionalSmsNotification = Optional.ofNullable(product.getFailureSms());
                        optionalSmsNotification.ifPresent(smsNotification -> {
                            if (smsNotification.getPlaceHolder1() != null) {
                                placeHolders[0] = smsNotification.getPlaceHolder1();
                            }
                            if (smsNotification.getPlaceHolder2() != null) {
                                placeHolders[1] = smsNotification.getPlaceHolder2();
                            }
                            if (smsNotification.getPlaceHolder3() != null) {
                                placeHolders[2] = smsNotification.getPlaceHolder3();
                            }
                            if (smsNotification.getPlaceHolder4() != null) {
                                placeHolders[3] = smsNotification.getPlaceHolder4();
                            }
                            if (smsNotification.getPlaceHolder4() != null) {
                                placeHolders[4] = smsNotification.getPlaceHolder5();
                            }
                        });
                        String failureSmsStr = utilities.addParametersToMessage(product.getFailureSms().getDescription(), placeHolders, event.getProductParamsMap());
                        String senderCode = product.getFailureSms().getSender() != null ? product.getFailureSms().getSender() : smsKannelConnectorProperties.getSender();
                        smsBrokerService.registerSmsForSending(failureSmsStr, event.getProductParamsMap().get("cellphonenumber"), senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus());

                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                    }
                });
            });

        } catch (Exception e) {

            smsBrokerService.registerSmsForSending(menuMessages.getGeneralExceptionMessage(), event.getProductParamsMap().get("cellphonenumber"), smsKannelConnectorProperties.getSender(), smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus());
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }

    }

    @SuppressWarnings("unchecked")
    @AllowConcurrentEvents
    @Subscribe
    public void handleUssdServiceActivationEvent(DashboardEvent.ServiceActivationEvent event) {

//        try {
//            Map<String, String> serviceRequestMap = serviceActivator.initServiceOrder(event.getOrder());
//
//        /*
//            Invoke the method defined on the Provisioning Templates
//         */
//            String methodToImplement = serviceRequestMap.get("methodname") != null ? serviceRequestMap.get("methodname") : null;
//
//            orderProcessingService.findServiceRequestsByOrder(event.getOrder()).ifPresent(sr -> {
//                try {
//                    if (provisioningActions == null) {
//                        provisioningActions = new ServiceProvisioningActions();
//                    }
//                    Method method = provisioningActions.getClass().getMethod(methodToImplement, new Class[]{Map.class, ServiceRequests.class});
//                    Logger.getLogger(this.getClass().getName()).log(Level.INFO, new StringBuilder().append("Calling ").append(method.getName()).append(" using ").append(serviceRequestMap.toString()).append(" and ").append(sr).toString());
//                    Map<String, Object> results = (Map<String, Object>) method.invoke(provisioningActions, serviceRequestMap, sr);
//                    Logger.getLogger(this.getClass().getName()).log(Level.INFO, MessageFormat.format("Action response is{0}", results.toString()));
//                } catch (NoSuchMethodException | NullPointerException | IllegalAccessException | InvocationTargetException e) {
//                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
//                }
//
//            });
//
//
//        } catch (Exception e) {
//            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
//        }
        try {

            Map<String, String> serviceRequestMap = serviceActivator.initServiceOrder(event.getOrder());
            Optional<ServiceRequests> serviceRequests = orderProcessingService.findServiceRequestsByOrderAndStatus(event.getOrder(), orderProcessingProperties.getSrInitiatedStatus());
            serviceRequests.ifPresent(sr -> {
                /*
                    TODO: We need an intermediate status here to prevent two apps from picking up the same SR
                 */
                sr.setStatus(orderProcessingProperties.getSrPendingStatus());
                sr.setRequestdequeuedDate(new Date());

                orderProcessingService.saveServiceRequest(sr);


                Optional<String> methodToImplement = Optional.ofNullable(serviceRequestMap.get("methodname"));
                methodToImplement.ifPresent(methodName -> {
                    try {
                        /*
                            TODO: Is this still needed with Autowiring?, Need to test
                         */
                        if (provisioningActions == null) {
                            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Provisioning actions are null");
//                            provisioningActions = new ServiceProvisioningActions();
                        }
                        Method method = provisioningActions != null ? provisioningActions.getClass().getMethod(methodName, Map.class, ServiceRequests.class) : null;
                        Logger.getLogger(this.getClass().getName()).log(Level.FINE, "Calling " + (method != null ? method.getName() : null) + " using " + serviceRequestMap.toString() + " and " + sr);
                        assert method != null;
                        Map<String, Object> results = (Map<String, Object>) method.invoke(provisioningActions, serviceRequestMap, sr);
//                        Logger.getLogger(this.getClass().getName()).log(Level.INFO, MessageFormat.format("Action response is{0}", results.toString()));
                        results.forEach((s, o) -> Logger.getLogger(this.getClass().getName()).log(Level.FINE, String.format("Action response is %s=%s", s, o.toString())));
                    } catch (NoSuchMethodException | IllegalAccessException e) {
                        /*
                            Method defination not done correctly.
                            Log the failure and retain the status so that it can be changed to get the SR provisioned
                         */
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, String.format("%s%s could not be processed due to incorrect processing method defination", e.getMessage(), sr.toString()));

                    } catch (InvocationTargetException e) {
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, String.format("%s%s could not be processed due to an exception within the reflected method", e.getMessage(), sr.toString()), e);

                    } catch (NullPointerException e) {
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                    }

                });
            });
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @SuppressWarnings("unchecked")
    @AllowConcurrentEvents
    @Subscribe
    public void handleProcessPendingServiceRequestsEvent(DashboardEvent.ProcessPendingServiceRequestsEvent event) {
        Optional<String> methodToImplement = Optional.ofNullable(event.getServiceRequests().getPrvItemMapValue1());
        methodToImplement.ifPresent(methodName -> {
            try {
                Map<String, String> serviceRequestMap = createMapFromServiceRequests(event.getServiceRequests());
                Method method = provisioningActions.getClass().getMethod(methodName, Map.class, ServiceRequests.class);
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("Calling %s using %s and %s", method.getName(), serviceRequestMap.toString(), event.getServiceRequests()));
                Map<String, Object> results = (Map<String, Object>) method.invoke(provisioningActions, serviceRequestMap, event.getServiceRequests());
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, MessageFormat.format("Action response is{0}", results.toString()));
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                event.getServiceRequests().setStatus(orderProcessingProperties.getsrReprocessFailed());
                orderProcessingService.saveServiceRequest(event.getServiceRequests());
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            } catch (NullPointerException | ClassCastException e) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }

        });
    }

    private Map<String, String> createMapFromServiceRequests(ServiceRequests sr) {
        Map<String, String> results = new HashMap<>();
        /*
         TODO: Test performance by returning SR as item in Map to reduce calls to DB
         */
        results.put(orderProcessingProperties.getSrIdKeyword(), String.valueOf(sr.getId()));
        if (sr.getPrvItemMapKey1() != null) {
            results.put(sr.getPrvItemMapKey1(), sr.getPrvItemMapValue1());
        }
        if (sr.getPrvItemMapKey2() != null) {
            results.put(sr.getPrvItemMapKey2(), sr.getPrvItemMapValue2());
        }
        if (sr.getPrvItemMapKey3() != null) {
            results.put(sr.getPrvItemMapKey3(), sr.getPrvItemMapValue3());
        }
        if (sr.getPrvItemMapKey4() != null) {
            results.put(sr.getPrvItemMapKey4(), sr.getPrvItemMapValue4());
        }
        if (sr.getPrvItemMapKey5() != null) {
            results.put(sr.getPrvItemMapKey5(), sr.getPrvItemMapValue5());
        }
        if (sr.getPrvItemMapKey6() != null) {
            results.put(sr.getPrvItemMapKey6(), sr.getPrvItemMapValue6());
        }
        if (sr.getPrvItemMapKey7() != null) {
            results.put(sr.getPrvItemMapKey7(), sr.getPrvItemMapValue7());
        }
        if (sr.getPrvItemMapKey8() != null) {
            results.put(sr.getPrvItemMapKey8(), sr.getPrvItemMapValue8());
        }
        if (sr.getPrvItemMapKey9() != null) {
            results.put(sr.getPrvItemMapKey9(), sr.getPrvItemMapValue9());
        }
        if (sr.getPrvItemMapKey10() != null) {
            results.put(sr.getPrvItemMapKey10(), sr.getPrvItemMapValue10());
        }

        return results;
    }

    @AllowConcurrentEvents
    @Subscribe
    public void handleUssdRequestProcessingSubmitEvent(DashboardEvent.UssdRequestProcessingSubmitEvent event) {
        /*
          Use the session ID to get all the data
         */
        try {
            Map<String, String> model = new HashMap<>();

            Stream<String> stringStream = processorService
                    .findUssdRequestsBySessionId(event.getRequests().getSessionid())
                    .stream()
                    .filter(sr -> sr.getVarFld2() != null || !sr.getVarFld2().isEmpty())
                    .collect(Collectors.toList())
                    .stream().map(srs -> model.put(srs.getVarFld2(), srs.getVarFld3()));

            /*
              Create a new service requests
             */
//            sessionRequests.stream().map(sr -> model.put(sr.getVarFld2(), sr.getVarFld3()));
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, stringStream.toString());
        } catch (Exception e) {
            Logger.getLogger(AsyncSubscriberService.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }

    }

}
