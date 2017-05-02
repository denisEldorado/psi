package org.muhia.app.psi.portal.service.orm;/**
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
 * Generated on 30-Oct-16 01:30
 */

import org.muhia.app.psi.orm.model.MobileMoneyProviders;
import org.muhia.app.psi.orm.model.MobileMoneyRequests;
import org.muhia.app.psi.orm.model.MobileMoneyResponses;
import org.muhia.app.psi.orm.model.TransactionRequests;

import java.util.Optional;

/**
 * Created by KennethKZMMuhia
 * Project: psi
 * Package: org.muhia.app.psi.portal.service.orm
 * Generated on: 22-Apr-17, 21:34
 */
public interface IMobileMoneyOperations {
    /**
     * MobileMoneyProviders
     */
    Optional<MobileMoneyProviders> findMobileMoneyProvidersByProvider(String provider);

    Optional<MobileMoneyProviders> findMobileMoneyProvidersById(Long id);

    MobileMoneyProviders saveMobileMoneyProviders(MobileMoneyProviders mobileMoneyProviders);

    void deleteMobileMoneyProviders(MobileMoneyProviders mobileMoneyProviders);

    /**
     * MobileMoney Requests
     */
    Optional<MobileMoneyRequests> findMobileMoneyRequestsByProvider(String provider);

    Optional<MobileMoneyRequests> findMobileMoneyRequestsById(Long id);

    MobileMoneyRequests saveMobileMoneyRequests(MobileMoneyRequests mobileMoneyRequests);

    void deleteMobileMoneyRequests(MobileMoneyRequests mobileMoneyRequests);

    /**
     * MobileMoney Responses
     */
    Optional<MobileMoneyResponses> findMobileMoneyResponsesByProvider(String provider);

    Optional<MobileMoneyResponses> findMobileMoneyResponsesById(Long id);

    MobileMoneyResponses saveMobileMoneyResponses(MobileMoneyResponses mobileMoneyResponses);

    void deleteMobileMoneyResponses(MobileMoneyResponses mobileMoneyResponses);

    /**
     * TransactionRequest processing
     */
    TransactionRequests prepareMobileMoneyRequestForMaishaLoanTransaction(TransactionRequests requests, String provider);


}
