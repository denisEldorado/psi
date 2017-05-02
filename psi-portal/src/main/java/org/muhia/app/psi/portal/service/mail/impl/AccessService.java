package org.muhia.app.psi.portal.service.mail.impl;

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

import org.muhia.app.psi.portal.service.mail.IAccessService;
import org.muhia.app.psi.config.external.properties.ExternalProperties;
import org.muhia.app.psi.infra.dto.AccessDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/*
    Created by Kenneth Muhia <muhia@muhia.org> 
    Project: psi
    Package: org.muhia.app.psi.portal.service.mail.impl
    Date: 03-Jan-17.
*/
@Service
public class AccessService implements IAccessService {
    @Autowired
    private ExternalProperties properties;
    @Override
    public boolean isEmailApproved(String email) {
        AccessDTO accessDTO = createAccessDTO(email);
        return accessDTO.isApproved();
    }

    @Override
    public AccessDTO createAccessDTO(String email) {
        AccessDTO accessDTO = getEmailDomain(email);
        if (accessDTO.isValid()) {
            String domain = accessDTO.getDomain();
            int startIndex = 0;
            int nextIndex = domain.indexOf('.');
            int lastIndex = domain.lastIndexOf('.');
            while (nextIndex < lastIndex) {
                startIndex = nextIndex + 1;
                nextIndex = domain.indexOf('.', startIndex);
            }
            if (startIndex > 0) {
                accessDTO.setDomain(domain.substring(startIndex));
            } else {
                accessDTO.setDomain(domain);
            }
            accessDTO.setApproved(!isDomainBlacklisted(accessDTO.getDomain()));
        }
        Logger.getLogger(this.getClass().getName()).fine(accessDTO.toString());
        return accessDTO;
    }

    private AccessDTO getEmailDomain(String email) {
        AccessDTO accessDTO = new AccessDTO(email);
        int ampersand = email.indexOf("@");
        if (ampersand > 0) {
            accessDTO.setDomain(email.substring(ampersand + 1));
            if (accessDTO.getDomain().contains("."))
                accessDTO.setValid(true);
        }
        return accessDTO;
    }

    private List<String> blackListedDomains() {
        return Arrays.asList(properties.getBlacklistedEmailEndswith());
    }

    private List<String> overrideDomains() {
        return Arrays.asList(properties.getBlacklistedEmailOverrides());
    }

    private boolean isDomainBlacklisted(String domain) {
        boolean isBlacklisted = false;
        for (String blacklistedDomain :
                blackListedDomains()) {
            if (domain.endsWith(blacklistedDomain))
                isBlacklisted = true;
        }
        for (String overrideDomain :
                overrideDomains()) {
            if (domain.endsWith(overrideDomain))
                isBlacklisted = false;
        }
        return isBlacklisted;
    }
}
