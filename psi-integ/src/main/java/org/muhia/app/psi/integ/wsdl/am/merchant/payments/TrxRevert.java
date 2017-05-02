
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
 *       &lt;element name="TrxRevert" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "trxRevert"
})
@XmlRootElement(name = "TrxRevert")
public class TrxRevert {

    @XmlElement(name = "TrxRevert", required = true)
    protected String trxRevert;

    /**
     * Gets the value of the trxRevert property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTrxRevert() {
        return trxRevert;
    }

    /**
     * Sets the value of the trxRevert property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTrxRevert(String value) {
        this.trxRevert = value;
    }

}
