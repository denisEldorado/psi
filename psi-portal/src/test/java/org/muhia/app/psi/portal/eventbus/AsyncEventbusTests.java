package org.muhia.app.psi.portal.eventbus;

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
 
 
  Generated on 04-Nov-16 11:21 
 
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.muhia.app.psi.config.menu.ussd.MenuMessages;
import org.muhia.app.psi.config.order.properties.OrderProcessingProperties;
import org.muhia.app.psi.orm.model.OrderMaster;
import org.muhia.app.psi.orm.model.ServiceRequests;
import org.muhia.app.psi.orm.model.UssdRequests;
import org.muhia.app.psi.portal.PortalApplication;
import org.muhia.app.psi.portal.service.orchestrate.IServiceProvisioningActions;
import org.muhia.app.psi.portal.service.orm.IUssdRequestsProcessorService;
import org.muhia.app.psi.portal.service.orm.IWorkOrderProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.text.MessageFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.System.out;

/*
  @author Kenneth Muhia <muhia@muhia.org> on 04-Nov-16. 
  for package org.muhia.app.psi.portal.eventbus
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncEventbusTests {

    @Autowired
    OrderProcessingProperties orderProcessingProperties;
    @Autowired
    private IUssdRequestsProcessorService requestService;
    @Autowired
    private IWorkOrderProcessingService orderProcessingService;
    @Autowired
    private MenuMessages menuMessages;
    @Autowired
    private IServiceProvisioningActions provisioningActions;

    @Test
    private Map<String, String> extractMapFromSessionId() {
        String sessionId1 = "14383457558798609";
        Map<String, String> results = new HashMap<>();

        Optional<Collection<UssdRequests>> sessionRequests = requestService.findUssdRequestsBySessionIdAndStatusAndVarFld4Exists("14383457558798609", menuMessages.getUssdSuccessStatus());

        try {

            sessionRequests
                    .ifPresent(sr -> sr
                            .forEach(u -> {
                        /*
                          Add Fields to Map
                         */
//                                if (u.getVarFld4() != null) {
//                                    results.put(u.getVarFld4() == null ? "" : u.getVarFld2(), u.getVarFld3() == null ? "" : u.getVarFld3());
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

    private Map<String, String> createMapFromSr(ServiceRequests sr) {
        Map<String, String> results = new HashMap<>();
        /*
         DONE First item should be the method to be used or should it?
         */
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
            results.put(sr.getPrvItemMapKey5(), sr.getPrvItemMapValue6());
        }
        if (sr.getPrvItemMapKey6() != null) {
            results.put(sr.getPrvItemMapKey6(), sr.getPrvItemMapValue7());
        }
        if (sr.getPrvItemMapKey7() != null) {
            results.put(sr.getPrvItemMapKey1(), sr.getPrvItemMapValue7());
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

    @SuppressWarnings("unchecked")
    @Test
    public void serviceProvisioningMethodInvocationTest() {
        OrderMaster order = orderProcessingService.findOrderMasterById(Long.valueOf("102"));
        Map<String, String> orderMap = extractMapFromSessionId();
        DashboardEvent.ServiceActivationEvent event = new DashboardEvent.ServiceActivationEvent(order, orderMap);
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "event is " + event.toString());
        Optional<ServiceRequests> serviceRequests = orderProcessingService.findServiceRequestByIdAndStatus(Long.valueOf("22"), orderProcessingProperties.getSrInitiatedStatus());

        serviceRequests.ifPresent(sr -> {
            Map<String, String> serviceRequestMap = createMapFromSr(sr);
            Optional<String> methodToImplement = Optional.ofNullable(serviceRequestMap.get("methodname"));
            methodToImplement.ifPresent(methodName -> {
                try {
                    if (provisioningActions == null) {
                        Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Service Provisioning Actions is null");
//                        provisioningActions = new ServiceProvisioningActions();
                    }
                    Method method = provisioningActions.getClass().getMethod(methodName, Map.class, ServiceRequests.class);
                    Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Calling " + method.getName() + " using " + serviceRequestMap.toString() + " and " + sr);
                    Map<String, Object> results = (Map<String, Object>) method.invoke(provisioningActions, serviceRequestMap, sr);
                    Logger.getLogger(this.getClass().getName()).log(Level.INFO, MessageFormat.format("Action response is{0}", results.toString()));
                } catch (NoSuchMethodException | NullPointerException | IllegalAccessException | InvocationTargetException e) {
                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                }

            });

        });
    }

    @Test
    public void reflectMethodInvocationTest() {
        OrderMaster order = orderProcessingService.findOrderMasterById(Long.valueOf("102"));
        Map<String, String> orderMap = extractMapFromSessionId();
        DashboardEvent.ServiceActivationEvent event = new DashboardEvent.ServiceActivationEvent(order, orderMap);
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Before");
        PortalApplication.asyncEventbusService().post(event);
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "After");
    }

    @Test
    public void reflectionTest() {

        String[] args = new String[4];
        args[0] = "0";
        args[1] = "1";
        args[2] = "2";
        args[3] = "3";

        try {
//            provisioningActions = new ServiceProvisioningActions();
            String className = provisioningActions.getClass().getName();
            Class<?> c;

            c = Class.forName(className);

            Object t = c.newInstance();

            Method[] allMethods = c.getDeclaredMethods();
            for (Method m : allMethods) {
                String mname = m.getName();
                if (!mname.startsWith("test")
                        || (m.getGenericReturnType() != boolean.class)) {
                    continue;
                }
                Type[] pType = m.getGenericParameterTypes();
                if ((pType.length != 1)
                        || Locale.class.isAssignableFrom(pType[0].getClass())) {
                    continue;
                }

                out.format("invoking %s()%n", mname);

                m.setAccessible(true);
                Object o = m.invoke(t, new Locale(args[1], args[2], args[3]));
                out.format("%s() returned %b%n", mname, o);

                // Handle any exceptions thrown by method to be invoked.
            }
        } catch (NullPointerException | IllegalAccessException | InvocationTargetException | ClassNotFoundException | InstantiationException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
//            err.format("invocation of %s failed: %s%n", mname, cause.getMessage());
        }

    }
}
