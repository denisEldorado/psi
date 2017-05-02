package org.muhia.app.psi.portal.service.orm;

import org.muhia.app.psi.orm.model.*;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

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


  Generated on 24-Oct-16 11:13

 */

/*
  @author Kenneth Muhia <muhia@muhia.org> on 24-Oct-16.
  for package ${PACKAGE_NAME}
*/
public interface IWorkOrderProcessingService {
    OrderMaster createNewOrder(OrderMaster orderMaster);

    void createRecurringOrderRecordFromServiceRequest(ServiceRequests serviceRequests, String txnamount, Date txnDate, ProductsMaster product);

    String airtelMoneyTransaction(Long amount, String transactionCode, String orderNumber, String phonenumber);

    ProductPrvTemplates findProductPrvTemplatesByProductIdAndStatus(ProductsMaster productId, int status);

    ServiceRequests saveServiceRequest(ServiceRequests serviceRequests);

    PricingProfile findFirstPricingProfileByProductId(ProductsMaster productId);

    Optional<Collection<OrderMaster>> findOrderMasterBySubnoAndTransactionStatus(String subno, int transactionStatus);

    Optional<ServiceRequests> findServiceRequestsByOrder(OrderMaster order);

    OrderMaster findOrderMasterById(Long id);

    Optional<ServiceRequests> findServiceRequestById(Long id);

    Optional<ServiceRequests> findServiceRequestByIdAndStatus(Long id, int status);

    Optional<ServiceRequests> findServiceRequestsByOrderAndStatus(OrderMaster order, int status);

    Optional<Collection<OrderMaster>> findOrderMasterByTransactionStatus(int transactionStatus);

    Optional<ServiceRequests> findServiceRequestsById(Long id);

    Optional<Collection<ServiceRequests>> findServiceRequestByStatus(int status);

    OrderMaster saveOrderMaster(OrderMaster orderMaster);

    Optional<Collection<OrderMaster>> findOrderMasterBySubboAndTransactionStatus(String subno, Integer status);

    RecurringOrders createNewOrderRecurringOrder(RecurringOrders r);
    RecurringOrders updateOrderRecurringOrder(RecurringOrders r);
    Optional<Collection<RecurringOrders>> listPendingTransactionsToday(Date today, int status);
    void processRecurringPayments();
}
