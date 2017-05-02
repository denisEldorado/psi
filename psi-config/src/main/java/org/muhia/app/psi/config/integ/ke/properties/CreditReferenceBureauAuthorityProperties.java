package org.muhia.app.psi.config.integ.ke.properties;

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
    Package: org.muhia.app.psi.config.integ.properties
    Generated on: 05-Feb-17.
*/
@Configuration
@PropertySource(value = {"file:${CONFIG_PATH}/crba-ke.properties"})
public class CreditReferenceBureauAuthorityProperties {
    @Value("${org.muhia.psi.config.wsdl.crba.transunion.url}")
    private String crbaTransunionUrl;
    @Value("${org.muhia.psi.config.wsdl.crba.transunion.username}")
    private String crbaTransunionUsername;
    @Value("${org.muhia.psi.config.wsdl.crba.transunion.password}")
    private String crbaTransunionPassword;
    @Value("${org.muhia.psi.config.wsdl.crba.transunion.maintain.session}")
    private String crbaTransunionMaintainSession;
    @Value("${org.muhia.psi.config.wsdl.crba.transunion.code}")
    private String crbaTransunionCode;
    @Value("${org.muhia.psi.config.wsdl.crba.transunion.infinity.code}")
    private String crbaTransunionInfinityCode;
    @Value("${org.muhia.psi.config.wsdl.crba.transunion.marshaller.context}")
    private String crbaTransunionMarshallerContext;
    @Value("${org.muhia.psi.config.wsdl.crba.transunion.unmarshaller.context}")
    private String crbaTransunionUnmarshallerContext;
    @Value("${org.muhia.psi.config.wsdl.crba.transunion.crb.name}")
    private String crbaTransunionCrbName;
    @Value("${org.muhia.psi.config.wsdl.crba.transunion.pdf.id}")
    private String crbaTransunionPdfId;
    @Value("${org.muhia.psi.config.wsdl.crba.transunion.report.date}")
    private String crbaTransunionReportDate;
    @Value("${org.muhia.psi.config.wsdl.crba.transunion.report.type}")
    private String crbaTransunionReportType;
    @Value("${org.muhia.psi.config.wsdl.crba.transunion.requester}")
    private String crbaTransunionRequester;
    @Value("${org.muhia.psi.config.wsdl.crba.transunion.transport.username}")
    private String crbaTransunionTransportUsername;
    @Value("${org.muhia.psi.config.wsdl.crba.transunion.transport.password}")
    private String crbaTransunionTransportPassword;
    @Value("${org.muhia.psi.config.wsdl.crba.transunion.securement.actions}")
    private String crbaTransunionSecurementActions;
    @Value("${org.muhia.psi.config.wsdl.crba.transunion.validation.actions}")
    private String crbaTransunionValidationActions;
    @Value("${org.muhia.psi.config.wsdl.crba.transport.read.timeout}")
    private int crbaTransportReadTimeout;
    @Value("${org.muhia.psi.config.wsdl.crba.transport.connection.timeout}")
    private int crbaTransportConnectionTimeout;
    @Value("${org.muhia.psi.config.wsdl.crba.transport.connection.requestTimeout}")
    private int crbaTransportConnectionRequestTimeout;
    @Value("${org.muhia.psi.config.wsdl.crba.pool.max.host}")
    private int crbaPoolMaxHost;
    @Value("${org.muhia.psi.config.wsdl.crba.pool.defaultmax.perhost}")
    private int crbaPoolDefaultmaxPerhost;
    @Value("${org.muhia.psi.config.wsdl.crba.pool.validate.afterInactivity}")
    private int crbaPoolValidateAfterInactivity;






    public String getCrbaTransunionUrl() {
        return crbaTransunionUrl;
    }

    public String getCrbaTransunionUsername() {
        return crbaTransunionUsername;
    }

    public String getCrbaTransunionPassword() {
        return crbaTransunionPassword;
    }

    public String getCrbaTransunionMaintainSession() {
        return crbaTransunionMaintainSession;
    }

    public String getCrbaTransunionCode() {
        return crbaTransunionCode;
    }

    public String getCrbaTransunionInfinityCode() {
        return crbaTransunionInfinityCode;
    }

    public String getCrbaTransunionMarshallerContext() {
        return crbaTransunionMarshallerContext;
    }

    public String getCrbaTransunionUnmarshallerContext() {
        return crbaTransunionUnmarshallerContext;
    }

    public String getCrbaTransunionCrbName() {
        return crbaTransunionCrbName;
    }

    public String getCrbaTransunionPdfId() {
        return crbaTransunionPdfId;
    }

    public String getCrbaTransunionReportDate() {
        return crbaTransunionReportDate;
    }

    public String getCrbaTransunionReportType() {
        return crbaTransunionReportType;
    }

    public String getCrbaTransunionRequester() {
        return crbaTransunionRequester;
    }

    public String getCrbaTransunionTransportUsername() {
        return crbaTransunionTransportUsername;
    }

    public String getCrbaTransunionTransportPassword() {
        return crbaTransunionTransportPassword;
    }

    public String getCrbaTransunionSecurementActions() {
        return crbaTransunionSecurementActions;
    }

    public String getCrbaTransunionValidationActions() {
        return crbaTransunionValidationActions;
    }

    public int getCrbaTransportReadTimeout() {
        return crbaTransportReadTimeout;
    }

    public int getCrbaTransportConnectionTimeout() {
        return crbaTransportConnectionTimeout;
    }

    public int getCrbaTransportConnectionRequestTimeout() {
        return crbaTransportConnectionRequestTimeout;
    }

    public int getCrbaPoolMaxHost() {
        return crbaPoolMaxHost;
    }

    public int getCrbaPoolDefaultmaxPerhost() {
        return crbaPoolDefaultmaxPerhost;
    }

    public int getCrbaPoolValidateAfterInactivity() {
        return crbaPoolValidateAfterInactivity;
    }
}
