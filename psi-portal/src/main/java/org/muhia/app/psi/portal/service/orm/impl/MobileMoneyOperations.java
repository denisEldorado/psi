package org.muhia.app.psi.portal.service.orm.impl;/**
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

import org.muhia.app.psi.config.integ.properties.ObopayBulkApiProperties;
import org.muhia.app.psi.config.order.properties.OrderProcessingProperties;
import org.muhia.app.psi.config.security.HashingImplementation;
import org.muhia.app.psi.orm.model.MobileMoneyProviders;
import org.muhia.app.psi.orm.model.MobileMoneyRequests;
import org.muhia.app.psi.orm.model.MobileMoneyResponses;
import org.muhia.app.psi.orm.model.TransactionRequests;
import org.muhia.app.psi.orm.repo.MobileMoneyProvidersRepository;
import org.muhia.app.psi.orm.repo.MobileMoneyRequestsRepository;
import org.muhia.app.psi.orm.repo.MobileMoneyResponsesRepository;
import org.muhia.app.psi.portal.service.orm.IBankingOperationsService;
import org.muhia.app.psi.portal.service.orm.IMobileMoneyOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by KennethKZMMuhia
 * Project: psi
 * Package: org.muhia.app.psi.portal.service.orm.impl
 * Generated on: 23-Apr-17, 08:08
 */
@Service
public class MobileMoneyOperations implements IMobileMoneyOperations {
    private final MobileMoneyProvidersRepository mobileMoneyProvidersRepository;
    private final MobileMoneyRequestsRepository mobileMoneyRequestsRepository;
    private final MobileMoneyResponsesRepository mobileMoneyResponsesRepository;

    private final ObopayBulkApiProperties obopayBulkApiProperties;
    private final HashingImplementation hasher;
    private final OrderProcessingProperties orderProcessingProperties;
    private final IBankingOperationsService bankingOperationsService;

    @Autowired
    public MobileMoneyOperations(MobileMoneyProvidersRepository mobileMoneyProvidersRepository, MobileMoneyRequestsRepository mobileMoneyRequestsRepository, MobileMoneyResponsesRepository mobileMoneyResponsesRepository, ObopayBulkApiProperties obopayBulkApiProperties, HashingImplementation hasher, OrderProcessingProperties orderProcessingProperties, IBankingOperationsService bankingOperationsService) {
        this.mobileMoneyProvidersRepository = mobileMoneyProvidersRepository;
        this.mobileMoneyRequestsRepository = mobileMoneyRequestsRepository;
        this.mobileMoneyResponsesRepository = mobileMoneyResponsesRepository;

        this.obopayBulkApiProperties = obopayBulkApiProperties;
        this.hasher = hasher;
        this.orderProcessingProperties = orderProcessingProperties;
        this.bankingOperationsService = bankingOperationsService;
    }

    @Override
    public Optional<MobileMoneyProviders> findMobileMoneyProvidersByProvider(String provider) {
        return mobileMoneyProvidersRepository.findMobileMoneyProvidersByProvider(provider);
    }

    @Override
    public Optional<MobileMoneyProviders> findMobileMoneyProvidersById(Long id) {
        return mobileMoneyProvidersRepository.findMobileMoneyProvidersById(id);
    }

    @Override
    public MobileMoneyProviders saveMobileMoneyProviders(MobileMoneyProviders mobileMoneyProviders) {
        return mobileMoneyProvidersRepository.save(mobileMoneyProviders);
    }

    @Override
    public void deleteMobileMoneyProviders(MobileMoneyProviders mobileMoneyProviders) {
        mobileMoneyProvidersRepository.delete(mobileMoneyProviders);
    }

    @Override
    public Optional<MobileMoneyRequests> findMobileMoneyRequestsByProvider(String provider) {
        return mobileMoneyRequestsRepository.findMobileMoneyRequestsByProvider(provider);
    }

    @Override
    public Optional<MobileMoneyRequests> findMobileMoneyRequestsById(Long id) {
        return mobileMoneyRequestsRepository.findMobileMoneyRequestsById(id);
    }

    @Override
    public MobileMoneyRequests saveMobileMoneyRequests(MobileMoneyRequests mobileMoneyRequests) {
        return mobileMoneyRequestsRepository.save(mobileMoneyRequests);
    }

    @Override
    public void deleteMobileMoneyRequests(MobileMoneyRequests mobileMoneyRequests) {
        mobileMoneyRequestsRepository.delete(mobileMoneyRequests);
    }

    @Override
    public Optional<MobileMoneyResponses> findMobileMoneyResponsesByProvider(String provider) {
        return mobileMoneyResponsesRepository.findMobileMoneyResponsesByProvider(provider);
    }

    @Override
    public Optional<MobileMoneyResponses> findMobileMoneyResponsesById(Long id) {
        return mobileMoneyResponsesRepository.findMobileMoneyResponsesById(id);
    }

