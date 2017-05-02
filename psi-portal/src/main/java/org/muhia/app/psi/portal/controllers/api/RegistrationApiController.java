/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.controllers.api;

import org.muhia.app.psi.portal.PortalApplication;
import org.muhia.app.psi.portal.controllers.RegistrationController;
import org.muhia.app.psi.portal.eventbus.DashboardEvent;
import org.muhia.app.psi.portal.service.orm.IPrincipalsService;
import org.muhia.app.psi.orm.model.Principals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ngatia
 */
@RestController
public class RegistrationApiController {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private IPrincipalsService principalsService;
    
    @RequestMapping(value = "/api/portal/user/register")
    public String registerUser(@RequestParam String fullname,
            @RequestParam String phone) {
        try {
            Map<String, String> productParamsMap = new HashMap<>();
            productParamsMap.put("productid", "1");
            productParamsMap.put("cellphonenumber",phone);
            productParamsMap.put("fullname",fullname);
            DashboardEvent.ApiRegistrationEvent apiRegistrationEvent=new DashboardEvent.ApiRegistrationEvent(productParamsMap);
            PortalApplication.dashBoardEventBusService().post(apiRegistrationEvent);
            return "true";
        } catch (Exception ex) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
            return "false";
        }
    }
    
    @RequestMapping(value = "/api/portal/user/register/confirm")
    public String confirmPin(@RequestParam String pin,
            @RequestParam String phone) {
        
        try {
            String[] result = new String[1];
            Optional<Principals> principalOptional=principalsService.findUserByPhone(phone);
            result[0] = "false";
            principalOptional.ifPresent(principals -> {
                if (passwordEncoder.matches(pin, principals.getCredentials())) {
                    result[0] = "true";
                } else {
                    result[0] = "false";
                }
            });
            return result[0];

        } catch (Exception ex) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
            return "false";
        }
    }
    
    @RequestMapping(value = "/api/portal/user/register/complete")
    public String completeRegister(@RequestParam String email,
            @RequestParam String phone, @RequestParam String password,
            @RequestParam String username,@RequestParam String pin) {
        String[] result = new String[1];
        try {
            Optional<Principals> principalOptional=principalsService.findUserByPhone(phone);
            /*
                TODO: Watch how I have changed this code below
             */
//            Principals principals=principalOptional.get();

            result[0] = "false";
            principalOptional.ifPresent(principals -> {
                if (passwordEncoder.matches(pin, principals.getCredentials())) {
                    DashboardEvent.ApiCompleteRegistrationEvent apiCompleteRegistrationEvent = new DashboardEvent.ApiCompleteRegistrationEvent(password, username, email, principals);
                    PortalApplication.dashBoardEventBusService().post(apiCompleteRegistrationEvent);
                    result[0] = "true";
                } else {
                    result[0] = "false";
                }

            });


        } catch (Exception ex) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
            result[0] = "false";
        }
        return result[0];
    }
    
}
