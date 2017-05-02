/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.security;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 */
public class CustomPersistentTokenBasedRememberMeServices extends org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices {

    public CustomPersistentTokenBasedRememberMeServices(String key, UserDetailsService userDetailsService, PersistentTokenRepository tokenRepository) {
        super(key, userDetailsService, tokenRepository);
    }

    @Override
    protected boolean rememberMeRequested(HttpServletRequest request, String parameter) {
        if (request.getAttribute(DEFAULT_PARAMETER) != null && (boolean) request.getAttribute(DEFAULT_PARAMETER)) {
            request.removeAttribute(DEFAULT_PARAMETER);
            return true;
        }
        return super.rememberMeRequested(request, parameter);

    }

}
