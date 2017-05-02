
package org.muhia.app.psi.portal.config;

import org.muhia.app.psi.config.web.properties.WebMvcProperties;
import org.muhia.app.psi.portal.security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;
import java.security.SecureRandom;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 */

public class SecurityConfiguration {

    @Configuration
    @EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
    public static class CustomGlobalMethodSecurityConfiguration extends GlobalMethodSecurityConfiguration {

        @Bean
        @Override
        public AccessDecisionManager accessDecisionManager() {
            return super.accessDecisionManager();
        }
    }

    /**
     * WebSecurity configuration
     *
     * @author Kenneth Muhia <muhia@muhia.org>
     */
    @Configuration
    @EnableWebSecurity
    public static class CustomWebSecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Autowired
        @Qualifier(value = "psiCustomUserDetailsService")
        private UserDetailsService userDetailsService;
        @Autowired
        private DataSource dataSource;
        @Autowired
        private CustomLoggingFilter customLoggingFilter;
        @Autowired
        private AuthenticationSuccessHandler authenticationSuccessHandler;
        @Autowired
        private AuthenticationFailureHandler authenticationFailureHandler;
        @Autowired
        private WebMvcProperties properties;
        @Autowired
        private RestAuthenticationEntryPoint authenticationEntryPoint;




        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder(12, new SecureRandom());
        }

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
           // auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

            auth.inMemoryAuthentication()
                    .withUser("admin")
                    .password("password")
                    .roles("ROLE_ADMIN");
        }


        @Bean(name = "authenticationManager")
        @Override
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
        }

        @Bean
        public PersistentTokenRepository jdbcTokenRepository() {
            JdbcTokenRepositoryImpl repository = new JdbcTokenRepositoryImpl();
            repository.setCreateTableOnStartup(false);
            repository.setDataSource(dataSource);
            return repository;
        }

        @Bean
        public RememberMeServices persistentTokenBasedRememberMeServices() {
            return new CustomPersistentTokenBasedRememberMeServices(properties.getTokenRememberme(), userDetailsService, jdbcTokenRepository());
        }


        @Override
        protected void configure(HttpSecurity http) throws Exception {

            // @formatter:off
            http.addFilterBefore(customLoggingFilter, AnonymousAuthenticationFilter.class)
//                    .csrf().disable()
                    .csrf().disable()
                        .authorizeRequests()
                    .and()
                        .exceptionHandling()
                        .authenticationEntryPoint(authenticationEntryPoint)
                        .accessDeniedPage(properties.getAccessForbiddenPage())
                    .and()

                        .authorizeRequests()
                            .antMatchers(properties.getListResourceIgnored() ).permitAll()
                            .antMatchers(properties.getListResourcePermitall()).permitAll()
                            .antMatchers(properties.getListResourceAdmin())
                                .hasAuthority(properties.getHasRoleAdmin())
                            .antMatchers(properties.getListResourceApi())
                                .hasAnyAuthority(properties.getHasRoleApi())
                                    .anyRequest()
                                    .authenticated()
                                .and()
                                    .httpBasic()
                                    .realmName(properties.getHttpBasicAuthRealm())
                    .and()
                        .anonymous()
                        .key(properties.getKeyAnonymous())
                    .and()
                        .formLogin()
                            .loginPage(properties.getLoginPage()).permitAll()
                            .loginProcessingUrl(properties.getLoginProcessingUrl())
                            .successHandler(authenticationSuccessHandler)
                            .failureHandler(authenticationFailureHandler)
                    .and()
                        .logout()
                            .permitAll()
                            .deleteCookies(properties.getTokenRememberme())
                            .logoutUrl(properties.getLogoutProcessingUrl())
                    .and()
                        .rememberMe().key(properties.getTokenRememberme())
                        .rememberMeServices(persistentTokenBasedRememberMeServices())

                    /*
                        TODO: Set up postlogin url
                     */
//                    .csrf().disable()
                    ;

            // @formatter:on
        }

    }

}
