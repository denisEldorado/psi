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

import org.muhia.app.psi.integ.wsdl.am.merchant.payments.TrxPayment;
import org.muhia.app.psi.integ.wsdl.am.merchant.payments.TrxPaymentResponse;
import org.muhia.app.psi.portal.service.orchestrate.IObopayMethods;
import org.springframework.stereotype.Service;

/*
  Created by Kenneth Muhia <muhia@muhia.org>
  Project: psi
  Package: org.muhia.app.psi.portal.service.orchestrate.impl
  Generated on: 22-Mar-17, 02:50.
 */
@Service
public class ObopayMethods implements IObopayMethods {


    @Override
    public Object sendAndReceiveCashInRequest(TrxPayment request) {
        return null;
    }

    @Override
    public Object sendAndReceiveObopayWebServiceData(TrxPaymentResponse request) {
        return null;
    }
}
