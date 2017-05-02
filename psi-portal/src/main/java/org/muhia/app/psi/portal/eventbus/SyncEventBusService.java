/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.eventbus;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.SubscriberExceptionContext;
import com.google.common.eventbus.SubscriberExceptionHandler;

import javax.annotation.Nonnull;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 */
public class SyncEventBusService implements SubscriberExceptionHandler {

    //    public static final SyncEventBusService APPLICATION_EVENT_BUS = new SyncEventBusService();
//    @Bean
//    public static SyncEventBusService $() {
//        return APPLICATION_EVENT_BUS;
//    }
    private EventBus eventBus = null;

    public SyncEventBusService() {
//        eventBus = new AsyncEventBus("ui-events", Executors.newCachedThreadPool());
        eventBus = new EventBus("ui-events");
    }

    @Override
    public void handleException(@Nonnull Throwable exception, SubscriberExceptionContext context) {
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Handler " + context.getSubscriber() + " could not handle " + context.getEvent().getClass().getName() + "[" + context.getEvent() + "]: " + exception.getMessage(), exception);

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

}
