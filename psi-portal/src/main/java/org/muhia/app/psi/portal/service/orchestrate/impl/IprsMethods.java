package org.muhia.app.psi.portal.service.orchestrate.impl;
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
*/

import org.muhia.app.psi.config.order.properties.OrderProcessingProperties;
import org.muhia.app.psi.orm.model.RegistrationDetails;
import org.muhia.app.psi.portal.service.orchestrate.IIprsMethods;
import org.muhia.app.psi.portal.service.orm.IRegistrationDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/*
  Created by Kenneth Muhia <muhia@muhia.org>
  Project: psi
  Package: org.muhia.app.psi.portal.service.orchestrate.impl
  Generated on: 22-Mar-17, 12:15.
 */
@Service
public class IprsMethods implements IIprsMethods {
    private final OrderProcessingProperties orderProcessingProperties;
    private final IRegistrationDetailsService registrationDetailsService;

    @Autowired
    public IprsMethods(OrderProcessingProperties orderProcessingProperties, IRegistrationDetailsService registrationDetailsService) {
        this.orderProcessingProperties = orderProcessingProperties;
        this.registrationDetailsService = registrationDetailsService;
    }

    @Override
    public RegistrationDetails validateKycInformation(RegistrationDetails details) {
        details.setUserRegistrationStatus(orderProcessingProperties.getOrderUserregistrationIprsOkStatus());
        details.setModifiedOn(new Date());
        details.setModifiedby(orderProcessingProperties.getKycValidationModuleName());
        details = registrationDetailsService.save(details);
        return details;
    }
}
