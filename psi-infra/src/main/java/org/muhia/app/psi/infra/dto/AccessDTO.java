package org.muhia.app.psi.infra.dto;

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

import java.io.Serializable;

/*
    Created by Kenneth Muhia <muhia@muhia.org> 
    Project: psi
    Package: org.muhia.app.psi.infra.dto
    Date: 03-Jan-17.
*/
public class AccessDTO implements Serializable {
    private boolean isValid;
    private boolean isApproved;
    private String email;
    private String domain;

    public AccessDTO() {
    }

    public AccessDTO(String email) {
        this.setEmail(email);
        this.setValid(false);
        this.setApproved(false);
    }

    @Override
    public String toString() {
        return "AccessDTO{" + "isValid=" + isValid() + ", isApproved='" + isApproved() + '\'' + ", email='" + getEmail() + '\'' + ", domain='" + getDomain() + '\'' + '}';
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
