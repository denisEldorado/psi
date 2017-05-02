package org.muhia.app.psi.infra.dto;

import org.springframework.stereotype.Component;

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
/*
  Created by Kenneth Muhia <muhia@muhia.org>
  Project: psi
  Package: org.muhia.app.psi.integ.config.ke.shared
  Generated on: 12-Feb-17, 10:25.
 */
@Component
public class SharedDataDTO {
    private String transportUsername;
    private String transportPassword;

    public SharedDataDTO() {
        this.transportUsername = "test";
        this.transportPassword = "test";
    }

    public String getTransportUsername() {
        return transportUsername;
    }

    public void setTransportUsername(String transportUsername) {
        this.transportUsername = transportUsername;
    }

    public String getTransportPassword() {
        return transportPassword;
    }

    public void setTransportPassword(String transportPassword) {
        this.transportPassword = transportPassword;
    }
}
