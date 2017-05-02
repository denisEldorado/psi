package org.muhia.app.psi.portal.service.activation.impl;


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
  Generated on 29-Oct-16 00:30
 */

import org.muhia.app.psi.portal.service.activation.IServiceActivator;
import org.muhia.app.psi.portal.service.orm.IWorkOrderProcessingService;
import org.muhia.app.psi.portal.service.sms.ISmsBrokerService;
import org.muhia.app.psi.config.menu.ussd.MenuMessages;
import org.muhia.app.psi.config.order.properties.OrderProcessingProperties;
import org.muhia.app.psi.config.sms.properties.SmsKannelConnectorProperties;
import org.muhia.app.psi.orm.model.OrderMaster;
import org.muhia.app.psi.orm.model.PricingProfile;
import org.muhia.app.psi.orm.model.ProductPrvTemplates;
import org.muhia.app.psi.orm.model.ServiceRequests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Kenneth Muhia <muhia@muhia.org> on 29-Oct-16.
 *         for package org.muhia.app.psi.portal.service.activation.impl
 */
@Service
public class ServiceActivator implements IServiceActivator {

    private final IWorkOrderProcessingService workOrderProcessingService;

    private final ISmsBrokerService smsBrokerService;

    private final MenuMessages menuMessages;

    private final OrderProcessingProperties orderProcessingProperties;

    private final SmsKannelConnectorProperties smsKannelConnectorProperties;

    @Autowired
    public ServiceActivator(IWorkOrderProcessingService workOrderProcessingService, ISmsBrokerService smsBrokerService, MenuMessages menuMessages, OrderProcessingProperties orderProcessingProperties, SmsKannelConnectorProperties smsKannelConnectorProperties) {
        this.workOrderProcessingService = workOrderProcessingService;
        this.smsBrokerService = smsBrokerService;
        this.menuMessages = menuMessages;
        this.orderProcessingProperties = orderProcessingProperties;
        this.smsKannelConnectorProperties = smsKannelConnectorProperties;
    }


