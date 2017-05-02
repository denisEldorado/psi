
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
 *         &lt;element name="TrxRevertResult" type="{java:com.obopay.ws.bulkpayment.zain}TrxRevertResponse"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "trxRevertResult"
})
@XmlRootElement(name = "TrxRevertResponse")
public class TrxRevertResponse2 {

    @XmlElement(name = "TrxRevertResult", required = true)
    protected TrxRevertResponse trxRevertResult;

    /**
     * Gets the value of the trxRevertResult property.
     *
     * @return possible object is
     * {@link TrxRevertResponse }
     */
    public TrxRevertResponse getTrxRevertResult() {
        return trxRevertResult;
    }

    /**
     * Sets the value of the trxRevertResult property.
     *
     * @param value allowed object is
     *              {@link TrxRevertResponse }
     */
    public void setTrxRevertResult(TrxRevertResponse value) {
        this.trxRevertResult = value;
    }

}
