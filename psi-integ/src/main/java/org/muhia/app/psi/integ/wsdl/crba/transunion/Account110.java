package org.muhia.app.psi.integ.wsdl.crba.transunion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for account110 complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="account110">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="balanceAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subscriberShortCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "account110", propOrder = {"balanceAmount", "category", "subscriberShortCode"})
public class Account110 {

    protected Double balanceAmount;
    protected String category;
    protected String subscriberShortCode;

    /**
     * Gets the value of the balanceAmount property.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getBalanceAmount() {
        return balanceAmount;
    }

    /**
     * Sets the value of the balanceAmount property.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setBalanceAmount(Double value) {
        this.balanceAmount = value;
    }

    /**
     * Gets the value of the category property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCategory(String value) {
        this.category = value;
    }

    /**
     * Gets the value of the subscriberShortCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSubscriberShortCode() {
        return subscriberShortCode;
    }

    /**
     * Sets the value of the subscriberShortCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSubscriberShortCode(String value) {
        this.subscriberShortCode = value;
    }

}
