
package org.muhia.app.psi.integ.wsdl.am.merchant.query;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * <p>Java class for Response complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Referenceld" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Msisdn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FirstName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LastName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TransactionId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="PaymentDetails" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CreatedTimestamp" type="{java:javax.xml.datatype}XMLGregorianCalendar"/>
 *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Response", namespace = "java:com.obopay.ws.merchantquery.zain", propOrder = {
        "referenceld",
        "status",
        "msisdn",
        "firstName",
        "lastName",
        "transactionId",
        "paymentDetails",
        "createdTimestamp",
        "amount",
        "message"
})
public class Response {

    @XmlElement(name = "Referenceld", required = true, nillable = true)
    protected String referenceld;
    @XmlElement(name = "Status")
    protected int status;
    @XmlElement(name = "Msisdn", required = true, nillable = true)
    protected String msisdn;
    @XmlElement(name = "FirstName", required = true, nillable = true)
    protected String firstName;
    @XmlElement(name = "LastName", required = true, nillable = true)
    protected String lastName;
    @XmlElement(name = "TransactionId")
    protected long transactionId;
    @XmlElement(name = "PaymentDetails", required = true, nillable = true)
    protected String paymentDetails;
    @XmlElement(name = "CreatedTimestamp", required = true, nillable = true)
    protected XMLGregorianCalendar createdTimestamp;
    @XmlElement(name = "Amount", required = true, nillable = true)
    protected BigDecimal amount;
    @XmlElement(name = "Message", required = true, nillable = true)
    protected String message;

    /**
     * Gets the value of the referenceld property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getReferenceld() {
        return referenceld;
    }

    /**
     * Sets the value of the referenceld property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setReferenceld(String value) {
        this.referenceld = value;
    }

    /**
     * Gets the value of the status property.
     */
    public int getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     */
    public void setStatus(int value) {
        this.status = value;
    }

    /**
     * Gets the value of the msisdn property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getMsisdn() {
        return msisdn;
    }

    /**
     * Sets the value of the msisdn property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMsisdn(String value) {
        this.msisdn = value;
    }

    /**
     * Gets the value of the firstName property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the lastName property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the transactionId property.
     */
    public long getTransactionId() {
        return transactionId;
    }

    /**
     * Sets the value of the transactionId property.
     */
    public void setTransactionId(long value) {
        this.transactionId = value;
    }

    /**
     * Gets the value of the paymentDetails property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPaymentDetails() {
        return paymentDetails;
    }

    /**
     * Sets the value of the paymentDetails property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPaymentDetails(String value) {
        this.paymentDetails = value;
    }

    /**
     * Gets the value of the createdTimestamp property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getCreatedTimestamp() {
        return createdTimestamp;
    }

    /**
     * Sets the value of the createdTimestamp property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setCreatedTimestamp(XMLGregorianCalendar value) {
        this.createdTimestamp = value;
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
     * Gets the value of the message property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMessage(String value) {
        this.message = value;
    }

}
