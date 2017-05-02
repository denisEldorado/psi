
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
 *         &lt;element name="RequestTransactionByTimeIntervalDetailedResult" type="{java:com.obopay.ws.merchantquery.zain}RequestTransactionsResponse"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "requestTransactionByTimeIntervalDetailedResult"
})
@XmlRootElement(name = "RequestTransactionByTimeIntervalDetailedResponse")
public class RequestTransactionByTimeIntervalDetailedResponse {

    @XmlElement(name = "RequestTransactionByTimeIntervalDetailedResult", required = true)
    protected RequestTransactionsResponse requestTransactionByTimeIntervalDetailedResult;

    /**
     * Gets the value of the requestTransactionByTimeIntervalDetailedResult property.
     *
     * @return possible object is
     * {@link RequestTransactionsResponse }
     */
    public RequestTransactionsResponse getRequestTransactionByTimeIntervalDetailedResult() {
        return requestTransactionByTimeIntervalDetailedResult;
    }

    /**
     * Sets the value of the requestTransactionByTimeIntervalDetailedResult property.
     *
     * @param value allowed object is
     *              {@link RequestTransactionsResponse }
     */
    public void setRequestTransactionByTimeIntervalDetailedResult(RequestTransactionsResponse value) {
        this.requestTransactionByTimeIntervalDetailedResult = value;
    }

}
