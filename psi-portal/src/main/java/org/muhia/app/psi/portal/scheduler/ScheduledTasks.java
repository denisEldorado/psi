package org.muhia.app.psi.portal.scheduler;

import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.core.SchedulerLock;
import net.javacrumbs.shedlock.provider.jdbc.JdbcLockProvider;
import net.javacrumbs.shedlock.spring.SpringLockableTaskSchedulerFactory;
import org.muhia.app.psi.portal.service.batch.OrderProcessingCleanupService;
import org.muhia.app.psi.portal.service.batch.ServiceRequestsProcessorService;
import org.muhia.app.psi.portal.service.moma.ProcessMomaDataService;
import org.muhia.app.psi.portal.service.orm.impl.WorkOrderProcessingService;
import org.muhia.app.psi.portal.service.sms.SendPendingSmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

import javax.sql.DataSource;
import java.util.logging.Level;
import java.util.logging.Logger;

/*

@author Kenneth Muhia <muhia@muhia.org> on 30-Oct-16.
for package org.muhia.app.psi.portal.security

*/
@Configuration
@PropertySource(value = {"file:${CONFIG_PATH}/quartz.properties"}, ignoreResourceNotFound = true)
public class ScheduledTasks {

    private static final long LOCK_AT_MOST_FOR = 15000;
    private static final long LOCK_AT_LEAST_FOR = 15000;
    private final SendPendingSmsService sendPendingSmsService;
    private final OrderProcessingCleanupService orderCleanupService;
    private final ServiceRequestsProcessorService serviceRequestsProcessorService;
    private final WorkOrderProcessingService processRecurringPayments;
    private final ProcessMomaDataService processMomaDataService;
    private final DataSource dataSource;
    @Value("${org.muhia.psi.scheduler.cron.schedule.locker.pool.size}")
    private int scheduleLockerPoolSize;


//    private final MomaLogService momaService;

    @Autowired
    public ScheduledTasks(SendPendingSmsService sendPendingSmsService, OrderProcessingCleanupService orderCleanupService, ServiceRequestsProcessorService serviceRequestsProcessorService, WorkOrderProcessingService processRecurringPayments, ProcessMomaDataService processMomaDataService, DataSource dataSource) {
        this.sendPendingSmsService = sendPendingSmsService;
        this.orderCleanupService = orderCleanupService;
        this.serviceRequestsProcessorService = serviceRequestsProcessorService;
        this.processRecurringPayments = processRecurringPayments;
//        this.momaService = momaService;
        this.processMomaDataService = processMomaDataService;
        this.dataSource = dataSource;
    }

    @Bean
    public LockProvider lockProvider() {
        return new JdbcLockProvider(dataSource);
    }

    @Bean
    public TaskScheduler taskScheduler() {

        return SpringLockableTaskSchedulerFactory.newLockableTaskScheduler(scheduleLockerPoolSize, lockProvider());
    }


    @Scheduled(cron = "${org.muhia.psi.scheduler.cron.sr.send.pending.sms.job}")
    @SchedulerLock(name = "sendPendingSms", lockAtLeastFor = LOCK_AT_LEAST_FOR, lockAtMostFor = LOCK_AT_MOST_FOR)
    @Async
    public void sendPendingSms() {

        try {
            /*
                DONE: Enable SMS sending
             */
            sendPendingSmsService.run();
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @Scheduled(cron = "${org.muhia.psi.scheduler.cron.order.cleanup.job}")
    @SchedulerLock(name = "processPendingWorkOrders", lockAtLeastFor = LOCK_AT_LEAST_FOR, lockAtMostFor = LOCK_AT_MOST_FOR)
    @Async
    public void processPendingWorkOrders() {
        try {
            orderCleanupService.run();
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }

    }

    @Scheduled(cron = "${org.muhia.psi.scheduler.cron.sr.cleanup.job}")
    @SchedulerLock(name = "processPendingServiceRequests", lockAtLeastFor = LOCK_AT_LEAST_FOR, lockAtMostFor = LOCK_AT_MOST_FOR)
//    @Scheduled(fixedDelayString = "${org.muhia.psi.scheduler.delay.interval.srcleanup}", initialDelayString = "${org.muhia.psi.scheduler.delay.initial.srcleanup}")
    @Async
    public void processPendingServiceRequests() {
        try {
            serviceRequestsProcessorService.run();
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }

    }

    //scheduled tasks to pay back a loan
    //create a trigger that fires every 5 minutes, at 10 seconds after the minute (i.e. 10:00:10 am, 10:05:10 am, etc.).
    @Scheduled(cron = "${org.muhia.psi.scheduler.cron.recurring.payments}")
    @SchedulerLock(name = "recurringPayments", lockAtLeastFor = LOCK_AT_LEAST_FOR, lockAtMostFor = LOCK_AT_MOST_FOR)
    @Async
    public void recurringPayments() {
        try {
            processRecurringPayments.run();
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }

    }

    /*
        everyday at 0100h
        public class CronSequenceGenerator
        extends Object
        Date sequence generator for a Crontab pattern, allowing clients to specify a pattern that the sequence matches.
        The pattern is a list of six single space-separated fields: representing second, minute, hour, day, month, weekday. Month and weekday names can be given as the first three letters of the English names.
        Example patterns:
        "0 0 * * * *" = the top of every hour of every day.
        "10 * * * * *" = every ten seconds.
        "0 0 8-10 * * *" = 8, 9 and 10 o'clock of every day.
        "0 0 6,19 * * *" = 6:00 AM and 7:00 PM every day.
        "0 0/30 8-10 * * *" = 8:00, 8:30, 9:00, 9:30, 10:00 and 10:30 every day.
        "0 0 9-17 * * MON-FRI" = on the hour nine-to-five weekdays
        "0 0 0 25 12 ?" = every Christmas Day at midnight
        TODO: Externalize Cron configs
     */
    @Scheduled(cron = "${org.muhia.psi.scheduler.cron.fetch.moma.daily.dump}")
    @SchedulerLock(name = "fetchMomaData", lockAtLeastFor = LOCK_AT_LEAST_FOR, lockAtMostFor = LOCK_AT_MOST_FOR)
    @Async
    public void fetchMomaData() {

        try {
            processMomaDataService.run();
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }


}
