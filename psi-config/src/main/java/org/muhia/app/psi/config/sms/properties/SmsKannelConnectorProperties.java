/*

  Copyright 2015-2017 the original author or authors.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
 */
package org.muhia.app.psi.config.sms.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 *
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@Configuration
@PropertySource(value = {"file:${CONFIG_PATH}/sms-broker.properties"})
public class SmsKannelConnectorProperties {

    @Value("${org.muhia.psi.sms.gateway.ip}")
    private String ip;
    @Value("${org.muhia.psi.sms.gateway.port}")
    private String port;
    @Value("${org.muhia.psi.sms.gateway.user}")
    private String user;
    @Value("${org.muhia.psi.sms.gateway.psswd}")
    private String credentials;
    @Value("${org.muhia.psi.sms.gateway.sender}")
    private String sender;
    @Value("${org.muhia.psi.sms.gateway.sender.mvno}")
    private String mvnoSender;
    @Value("${org.muhia.psi.sms.gateway.sender.yu}")
    private String yuSender;
    @Value("${org.muhia.psi.sms.gateway.type}")
    private String type;
    @Value("${org.muhia.psi.sms.codes.response.file}")
    private String responseFile;
    @Value("${org.muhia.psi.sms.gateway.countrycode}")
    private String countryCode;
    @Value("${org.muhia.psi.sms.gateway.msisdnlength}")
    private int msisdnLength;
    @Value("${org.muhia.psi.sms.gateway.default.response}")
    private String defaultResponse;
    @Value("${org.muhia.psi.sms.gateway.default.encoding}")
    private String defaultEncoding;
    @Value("${org.muhia.psi.sms.gateway.default.maxretry}")
    private int maxRetry;
    @Value("${org.muhia.psi.sms.response.sms.in.status.init}")
    private int smsInInitStatus;
    @Value("${org.muhia.psi.sms.response.sms.in.status.processing}")
    private int smsInProcessingStatus;
    @Value("${org.muhia.psi.sms.response.sms.in.status.final}")
    private int smsInFinalStatus;
    @Value("${org.muhia.psi.sms.response.sms.in.status.fail}")
    private int smsInFailStatus;
    @Value("${org.muhia.psi.sms.response.sms.out.status.init}")
    private int smsOutInitStatus;
    @Value("${org.muhia.psi.sms.response.sms.out.status.processing}")
    private int smsOutProcessingStatus;
    @Value("${org.muhia.psi.sms.response.sms.out.status.final}")
    private int smsOutFinalStatus;
    @Value("${org.muhia.psi.sms.response.sms.out.status.fail}")
    private int smsOutFailStatus;
    @Value("${org.muhia.psi.sms.response.sms.out.notification.default}")
    private int defaultSmsOutNotification;
    @Value("${org.muhia.psi.sms.response.log.sdf}")
    private String logStandardDateFormat;
    @Value("${org.muhia.psi.sms.gateway.url}")
    private String kannelUrl;
    @Value("${org.muhia.psi.sms.gateway.url.keywords}")
    private String[] kannelUrlKeywords;
    @Value("${org.muhia.psi.sms.response.sms.in.status.response.init}")
    private int smsInInitResponseStatus;
    @Value("${org.muhia.psi.sms.response.sms.in.auto.responseKeyword}")
    private int smsInAutoResponseKeyword;
    @Value("${org.muhia.psi.sms.response.sms.keyword.out}")
    private String smsOutKeyword;
    @Value("${org.muhia.psi.sms.response.sms.keyword.in}")
    private String smsInKeyword;
    @Value("${org.muhia.psi.sms.gateway.default.error.response}")
    private String defaultErrorResponse;
    @Value("${org.muhia.psi.sms.response.sms.app.name.user}")
    private String appUserName;
    @Value("${org.muhia.psi.sms.response.sms.app.name}")
    private String appName;
    @Value("${org.muhia.psi.sms.response.kannel.status.successKeyword}")
    private String kannelSuccessKeyword;
    @Value("${org.muhia.psi.sms.bulksms.user}")
    private String bulkUser;
    @Value("${org.muhia.psi.sms.bulksms.psswd}")
    private String bulkPassword;
    @Value("${org.muhia.psi.sms.bulksms.url}")
    private String bulkUrl;
    @Value("${org.muhia.psi.sms.response.kannel.keyword.separatorKeyword}")
    private String separatorKeyword;
    @Value("${org.muhia.psi.sms.bulksms.single.url}")
    private String singleSmsBulkUrl;
    @Value("${org.muhia.psi.sms.bulksms.encoding}")
    private String bulkEncoding;
    @Value("${org.muhia.psi.sms.bulksms.sender}")
    private String bulkSender;
    @Value("${org.muhia.psi.sms.africastalking.username}")
    private String africasTalkingUsername;
    @Value("${org.muhia.psi.sms.africastalking.sender}")
    private String africasTalkingSender;
    @Value("${org.muhia.psi.sms.africastalking.apiKey}")
    private String africasTalkingApiKey;

