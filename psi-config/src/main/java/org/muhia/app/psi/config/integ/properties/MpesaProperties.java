package org.muhia.app.psi.config.integ.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.math.BigInteger;

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
    Created by mathenge
    Project: psi
    Package: ${PACKAGE_NAME}
    Generated on: 1/30/17.
*/
@Configuration
@PropertySource(value = {"file:${CONFIG_PATH}/mpesa.properties"})
public class MpesaProperties {
    @Value("${org.muhia.app.psi.integ.ke.mpesa.serviceId}")
    private String serviceId;
    @Value("${org.muhia.app.psi.integ.ke.mpesa.initiatorUsername}")
    private String initiatorUsername;
    @Value("${org.muhia.app.psi.integ.ke.mpesa.initiatorPassword}")
    private String initiatorPassword;
    @Value("${org.muhia.app.psi.integ.ke.mpesa.shortCode}")
    private String shortCode;
    @Value("${org.muhia.app.psi.integ.ke.mpesa.spId}")
    private String spId;
    @Value("${org.muhia.app.psi.integ.ke.mpesa.spPassword}")
    private String spPassword;
    @Value("${org.muhia.app.psi.integ.ke.mpesa.commandID}")
    private String commandId;
    @Value("${org.muhia.app.psi.integ.ke.mpesa.languageCode}")
    private String languageCode;
    @Value("${org.muhia.app.psi.integ.ke.mpesa.callerType}")
    private BigInteger callerType;
    @Value("${org.muhia.app.psi.integ.ke.mpesa.resultUrl}")
    private String resultUrl;
    @Value("${org.muhia.app.psi.integ.ke.mpesa.brokerEndPoint}")
    private String brokerEndPoint;
    @Value("${org.muhia.app.psi.integ.ke.mpesa.marshaller.packages.to.scan}")
    private String marshallerPackagesToScan;
    @Value("${org.muhia.app.psi.integ.ke.mpesa.unmarshaller.packages.to.scan}")
    private String unMarshallerPackagesToScan;
    @Value("${org.muhia.app.psi.integ.ke.mpesa.request.xsd.path}")
    private String mpesaRequestXsdPath;
    @Value("${org.muhia.app.psi.integ.ke.mpesa.registerUrlCommandId}")
    private String registerUrlCommandId;
    @Value("${org.muhia.app.psi.integ.ke.mpesa.originatorConversationId}")
    private String originatorConversationId;
    @Value("${org.muhia.app.psi.integ.ke.mpesa.register.ResponseType}")
    private String registerUrlResponseType;
    @Value("${org.muhia.app.psi.integ.ke.mpesa.register.ResponseType.value}")
    private String registerUrlResponseTypeValue;
    @Value("${org.muhia.app.psi.integ.ke.mpesa.register.validationUrl.key}")
    private String registerValidationURLKey;
    @Value("${org.muhia.app.psi.integ.ke.mpesa.register.validationUrl.value}")
    private String registerValidationURLValue;
    @Value("${org.muhia.app.psi.integ.ke.mpesa.register.confirmationUrl.key}")
    private String registerConfirmationURLKey;
    @Value("${org.muhia.app.psi.integ.ke.mpesa.register.confirmationUrl.value}")
    private String registerConfirmationURLValue;
    @Value("${org.muhia.app.psi.integ.ke.mpesa.registerUrl.callerType}")
    private BigInteger registerUrlCallerType;
    @Value("${org.muhia.app.psi.integ.ke.mpesa.registerUrl.identity.identifierType}")
    private BigInteger registerUrlIdentityIdentifierType;
    @Value("${org.muhia.app.psi.integ.ke.mpesa.registerUrl.keyOwner}")
    private BigInteger registerUrlKeyOwner;
    @Value("${org.muhia.app.psi.integ.ke.mpesa.registerUrl.endPoint}")
    private String registerUrlEndPoint;
    @Value("${org.muhia.psi.config.wsdl.mpesa.sdf.header.timestamp}")
    private String mpesaSdfHeaderTimestamp;
    @Value("${org.muhia.psi.config.wsdl.ke.mpesa.short.code}")
    private String keMpesaShortCode;
    @Value("${org.muhia.psi.config.wsdl.ke.mpesa.sdfRequest.timestamp}")
    private String keMpesaSdfRequestTimestamp;
    @Value("${org.muhia.psi.config.wsdl.mpesa.commandId.transactionStatus.query}")
    private String mpesaCommandIdTransactionStatusQuery;
    @Value("${org.muhia.psi.config.wsdl.mpesa.sdf.unique.timestamp}")
    private String mpesaSdfUniqueTimestamp;
    @Value("${org.muhia.psi.config.wsdl.ke.mpesa.3rd.partyId}")
    private String keMpesa3rdPartyId;
    @Value("${org.muhia.psi.config.wsdl.ke.mpesa.3rd.password}")
    private String keMpesa3rdPartyPassword;
    @Value("${org.muhia.psi.config.wsdl.ke.request.initiator.identifier}")
    private String keRequestInitiatorIdentifier;
    @Value("${org.muhia.psi.config.wsdl.ke.request.initiator.securityCredential}")
    private String keRequestInitiatorSecurityCredential;
    @Value("${org.muhia.psi.config.wsdl.ke.request.receiverParty.identifierType}")
    private int keRequestReceiverPartyIdentifierType;
    @Value("${org.muhia.psi.config.wsdl.ke.request.receiverParty.identifier}")
    private String keRequestReceiverPartyIdentifier;
    @Value("${org.muhia.psi.config.wsdl.ke.request.transaction.remark}")
    private String keRequestTransactionRemark;
    @Value("${org.muhia.psi.config.wsdl.ke.mpesa.request.keyOwner}")
    private int keMpesaRequestKeyOwner;
    @Value("${org.muhia.app.psi.integ.ke.mpesa.identity.primaryparty.identifierType}")
    private BigInteger primaryIdentifierType;
    @Value("${org.muhia.app.psi.integ.ke.mpesa.identity.receiverparty.identifierType}")
    private BigInteger receiverPartyIdentifierType;
    @Value("${org.muhia.psi.config.wsdl.mpesa.commandid.PromotionPayment}")
    private String mpesaCommandIdPromotionPayment;
    @Value("${org.muhia.psi.config.wsdl.mpesa.commandid.SalaryPayment}")
    private String mpesaCommandidSalaryPayment;
    @Value("${org.muhia.psi.config.wsdl.mpesa.commandid.BusinessPayment}")
    private String mpesaCommandidBusinessPayment;
    @Value("${org.muhia.psi.config.wsdl.mpesa.commandid.BusinessPaymentWithWithdrawalChargePaid}")
    private String mpesaCommandidBusinessPaymentWithWithdrawalChargePaid;
    @Value("${org.muhia.psi.config.wsdl.mpesa.commandid.SalaryPaymentWithWithdrawalChargePaid}")
    private String mpesaCommandidSalaryPaymentWithWithdrawalChargePaid;
    //    @Value("${org.muhia.psi.config.wsdl.mpesa.commandid.PromotionPayment}") private  String mpesaCommandidPromotionPayment;
    @Value("${org.muhia.psi.config.wsdl.mpesa.commandid.TransferFromBankToCustomer}")
    private String mpesaCommandidTransferFromBankToCustomer;
    @Value("${org.muhia.psi.config.wsdl.mpesa.query.timeout.url}")
    private String mpesaQueryTimeoutUrl;
    @Value("${org.muhia.psi.config.wsdl.mpesa.request.identity.checksum}")
    private String mpesaRequestIdentityChecksum;
    @Value("${org.muhia.psi.config.wsdl.ke.request.accessDevice.identifierType}")
    private String keRequestAccessDeviceIdentifierType;
    @Value("${org.muhia.psi.config.wsdl.ke.request.accessDevice.identifier}")
    private String keRequestAccessDeviceIdentifier;
    @Value("${org.muhia.psi.config.wsdl.ke.registerurl.result.endpoint}")
    private String registerUrlRlEndpoint;
    @Value("${org.muhia.psi.config.wsdl.ke.registerurl.result.localport}")
    private String registerUrlLocalPort;

