package org.muhia.app.psi.integ.config.ke.obopay;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.muhia.app.psi.config.integ.properties.ObopayBulkApiProperties;
import org.muhia.app.psi.integ.wsdl.am.bulkpayment.*;
import org.muhia.app.psi.integ.wsdl.am.bulkpayment.ObjectFactory;
import org.muhia.app.psi.integ.wsdl.am.directdebit.*;
import org.muhia.app.psi.integ.wsdl.crba.transunion.GetProduct102;
import org.muhia.app.psi.integ.wsdl.crba.transunion.GetProduct102Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ws.client.core.WebServiceTemplate;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.namespace.QName;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;
/**
 * Copyright 2015-2016 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p>
 * <p>
 * Generated on 30-Oct-16 01:30
 */

/**
 * Created by KennethKZMMuhia
 * Project: psi
 * Package: org.muhia.app.psi.integ.config.ke.obopay
 * Generated on: 14-Apr-17, 11:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ObopayBulkApiClientConfigurationTest {
    @Autowired
    @Qualifier(value = "obopayBulkApiWebServiceTemplate")
    private WebServiceTemplate obopayBulkApiWebServiceTemplate;
    @Autowired
    private ObopayBulkApiProperties properties;

    @Test
    public void testDirectDebit(){
        org.muhia.app.psi.integ.wsdl.am.directdebit.ObjectFactory o = new org.muhia.app.psi.integ.wsdl.am.directdebit.ObjectFactory();
        DirectDebitAPI directDebitAPI = o.createDirectDebitAPI();
        directDebitAPI.setUserName(properties.getEndpointBulkpaymentProductionUsername());
        directDebitAPI.setPassword(properties.getEndpointBulkpaymentProductionPassword());
        directDebitAPI.setAmount(new BigDecimal(1));
        directDebitAPI.setCustomerMobileNumber("0733814627");
        directDebitAPI.setMerchantWalletMsisdn("0737777779");

        DirectDebitAPIResponse directDebitAPIResponse = (DirectDebitAPIResponse) JAXBIntrospector.getValue(obopayBulkApiWebServiceTemplate.marshalSendAndReceive(properties.getEndpointBulkpaymentTestUrl(),directDebitAPI));
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, directDebitAPIResponse.getDirectDebitAPIResult());




    }
    @Test
    public void testBulkPaymentRequest() {
        ObjectFactory o = new ObjectFactory();
        CheckBalance checkBalance = o.createCheckBalance();
        checkBalance.setNickname(properties.getEndpointBulkpaymentProductionNickname());
        checkBalance.setPassword(properties.getEndpointBulkpaymentProductionPassword());
        checkBalance.setUsername(properties.getEndpointBulkpaymentProductionUsername());

        SimpleDateFormat dateFormat = new SimpleDateFormat(properties.getSdfUniqueTimestamp());
        String batchRef = String.format("%s-%s", dateFormat.format(new Date()), UUID.randomUUID().toString());


        CheckBalanceResponse balanceResponse = (CheckBalanceResponse) JAXBIntrospector.getValue(obopayBulkApiWebServiceTemplate.marshalSendAndReceive(properties.getEndpointBulkpaymentTestUrl(), new JAXBElement<>(new QName("http://www.obopay.com/xml/bulkpayment/v1", "CheckBalance"), CheckBalance.class, checkBalance)));

        if (balanceResponse.getCheckBalanceResult().getCheckBalanceResult().contains("1")) {

            /**
             * Perform the bulkPayment
             */
            try {
                TrxPayment payment = o.createTrxPayment();
                payment.setAmount(new BigDecimal(1));
                payment.setBatchref(batchRef);
                payment.setCustomermsisdn("0733814267");
                payment.setNarrative("Api Testing");
                payment.setNickname(properties.getEndpointBulkpaymentProductionNickname());
                payment.setPassword(properties.getEndpointBulkpaymentProductionPassword());
                payment.setUsername(properties.getEndpointBulkpaymentProductionUsername());
                payment.setReferenceid(batchRef.split("-")[1]);

                TrxPaymentResponse paymentResponse = (TrxPaymentResponse) JAXBIntrospector.getValue(obopayBulkApiWebServiceTemplate.marshalSendAndReceive(properties.getEndpointBulkpaymentTestUrl(), new JAXBElement<>(new QName("http://www.obopay.com/xml/bulkpayment/v1", "TrxPayment"), TrxPayment.class, payment)));
                if (paymentResponse.getTrxPaymentResult().contains("OK")) {
                    Logger.getLogger(this.getClass().getName()).log(Level.INFO, paymentResponse.getTrxPaymentResult());

                } else {
                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, paymentResponse.getTrxPaymentResult());
                }

            } catch (Exception e) {
                /**
                 * Perform PaymentReversal
                 * TODO: Decide if this is to be done on the UI
                 */
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, e.getMessage(), e);
                TrxRevert trxRevert = o.createTrxRevert();
                trxRevert.setNarration("API testing reversal");
                trxRevert.setNickname(properties.getEndpointBulkpaymentProductionNickname());
                trxRevert.setPassword(properties.getEndpointBulkpaymentProductionPassword());
                trxRevert.setReferenceid(batchRef);
                trxRevert.setUsername(properties.getEndpointBulkpaymentProductionUsername());

                TrxRevertResponse trxRevertResponse = (TrxRevertResponse) JAXBIntrospector.getValue(obopayBulkApiWebServiceTemplate.marshalSendAndReceive(properties.getEndpointBulkpaymentTestUrl(), new JAXBElement<>(new QName("http://www.obopay.com/xml/bulkpayment/v1", "TrxRevert"), TrxRevert.class, trxRevert)));
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, trxRevertResponse.getTrxRevertResult().toString());

            }
        }

    }

}