    public String getKannelSuccessKeyword() {
        return kannelSuccessKeyword;
    }

    public String getSmsOutKeyword() {
        return smsOutKeyword;
    }

    public String getSmsInKeyword() {
        return smsInKeyword;
    }



    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip the ip to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return the port
     */
    public String getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the credentials
     */
    public String getCredentials() {
        return credentials;
    }

    /**
     * @param credentials the credentials to set
     */
    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    /**
     * @return the sender
     */
    public String getSender() {
        return sender;
    }

    /**
     * @param sender the sender to set
     */
    public void setSender(String sender) {
        this.sender = sender;
    }

    /**
     * @return the mvnoSender
     */
    public String getMvnoSender() {
        return mvnoSender;
    }

    /**
     * @param mvnoSender the mvnoSender to set
     */
    public void setMvnoSender(String mvnoSender) {
        this.mvnoSender = mvnoSender;
    }

    /**
     * @return the yuSender
     */
    public String getYuSender() {
        return yuSender;
    }

    /**
     * @param yuSender the yuSender to set
     */
    public void setYuSender(String yuSender) {
        this.yuSender = yuSender;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the responseFile
     */
    public String getResponseFile() {
        return responseFile;
    }

    /**
     * @param responseFile the responseFile to set
     */
    public void setResponseFile(String responseFile) {
        this.responseFile = responseFile;
    }

    /**
     * @return the countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * @param countryCode the countryCode to set
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * @return the msisdnLength
     */
    public int getMsisdnLength() {
        return msisdnLength;
    }

    /**
     * @param msisdnLength the msisdnLength to set
     */
    public void setMsisdnLength(int msisdnLength) {
        this.msisdnLength = msisdnLength;
    }

    /**
     * @return the defaultResponse
     */
    public String getDefaultResponse() {
        return defaultResponse;
    }

    /**
     * @param defaultResponse the defaultResponse to set
     */
    public void setDefaultResponse(String defaultResponse) {
        this.defaultResponse = defaultResponse;
    }

    /**
     * @return the maxRetry
     */
    public int getMaxRetry() {
        return maxRetry;
    }

    /**
     * @param maxRetry the maxRetry to set
     */
    public void setMaxRetry(int maxRetry) {
        this.maxRetry = maxRetry;
    }

    /**
     * @return the smsInInitStatus
     */
    public int getSmsInInitStatus() {
        return smsInInitStatus;
    }

    /**
     * @param smsInInitStatus the smsInInitStatus to set
     */
    public void setSmsInInitStatus(int smsInInitStatus) {
        this.smsInInitStatus = smsInInitStatus;
    }

    /**
     * @return the smsInFinalStatus
     */
    public int getSmsInFinalStatus() {
        return smsInFinalStatus;
    }

    /**
     * @param smsInFinalStatus the smsInFinalStatus to set
     */
    public void setSmsInFinalStatus(int smsInFinalStatus) {
        this.smsInFinalStatus = smsInFinalStatus;
    }

    /**
     * @return the smsInFailStatus
     */
    public int getSmsInFailStatus() {
        return smsInFailStatus;
    }

    /**
     * @param smsInFailStatus the smsInFailStatus to set
     */
    public void setSmsInFailStatus(int smsInFailStatus) {
        this.smsInFailStatus = smsInFailStatus;
    }

    /**
     * @return the smsOutInitStatus
     */
    public int getSmsOutInitStatus() {
        return smsOutInitStatus;
    }

    /**
     * @param smsOutInitStatus the smsOutInitStatus to set
     */
    public void setSmsOutInitStatus(int smsOutInitStatus) {
        this.smsOutInitStatus = smsOutInitStatus;
    }

    /**
     * @return the smsOutFinalStatus
     */
    public int getSmsOutFinalStatus() {
        return smsOutFinalStatus;
    }

    /**
     * @param smsOutFinalStatus the smsOutFinalStatus to set
     */
    public void setSmsOutFinalStatus(int smsOutFinalStatus) {
        this.smsOutFinalStatus = smsOutFinalStatus;
    }

    /**
     * @return the smsOutFailStatus
     */
    public int getSmsOutFailStatus() {
        return smsOutFailStatus;
    }

    /**
     * @param smsOutFailStatus the smsOutFailStatus to set
     */
    public void setSmsOutFailStatus(int smsOutFailStatus) {
        this.smsOutFailStatus = smsOutFailStatus;
    }

    /**
     * @return the defaultSmsOutNotification
     */
    public int getDefaultSmsOutNotification() {
        return defaultSmsOutNotification;
    }

    /**
     * @param defaultSmsOutNotification the defaultSmsOutNotification to set
     */
    public void setDefaultSmsOutNotification(int defaultSmsOutNotification) {
        this.defaultSmsOutNotification = defaultSmsOutNotification;
    }

    /**
     * @return the logStandardDateFormat
     */
    public String getLogStandardDateFormat() {
        return logStandardDateFormat;
    }

    /**
     * @param logStandardDateFormat the logStandardDateFormat to set
     */
    public void setLogStandardDateFormat(String logStandardDateFormat) {
        this.logStandardDateFormat = logStandardDateFormat;
    }

    /**
     * @return the kannelUrl
     */
    public String getKannelUrl() {
        return kannelUrl;
    }

    /**
     * @param kannelUrl the kannelUrl to set
     */
    public void setKannelUrl(String kannelUrl) {
        this.kannelUrl = kannelUrl;
    }

    /**
     * @return the kannelUrlKeywords
     */
    public String[] getKannelUrlKeywords() {
        return kannelUrlKeywords;
    }

    /**
     * @param kannelUrlKeywords the kannelUrlKeywords to set
     */
    public void setKannelUrlKeywords(String[] kannelUrlKeywords) {
        this.kannelUrlKeywords = kannelUrlKeywords;
    }

    /**
     * @return the smsInInitResponseStatus
     */
    public int getSmsInInitResponseStatus() {
        return smsInInitResponseStatus;
    }

    /**
     * @param smsInInitResponseStatus the smsInInitResponseStatus to set
     */
    public void setSmsInInitResponseStatus(int smsInInitResponseStatus) {
        this.smsInInitResponseStatus = smsInInitResponseStatus;
    }

    public int getSmsInAutoResponseKeyword() {
        return smsInAutoResponseKeyword;
    }

    public void setSmsInAutoResponseKeyword(int smsInAutoResponseKeyword) {
        this.smsInAutoResponseKeyword = smsInAutoResponseKeyword;
    }

    public String getDefaultErrorResponse() {
        return defaultErrorResponse;
    }

    public void setDefaultErrorResponse(String defaultErrorResponse) {
        this.defaultErrorResponse = defaultErrorResponse;
    }

    public String getAppUserName() {
        return appUserName;
    }

    public void setAppUserName(String appUserName) {
        this.appUserName = appUserName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getDefaultEncoding() {
        return defaultEncoding;
    }
    
    public String getBulkUser() {
        return bulkUser;
    }

    public void setBulkUser(String bulkUser) {
        this.bulkUser = bulkUser;
    }

    public String getBulkPassword() {
        return bulkPassword;
    }

    public void setBulkPassword(String bulkPassword) {
        this.bulkPassword = bulkPassword;
    }

    public String getBulkUrl() {
        return bulkUrl;
    }

    public void setBulkUrl(String bulkUrl) {
        this.bulkUrl = bulkUrl;
    }
    

    public String getSeparatorKeyword() {
        return separatorKeyword;
    }

    public void setSeparatorKeyword(String separatorKeyword) {
        this.separatorKeyword = separatorKeyword;
    }

    public int getSmsOutProcessingStatus() {
        return smsOutProcessingStatus;
    }

    public void setSmsOutProcessingStatus(int smsOutProcessingStatus) {
        this.smsOutProcessingStatus = smsOutProcessingStatus;
    }

    public String getSingleSmsBulkUrl() {
        return singleSmsBulkUrl;
    }

    public void setSingleSmsBulkUrl(String singleSmsBulkUrl) {
        this.singleSmsBulkUrl = singleSmsBulkUrl;
    }

    public String getBulkEncoding() {
        return bulkEncoding;
    }

    public void setBulkEncoding(String bulkEncoding) {
        this.bulkEncoding = bulkEncoding;
    }

    public String getBulkSender() {
        return bulkSender;
    }

    public void setBulkSender(String bulkSender) {
        this.bulkSender = bulkSender;
    }

    public String getAfricasTalkingUsername() {
        return africasTalkingUsername;
    }

    public void setAfricasTalkingUsername(String africasTalkingUsername) {
        this.africasTalkingUsername = africasTalkingUsername;
    }

    public String getAfricasTalkingSender() {
        return africasTalkingSender;
    }

    public void setAfricasTalkingSender(String africasTalkingSender) {
        this.africasTalkingSender = africasTalkingSender;
    }

    public String getAfricasTalkingApiKey() {
        return africasTalkingApiKey;
    }

    public void setAfricasTalkingApiKey(String africasTalkingApiKey) {
        this.africasTalkingApiKey = africasTalkingApiKey;
    }
}
