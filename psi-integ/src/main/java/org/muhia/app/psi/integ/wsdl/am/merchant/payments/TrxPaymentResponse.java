
package org.muhia.app.psi.integ.wsdl.am.merchant.payments;

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
 *         &lt;element name="TrxPaymentResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "trxPaymentResult"
})
@XmlRootElement(name = "TrxPaymentResponse")
public class TrxPaymentResponse {

    @XmlElement(name = "TrxPaymentResult", required = true)
    protected String trxPaymentResult;

    /**
     * Gets the value of the trxPaymentResult property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTrxPaymentResult() {
        return trxPaymentResult;
    }

    /**
     * Sets the value of the trxPaymentResult property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTrxPaymentResult(String value) {
        this.trxPaymentResult = value;
    }

}
