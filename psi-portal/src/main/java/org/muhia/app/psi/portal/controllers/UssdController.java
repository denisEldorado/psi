/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.controllers;

import org.hibernate.TypeMismatchException;
import org.muhia.app.psi.portal.PortalApplication;
import org.muhia.app.psi.portal.eventbus.DashboardEvent;
import org.muhia.app.psi.portal.eventbus.DashboardEvent.UssdRequestReceivedEvent;
import org.muhia.app.psi.config.menu.ussd.MenuMessages;
import org.muhia.app.psi.config.security.HashingImplementation;
import org.muhia.app.psi.orm.model.UssdRequests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@RestController
public class UssdController {

    private final MenuMessages menuMessages;
    private final HashingImplementation hasher;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public UssdController(MenuMessages menuMessages, HashingImplementation hasher, AuthenticationManager authenticationManager) {
        this.menuMessages = menuMessages;
        this.hasher = hasher;
        this.authenticationManager = authenticationManager;
    }

    @RequestMapping(value = "/ussd/ussdke", method = RequestMethod.POST)
    @ResponseBody
    private ResponseEntity processAcceptPostRequest(

            @RequestParam(name = "userid") String requestUserid,
            @RequestParam(name = "password") String requestPassword,
            @RequestParam(name = "input") String input,
            @RequestParam(name = "sessionid") String sessionid,
            @RequestParam(name = "msisdn") String msisdn,
            @RequestParam(name = "transactionid") String transactionid,
            @RequestParam(name = "imsi", required = false) String imsi,
            @RequestParam(name = "newrequest", required = false) String newrequest,
            @RequestParam(name = "code", required = false) String code,
            @RequestParam(name = "clean", required = false) String clean,
            @RequestParam(name = "lac", required = false) String lac,
            @RequestParam(name = "status", required = false) String requestStatus, HttpServletRequest request) {
        /*
          Obtain request parameters
         */
        Map<String, String> requestParameterMaps = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String val = request.getHeader(key);
            Logger.getLogger(UssdController.class.getName()).log(Level.INFO, "Key: {0} value {1}", new Object[]{key, val});
            requestParameterMaps.put(key, val);
        }
        /*
          Add ServletRequestParameters to my map

         */
        requestParameterMaps.put("lac", lac);
        requestParameterMaps.put("clean", clean);
        requestParameterMaps.put("code", code);
        requestParameterMaps.put("imsi", imsi);
        requestParameterMaps.put("msisdn", msisdn);
        requestParameterMaps.put("newrequest", newrequest);
        requestParameterMaps.put("input", input);
        requestParameterMaps.put("password", requestPassword);
        requestParameterMaps.put("userid", requestUserid);
        requestParameterMaps.put("sessionid", sessionid);
        requestParameterMaps.put("status", requestStatus);
        requestParameterMaps.put("transactionid", transactionid);

        String result = "";
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("charge", "N");
        responseHeaders.set("Expires", "-1");
//        responseHeaders.set("Content-Type", "text/xml");
        responseHeaders.set("Pragma", "no-cache");
        responseHeaders.set("Freeflow", "FB");
        responseHeaders.set("Cache-Control", "max-age=0");
        responseHeaders.set("Local-Redirect", "N");
        UssdRequests ussdRequests = new UssdRequests();

        /*
          A new transaction, map the data to the request
         */
        ussdRequests.setClean(requestParameterMaps.get("clean"));
        ussdRequests.setCode(requestParameterMaps.get("code"));
        ussdRequests.setImsi(requestParameterMaps.get("imsi"));
        ussdRequests.setMsisdn(requestParameterMaps.get("msisdn"));
        ussdRequests.setNewrequest(requestParameterMaps.get("newrequest"));
        ussdRequests.setRequestDate(new Date());
        ussdRequests.setRequestInput(requestParameterMaps.get("input"));
        ussdRequests.setRequestIp(request.getRemoteAddr() + ":" + request.getRemotePort());
        ussdRequests.setRequestPassword(requestParameterMaps.get("password"));
        ussdRequests.setRequestUserid(requestParameterMaps.get("userid"));
        ussdRequests.setSessionid(requestParameterMaps.get("sessionid"));
        ussdRequests.setStatus(requestParameterMaps.get("status"));
        ussdRequests.setTransactionid(requestParameterMaps.get("transactionid"));
        ussdRequests.setVarFld10(requestParameterMaps.get("lac"));

        final StringBuilder mapStr = new StringBuilder();
        mapStr.append("[");

        requestParameterMaps.entrySet().forEach(m -> {
            if (m.getKey().equals(menuMessages.getCredentialsVar())) {
                mapStr.append("[").append(m.getKey()).append("=").append("************").append("], ");
            } else if (m.getKey().equals(menuMessages.getCredentialVar())) {
                mapStr.append("[").append(m.getKey()).append("=").append(hasher.getEncryptedValue(m.getValue())).append("], ");
            } else {
                mapStr.append("[").append(m.getKey()).append("=").append(m.getValue()).append("], ");
            }
        });
        mapStr.append("]");

