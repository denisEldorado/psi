package org.muhia.app.psi.portal.service.ussd;
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

import org.muhia.app.psi.orm.model.Principals;
import org.muhia.app.psi.orm.model.UssdRequests;
import org.muhia.app.psi.orm.model.UssdResponses;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;

/*
  Created by Kenneth Muhia <muhia@muhia.org>
  Project: psi
  Package: org.muhia.app.psi.portal.service
  Generated on: 25-Mar-17, 11:19.
 */
public interface IUssdMenuProcessorService {
    boolean isSubscriberWhitelistedForCode(UssdRequests requests);

    boolean isImsiInAllowedRange(UssdRequests requests);

    boolean isRequestUserRegistered(UssdRequests requests);

    UssdRequests logUssdRequest(UssdRequests ussdRequests);

    UssdResponses logUssdResponse(UssdResponses ussdResponses);

    Authentication authenticateUssdRequest(UssdRequests requests, Principals p);

    Authentication authenticateUssdRequest(String login, String password);

    UssdResponses processUssdRequestAndLogResponse(UssdRequests requests, String messages, String status, String parentId, String endOfSession, int responseCode, HttpHeaders headers);
}
