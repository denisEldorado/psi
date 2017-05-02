/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@Component
public class AsyncBean {
    @Async
    public void asyncMethod() {
        System.out.println("");
    }


}
