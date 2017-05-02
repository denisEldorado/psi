package org.muhia.app.psi.integ.wsdl.crba.transunion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for guarantor complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="guarantor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="disputed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="guarantorAccountType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="guarantorCrn" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="guarantorLimit" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="guarantorType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="loanStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="principalAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "guarantor", propOrder = {"currency", "disputed", "guarantorAccountType", "guarantorCrn", "guarantorLimit", "guarantorType", "loanStatus", "principalAmount"})
public class Guarantor {

    protected String currency;
    protected String disputed;
    protected String guarantorAccountType;
    protected Integer guarantorCrn;
    protected Double guarantorLimit;
    protected String guarantorType;
    protected String loanStatus;
    protected Double principalAmount;

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
     * Gets the value of the disputed property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDisputed() {
        return disputed;
    }

    /**
     * Sets the value of the disputed property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDisputed(String value) {
        this.disputed = value;
    }

    /**
     * Gets the value of the guarantorAccountType property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getGuarantorAccountType() {
        return guarantorAccountType;
    }

    /**
     * Sets the value of the guarantorAccountType property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setGuarantorAccountType(String value) {
        this.guarantorAccountType = value;
    }

    /**
     * Gets the value of the guarantorCrn property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getGuarantorCrn() {
        return guarantorCrn;
    }

    /**
     * Sets the value of the guarantorCrn property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setGuarantorCrn(Integer value) {
        this.guarantorCrn = value;
    }

    /**
     * Gets the value of the guarantorLimit property.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getGuarantorLimit() {
        return guarantorLimit;
    }

    /**
     * Sets the value of the guarantorLimit property.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setGuarantorLimit(Double value) {
        this.guarantorLimit = value;
    }

    /**
     * Gets the value of the guarantorType property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getGuarantorType() {
        return guarantorType;
    }

    /**
     * Sets the value of the guarantorType property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setGuarantorType(String value) {
        this.guarantorType = value;
    }

    /**
     * Gets the value of the loanStatus property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLoanStatus() {
        return loanStatus;
    }

    /**
     * Sets the value of the loanStatus property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLoanStatus(String value) {
        this.loanStatus = value;
    }

    /**
     * Gets the value of the principalAmount property.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getPrincipalAmount() {
        return principalAmount;
    }

    /**
     * Sets the value of the principalAmount property.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setPrincipalAmount(Double value) {
        this.principalAmount = value;
    }

}
