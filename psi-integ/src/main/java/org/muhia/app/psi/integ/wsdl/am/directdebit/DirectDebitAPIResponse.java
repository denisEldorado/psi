
package org.muhia.app.psi.integ.wsdl.am.directdebit;

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
 *         &lt;element name="DirectDebitAPIResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "directDebitAPIResult"
})
@XmlRootElement(name = "DirectDebitAPIResponse")
public class DirectDebitAPIResponse {

    @XmlElement(name = "DirectDebitAPIResult", required = true)
    protected String directDebitAPIResult;

    /**
     * Gets the value of the directDebitAPIResult property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDirectDebitAPIResult() {
        return directDebitAPIResult;
    }

    /**
     * Sets the value of the directDebitAPIResult property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDirectDebitAPIResult(String value) {
        this.directDebitAPIResult = value;
    }

}
