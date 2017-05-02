package org.muhia.app.psi.config.integ.properties.shared;
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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/*
  Created by Kenneth Muhia <muhia@muhia.org>
  Project: psi
  Package: org.muhia.app.psi.config.integ
  Generated on: 11-Feb-17, 12:09.
 */
@Configuration
@PropertySource(value = "file:${CONFIG_PATH}/shared-ws-client.properties")
public class SharedWsClientProperties {
    @Value("${org.muhia.psi.config.wsdl.shared.keystore.path}")
    private String sharedKeystorePath;
    @Value("${org.muhia.psi.config.wsdl.shared.keystore.password}")
    private String sharedKeystorePassword;
    @Value("${org.muhia.psi.config.wsdl.shared.transport.read.timeout}")
    private int sharedTransportReadTimeout;
    @Value("${org.muhia.psi.config.wsdl.shared.transport.connection.timeout}")
    private int sharedTransportConnectionTimeout;
    @Value("${org.muhia.psi.config.wsdl.shared.transport.connection.requestTimeout}")
    private int sharedTransportConnectionRequestTimeout;
    @Value("${org.muhia.psi.config.wsdl.shared.pool.max.host}")
    private int sharedPoolMaxHost;
    @Value("${org.muhia.psi.config.wsdl.shared.pool.defaultmax.perhost}")
    private int sharedPoolDefaultmaxPerhost;
    @Value("${org.muhia.psi.config.wsdl.shared.pool.validate.afterInactivity}")
    private int sharedPoolValidateAfterInactivity;


    public String getSharedKeystorePath() {
        return sharedKeystorePath;
    }

    public String getSharedKeystorePassword() {
        return sharedKeystorePassword;
    }

    public int getSharedTransportReadTimeout() {
        return sharedTransportReadTimeout;
    }

    public int getSharedTransportConnectionTimeout() {
        return sharedTransportConnectionTimeout;
    }

    public int getSharedTransportConnectionRequestTimeout() {
        return sharedTransportConnectionRequestTimeout;
    }

    public int getSharedPoolMaxHost() {
        return sharedPoolMaxHost;
    }

    public int getSharedPoolDefaultmaxPerhost() {
        return sharedPoolDefaultmaxPerhost;
    }

    public int getSharedPoolValidateAfterInactivity() {
        return sharedPoolValidateAfterInactivity;
    }
}
