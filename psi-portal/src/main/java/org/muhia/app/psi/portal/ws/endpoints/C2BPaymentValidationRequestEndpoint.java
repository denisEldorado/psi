package org.muhia.app.psi.portal.ws.endpoints;

import org.muhia.app.psi.integ.wsdl.mpesa.paymentvalidationandconfirmation.C2BPaymentConfirmationRequest;
import org.muhia.app.psi.integ.wsdl.mpesa.paymentvalidationandconfirmation.C2BPaymentValidationRequest;
import org.muhia.app.psi.integ.wsdl.mpesa.paymentvalidationandconfirmation.C2BPaymentValidationResult;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.bind.JAXBElement;

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
  

  Created by Kenneth Muhia <muhia@muhia.org>
  Project: psi
  Package: org.muhia.app.psi.portal.ws.endpoints
  Generated on: 07-Mar-17, 00:16.
 */
@Endpoint
public class C2BPaymentValidationRequestEndpoint {
    public static final String C2BNAMESPACE_URI = "http://cps.huawei.com/cpsinterface/c2bpayment";

    @PayloadRoot(namespace = C2BNAMESPACE_URI, localPart = "C2BPaymentValidationRequest")
    @ResponsePayload
    public C2BPaymentValidationResult getC2BPaymentValidationResult(@RequestPayload C2BPaymentValidationRequest request) {
        org.muhia.app.psi.integ.wsdl.mpesa.paymentvalidationandconfirmation.ObjectFactory o = new org.muhia.app.psi.integ.wsdl.mpesa.paymentvalidationandconfirmation.ObjectFactory();
        C2BPaymentValidationResult result = o.createC2BPaymentValidationResult();
        result.setResultCode("0");
        result.setResultDesc("Service processing successful");
        result.setThirdPartyTransID(request.getTransID());
        return result;
    }


    @PayloadRoot(namespace = C2BNAMESPACE_URI, localPart = "C2BPaymentConfirmationRequest")
    @ResponsePayload
    public JAXBElement<String> getC2BPaymentConfirmationResult(@RequestPayload C2BPaymentConfirmationRequest request) {
        org.muhia.app.psi.integ.wsdl.mpesa.paymentvalidationandconfirmation.ObjectFactory o = new org.muhia.app.psi.integ.wsdl.mpesa.paymentvalidationandconfirmation.ObjectFactory();
        String confirmation = "C2B Payment Transaction " + request.getTransID() + " result received.";

//        request.setThirdPartyTransID(request.getTransID());
        return o.createC2BPaymentConfirmationResult(confirmation);
    }

}
