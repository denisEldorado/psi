/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.security;

import org.muhia.app.psi.orm.model.Principals;
import org.muhia.app.psi.portal.service.orm.IPrincipalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ngatia
 */
@Configuration
public class AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final IPrincipalsService principalsService;

    private RequestCache requestCache = new HttpSessionRequestCache();

    @Autowired
    public AuthenticationSuccessHandler(NoRedirectStrategy noRedirectStrategy, IPrincipalsService principalsService) {
        super();
        setRedirectStrategy(noRedirectStrategy);
        this.principalsService = principalsService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        super.onAuthenticationSuccess(request, response, authentication);
        User principal = (User) authentication.getPrincipal();
        Principals principals = principalsService.findByLoginName(principal.getUsername());
        PrintWriter pr = response.getWriter();


        //check if request is not from mobile then redirect
        if (request.getHeader("Device").equals("Android")) {
            pr.write("true-" + principals.getEmailaddress() + "-" + principals.getLoginName() + "-" + principals.getCellphonenumber());
        } else if (request.getHeader("Device").equals("API")) {
            /*
                TODO: Test for API access requests, to ensure that they return status 200 not 302
             */
            SavedRequest savedRequest = requestCache.getRequest(request, response);
            if (savedRequest == null) {
                clearAuthenticationAttributes(request);
                return;
            }
            String targetUrlParam = getTargetUrlParameter();
            if (isAlwaysUseDefaultTargetUrl() || (targetUrlParam != null && StringUtils.hasText(request.getParameter(targetUrlParam)))) {
                requestCache.removeRequest(request, response);
                clearAuthenticationAttributes(request);
                return;
            }

            clearAuthenticationAttributes(request);
            // Use the DefaultSavedRequest URL

            // final String targetUrl = savedRequest.getRedirectUrl();

            // logger.debug("Redirecting to DefaultSavedRequest Url: " + targetUrl);

            // getRedirectStrategy().sendRedirect(request, response, targetUrl);
        } else {
            request.getSession().setAttribute("picturepath", principals.getPicturepath());
            response.sendRedirect("/home");
        }
    }

    public void setRequestCache(RequestCache requestCache) {
        this.requestCache = requestCache;
    }


}
