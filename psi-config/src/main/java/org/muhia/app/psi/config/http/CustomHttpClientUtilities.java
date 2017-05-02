/*

  Copyright 2015-2017 the original author or authors.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
 */
package org.muhia.app.psi.config.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.muhia.app.psi.config.http.properties.HttpClientProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@Component
public class CustomHttpClientUtilities {

    @Autowired
    private HttpClientProperties hcp;

    public CloseableHttpResponse doGet(String url, String[] replaceParams, String[] params) {
        CloseableHttpResponse result = null;
        CloseableHttpClient client = null;
        try {
            if (replaceParams.length > 0) {
                for (int i = 0; i < replaceParams.length; i++) {
                    url = url.replaceAll(replaceParams[i], params[i]);
                }
            }

            RequestConfig config = RequestConfig.custom().setConnectTimeout(hcp.getConnectionTimeout()).setConnectionRequestTimeout(hcp.getConnectionRequestTimeout()).setSocketTimeout(hcp.getSockectTimeout()).build();

            client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "url {0} ",url);

            HttpGet getMethod = new HttpGet(url);

            result = client.execute(getMethod);
            client.close();

        } catch (IOException ex) {
            Logger.getLogger(CustomHttpClientUtilities.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            try {
                if (client != null) {
                    client.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(CustomHttpClientUtilities.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "result {0} ",result.getEntity());

        return result;
    }

    public String doGetWithResponseHandler(String url) {
        String result;
        // CloseableHttpResponse response = null;
        CloseableHttpClient client = null;
        try {

            RequestConfig config = RequestConfig.custom().setConnectTimeout(hcp.getConnectionTimeout()).setConnectionRequestTimeout(hcp.getConnectionRequestTimeout()).setSocketTimeout(hcp.getSockectTimeout()).build();

            client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();

            HttpGet getMethod = new HttpGet(url);

            ResponseHandler<String> responseHandler = (final HttpResponse response) -> {
                int status = response.getStatusLine().getStatusCode();
                if (status >= hcp.getLowerStatusLimit() && status <= hcp.getUpperStatusLimit()) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException(hcp.getExceptionMessage() + status);
                }
            };

            result = client.execute(getMethod, responseHandler);
            client.close();

        } catch (SocketTimeoutException ex) {
            result = hcp.getTimeoutMessage();
            Logger.getLogger(CustomHttpClientUtilities.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            result = hcp.getFailMessage();
            Logger.getLogger(CustomHttpClientUtilities.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (client != null) {
                    client.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(CustomHttpClientUtilities.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public String doGetWithResponseHandler(String url, String[] replaceParams, String[] params) {
        String result;
        // CloseableHttpResponse response = null;
        CloseableHttpClient client = null;
        try {
            if (replaceParams.length > 0) {
                for (int i = 0; i < replaceParams.length; i++) {
                    Logger.getLogger(CustomHttpClientUtilities.class.getName()).log(Level.FINE, replaceParams[i], params[i]);
                    url = url.replaceAll(replaceParams[i], params[i]);
                }
            }

            RequestConfig config = RequestConfig.custom().setConnectTimeout(hcp.getConnectionTimeout()).setConnectionRequestTimeout(hcp.getConnectionRequestTimeout()).setSocketTimeout(hcp.getSockectTimeout()).build();

            client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();

            HttpGet getMethod = new HttpGet(url);

            ResponseHandler<String> responseHandler = (final HttpResponse response) -> {
                int status = response.getStatusLine().getStatusCode();
                if (status >= hcp.getLowerStatusLimit() && status <= hcp.getUpperStatusLimit()) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException(hcp.getExceptionMessage() + status);
                }
            };

            result = client.execute(getMethod, responseHandler);
            client.close();

        } catch (SocketTimeoutException ex) {
            result = hcp.getTimeoutMessage();
            Logger.getLogger(CustomHttpClientUtilities.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            result = hcp.getFailMessage();
            Logger.getLogger(CustomHttpClientUtilities.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (client != null) {
                    client.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(CustomHttpClientUtilities.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public String doGetWithResponseHandler(String url, Map<String, String> allRequestParams) {
        AtomicReference<String> result = new AtomicReference<>("");
        // CloseableHttpResponse response = null;
        CloseableHttpClient client = null;
        try {
            HttpGet httpGet = new HttpGet(url);
            URIBuilder uriBuilder = new URIBuilder(httpGet.getURI());

            allRequestParams.entrySet().forEach((entry) -> {
                String key = entry.getKey();
                String value = entry.getValue();
                if (value != null) {
                    uriBuilder.setParameter(key, value);
                }
            });

            httpGet.setURI(uriBuilder.build());

            RequestConfig config = RequestConfig.custom().setConnectTimeout(hcp.getConnectionTimeout()).setConnectionRequestTimeout(hcp.getConnectionRequestTimeout()).setSocketTimeout(hcp.getSockectTimeout()).build();

            client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();

            ResponseHandler<String> responseHandler = (final HttpResponse response) -> {
                int status = response.getStatusLine().getStatusCode();
                if (status >= hcp.getLowerStatusLimit() && status <= hcp.getUpperStatusLimit()) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException(hcp.getUnexpectedStatus() + status);
                }
            };

            result.set(client.execute(httpGet, responseHandler));
            client.close();

        } catch (IOException | URISyntaxException ex) {
            // LoggerFactory.getLogger(CustomHttpClientUtil.class).error(ex.getMessage(),
            // ex);
            Logger.getLogger(CustomHttpClientUtilities.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (client != null) {
                    client.close();
                }

            } catch (IOException ex) {
                // LoggerFactory.getLogger(CustomHttpClientUtil.class).error(ex.getMessage(),
                // ex);
                result.set(hcp.getIoExceptionMessage());
                Logger.getLogger(CustomHttpClientUtilities.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result.get();
    }

    public String doSimpleGet(String url) {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);
        StringBuffer result = new StringBuffer();
        HttpResponse response;
        try {
            response = client.execute(request);
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, MessageFormat.format("Sending 'GET' request to URL :  {0} ",url));
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, MessageFormat.format("Response Code : {0} ",response.getStatusLine().getStatusCode()));
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
        } catch (IOException ex) {
            Logger.getLogger(CustomHttpClientUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result.toString();

    }
    public CloseableHttpResponse doPost(String url, String[] replaceParams, String[] params) {
        CloseableHttpResponse result = null;
        CloseableHttpClient client = null;
        try {
            if (replaceParams.length > 0) {
                for (int i = 0; i < replaceParams.length; i++) {
                    url = url.replaceAll(replaceParams[i], params[i]);
                }
            }

            RequestConfig config = RequestConfig.custom().setConnectTimeout(hcp.getConnectionTimeout()).setConnectionRequestTimeout(hcp.getConnectionRequestTimeout()).setSocketTimeout(hcp.getSockectTimeout()).build();

            client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "url {0} ",url);

            HttpPost postMethod = new HttpPost(url);

            result = client.execute(postMethod);
            client.close();

        } catch (IOException ex) {
            Logger.getLogger(CustomHttpClientUtilities.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            try {
                if (client != null) {
                    client.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(CustomHttpClientUtilities.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "result {0} ",result.getEntity());

        return result;
    }

}
