/**
 * Copyright 2015-2017 the original author or authors.
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
 */
package org.muhia.app.psi.config.mail.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@Configuration
@PropertySource(value = "file:${CONFIG_PATH}/mailer.properties")
public class MailerProperties {

    @Value("${org.muhia.psi.mailer.host}")
    private String serverHost;
    @Value("${org.muhia.psi.mailer.port}")
    private Integer serverPort;
    @Value("${org.muhia.psi.mailer.username}")
    private String serverUsername;
    @Value("${org.muhia.psi.mailer.password}")
    private String serverPassword;
    @Value("${org.muhia.psi.mailer.protocol}")
    private String serverProtocol;
    @Value("${org.muhia.psi.mailer.smtpAuth}")
    private Boolean smtpAuth;
    @Value("${org.muhia.psi.mailer.smtpStartTlsEnable}")
    private Boolean smtpStartTlsEnable;

    @Value("${org.muhia.psi.mailer.contact.from}")
    private String contactFrom;
    @Value("${org.muhia.psi.mailer.contact.body.type}")
    private String contactBodyType;
    @Value("${org.muhia.psi.mailer.contact.subject}")
    private String contactSubject;
    @Value("${org.muhia.psi.mailer.contact.greeting}")
    private String contactGreeting;
    @Value("${org.muhia.psi.mailer.passwordreset.from}")
    private String passwordresetFrom;
    @Value("${org.muhia.psi.mailer.passwordreset.body.type}")
    private String passwordresetBodyType;
    @Value("${org.muhia.psi.mailer.passwordreset.subject}")
    private String passwordresetSubject;
    @Value("${org.muhia.psi.mailer.passwordreset.greeting}")
    private String passwordresetGreeting;
    @Value("${org.muhia.psi.mailer.verification.from}")
    private String verificationFrom;
    @Value("${org.muhia.psi.mailer.verification.subject}")
    private String verificationSubject;
    @Value("${org.muhia.psi.mailer.verification.greeting}")
    private String verificationGreeting;
    @Value("${org.muhia.psi.mailer.verification.body.type}")
    private String verificationBodyType;
    @Value("${org.muhia.psi.mailer.activateAccountSubject}")
    private String activateAccounSubject;
    @Value("${org.muhia.psi.mailer.activateAccountSender}")
    private String activateAccounSender;
    @Value("${org.muhia.psi.mailer.passwordResetSubject}")
    private String passwordResetSubject;
    @Value("${org.muhia.psi.mailer.passwordResetSender}")
    private String passwordResetSender;
    @Value("${org.muhia.psi.mailer.passwordResetBody}")
    private String passwordResetBody;
    @Value("${org.muhia.psi.mailer.activateAccountConfirmationBody}")
    private String activateAccountConfirmationBody;
    @Value("${org.muhia.psi.mailer.activateAccountBody}")
    private String activateAccountBody;
    @Value("${org.muhia.psi.mailer.passwordResetConfirmationBody}")
    private String passwordResetConfirmationBody;
    @Value("${org.muhia.psi.mailer.forgotPasswordBody}")
    private String forgotPasswordBody;
    @Value("${org.muhia.psi.mailer.forgotPasswordSubject}")
    private String forgotPasswordSubject;
    @Value("${org.muhia.psi.mailer.developer.from}")
    private String developerFrom;
    @Value("${org.muhia.psi.mailer.developer.subject}")
    private String developerSubject;
    @Value("${org.muhia.psi.mailer.developer.greeting}")
    private String developerGreeting;
    @Value("${org.muhia.psi.mailer.developer.body.type}")
    private String developerBodyType;
    @Value("${org.muhia.psi.mailer.passwordreset.url}")
    private String passwordresetUrl;
    @Value("${org.muhia.psi.mailer.verification.url}")
    private String verificationUrl;
    @Value("${org.muhia.psi.mailer.site.user.services}")
    private String siteUserServices;
    @Value("${org.muhia.psi.mailer.passwordreset.template.name}")
    private String passwordresetTemplateName;
    @Value("${org.muhia.psi.mailer.verification.template.name}")
    private String verificationTemplateName;
    @Value("${org.muhia.psi.mailer.contact.template.name}")
    private String contactTemplateName;
    private boolean sendContactCC;
    private String contactCC;



    public String getServerHost() {
        return serverHost;
    }

    public Integer getServerPort() {
        return serverPort;
    }

    public String getServerUsername() {
        return serverUsername;
    }

    public String getServerPassword() {
        return serverPassword;
    }

    public String getServerProtocol() {
        return serverProtocol;
    }

    public Boolean getSmtpAuth() {
        return smtpAuth;
    }

    public Boolean getSmtpStartTlsEnable() {
        return smtpStartTlsEnable;
    }

    public String getContactFrom() {
        return contactFrom;
    }

    public String getContactBodyType() {
        return contactBodyType;
    }

    public String getContactSubject() {
        return contactSubject;
    }

    public String getContactGreeting() {
        return contactGreeting;
    }

    public String getPasswordresetFrom() {
        return passwordresetFrom;
    }

    public String getPasswordresetBodyType() {
        return passwordresetBodyType;
    }

    public String getPasswordresetSubject() {
        return passwordresetSubject;
    }

    public String getPasswordresetGreeting() {
        return passwordresetGreeting;
    }

    public String getVerificationFrom() {
        return verificationFrom;
    }

    public String getVerificationSubject() {
        return verificationSubject;
    }

    public String getVerificationGreeting() {
        return verificationGreeting;
    }

    public String getVerificationBodyType() {
        return verificationBodyType;
    }

    public String getActivateAccounSubject() {
        return activateAccounSubject;
    }

    public String getActivateAccounSender() {
        return activateAccounSender;
    }

    public String getPasswordResetSubject() {
        return passwordResetSubject;
    }

    public String getPasswordResetSender() {
        return passwordResetSender;
    }

    public String getPasswordResetBody() {
        return passwordResetBody;
    }

    public String getActivateAccountConfirmationBody() {
        return activateAccountConfirmationBody;
    }

    public String getActivateAccountBody() {
        return activateAccountBody;
    }

    public String getPasswordResetConfirmationBody() {
        return passwordResetConfirmationBody;
    }

    public String getForgotPasswordBody() {
        return forgotPasswordBody;
    }

    public String getForgotPasswordSubject() {
        return forgotPasswordSubject;
    }

    public String getDeveloperFrom() {
        return developerFrom;
    }

    public String getDeveloperSubject() {
        return developerSubject;
    }

    public String getDeveloperGreeting() {
        return developerGreeting;
    }

    public String getDeveloperBodyType() {
        return developerBodyType;
    }


    public String getPasswordresetUrl() {
        return passwordresetUrl;
    }

    public String getVerificationUrl() {
        return verificationUrl;
    }

    public String getSiteUserServices() {
        return siteUserServices;
    }

    public String getPasswordresetTemplateName() {
        return passwordresetTemplateName;
    }

    public String getVerificationTemplateName() {
        return verificationTemplateName;
    }

    public String getContactTemplateName() {
        return contactTemplateName;
    }

    public boolean getSendContactCC() {
        return sendContactCC;
    }

    public boolean isSendContactCC() {
        return sendContactCC;
    }

    public void setSendContactCC(boolean sendContactCC) {
        this.sendContactCC = sendContactCC;
    }

    public String getContactCC() {
        return contactCC;
    }

    public void setContactCC(String contactCC) {
        this.contactCC = contactCC;
    }
}
