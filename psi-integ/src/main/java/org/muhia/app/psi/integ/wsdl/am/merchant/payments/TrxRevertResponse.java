
package org.muhia.app.psi.integ.wsdl.am.merchant.payments;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TrxRevertResponse complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="TrxRevertResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TrxRevertResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrxRevertResponse", namespace = "java:com.obopay.ws.bulkpayment.zain", propOrder = {
        "trxRevertResult"
})
public class TrxRevertResponse {

    @XmlElement(name = "TrxRevertResult", required = true, nillable = true)
    protected String trxRevertResult;

    /**
     * Gets the value of the trxRevertResult property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTrxRevertResult() {
        return trxRevertResult;
    }

    /**
     * Sets the value of the trxRevertResult property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTrxRevertResult(String value) {
        this.trxRevertResult = value;
    }

}
