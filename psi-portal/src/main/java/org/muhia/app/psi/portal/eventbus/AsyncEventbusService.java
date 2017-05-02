/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.eventbus;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.SubscriberExceptionContext;
import com.google.common.eventbus.SubscriberExceptionHandler;

import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author KennethKZMMuhia
 */
public class AsyncEventbusService implements SubscriberExceptionHandler {
    private EventBus eventBus = null;

    public AsyncEventbusService() {
        eventBus = new AsyncEventBus("orchestrate-events", Executors.newCachedThreadPool());
    }

    public void post(final Object event) {
        eventBus.post(event);

    }

    public void register(final Object subscriber) {
        eventBus.register(subscriber);

    }

    public void unregister(final Object subscriber) {
        eventBus.unregister(subscriber);

    }

    @Override
    public void handleException(Throwable exception, SubscriberExceptionContext context) {
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Handler " + context.getSubscriber() + " could not handle " + context.getEvent().getClass().getName() + "[" + context.getEvent() + "]: " + exception.getMessage(), exception);
    }

}