    public String getRegisterUrlLocalPort() {
        return registerUrlLocalPort;
    }

    public String getRegisterUrlRlEndpoint() {
        return registerUrlRlEndpoint;
    }

    public String getServiceId() {
        return serviceId;
    }

    public String getInitiatorUsername() {
        return initiatorUsername;
    }

    public String getInitiatorPassword() {
        return initiatorPassword;
    }

    public String getShortCode() {
        return shortCode;
    }

    public String getSpId() {
        return spId;
    }

    public String getSpPassword() {
        return spPassword;
    }

    public String getCommandId() {
        return commandId;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public BigInteger getCallerType() {
        return callerType;
    }

    public String getResultUrl() {
        return resultUrl;
    }

    public String getBrokerEndPoint() {
        return brokerEndPoint;
    }

    public String getMarshallerPackagesToScan() {
        return marshallerPackagesToScan;
    }

    public String getUnMarshallerPackagesToScan() {
        return unMarshallerPackagesToScan;
    }

    public String getMpesaRequestXsdPath() {
        return mpesaRequestXsdPath;
    }

    public String getRegisterUrlCommandId() {
        return registerUrlCommandId;
    }

    public String getOriginatorConversationId() {
        return originatorConversationId;
    }

    public String getRegisterUrlResponseType() {
        return registerUrlResponseType;
    }


    public String getRegisterUrlResponseTypeValue() {
        return registerUrlResponseTypeValue;
    }


    public String getRegisterValidationURLKey() {
        return registerValidationURLKey;
    }


    public String getRegisterValidationURLValue() {
        return registerValidationURLValue;
    }


    public String getRegisterConfirmationURLKey() {
        return registerConfirmationURLKey;
    }

    public String getRegisterConfirmationURLValue() {
        return registerConfirmationURLValue;
    }

    public BigInteger getRegisterUrlCallerType() {
        return registerUrlCallerType;
    }

    public BigInteger getRegisterUrlIdentityIdentifierType() {
        return registerUrlIdentityIdentifierType;
    }

    public BigInteger getRegisterUrlKeyOwner() {
        return registerUrlKeyOwner;
    }

    public String getRegisterUrlEndPoint() {
        return registerUrlEndPoint;
    }

    public String getMpesaSdfHeaderTimestamp() {
        return mpesaSdfHeaderTimestamp;
    }

    public String getKeMpesaShortCode() {
        return keMpesaShortCode;
    }

    public String getKeMpesaSdfRequestTimestamp() {
        return keMpesaSdfRequestTimestamp;
    }

    public String getMpesaCommandIdTransactionStatusQuery() {
        return mpesaCommandIdTransactionStatusQuery;
    }

    public String getMpesaSdfUniqueTimestamp() {
        return mpesaSdfUniqueTimestamp;
    }

    public String getKeMpesa3rdPartyId() {
        return keMpesa3rdPartyId;
    }

    public String getKeMpesa3rdPartyPassword() {
        return keMpesa3rdPartyPassword;
    }

    public String getKeRequestInitiatorIdentifier() {
        return keRequestInitiatorIdentifier;
    }

    public String getKeRequestInitiatorSecurityCredential() {
        return keRequestInitiatorSecurityCredential;
    }

    public int getKeRequestReceiverPartyIdentifierType() {
        return keRequestReceiverPartyIdentifierType;
    }

    public String getKeRequestReceiverPartyIdentifier() {
        return keRequestReceiverPartyIdentifier;
    }

    public String getKeRequestTransactionRemark() {
        return keRequestTransactionRemark;
    }

    public int getKeMpesaRequestKeyOwner() {
        return keMpesaRequestKeyOwner;
    }

    public BigInteger getPrimaryIdentifierType() {
        return primaryIdentifierType;
    }

    public BigInteger getReceiverPartyIdentifierType() {
        return receiverPartyIdentifierType;
    }

    public String getMpesaCommandidSalaryPayment() {
        return mpesaCommandidSalaryPayment;
    }

    public String getMpesaCommandidBusinessPayment() {
        return mpesaCommandidBusinessPayment;
    }

    public String getMpesaCommandidBusinessPaymentWithWithdrawalChargePaid() {
        return mpesaCommandidBusinessPaymentWithWithdrawalChargePaid;
    }

    public String getMpesaCommandidSalaryPaymentWithWithdrawalChargePaid() {
        return mpesaCommandidSalaryPaymentWithWithdrawalChargePaid;
    }


    public String getMpesaCommandidTransferFromBankToCustomer() {
        return mpesaCommandidTransferFromBankToCustomer;
    }

    public String getMpesaQueryTimeoutUrl() {
        return mpesaQueryTimeoutUrl;
    }

    public String getMpesaRequestIdentityChecksum() {
        return mpesaRequestIdentityChecksum;
    }

    public String getKeRequestAccessDeviceIdentifierType() {
        return keRequestAccessDeviceIdentifierType;
    }

    public String getKeRequestAccessDeviceIdentifier() {
        return keRequestAccessDeviceIdentifier;
    }

    public String getMpesaCommandIdPromotionPayment() {
        return mpesaCommandIdPromotionPayment;
    }

    public void setMpesaCommandIdPromotionPayment(String mpesaCommandIdPromotionPayment) {
        this.mpesaCommandIdPromotionPayment = mpesaCommandIdPromotionPayment;
    }
}

