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

import org.muhia.app.psi.portal.service.orm.IPrincipalsService;
import org.muhia.app.psi.config.security.properties.UserAccountStatus;
import org.muhia.app.psi.orm.model.Principals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;

/*
    Created by Kenneth Muhia <muhia@muhia.org> 
    Project: psi
    Package: org.muhia.app.psi.portal.security
    Date: 02-Jan-17.
*/
public class CurrentUser extends User {
    private Principals user;

    @Autowired
    private IPrincipalsService service;

    @Autowired
    private UserAccountStatus accountStatus;

    @Autowired
    public CurrentUser(Principals user) {
        super(user.getLoginName(), user.getCredentials(), user.getGrantedAuthorities());
        this.user = user;
    }

    public Long getId() {
        return user.getId();
    }

    public String getProfileIconUrl() {

        return user.getPicturepath();
    }

    public String getProfileImageUrl() {
        /*
            TODO: Do we need a separate path, I would suggest to have a separate table for paths...
         */

        return user.getPicturepath();
    }

    @Override
    public String toString() {
        return "CurrentUser{" + "user=" + user + '}' + super.toString();
    }


}
