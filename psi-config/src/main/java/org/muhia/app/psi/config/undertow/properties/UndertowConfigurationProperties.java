package org.muhia.app.psi.config.undertow.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/*
  Created by Kenneth Muhia <muhia@muhia.org>
  Project: psi
  Package: org.muhia.app.psi.config
  Generated on: 10-Mar-17, 22:14.
 */
@Configuration
@PropertySource(value = {"file:${CONFIG_PATH}/undertow-config.properties"})
public class UndertowConfigurationProperties {
    @Value("${org.muhia.psi.config.http.server.undertow.listener.counter}")
    private String listenerCounter;
    @Value("${org.muhia.psi.config.http.server.undertow.listener.production.http.port}")
    private int[] listenerProductionHttpPort;
    @Value("${org.muhia.psi.config.http.server.undertow.listener.production.https.port}")
    private int[] listenerProductionHttpsPort;
    @Value("${org.muhia.psi.config.http.server.undertow.listener.production.http.ip}")
    private String[] listenerProductionHttpIp;
    @Value("${org.muhia.psi.config.http.server.undertow.listener.production.https.ip}")
    private String[] listenerProductionHttpsIp;
    @Value("${org.muhia.psi.config.http.server.undertow.listener.test.http.port}")
    private String[] listenerTestHttpPort;
    @Value("${org.muhia.psi.config.http.server.undertow.listener.test.https.port}")
    private String[] listenerTestHttpsPort;
    @Value("${org.muhia.psi.config.http.server.undertow.listener.test.http.ip}")
    private String[] listenerTestHttpIp;
    @Value("${org.muhia.psi.config.http.server.undertow.listener.test.https.ip}")
    private String[] listenerTestHttpsIp;
    @Value("${org.muhia.psi.config.http.server.undertow.listener.http2.enable}")
    private boolean listenerHttp2Enable;
    @Value("${org.muhia.psi.config.http.server.undertow.ssl.client.keystore.path}")
    private String sslClientKeystorePath;
    @Value("${org.muhia.psi.config.http.server.undertow.ssl.client.truststore.path}")
    private String sslClientTruststorePath;
    @Value("${org.muhia.psi.config.http.server.undertow.ssl.server.keystore.path}")
    private String sslServerKeystorePath;
    @Value("${org.muhia.psi.config.http.server.undertow.ssl.server.truststore.path}")
    private String sslServerTruststorePath;
    @Value("${org.muhia.psi.config.http.server.undertow.ssl.server.keystore.password}")
    private String sslServerKeystorePassword;
    @Value("${org.muhia.psi.config.http.server.undertow.ssl.server.truststore.password}")
    private String sslServerTruststorePassword;
    @Value("${org.muhia.tau.config.http.server.undertow.ssl.keystore.keyword}")
    private String sslKeystoreKeyword;
    @Value("${org.muhia.tau.config.http.server.undertow.ssl.truststore.keyword}")
    private String sslTruststoreKeyword;
    @Value("${org.muhia.tau.config.http.server.undertow.ssl.keystore.type}")
    private String sslKeystoreType;
    @Value("${org.muhia.tau.config.http.server.undertow.ssl.server.context.instance}")
    private String sslServerContextInstance;
    @Value("${org.muhia.psi.config.http.server.undertow.listener.record.request.starttime}")
    private boolean listenerRecordRequestStarttime;


    public String getListenerCounter() {
        return listenerCounter;
    }

    public int[] getListenerProductionHttpPort() {
        return listenerProductionHttpPort;
    }

    public int[] getListenerProductionHttpsPort() {
        return listenerProductionHttpsPort;
    }

    public String[] getListenerProductionHttpIp() {
        return listenerProductionHttpIp;
    }

    public String[] getListenerProductionHttpsIp() {
        return listenerProductionHttpsIp;
    }

    public String[] getListenerTestHttpPort() {
        return listenerTestHttpPort;
    }

    public String[] getListenerTestHttpsPort() {
        return listenerTestHttpsPort;
    }

    public String[] getListenerTestHttpIp() {
        return listenerTestHttpIp;
    }

    public String[] getListenerTestHttpsIp() {
        return listenerTestHttpsIp;
    }

    public boolean isListenerHttp2Enable() {
        return listenerHttp2Enable;
    }

    public String getSslClientKeystorePath() {
        return sslClientKeystorePath;
    }

    public String getSslClientTruststorePath() {
        return sslClientTruststorePath;
    }

    public String getSslServerKeystorePath() {
        return sslServerKeystorePath;
    }

    public String getSslServerTruststorePath() {
        return sslServerTruststorePath;
    }

    public String getSslServerKeystorePassword() {
        return sslServerKeystorePassword;
    }

    public String getSslServerTruststorePassword() {
        return sslServerTruststorePassword;
    }

    public String getSslKeystoreKeyword() {
        return sslKeystoreKeyword;
    }

    public String getSslTruststoreKeyword() {
        return sslTruststoreKeyword;
    }

    public String getSslKeystoreType() {
        return sslKeystoreType;
    }

    public String getSslServerContextInstance() {
        return sslServerContextInstance;
    }

    public boolean isListenerRecordRequestStarttime() {
        return listenerRecordRequestStarttime;
    }
}
