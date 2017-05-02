package org.muhia.app.psi.portal.service.orchestrate;

import org.muhia.app.psi.integ.wsdl.mpesa.cbp.request.Response;

import java.util.Map;

/*
  Copyright 2015-2017 the original author or authors.
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

*/
/*
  Created by ngatia
  Project: psi
  Package: ${PACKAGE_NAME}
  Generated on: 2/9/17, 18:54.
 */
public interface IMpesaMethods {

    Response registerUrl();

    Response queryMpesaTransaction(Map<String, String> queryParams, Map<String, String> transactionReferenceData, String receiverMsisdn);

    Response processPromotionPayment(Map<String, String> queryParams, Map<String, String> transactionReferenceData);

    Response processMpesaTransaction(Map<String, String> transactionParameters, Map<String, String> transactionReferenceData, String commandId);


    Object sendValidationResponse(String code, String desc, String transId);
}