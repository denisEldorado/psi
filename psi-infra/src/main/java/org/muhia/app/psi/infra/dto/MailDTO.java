package org.muhia.app.psi.infra.dto;/*
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

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.muhia.app.psi.infra.validators.ExtendedEmailValidator;

import javax.persistence.Basic;
import java.io.Serializable;

/*
  Created by KennethKZMMuhia
  Project: psi
  Package: org.muhia.app.psi.infra.mail.components
  Generated on 31-Dec-16.
 */
public class MailDTO implements Serializable {
    private static final int MAX_LENGTH_EMAIL_ADDRESS = 65;
    private static final int MAX_LENGTH_FROM_NAME = 60;
    private static final int MAX_LENGTH_EMAIL_BODY = 1000;

    @Basic
    @ExtendedEmailValidator
    @Length(max = MAX_LENGTH_EMAIL_ADDRESS)
    private String from;

    @NotEmpty
    @Length(max = MAX_LENGTH_FROM_NAME)
    private String fromName;

    @NotEmpty
    @Length(max = MAX_LENGTH_EMAIL_BODY)
    private String body;

    private String to;
    private String cc;
    private String bcc;
    private String subject;
    private String templateName;
    private Type type = Type.PLAIN;

    public MailDTO() {
    }

    private MailDTO(MailDTO m) {
        this.type = m.type;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    @Override
    public String toString() {

        return "MailDTO{" + "from=" + from + ", fromName=" + fromName + ", to=" + to + ", cc='" + cc + '\'' + ", bcc='" + bcc + '\'' + ", subject='" + subject + '\'' + ", body='" + body + '\'' + ", templateName='" + templateName + '\'' + ", type=" + type + '}';
    }

    public enum Type {
        PLAIN, HTML
    }
}
