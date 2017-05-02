
package org.muhia.app.psi.integ.wsdl.am.merchant.payments;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;


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
 *         &lt;element name="referenceid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customermsisdn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nickname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="batchref" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="narrative" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "referenceid",
        "customermsisdn",
        "nickname",
        "amount",
        "batchref",
        "username",
        "password",
        "narrative"
})
@XmlRootElement(name = "TrxPayment")
public class TrxPayment {

    @XmlElement(required = true)
    protected String referenceid;
    @XmlElement(required = true)
    protected String customermsisdn;
    @XmlElement(required = true)
    protected String nickname;
    @XmlElement(required = true)
    protected BigDecimal amount;
    @XmlElement(required = true)
    protected String batchref;
    @XmlElement(required = true)
    protected String username;
    @XmlElement(required = true)
    protected String password;
    @XmlElement(required = true)
    protected String narrative;

    /**
     * Gets the value of the referenceid property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getReferenceid() {
        return referenceid;
    }

    /**
     * Sets the value of the referenceid property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setReferenceid(String value) {
        this.referenceid = value;
    }

    /**
     * Gets the value of the customermsisdn property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCustomermsisdn() {
        return customermsisdn;
    }

    /**
     * Sets the value of the customermsisdn property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCustomermsisdn(String value) {
        this.customermsisdn = value;
    }

    /**
     * Gets the value of the nickname property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Sets the value of the nickname property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNickname(String value) {
        this.nickname = value;
    }

    /**
     * Gets the value of the amount property.
     *
     * @return possible object is
     * {@link BigDecimal }
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setAmount(BigDecimal value) {
        this.amount = value;
    }

    /**
     * Gets the value of the batchref property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBatchref() {
        return batchref;
    }

    /**
     * Sets the value of the batchref property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBatchref(String value) {
        this.batchref = value;
    }

    /**
     * Gets the value of the username property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * Gets the value of the password property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the narrative property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNarrative() {
        return narrative;
    }

    /**
     * Sets the value of the narrative property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNarrative(String value) {
        this.narrative = value;
    }

}
