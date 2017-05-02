/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.service.orm;

import org.muhia.app.psi.orm.model.*;

import java.util.Collection;
import java.util.Optional;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 */
public interface IUssdRequestsProcessorService {

    UssdRequests findUssdRequestByTransactionIdAndStatus(String transactionId, String status);

    Collection<UssdMenuImsiCodeVw> findUssdMenuImsiCodeVwByCode(String code);
    Collection<UssdMenuImsiCodeVw> findUssdMenuImsiCodeVwByCodeAndStatus(String code,int status);

    UssdRequests saveUssdRequest(UssdRequests requests);

    UssdResponses saveUssdResponse(UssdResponses ussdResponses);

    Collection<UssdRequests> findUssdRequestsBySessionId(String sessionid);

    Collection<UssdRequests> findUssdRequestsBySessionIdAndStatus(String sessionid, String status);

    UssdRequests findUssdRequestBySessionIdAndTransactionId(String sessionid, String transactionId);

    ProductParameters findProductParametersByProductId(Long id);

    UssdMenuImsiCodeVw findUssdUssdMenuImsiCodeVwByMenuKeyAndByMenuParameter(String menuKey, String textVar1);

    Optional<UssdMenuImsiCodeVw> findUssdUssdMenuImsiCodeVwByMenuKeyAndMenuCondition(String menuKey, String menuCondition);

    ProductsMaster findProductMasterById(Long id);

    ApplicationSrc findApplicationSrcByApplication(String appName);

    UssdMenuImsiCodeVw findUssdMenuImsiCodeVwByMenuKey(String menuKey);


    Optional<Collection<UssdRequests>> findUssdRequestsBySessionIdAndStatusAndVarFld4Exists(String sessionId, String ussdSuccessStatus);

    Optional<ProductParameters> findProductParametersBySmSKeyword(String smsKeyword);


    Optional<UssdCodes> findUssdCodesByUssdCodeAndStatus(String ussdCode, int status);

    Optional<UssdCodes> fetchUssdCodesByUssdCode(String ussdCode);

    SubscriberWhitelist saveSubscriberWhitelist(SubscriberWhitelist subscriberWhitelist);

    SubscriberWhitelist changeSubscriberWhitelistStatus(SubscriberWhitelist subscriberWhitelist, int status);

    Optional<SubscriberWhitelist> findSubscriberWhitelistBySubno(String subno);

    Optional<SubscriberWhitelist> findSubscriberWhitelistBySubnoAndCode(String subno, UssdCodes code);

    Optional<UssdSessions> findUssdSessionsBySessionIdAndUserId(String sessionId, Principals userId);

    UssdSessions saveUssdSessions(UssdSessions ussdSessions);

//    SaccoRegistration saveSaccoRegistration(SaccoRegistration saccoRegistration);

//    Collection<SaccoRegistration> findSaccoRegistrationByUserId(Principals userId);
}
