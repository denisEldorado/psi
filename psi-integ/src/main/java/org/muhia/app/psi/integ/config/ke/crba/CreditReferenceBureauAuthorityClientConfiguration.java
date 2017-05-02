package org.muhia.app.psi.integ.config.ke.crba;

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


import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.muhia.app.psi.config.integ.ke.properties.CreditReferenceBureauAuthorityProperties;
import org.muhia.app.psi.integ.config.interceptors.RemoveHttpHeadersInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;
import org.springframework.ws.soap.server.endpoint.interceptor.SoapEnvelopeLoggingInterceptor;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
    Created by Kenneth Muhia <muhia@muhia.org> 
    Project: psi
    Package: org.muhia.app.psi.integ.config
    Generated on: 05-Feb-17.
*/
@Configuration
public class CreditReferenceBureauAuthorityClientConfiguration {
    private final CreditReferenceBureauAuthorityProperties properties;

    @Autowired
    public CreditReferenceBureauAuthorityClientConfiguration(CreditReferenceBureauAuthorityProperties properties) {
        this.properties = properties;
    }

    @Bean
    public SoapEnvelopeLoggingInterceptor envelopeLoggingInterceptor() {
        SoapEnvelopeLoggingInterceptor interceptor = new SoapEnvelopeLoggingInterceptor();
        interceptor.setLogFault(false);
        interceptor.setLogRequest(true);
        interceptor.setLogResponse(true);
        return interceptor;
    }

    @Bean(name = "transunionSecurityInterceptor")
    public Wss4jSecurityInterceptor securityInterceptor() {
        Wss4jSecurityInterceptor wss4jSecurityInterceptor = new Wss4jSecurityInterceptor();
        wss4jSecurityInterceptor.setSecurementActions(properties.getCrbaTransunionSecurementActions());
        wss4jSecurityInterceptor.setSecurementUsername(properties.getCrbaTransunionTransportUsername());
        wss4jSecurityInterceptor.setSecurementPassword(properties.getCrbaTransunionTransportPassword());
        wss4jSecurityInterceptor.setSecurementPasswordType("PasswordText");
        wss4jSecurityInterceptor.setSecureRequest(true);
        wss4jSecurityInterceptor.setSecureResponse(false);
        wss4jSecurityInterceptor.setSecurementMustUnderstand(true);
//        wss4jSecurityInterceptor.setValidationActions(properties.getCrbaTransunionValidationActions());

        return wss4jSecurityInterceptor;
    }


    @Bean(name = "transunionHttpClient")
    public CloseableHttpClient httpClient() {


        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(properties.getCrbaTransportConnectionTimeout())
                .setConnectionRequestTimeout(properties.getCrbaTransportConnectionRequestTimeout())
                .setSocketTimeout(properties.getCrbaTransportReadTimeout())
                .build();
        CredentialsProvider provider = new BasicCredentialsProvider();
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(properties.getCrbaTransunionTransportUsername(), properties.getCrbaTransunionTransportPassword());
        provider.setCredentials(AuthScope.ANY, credentials);


        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
        connManager.setMaxTotal(properties.getCrbaPoolMaxHost());
        connManager.setDefaultMaxPerRoute(properties.getCrbaPoolDefaultmaxPerhost());
        connManager.setValidateAfterInactivity(properties.getCrbaPoolValidateAfterInactivity());


        return HttpClientBuilder.create()
                .setDefaultRequestConfig(config)
                .setDefaultCredentialsProvider(provider)
                .setConnectionManager(connManager)
                .evictExpiredConnections()
                .addInterceptorFirst(new RemoveHttpHeadersInterceptor())
                .build();

    }


    @Bean(name = "transunionMessageFactory")
    public SaajSoapMessageFactory messageFactory() {
        SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory();
        messageFactory.afterPropertiesSet();
        return messageFactory;
    }

    @Bean(name = "transunionMarshaller")
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//        marshaller.setContextPaths(properties.getCrbaTransunionMarshallerContext().split(","));
        marshaller.setPackagesToScan(properties.getCrbaTransunionMarshallerContext().split(","));

        return marshaller;
    }

    @Bean(name = "transunionUnmarshaller")
    public Jaxb2Marshaller unmarshaller() {
        Jaxb2Marshaller unmarshaller = new Jaxb2Marshaller();
        /*
            TODO: Find out what contextPath means and how to configure
         */
//        unmarshaller.setContextPaths(properties.getCrbaTransunionUnmarshallerContext().split(","));
        unmarshaller.setPackagesToScan(properties.getCrbaTransunionUnmarshallerContext().split(","));

        return unmarshaller;
    }

    @Bean(name = "transunionCrbaMessageSender")
    public HttpComponentsMessageSender messageSender() {
        try {
            HttpComponentsMessageSender sender = new HttpComponentsMessageSender(httpClient());
//            sender.setConnectionTimeout(properties.getCrbaTransportConnectionTimeout());
//            sender.setReadTimeout(properties.getCrbaTransportReadTimeout());


            sender.afterPropertiesSet();

            return sender;
        } catch (Exception e) {

            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    @Bean(name = "transunionCrbaWebServiceTemplate")
//    @Bean
    public WebServiceTemplate webServiceTemplate() {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(messageFactory());
        webServiceTemplate.setDefaultUri(properties.getCrbaTransunionUrl());
        webServiceTemplate.setMarshaller(marshaller());
        webServiceTemplate.setUnmarshaller(unmarshaller());
        webServiceTemplate.setMessageSender(messageSender());

//        ClientInterceptor[] interceptors = new ClientInterceptor[]{securityInterceptor()};
//
//        webServiceTemplate.setInterceptors(interceptors);

        return webServiceTemplate;
    }

}
