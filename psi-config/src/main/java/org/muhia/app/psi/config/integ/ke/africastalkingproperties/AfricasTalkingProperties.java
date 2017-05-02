package org.muhia.app.psi.config.integ.ke.africastalkingproperties;/**
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
 * Package: org.muhia.app.psi.config.integ.ke.properties
 * Generated on: 13-Apr-17, 21:16
 */
@Configuration
@PropertySource(value = {"file:${CONFIG_PATH}/africas-talking.properties"})
public class AfricasTalkingProperties {
    @Value("${org.muhia.psi.config.africastalking.integ.username.data}") private  String integUsernameData;
    @Value("${org.muhia.psi.config.africastalking.integ.username.keyword}") private  String integUsernameKeyword;

    @Value("${org.muhia.psi.config.africastalking.integ.enviroment}")
    private String integEnviroment;
    @Value("${org.muhia.psi.config.africastalking.integ.sender}")
    private String integSender;
    @Value("${org.muhia.psi.config.africastalking.response.code.http.ok}")
    private int responseCodeHttpOk;
    @Value("${org.muhia.psi.config.africastalking.response.code.http.created}")
    private int responseCodeHttpCreated;
    @Value("${org.muhia.psi.config.africastalking.integ.debug}")
    private boolean integDebug;
    @Value("${org.muhia.psi.config.africastalking.prod.api.host}")
    private String prodApiHost;
    @Value("${org.muhia.psi.config.africastalking.sandbox.api.host}")
    private String sandboxApiHost;
    @Value("${org.muhia.psi.config.africastalking.prod.payments.host}")
    private String prodPaymentsHost;
    @Value("${org.muhia.psi.config.africastalking.sandbox.payments.host}")
    private String sandboxPaymentsHost;
    @Value("${org.muhia.psi.config.africastalking.prod.voice.host}")
    private String prodVoiceHost;
    @Value("${org.muhia.psi.config.africastalking.sandbox.voice.host}")
    private String sandboxVoiceHost;
    @Value("${org.muhia.psi.config.africastalking.sms.url}")
    private String smsUrl;
    @Value("${org.muhia.psi.config.africastalking.voice.url}")
    private String voiceUrl;
    @Value("${org.muhia.psi.config.africastalking.subscription.url}")
    private String subscriptionUrl;
    @Value("${org.muhia.psi.config.africastalking.user.data.url}")
    private String userDataUrl;
    @Value("${org.muhia.psi.config.africastalking.airtime.url}")
    private String airtimeUrl;
    @Value("${org.muhia.psi.config.africastalking.payment.checkout.url}")
    private String paymentCheckoutUrl;
    @Value("${org.muhia.psi.config.africastalking.mobile.payment.b2b.url}")
    private String mobilePaymentB2bUrl;
    @Value("${org.muhia.psi.config.africastalking.mobile.payment.b2c.url}")
    private String mobilePaymentB2cUrl;
    @Value("${org.muhia.psi.config.africastalking.integ.phonenumber.keyword}")
    private String integPhonenumberKeyword;
    @Value("${org.muhia.psi.config.africastalking.integ.phonenumber.data}")
    private String integPhonenumberData;
    @Value("${org.muhia.psi.config.africastalking.integ.keyword.keyword}")
    private String integKeywordKeyword;
    @Value("${org.muhia.psi.config.africastalking.integ.keyword.data}")
    private String integKeywordData;
    @Value("${org.muhia.psi.config.africastalking.integ.shortcode.keyword}")
    private String integShortcodeKeyword;
    @Value("${org.muhia.psi.config.africastalking.integ.shortcode.data}")
    private String integShortcodeData;
    @Value("${org.muhia.psi.config.africastalking.integ.to.keyword}")
    private String integToKeyword;
    @Value("${org.muhia.psi.config.africastalking.integ.to.data}")
    private String integToData;
    @Value("${org.muhia.psi.config.africastalking.integ.from.keyword}")
    private String integFromKeyword;
    @Value("${org.muhia.psi.config.africastalking.integ.from.data}")
    private String integFromData;
    @Value("${org.muhia.psi.config.africastalking.integ.phone.numbers.keyword}")
    private String integPhoneNumbersKeyword;
    @Value("${org.muhia.psi.config.africastalking.integ.phone.numbers.data}")
    private String integPhoneNumbersData;
    @Value("${org.muhia.psi.config.africastalking.integ.currency.code.keyword}")
    private String integCurrencyCodeKeyword;
    @Value("${org.muhia.psi.config.africastalking.integ.currency.code.data}")
    private String integCurrencyCodeData;
    @Value("${org.muhia.psi.config.africastalking.integ.amount.keyword}")
    private String integAmountKeyword;
    @Value("${org.muhia.psi.config.africastalking.integ.amount.data}")
    private String integAmountData;
    @Value("${org.muhia.psi.config.africastalking.integ.metadata.keyword}")
    private String integMetadataKeyword;
    @Value("${org.muhia.psi.config.africastalking.integ.metadata.data}")
    private String integMetadataData;
    @Value("${org.muhia.psi.config.africastalking.url.header.accept.keyword}")
    private String urlHeaderAcceptKeyword;
    @Value("${org.muhia.psi.config.africastalking.url.header.accept.data}")
    private String urlHeaderAcceptData;
    @Value("${org.muhia.psi.config.africastalking.url.header.api.keyword}")
    private String urlHeaderApiKeyword;
    @Value("${org.muhia.psi.config.africastalking.url.header.api.data}")
    private String urlHeaderApiData;
    @Value("${org.muhia.psi.config.africastalking.sms.message.data.keyword}") private  String smsMessageDataKeyword;
    @Value("${org.muhia.psi.config.africastalking.integ.response.recipients.keyword}") private  String integResponseRecipientsKeyword;
    @Value("${org.muhia.psi.config.africastalking.integ.response.message.keyword}") private  String integResponseMessageKeyword;
    @Value("${org.muhia.psi.config.africastalking.integ.sms.message.keyword}") private  String integSmsMessageKeyword;
    @Value("${org.muhia.psi.config.africastalking.integ.http.method.post}") private  String integHttpMethodPost;
    @Value("${org.muhia.psi.config.africastalking.integ.http.method.get}") private  String integHttpMethodGet;
    @Value("${org.muhia.psi.config.africastalking.integ.url.encode.encoding}") private  String integUrlEncodeEncoding;
    @Value("${org.muhia.psi.config.africastalking.sms.send.success.keyword}") private  String smsSendSuccessKeyword;









