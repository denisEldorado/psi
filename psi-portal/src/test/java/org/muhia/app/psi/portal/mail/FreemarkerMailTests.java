package org.muhia.app.psi.portal.mail;/*
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
  ee the License for the specific language governing permissions and
  limitations under the License.
  
 */

import freemarker.template.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.muhia.app.psi.portal.service.mail.IFreemarkerMailService;
import org.muhia.app.psi.portal.service.orm.IPrincipalsService;
import org.muhia.app.psi.config.mail.properties.MailerProperties;
import org.muhia.app.psi.config.org.properties.OrganizationProperties;
import org.muhia.app.psi.infra.dto.MailDTO;
import org.muhia.app.psi.infra.mail.components.MailSender;
import org.muhia.app.psi.orm.model.PasswordResetTokens;
import org.muhia.app.psi.orm.model.Principals;
import org.muhia.app.psi.orm.model.VerificationTokens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.UUID;

/*
  Created by KennethKZMMuhia
  Project: psi
  Package: org.muhia.app.psi.portal.mail
  Generated on 01-Jan-17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FreemarkerMailTests {
    @Autowired
    private Configuration fmt;
    @Autowired
    private IFreemarkerMailService service;
    @Autowired
    private IPrincipalsService principalsService;
    @Autowired
    private MailSender sender;
    @Autowired
    private MailerProperties properties;
    @Autowired
    private OrganizationProperties organizationProperties;


    @Test
    public void sendUserVerificationMailTest() {
        Optional<Principals> principalsOptional = principalsService.findUserByPhone("12345678");
        principalsOptional.ifPresent(principals -> {
            final String token = UUID.randomUUID().toString();
            VerificationTokens tokens = principalsService.createVerificationTokenForUser(principals, token, organizationProperties.getValidationTokenExpiryMinutes());
            service.sendUserVerificationMail(principals, tokens.getToken());

        });


    }

    @Test
    public void sendResetPasswordMailTest() {
        Optional<Principals> principalsOptional = principalsService.findUserByPhone("12345678");
        principalsOptional.ifPresent(principals -> {
            final String token = UUID.randomUUID().toString();
            PasswordResetTokens tokens = principalsService.createPasswordResetTokenForUser(principals, token);
            service.sendResetPasswordMail(principals, tokens.getToken());

        });

    }


    @Test
    public void contactSendsMimeMessageTest() {
        Optional<Principals> principalsOptional = principalsService.findUserByPhone("12345678");
        principalsOptional.ifPresent(principals -> {
            MailDTO dto = new MailDTO();
            dto.setFrom(properties.getDeveloperFrom());
            dto.setFromName(principals.getFullname());
            dto.setSubject(properties.getContactSubject());
            dto.setTo(principals.getEmailaddress());
            dto.setBody("This is a message from test dude");
            dto.setType(MailDTO.Type.HTML);


            service.sendContactMail(dto);
        });

    }
}
