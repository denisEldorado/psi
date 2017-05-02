package org.muhia.app.psi.portal.config;

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
import org.muhia.app.psi.portal.security.CustomSignInUtils;
import org.muhia.app.psi.portal.service.orm.IPrincipalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionData;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.web.context.request.NativeWebRequest;

import javax.inject.Inject;

/*
    Created by Kenneth Muhia <muhia@muhia.org> 
    Project: psi
    Package: org.muhia.app.psi.portal.config
    Date: 02-Jan-17.
*/
public class SocialSignInAdapter implements SignInAdapter {
    @Autowired
    private IPrincipalsService service;

    @Inject
    public SocialSignInAdapter(RequestCache requestCache) {
    }

    @Override
    public String signIn(String userId, Connection<?> connection, NativeWebRequest request) {
        Principals user = service.findByLoginName(userId);
        ConnectionData connectionData = connection.createData();
        CustomSignInUtils.authorizeUser(user);
        CustomSignInUtils.setUserConnection(request, connectionData);
        return user.toString();
    }
}
