/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.security;

import org.muhia.app.psi.portal.components.WebUI;
import org.muhia.app.psi.portal.service.orm.IPrincipalsService;
import org.muhia.app.psi.config.security.properties.UserAccountStatus;
import org.muhia.app.psi.orm.model.Principals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.Optional;


/**
 *
 * @author ngatia
 */
@Configuration
public class AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler{
    private final WebUI webUI;
    @Autowired
    private IPrincipalsService service;
    @Autowired
    private UserAccountStatus userAccountStatus;

    @Autowired
    public AuthenticationFailureHandler(NoRedirectStrategy noRedirectStrategy, WebUI webUI) {
        super();
        setRedirectStrategy(noRedirectStrategy);
        this.webUI = webUI;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        
        PrintWriter pr=response.getWriter();
        //check if request is not from mobile then redirect
        if(Objects.equals(request.getHeader("Device"),"Android")) {
            pr.write("false-null-null-null");
        }else{
            request.setAttribute("param", "error");
            response.sendRedirect("/index?error");
            /*
                TODO: Replace with correct parameter name and externalise
                TODO: Check the status of the user and add an error message e.g
                TODO: Implementation may require to be done for errormessages etc
             */
            final String[] errorMessage = {webUI.getMessage("user.generic.authentication.error")};
            Optional<Principals> principals = Optional.ofNullable(service.findByLoginName(request.getParameter("username")));
            principals.ifPresent(user -> {
                String notYetApprovedMessage = webUI.getMessage("user.not.verified.message", user.getLoginName(), user.getEmailaddress());

                if (exception.getMessage().equalsIgnoreCase(("User is disabled"))) {
                    if (user.getStatus() == userAccountStatus.getDisabled()) errorMessage[0] = notYetApprovedMessage;
                }

            });

        }
    }

}
