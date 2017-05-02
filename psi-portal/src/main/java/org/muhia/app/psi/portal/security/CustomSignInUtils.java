package org.muhia.app.psi.portal.security;

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

import org.muhia.app.psi.orm.model.Principals;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.ConnectionData;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

/*
    Created by Kenneth Muhia <muhia@muhia.org> 
    Project: psi
    Package: org.muhia.app.psi.portal.security
    Date: 02-Jan-17.
*/
public class CustomSignInUtils {
    private static final String SESSION_USER_CONNECTION = "MY_USER_CONNECTION";
    public static void authorizeUser(Principals user) {

        CurrentUser currentUser = new CurrentUser(user);
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(currentUser, user.getCredentials(), user.getGrantedAuthorities()));

    }

    public static void setUserConnection(WebRequest request, ConnectionData connectionData) {
        String attribute = SESSION_USER_CONNECTION;
        request.setAttribute(attribute, connectionData, RequestAttributes.SCOPE_SESSION);
    }
}
