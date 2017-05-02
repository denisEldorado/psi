package org.muhia.app.psi.portal.config;

import org.muhia.app.psi.portal.ws.endpoints.C2BPaymentValidationRequestEndpoint;
import org.muhia.app.psi.portal.ws.endpoints.ResponseEndpoint;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

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


  Created by Kenneth Muhia <muhia@muhia.org>
  Project: psi
  Package: org.muhia.app.psi.portal.config
  Generated on: 2/23/17, 10:38.
 */
@EnableWs
@Configuration
public class WebServiceConfiguration extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/mpesa/*");
    }

    @Bean(name = "response")
    public DefaultWsdl11Definition defaultWsdl11Definition() {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("response");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace(ResponseEndpoint.NAMESPACE_URI);
        wsdl11Definition.setSchema(responsesSchema());
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema responsesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/CPSInterface_Response.xsd"));
    }

    @Bean
    public XsdSchema c2BPaymentValidationAndConfirmation() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/CBPInterface_C2BPaymentValidationAndConfirmation.xsd"));
    }



    @Bean(name = "C2BPaymentValidationRequest")
    public DefaultWsdl11Definition c2bWsdl11Definition() {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("C2BPaymentValidationRequest");
        wsdl11Definition.setLocationUri("/ws/mpesa");
        wsdl11Definition.setTargetNamespace(C2BPaymentValidationRequestEndpoint.C2BNAMESPACE_URI);
        wsdl11Definition.setSchema(c2BPaymentValidationAndConfirmation());
        return wsdl11Definition;
    }




}
