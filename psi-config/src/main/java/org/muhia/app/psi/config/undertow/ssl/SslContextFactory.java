package org.muhia.app.psi.config.undertow.ssl;

import org.muhia.app.psi.config.loaders.ResourceLoaderService;
import org.muhia.app.psi.config.security.HashingImplementation;
import org.muhia.app.psi.config.undertow.properties.UndertowConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;

/*
  Created by Kenneth Muhia <muhia@muhia.org>
  Project: psi
  Package: org.muhia.app.psi.config.undertow.properties
  Generated on: 10-Mar-17, 23:03.
 */
@Component
public class SslContextFactory {
    private final static TrustManager[] TRUST_ALL_CERTS = new X509TrustManager[]{new DummyTrustManager()};
    private final UndertowConfigurationProperties properties;
    private final ResourceLoaderService loaderService;
    private final HashingImplementation hasher;


    @Autowired
    public SslContextFactory(UndertowConfigurationProperties properties, ResourceLoaderService loaderService, HashingImplementation hasher) {
        this.properties = properties;
        this.loaderService = loaderService;
        this.hasher = hasher;
    }

    public SSLContext createSslContext() throws IOException {
        String keyStoreName = properties.getSslServerKeystorePath();
        String keyStoreType = properties.getSslKeystoreType();
        String keyStorePassword = hasher.getDecryptedValue(properties.getSslServerKeystorePassword());
        KeyStore keyStore = loadKeyStore(keyStoreName, keyStoreType, keyStorePassword);

        KeyManager[] keyManagers = buildKeyManagers(keyStore, keyStorePassword.toCharArray());
        TrustManager[] trustManagers = buildTrustManagers(null);
        SSLContext sslContext;

        try {
            sslContext = SSLContext.getInstance(properties.getSslServerContextInstance());
            sslContext.init(keyManagers, trustManagers, null);
        } catch (NoSuchAlgorithmException | KeyManagementException exc) {
            throw new IOException("Unable to create and initialise the SSLContext", exc);
        }

        return sslContext;
    }

    private KeyStore loadKeyStore(final String location, String type, String storePassword) throws IOException {
        /*
            TODO: Use resource loader
         */
        Resource resource = loaderService.getResource(location);


        try (InputStream stream = resource.getInputStream()) {
            KeyStore loadedKeystore = KeyStore.getInstance(type);
            loadedKeystore.load(stream, storePassword.toCharArray());
            return loadedKeystore;
        } catch (KeyStoreException | NoSuchAlgorithmException | CertificateException exc) {
            throw new IOException(String.format("Unable to load KeyStore %s", location), exc);
        }

    }


    private static TrustManager[] buildTrustManagers(final KeyStore trustStore) throws IOException {
        TrustManager[] trustManagers;
        /*
            TODO: trustStore == null does not make sense, to be tested
         */
        if (trustStore != null) {
            try {
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init(trustStore);
                trustManagers = trustManagerFactory.getTrustManagers();
            } catch (NoSuchAlgorithmException | KeyStoreException exc) {
                throw new IOException("Unable to initialise TrustManager[]", exc);
            }
        } else {

            trustManagers = TRUST_ALL_CERTS;

        }

        return trustManagers;

    }

    private static KeyManager[] buildKeyManagers(final KeyStore keyStore, char[] storePassword) throws IOException {
        KeyManager[] keyManagers;
        try {
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keyStore, storePassword);
            keyManagers = keyManagerFactory.getKeyManagers();
        } catch (NoSuchAlgorithmException | UnrecoverableKeyException | KeyStoreException exc) {
            throw new IOException("Unable to initialise KeyManager[]", exc);
        }
        return keyManagers;

    }
}
