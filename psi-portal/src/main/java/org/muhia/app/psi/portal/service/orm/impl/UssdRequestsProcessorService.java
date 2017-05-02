/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.service.orm.impl;

import org.muhia.app.psi.orm.model.*;
import org.muhia.app.psi.orm.repo.*;
import org.muhia.app.psi.portal.service.orm.IUssdRequestsProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

@Service
//@Transactional
public class UssdRequestsProcessorService implements IUssdRequestsProcessorService {

    private final UssdRequestsRepository repository;

    private final UssdResponsesRepository ussdResponsesRepository;

    private final UssdMenuImsiCodeVwsRepository menuImsiCodeVwRepository;

    private final ProductParametersRepository productParametersRepository;

    private final ProductsMasterRepository productsMasterRepository;

    private final ApplicationSrcRepository applicationSrcRepository;

    private final UssdCodesRepository ussdCodesRepository;

    private final UssdMenuImsiCodeVwsRepository ussdMenuImsiCodeVwsRepository;

    private final SubscriberWhitelistRepository subscriberWhitelistRespository;

    private final UssdSessionsRepository ussdSessionsRepository;

    @Autowired
    public UssdRequestsProcessorService(UssdRequestsRepository repository, UssdResponsesRepository ussdResponsesRepository, UssdMenuImsiCodeVwsRepository menuImsiCodeVwRepository, ProductParametersRepository productParametersRepository, ProductsMasterRepository productsMasterRepository, ApplicationSrcRepository applicationSrcRepository, UssdCodesRepository ussdCodesRepository, UssdMenuImsiCodeVwsRepository ussdMenuImsiCodeVwsRepository, SubscriberWhitelistRepository subscriberWhitelistRespository, UssdSessionsRepository ussdSessionsRepository) {
        this.repository = repository;
        this.ussdResponsesRepository = ussdResponsesRepository;
        this.menuImsiCodeVwRepository = menuImsiCodeVwRepository;
        this.productParametersRepository = productParametersRepository;
        this.productsMasterRepository = productsMasterRepository;
        this.applicationSrcRepository = applicationSrcRepository;
        this.ussdCodesRepository = ussdCodesRepository;
        this.ussdMenuImsiCodeVwsRepository = ussdMenuImsiCodeVwsRepository;
        this.subscriberWhitelistRespository = subscriberWhitelistRespository;
        this.ussdSessionsRepository = ussdSessionsRepository;
    }

    @Override
    public UssdRequests findUssdRequestByTransactionIdAndStatus(String transactionId, String status) {
        return repository.findUssdRequestsByTransactionidAndStatus(transactionId, status).orElse(new UssdRequests());
    }

    @Override
    public Collection<UssdMenuImsiCodeVw> findUssdMenuImsiCodeVwByCode(String code) {
        return menuImsiCodeVwRepository.findUssdMenuImsiCodeVwByUssdCode(code).orElse(null);
    }

    @Override
    public Collection<UssdMenuImsiCodeVw> findUssdMenuImsiCodeVwByCodeAndStatus(String code, int status) {

        return menuImsiCodeVwRepository.findUssdMenuImsiCodeVwByUssdCodeAndStatus(code, status).orElse(null);
    }

    @Override
    public UssdRequests saveUssdRequest(UssdRequests requests) {
        return repository.save(requests);
    }

    @Override
    public UssdResponses saveUssdResponse(UssdResponses ussdResponses) {
        return ussdResponsesRepository.save(ussdResponses);
    }

    @Override
    public Collection<UssdRequests> findUssdRequestsBySessionId(String sessionid) {
        return repository.findUssdRequestsBySessionid(sessionid).orElse(null);
    }

    @Override
    public Collection<UssdRequests> findUssdRequestsBySessionIdAndStatus(String sessionid, String status) {
        return repository.findUssdRequestsBySessionidAndStatus(sessionid, status).orElse(null);
    }