    @Override
    public MobileMoneyResponses saveMobileMoneyResponses(MobileMoneyResponses mobileMoneyResponses) {
        return mobileMoneyResponsesRepository.save(mobileMoneyResponses);
    }

    @Override
    public void deleteMobileMoneyResponses(MobileMoneyResponses mobileMoneyResponses) {
        mobileMoneyResponsesRepository.delete(mobileMoneyResponses);
    }

    @Override
    @Transactional
    public TransactionRequests prepareMobileMoneyRequestForMaishaLoanTransaction(TransactionRequests requests, String provider) {
        /**
         * Prepare MobileMoney Request for TransactionRequest
         */
        findMobileMoneyProvidersByProvider(provider).ifPresent(mobileMoneyProviders -> {
            try {
                /**
                 * TODO: Move this section to the calling function
                 */
                requests.setPrepareStartDate(new Date());
                requests.setTransactionStatus(orderProcessingProperties.getRequestStatusPreparedWorking());
                bankingOperationsService.saveTransactionRequests(requests);

                SimpleDateFormat dateFormat = new SimpleDateFormat(obopayBulkApiProperties.getSdfUniqueTimestamp());
                String batchRef = String.format("%s-%s", dateFormat.format(new Date()), UUID.randomUUID().toString());
                Double bulkPaymentAmount = requests.getTranamount() - requests.getTransactionCharges();
                MobileMoneyRequests mobileMoneyRequests = new MobileMoneyRequests();
                mobileMoneyRequests.setProvider(mobileMoneyProviders.getProvider());
                mobileMoneyRequests.setFromSubno(obopayBulkApiProperties.getEndpointBulkpaymentMerchantMsisdn());
                mobileMoneyRequests.setToSubno(requests.getToaccount());
                mobileMoneyRequests.setTransactionType(requests.getTrancategory());
                mobileMoneyRequests.setAmmount(requests.getTranamount());
                mobileMoneyRequests.setVarParameter1(obopayBulkApiProperties.getRequestKeywordReferenceId());
                mobileMoneyRequests.setVarValue1(batchRef);
                mobileMoneyRequests.setVarParameter2(obopayBulkApiProperties.getRequestKeywordCustomerMsisdn());
                mobileMoneyRequests.setVarValue2(requests.getToaccount());
                mobileMoneyRequests.setVarParameter3(obopayBulkApiProperties.getRequestKeywordNickname());
                mobileMoneyRequests.setVarValue3(hasher.getEncryptedValue(obopayBulkApiProperties.getEndpointBulkpaymentProductionNickname()));
                mobileMoneyRequests.setVarParameter4(obopayBulkApiProperties.getRequestKeywordAmount());
                mobileMoneyRequests.setVarValue4(bulkPaymentAmount.toString());
                mobileMoneyRequests.setVarParameter5(obopayBulkApiProperties.getRequestKeywordBatchRef());
                mobileMoneyRequests.setVarValue5(batchRef);
                mobileMoneyRequests.setVarParameter6(obopayBulkApiProperties.getRequestKeywordUsername());
                mobileMoneyRequests.setVarValue6(hasher.getEncryptedValue(obopayBulkApiProperties.getEndpointBulkpaymentProductionUsername()));
                mobileMoneyRequests.setVarParameter7(obopayBulkApiProperties.getRequestKeywordPassword());
                mobileMoneyRequests.setVarValue7(hasher.getEncryptedValue(obopayBulkApiProperties.getEndpointBulkpaymentProductionPassword()));
                mobileMoneyRequests.setVarParameter8(obopayBulkApiProperties.getRequestKeywordNarrative());
                mobileMoneyRequests.setVarValue8(requests.getNarration());
                mobileMoneyRequests = saveMobileMoneyRequests(mobileMoneyRequests);


                requests.setPrepareEndDate(new Date());
                try {
                    Integer retried = requests.getVarField1() == null ? 1 : Integer.parseInt(requests.getVarField1()) + 1;
                    requests.setVarField1(retried.toString());
                } catch (NumberFormatException e) {
                    Integer retried = 1;
                    requests.setVarField1(retried.toString());
                }
                requests.setVarField2(String.format("[%s= %d]", mobileMoneyRequests.getClass().getName(), mobileMoneyRequests.getId()));
                requests.setTransactionStatus(orderProcessingProperties.getRequestStatusPreparedSuccess());
                bankingOperationsService.saveTransactionRequests(requests);
            } catch (Exception e) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, String.format("[%s= %s]", e.getClass().getName(), e.getMessage()), e);
                requests.setPrepareEndDate(new Date());
                requests.setVarField2(String.format("[%s= %s]", e.getClass().getName(), e.getMessage()));
                requests.setTransactionStatus(orderProcessingProperties.getRequestStatusPreparedFail());
                bankingOperationsService.saveTransactionRequests(requests);

            }

        });


        return bankingOperationsService.saveTransactionRequests(requests);
    }
}
