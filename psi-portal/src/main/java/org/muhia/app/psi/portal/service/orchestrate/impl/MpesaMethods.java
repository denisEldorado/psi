package org.muhia.app.psi.portal.service.orchestrate.impl;


import org.muhia.app.psi.config.integ.properties.MpesaProperties;
import org.muhia.app.psi.integ.adapters.CdataAdapter;
import org.muhia.app.psi.integ.config.ke.mpesa.MpesaSoapRequestHeaderModifier;
import org.muhia.app.psi.integ.wsdl.mpesa.cbp.request.ObjectFactory;
import org.muhia.app.psi.integ.wsdl.mpesa.cbp.request.ParameterType2;
import org.muhia.app.psi.integ.wsdl.mpesa.cbp.request.Request;
import org.muhia.app.psi.integ.wsdl.mpesa.cbp.request.Response;
import org.muhia.app.psi.integ.wsdl.mpesa.paymentvalidationandconfirmation.C2BPaymentValidationResult;
import org.muhia.app.psi.portal.service.orchestrate.IMpesaMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.WebServiceIOException;
import org.springframework.ws.client.core.WebServiceTemplate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamResult;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
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
  Created by ngatia
  Project: psi
  Package: ${PACKAGE_NAME}
  Generated on: 2/9/17, 18:55.
 */
@Service
public class MpesaMethods implements IMpesaMethods {

    private final MpesaProperties mpesaProperties;
    private final CdataAdapter adapter;

    private final WebServiceTemplate mpesaWebServiceTemplate;

    private final MpesaSoapRequestHeaderModifier mpesaSoapRequestHeaderModifier;

    @Autowired
    public MpesaMethods(MpesaProperties mpesaProperties, CdataAdapter adapter, @Qualifier(value = "mpesaWebServiceTemplate") WebServiceTemplate mpesaWebServiceTemplate, MpesaSoapRequestHeaderModifier mpesaSoapRequestHeaderModifier) {
        this.mpesaProperties = mpesaProperties;
        this.adapter = adapter;
        this.mpesaWebServiceTemplate = mpesaWebServiceTemplate;
        this.mpesaSoapRequestHeaderModifier = mpesaSoapRequestHeaderModifier;
    }

