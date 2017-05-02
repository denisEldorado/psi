/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.service.orchestrate;


import org.muhia.app.psi.integ.wsdl.am.merchant.payments.TrxPayment;
import org.muhia.app.psi.integ.wsdl.am.merchant.payments.TrxPaymentResponse;

/**
 *
 * @author KennethKZMMuhia
 */
public interface IObopayMethods {
    Object sendAndReceiveCashInRequest(TrxPayment request);
    
    /**
     *
     * @param request
     * @return
     */
    Object sendAndReceiveObopayWebServiceData(TrxPaymentResponse request);
    
}
