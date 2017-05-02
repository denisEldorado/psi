package org.muhia.app.psi.config.web.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/*
  Created by Kenneth Muhia <muhia@muhia.org>
  Project: psi
  Package: org.muhia.app.psi.config
  Generated on: 14-Mar-17, 04:55.
 */
@Configuration
@PropertySource(value = {"file:${CONFIG_PATH}/web-mvc.properties"})
public class WebMvcProperties {
    @Value("${org.muhia.app.psi.config.web.mvc.list.resource.ignored}")
    private String[] listResourceIgnored;
    @Value("${org.muhia.app.psi.config.web.mvc.list.resource.permitall}")
    private String[] listResourcePermitall;
    @Value("${org.muhia.app.psi.config.web.mvc.list.resource.admin}")
    private String[] listResourceAdmin;
    @Value("${org.muhia.app.psi.config.web.mvc.has.role.admin}")
    private String hasRoleAdmin;
    @Value("${org.muhia.app.psi.config.web.mvc.key.anonymous}")
    private String keyAnonymous;
    @Value("${org.muhia.app.psi.config.web.mvc.login.page}")
    private String loginPage;
    @Value("${org.muhia.app.psi.config.web.mvc.login.processing.url}")
    private String loginProcessingUrl;
    @Value("${org.muhia.app.psi.config.web.mvc.token.rememberme}")
    private String tokenRememberme;
    @Value("${org.muhia.app.psi.config.web.mvc.access.forbidden.page}")
    private String accessForbiddenPage;

    @Value("${org.muhia.app.psi.config.web.mvc.post.login.url}")
    private String postLoginUrl;
    @Value("${org.muhia.app.psi.config.web.mvc.list.resource.api}")
    private String listResourceApi;
    @Value("${org.muhia.app.psi.config.web.mvc.has.role.user}")
    private String hasRoleUser;
    @Value("${org.muhia.app.psi.config.web.mvc.has.role.api}")
    private String hasRoleApi;
    @Value("${org.muhia.app.psi.config.web.mvc.has.role.ui}")
    private String hasRoleUi;
    @Value("${org.muhia.app.psi.config.web.mvc.logout.processing.url}")
    private String logoutProcessingUrl;
    @Value("${org.muhia.app.psi.config.web.mvc.http.basic.auth.realm}")
    private String httpBasicAuthRealm;

    public String[] getListResourceIgnored() {
        return listResourceIgnored;
    }

    public String[] getListResourcePermitall() {
        return listResourcePermitall;
    }

    public String[] getListResourceAdmin() {
        return listResourceAdmin;
    }

    public String getHasRoleAdmin() {
        return hasRoleAdmin;
    }

    public String getKeyAnonymous() {
        return keyAnonymous;
    }

    public String getLoginPage() {
        return loginPage;
    }

    public String getLoginProcessingUrl() {
        return loginProcessingUrl;
    }

    public String getTokenRememberme() {
        return tokenRememberme;
    }

    public String getAccessForbiddenPage() {
        return accessForbiddenPage;
    }

    public String getPostLoginUrl() {
        return postLoginUrl;
    }

    public String getListResourceApi() {
        return listResourceApi;
    }

    public String getHasRoleUser() {
        return hasRoleUser;
    }

    public String getHasRoleUi() {
        return hasRoleUi;
    }

    public String getLogoutProcessingUrl() {
        return logoutProcessingUrl;
    }

    public String getHasRoleApi() {
        return hasRoleApi;
    }

    public String getHttpBasicAuthRealm() {
        return httpBasicAuthRealm;
    }
}