    public String getIntegEnviroment() {
        return integEnviroment;
    }

    public String getIntegSender() {
        return integSender;
    }

    public int getResponseCodeHttpOk() {
        return responseCodeHttpOk;
    }

    public int getResponseCodeHttpCreated() {
        return responseCodeHttpCreated;
    }

    public boolean isIntegDebug() {
        return integDebug;
    }

    public String getProdApiHost() {
        return prodApiHost;
    }

    public String getSandboxApiHost() {
        return sandboxApiHost;
    }

    public String getProdPaymentsHost() {
        return prodPaymentsHost;
    }

    public String getSandboxPaymentsHost() {
        return sandboxPaymentsHost;
    }

    public String getProdVoiceHost() {
        return prodVoiceHost;
    }

    public String getSandboxVoiceHost() {
        return sandboxVoiceHost;
    }

    public String getSmsUrl() {
        return smsUrl;
    }

    public String getVoiceUrl() {
        return voiceUrl;
    }

    public String getSubscriptionUrl() {
        return subscriptionUrl;
    }

    public String getUserDataUrl() {
        return userDataUrl;
    }

    public String getAirtimeUrl() {
        return airtimeUrl;
    }

    public String getPaymentCheckoutUrl() {
        return paymentCheckoutUrl;
    }

    public String getMobilePaymentB2bUrl() {
        return mobilePaymentB2bUrl;
    }

    public String getMobilePaymentB2cUrl() {
        return mobilePaymentB2cUrl;
    }

    public String getIntegPhonenumberKeyword() {
        return integPhonenumberKeyword;
    }

    public String getIntegPhonenumberData() {
        return integPhonenumberData;
    }

    public String getIntegKeywordKeyword() {
        return integKeywordKeyword;
    }

    public String getIntegKeywordData() {
        return integKeywordData;
    }

    public String getIntegShortcodeKeyword() {
        return integShortcodeKeyword;
    }

    public String getIntegShortcodeData() {
        return integShortcodeData;
    }

    public String getIntegToKeyword() {
        return integToKeyword;
    }

    public String getIntegToData() {
        return integToData;
    }

    public String getIntegFromKeyword() {
        return integFromKeyword;
    }

    public String getIntegFromData() {
        return integFromData;
    }

    public String getIntegPhoneNumbersKeyword() {
        return integPhoneNumbersKeyword;
    }

    public String getIntegPhoneNumbersData() {
        return integPhoneNumbersData;
    }

    public String getIntegCurrencyCodeKeyword() {
        return integCurrencyCodeKeyword;
    }

    public String getIntegCurrencyCodeData() {
        return integCurrencyCodeData;
    }

    public String getIntegAmountKeyword() {
        return integAmountKeyword;
    }

    public String getIntegAmountData() {
        return integAmountData;
    }

    public String getIntegMetadataKeyword() {
        return integMetadataKeyword;
    }

    public String getIntegMetadataData() {
        return integMetadataData;
    }

    public String getUrlHeaderAcceptKeyword() {
        return urlHeaderAcceptKeyword;
    }

    public String getUrlHeaderAcceptData() {
        return urlHeaderAcceptData;
    }

    public String getUrlHeaderApiKeyword() {
        return urlHeaderApiKeyword;
    }

    public String getUrlHeaderApiData() {
        return urlHeaderApiData;
    }

    public String getSmsMessageDataKeyword() {
        return smsMessageDataKeyword;
    }



    public String getIntegResponseRecipientsKeyword() {
        return integResponseRecipientsKeyword;
    }

    public String getIntegResponseMessageKeyword() {
        return integResponseMessageKeyword;
    }

    public String getIntegUsernameData() {
        return integUsernameData;
    }

    public String getIntegUsernameKeyword() {
        return integUsernameKeyword;
    }

    public String getIntegSmsMessageKeyword() {
        return integSmsMessageKeyword;
    }

    public String getIntegHttpMethodPost() {
        return integHttpMethodPost;
    }

    public String getIntegHttpMethodGet() {
        return integHttpMethodGet;
    }

    public String getIntegUrlEncodeEncoding() {
        return integUrlEncodeEncoding;
    }

    public String getSmsSendSuccessKeyword() {
        return smsSendSuccessKeyword;
    }
}