    @Override
    public UssdRequests findUssdRequestBySessionIdAndTransactionId(String sessionid, String transactionId) {
        try {
            return repository
                    .findOneUssdRequestsBySessionidAndTransactionid(sessionid, transactionId)
                    .orElse(null);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ProductParameters findProductParametersByProductId(Long id) {

        return productParametersRepository
                .findFirstProductParametersByProductId(productsMasterRepository.findOne(id))
                .orElse(null);
    }

    @Override
    public UssdMenuImsiCodeVw findUssdUssdMenuImsiCodeVwByMenuKeyAndByMenuParameter(String menuKey, String menuParameter) {
        return menuImsiCodeVwRepository.findUssdMenuImsiCodeVwByMenuKeyAndByMenuParameter(menuKey, menuParameter).orElse(null);
    }

    @Override
    public Optional<UssdMenuImsiCodeVw> findUssdUssdMenuImsiCodeVwByMenuKeyAndMenuCondition(String menuKey, String menuCondition) {
        return menuImsiCodeVwRepository.findUssdMenuImsiCodeVwByMenuKeyAndMenuCondition(menuKey, menuCondition);
    }

    @Override
    public ProductsMaster findProductMasterById(Long id) {
        return productsMasterRepository.findOne(id);
    }

    @Override
    public ApplicationSrc findApplicationSrcByApplication(String appName) {
        return applicationSrcRepository.findApplicationSrcByApplication(appName).orElse(null);
    }

    @Override
    public UssdMenuImsiCodeVw findUssdMenuImsiCodeVwByMenuKey(String menuKey) {
        return ussdMenuImsiCodeVwsRepository.findUssdMenuImsiCodeVwByMenuKey(menuKey).orElse(null);
    }

    @Override
    public Optional<Collection<UssdRequests>> findUssdRequestsBySessionIdAndStatusAndVarFld4Exists(String sessionid, String ussdSuccessStatus) {
        return repository.findUssdRequestsBySessionidAndStatusAndVarFld4Exists(sessionid, ussdSuccessStatus);
    }

    @Override
    public Optional<ProductParameters> findProductParametersBySmSKeyword(String smsKeyword) {
        return productParametersRepository.findProductParametersBySmsKeyword(smsKeyword);
    }

    @Override
    public Optional<UssdCodes> fetchUssdCodesByUssdCode(String ussdCode) {
        return ussdCodesRepository.findUssdCodesByUssdCode(ussdCode);
    }

    @Override
    public Optional<UssdCodes> findUssdCodesByUssdCodeAndStatus(String ussdCode, int status) {
        return ussdCodesRepository.findUssdCodesByUssdCodeAndStatus(ussdCode, status);
    }

    @Override
    @Transactional
    public SubscriberWhitelist saveSubscriberWhitelist(SubscriberWhitelist subscriberWhitelist) {
        return subscriberWhitelistRespository.save(subscriberWhitelist);
    }

    @Override
    @Transactional
    public SubscriberWhitelist changeSubscriberWhitelistStatus(SubscriberWhitelist subscriberWhitelist, int status) {
        subscriberWhitelist.setStatus(status);
        subscriberWhitelist.setModifiedby("AdminTask");
        subscriberWhitelist.setModifiedon(new Date());

        return subscriberWhitelistRespository.save(subscriberWhitelist);
    }

    @Override
    public Optional<SubscriberWhitelist> findSubscriberWhitelistBySubno(String subno) {
        return subscriberWhitelistRespository.findSubscriberWhitelistBySubno(subno);
    }

    @Override
    public Optional<SubscriberWhitelist> findSubscriberWhitelistBySubnoAndCode(String subno, UssdCodes code) {
        return subscriberWhitelistRespository.findSubscriberWhitelistBySubnoAndCode(subno, code);
    }

    @Override
    public Optional<UssdSessions> findUssdSessionsBySessionIdAndUserId(String sessionId, Principals userId) {
        return ussdSessionsRepository.findUssdSessionsBySessionIdAndUserId(sessionId, userId);
    }

    @Override
//    @Transactional
    public UssdSessions saveUssdSessions(UssdSessions ussdSessions) {
        return ussdSessionsRepository.save(ussdSessions);
    }


}
