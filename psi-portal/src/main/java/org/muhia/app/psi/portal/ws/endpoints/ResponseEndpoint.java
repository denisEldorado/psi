package org.muhia.app.psi.portal.ws.endpoints;

import org.muhia.app.psi.integ.wsdl.mpesa.cbp.request.ObjectFactory;
import org.muhia.app.psi.integ.wsdl.mpesa.cbp.request.Request;
import org.muhia.app.psi.integ.wsdl.mpesa.cbp.request.Response;
import org.muhia.app.psi.integ.wsdl.mpesa.paymentvalidationandconfirmation.C2BPaymentValidationRequest;
import org.muhia.app.psi.integ.wsdl.mpesa.paymentvalidationandconfirmation.C2BPaymentValidationResult;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.bind.JAXBElement;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

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
  Package: org.muhia.app.psi.portal
  Generated on: 06-Mar-17, 12:32.
 */
@Endpoint
public class ResponseEndpoint {
    public static final String NAMESPACE_URI = "http://api-v1.gen.mm.vodafone.com/mminterface/request";


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "Response")
    @ResponsePayload
    public Response getResponse(@RequestPayload Response response) {
        ObjectFactory o = new ObjectFactory();
        Response response_ = o.createResponse();
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("[body= %s]", response.toString()));
        response_.setConversationID("c8437663-4aaa-44dc-a84f-09fcc872562e-20170304190142257");
        response_.setOriginatorConversationID("c8437663-4aaa-44dc-a84f-09fcc872562e-20170304190142257");
        response_.setResponseCode("100000014");
        response_.setResponseDesc("Missing mandatory parameter:CommandId,CommandId indicates the parameter's name.");
        response_.setServiceStatus(new BigInteger("0"));

        return response_;


    }


}
