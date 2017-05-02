
package org.muhia.app.psi.integ.wsdl.am.merchant.query;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RequestTransactionByTimeIntervalResult" type="{java:com.obopay.ws.merchantquery.zain}RequestTransactionsResponse"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "requestTransactionByTimeIntervalResult"
})
@XmlRootElement(name = "RequestTransactionByTimeIntervalResponse")
public class RequestTransactionByTimeIntervalResponse {

    @XmlElement(name = "RequestTransactionByTimeIntervalResult", required = true)
    protected RequestTransactionsResponse requestTransactionByTimeIntervalResult;

    /**
     * Gets the value of the requestTransactionByTimeIntervalResult property.
     *
     * @return possible object is
     * {@link RequestTransactionsResponse }
     */
    public RequestTransactionsResponse getRequestTransactionByTimeIntervalResult() {
        return requestTransactionByTimeIntervalResult;
    }

    /**
     * Sets the value of the requestTransactionByTimeIntervalResult property.
     *
     * @param value allowed object is
     *              {@link RequestTransactionsResponse }
     */
    public void setRequestTransactionByTimeIntervalResult(RequestTransactionsResponse value) {
        this.requestTransactionByTimeIntervalResult = value;
    }

}
