package org.muhia.app.psi.integ.wsdl.crba.transunion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for fraud complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="fraud">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fraudAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="fraudStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="incidentDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="incidentDetails" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lossAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="tradeSector" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fraud", propOrder = {"currency", "fraudAmount", "fraudStatus", "incidentDate", "incidentDetails", "lossAmount", "tradeSector"})
public class Fraud {

    protected String currency;
    protected Double fraudAmount;
    protected String fraudStatus;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar incidentDate;
    protected String incidentDetails;
    protected Double lossAmount;
    protected String tradeSector;

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
     * Gets the value of the fraudAmount property.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getFraudAmount() {
        return fraudAmount;
    }

    /**
     * Sets the value of the fraudAmount property.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setFraudAmount(Double value) {
        this.fraudAmount = value;
    }

    /**
     * Gets the value of the fraudStatus property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFraudStatus() {
        return fraudStatus;
    }

    /**
     * Sets the value of the fraudStatus property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFraudStatus(String value) {
        this.fraudStatus = value;
    }

    /**
     * Gets the value of the incidentDate property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getIncidentDate() {
        return incidentDate;
    }

    /**
     * Sets the value of the incidentDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setIncidentDate(XMLGregorianCalendar value) {
        this.incidentDate = value;
    }

    /**
     * Gets the value of the incidentDetails property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getIncidentDetails() {
        return incidentDetails;
    }

    /**
     * Sets the value of the incidentDetails property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setIncidentDetails(String value) {
        this.incidentDetails = value;
    }

    /**
     * Gets the value of the lossAmount property.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getLossAmount() {
        return lossAmount;
    }

    /**
     * Sets the value of the lossAmount property.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setLossAmount(Double value) {
        this.lossAmount = value;
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
