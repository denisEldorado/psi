package org.muhia.app.psi.integ.sms.africastalking;
/**
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

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.AsyncHttpClientConfig;
import org.asynchttpclient.DefaultAsyncHttpClientConfig;
import org.asynchttpclient.RequestBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.muhia.app.psi.config.http.properties.AsyncHttpClientConfigProperties;
import org.muhia.app.psi.config.integ.ke.africastalkingproperties.AfricasTalkingProperties;
import org.muhia.app.psi.config.security.HashingImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.asynchttpclient.Dsl.asyncHttpClient;

/**
 * Created by KennethKZMMuhia
 * Project: psi
 * Package: org.muhia.app.psi.integ.sms
 * Generated on: 13-Apr-17, 20:34
 */
@Component
public class AfricasTalkingGateway {
    private final AfricasTalkingProperties properties;
    private final HashingImplementation hasher;
    private final AsyncHttpClientConfigProperties asyncHttpClientConfigProperties;
//    private final SslContextFactory sslContextFactory;

    @Autowired
    public AfricasTalkingGateway(AfricasTalkingProperties properties, HashingImplementation hasher, AsyncHttpClientConfigProperties asyncHttpClientConfigProperties) {
        this.properties = properties;
        this.hasher = hasher;
        this.asyncHttpClientConfigProperties = asyncHttpClientConfigProperties;
        /**
         * TODO: Implement SSL for AsycCLient
         */
//        this.sslContextFactory = sslContextFactory;
    }

    private JSONArray sendPostSmsRequest(HashMap<String, String> dataMap, String urlString, String httpMethod) throws IOException {
        final JSONArray[] jsonArray = {new JSONArray()};
        AsyncHttpClientConfig cf = new DefaultAsyncHttpClientConfig.Builder()
                .setCompressionEnforced(asyncHttpClientConfigProperties.isAsynchttpclientCompressionEnforced())
                .setPooledConnectionIdleTimeout(asyncHttpClientConfigProperties.getAsynchttpclientPooledConnectionIdleTimeout())
                .setRequestTimeout(asyncHttpClientConfigProperties.getAsynchttpclientRequestTimeout())
                .setMaxConnectionsPerHost(asyncHttpClientConfigProperties.getAsynchttpclientMaxConnectionsPerHost())
                .setRequestTimeout(asyncHttpClientConfigProperties.getAsynchttpclientRequestTimeout())
//                    .setSslContext((SSLContext) sslContextFactory.createSslContext().getClientSessionContext())
                .build();


        try (AsyncHttpClient client = asyncHttpClient(cf)) {
            RequestBuilder builder = new RequestBuilder(httpMethod);
//            dataMap.forEach(builder::addFormParam);
            dataMap.forEach((p, v) -> {
                try {
                    builder.addFormParam(p, URLEncoder.encode(v, properties.getIntegUrlEncodeEncoding()));
                } catch (UnsupportedEncodingException e) {
                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                }
            });

            builder
                    .setUrl(urlString)
                    .addHeader(properties.getUrlHeaderAcceptKeyword(), properties.getUrlHeaderAcceptData())
                    .addHeader(properties.getUrlHeaderApiKeyword(), hasher.getDecryptedValue(properties.getUrlHeaderApiData()))
                    .build();

            client
                    .executeRequest(builder)
                    .toCompletableFuture()
                    .thenApply(response -> {
                        Logger.getLogger(this.getClass().getName()).log(Level.FINE, response.getResponseBody());
                        JSONObject jsObject = new JSONObject();
                        try {
                            if (response.getStatusCode() != properties.getResponseCodeHttpCreated()) {
                                Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("Received [HttpStatus = %d, Text = %s, URL = %s] processing halted!", response.getStatusCode(), response.getStatusText(), urlString));
                            } else {
                                jsObject = new JSONObject(response.getResponseBody());
                                Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("Received [HttpStatus = %d, Text = %s, URL = %s] processing halted!", response.getStatusCode(), response.getStatusText(), jsObject.toString()));
                            }

                        } catch (Exception e) {
                            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, String.format("JSON Processing failed, [Message= %s, URL= %s]", e.getMessage(), urlString));

                        }
                        return jsObject;

                    })
                    .thenAccept(object -> {
                        try {
                            if (object.length() > 0) {

                                JSONArray recipients = object.getJSONObject(properties.getSmsMessageDataKeyword()).getJSONArray(properties.getIntegResponseRecipientsKeyword());
                                if (recipients.length() > 0) {
                                    jsonArray[0] = recipients;
                                } else {

                                        throw new Exception(object.getJSONObject(properties.getSmsMessageDataKeyword()).getString(properties.getIntegResponseMessageKeyword()));

                                }
                            }
                        }catch (Exception e){
                            jsonArray[0] = new JSONArray(e.getMessage());
                            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, String.format("SMS Sending failed failed, [Message= %s, URL= %s]", e.getMessage(), urlString));
                        }
                    })
                    .join();

        }

        return jsonArray[0];
    }

    public JSONArray sendMessage(String to_, String message_, String from_) throws Exception {
        HashMap<String, String> data = new HashMap<>();
        data.put(properties.getIntegUsernameKeyword(), hasher.getDecryptedValue(properties.getIntegUsernameData()));
        data.put(properties.getIntegToKeyword(), to_);
        data.put(properties.getIntegSmsMessageKeyword(), message_);

        if (from_.length() > 0) data.put(properties.getIntegFromKeyword(), from_);

        return sendPostSmsRequest(data, properties.getProdApiHost() + properties.getSmsUrl(), properties.getIntegHttpMethodPost());
    }
}
