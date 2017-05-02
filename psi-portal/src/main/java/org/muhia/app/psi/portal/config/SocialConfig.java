package org.muhia.app.psi.portal.config;

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

import org.muhia.app.psi.config.external.properties.ExternalProperties;
import org.muhia.app.psi.config.security.HashingImplementation;
import org.muhia.app.psi.portal.security.CustomSocialSignInAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.linkedin.connect.LinkedInConnectionFactory;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;

import javax.sql.DataSource;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
    Created by Kenneth Muhia <muhia@muhia.org> 
    Project: psi
    Package: org.muhia.app.psi.portal.config
    Date: 02-Jan-17.
*/
@Configuration
@EnableSocial
public class SocialConfig extends SocialConfigurerAdapter {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private ExternalProperties properties;
    @Autowired
    private Environment environment;
    @Autowired
    private HashingImplementation hasher;

    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer cfConfig, Environment env) {
        try {
            cfConfig.addConnectionFactory(new TwitterConnectionFactory(hasher.getDecryptedValue(properties.getTwitterAppId()), hasher.getDecryptedValue(properties.getTwitterAppSecret())));
            cfConfig.addConnectionFactory(new FacebookConnectionFactory(hasher.getDecryptedValue(properties.getFacebookAppId()), hasher.getDecryptedValue(properties.getFacebookAppSecret())));
            cfConfig.addConnectionFactory(new GoogleConnectionFactory(hasher.getDecryptedValue(properties.getGoogleAppId()), hasher.getDecryptedValue(properties.getGoogleAppSecret())));
            cfConfig.addConnectionFactory(new LinkedInConnectionFactory(hasher.getDecryptedValue(properties.getLinkedinAppId()), hasher.getDecryptedValue(properties.getLinkedinAppSecret())));
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }


    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        /*
            TODO: Change to a more secure mechanism
            TODO: Implement SignIn UI using social and test
         */
        return new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());
    }

    @Bean
    public SignInAdapter signInAdapter() {
        return new CustomSocialSignInAdapter(new HttpSessionRequestCache());
    }

    @Bean
    public ProviderSignInUtils providerSignInUtils(ConnectionFactoryLocator connectionFactoryLocator, UsersConnectionRepository connectionRepository) {
        return new ProviderSignInUtils(connectionFactoryLocator, connectionRepository);
    }
}
