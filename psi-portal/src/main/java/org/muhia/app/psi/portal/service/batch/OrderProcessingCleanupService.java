package org.muhia.app.psi.portal.service.batch;

import org.muhia.app.psi.config.order.properties.OrderProcessingProperties;
import org.muhia.app.psi.orm.model.OrderMaster;
import org.muhia.app.psi.portal.PortalApplication;
import org.muhia.app.psi.portal.eventbus.DashboardEvent;
import org.muhia.app.psi.portal.service.orm.IWorkOrderProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
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


  Generated on 05-Nov-16 10:24

 */

/*
  @author Kenneth Muhia <muhia@muhia.org> on 05-Nov-16. 
  for package org.muhia.app.psi.portal.service
*/
@Service
public class OrderProcessingCleanupService implements Runnable {
    @Autowired
    private IWorkOrderProcessingService orderProcessingService;
    @Autowired
    private OrderProcessingProperties orderProcessingProperties;
    


    private void findAndInitiatePendingOrders() {
        Optional<Collection<OrderMaster>> pendingOpenOrders = orderProcessingService.findOrderMasterByTransactionStatus(orderProcessingProperties.getOrderInitiatedStatus());
        pendingOpenOrders.ifPresent(poms -> {
            /*
                Perform service activation
                Post to eventbus
             */

            poms.forEach(pom -> {
                DashboardEvent.ServiceActivationEvent event = new DashboardEvent.ServiceActivationEvent(pom);
                PortalApplication.asyncEventbusService().post(event);

            });
        });
    }

    @Override
    public void run() {
        try {
            findAndInitiatePendingOrders();

        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }

    }
}
