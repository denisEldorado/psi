package org.muhia.app.psi.integ.config.ke.mpesa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.muhia.app.psi.config.integ.properties.MpesaProperties;
import org.muhia.app.psi.integ.wsdl.mpesa.cbp.request.ObjectFactory;
import org.muhia.app.psi.integ.wsdl.mpesa.cbp.request.ParameterType2;
import org.muhia.app.psi.integ.wsdl.mpesa.cbp.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    Package: org.muhia.app.psi.integ.config.mpesa
    Generated on: 05-Feb-17.
*/
@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = {MpesaClientConfig.class,WebServiceTemplate.class, MpesaProperties.class,OrganizationProperties.class})
@SpringBootTest
public class MpesaClientMethodsTest {


    @Autowired
    @Qualifier(value = "mpesaWebServiceTemplate")
    private WebServiceTemplate mpesaWebServiceTemplate;

    @Autowired
    private MpesaProperties properties;

    @Autowired
    private MpesaSoapRequestHeaderModifier mpesaSoapRequestHeaderModifier;


//    private Object generateHeader(OrganizationProperties organizationProperties, MpesaProperties properties, ObjectFactory objectFactory){
//        RequestSOAPHeader header = new RequestSOAPHeader();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(organizationProperties.getSimpleDateFormat());
//        header.setServiceId(properties.getServiceId());
//        header.setSpId(properties.getSpId());
//        header.setSpPassword(properties.getSpPassword());
//        header.setTimeStamp(simpleDateFormat.format(new Date()));
//
//        return objectFactory.createRequestSOAPHeader(header);
//
//
//
//    }

    @Test
    public void genericAPIRequestTestViaJaxb() {
        ObjectFactory objectFactory = new ObjectFactory();
        try {
            Request requestWithQueueTimeoutUrlAndResultUrl = objectFactory.createRequest();
            Request.Transaction transaction = objectFactory.createRequestTransaction();
            transaction.setCommandID("PromotionPayment");
            transaction.setLanguageCode("");
            transaction.setOriginatorConversationID("4596");
            transaction.setConversationID("");
            transaction.setRemark("");
            Request.Transaction.Parameters parameters = objectFactory.createRequestTransactionParameters();

            Request.Transaction.Parameters.Parameter parameter = objectFactory.createRequestTransactionParametersParameter();
            Request.Transaction.Parameters.Parameter parameter1 = objectFactory.createRequestTransactionParametersParameter();

            parameter.setKey("Amount");
            parameter.setValue("1");

            parameter1.setKey("Key1");
            parameter1.setValue("Value1");
            parameters.getParameter().add(parameter);
            parameters.getParameter().add(parameter1);
            Request.Transaction.ReferenceData referenceData = objectFactory.createRequestTransactionReferenceData();
            ParameterType2 referenceItem = objectFactory.createParameterType2();
            referenceItem.setKey("QueueTimeoutURL");
            referenceItem.setValue("http://10.66.49.789:7888/new");
            referenceData.getReferenceItem().add(referenceItem);
            referenceItem = objectFactory.createParameterType2();
            referenceItem.setValue("MayDay");
            referenceItem.setKey("Ocassion");
            referenceData.getReferenceItem().add(referenceItem);

            transaction.setParameters(parameters);
            transaction.setReferenceData(referenceData);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(properties.getMpesaSdfHeaderTimestamp());
            transaction.setTimestamp(simpleDateFormat.format(new Date()));

            requestWithQueueTimeoutUrlAndResultUrl.setTransaction(transaction);
            Request.Identity identity = objectFactory.createRequestIdentity();
            Request.Identity.Caller caller = objectFactory.createRequestIdentityCaller();
            caller.setCallerType(new BigInteger("2"));
            caller.setCheckSum("Checksum0");
            caller.setPassword("Password0");
            caller.setThirdPartyID("");
            caller.setResultURL("ResultURL0");
            identity.setCaller(caller);
            Request.Identity.Initiator initiator = objectFactory.createRequestIdentityInitiator();
            initiator.setIdentifierType(new BigInteger("11"));
            initiator.setIdentifier("username");
            initiator.setSecurityCredential("SecurityCredential0");
            initiator.setShortCode("859636");
            identity.setInitiator(initiator);
            Request.Identity.PrimaryParty primaryParty = objectFactory.createRequestIdentityPrimartyParty();
            primaryParty.setIdentifierType(new BigInteger("4"));
            primaryParty.setIdentifier("859636");
            primaryParty.setShortCode("859636");
            identity.setPrimaryParty(primaryParty);
            Request.Identity.ReceiverParty receiverParty = objectFactory.createRequestIdentityReceiverParty();
            receiverParty.setIdentifierType(new BigInteger("1"));
            receiverParty.setIdentifier("2547204789659");
            receiverParty.setShortCode("859636");
            identity.setReceiverParty(receiverParty);
            Request.Identity.AccessDevice accessDevice = objectFactory.createRequestIdentityAccessDevice();
            accessDevice.setIdentifierType(new BigInteger("1"));
            accessDevice.setIdentifier("dummyDevice");
            identity.setAccessDevice(accessDevice);
            requestWithQueueTimeoutUrlAndResultUrl.setIdentity(identity);
            requestWithQueueTimeoutUrlAndResultUrl.setKeyOwner(new BigInteger("1"));

//            ObjectFactory objectFactoryCbpRequest = new ObjectFactory();
//            objectFactoryCbpRequest.createRequestMsg(requestWithQueueTimeoutUrlAndResultUrl);

//            mpesaWebServiceTemplate.getUnmarshaller().unmarshal(requestWithQueueTimeoutUrlAndResultUrl);


//            Response response = (Response) JAXBIntrospector.getValue(mpesaWebServiceTemplate.marshalSendAndReceive(properties.getBrokerEndPoint(),objectFactory.createRequestMsg(requestWithQueueTimeoutUrlAndResultUrl),mpesaSoapRequestHeaderModifier));

//            JAXBIntrospector.getValue(mpesaWebServiceTemplate.marshalSendAndReceive(properties.getBrokerEndPoint(), new JAXBElement<String>(new QName("http://api-v1.gen.mm.vodafone.com/mminterface/request", "RequestMsg"), String.class, new JAXBElement<Request>(new QName("http://api-v1.gen.mm.vodafone.com/mminterface/request", "request"), Request.class, requestWithQueueTimeoutUrlAndResultUrl)), mpesaSoapRequestHeaderModifier));

//            Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("[Response Code=%s, code= %s]", response.getResponseCode(), response.getResponseDesc()));



        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }

    }


//    @Test
//    public void genericAPIRequestTest() {
//
//
//        try {
//            URL url = new URL(properties.getBrokerEndPoint());
//            QName qName = new QName("http://api-v1.gen.mm.vodafone.com/mminterface/request", "RequestMgrPortType");
//
//
//            Service service = Service.create(url, qName);
//
//
////            RequestMgrPortType requestMgrPortType = service.getPort(RequestMgrPortType.class);
//
////            Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("Sample %s", requestMgrPortType.genericAPIRequest("test", generateHeader(organizationProperties, properties))));
//
//
//        } catch (MalformedURLException e) {
//            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
//        }
//
//
//    }

}