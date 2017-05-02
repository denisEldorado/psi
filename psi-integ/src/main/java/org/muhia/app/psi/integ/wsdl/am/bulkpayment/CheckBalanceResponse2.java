
package org.muhia.app.psi.integ.wsdl.am.bulkpayment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CheckBalanceResponse complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="CheckBalanceResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CheckBalanceResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CheckBalanceResponse", namespace = "java:com.obopay.ws.bulkpayment.zain", propOrder = {
        "checkBalanceResult"
})
public class CheckBalanceResponse2 {

    @XmlElement(name = "CheckBalanceResult", required = true, nillable = true)
    protected String checkBalanceResult;

    /**
     * Gets the value of the checkBalanceResult property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCheckBalanceResult() {
        return checkBalanceResult;
    }

    /**
     * Sets the value of the checkBalanceResult property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCheckBalanceResult(String value) {
        this.checkBalanceResult = value;
    }

}
