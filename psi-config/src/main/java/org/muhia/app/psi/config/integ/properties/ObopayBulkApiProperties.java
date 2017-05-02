package org.muhia.app.psi.config.integ.properties;/**
 * Copyright 2015-2016 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p>
 * <p>
 * Generated on 30-Oct-16 01:30
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by KennethKZMMuhia
 * Project: psi
 * Package: org.muhia.app.psi.config.integ.properties
 * Generated on: 14-Apr-17, 11:22
 */
@Configuration
@PropertySource(value = {"file:${CONFIG_PATH}/obopay-ke-bulk-api.properties"})
public class ObopayBulkApiProperties {
    @Value("${org.muhia.app.psi.integ.ke.airtelmoney.endpoint.directdebit.production.url}")
    private String endpointDirectdebitProductionUrl;
    @Value("${org.muhia.app.psi.integ.ke.airtelmoney.endpoint.directdebit.test.url}")
    private String endpointDirectdebitTestUrl;
    @Value("${org.muhia.app.psi.integ.ke.airtelmoney.endpoint.directdebit.production.username}")
    private String endpointDirectdebitProductionUsername;
    @Value("${org.muhia.app.psi.integ.ke.airtelmoney.endpoint.bulkpayment.production.nickname}") private  String endpointBulkpaymentProductionNickname;
    @Value("${org.muhia.app.psi.integ.ke.airtelmoney.sdf.unique.timestamp}") private  String sdfUniqueTimestamp;


    @Value("${org.muhia.app.psi.integ.ke.airtelmoney.endpoint.directdebit.test.username}")
    private String endpointDirectdebitTestUsername;
    @Value("${org.muhia.app.psi.integ.ke.airtelmoney.endpoint.directdebit.production.password}")
    private String endpointDirectdebitProductionPassword;
    @Value("${org.muhia.app.psi.integ.ke.airtelmoney.endpoint.directdebit.test.password}")
    private String endpointDirectdebitTestPassword;
    @Value("${org.muhia.app.psi.integ.ke.airtelmoney.endpoint.directdebit.merchant.msisdn}")
    private String endpointDirectdebitMerchantMsisdn;
    @Value("${org.muhia.app.psi.integ.ke.airtelmoney.endpoint.bulkpayment.production.url}")
    private String endpointBulkpaymentProductionUrl;
    @Value("${org.muhia.app.psi.integ.ke.airtelmoney.endpoint.bulkpayment.test.url}")
    private String endpointBulkpaymentTestUrl;
    @Value("${org.muhia.app.psi.integ.ke.airtelmoney.endpoint.bulkpayment.production.username}")
    private String endpointBulkpaymentProductionUsername;
    @Value("${org.muhia.app.psi.integ.ke.airtelmoney.endpoint.bulkpayment.test.username}")
    private String endpointBulkpaymentTestUsername;
    @Value("${org.muhia.app.psi.integ.ke.airtelmoney.endpoint.bulkpayment.production.password}")
    private String endpointBulkpaymentProductionPassword;
    @Value("${org.muhia.app.psi.integ.ke.airtelmoney.endpoint.bulkpayment.test.password}")
    private String endpointBulkpaymentTestPassword;
    @Value("${org.muhia.app.psi.integ.ke.airtelmoney.endpoint.bulkpayment.merchant.msisdn}")
    private String endpointBulkpaymentMerchantMsisdn;
    @Value("${org.muhia.app.psi.integ.ke.airtelmoney.directdebit.marshaller.packages.toscan}")
    private String directdebitMarshallerPackagesToscan;
    @Value("${org.muhia.app.psi.integ.ke.airtelmoney.directdebit.unmarshaller.packages.toscan}")
    private String directdebitUnmarshallerPackagesToscan;
    @Value("${org.muhia.app.psi.integ.ke.airtelmoney.bulkpayment.marshaller.packages.toscan}")
    private String bulkpaymentMarshallerPackagesToscan;
    @Value("${org.muhia.app.psi.integ.ke.airtelmoney.bulkpayment.unmarshaller.packages.toscan}")
    private String bulkpaymentUnmarshallerPackagesToscan;
    @Value("${org.muhia.app.psi.integ.ke.airtelmoney.securement.actions}")
    private String securementActions;
    @Value("${org.muhia.app.psi.integ.ke.airtelmoney.securement.transport.username}")
    private String securementTransportUsername;
    @Value("${org.muhia.app.psi.integ.ke.airtelmoney.securement.transport.password}")
    private String securementTransportPassword;
    @Value("${org.muhia.app.psi.integ.ke.airtelmoney.transport.connection.timeout}")
    private int transportConnectionTimeout;
    @Value("${org.muhia.app.psi.integ.ke.airtelmoney.transport.socket.timeout}") private  int transportSocketTimeout;

    @Value("${org.muhia.app.psi.integ.ke.airtelmoney.transport.connection.request.timeout}")
    private int transportConnectionRequestTimeout;
    @Value("${org.muhia.app.psi.integ.ke.airtelmoney.transport.read.timeout}")
    private int transportReadTimeout;
    @Value("${org.muhia.app.psi.integ.ke.airtelmoney.pool.host.max}")
    private int poolHostMax;
    @Value("${org.muhia.app.psi.integ.ke.airtelmoney.pool.default.max.perhost}")
    private int poolDefaultMaxPerhost;
    @Value("${org.muhia.app.psi.integ.ke.airtelmoney.pool.validate.after.activity}")
    private int poolValidateAfterActivity;

