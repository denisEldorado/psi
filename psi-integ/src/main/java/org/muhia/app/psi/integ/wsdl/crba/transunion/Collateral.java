package org.muhia.app.psi.integ.wsdl.crba.transunion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for collateral complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="collateral">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="collateralRefNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="collateralType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="saleAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="saleDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="tradeSector" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="valuationAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="valuationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "collateral", propOrder = {"collateralRefNo", "collateralType", "currency", "description", "saleAmount", "saleDate", "tradeSector", "valuationAmount", "valuationDate"})
public class Collateral {

    protected String collateralRefNo;
    protected String collateralType;
    protected String currency;
    protected String description;
    protected Double saleAmount;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar saleDate;
    protected String tradeSector;
    protected Double valuationAmount;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar valuationDate;

    /**
     * Gets the value of the collateralRefNo property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCollateralRefNo() {
        return collateralRefNo;
    }

    /**
     * Sets the value of the collateralRefNo property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCollateralRefNo(String value) {
        this.collateralRefNo = value;
    }

    /**
     * Gets the value of the collateralType property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCollateralType() {
        return collateralType;
    }

    /**
     * Sets the value of the collateralType property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCollateralType(String value) {
        this.collateralType = value;
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
     * Gets the value of the description property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the saleAmount property.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getSaleAmount() {
        return saleAmount;
    }

    /**
     * Sets the value of the saleAmount property.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setSaleAmount(Double value) {
        this.saleAmount = value;
    }

    /**
     * Gets the value of the saleDate property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getSaleDate() {
        return saleDate;
    }

    /**
     * Sets the value of the saleDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setSaleDate(XMLGregorianCalendar value) {
        this.saleDate = value;
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

    /**
     * Gets the value of the valuationAmount property.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getValuationAmount() {
        return valuationAmount;
    }

    /**
     * Sets the value of the valuationAmount property.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setValuationAmount(Double value) {
        this.valuationAmount = value;
    }

    /**
     * Gets the value of the valuationDate property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getValuationDate() {
        return valuationDate;
    }

    /**
     * Sets the value of the valuationDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setValuationDate(XMLGregorianCalendar value) {
        this.valuationDate = value;
    }

}
