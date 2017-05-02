package org.muhia.app.psi.portal.service.orm.impl;

import org.muhia.app.psi.config.integ.properties.ObopayKeProperties;
import org.muhia.app.psi.config.order.properties.OrderProcessingProperties;
import org.muhia.app.psi.config.security.HashingImplementation;
import org.muhia.app.psi.orm.model.*;
import org.muhia.app.psi.orm.repo.*;
import org.muhia.app.psi.portal.service.orchestrate.IObopayMethods;
import org.muhia.app.psi.portal.service.orm.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

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


  Generated on 24-Oct-16 11:12

 */

/*
  @author Kenneth Muhia <muhia@muhia.org> on 24-Oct-16.
  for package ${PACKAGE_NAME}
*/
@Service
public class WorkOrderProcessingService implements IWorkOrderProcessingService, Runnable {
    private final OrderMasterRepository orderMasterRepository;
    private final RecurringOrdersRepository recurringOrdersRepository;
    private final ServiceRequestsRepository serviceRequestsRepository;

    private final ProductPrvTemplatesRepository prvTemplatesRepository;

    private final PricingProfileRepository pricingProfileRepository;
    private final IObaPayErrorCodesService errorCodesService;

    private final IPrincipalsService principalsService;
    private final HashingImplementation hasher;
    private final ObopayKeProperties keProperties;
    private final IObopayMethods obopayMethods;
    private final IPrincipalsLoansService loansService;
    private final IPrincipalsSavingsTargetsService savingsTargetService;
    private final OrderProcessingProperties orderProcessingProperties;


    @Autowired
    public WorkOrderProcessingService(OrderMasterRepository orderMasterRepository, ServiceRequestsRepository serviceRequestsRepository, RecurringOrdersRepository recurringOrdersRepository, ProductPrvTemplatesRepository prvTemplatesRepository, PricingProfileRepository pricingProfileRepository, IObaPayErrorCodesService errorCodesService, IPrincipalsService principalsService, HashingImplementation hasher, ObopayKeProperties keProperties, IObopayMethods obopayMethods, IPrincipalsLoansService loansService, IPrincipalsSavingsTargetsService savingsTargetService, OrderProcessingProperties orderProcessingProperties) {
        this.orderMasterRepository = orderMasterRepository;
        this.serviceRequestsRepository = serviceRequestsRepository;
        this.recurringOrdersRepository = recurringOrdersRepository;
        this.prvTemplatesRepository = prvTemplatesRepository;
        this.pricingProfileRepository = pricingProfileRepository;
        this.errorCodesService = errorCodesService;
        this.hasher = hasher;
        this.obopayMethods = obopayMethods;
        this.principalsService = principalsService;
        this.keProperties = keProperties;
        this.loansService = loansService;
        this.savingsTargetService = savingsTargetService;
        this.orderProcessingProperties = orderProcessingProperties;
    }