    @Value("${org.muhia.app.psi.integ.ke.airtelmoney.request.keyword.nickname}")
    private String requestKeywordNickname;
    @Value("${org.muhia.app.psi.integ.ke.airtelmoney.request.keyword.username}")
    private String requestKeywordUsername;
    @Value("${org.muhia.app.psi.integ.ke.airtelmoney.request.keyword.password}")
    private String requestKeywordPassword;
    @Value("${org.muhia.app.psi.integ.ke.airtelmoney.request.keyword.reference.id}")
    private String requestKeywordReferenceId;
    @Value("${org.muhia.app.psi.integ.ke.airtelmoney.request.keyword.narrative}")
    private String requestKeywordNarrative;
    @Value("${org.muhia.app.psi.integ.ke.airtelmoney.request.keyword.customer.msisdn}")
    private String requestKeywordCustomerMsisdn;
    @Value("${org.muhia.app.psi.integ.ke.airtelmoney.request.keyword.batch.ref}")
    private String requestKeywordBatchRef;
    @Value("${org.muhia.app.psi.integ.ke.airtelmoney.request.keyword.amount}")
    private String requestKeywordAmount;




    public String getEndpointDirectdebitProductionUrl() {
        return endpointDirectdebitProductionUrl;
    }

    public String getEndpointDirectdebitTestUrl() {
        return endpointDirectdebitTestUrl;
    }

    public String getEndpointDirectdebitProductionUsername() {
        return endpointDirectdebitProductionUsername;
    }

    public String getEndpointDirectdebitTestUsername() {
        return endpointDirectdebitTestUsername;
    }

    public String getEndpointDirectdebitProductionPassword() {
        return endpointDirectdebitProductionPassword;
    }

    public String getEndpointDirectdebitTestPassword() {
        return endpointDirectdebitTestPassword;
    }

    public String getEndpointDirectdebitMerchantMsisdn() {
        return endpointDirectdebitMerchantMsisdn;
    }

    public String getEndpointBulkpaymentProductionUrl() {
        return endpointBulkpaymentProductionUrl;
    }

    public String getEndpointBulkpaymentTestUrl() {
        return endpointBulkpaymentTestUrl;
    }

    public String getEndpointBulkpaymentProductionUsername() {
        return endpointBulkpaymentProductionUsername;
    }

    public String getEndpointBulkpaymentTestUsername() {
        return endpointBulkpaymentTestUsername;
    }

    public String getEndpointBulkpaymentProductionPassword() {
        return endpointBulkpaymentProductionPassword;
    }

    public String getEndpointBulkpaymentTestPassword() {
        return endpointBulkpaymentTestPassword;
    }

    public String getEndpointBulkpaymentMerchantMsisdn() {
        return endpointBulkpaymentMerchantMsisdn;
    }

    public String getDirectdebitMarshallerPackagesToscan() {
        return directdebitMarshallerPackagesToscan;
    }

    public String getDirectdebitUnmarshallerPackagesToscan() {
        return directdebitUnmarshallerPackagesToscan;
    }

    public String getBulkpaymentMarshallerPackagesToscan() {
        return bulkpaymentMarshallerPackagesToscan;
    }

    public String getBulkpaymentUnmarshallerPackagesToscan() {
        return bulkpaymentUnmarshallerPackagesToscan;
    }

    public String getSecurementActions() {
        return securementActions;
    }

    public String getSecurementTransportUsername() {
        return securementTransportUsername;
    }

    public String getSecurementTransportPassword() {
        return securementTransportPassword;
    }

    public int getTransportConnectionTimeout() {
        return transportConnectionTimeout;
    }

    public int getTransportConnectionRequestTimeout() {
        return transportConnectionRequestTimeout;
    }

    public int getTransportReadTimeout() {
        return transportReadTimeout;
    }

    public int getPoolHostMax() {
        return poolHostMax;
    }

    public int getPoolDefaultMaxPerhost() {
        return poolDefaultMaxPerhost;
    }

    public int getPoolValidateAfterActivity() {
        return poolValidateAfterActivity;
    }

    public int getTransportSocketTimeout() {
        return transportSocketTimeout;
    }

    public String getEndpointBulkpaymentProductionNickname() {
        return endpointBulkpaymentProductionNickname;
    }

    public String getSdfUniqueTimestamp() {
        return sdfUniqueTimestamp;
    }

    /**
     * Payement Request Parameters
     */
    public String getRequestKeywordNickname() {
        return requestKeywordNickname;
    }

    public String getRequestKeywordUsername() {
        return requestKeywordUsername;
    }

    public String getRequestKeywordPassword() {
        return requestKeywordPassword;
    }

    public String getRequestKeywordReferenceId() {
        return requestKeywordReferenceId;
    }

    public String getRequestKeywordNarrative() {
        return requestKeywordNarrative;
    }

    public String getRequestKeywordCustomerMsisdn() {
        return requestKeywordCustomerMsisdn;
    }

    public String getRequestKeywordBatchRef() {
        return requestKeywordBatchRef;
    }

    public String getRequestKeywordAmount() {
        return requestKeywordAmount;
    }
}
