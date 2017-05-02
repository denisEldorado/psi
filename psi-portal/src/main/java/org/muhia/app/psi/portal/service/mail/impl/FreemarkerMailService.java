package org.muhia.app.psi.portal.service.mail.impl;/*
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

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.muhia.app.psi.portal.service.mail.IFreemarkerMailService;
import org.muhia.app.psi.config.mail.properties.MailerProperties;
import org.muhia.app.psi.config.org.properties.OrganizationProperties;
import org.muhia.app.psi.infra.dto.MailDTO;
import org.muhia.app.psi.infra.mail.components.MailSender;
import org.muhia.app.psi.orm.model.Principals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Hashtable;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
  Created by KennethKZMMuhia
  Project: psi
  Package: org.muhia.app.psi.portal.service.mail.impl
  Generated on 31-Dec-16.
 */
@Service
public class FreemarkerMailService implements IFreemarkerMailService {


    private final Configuration fmt;
    private final OrganizationProperties properties;
    private final MailSender mailSender;
    private final MailerProperties mailerProperties;
    private MailDTO.Type mailType;


    @Autowired
    public FreemarkerMailService(Configuration fmt, OrganizationProperties properties, MailSender mailSender, MailerProperties mailerProperties) {
        this.fmt = fmt;
        this.properties = properties;
        this.mailSender = mailSender;
        this.mailerProperties = mailerProperties;

    }

    @Override
    public void sendResetPasswordMail(Principals user, String token) {
        try {
            mailSender.send(mimeMessage -> {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                String sendTo = properties.getApplicationPropertyUrl().contains(properties.getKeyWordLocalhost()) ? mailerProperties.getDeveloperFrom() : user.getEmailaddress();
                message.addTo(sendTo);
                message.setFrom(mailerProperties.getPasswordResetSender());
                message.setSubject(mailerProperties.getPasswordResetSubject());
                String greeting = mailerProperties.getPasswordresetGreeting();
                greeting = MessageFormat.format(greeting, String.format("%s ", user.getFullname()));
                String siteName = properties.getSiteName();
                String resetLink = properties.getApplicationPropertyUrl() + mailerProperties.getPasswordresetUrl() + token;

                Map<String, Object> model = new Hashtable<>();
                model.put("greeting", greeting);
                model.put("memberServices", mailerProperties.getSiteUserServices());
                model.put("siteName", siteName);
                model.put("organizationName", properties.getOrganizationName());
                model.put("applicationPropertyUrl", properties.getApplicationPropertyUrl());
                model.put("resetLink", resetLink);

                String html;
                try {
                    Template template = fmt.getTemplate(mailerProperties.getPasswordresetTemplateName());
                    html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
                    message.setText(html, true);
                } catch (IOException | TemplateException e) {
                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                }

                Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("Reset Password email sent to: %s", String.format("%s %s", user.getFullname(), user.getEmailaddress())));
            });

        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }

    }

    @Override
    public void sendContactMail(MailDTO mailDTO) {
        try {
            mailSender.send(mimeMessage -> {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                String sendTo = properties.getApplicationPropertyUrl().contains(properties.getKeyWordLocalhost()) ? mailerProperties.getDeveloperFrom() : mailDTO.getTo();

                message.setFrom(mailDTO.getFrom());
                message.addTo(sendTo);

                if (mailerProperties.getSendContactCC()) {
                    message.addCc(mailerProperties.getContactCC());
                }

                String subject = mailerProperties.getContactSubject();
                message.setSubject(MessageFormat.format(subject, mailDTO.getFromName()));
                String body = mailDTO.getBody();
                String applicationPropertyUrl = properties.getApplicationPropertyUrl();

                String greeting = mailerProperties.getContactGreeting();
                greeting = MessageFormat.format(greeting, String.format("%s ", mailDTO.getFromName()));

                String siteName = properties.getSiteName();
                mailType = mailDTO.getType();
                switch (mailType) {
                    case HTML:
                        Map<String, Object> model = new Hashtable<>();
                        model.put("message", mailDTO);
                        model.put("greeting", greeting);
                        model.put("siteName", siteName);
                        model.put("organizationName", properties.getOrganizationName());
                        model.put("applicationPropertyUrl", applicationPropertyUrl);

                        String html;
                        try {
                            Template template = fmt.getTemplate(mailerProperties.getContactTemplateName());
                            html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
                            message.setText(html, true);
                        } catch (IOException | TemplateException e) {
                            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                        }

                        break;
                    case PLAIN:
                        message.setText(mailDTO.getBody());
                        break;

                    default:
                        message.setText(body);
                        break;

                }
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("Contact Email sent from:: %s", mailDTO.getFrom()));


            });

        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }

    }

    @Override
    public void sendUserVerificationMail(Principals user, String token) {
        try {
            mailSender.send(mimeMessage -> {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                String sendTo = properties.getApplicationPropertyUrl().contains(properties.getKeyWordLocalhost()) ? mailerProperties.getDeveloperFrom() : user.getEmailaddress();
                message.addTo(sendTo);
                message.setFrom(mailerProperties.getVerificationFrom());
                message.setSubject(mailerProperties.getVerificationSubject());
                String greeting = mailerProperties.getVerificationGreeting();
                greeting = MessageFormat.format(greeting, String.format("%s ", user.getFullname()));
                String siteName = properties.getSiteName();
                String verifyLink = properties.getApplicationPropertyUrl() + mailerProperties.getVerificationUrl() + token;


                Map<String, Object> model = new Hashtable<>();
                model.put("greeting", greeting);
                model.put("memberServices", mailerProperties.getSiteUserServices());
                model.put("siteName", siteName);
                model.put("organizationName", properties.getOrganizationName());
                model.put("applicationPropertyUrl", properties.getApplicationPropertyUrl());
                model.put("verifyLink", verifyLink);

                String html;
                try {
                    Template template = fmt.getTemplate(mailerProperties.getVerificationTemplateName());
                    html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
                    message.setText(html, true);
                } catch (IOException | TemplateException e) {
                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                }

                Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("User Verification email sent to: %s", String.format("%s %s", user.getFullname(), user.getEmailaddress())));
            });

        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }

    }
}
