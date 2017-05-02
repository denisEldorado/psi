
package org.muhia.app.psi.integ.wsdl.am.bulkpayment;

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
public class CheckBalanceResponse {

    @XmlElement(name = "CheckBalanceResult", required = true)
    protected CheckBalanceResponse2 checkBalanceResult;

    /**
     * Gets the value of the checkBalanceResult property.
     *
     * @return possible object is
     * {@link CheckBalanceResponse2 }
     */
    public CheckBalanceResponse2 getCheckBalanceResult() {
        return checkBalanceResult;
    }

    /**
     * Sets the value of the checkBalanceResult property.
     *
     * @param value allowed object is
     *              {@link CheckBalanceResponse2 }
     */
    public void setCheckBalanceResult(CheckBalanceResponse2 value) {
        this.checkBalanceResult = value;
    }

}
