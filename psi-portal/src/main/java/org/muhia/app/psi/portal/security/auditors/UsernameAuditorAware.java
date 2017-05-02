package org.muhia.app.psi.portal.security.auditors;

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

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.util.logging.Logger;

/*
    This component returns the username of the authenticated user.

    Created by Kenneth Muhia <muhia@muhia.org>
    Project: psi
    Package: org.muhia.app.psi.orm.model.auditors
    Date: 02-Jan-17.
*/
public class UsernameAuditorAware implements AuditorAware<String> {

    @Override
    public String getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            Logger.getLogger(this.getClass().getName()).fine("Current user is anonymous. Returning null.");
            return null;
        }
        String username = ((User) authentication.getPrincipal()).getUsername();
        Logger.getLogger(this.getClass().getName()).fine(String.format("Returning username: {%s}", username));

        return username;
    }
}
