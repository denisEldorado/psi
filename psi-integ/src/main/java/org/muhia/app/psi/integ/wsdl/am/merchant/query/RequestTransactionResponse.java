
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
 *         &lt;element name="RequestTransactionResult" type="{java:com.obopay.ws.merchantquery.zain}Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "requestTransactionResult"
})
@XmlRootElement(name = "RequestTransactionResponse")
public class RequestTransactionResponse {

    @XmlElement(name = "RequestTransactionResult", required = true)
    protected Response requestTransactionResult;

    /**
     * Gets the value of the requestTransactionResult property.
     *
     * @return possible object is
     * {@link Response }
     */
    public Response getRequestTransactionResult() {
        return requestTransactionResult;
    }

    /**
     * Sets the value of the requestTransactionResult property.
     *
     * @param value allowed object is
     *              {@link Response }
     */
    public void setRequestTransactionResult(Response value) {
        this.requestTransactionResult = value;
    }

}
