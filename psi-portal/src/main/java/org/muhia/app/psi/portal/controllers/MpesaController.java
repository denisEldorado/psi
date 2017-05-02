package org.muhia.app.psi.portal.controllers;/*
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


import org.muhia.app.psi.integ.wsdl.mpesa.cbp.request.ObjectFactory;
import org.muhia.app.psi.integ.wsdl.mpesa.cbp.request.Response;
import org.muhia.app.psi.integ.wsdl.mpesa.cbp.request.Result;
import org.muhia.app.psi.integ.wsdl.mpesa.paymentvalidationandconfirmation.C2BPaymentValidationRequest;
import org.muhia.app.psi.portal.service.orchestrate.IMpesaMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
  Created by Kenneth Muhia <muhia@muhia.org>
  Project: psi
  Package: org.muhia.app.psi.portal.controllers
  Generated on: 11-Feb-17, 07:33.
 */
@Controller
@WebService(name = "C2BPaymentValidationRequest", targetNamespace = "http://cps.huawei.com/cpsinterface/c2bpayment")
public class MpesaController {

    private IMpesaMethods mpesaMethods;

    @Autowired
    public MpesaController(IMpesaMethods iMpesaMethods) {
        this.mpesaMethods = iMpesaMethods;
    }

    @RequestMapping(value = "/mpesa/results", consumes = "application/xml", produces = "application/xml", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<Response> mpesaResultsCallBackProcessor(@RequestBody Result body) {
        /*
            DONE: Process xml received and action as per request status
            TODO: Require correct request format to test E2E
            DONE: Do we simulate SOAP for (un)marshalling or manually create xml response unmarshalling works ok now for the request
         */
        HttpHeaders responseHeaders = new HttpHeaders();
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("[body= %s]", body.toString()));
        ObjectFactory objectFactory = new ObjectFactory();
        Response response = objectFactory.createResponse();
        try {
            /*
                TODO: Externalise the request & response codes
             */
            if (body.getResultCode().equals("EXTERNILIZED_SUCCESS_RESPONSE")) {

                response.setConversationID(body.getConversationID());
                response.setResponseCode("00000000");
                response.setResponseDesc("Success");
                response.setOriginatorConversationID(body.getOriginatorConversationID());
                /*
                    TODO: Log the request received and find a way to tie it back to an existing SR and the requisite notifications, probably send it to the eventbus
                */

            }
        } catch (Exception e) {
            response.setConversationID(body.getConversationID());
            response.setResponseCode("EXTERNILIZED_FAILURE_RESPONSE");
            response.setResponseDesc(e.getMessage());
            response.setOriginatorConversationID(body.getOriginatorConversationID());
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return new ResponseEntity<>(response, responseHeaders, HttpStatus.OK);
    }

    @RequestMapping(value = "/mpesa/queue/notify", consumes = "application/xml", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<Response> mpesaQueueNotificationCallBackProcessor(HttpServletRequest request, @RequestBody Result body) {
        /*
            TODO: Process xml received and action as per request status, do we need to dictate the timeout?
            TODO: Do we simulate SOAP for (un)marshalling or manually create xml response
         */
        HttpHeaders responseHeaders = new HttpHeaders();
        ObjectFactory objectFactory = new ObjectFactory();
        Response response = objectFactory.createResponse();
        return new ResponseEntity<>(response, responseHeaders, HttpStatus.OK);
    }

    @RequestMapping(value = "/mpesa/validate",
            consumes = MediaType.ALL_VALUE,
            method = {RequestMethod.GET, RequestMethod.POST}
    )
    @ResponseBody
    public ResponseEntity validateC2BRequest(
            HttpServletRequest request,
            @RequestBody C2BPaymentValidationRequest c2bRequest
//            @RequestBody MultiValueMap<String, String> values
    ) {
        String s = "";
        c2bRequest.setBillRefNumber("Trial");
        s += c2bRequest.getMSISDN() + c2bRequest.getBusinessShortCode() + c2bRequest.getTransType() + c2bRequest.getTransID() + c2bRequest.getBillRefNumber();
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, MessageFormat.format("allparamets {0} ", s));
        /*
            TODO: Check the Request Method. Assume post for now
            TODO: Having problems parsing xml when testing
            TODO:Process xml and Implement to intercept c2b transactions before to approve/disapprove
         */

        // 0 for success, other for failure
        String code = "0";
        String desc = "success";
        mpesaMethods.sendValidationResponse(code, desc, c2bRequest.getTransID());
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<>("Received", responseHeaders, HttpStatus.OK);
    }

    @RequestMapping(value = "/mpesa/registerUrl", consumes = "application/xml", produces = "application/xml", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<Response> registerUrl(HttpServletRequest request) {
        Response response = null;
        HttpHeaders responseHeaders = new HttpHeaders();
        try {
            Enumeration<String> headerNames = request.getHeaderNames();
            StringBuilder requestparamsStr = new StringBuilder();

            while (headerNames.hasMoreElements()) {
                String key = headerNames.nextElement();
                String val = request.getHeader(key);

//                requestParameterMaps.put(key, val);
                requestparamsStr.append(String.format("[%s= %s], ", key, val));

            }
            Logger.getLogger(UssdController.class.getName()).log(Level.INFO, String.format("Request parameters %s", requestparamsStr.toString()));
            response = mpesaMethods.registerUrl();

            /*
            TODO : externalize success code
             */
            if (response.getResponseCode().equals("00000000")) {

                Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("Successful response [ResponseCode= %s, ResponseDesc= %s, ConversationID= %s, ServiceStatus= %s, OriginatorConversationID= %s]", response.getResponseCode(), response.getResponseDesc(), response.getConversationID(), response.getServiceStatus(), response.getOriginatorConversationID()));

            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("[ResponseCode= %s, ResponseDesc= %s, ConversationID= %s, ServiceStatus= %s, OriginatorConversationID= %s]", response.getResponseCode(), response.getResponseDesc(), response.getConversationID(), response.getServiceStatus(), response.getOriginatorConversationID()));

            }

        } catch (NullPointerException e) {
            ObjectFactory factory = new ObjectFactory();
            response = factory.createResponse();
            response.setResponseCode("An error occurred, try again later");
            response.setResponseDesc(String.format("No value found, [Message= %s]", e.getMessage()));
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, String.format("No value found, [Message= %s]", e.getMessage()));
        } catch (Exception e) {
            ObjectFactory factory = new ObjectFactory();
            response = factory.createResponse();
            response.setResponseCode("An error occurred, try again later");
            response.setResponseDesc(String.format("Error Occurred, [Message= %s]", e.getMessage()));
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return new ResponseEntity<>(response, responseHeaders, HttpStatus.OK);
    }

