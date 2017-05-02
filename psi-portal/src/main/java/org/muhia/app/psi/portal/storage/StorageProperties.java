/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 * @author ngatia
 */
@ConfigurationProperties("storage")
public class StorageProperties {
    
    private String location = "src/main/resources/static/uploads";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}