/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.integ.config.ke.obopay;

import org.muhia.app.psi.config.integ.properties.ObopayKeProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

/**
 * @author KennethKZMMuhia
 */
@Configuration
public class ObopayClientConfiguration {

    @Autowired
    private ObopayKeProperties keProperties;

    @Bean(name = "obopayMessageFactory")
    public SaajSoapMessageFactory messageFactory() {
        SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory();
        messageFactory.afterPropertiesSet();
        return messageFactory;
    }

    @Bean(name = "obopayMarshaller")
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan(keProperties.getMarshallerPackagesToScan().split(","));
        return marshaller;
    }

    @Bean(name = "obopayUnMarshaller")
    public Jaxb2Marshaller unmarshaller() {
        Jaxb2Marshaller unmarshaller = new Jaxb2Marshaller();
        unmarshaller.setPackagesToScan(keProperties.getUnMarshallerPackagesToScan().split(","));
        return unmarshaller;
    }

    @Bean(name = "obopayMessageSender")
    public HttpComponentsMessageSender messageSender() {
        HttpComponentsMessageSender httpComponentsMessageSender = new HttpComponentsMessageSender();
        return httpComponentsMessageSender;
    }

    @Bean(name = "obopayWebServiceTemplate")
    public WebServiceTemplate webServiceTemplate() {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(messageFactory());
        webServiceTemplate.setMarshaller(marshaller());
        webServiceTemplate.setUnmarshaller(unmarshaller());
        webServiceTemplate.setMessageSender(messageSender());
        webServiceTemplate.setDefaultUri(keProperties.getTargetEndpoint());
        return webServiceTemplate;
    }
}