    private String marshallRequest(Request request) {
        String result = "";
        try {

            StringWriter sw = new StringWriter();
            StreamResult streamResult = new StreamResult(sw);

            mpesaWebServiceTemplate.getMarshaller().marshal(request, streamResult);

            result = adapter.unmarshal(streamResult.getWriter().toString());


        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, String.format("Marshalling failed [ message = %s ]", e.getMessage()));
        }
        return result;
    }

    private Response unmarshallResponse(String xml) {
        Response response = null;
        try {
            JAXBContext umContext = JAXBContext.newInstance(mpesaProperties.getUnMarshallerPackagesToScan());

            StringReader sr = new StringReader(adapter.marshal(xml));
            Unmarshaller um = umContext.createUnmarshaller();
            response = ((JAXBElement<Response>) um.unmarshal(sr)).getValue();

        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, String.format("UnMarshalling failed [ message = %s ]", e.getMessage()));
        }

        return response;
    }

    /*
        TODO: This is only useful as a test class, we need to implement the other methods such as the ones used to transfer funds and/or make deductions
        TODO: I have implemented a method below which you can use as a guide
     */
    @Override
    public Response registerUrl() {
        ObjectFactory objectFactory = new ObjectFactory();
        Response response = null;
        try {
            Request request = objectFactory.createRequest();
            Request.Transaction transaction = objectFactory.createRequestTransaction();
            transaction.setCommandID(mpesaProperties.getRegisterUrlCommandId());
            /*
                TODO: As this should vary with every transaction, we should use a random string and AAUID to generate
             */
            SimpleDateFormat dateFormat = new SimpleDateFormat(mpesaProperties.getMpesaSdfUniqueTimestamp());
            String originatorConversationID = String.format("%s-%s", dateFormat.format(new Date()), UUID.randomUUID().toString());
            transaction.setOriginatorConversationID(originatorConversationID);

            Request.Transaction.Parameters parameters = objectFactory.createRequestTransactionParameters();

            Request.Transaction.Parameters.Parameter parameter = objectFactory.createRequestTransactionParametersParameter();
            parameter.setKey(mpesaProperties.getRegisterUrlResponseType());
            parameter.setValue(mpesaProperties.getRegisterUrlResponseTypeValue());

            parameters.getParameter().add(parameter);
            transaction.setParameters(parameters);

            Request.Transaction.ReferenceData referenceData = objectFactory.createRequestTransactionReferenceData();

            ParameterType2 referenceItem = objectFactory.createParameterType2();
            referenceItem.setKey(mpesaProperties.getRegisterValidationURLKey());
//            referenceItem.setValue(URLEncoder.encode(mpesaProperties.getRegisterValidationURLValue(), "UTF-8"));
            referenceItem.setValue(mpesaProperties.getRegisterValidationURLValue());
            referenceData.getReferenceItem().add(referenceItem);
            referenceItem = objectFactory.createParameterType2();
            referenceItem.setKey(mpesaProperties.getRegisterConfirmationURLKey());
//            referenceItem.setValue(URLEncoder.encode(mpesaProperties.getRegisterConfirmationURLValue(), "UTF-8"));
            referenceItem.setValue(mpesaProperties.getRegisterConfirmationURLValue());
            referenceData.getReferenceItem().add(referenceItem);

            transaction.setReferenceData(referenceData);

            Request.Identity identity = objectFactory.createRequestIdentity();
            Request.Identity.Caller caller = objectFactory.createRequestIdentityCaller();
            caller.setCallerType(mpesaProperties.getRegisterUrlCallerType());
            caller.setThirdPartyID("");
            caller.setPassword("");
            caller.setCheckSum("");
            /*
                TODO: I have defined some bare controllers, we can just have them log the request received and use them here
             */
            caller.setResultURL("");
            identity.setCaller(caller);

            Request.Identity.Initiator initiator = objectFactory.createRequestIdentityInitiator();
            initiator.setIdentifierType(mpesaProperties.getRegisterUrlIdentityIdentifierType());
            initiator.setIdentifier("");
            initiator.setSecurityCredential("");
            initiator.setShortCode(null);
            identity.setInitiator(initiator);

            Request.Identity.PrimaryParty primaryParty = objectFactory.createRequestIdentityPrimartyParty();
            primaryParty.setIdentifierType(mpesaProperties.getPrimaryIdentifierType());
            /*
                TODO: Could this be our Paybill number? Not clear what shortcode means
             */
            primaryParty.setIdentifier("");
            primaryParty.setShortCode(mpesaProperties.getShortCode());
            identity.setPrimaryParty(primaryParty);

            request.setIdentity(identity);
            request.setTransaction(transaction);
            request.setKeyOwner(mpesaProperties.getRegisterUrlKeyOwner());


            String requestStr = marshallRequest(request);
//            String requestStr = sw.toString();

            /*
                TODO: QName->NamespaceURI and QName->localPort can also be externalised
             */
            JAXBElement<String> resp = objectFactory.createResponseMsg((String) JAXBIntrospector.getValue(mpesaWebServiceTemplate.marshalSendAndReceive(mpesaProperties.getRegisterUrlRlEndpoint(), objectFactory.createRequestMsg(requestStr), mpesaSoapRequestHeaderModifier)));
//            JAXBElement<String> resp = objectFactory.createResponseMsg((String) JAXBIntrospector.getValue(mpesaWebServiceTemplate.marshalSendAndReceive(mpesaProperties.getRegisterUrlEndPoint(), objectFactory.createRequestMsg(requestStr), mpesaSoapRequestHeaderModifier)));
            Logger.getLogger(this.getClass().getName()).log(Level.FINE, String.format("[Response Code=%s, code= %s]", resp.getValue(), resp.toString()));

            response = unmarshallResponse(resp.getValue());
            /*
                TODO: Request response will be picked up from the database, so status can be used for retry.
                TODO: Performance testing to be done for the JAXB (UN)Marshall process
             */
        } catch (WebServiceIOException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, String.format("Request failed, [Message= %s, URL= %s]", e.getMessage(), mpesaProperties.getRegisterUrlEndPoint()));
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return response;
    }


    @Override
    public Response queryMpesaTransaction(Map<String, String> transactionParameters, Map<String, String> transactionReferenceData, String receiverMsisdn) {
        ObjectFactory objectFactory = new ObjectFactory();
        try {
            Request request = objectFactory.createRequest();
            Request.Transaction transaction = objectFactory.createRequestTransaction();
            transaction.setCommandID(mpesaProperties.getMpesaCommandIdTransactionStatusQuery());
            /*
                Generate unique ID based on the timestamp
                TODO: Validate the correct length
             */
            SimpleDateFormat dateFormat = new SimpleDateFormat(mpesaProperties.getMpesaSdfUniqueTimestamp());
            String originatorConversationID = String.format("%s-%s", UUID.randomUUID().toString(), dateFormat.format(new Date()));
            transaction.setOriginatorConversationID(originatorConversationID);


            Request.Identity identity = objectFactory.createRequestIdentity();


            Request.Identity.Caller caller = objectFactory.createRequestIdentityCaller();
            caller.setCallerType(mpesaProperties.getRegisterUrlCallerType());
            caller.setThirdPartyID(mpesaProperties.getKeMpesa3rdPartyId());
            /*
                TODO: Hashed?This security credential of the ThirdPartyID defined in MM. If the password feature for third party is used in MM, then this parameter must be presented in the request message.
             */
            caller.setPassword(mpesaProperties.getKeMpesa3rdPartyPassword());
            caller.setResultURL(mpesaProperties.getResultUrl());
            identity.setCaller(caller);

            Request.Identity.Initiator initiator = objectFactory.createRequestIdentityInitiator();
            initiator.setIdentifierType(mpesaProperties.getRegisterUrlIdentityIdentifierType());
            initiator.setIdentifier(mpesaProperties.getKeRequestInitiatorIdentifier());
            initiator.setSecurityCredential(mpesaProperties.getKeRequestInitiatorSecurityCredential());
            initiator.setShortCode(mpesaProperties.getKeMpesaShortCode());
            identity.setInitiator(initiator);

            Request.Identity.PrimaryParty primaryParty = objectFactory.createRequestIdentityPrimartyParty();
            primaryParty.setIdentifierType(mpesaProperties.getPrimaryIdentifierType());
            primaryParty.setIdentifier(mpesaProperties.getShortCode());
            primaryParty.setShortCode(mpesaProperties.getShortCode());

            identity.setPrimaryParty(primaryParty);

            Request.Identity.AccessDevice accessDevice = objectFactory.createRequestIdentityAccessDevice();
            accessDevice.setIdentifierType(new BigInteger(String.valueOf(mpesaProperties.getKeRequestAccessDeviceIdentifierType())));
            accessDevice.setIdentifier(mpesaProperties.getKeRequestAccessDeviceIdentifier());

            identity.setAccessDevice(accessDevice);


            Request.Identity.ReceiverParty receiverParty = objectFactory.createRequestIdentityReceiverParty();
            receiverParty.setIdentifier(mpesaProperties.getKeRequestReceiverPartyIdentifier());
            receiverParty.setIdentifierType(new BigInteger(String.valueOf(mpesaProperties.getKeRequestReceiverPartyIdentifierType())));
            receiverParty.setShortCode(mpesaProperties.getKeMpesaShortCode());
            identity.setReceiverParty(receiverParty);

            /*
                TODO: Should probably be on the product defination
             */
            transaction.setRemark(mpesaProperties.getKeRequestTransactionRemark());


            Request.Transaction.Parameters parameters = objectFactory.createRequestTransactionParameters();

            transactionParameters.forEach((s, v) -> {
                Request.Transaction.Parameters.Parameter parameter = objectFactory.createRequestTransactionParametersParameter();
                parameter.setKey(s);
                parameter.setValue(v);
                parameters.getParameter().add(parameter);
            });

            transaction.setParameters(parameters);

            Request.Transaction.ReferenceData referenceData = objectFactory.createRequestTransactionReferenceData();


            transactionReferenceData.forEach((s, v) -> {
                ParameterType2 referenceItem = objectFactory.createParameterType2();
                referenceItem.setKey(s);
                referenceItem.setValue(v);
                referenceData.getReferenceItem().add(referenceItem);

            });

            transaction.setReferenceData(referenceData);

            dateFormat = new SimpleDateFormat(mpesaProperties.getKeMpesaSdfRequestTimestamp());
            transaction.setTimestamp(dateFormat.format(new Date()));
            request.setKeyOwner(new BigInteger(String.valueOf(mpesaProperties.getKeMpesaRequestKeyOwner())));


            request.setIdentity(identity);
            request.setTransaction(transaction);
            request.setKeyOwner(mpesaProperties.getRegisterUrlKeyOwner());

            String requestStr = marshallRequest(request);

            /*
                TODO: QName->NamespaceURI and QName->localPort can also be externalised
             */
            JAXBElement<String> resp = objectFactory.createResponseMsg((String) JAXBIntrospector.getValue(mpesaWebServiceTemplate.marshalSendAndReceive(mpesaProperties.getRegisterUrlEndPoint(), objectFactory.createRequestMsg(requestStr), mpesaSoapRequestHeaderModifier)));
            Logger.getLogger(this.getClass().getName()).log(Level.FINE, String.format("[Response Code=%s, code= %s]", resp.getValue(), resp.toString()));

            return unmarshallResponse(resp.getValue());


        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    @Override
    public Response processPromotionPayment(Map<String, String> transactionParameters, Map<String, String> transactionReferenceData) {
        ObjectFactory objectFactory = new ObjectFactory();
        try {
            Request request = objectFactory.createRequest();
            Request.Transaction transaction = objectFactory.createRequestTransaction();
            transaction.setCommandID(mpesaProperties.getMpesaCommandIdPromotionPayment());
            transaction.setLanguageCode("");
            /*
                Generate unique ID based on the timestamp
                TODO: Validate the correct length
             */
            SimpleDateFormat dateFormat = new SimpleDateFormat(mpesaProperties.getMpesaSdfUniqueTimestamp());
            String originatorConversationID = String.format("%s-%s", UUID.randomUUID().toString(), dateFormat.format(new Date()));
            transaction.setOriginatorConversationID(originatorConversationID);
            transaction.setConversationID("");
            /*
                TODO: Should probably be on the product defination
             */
            transaction.setRemark(mpesaProperties.getKeRequestTransactionRemark());

            Request.Transaction.Parameters parameters = objectFactory.createRequestTransactionParameters();

            transactionParameters.forEach((s, v) -> {
                Request.Transaction.Parameters.Parameter parameter = objectFactory.createRequestTransactionParametersParameter();
                parameter.setKey(s);
                parameter.setValue(v);
                parameters.getParameter().add(parameter);
            });
            transaction.setParameters(parameters);
            Request.Transaction.ReferenceData referenceData = objectFactory.createRequestTransactionReferenceData();
            transactionReferenceData.forEach((s, v) -> {
                ParameterType2 referenceItem = objectFactory.createParameterType2();
                referenceItem.setKey(s);
                referenceItem.setValue(v);
                referenceData.getReferenceItem().add(referenceItem);

            });
            transaction.setReferenceData(referenceData);
            Request.Identity identity = objectFactory.createRequestIdentity();


            Request.Identity.Caller caller = objectFactory.createRequestIdentityCaller();
            caller.setCallerType(mpesaProperties.getRegisterUrlCallerType());
            caller.setThirdPartyID(mpesaProperties.getKeMpesa3rdPartyId());
            /*
                TODO: Hashed?This security credential of the ThirdPartyID defined in MM. If the password feature for third party is used in MM, then this parameter must be presented in the request message.
             */
            caller.setPassword(mpesaProperties.getKeMpesa3rdPartyPassword());
            caller.setCheckSum(mpesaProperties.getMpesaRequestIdentityChecksum());
            caller.setResultURL("");
            identity.setCaller(caller);

            Request.Identity.Initiator initiator = objectFactory.createRequestIdentityInitiator();
            initiator.setIdentifierType(mpesaProperties.getRegisterUrlIdentityIdentifierType());
            initiator.setIdentifier(mpesaProperties.getKeRequestInitiatorIdentifier());
            initiator.setSecurityCredential(mpesaProperties.getKeRequestInitiatorSecurityCredential());
            initiator.setShortCode(mpesaProperties.getKeMpesaShortCode());
            identity.setInitiator(initiator);

            Request.Identity.PrimaryParty primaryParty = objectFactory.createRequestIdentityPrimartyParty();
            primaryParty.setIdentifierType(mpesaProperties.getRegisterUrlIdentityIdentifierType());
            /*
                TODO: Could this be our Paybill number? Not clear what shortcode means
             */
            primaryParty.setIdentifier(mpesaProperties.getShortCode());
            primaryParty.setShortCode(mpesaProperties.getShortCode());
            identity.setPrimaryParty(primaryParty);

            Request.Identity.ReceiverParty receiverParty = objectFactory.createRequestIdentityReceiverParty();
            receiverParty.setIdentifier(mpesaProperties.getKeRequestReceiverPartyIdentifier());
            receiverParty.setIdentifierType(new BigInteger(String.valueOf(mpesaProperties.getKeRequestReceiverPartyIdentifierType())));
            receiverParty.setShortCode(mpesaProperties.getKeMpesaShortCode());
            identity.setReceiverParty(receiverParty);

            Request.Identity.AccessDevice accessDevice = objectFactory.createRequestIdentityAccessDevice();
            accessDevice.setIdentifierType(new BigInteger(mpesaProperties.getKeRequestAccessDeviceIdentifierType()));
            accessDevice.setIdentifier(mpesaProperties.getKeRequestAccessDeviceIdentifier());
            identity.setAccessDevice(accessDevice);

            dateFormat = new SimpleDateFormat(mpesaProperties.getKeMpesaSdfRequestTimestamp());
            transaction.setTimestamp(dateFormat.format(new Date()));
            request.setKeyOwner(new BigInteger(String.valueOf(mpesaProperties.getKeMpesaRequestKeyOwner())));


            request.setIdentity(identity);
            request.setTransaction(transaction);
            request.setKeyOwner(mpesaProperties.getRegisterUrlKeyOwner());

            String requestStr = marshallRequest(request);

            /*
                TODO: QName->NamespaceURI and QName->localPort can also be externalised
             */
            JAXBElement<String> resp = objectFactory.createResponseMsg((String) JAXBIntrospector.getValue(mpesaWebServiceTemplate.marshalSendAndReceive(mpesaProperties.getRegisterUrlEndPoint(), objectFactory.createRequestMsg(requestStr), mpesaSoapRequestHeaderModifier)));
            Logger.getLogger(this.getClass().getName()).log(Level.FINE, String.format("[Response Code=%s, code= %s]", resp.getValue(), resp.toString()));

            Response response = unmarshallResponse(resp.getValue());
            return response;


        } catch (WebServiceIOException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, String.format("Request failed, [Message= %s, URL= %s]", e.getMessage(), mpesaProperties.getBrokerEndPoint()));
            return null;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    @Override
    public Response processMpesaTransaction(Map<String, String> transactionParameters, Map<String, String> transactionReferenceData, String commandId) {
        ObjectFactory objectFactory = new ObjectFactory();
        try {
            Request request = objectFactory.createRequest();
            Request.Transaction transaction = objectFactory.createRequestTransaction();
            transaction.setCommandID(commandId);
            transaction.setLanguageCode("");
            /*
                Generate unique ID based on the timestamp
                TODO: Validate the correct length
             */
            SimpleDateFormat dateFormat = new SimpleDateFormat(mpesaProperties.getMpesaSdfUniqueTimestamp());
            String originatorConversationID = String.format("%s-%s", UUID.randomUUID().toString(), dateFormat.format(new Date()));
            transaction.setOriginatorConversationID(originatorConversationID);
            transaction.setConversationID("");
            /*
                TODO: Should probably be on the product defination
             */
            transaction.setRemark(mpesaProperties.getKeRequestTransactionRemark());

            Request.Transaction.Parameters parameters = objectFactory.createRequestTransactionParameters();

            transactionParameters.forEach((s, v) -> {
                Request.Transaction.Parameters.Parameter parameter = objectFactory.createRequestTransactionParametersParameter();
                parameter.setKey(s);
                parameter.setValue(v);
                parameters.getParameter().add(parameter);
            });
            transaction.setParameters(parameters);
            Request.Transaction.ReferenceData referenceData = objectFactory.createRequestTransactionReferenceData();
            transactionReferenceData.forEach((s, v) -> {
                ParameterType2 referenceItem = objectFactory.createParameterType2();
                referenceItem.setKey(s);
                referenceItem.setValue(v);
                referenceData.getReferenceItem().add(referenceItem);

            });
            transaction.setReferenceData(referenceData);
            Request.Identity identity = objectFactory.createRequestIdentity();


            Request.Identity.Caller caller = objectFactory.createRequestIdentityCaller();
            caller.setCallerType(mpesaProperties.getRegisterUrlCallerType());
            caller.setThirdPartyID(mpesaProperties.getKeMpesa3rdPartyId());
            /*
                TODO: Hashed?This security credential of the ThirdPartyID defined in MM. If the password feature for third party is used in MM, then this parameter must be presented in the request message.
             */
            caller.setPassword(mpesaProperties.getKeMpesa3rdPartyPassword());
            caller.setCheckSum(mpesaProperties.getMpesaRequestIdentityChecksum());
            caller.setResultURL(mpesaProperties.getResultUrl());
            identity.setCaller(caller);

            Request.Identity.Initiator initiator = objectFactory.createRequestIdentityInitiator();
            initiator.setIdentifierType(mpesaProperties.getRegisterUrlIdentityIdentifierType());
            initiator.setIdentifier(mpesaProperties.getKeRequestInitiatorIdentifier());
            initiator.setSecurityCredential(mpesaProperties.getKeRequestInitiatorSecurityCredential());
            initiator.setShortCode(mpesaProperties.getKeMpesaShortCode());
            identity.setInitiator(initiator);

            Request.Identity.PrimaryParty primaryParty = objectFactory.createRequestIdentityPrimartyParty();
            primaryParty.setIdentifierType(mpesaProperties.getRegisterUrlIdentityIdentifierType());
            /*
                TODO: Could this be our Paybill number? Not clear what shortcode means
             */
            primaryParty.setIdentifier(mpesaProperties.getShortCode());
            primaryParty.setShortCode(mpesaProperties.getShortCode());
            identity.setPrimaryParty(primaryParty);

            Request.Identity.ReceiverParty receiverParty = objectFactory.createRequestIdentityReceiverParty();
            receiverParty.setIdentifier(mpesaProperties.getKeRequestReceiverPartyIdentifier());
            receiverParty.setIdentifierType(new BigInteger(String.valueOf(mpesaProperties.getKeRequestReceiverPartyIdentifierType())));
            receiverParty.setShortCode(mpesaProperties.getKeMpesaShortCode());
            identity.setReceiverParty(receiverParty);

            Request.Identity.AccessDevice accessDevice = objectFactory.createRequestIdentityAccessDevice();
            accessDevice.setIdentifierType(new BigInteger(mpesaProperties.getKeRequestAccessDeviceIdentifierType()));
            accessDevice.setIdentifier(mpesaProperties.getKeRequestAccessDeviceIdentifier());
            identity.setAccessDevice(accessDevice);

            dateFormat = new SimpleDateFormat(mpesaProperties.getKeMpesaSdfRequestTimestamp());
            transaction.setTimestamp(dateFormat.format(new Date()));
            request.setKeyOwner(new BigInteger(String.valueOf(mpesaProperties.getKeMpesaRequestKeyOwner())));


            request.setIdentity(identity);
            request.setTransaction(transaction);
            request.setKeyOwner(mpesaProperties.getRegisterUrlKeyOwner());

            String requestStr = marshallRequest(request);

            /*
                TODO: QName->NamespaceURI and QName->localPort can also be externalised
             */
            JAXBElement<String> resp = objectFactory.createResponseMsg((String) JAXBIntrospector.getValue(mpesaWebServiceTemplate.marshalSendAndReceive(mpesaProperties.getRegisterUrlEndPoint(), objectFactory.createRequestMsg(requestStr), mpesaSoapRequestHeaderModifier)));
            Logger.getLogger(this.getClass().getName()).log(Level.FINE, String.format("[Response Code=%s, code= %s]", resp.getValue(), resp.toString()));

            return unmarshallResponse(resp.getValue());


        } catch (WebServiceIOException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, String.format("Request failed, [Message= %s, URL= %s]", e.getMessage(), mpesaProperties.getBrokerEndPoint()));
            return null;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    @Override
    /*
    This function is used to create a result to send to broker
    the broker.
    code 0=success else unsuccessfull
    description and transId are optional
     */
    public Object sendValidationResponse(String code, String desc, String transId) {
        Object object;
        org.muhia.app.psi.integ.wsdl.mpesa.paymentvalidationandconfirmation.ObjectFactory objectFactory = new org.muhia.app.psi.integ.wsdl.mpesa.paymentvalidationandconfirmation.ObjectFactory();
        C2BPaymentValidationResult result = objectFactory.createC2BPaymentValidationResult();
        result.setResultCode(code);
        result.setResultDesc(desc);
        result.setThirdPartyTransID(transId);
        try {
            /*
                TODO: How to log the response
             */
            object = JAXBIntrospector.getValue(mpesaWebServiceTemplate.marshalSendAndReceive(mpesaProperties.getBrokerEndPoint(), new JAXBElement<>(new QName("http://api-v1.gen.mm.vodafone.com/mminterface/request", "result"), C2BPaymentValidationResult.class, result), mpesaSoapRequestHeaderModifier));
//            Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("Response [code=%s, description=%s]", response.getResponseCode(), response.getResponseDesc()));
            return object;

        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }
}