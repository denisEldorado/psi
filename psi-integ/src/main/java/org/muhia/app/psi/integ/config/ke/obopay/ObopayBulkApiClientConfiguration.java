package org.muhia.app.psi.integ.config.ke.obopay;/**
 * Copyright 2015-2016 the original author or authors.
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
 * <p>
 * <p>
 * Generated on 30-Oct-16 01:30
 */

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.muhia.app.psi.config.integ.properties.ObopayBulkApiProperties;
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

/**
 * Created by KennethKZMMuhia
 * Project: psi
 * Package: org.muhia.app.psi.integ.config.ke.obopay
 * Generated on: 14-Apr-17, 11:27
 */
@Configuration
public class ObopayBulkApiClientConfiguration {
    private final ObopayBulkApiProperties properties;

    @Autowired
    public ObopayBulkApiClientConfiguration(ObopayBulkApiProperties properties) {
        this.properties = properties;
    }

    @Bean(name = "obopayBulkApiSecurityInterceptor")
    public SoapEnvelopeLoggingInterceptor envelopeLoggingInterceptor() {
        SoapEnvelopeLoggingInterceptor obopayBulkApiInterceptor = new SoapEnvelopeLoggingInterceptor();
        obopayBulkApiInterceptor.setLogFault(false);
        obopayBulkApiInterceptor.setLogRequest(true);
        obopayBulkApiInterceptor.setLogResponse(true);
        return obopayBulkApiInterceptor;
    }

    @Bean(name = "obopayBulkApiSecurityInterceptor")
    public Wss4jSecurityInterceptor securityInterceptor() {
        Wss4jSecurityInterceptor wss4jSecurityInterceptor = new Wss4jSecurityInterceptor();
        wss4jSecurityInterceptor.setSecurementActions(properties.getSecurementActions());
        wss4jSecurityInterceptor.setSecurementUsername(properties.getSecurementTransportUsername());
        wss4jSecurityInterceptor.setSecurementPassword(properties.getSecurementTransportPassword());
        wss4jSecurityInterceptor.setSecurementPasswordType("PasswordText");
        wss4jSecurityInterceptor.setSecureRequest(true);
        wss4jSecurityInterceptor.setSecureResponse(false);
        wss4jSecurityInterceptor.setSecurementMustUnderstand(true);

        return wss4jSecurityInterceptor;
    }

    @Bean(name = "obopayBulkApiHttpClient")
    public CloseableHttpClient httpClient() {


        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(properties.getTransportConnectionTimeout())
                .setConnectionRequestTimeout(properties.getTransportReadTimeout())
                .setSocketTimeout(properties.getTransportSocketTimeout())
                .build();
//        CredentialsProvider provider = new BasicCredentialsProvider();
//        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(properties.getCrbaTransunionTransportUsername(), properties.getCrbaTransunionTransportPassword());
//        provider.setCredentials(AuthScope.ANY, credentials);


        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
        connManager.setMaxTotal(properties.getPoolHostMax());
        connManager.setDefaultMaxPerRoute(properties.getPoolDefaultMaxPerhost());
        connManager.setValidateAfterInactivity(properties.getPoolValidateAfterActivity());


        return HttpClientBuilder.create()
                .setDefaultRequestConfig(config)
//                .setDefaultCredentialsProvider(provider)
                .setConnectionManager(connManager)
                .evictExpiredConnections()
                .addInterceptorFirst(new RemoveHttpHeadersInterceptor())
                .build();

    }


    @Bean(name = "obopayBulkApiMessageFactory")
    public SaajSoapMessageFactory messageFactory() {
        SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory();
        messageFactory.afterPropertiesSet();
        return messageFactory;
    }

    @Bean(name = "obopayBulkApiMarshaller")
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan(properties.getBulkpaymentMarshallerPackagesToscan().split(","));
        return marshaller;
    }

    @Bean(name = "obopayBulkApiUnmarshaller")
    public Jaxb2Marshaller unmarshaller() {
        Jaxb2Marshaller unmarshaller = new Jaxb2Marshaller();
        unmarshaller.setPackagesToScan(properties.getBulkpaymentUnmarshallerPackagesToscan().split(","));
        return unmarshaller;
    }

    @Bean(name = "obopayBulkApiMessageSender")
    public HttpComponentsMessageSender messageSender() {
        try {
            HttpComponentsMessageSender obopayBulkApiSender = new HttpComponentsMessageSender(httpClient());
            obopayBulkApiSender.afterPropertiesSet();

            return obopayBulkApiSender;
        } catch (Exception e) {

            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    @Bean(name = "obopayBulkApiWebServiceTemplate")
//    @Bean
    public WebServiceTemplate webServiceTemplate() {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(messageFactory());
        webServiceTemplate.setDefaultUri(properties.getEndpointBulkpaymentProductionUrl());
        webServiceTemplate.setMarshaller(marshaller());
        webServiceTemplate.setUnmarshaller(unmarshaller());
        webServiceTemplate.setMessageSender(messageSender());

        return webServiceTemplate;
    }
}
