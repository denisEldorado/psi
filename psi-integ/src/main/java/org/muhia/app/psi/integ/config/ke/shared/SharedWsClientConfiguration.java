package org.muhia.app.psi.integ.config.ke.shared;/*
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
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.muhia.app.psi.config.integ.properties.shared.SharedWsClientProperties;
import org.muhia.app.psi.config.loaders.ResourceLoaderService;
import org.muhia.app.psi.config.security.HashingImplementation;
import org.muhia.app.psi.infra.dto.SharedDataDTO;
import org.muhia.app.psi.integ.config.interceptors.RemoveHttpHeadersInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
  Created by Kenneth Muhia <muhia@muhia.org>
  Project: psi
  Package: org.muhia.app.psi.integ.config.ke.shared
  Generated on: 11-Feb-17, 11:50.
 */
@Configuration
public class SharedWsClientConfiguration {
    private final ResourceLoaderService loaderService;
    private final SharedWsClientProperties properties;
    private final HashingImplementation hasher;
    private final SharedDataDTO sharedDataDTO;


    @Autowired
    public SharedWsClientConfiguration(ResourceLoaderService loaderService, SharedWsClientProperties properties, HashingImplementation hasher, SharedDataDTO sharedDataDTO) {
        this.loaderService = loaderService;
        this.properties = properties;
        this.hasher = hasher;
        this.sharedDataDTO = sharedDataDTO;
    }



    @Bean(name = "sharedSecureHttpClient")
    public CloseableHttpClient secureHttpClient() {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        try {
            /*
                TODO: Modify to accept only specific certificates, test implementation is as below,
                TODO: need to find a way of determining if server url is https or not
                TODO: Whether we have imported the certificate or not
            */
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            Resource resource = loaderService.getResource(properties.getSharedKeystorePath());
            keyStore.load(resource.getInputStream(), hasher.getDecryptedValue(properties.getSharedKeystorePassword()).toCharArray());
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustSelfSignedStrategy()).loadKeyMaterial(keyStore, hasher.getDecryptedValue(properties.getSharedKeystorePassword()).toCharArray()).build();
//            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, (certificate, authType) -> true).build();

            RequestConfig config = RequestConfig.custom()
                    .setConnectTimeout(properties.getSharedTransportConnectionTimeout())
                    .setConnectionRequestTimeout(properties.getSharedTransportConnectionRequestTimeout())
                    .setSocketTimeout(properties.getSharedTransportReadTimeout())
                    .build();
            CredentialsProvider provider = new BasicCredentialsProvider();
            UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(sharedDataDTO.getTransportUsername(), sharedDataDTO.getTransportPassword());
            provider.setCredentials(AuthScope.ANY, credentials);


            PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
            connManager.setMaxTotal(properties.getSharedPoolMaxHost());
            connManager.setDefaultMaxPerRoute(properties.getSharedPoolDefaultmaxPerhost());
            connManager.setValidateAfterInactivity(properties.getSharedPoolValidateAfterInactivity());
            httpClient =
                    HttpClientBuilder.create()
                            .setSSLContext(sslContext)
                            .setSSLHostnameVerifier(new NoopHostnameVerifier())
                            .setDefaultRequestConfig(config)
                            .setDefaultCredentialsProvider(provider)
                            .setConnectionManager(connManager)
                            .evictExpiredConnections()
                            .addInterceptorFirst(new RemoveHttpHeadersInterceptor())
                            .build();
        } catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException | CertificateException | IOException | UnrecoverableKeyException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return httpClient;

    }
}