    @Override
    @Transactional
    public Map<String, String> initServiceOrder(OrderMaster order) {
        Map<String, String> prvParameterMap = new HashMap<>();
        try {
            /*
                Lets create a new service flow
             */
            ProductPrvTemplates prvTemplates = workOrderProcessingService.findProductPrvTemplatesByProductIdAndStatus(order.getProductId(), 1);


            Optional<PricingProfile> pricingProfile = Optional.ofNullable(workOrderProcessingService.findFirstPricingProfileByProductId(order.getProductId()));
            if (pricingProfile.isPresent()) {
                ServiceRequests serviceRequests = pricingProfile.map((PricingProfile pricing) -> {

                    ServiceRequests sr = new ServiceRequests();
                    sr.setChargingNode(pricing.getWallet());
                    sr.setChargingValue(pricing.getWalletValue().toString());
                    sr.setPrvTemplate(prvTemplates);

                    sr.setPriority(orderProcessingProperties.getDefaultSrPriority());
                    sr.setOrderreceivedDate(order.getSubmittedDate());
                    sr.setWorkorderinitiatedDate(new Date());
                    /**
                     DONE: Ammend to pick up values correctly
                     */
                    sr.setPrvItemMapKey1(orderProcessingProperties.getMethodnameKeyword());
                    sr.setPrvItemMapValue1(prvTemplates.getTemplateName());
                    sr.setPrvItemMapKey2(prvTemplates.getVarFld01());
                    sr.setPrvItemMapValue2(order.getVarFld01());
                    sr.setPrvItemMapKey3(prvTemplates.getVarFld02());
                    sr.setPrvItemMapValue3(order.getVarFld02());
                    sr.setPrvItemMapKey4(prvTemplates.getVarFld03());
                    sr.setPrvItemMapValue4(order.getVarFld03());
                    sr.setPrvItemMapKey5(prvTemplates.getVarFld04());
                    sr.setPrvItemMapValue5(order.getVarFld04());
                    sr.setPrvItemMapKey6(prvTemplates.getVarFld05());
                    sr.setPrvItemMapValue6(order.getVarFld05());
                    sr.setPrvItemMapKey7(prvTemplates.getVarFld06());
                    sr.setPrvItemMapValue7(order.getVarFld06());
                    sr.setPrvItemMapKey8(prvTemplates.getVarFld07());
                    sr.setPrvItemMapValue8(order.getVarFld07());
                    sr.setPrvItemMapKey9(prvTemplates.getVarFld08());
                    sr.setPrvItemMapValue9(order.getVarFld08());
                    sr.setPrvItemMapKey10(prvTemplates.getVarFld09());
                    sr.setPrvItemMapValue10(order.getVarFld09());
                    sr.setRenewable(orderProcessingProperties.getSrRenewableFalse());
                    sr.setResourceorderscreatedDate(new Date());
                    sr.setStatus(orderProcessingProperties.getSrInitiatedStatus());

                    order.setTransactionStatus(orderProcessingProperties.getOrderSubmittedStatus());
                    workOrderProcessingService.saveOrderMaster(order);
                    sr.setOrderNumber(order);

                /*
                    TODO: Confirm that the order gets persited with the new status
                 */
                    sr = workOrderProcessingService.saveServiceRequest(sr);

                    return sr;


                }).orElse(null);

                if (serviceRequests != null) {
                    prvParameterMap = createMapFromSr(serviceRequests);
                }
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, String.format("Pricing Profile is not defined for [Product=%s ] ", prvTemplates.getProductId().getDescription()));
            }


            /**
             TODO: Invoke the method to do provisioning, hmmh seems overtaken by events
             */


        } catch (Exception e) {

            smsBrokerService.registerSmsForSending(menuMessages.getGeneralExceptionMessage(), order.getVarFld01(), smsKannelConnectorProperties.getSender(), smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus());

            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return prvParameterMap;

    }

    private Map<String, String> createMapFromSr(ServiceRequests sr) {
        Map<String, String> results = new HashMap<>();
        /*
         TODO: Test performance by returning SR as item in Map to reduce calls to DB
         */
        results.put(orderProcessingProperties.getSrIdKeyword(), String.valueOf(sr.getId()));
//        results.put(orderProcessingProperties.getSrIdKeyword(), String.valueOf(sr.getId()));
        if (sr.getPrvItemMapKey1() != null) results.put(sr.getPrvItemMapKey1(), sr.getPrvItemMapValue1());
        if (sr.getPrvItemMapKey2() != null) results.put(sr.getPrvItemMapKey2(), sr.getPrvItemMapValue2());
        if (sr.getPrvItemMapKey3() != null) results.put(sr.getPrvItemMapKey3(), sr.getPrvItemMapValue3());
        if (sr.getPrvItemMapKey4() != null) results.put(sr.getPrvItemMapKey4(), sr.getPrvItemMapValue4());
        if (sr.getPrvItemMapKey5() != null) results.put(sr.getPrvItemMapKey5(), sr.getPrvItemMapValue5());
        if (sr.getPrvItemMapKey6() != null) results.put(sr.getPrvItemMapKey6(), sr.getPrvItemMapValue6());
        if (sr.getPrvItemMapKey7() != null) results.put(sr.getPrvItemMapKey7(), sr.getPrvItemMapValue7());
        if (sr.getPrvItemMapKey8() != null) results.put(sr.getPrvItemMapKey8(), sr.getPrvItemMapValue8());
        if (sr.getPrvItemMapKey9() != null) results.put(sr.getPrvItemMapKey9(), sr.getPrvItemMapValue9());
        if (sr.getPrvItemMapKey10() != null) results.put(sr.getPrvItemMapKey10(), sr.getPrvItemMapValue10());
        return results;
    }
}
