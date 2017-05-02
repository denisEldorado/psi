
package org.muhia.app.psi.integ.wsdl.am.bulkpayment;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import java.math.BigDecimal;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 */
@WebService(name = "BulkPaymentWebServiceNew", targetNamespace = "http://www.obopay.com/xml/bulkpayment/v1")
@XmlSeeAlso({
        ObjectFactory.class
})
public interface BulkPaymentWebServiceNew {


    /**
     * @param password
     * @param nickname
     * @param username
     * @return returns org.muhia.app.psi.integ.wsdl.am.bulkpayment.CheckBalanceResponse2
     */
    @WebMethod(operationName = "CheckBalance", action = "CheckBalance")
    @WebResult(name = "CheckBalanceResult", targetNamespace = "http://www.obopay.com/xml/bulkpayment/v1")
    @RequestWrapper(localName = "CheckBalance", targetNamespace = "http://www.obopay.com/xml/bulkpayment/v1", className = "org.muhia.app.psi.integ.wsdl.am.bulkpayment.CheckBalance")
    @ResponseWrapper(localName = "CheckBalanceResponse", targetNamespace = "http://www.obopay.com/xml/bulkpayment/v1", className = "org.muhia.app.psi.integ.wsdl.am.bulkpayment.CheckBalanceResponse")
    CheckBalanceResponse2 checkBalance(
            @WebParam(name = "username", targetNamespace = "http://www.obopay.com/xml/bulkpayment/v1")
                    String username,
            @WebParam(name = "password", targetNamespace = "http://www.obopay.com/xml/bulkpayment/v1")
                    String password,
            @WebParam(name = "nickname", targetNamespace = "http://www.obopay.com/xml/bulkpayment/v1")
                    String nickname);

    /**
     * @param amount
     * @param password
     * @param narrative
     * @param nickname
     * @param customermsisdn
     * @param batchref
     * @param referenceid
     * @param username
     * @return returns java.lang.String
     */
    @WebMethod(operationName = "TrxPayment", action = "TrxPayment")
    @WebResult(name = "TrxPaymentResult", targetNamespace = "http://www.obopay.com/xml/bulkpayment/v1")
    @RequestWrapper(localName = "TrxPayment", targetNamespace = "http://www.obopay.com/xml/bulkpayment/v1", className = "org.muhia.app.psi.integ.wsdl.am.bulkpayment.TrxPayment")
    @ResponseWrapper(localName = "TrxPaymentResponse", targetNamespace = "http://www.obopay.com/xml/bulkpayment/v1", className = "org.muhia.app.psi.integ.wsdl.am.bulkpayment.TrxPaymentResponse")
    String trxPayment(
            @WebParam(name = "referenceid", targetNamespace = "http://www.obopay.com/xml/bulkpayment/v1")
                    String referenceid,
            @WebParam(name = "customermsisdn", targetNamespace = "http://www.obopay.com/xml/bulkpayment/v1")
                    String customermsisdn,
            @WebParam(name = "nickname", targetNamespace = "http://www.obopay.com/xml/bulkpayment/v1")
                    String nickname,
            @WebParam(name = "amount", targetNamespace = "http://www.obopay.com/xml/bulkpayment/v1")
                    BigDecimal amount,
            @WebParam(name = "batchref", targetNamespace = "http://www.obopay.com/xml/bulkpayment/v1")
                    String batchref,
            @WebParam(name = "username", targetNamespace = "http://www.obopay.com/xml/bulkpayment/v1")
                    String username,
            @WebParam(name = "password", targetNamespace = "http://www.obopay.com/xml/bulkpayment/v1")
                    String password,
            @WebParam(name = "narrative", targetNamespace = "http://www.obopay.com/xml/bulkpayment/v1")
                    String narrative);

    /**
     * @param password
     * @param narration
     * @param nickname
     * @param referenceid
     * @param username
     * @return returns org.muhia.app.psi.integ.wsdl.am.bulkpayment.TrxRevertResponse2
     */
    @WebMethod(operationName = "TrxRevert", action = "TrxRevert")
    @WebResult(name = "TrxRevertResult", targetNamespace = "http://www.obopay.com/xml/bulkpayment/v1")
    @RequestWrapper(localName = "TrxRevert", targetNamespace = "http://www.obopay.com/xml/bulkpayment/v1", className = "org.muhia.app.psi.integ.wsdl.am.bulkpayment.TrxRevert")
    @ResponseWrapper(localName = "TrxRevertResponse", targetNamespace = "http://www.obopay.com/xml/bulkpayment/v1", className = "org.muhia.app.psi.integ.wsdl.am.bulkpayment.TrxRevertResponse")
    TrxRevertResponse2 trxRevert(
            @WebParam(name = "referenceid", targetNamespace = "http://www.obopay.com/xml/bulkpayment/v1")
                    String referenceid,
            @WebParam(name = "narration", targetNamespace = "http://www.obopay.com/xml/bulkpayment/v1")
                    String narration,
            @WebParam(name = "nickname", targetNamespace = "http://www.obopay.com/xml/bulkpayment/v1")
                    String nickname,
            @WebParam(name = "username", targetNamespace = "http://www.obopay.com/xml/bulkpayment/v1")
                    String username,
            @WebParam(name = "password", targetNamespace = "http://www.obopay.com/xml/bulkpayment/v1")
                    String password);

}
