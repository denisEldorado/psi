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

import org.muhia.app.psi.config.menu.ussd.MenuMessages;
import org.muhia.app.psi.portal.PortalApplication;
import org.muhia.app.psi.portal.eventbus.DashboardEvent;
import org.muhia.app.psi.portal.service.ussd.IUssdMenuProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
  Created by KennethKZMMuhia
  Project: psi
  Package: org.muhia.app.psi.portal.controllers
  Generated on 20-Dec-16.
 */
@RestController
public class TasksAutomationController {

    private final MenuMessages menuMessages;

    private final AuthenticationManager authenticationManager;

    private final IUssdMenuProcessorService menuProcessorService;


    @Autowired
    public TasksAutomationController(MenuMessages menuMessages, AuthenticationManager authenticationManager, IUssdMenuProcessorService menuProcessorService) {
        this.menuMessages = menuMessages;
        this.authenticationManager = authenticationManager;
        this.menuProcessorService = menuProcessorService;
    }

    @RequestMapping(value = "/tasks/generateToken", method = RequestMethod.POST)
    public ResponseEntity<String> processPasswordReset(@RequestParam(name = "userid", required = false) String requestUserid,
                                                       @RequestParam(name = "password", required = false) String requestPassword,
                                                       @RequestParam(name = "subno", required = false) String subno,
                                                       @RequestParam(name = "code") String code,
                                                       @RequestParam(name = "status") int status,
                                                       HttpServletRequest request) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("charge", "N");
        responseHeaders.set("Expires", "-1");
        responseHeaders.set("Pragma", "no-cache");
        responseHeaders.set("Cache-Control", "max-age=0");
        responseHeaders.set("Freeflow", "FB");
        responseHeaders.set("Local-Redirect", "N");
        try {


//            Authentication authentication = menuProcessorService.authenticateUssdRequest(requestUserid, requestPassword);
//            if (authentication.isAuthenticated()) {
                DashboardEvent.TokenResetRequestReceivedEvent event = new DashboardEvent.TokenResetRequestReceivedEvent(subno, code, status);
                event.setHttpHeaders(responseHeaders);
                PortalApplication.dashBoardEventBusService().post(event);
                return new ResponseEntity<>(event.getOutput(), event.getHttpHeaders(), HttpStatus.ACCEPTED);

//            } else {
//                Logger.getLogger(this.getClass().getName()).log(Level.INFO, menuMessages.getUssdNotAllowedResponse());
//                return new ResponseEntity<>(menuMessages.getUssdNotAllowedResponse(), responseHeaders, HttpStatus.FORBIDDEN);
//            }


        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(menuMessages.getGeneralExceptionMessage(), responseHeaders, HttpStatus.ACCEPTED);

        }


    }

    @RequestMapping(value = "/tasks/whitelistsubscriber", method = RequestMethod.POST)
    public ResponseEntity<String> processSubscriberWhitelistRequest(@RequestParam(name = "userid") String requestUserid,
                                                                    @RequestParam(name = "password") String requestPassword,
                                                                    @RequestParam(name = "subno") String subno,
                                                                    @RequestParam(name = "code") String code,
                                                                    @RequestParam(name = "status") int status,
                                                                    HttpServletRequest request) {
//        Map<String, String> requestParameterMaps = new HashMap<>();
//        requestParameterMaps.put("subno", subno);
//        requestParameterMaps.put("code", code);
//        requestParameterMaps.put("status", String.valueOf(status));
//        requestParameterMaps.put("password", requestPassword);
//        requestParameterMaps.put("userid", requestUserid);

        final StringBuilder mapStr = new StringBuilder();
        mapStr.append("[");

//        requestParameterMaps.entrySet().forEach(m -> {
//            if (m.getKey().equals(menuMessages.getCredentialsVar())) {
//                mapStr.append("[").append(m.getKey()).append("=").append("********").append("], ");
//            } else if (m.getKey().equals(menuMessages.getCredentialVar())) {
//                mapStr.append("[").append(m.getKey()).append("=").append("********").append("], ");
//            } else {
//                mapStr.append("[").append(m.getKey()).append("=").append(m.getValue()).append("], ");
//            }
//        });

        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Whitelisting request received {0} from: {1}:{2}", new Object[]{mapStr, request.getRemoteAddr(), request.getRemotePort()});

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("charge", "N");
        responseHeaders.set("Expires", "-1");
        responseHeaders.set("Pragma", "no-cache");
        responseHeaders.set("Cache-Control", "max-age=0");
        responseHeaders.set("Freeflow", "FB");
        responseHeaders.set("Local-Redirect", "N");
        try {


            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(requestUserid, requestPassword);


            Authentication auth = authenticationManager.authenticate(token);
            if (auth.isAuthenticated() && auth.getAuthorities().contains(new SimpleGrantedAuthority(menuMessages.getAdminRoleKeyword()))) {
                DashboardEvent.WhitelistSubscriberRequestReceivedEvent event = new DashboardEvent.WhitelistSubscriberRequestReceivedEvent(subno, code, status, responseHeaders);
                PortalApplication.dashBoardEventBusService().post(event);
                return new ResponseEntity<>(event.getOutput(), event.getHttpHeaders(), HttpStatus.ACCEPTED);
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, menuMessages.getUssdNotAllowedResponse());
                return new ResponseEntity<>(menuMessages.getUssdNotAllowedResponse(), responseHeaders, HttpStatus.FORBIDDEN);
            }


        } catch (AuthenticationException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(menuMessages.getGeneralExceptionMessage(), responseHeaders, HttpStatus.ACCEPTED);
        }

    }

    @RequestMapping(value = "/tasks/unhasher", method = RequestMethod.POST)
    public ResponseEntity<String> processUnhashingRequest(@RequestParam(name = "userid") String requestUserid,
                                                          @RequestParam(name = "password") String requestPassword,
                                                          @RequestParam(name = "input") String input, HttpServletRequest request) {
//        Map<String, String> requestParameterMaps = new HashMap<>();
//        requestParameterMaps.put("input", input);
//        requestParameterMaps.put("password", requestPassword);
//        requestParameterMaps.put("userid", requestUserid);
//
//        final StringBuilder mapStr = new StringBuilder();
//        mapStr.append("[");
//
//        requestParameterMaps.entrySet().forEach(m -> {
//            if (m.getKey().equals(menuMessages.getCredentialsVar())) {
//                mapStr.append("[").append(m.getKey()).append("=").append("********").append("], ");
//            } else if (m.getKey().equals(menuMessages.getCredentialVar())) {
//                mapStr.append("[").append(m.getKey()).append("=").append("********").append("], ");
//            } else {
//                mapStr.append("[").append(m.getKey()).append("=").append(m.getValue()).append("], ");
//            }
//        });

//        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Hashing request received {0} from: {1}:{2}", new Object[]{mapStr, request.getRemoteAddr(), request.getRemotePort()});

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("charge", "N");
        responseHeaders.set("Expires", "-1");
        responseHeaders.set("Pragma", "no-cache");
        responseHeaders.set("Cache-Control", "max-age=0");
        responseHeaders.set("Freeflow", "FB");
        responseHeaders.set("Local-Redirect", "N");
        try {


            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(requestUserid, requestPassword);


            Authentication auth = authenticationManager.authenticate(token);
            if (auth.isAuthenticated() && auth.getAuthorities().contains(new SimpleGrantedAuthority(menuMessages.getAdminRoleKeyword()))) {
                DashboardEvent.ReverseHasherAdminTaskRequestReceivedEvent event = new DashboardEvent.ReverseHasherAdminTaskRequestReceivedEvent(input, "", responseHeaders);
                PortalApplication.dashBoardEventBusService().post(event);
                return new ResponseEntity<>(event.getOutput(), event.getHttpHeaders(), HttpStatus.ACCEPTED);
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, menuMessages.getUssdNotAllowedResponse());
                return new ResponseEntity<>(menuMessages.getUssdNotAllowedResponse(), responseHeaders, HttpStatus.FORBIDDEN);
            }


        } catch (AuthenticationException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(menuMessages.getGeneralExceptionMessage(), responseHeaders, HttpStatus.ACCEPTED);
        }

    }

    @RequestMapping(value = "/tasks/hasher", method = RequestMethod.POST)
    public ResponseEntity<String> processHashingRequest(@RequestParam(name = "userid") String requestUserid,
                                                        @RequestParam(name = "password") String requestPassword,
                                                        @RequestParam(name = "input") String input, HttpServletRequest request) {
//        Map<String, String> requestParameterMaps = new HashMap<>();
//        requestParameterMaps.put("input", input);
//        requestParameterMaps.put("password", requestPassword);
//        requestParameterMaps.put("userid", requestUserid);

        final StringBuilder mapStr = new StringBuilder();
        mapStr.append("[");
//
//        requestParameterMaps.entrySet().forEach(m -> {
//            if (m.getKey().equals(menuMessages.getCredentialsVar())) {
//                mapStr.append("[").append(m.getKey()).append("=").append("********").append("], ");
//            } else if (m.getKey().equals(menuMessages.getCredentialVar())) {
//                mapStr.append("[").append(m.getKey()).append("=").append("********").append("], ");
//            } else {
//                mapStr.append("[").append(m.getKey()).append("=").append(m.getValue()).append("], ");
//            }
//        });
        mapStr.append("]");
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Hashing request received {0} from: {1}:{2}", new Object[]{mapStr, request.getRemoteAddr(), request.getRemotePort()});

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("charge", "N");
        responseHeaders.set("Expires", "-1");
        responseHeaders.set("Pragma", "no-cache");
        responseHeaders.set("Cache-Control", "max-age=0");
        responseHeaders.set("Freeflow", "FB");
        responseHeaders.set("Local-Redirect", "N");
        try {


            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(requestUserid, requestPassword);


            Authentication auth = authenticationManager.authenticate(token);
            if (auth.isAuthenticated() && auth.getAuthorities().contains(new SimpleGrantedAuthority(menuMessages.getAdminRoleKeyword()))) {
                DashboardEvent.HasherAdminTaskRequestReceivedEvent event = new DashboardEvent.HasherAdminTaskRequestReceivedEvent(input, "", responseHeaders);
                PortalApplication.dashBoardEventBusService().post(event);
                return new ResponseEntity<>(event.getOutput(), event.getHttpHeaders(), HttpStatus.ACCEPTED);
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, menuMessages.getUssdNotAllowedResponse());
                return new ResponseEntity<>(menuMessages.getUssdNotAllowedResponse(), responseHeaders, HttpStatus.FORBIDDEN);
            }


        } catch (AuthenticationException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(menuMessages.getGeneralExceptionMessage(), responseHeaders, HttpStatus.ACCEPTED);
        }
    }
}
