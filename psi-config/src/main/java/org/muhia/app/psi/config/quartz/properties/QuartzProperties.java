package org.muhia.app.psi.config.quartz.properties;
/*
  Copyright 2015-2016 the original author or authors.
  <p>
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
  <p>
  http://www.apache.org/licenses/LICENSE-2.0
  <p>
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
  <p>
  <p>
  Generated on 30-Oct-16 14:36
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Kenneth Muhia <muhia@muhia.org> on 30-Oct-16.
 *         for package org.muhia.app.psi.config
 */
@Configuration
@PropertySource(value = {"file:${CONFIG_PATH}/quartz.properties"}, ignoreResourceNotFound = true)
public class QuartzProperties {
    @Value("${org.muhia.psi.scheduler.delay.smsExecutorFixedDelay}")
    private String smsExecutorFixedDelay;
    @Value("${org.muhia.psi.scheduler.delay.smsExecutorInitialDelay}")
    private String smsExecutorInitialDelay;
    @Value("${org.muhia.psi.scheduler.delay.autoRenewalInterval}")
    private String autoRenewalInterval;
    @Value("${org.muhia.psi.scheduler.cron.order.cleanup.job}") private  String cronOrderCleanupJob;



    public String getSmsExecutorFixedDelay() {
        return smsExecutorFixedDelay;
    }

    public void setSmsExecutorFixedDelay(String smsExecutorFixedDelay) {
        this.smsExecutorFixedDelay = smsExecutorFixedDelay;
    }

    public String getSmsExecutorInitialDelay() {
        return smsExecutorInitialDelay;
    }

    public void setSmsExecutorInitialDelay(String smsExecutorInitialDelay) {
        this.smsExecutorInitialDelay = smsExecutorInitialDelay;
    }

    public String getAutoRenewalInterval() {
        return autoRenewalInterval;
    }

    public void setAutoRenewalInterval(String autoRenewalInterval) {
        this.autoRenewalInterval = autoRenewalInterval;
    }
}