    @Override
    public void createRecurringOrderRecordFromServiceRequest(ServiceRequests serviceRequests, String txnamount, Date txnDate, ProductsMaster product) {
        /*
         * TODO: Where do I get the transaction amount,
         * TODO: what will be the indicator that there will be a recurring order,
         * TODO: what to use as the next interval e.g. daily, weekly, hourly etc
		 */
        try {

            RecurringOrders r = new RecurringOrders();

            r.setTransactionStatus(orderProcessingProperties.getOrderInitiatedStatus());
            //r.setCreatedOn(new Date());
            r.setOrderProduct(product);
            r.setFailedAttempts(Long.valueOf("0"));
            // r.setMaxAttempts(serviceRequests.getOrderNumber().getProductId().getProductPrvTemplatesCollection().stream().map(productPrvTemplates
            // -> {productPrvTemplates.}));
            r.setOrderProduct(serviceRequests.getOrderNumber().getProductId());
            r.setServiceRequest(serviceRequests);
            r.setSubscriberMsisdn(serviceRequests.getOrderNumber().getSubno());
            r.setTransactionFee(new Long(serviceRequests.getChargingValue()));
            r.setTransactionAmount(new Long(txnamount));
            r.setTransactionDate(txnDate);
            createNewOrderRecurringOrder(r);
        } catch (NumberFormatException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);

        }

    }

    @Override
    public String airtelMoneyTransaction(Long amount, String transactionCode, String orderNumber, String phonenumber) {


        return null;

    }

    @Override
    public OrderMaster createNewOrder(OrderMaster orderMaster) {
        return orderMasterRepository.save(orderMaster);
    }

    @Override
    public ProductPrvTemplates findProductPrvTemplatesByProductIdAndStatus(ProductsMaster productId, int status) {
        return prvTemplatesRepository.findProductPrvTemplatesByProductIdAndStatus(productId, status);
    }

    @Override
    public ServiceRequests saveServiceRequest(ServiceRequests serviceRequests) {
        return serviceRequestsRepository.save(serviceRequests);
    }

    @Override
    public PricingProfile findFirstPricingProfileByProductId(ProductsMaster productId) {
        return pricingProfileRepository.findFirstPricingProfileByProductId(productId).orElse(new PricingProfile());
    }

    @Override
    public Optional<Collection<OrderMaster>> findOrderMasterBySubnoAndTransactionStatus(String subno, int transactionStatus) {
        return orderMasterRepository.findOrderMasterBySubnoAndTransactionStatus(subno, transactionStatus, new Date());
    }

    @Override
    public Optional<ServiceRequests> findServiceRequestsByOrder(OrderMaster order) {
        return serviceRequestsRepository.findServiceRequestsByOrderNumber(order);
    }

    @Override
    public OrderMaster findOrderMasterById(Long id) {
        return orderMasterRepository.findOne(id);
    }

    @Override
    public Optional<ServiceRequests> findServiceRequestById(Long id) {
        return serviceRequestsRepository.findServiceRequestById(id);
    }

    @Override
    public Optional<ServiceRequests> findServiceRequestByIdAndStatus(Long id, int status) {
        return serviceRequestsRepository.findServiceRequestByIdAndStatus(id, status);
    }

    @Override
    public Optional<ServiceRequests> findServiceRequestsByOrderAndStatus(OrderMaster order, int status) {
        return serviceRequestsRepository.findServiceRequestsByOrderNumberAndStatus(order, status);
    }

    @Override
    public Optional<Collection<OrderMaster>> findOrderMasterByTransactionStatus(int transactionStatus) {
        return orderMasterRepository.findOrderMasterByTransactionStatus(transactionStatus);
    }

    @Override
    public Optional<ServiceRequests> findServiceRequestsById(Long id) {
        return Optional.ofNullable(serviceRequestsRepository.findOne(id));
    }

    @Override
    public Optional<Collection<ServiceRequests>> findServiceRequestByStatus(int status) {
        return serviceRequestsRepository.findServiceRequestsByStatus(status);
    }

    @Override
    public OrderMaster saveOrderMaster(OrderMaster orderMaster) {
        return orderMasterRepository.save(orderMaster);
    }

    @Override
    public Optional<Collection<OrderMaster>> findOrderMasterBySubboAndTransactionStatus(String subno, Integer status) {
        return orderMasterRepository.findOrderMasterBySubnoAndTransactionStatus(subno, status, new Date());
    }

    @Override
    public RecurringOrders createNewOrderRecurringOrder(RecurringOrders r) {
        return recurringOrdersRepository.save(r);
    }

    @Override
    public Optional<Collection<RecurringOrders>> listPendingTransactionsToday(Date today, int status) {
        return recurringOrdersRepository.listPendingTransactionsToday(today, status);
    }

    @Override
    public void processRecurringPayments() {
        // Status of zero for pending transactions
        Optional<Collection<RecurringOrders>> ordersToday = listPendingTransactionsToday(new Date(), 0);
        ordersToday.ifPresent(orders -> orders.forEach((order) -> {
            //Use product ids to differentiate between savings and loan
            //product id 4 loans p2B
            //product id 7 savings
            //product id 9 loans p2p
            String status = airtelMoneyTransaction(order.getTransactionAmount() - order.getTransactionFee(),
                    keProperties.getCashOutTransactionCode(),
                    principalsService.generateMembershipNo(), order.getSubscriberMsisdn());
            if (status.equals("0")) {
                //order successful
                order.setTransactionStatus(1);
                updateOrderRecurringOrder(order);

                //transaction successful
                //persist based on product
                switch (order.getOrderProduct().getId().toString()) {
                    case "4": {
                        PrincipalsLoans loan = loansService.findBySr(order.getServiceRequest());
                        //transaction successful
                        loan.setStatus(orderProcessingProperties.getPaidStatus());
                        loansService.updatePrincipalsLoan(loan);
                        // TODO:  send sms out transaction
                        break;
                    }
                    // TODO send sms out transaction
                    case "7":
                        //Savings product so get interval and create a new order for another day
                        PrincipalsSavingsTarget target = savingsTargetService.findBySr(order.getServiceRequest());
                        Date txnDate = new Date();
                        if (target.getStatus() == orderProcessingProperties.getSavingsDeactivatedStatus()) {
                            //savings target is deactivated
                            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "savings target is deactivated");
                        } else {

                            //calculate next transaction date
                            switch (target.getInterval().getInterval()) {
                                case "Daily":
                                    txnDate = loansService.addPayBackDays(new Date(), 1);
                                    break;
                                case "Weekly":
                                    txnDate = loansService.addPayBackDays(new Date(), 7);
                                    break;
                                case "Monthly":
                                    txnDate = loansService.addPayBackDays(new Date(), 30);
                                    break;
                                default:
                                    break;
                            }
                        }

                        createRecurringOrderRecordFromServiceRequest(order.getServiceRequest(), order.getTransactionAmount().toString(), txnDate, order.getOrderProduct());
                        break;
                    case "9": {
                        PrincipalsLoans loan = loansService.findBySr(order.getServiceRequest());
                        if (status.equals("0")) {
                            String transfer = airtelMoneyTransaction(order.getTransactionAmount() - order.getTransactionFee(),
                                    keProperties.getCashInTransactionCode(),
                                    principalsService.generateMembershipNo(), loan.getLender().getCellphonenumber());
                            if (transfer.equals("0")) {
                                //transaction successful
                                loan.setStatus(orderProcessingProperties.getPaidStatus());
                                loansService.updatePrincipalsLoan(loan);
                                // To do send sms ot transaction
                            }

                        }
                        break;
                    }
                    default:
                        break;
                }
            } else {
                /*
                    TODO:re attempt after some time in case cash is not enough
                 */
            }
        }));

    }

    @Override
    public RecurringOrders updateOrderRecurringOrder(RecurringOrders r) {
        return recurringOrdersRepository.save(r);
    }


    @Override
    public void run() {
        processRecurringPayments();
    }
}
