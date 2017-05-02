package org.muhia.app.psi.integ.wsdl.crba.transunion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getProduct405 complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="getProduct405">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="infinityCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="origin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dest" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="receivedTimeStamp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transactionDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transactionTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transactionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transactionMobileNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transactionAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="senderNames" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transactionAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getProduct405", propOrder = {"username", "password", "code", "infinityCode", "origin", "dest", "receivedTimeStamp", "transactionDate", "transactionTime", "transactionCode", "transactionMobileNo", "transactionAccount", "senderNames", "transactionAmount"})
public class GetProduct405 {

    protected String username;
    protected String password;
    protected String code;
    protected String infinityCode;
    protected String origin;
    protected String dest;
    protected String receivedTimeStamp;
    protected String transactionDate;
    protected String transactionTime;
    protected String transactionCode;
    protected String transactionMobileNo;
    protected String transactionAccount;
    protected String senderNames;
    protected String transactionAmount;

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
     * Gets the value of the code property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the infinityCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getInfinityCode() {
        return infinityCode;
    }

    /**
     * Sets the value of the infinityCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setInfinityCode(String value) {
        this.infinityCode = value;
    }

    /**
     * Gets the value of the origin property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Sets the value of the origin property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setOrigin(String value) {
        this.origin = value;
    }

    /**
     * Gets the value of the dest property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDest() {
        return dest;
    }

    /**
     * Sets the value of the dest property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDest(String value) {
        this.dest = value;
    }

    /**
     * Gets the value of the receivedTimeStamp property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getReceivedTimeStamp() {
        return receivedTimeStamp;
    }

    /**
     * Sets the value of the receivedTimeStamp property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setReceivedTimeStamp(String value) {
        this.receivedTimeStamp = value;
    }

    /**
     * Gets the value of the transactionDate property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTransactionDate() {
        return transactionDate;
    }

    /**
     * Sets the value of the transactionDate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTransactionDate(String value) {
        this.transactionDate = value;
    }

    /**
     * Gets the value of the transactionTime property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTransactionTime() {
        return transactionTime;
    }

    /**
     * Sets the value of the transactionTime property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTransactionTime(String value) {
        this.transactionTime = value;
    }

    /**
     * Gets the value of the transactionCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTransactionCode() {
        return transactionCode;
    }

    /**
     * Sets the value of the transactionCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTransactionCode(String value) {
        this.transactionCode = value;
    }

    /**
     * Gets the value of the transactionMobileNo property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTransactionMobileNo() {
        return transactionMobileNo;
    }

    /**
     * Sets the value of the transactionMobileNo property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTransactionMobileNo(String value) {
        this.transactionMobileNo = value;
    }

    /**
     * Gets the value of the transactionAccount property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTransactionAccount() {
        return transactionAccount;
    }

    /**
     * Sets the value of the transactionAccount property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTransactionAccount(String value) {
        this.transactionAccount = value;
    }

    /**
     * Gets the value of the senderNames property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSenderNames() {
        return senderNames;
    }

    /**
     * Sets the value of the senderNames property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSenderNames(String value) {
        this.senderNames = value;
    }

    /**
     * Gets the value of the transactionAmount property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTransactionAmount() {
        return transactionAmount;
    }

    /**
     * Sets the value of the transactionAmount property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTransactionAmount(String value) {
        this.transactionAmount = value;
    }

}
