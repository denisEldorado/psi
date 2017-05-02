package org.muhia.app.psi.portal.service.sms;
/**
 * Copyright 2015-2016 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p>
 * <p>
 * Generated on 30-Oct-16 00:31
 */

import org.muhia.app.psi.orm.model.ServiceRequests;
import org.muhia.app.psi.orm.model.SmsRegistry;
import org.muhia.app.psi.orm.model.SmsResponses;
import org.muhia.app.psi.orm.model.UssdCodes;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Kenneth Muhia <muhia@muhia.org> on 30-Oct-16. 
 * for package org.muhia.app.psi.portal.service.sms.impl
 * 
 * The SMS message details being fetched from the smsRegistry
 * Outlines the content to be displayed during SmsForSending, AfterSendingAttempt
 * and DeliveryStatus
 * 
 * This works through an overloading method
 */
public interface ISmsBrokerService {
    String sendSmsMessage(SmsRegistry smsRegistry);

    SmsRegistry registerSmsForSending(String msg, String subno, String code, String direction, Date smsTime, int smsStatus, ServiceRequests orderMaster);

    SmsRegistry logOutgoingSmsAfterSendAttempt(String msg, Date smsTime, int smsStatus, String gwstatus, SmsRegistry smsRegistry);

    List<SmsRegistry> logOutgoingSmsAfterSendAttempt(List<SmsRegistry> smsRegistries);

    SmsRegistry logOutgoingSmsAfterSendAttempt(SmsRegistry smsRegistries);

    List<SmsRegistry> findSmsRegistryByDirectionAndDeliveryStatusAndRetried(String direction, long deliveryStatus);


    SmsRegistry registerSmsForSending(String msg, String subno, String code, String direction, Date smsTime, int smsStatus);

    Optional<UssdCodes> fetchUssdCodesByUssdCode(String ussdCode);

    Optional<SmsResponses> fetchSmsResponsesBySmsCode(UssdCodes smsCode);

    SmsRegistry registerIncomingSms(SmsRegistry smsRegistry);
    
    String sendBulkSmsFromCsv(MultipartFile file,Boolean single,String message);

    String sendBulkSmsFromCsvAfrica(MultipartFile file, Boolean single, String message);

    String sendSmsUsingAficasTalking(SmsRegistry smsRegistry);
}
