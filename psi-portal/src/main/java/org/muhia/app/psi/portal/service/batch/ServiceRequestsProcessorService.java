package org.muhia.app.psi.portal.service.batch;

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
 
 
  Generated on 06-Nov-16 15:09 
 
 */

import org.muhia.app.psi.config.order.properties.OrderProcessingProperties;
import org.muhia.app.psi.orm.model.ServiceRequests;
import org.muhia.app.psi.portal.PortalApplication;
import org.muhia.app.psi.portal.eventbus.DashboardEvent;
import org.muhia.app.psi.portal.service.orm.IWorkOrderProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/*
  @author Kenneth Muhia <muhia@muhia.org> on 06-Nov-16. 
  for package org.muhia.app.psi.portal.service.cleanup
*/
@Service
public class ServiceRequestsProcessorService implements Runnable {

    private final OrderProcessingProperties orderProcessingProperties;
    private final IWorkOrderProcessingService orderProcessingService;

    @Autowired
    public ServiceRequestsProcessorService(OrderProcessingProperties orderProcessingProperties, IWorkOrderProcessingService orderProcessingService) {
        this.orderProcessingProperties = orderProcessingProperties;
        this.orderProcessingService = orderProcessingService;
    }


    private void findAndProvisionPendingServiceRequests() {
        Optional<Collection<ServiceRequests>> pendingServiceRequestses = orderProcessingService.findServiceRequestByStatus(orderProcessingProperties.getSrInitiatedStatus());
        pendingServiceRequestses.ifPresent(psrs -> psrs.forEach(psr ->
                PortalApplication.asyncEventbusService().post(new DashboardEvent.ProcessPendingServiceRequestsEvent(psr))
        ));
    }


    @Override
    public void run() {
        findAndProvisionPendingServiceRequests();
    }
}
