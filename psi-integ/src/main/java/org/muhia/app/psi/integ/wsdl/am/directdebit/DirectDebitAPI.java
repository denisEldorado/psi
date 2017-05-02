
package org.muhia.app.psi.integ.wsdl.am.directdebit;

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
 *         &lt;element name="UserName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Password" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CustomerMobileNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="MerchantWalletMsisdn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "userName",
        "password",
        "customerMobileNumber",
        "amount",
        "merchantWalletMsisdn"
})
@XmlRootElement(name = "DirectDebitAPI")
public class DirectDebitAPI {

    @XmlElement(name = "UserName", required = true)
    protected String userName;
    @XmlElement(name = "Password", required = true)
    protected String password;
    @XmlElement(name = "CustomerMobileNumber", required = true)
    protected String customerMobileNumber;
    @XmlElement(name = "Amount", required = true)
    protected BigDecimal amount;
    @XmlElement(name = "MerchantWalletMsisdn", required = true)
    protected String merchantWalletMsisdn;

    /**
     * Gets the value of the userName property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUserName(String value) {
        this.userName = value;
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
     * Gets the value of the customerMobileNumber property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCustomerMobileNumber() {
        return customerMobileNumber;
    }

    /**
     * Sets the value of the customerMobileNumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCustomerMobileNumber(String value) {
        this.customerMobileNumber = value;
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
     * Gets the value of the merchantWalletMsisdn property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getMerchantWalletMsisdn() {
        return merchantWalletMsisdn;
    }

    /**
     * Sets the value of the merchantWalletMsisdn property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMerchantWalletMsisdn(String value) {
        this.merchantWalletMsisdn = value;
    }

}
