package org.muhia.app.psi.integ.wsdl.crba.transunion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for bouncedCheque complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="bouncedCheque">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bouncedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="bouncedReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="chequeAccountType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="chequeAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="chequeDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="chequeNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tradeSector" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bouncedCheque", propOrder = {"bouncedDate", "bouncedReason", "chequeAccountType", "chequeAmount", "chequeDate", "chequeNo", "currency", "tradeSector"})
public class BouncedCheque {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar bouncedDate;
    protected String bouncedReason;
    protected String chequeAccountType;
    protected Double chequeAmount;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar chequeDate;
    protected String chequeNo;
    protected String currency;
    protected String tradeSector;

    /**
     * Gets the value of the bouncedDate property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getBouncedDate() {
        return bouncedDate;
    }

    /**
     * Sets the value of the bouncedDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setBouncedDate(XMLGregorianCalendar value) {
        this.bouncedDate = value;
    }

    /**
     * Gets the value of the bouncedReason property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBouncedReason() {
        return bouncedReason;
    }

    /**
     * Sets the value of the bouncedReason property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBouncedReason(String value) {
        this.bouncedReason = value;
    }

    /**
     * Gets the value of the chequeAccountType property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getChequeAccountType() {
        return chequeAccountType;
    }

    /**
     * Sets the value of the chequeAccountType property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setChequeAccountType(String value) {
        this.chequeAccountType = value;
    }

    /**
     * Gets the value of the chequeAmount property.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getChequeAmount() {
        return chequeAmount;
    }

    /**
     * Sets the value of the chequeAmount property.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setChequeAmount(Double value) {
        this.chequeAmount = value;
    }

    /**
     * Gets the value of the chequeDate property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getChequeDate() {
        return chequeDate;
    }

    /**
     * Sets the value of the chequeDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setChequeDate(XMLGregorianCalendar value) {
        this.chequeDate = value;
    }

    /**
     * Gets the value of the chequeNo property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getChequeNo() {
        return chequeNo;
    }

    /**
     * Sets the value of the chequeNo property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setChequeNo(String value) {
        this.chequeNo = value;
    }

    /**
     * Gets the value of the currency property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * Gets the value of the tradeSector property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTradeSector() {
        return tradeSector;
    }

    /**
     * Sets the value of the tradeSector property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTradeSector(String value) {
        this.tradeSector = value;
    }

}
