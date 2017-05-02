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
import org.muhia.app.psi.portal.service.mail.IFreeMarkerService;
import org.muhia.app.psi.config.org.properties.OrganizationProperties;
import org.muhia.app.psi.orm.model.Principals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
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
public class FreeMarkerService implements IFreeMarkerService {
    private final Configuration fmt;

    private final OrganizationProperties properties;

    @Autowired
    public FreeMarkerService(Configuration fmt, OrganizationProperties properties){
        this.fmt = fmt;
        this.properties =properties;
    }

    @Override
    public String displayTestTemplate(Principals user) {
        Map<String, Object> model = new Hashtable<>();
        model.put("siteName", properties.getSiteName());
        model.put("greeting", properties.getGreeting());
        model.put("user", user);
        model.put("applicationPropertyUrl", properties.getApplicationPropertyUrl());

        String result = null;

        try {
            Template template = fmt.getTemplate("tests/test.ftl");
            result = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
        } catch (IOException | TemplateException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,"Problem merging test template : " + e.getMessage(),e);
        }
        return result;


    }



    @Override
    public String getRobotsTxt() {
        String result = null;
        try {
            result =  FreeMarkerTemplateUtils.processTemplateIntoString(fmt.getTemplate("utils/robots.ftl"), null);
        } catch (IOException | TemplateException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,"Problem merging Robots.txt template : " + e.getMessage(),e);
        }
        return result;
    }

    @Override
    public String getFileUploadingScript() {
        String result = null;
        try {
            result =  FreeMarkerTemplateUtils.processTemplateIntoString(fmt.getTemplate("utils/fileuploading.ftl"), null);
        } catch (IOException | TemplateException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,"Problem merging fileuploading template : " + e.getMessage(),e);
        }
        return result;
    }

    @Override
    public String getFileUploadedScript() {
        String result = null;
        try {
            result =  FreeMarkerTemplateUtils.processTemplateIntoString(fmt.getTemplate("utils/fileuploaded.ftl"), null);
        } catch (IOException | TemplateException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,"Problem merging fileuploaded template : " + e.getMessage(),e);
        }
        return result;

    }
}
