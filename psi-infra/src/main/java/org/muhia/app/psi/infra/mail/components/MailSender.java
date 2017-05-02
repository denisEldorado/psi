package org.muhia.app.psi.infra.mail.components;/*
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

import org.muhia.app.psi.config.mail.properties.MailerProperties;
import org.muhia.app.psi.config.security.HashingImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Properties;

/*
  Created by KennethKZMMuhia
  Project: psi
  Package: org.muhia.app.psi.infra.mail.components
  Generated on 31-Dec-16.
 */
@Component
public class MailSender extends JavaMailSenderImpl {
    @Autowired
    private MailerProperties mailSettings;
    @Autowired
    private HashingImplementation hasher;


    @Override
    public String getHost() {
        return mailSettings.getServerHost();
    }

    @Override
    public int getPort() {
        return mailSettings.getServerPort();
    }

    @Override
    public String getUsername() {
        return hasher.getDecryptedValue(mailSettings.getServerUsername());
    }

    @Override
    public String getPassword() {
        return hasher.getDecryptedValue(mailSettings.getServerPassword());
    }

    @Override
    public String getProtocol() {
        return mailSettings.getServerProtocol();
    }

    @Override
    public Properties getJavaMailProperties() {
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", mailSettings.getSmtpAuth().toString());
        properties.setProperty("mail.smtp.starttls.enable", mailSettings.getSmtpStartTlsEnable().toString());
        return properties;
    }


}
