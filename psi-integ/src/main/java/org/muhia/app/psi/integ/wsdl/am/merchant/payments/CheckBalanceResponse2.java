
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
 *         &lt;element name="CheckBalanceResult" type="{java:com.obopay.ws.bulkpayment.zain}CheckBalanceResponse"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "checkBalanceResult"
})
@XmlRootElement(name = "CheckBalanceResponse")
public class CheckBalanceResponse2 {

    @XmlElement(name = "CheckBalanceResult", required = true)
    protected CheckBalanceResponse checkBalanceResult;

    /**
     * Gets the value of the checkBalanceResult property.
     *
     * @return possible object is
     * {@link CheckBalanceResponse }
     */
    public CheckBalanceResponse getCheckBalanceResult() {
        return checkBalanceResult;
    }

    /**
     * Sets the value of the checkBalanceResult property.
     *
     * @param value allowed object is
     *              {@link CheckBalanceResponse }
     */
    public void setCheckBalanceResult(CheckBalanceResponse value) {
        this.checkBalanceResult = value;
    }

}
