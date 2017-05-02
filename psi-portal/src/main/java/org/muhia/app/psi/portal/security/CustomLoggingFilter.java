/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.security;

import org.muhia.app.psi.config.security.HashingImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@Component
public class CustomLoggingFilter extends GenericFilterBean {
    private final HashingImplementation hasher;

    @Autowired
    public CustomLoggingFilter(HashingImplementation hasher) {
        this.hasher = hasher;
    }

    @Override
    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        final String url = httpServletRequest.getRequestURL().toString();
        final String queryString = Optional.ofNullable(httpServletRequest.getQueryString()).map(value -> "?" + hasher.getEncryptedValue(value)).orElse("");
        Logger.getLogger(CustomLoggingFilter.class.getName()).info(String.format("Request Logging for URI: %s%s", url, queryString));

        filterChain.doFilter(servletRequest, servletResponse);
    }

}
