/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.service.orchestrate;

import org.muhia.app.psi.orm.model.ServiceRequests;

import java.util.Map;

/**
 * @author KennethKZMMuhia
 */
public interface IServiceProvisioningActions {

    Map<?, ?> saccoMemberRegistration(Map<String, String> serviceOrderInfo, ServiceRequests sr);
    boolean existsOnMobileMoney(String cellphonenumber);

    Map<?, ?> memberPasswordChange(Map<String, String> serviceOrderInfo, ServiceRequests sr);

    Map<?, ?> guarantorRequest(Map<String, String> serviceOrderInfo, ServiceRequests sr);
    Map<?,?> loanRequest(Map<String, String> serviceOrderInfo, ServiceRequests sr);
    Map<?,?> guaranteeApprove(Map<String, String> serviceOrderInfo, ServiceRequests sr);
    Map<?,?> guaranteeDecline(Map<String, String> serviceOrderInfo, ServiceRequests sr);
    Map<?,?> setSavingsTarget(Map<String, String> serviceOrderInfo, ServiceRequests sr);
    Map<?,?> rafikiLoanRequest(Map<String, String> serviceOrderInfo, ServiceRequests sr);
    Map<?,?> rafikiLoanDecline(Map<String, String> serviceOrderInfo, ServiceRequests sr);
    Map<?,?> rafikiLoanApprove(Map<String, String> serviceOrderInfo, ServiceRequests sr);

    Map<?, ?> maishaBankLoanRequest(Map<String, String> serviceOrderInfo, ServiceRequests sr);

    Map<?, ?> generateAdminTaskToken(Map<String, String> serviceOrderInfo, ServiceRequests sr);

    Map<?, ?> whitelistSubscriberForShortcode(Map<String, String> serviceOrderInfo, ServiceRequests sr);
    Map<?,?> deactivateSavingsTarget(Map<String, String> serviceOrderInfo, ServiceRequests sr);
    Map<?,?> depositSavings(Map<String, String> serviceOrderInfo, ServiceRequests sr);
    Map<?,?> queryLoanLimit(Map<String, String> serviceOrderInfo, ServiceRequests sr);
    Map<?,?> withdrawSavings(Map<String, String> serviceOrderInfo, ServiceRequests sr);
    Map<?,?> checkBalance(Map<String, String> serviceOrderInfo, ServiceRequests sr);
    Map<?,?> generateStatement(Map<String, String> serviceOrderInfo, ServiceRequests sr);
    Map<?,?> payLoan(Map<String, String> serviceOrderInfo, ServiceRequests sr);

    Map<?, ?> maishaBankMemberRegistration(Map<String, String> serviceOrderInfo, ServiceRequests sr);

}
