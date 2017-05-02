package org.muhia.app.psi.portal.service.sms;
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
  Generated on 30-Oct-16 02:09
 */

import org.muhia.app.psi.config.integ.ke.africastalkingproperties.AfricasTalkingProperties;
import org.muhia.app.psi.config.sms.properties.SmsKannelConnectorProperties;
import org.muhia.app.psi.orm.model.SmsRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Kenneth Muhia <muhia@muhia.org> on 30-Oct-16.
 *         for package org.muhia.app.psi.portal.service.sms
 */
@Service
public class SendPendingSmsService implements Runnable {
    private final ISmsBrokerService brokerService;
    private final AfricasTalkingProperties talkingProperties;
    private final SmsKannelConnectorProperties sp;

    @Autowired
    public SendPendingSmsService(ISmsBrokerService brokerService, AfricasTalkingProperties talkingProperties, SmsKannelConnectorProperties sp) {
        this.brokerService = brokerService;
        this.talkingProperties = talkingProperties;
        this.sp = sp;
    }

    @Override
    public void run() {
        List<SmsRegistry> smsRegistryList = brokerService.findSmsRegistryByDirectionAndDeliveryStatusAndRetried(sp.getSmsOutKeyword(), sp.getSmsOutInitStatus());

        try {
            if (!smsRegistryList.isEmpty()) {
                smsRegistryList.forEach(sms -> {
                    try {
                        sms.setDeliveryStatus((long) sp.getSmsOutProcessingStatus());

                        sms = brokerService.logOutgoingSmsAfterSendAttempt(sms);

                        //    String kannelStatus = brokerService.sendSmsMessage(sms);
                        String kannelStatus = brokerService.sendSmsUsingAficasTalking(sms);
                        sms.setKannelResponse(kannelStatus);
                        /**
                         * TODO: Split and have methods for Each SMS provider
                         */
                        sms.setDeliveryStatus(kannelStatus.contains(talkingProperties.getSmsSendSuccessKeyword()) ? new Long(sp.getSmsOutFinalStatus()) : new Long(sp.getSmsOutFailStatus()));
                        sms.setRetried(sms.getRetried() + 1);
                        sms.setSentDate(new Date());

                        sms.setResponseMessage(sms.getMessageText());
                        sms = brokerService.logOutgoingSmsAfterSendAttempt(sms);
                    } catch (Exception e) {
                        sms.setKannelResponse(e.getMessage());
                        if (sms.getRetried() < sms.getRetryAttempts()) {
                            sms.setDeliveryStatus((long) sp.getSmsOutInitStatus());
                            sms.setRetried(sms.getRetried() + 1);
                        } else {
                            sms.setDeliveryStatus((long) sp.getSmsOutFailStatus());
                            sms.setRetried(sms.getRetryAttempts());
                        }


                        sms.setSentDate(new Date());

                        sms.setResponseMessage("");
                        try {

                            sms = brokerService.logOutgoingSmsAfterSendAttempt(sms);
                        } catch (Exception ee) {
                            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, ee.getMessage(), ee);
                        }


                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage() + "Failed sending sms: " + sms.toString());
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                    }
                });

//                brokerService.logOutgoingSmsAfterSendAttempt(smsRegistryList);


            }
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }

    }
}
