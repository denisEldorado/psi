package org.muhia.app.psi.integ.config.ke.mpesa;

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
  
*/


import org.muhia.app.psi.config.integ.properties.MpesaProperties;
import org.muhia.app.psi.config.loaders.ResourceLoaderService;
import org.muhia.app.psi.integ.config.interceptors.PayloadValidatingInterceptorWithSourceFix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

import java.util.HashMap;
import java.util.Map;

/*
    Created by Kenneth Muhia <muhia@muhia.org> 
    Project: psi
    Package: org.muhia.app.psi.integ.config.obopay
    Generated on: 05-Feb-17.
*/
@Configuration
public class MpesaClientConfig {
    private final MpesaProperties properties;
    private final ResourceLoaderService loaderService;


    @Autowired
    public MpesaClientConfig(MpesaProperties properties, ResourceLoaderService loaderService) {
        this.properties = properties;
        this.loaderService = loaderService;
    }

    @Bean(name = "mpesaPayloadValidatingInterceptorWithSourceFix")
    public PayloadValidatingInterceptorWithSourceFix payloadValidatingInterceptorWithSourceFix() {
        PayloadValidatingInterceptorWithSourceFix payloadValidatingInterceptorWithSourceFix = new PayloadValidatingInterceptorWithSourceFix();
        Resource resource = loaderService.getResource(properties.getMpesaRequestXsdPath());
        payloadValidatingInterceptorWithSourceFix.setSchema(resource);
        payloadValidatingInterceptorWithSourceFix.setValidateRequest(true);
        payloadValidatingInterceptorWithSourceFix.setValidateResponse(true);
        return payloadValidatingInterceptorWithSourceFix;
    }

    @Bean(name = "mpesaSaajSoapMessageFactory")
    public SaajSoapMessageFactory messageFactory() {
        SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory();
//        Map<String, Object> stringMap = new HashMap<>();
//        stringMap.putIfAbsent(SOAPMessage.CHARACTER_SET_ENCODING, "UTF-16");
//        stringMap.putIfAbsent(SOAPMessage.WRITE_XML_DECLARATION, "true");

//        messageFactory.setMessageProperties(stringMap);
        messageFactory.afterPropertiesSet();
        return messageFactory;
    }

    @Bean(name = "mpesaMarshaller")
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPaths(properties.getMarshallerPackagesToScan().split(","));
        Map<String, Object> stringMap = new HashMap<>();

//        stringMap.putIfAbsent(Marshaller.JAXB_FRAGMENT, Boolean.FALSE);
        stringMap.putIfAbsent("com.sun.xml.internal.bind.xmlHeaders", "<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
//        stringMap.putIfAbsent("jaxb.encoding", "US-ASCII");
//        stringMap.putIfAbsent(Marshaller.JAXB_ENCODING, "US-ASCII");
//        stringMap.putIfAbsent("jaxb.encoding", "UTF-8");
//        stringMap.putIfAbsent(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//        stringMap.putIfAbsent(CharacterEscapeHandler.class.getName(), new CompleteCharacterEscapeHandler());
        marshaller.setMarshallerProperties(stringMap);
//        marshaller.setPackagesToScan(properties.getMarshallerPackagesToScan().split(","));
        return marshaller;
    }

    @Bean(name = "mpesaUnMarshaller")
    public Jaxb2Marshaller unmarshaller() {
        Jaxb2Marshaller unmarshaller = new Jaxb2Marshaller();
        unmarshaller.setContextPaths(properties.getUnMarshallerPackagesToScan().split(","));
//        unmarshaller.setPackagesToScan(properties.getUnMarshallerPackagesToScan().split(","));
        return unmarshaller;
    }

    @Bean(name = "mpesaMessageSender")
    public HttpComponentsMessageSender messageSender() {
//        HttpComponentsMessageSender sender = new HttpComponentsMessageSender();

        return new HttpComponentsMessageSender();
    }

    @Bean(name = "mpesaWebServiceTemplate")
    public WebServiceTemplate webServiceTemplate() {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(messageFactory());
        webServiceTemplate.setMarshaller(marshaller());
        webServiceTemplate.setUnmarshaller(unmarshaller());
        webServiceTemplate.setMessageSender(messageSender());
        webServiceTemplate.setDefaultUri(properties.getBrokerEndPoint());

//        ClientInterceptor[] interceptors = new ClientInterceptor[] {payloadValidatingInterceptorWithSourceFix()};
//
//        webServiceTemplate.setInterceptors(interceptors);
        return webServiceTemplate;
    }

}
