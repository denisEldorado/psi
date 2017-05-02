
package org.muhia.app.psi.integ.wsdl.am.merchant.query;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * <p>Java class for RequestTransactionsResponse complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="RequestTransactionsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TotalTransactions" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TotalAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Transactions" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestTransactionsResponse", namespace = "java:com.obopay.ws.merchantquery.zain", propOrder = {
        "status",
        "totalTransactions",
        "totalAmount",
        "transactions",
        "message"
})
public class RequestTransactionsResponse {

    @XmlElement(name = "Status")
    protected int status;
    @XmlElement(name = "TotalTransactions")
    protected int totalTransactions;
    @XmlElement(name = "TotalAmount", required = true, nillable = true)
    protected BigDecimal totalAmount;
    @XmlElement(name = "Transactions", required = true, nillable = true)
    protected String transactions;
    @XmlElement(name = "Message", required = true, nillable = true)
    protected String message;

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
     * Gets the value of the totalTransactions property.
     */
    public int getTotalTransactions() {
        return totalTransactions;
    }

    /**
     * Sets the value of the totalTransactions property.
     */
    public void setTotalTransactions(int value) {
        this.totalTransactions = value;
    }

    /**
     * Gets the value of the totalAmount property.
     *
     * @return possible object is
     * {@link BigDecimal }
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * Sets the value of the totalAmount property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setTotalAmount(BigDecimal value) {
        this.totalAmount = value;
    }

    /**
     * Gets the value of the transactions property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTransactions() {
        return transactions;
    }

    /**
     * Sets the value of the transactions property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTransactions(String value) {
        this.transactions = value;
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
