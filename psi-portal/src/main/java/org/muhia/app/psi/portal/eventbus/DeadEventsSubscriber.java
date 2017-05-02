/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.eventbus;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@Service
public class DeadEventsSubscriber {

    @Subscribe
    public void handleDeadEvent(DeadEvent deadEvent) {
        Logger.getLogger(DeadEventsSubscriber.class.getName()).log(Level.SEVERE, "Dead Event found: {0}", deadEvent.getEvent().toString());
    }

}