    @RequestMapping(value = "/mpesa/processTransaction", method = RequestMethod.POST)
    public ResponseEntity<Response> processTransaction(@RequestParam Map<String, String> allParams, HttpServletRequest request) {
        final String[] commandId = {""};
        Map<String, String> requestTransactionParameters = new HashMap<>();

        Map<String, String> transactionReferenceData = new HashMap<>();
        allParams.forEach((a, v) -> {
            /*
                TODO: Externalise all the Strings below
             */
            if (a.equals("commandid")) {
                commandId[0] = v;
            }
            if (a.startsWith("par")) {
                requestTransactionParameters.putIfAbsent(a.substring(3), v);
            }
            if (a.startsWith("ref")) {
                transactionReferenceData.putIfAbsent(a.substring(3), v);
            }
        });
        Response response = null;
        HttpHeaders responseHeaders = new HttpHeaders();
        try {
//            Map<String, String> requestParameterMaps = new HashMap<>();
            Enumeration<String> headerNames = request.getHeaderNames();
            StringBuilder requestparamsStr = new StringBuilder();

            while (headerNames.hasMoreElements()) {
                String key = headerNames.nextElement();
                String val = request.getHeader(key);

//                requestParameterMaps.put(key, val);
                requestparamsStr.append(String.format("[%s= %s], ", key, val));

            }
            Logger.getLogger(UssdController.class.getName()).log(Level.INFO, String.format("Request parameters %s", requestparamsStr.toString()));
            response = mpesaMethods.processMpesaTransaction(requestTransactionParameters, transactionReferenceData, commandId[0]);
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("[body= %s]", response.toString()));
            /*
            TODO : externalize success code
             */
            if (response.getResponseCode().equals("0")) {

                Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("[body= %s]", response.toString()));

            }

        } catch (NullPointerException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, String.format("No value found, [Message= %s]", e.getMessage()));
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return new ResponseEntity<>(response, responseHeaders, HttpStatus.OK);
    }

}