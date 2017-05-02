package org.muhia.app.psi.portal.service.orchestrate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.muhia.app.psi.config.integ.properties.MpesaProperties;
import org.muhia.app.psi.integ.wsdl.mpesa.cbp.request.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
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
  
*/
/*
  Created by Kenneth Muhia <muhia@muhia.org>
  Project: psi
  Package: org.muhia.app.psi.portal
  Generated on: 12-Feb-17, 20:42.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MpesaMethodsTest {
    @Autowired
    private IMpesaMethods mpesaMethods;
    @Autowired
    private MpesaProperties properties;

    @Test
    public void queryMpesaTransactionTest() {
        Map<String, String> requestTransactionParameters = new HashMap<>();
        requestTransactionParameters.putIfAbsent("ReceiptNumber", "0000000001199549");

        Map<String, String> transactionReferenceData = new HashMap<>();
        transactionReferenceData.putIfAbsent("Occasion", "Christmas");
        Response queryMpesaTransactionResponse = mpesaMethods.queryMpesaTransaction(requestTransactionParameters, transactionReferenceData,"254710473949");
//
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("Response [code=%s, description=%s]", queryMpesaTransactionResponse.getResponseCode(), queryMpesaTransactionResponse.getResponseDesc()));
    }

    @Test
    public void processPromotionPaymentTest() {
        Map<String, String> requestTransactionParameters = new HashMap<>();
        requestTransactionParameters.putIfAbsent("Amount", "1");
        requestTransactionParameters.putIfAbsent("Key1", "Value1");

        Map<String, String> transactionReferenceData = new HashMap<>();
        transactionReferenceData.putIfAbsent("Occasion", "Jamuhuri");
        transactionReferenceData.putIfAbsent("QueueTimeoutURL", properties.getMpesaQueryTimeoutUrl());
        Response queryMpesaTransactionResponse = mpesaMethods.processPromotionPayment(requestTransactionParameters, transactionReferenceData);
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("Response [code=%s, description=%s]", queryMpesaTransactionResponse.getResponseCode(), queryMpesaTransactionResponse.getResponseDesc()));
    }
}
