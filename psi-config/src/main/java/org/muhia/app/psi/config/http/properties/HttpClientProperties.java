/**
 *
 * Copyright 2015-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 * Generated on Aug 19, 2016 for  psi-config on package org.muhia.psi.properties.jms
 *
 */
package org.muhia.app.psi.config.http.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 *
 */
@Configuration
@PropertySource(value = {"file:${CONFIG_PATH}/http-client.properties"})
public class HttpClientProperties {

    @Value("${org.muhia.http.client.timeout.read}")
    int readTimeout;
    @Value("${org.muhia.http.client.timeout.connection}")
    int connectionTimeout;
    @Value("${org.muhia.http.client.timeout.connectionrequest}")
    int connectionRequestTimeout;
    @Value("${org.muhia.http.client.timeout.socket}")
    int sockectTimeout;
    @Value("${org.muhia.http.client.limit.status.lower}")
    int lowerStatusLimit;
    @Value("${org.muhia.http.client.limit.status.upper}")
    int upperStatusLimit;
    @Value("${org.muhia.http.client.security.enforce.flag}")
    boolean enforceSecurity;
    @Value("${org.muhia.http.client.security.keystore.path}")
    String keystorePath;
    @Value("${org.muhia.http.client.security.keystore.token}")
    String keystoreToken;
    @Value("${org.muhia.http.client.security.keystore.protocol}")
    String[] keystoreProtocol;
    @Value("${org.muhia.http.client.message.timeout}")
    String timeoutMessage;
    @Value("${org.muhia.http.client.message.fail}")
    String failMessage;
    @Value("${org.muhia.http.client.message.processing}")
    String processingMessage;
    @Value("${org.muhia.http.client.message.exception}")
    String exceptionMessage;
    @Value("org.muhia.http.client.message.ioexception")
    private String ioExceptionMessage;
    @Value("org.muhia.http.client.message.unexpectedStatus")
    private String unexpectedStatus;

    /**
     * @return the readTimeout
     */
    public int getReadTimeout() {
        return readTimeout;
    }

    /**
     * @param readTimeout the readTimeout to set
     */
    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    /**
     * @return the connectionTimeout
     */
    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    /**
     * @param connectionTimeout the connectionTimeout to set
     */
    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    /**
     * @return the connectionRequestTimeout
     */
    public int getConnectionRequestTimeout() {
        return connectionRequestTimeout;
    }

    /**
     * @param connectionRequestTimeout the connectionRequestTimeout to set
     */
    public void setConnectionRequestTimeout(int connectionRequestTimeout) {
        this.connectionRequestTimeout = connectionRequestTimeout;
    }

    /**
     * @return the sockectTimeout
     */
    public int getSockectTimeout() {
        return sockectTimeout;
    }

    /**
     * @param sockectTimeout the sockectTimeout to set
     */
    public void setSockectTimeout(int sockectTimeout) {
        this.sockectTimeout = sockectTimeout;
    }

    /**
     * @return the lowerStatusLimit
     */
    public int getLowerStatusLimit() {
        return lowerStatusLimit;
    }

    /**
     * @param lowerStatusLimit the lowerStatusLimit to set
     */
    public void setLowerStatusLimit(int lowerStatusLimit) {
        this.lowerStatusLimit = lowerStatusLimit;
    }

    /**
     * @return the upperStatusLimit
     */
    public int getUpperStatusLimit() {
        return upperStatusLimit;
    }

    /**
     * @param upperStatusLimit the upperStatusLimit to set
     */
    public void setUpperStatusLimit(int upperStatusLimit) {
        this.upperStatusLimit = upperStatusLimit;
    }

    /**
     * @return the enforceSecurity
     */
    public boolean isEnforceSecurity() {
        return enforceSecurity;
    }

    /**
     * @param enforceSecurity the enforceSecurity to set
     */
    public void setEnforceSecurity(boolean enforceSecurity) {
        this.enforceSecurity = enforceSecurity;
    }

    /**
     * @return the keystorePath
     */
    public String getKeystorePath() {
        return keystorePath;
    }

    /**
     * @param keystorePath the keystorePath to set
     */
    public void setKeystorePath(String keystorePath) {
        this.keystorePath = keystorePath;
    }

    /**
     * @return the keystoreToken
     */
    public String getKeystoreToken() {
        return keystoreToken;
    }

    /**
     * @param keystoreToken the keystoreToken to set
     */
    public void setKeystoreToken(String keystoreToken) {
        this.keystoreToken = keystoreToken;
    }

    /**
     * @return the keystoreProtocol
     */
    public String[] getKeystoreProtocol() {
        return keystoreProtocol;
    }

    /**
     * @param keystoreProtocol the keystoreProtocol to set
     */
    public void setKeystoreProtocol(String[] keystoreProtocol) {
        this.keystoreProtocol = keystoreProtocol;
    }

    /**
     * @return the timeoutMessage
     */
    public String getTimeoutMessage() {
        return timeoutMessage;
    }

    /**
     * @param timeoutMessage the timeoutMessage to set
     */
    public void setTimeoutMessage(String timeoutMessage) {
        this.timeoutMessage = timeoutMessage;
    }

    /**
     * @return the failMessage
     */
    public String getFailMessage() {
        return failMessage;
    }

    /**
     * @param failMessage the failMessage to set
     */
    public void setFailMessage(String failMessage) {
        this.failMessage = failMessage;
    }

    /**
     * @return the processingMessage
     */
    public String getProcessingMessage() {
        return processingMessage;
    }

    /**
     * @param processingMessage the processingMessage to set
     */
    public void setProcessingMessage(String processingMessage) {
        this.processingMessage = processingMessage;
    }

    /**
     * @return the exceptionMessage
     */
    public String getExceptionMessage() {
        return exceptionMessage;
    }

    /**
     * @param exceptionMessage the exceptionMessage to set
     */
    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    /**
     * @return the ioExceptionMessage
     */
    public String getIoExceptionMessage() {
        return ioExceptionMessage;
    }

    /**
     * @param ioExceptionMessage the ioExceptionMessage to set
     */
    public void setIoExceptionMessage(String ioExceptionMessage) {
        this.ioExceptionMessage = ioExceptionMessage;
    }

    /**
     * @return the unexpectedStatus
     */
    public String getUnexpectedStatus() {
        return unexpectedStatus;
    }

    /**
     * @param unexpectedStatus the unexpectedStatus to set
     */
    public void setUnexpectedStatus(String unexpectedStatus) {
        this.unexpectedStatus = unexpectedStatus;
    }

}
