package org.muhia.app.psi.config.integ.properties;
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
  Created by KennethKZMMuhia
  Project: psi
  Package: org.muhia.app.psi.config.integ.properties
  Generated on 30-Dec-16.
 */
@Configuration
@PropertySource(value = {"file:${CONFIG_PATH}/obopayke.properties"})
//@ConfigurationProperties(prefix = "org.muhia.app.psi.integ.ke.obopay")
public class ObopayKeProperties {
    @Value("${org.muhia.app.psi.integ.ke.obopay.targetEndpoint}")
    private String targetEndpoint;
    @Value("${org.muhia.app.psi.integ.ke.obopay.userName}")
    private String userName;
    @Value("${org.muhia.app.psi.integ.ke.obopay.password}")
    private String password;
    @Value("${org.muhia.app.psi.integ.ke.obopay.partnerId}")
    private String partnerId;
    @Value("${org.muhia.app.psi.integ.ke.obopay.encryptionKey}")
    private String encryptionKey;
    @Value("${org.muhia.app.psi.integ.ke.obopay.contextPath}")
    private String contextPath;
    @Value("${org.muhia.app.psi.integ.ke.obopay.marshaller.packages.to.scan}")
    private String marshallerPackagesToScan;
    @Value("${org.muhia.app.psi.integ.ke.obopay.unmarshaller.packages.to.scan}")
    private String unMarshallerPackagesToScan;

    @Value("${org.muhia.app.psi.integ.ke.obopay.cashintransactioncode}")
    private String cashInTransactionCode;

    @Value("${org.muhia.app.psi.integ.ke.obopay.cashouttransactioncode}")
    private String cashOutTransactionCode;
    @Value("${org.muhia.app.psi.integ.ke.obopay.currencytype}")
    private String currencyType;
    @Value("${org.muhia.app.psi.integ.ke.obopay.cashinout.processorcode}")
    private String processorCode;
    @Value("${org.muhia.app.psi.integ.ke.obopay.instrumenttype}")
    private String instrumentType;
    @Value("${org.muhia.app.psi.integ.ke.obopay.feeamount}")
    private String feeAmount;
    @Value("${org.muhia.app.psi.integ.ke.obopay.serviceSoapAction}")
    private String serviceSoapAction;

    @Value("${org.muhia.app.psi.integ.ke.obopay.balance.processorcode}")
    private String balanceProcessorCode;

    @Value("${org.muhia.app.psi.integ.ke.obopay.balance.transactioncode}")
    private String balanceTransactionCode;
    @Value("${org.muhia.app.psi.integ.ke.obopay.api.type.request.keyword}")
    private String apiIdRequestKeyword;
    @Value("${org.muhia.app.psi.integ.ke.obopay.api.type.response.keyword}")
    private String apiIdResponseKeyword;

    public String getTargetEndpoint() {
        return targetEndpoint;
    }

    public void setTargetEndpoint(String targetEndpoint) {
        this.targetEndpoint = targetEndpoint;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getEncryptionKey() {
        return encryptionKey;
    }

    public void setEncryptionKey(String encryptionKey) {
        this.encryptionKey = encryptionKey;
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public String getMarshallerPackagesToScan() {
        return marshallerPackagesToScan;
    }

    public void setMarshallerPackagesToScan(String marshallerPackagesToScan) {
        this.marshallerPackagesToScan = marshallerPackagesToScan;
    }

    public String getUnMarshallerPackagesToScan() {
        return unMarshallerPackagesToScan;
    }

    public void setUnMarshallerPackagesToScan(String unMarshallerPackagesToScan) {
        this.unMarshallerPackagesToScan = unMarshallerPackagesToScan;
    }

    public String getCashInTransactionCode() {
        return cashInTransactionCode;
    }

    public void setCashInTransactionCode(String cashInTransactionCode) {
        this.cashInTransactionCode = cashInTransactionCode;
    }

    public String getCashOutTransactionCode() {
        return cashOutTransactionCode;
    }

    public void setCashOutTransactionCode(String cashOutTransactionCode) {
        this.cashOutTransactionCode = cashOutTransactionCode;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public String getProcessorCode() {
        return processorCode;
    }

    public void setProcessorCode(String processorCode) {
        this.processorCode = processorCode;
    }

    public String getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(String instrumentType) {
        this.instrumentType = instrumentType;
    }

    public String getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(String feeAmount) {
        this.feeAmount = feeAmount;
    }

    public String getServiceSoapAction() {
        return serviceSoapAction;
    }

    public void setServiceSoapAction(String serviceSoapAction) {
        this.serviceSoapAction = serviceSoapAction;
    }

    public String getBalanceProcessorCode() {
        return balanceProcessorCode;
    }

    public void setBalanceProcessorCode(String balanceProcessorCode) {
        this.balanceProcessorCode = balanceProcessorCode;
    }

    public String getBalanceTransactionCode() {
        return balanceTransactionCode;
    }

    public void setBalanceTransactionCode(String balanceTransactionCode) {
        this.balanceTransactionCode = balanceTransactionCode;
    }

    public String getApiIdRequestKeyword() {
        return apiIdRequestKeyword;
    }

    public void setApiIdRequestKeyword(String apiIdRequestKeyword) {
        this.apiIdRequestKeyword = apiIdRequestKeyword;
    }

    public String getApiIdResponseKeyword() {
        return apiIdResponseKeyword;
    }

    public void setApiIdResponseKeyword(String apiIdResponseKeyword) {
        this.apiIdResponseKeyword = apiIdResponseKeyword;
    }
}
