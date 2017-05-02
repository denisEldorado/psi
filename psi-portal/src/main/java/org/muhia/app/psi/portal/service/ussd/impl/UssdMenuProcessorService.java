package org.muhia.app.psi.portal.service.ussd.impl;
/*
  Copyright 2015-2016 the original author or authors.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
       http://www.apache.org/licenses/LICENSE-2.0
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/

import org.muhia.app.psi.config.menu.ussd.MenuMessages;
import org.muhia.app.psi.orm.model.Principals;
import org.muhia.app.psi.orm.model.UssdMenuImsiCodeVw;
import org.muhia.app.psi.orm.model.UssdRequests;
import org.muhia.app.psi.orm.model.UssdResponses;
import org.muhia.app.psi.portal.service.orm.IPrincipalsService;
import org.muhia.app.psi.portal.service.orm.IUssdRequestsProcessorService;
import org.muhia.app.psi.portal.service.ussd.IUssdMenuProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
  Created by Kenneth Muhia <muhia@muhia.org>
  Project: psi
  Package: org.muhia.app.psi.portal.service.ussd.impl
  Generated on: 25-Mar-17, 11:21.
 */
@Service
public class UssdMenuProcessorService implements IUssdMenuProcessorService {
    private final MenuMessages menuMessages;
    private final IUssdRequestsProcessorService requestsProcessorService;
    private final IPrincipalsService principalsService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public UssdMenuProcessorService(MenuMessages menuMessages, IUssdRequestsProcessorService requestsProcessorService, IPrincipalsService principalsService, AuthenticationManager authenticationManager) {
        this.menuMessages = menuMessages;
        this.requestsProcessorService = requestsProcessorService;
        this.principalsService = principalsService;
        this.authenticationManager = authenticationManager;
    }


    @Override
    public boolean isSubscriberWhitelistedForCode(UssdRequests requests) {
        final boolean[] results = new boolean[1];
        if (requestsProcessorService.findUssdCodesByUssdCodeAndStatus(requests.getCode(), menuMessages.getUssdCodeTest()).isPresent()) {

            /**
             *Its a test shortcode
             */
            requestsProcessorService.findUssdCodesByUssdCodeAndStatus(requests.getCode(), menuMessages.getUssdCodeTest()).ifPresent(ussdCodes -> results[0] = requestsProcessorService.findSubscriberWhitelistBySubnoAndCode(requests.getMsisdn(), ussdCodes).isPresent());

        } else {
            /**
             *Production shortcode everyone allowed access
             */
            results[0] = requestsProcessorService.findUssdCodesByUssdCodeAndStatus(requests.getCode(), menuMessages.getUssdCodeActive()).isPresent();
        }
        return results[0];
    }

    @Override
    public boolean isImsiInAllowedRange(UssdRequests requests) {
        boolean results = false;
        Collection<UssdMenuImsiCodeVw> ussdMenuImsiCodeVws = requestsProcessorService.findUssdMenuImsiCodeVwByCodeAndStatus(requests.getCode(), menuMessages.getUssdCodeActive());
        if (ussdMenuImsiCodeVws.stream().anyMatch(ussdMenuImsiCodeVw -> requests.getImsi().startsWith(ussdMenuImsiCodeVw.getUssdImsiPrefix()))) {
            results = true;
        }

        return results;
    }

    @Override
    public boolean isRequestUserRegistered(UssdRequests requests) {
        return principalsService.findUserByPhone(requests.getMsisdn()).isPresent();
    }

    @Override
    public Authentication authenticateUssdRequest(UssdRequests requests, Principals p) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(p.getLoginName(), requests.getRequestInput());
        Authentication authentication = null;
        try {
            /**
             login successful
             TODO: Since there is a session ID for each USSD we need to retain a dummy cookie(manually created) so that when the user starts a new Ussd Session they have to Authenticate again
             */
            authentication = authenticationManager.authenticate(token);


        } catch (AuthenticationException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage());

        }
        return authentication;

    }

    @Override
    public Authentication authenticateUssdRequest(String login, String password) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(login, password);
        Authentication authentication = null;
        try {
            /**
             login successful
             TODO: Since there is a session ID for each USSD we need to retain a dummy cookie(manually created) so that when the user starts a new Ussd Session they have to Authenticate again
             */
            authentication = authenticationManager.authenticate(token);


        } catch (AuthenticationException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage());

        }
        return authentication;
    }


    @Override
    public UssdResponses processUssdRequestAndLogResponse(UssdRequests requests, String messages, String status, String parentId, String endOfSession, int responseCode, HttpHeaders headers) {
        requests.setVarFld1(parentId);
        requests.setStatus(status);


        requests = logUssdRequest(requests);

        UssdResponses ussdResponses = new UssdResponses();
        ussdResponses.setEndOfSession(endOfSession);
        ussdResponses.setRequestId(requests);
        ussdResponses.setResponseBody(messages);
        ussdResponses.setResponseCode(new Long(responseCode));
        ussdResponses.setResponseData(headers.toString());
        ussdResponses.setResponseDate(new Date());
        ussdResponses.setResponseType(status);
        ussdResponses.setSequenceId(requests.getSessionid());
        ussdResponses.setStatus(status);

        return logUssdResponse(ussdResponses);
    }


    @Override
    public UssdRequests logUssdRequest(UssdRequests ussdRequests) {

        return requestsProcessorService.saveUssdRequest(ussdRequests);

    }

    @Override
    public UssdResponses logUssdResponse(UssdResponses ussdResponses) {

        return requestsProcessorService.saveUssdResponse(ussdResponses);

    }


}