        Logger.getLogger(UssdController.class.getName()).log(Level.INFO, "Ussd request received {0} from: {1}:{2}",
                new Object[]{mapStr, request.getRemoteAddr(), request.getRemotePort()});
        try {

            //UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(hasher.getDecryptedValue(requestUserid), hasher.getDecryptedValue(requestPassword));
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(requestUserid, requestPassword);


            Authentication auth = authenticationManager.authenticate(token);
            if (auth.isAuthenticated()) {
                UssdRequestReceivedEvent event = new DashboardEvent.UssdRequestReceivedEvent(ussdRequests, result,responseHeaders, mapStr);
                PortalApplication.dashBoardEventBusService().post(event);
                return new ResponseEntity<>(event.getMessages(), event.getResponseHeaders(), HttpStatus.OK);
            }else {
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, menuMessages.getUssdNotAllowedResponse());
                return new ResponseEntity<>(menuMessages.getUssdNotAllowedResponse(), responseHeaders,HttpStatus.FORBIDDEN);
            }


        } catch (AuthenticationException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(),e);
            return new ResponseEntity<>(menuMessages.getGeneralExceptionMessage(), responseHeaders, HttpStatus.OK);
        }




    }

    @RequestMapping(value = "/ussd/ussdke", method = RequestMethod.GET, produces = "application/xml")
    private ResponseEntity<String> processRejectGetRequest(HttpServletRequest request) {

        String result = "Bad Request!\n";
        HttpHeaders responseHeaders = new HttpHeaders();
        /*
          Some none changing values
         */
        final StringBuilder mapStr = new StringBuilder();
        request.getParameterMap().values().stream().map(mapStr::append);
        responseHeaders.set("charge", "N");
        responseHeaders.set("Expires", "-1");
        responseHeaders.set("Pragma", "no-cache");
        responseHeaders.set("Cache-Control", "max-age=0");
//        responseHeaders.set("Content-Type", "application/xml");
        responseHeaders.set("Freeflow", "FB");
        responseHeaders.set("Local-Redirect", "N");

        Logger.getLogger(UssdController.class.getName()).log(Level.SEVERE,
                "Probable scamming request from Address:{0} , port: {1} having parameter values as [{2}]",
                new Object[]{request.getRemoteAddr(), request.getRemotePort(), mapStr});

        return new ResponseEntity<>(result, responseHeaders, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TypeMismatchException.class)
    public ResponseEntity<String> typeMismatchExceptionHandler(Exception exception,
                                                               HttpServletRequest request) throws IOException, ServletException {
        HttpHeaders responseHeaders = new HttpHeaders();
        String result = "type mismatch\n";
        responseHeaders.set("charge", "N");
        responseHeaders.set("Expires", "-1");
        responseHeaders.set("Pragma", "no-cache");
        responseHeaders.set("Cache-Control", "max-age=0");
//        responseHeaders.set("Content-Type", "application/xml");
        responseHeaders.set("Freeflow", "FB");
        responseHeaders.set("Local-Redirect", "N");

        Logger.getLogger(UssdController.class.getName()).log(Level.SEVERE, MessageFormat.format("{0}{1}", result, request.toString()), exception);

        return new ResponseEntity<>(result, responseHeaders, HttpStatus.EXPECTATION_FAILED);

    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<String> missingParameterExceptionHandler(Exception exception,
                                                                   HttpServletRequest request) {
        HttpHeaders responseHeaders = new HttpHeaders();
        String result = "Sorry, we are unable to process your request at the moment\n";
        responseHeaders.set("charge", "N");
        responseHeaders.set("Expires", "-1");
        responseHeaders.set("Pragma", "no-cache");
        responseHeaders.set("Cache-Control", "max-age=0");
//        responseHeaders.set("Content-Type", "application/xml");
        responseHeaders.set("Freeflow", "FB");
        responseHeaders.set("Local-Redirect", "N");

        Logger.getLogger(UssdController.class.getName()).log(Level.SEVERE, MessageFormat.format("{0}Missing Parameter{1}", result, request.toString()), exception);

        return new ResponseEntity<>(result, responseHeaders, HttpStatus.EXPECTATION_FAILED);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> generalExceptionHandler(Exception exception,
                                                          HttpServletRequest request) {
        HttpHeaders responseHeaders = new HttpHeaders();
        String result = "Sorry we could not process your request at the moment";
        responseHeaders.set("charge", "N");
        responseHeaders.set("Expires", "-1");
        responseHeaders.set("Pragma", "no-cache");
        responseHeaders.set("Cache-Control", "max-age=0");
//        responseHeaders.set("Content-Type", "application/xml");
        responseHeaders.set("Freeflow", "FB");
        responseHeaders.set("Local-Redirect", "N");

        Logger.getLogger(UssdController.class.getName()).log(Level.SEVERE, result + request.toString(), exception);

        return new ResponseEntity<>(result, responseHeaders, HttpStatus.EXPECTATION_FAILED);
    }

}
