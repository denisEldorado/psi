package org.muhia.app.psi.portal.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.muhia.app.psi.integ.wsdl.mpesa.cbp.request.ObjectFactory;
import org.muhia.app.psi.integ.wsdl.mpesa.cbp.request.Response;
import org.muhia.app.psi.integ.wsdl.mpesa.cbp.request.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
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
  Generated on: 17-Feb-17, 06:28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MpesaControllerTests {
    @Autowired
    private
    MpesaController mockMpesaController;

    @Test
    public void mpesaResultsCallBackProcessorTest() {
        String testXml = "</s:Envelope>";
        ObjectFactory objectFactory = new ObjectFactory();
        Result mockrequest = objectFactory.createResult();
        mockrequest.setConversationID("1233");
        QName qName = new QName("http://api-v1.gen.mm.vodafone.com/mminterface/request");
        mockrequest.setOriginatorConversationID(new JAXBElement<>(qName, String.class, "12345"));
        mockrequest.setResultCode("0");
        mockrequest.setResultType(new JAXBElement<>(qName, BigInteger.class, new BigInteger("1")));


        MockHttpServletRequest request = new MockHttpServletRequest("POST", testXml);
        ResponseEntity<Response> response = mockMpesaController.mpesaResultsCallBackProcessor(mockrequest);

        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Response " + response.getBody());


    }
}
