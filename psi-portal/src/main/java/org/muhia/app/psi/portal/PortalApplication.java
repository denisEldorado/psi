package org.muhia.app.psi.portal;

import io.undertow.UndertowOptions;
import org.muhia.app.psi.config.undertow.properties.UndertowConfigurationProperties;
import org.muhia.app.psi.config.undertow.ssl.SslContextFactory;
import org.muhia.app.psi.portal.eventbus.AsyncEventbusService;
import org.muhia.app.psi.portal.eventbus.SyncEventBusService;
import org.muhia.app.psi.portal.storage.StorageProperties;
import org.muhia.app.psi.portal.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.undertow.UndertowBuilderCustomizer;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author KennethKZMMuhia
 */
//@SpringBootApplication(scanBasePackages = {"org.muhia.app.psi.", "org.muhia.app.psi.config", "org.muhia.app.psi.infra", "org.muhia.app.psi.orm", "org.muhia.app.psi.integ", "org.muhia.app.psi.portal"})
@SpringBootApplication(scanBasePackages = {"org.muhia.app.psi"})
@EnableWebMvc
@EnableWebSecurity
@EnableScheduling
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableConfigurationProperties(StorageProperties.class)
//@EnableWs
public class PortalApplication {
    private static final SyncEventBusService APPLICATION_EVENT_BUS = new SyncEventBusService();
    private static final AsyncEventbusService ASYNC_EVENT_BUS = new AsyncEventbusService();
    private final UndertowConfigurationProperties undertowConfigurationProperties;
    private final SslContextFactory sslContextFactory;

    @Autowired
    public PortalApplication(UndertowConfigurationProperties undertowConfigurationProperties, SslContextFactory sslContextFactory) {
        this.undertowConfigurationProperties = undertowConfigurationProperties;
        this.sslContextFactory = sslContextFactory;
    }

    public static void main(String[] args) {
        SpringApplication.run(PortalApplication.class, args);


    }


    @Bean
    public static SyncEventBusService dashBoardEventBusService() {

        return APPLICATION_EVENT_BUS;
    }


    @Bean
    public static AsyncEventbusService asyncEventbusService() {
        return ASYNC_EVENT_BUS;
    }

    /*
        TODO: What is this service for
     */
    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> storageService.init();
    }


    @Bean
    public UndertowEmbeddedServletContainerFactory embeddedServletContainerFactory() {
        UndertowEmbeddedServletContainerFactory factory = new UndertowEmbeddedServletContainerFactory();
        factory.addBuilderCustomizers((UndertowBuilderCustomizer) builder -> {
            if (undertowConfigurationProperties.getListenerProductionHttpIp().length != undertowConfigurationProperties.getListenerProductionHttpPort().length) {
                /*
                    TODO: Port and IPs do not match, consider exiting app
                 */
            } else {
                for (int i = 0; i < undertowConfigurationProperties.getListenerProductionHttpsIp().length; i++) {
                    builder.addHttpListener(undertowConfigurationProperties.getListenerProductionHttpPort()[i], undertowConfigurationProperties.getListenerProductionHttpIp()[i]);
                    Logger.getLogger(PortalApplication.class.getName()).log(Level.INFO, String.format("HTTP [Listener %d) = %d:%s]", i, undertowConfigurationProperties.getListenerProductionHttpPort()[i], undertowConfigurationProperties.getListenerProductionHttpIp()[i]));
                }
            }
            /*
                TODO: Add https listener
             */
            if (undertowConfigurationProperties.getListenerProductionHttpsIp().length != undertowConfigurationProperties.getListenerProductionHttpsPort().length) {
                /*
                    TODO: Port and IPs do not match, consider exiting app
                 */
            } else {
                for (int i = 0; i < undertowConfigurationProperties.getListenerProductionHttpsIp().length; i++) {
                    try {
                        builder.addHttpsListener(undertowConfigurationProperties.getListenerProductionHttpsPort()[i], undertowConfigurationProperties.getListenerProductionHttpsIp()[i], sslContextFactory.createSslContext());
                        Logger.getLogger(PortalApplication.class.getName()).log(Level.INFO, String.format("HTTPS [Listener %d) = %d:%s]", i, undertowConfigurationProperties.getListenerProductionHttpsPort()[i], undertowConfigurationProperties.getListenerProductionHttpsIp()[i]));
                    } catch (IOException e) {
                        /*
                            TODO: Exit the application
                        */
                        Logger.getLogger(PortalApplication.class.getName()).log(Level.SEVERE, e.getMessage(), e);
                    }
                }
            }
            builder.setServerOption(UndertowOptions.ENABLE_HTTP2, undertowConfigurationProperties.isListenerHttp2Enable());
            builder.setServerOption(UndertowOptions.RECORD_REQUEST_START_TIME, undertowConfigurationProperties.isListenerRecordRequestStarttime());
            builder.build();

        });
        return factory;
    }


}
