package org.muhia.app.psi.integ.wsdl.crba.transunion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for guarantee complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="guarantee">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="disputed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="guaranteeAccountType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="guaranteeCrn" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="guaranteeLimit" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="guaranteeType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="loanStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="principalAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "guarantee", propOrder = {"currency", "disputed", "guaranteeAccountType", "guaranteeCrn", "guaranteeLimit", "guaranteeType", "loanStatus", "principalAmount"})
public class Guarantee {

    protected String currency;
    protected String disputed;
    protected String guaranteeAccountType;
    protected Integer guaranteeCrn;
    protected Double guaranteeLimit;
    protected String guaranteeType;
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
     * Gets the value of the guaranteeAccountType property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getGuaranteeAccountType() {
        return guaranteeAccountType;
    }

    /**
     * Sets the value of the guaranteeAccountType property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setGuaranteeAccountType(String value) {
        this.guaranteeAccountType = value;
    }

    /**
     * Gets the value of the guaranteeCrn property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getGuaranteeCrn() {
        return guaranteeCrn;
    }

    /**
     * Sets the value of the guaranteeCrn property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setGuaranteeCrn(Integer value) {
        this.guaranteeCrn = value;
    }

    /**
     * Gets the value of the guaranteeLimit property.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getGuaranteeLimit() {
        return guaranteeLimit;
    }

    /**
     * Sets the value of the guaranteeLimit property.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setGuaranteeLimit(Double value) {
        this.guaranteeLimit = value;
    }

    /**
     * Gets the value of the guaranteeType property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getGuaranteeType() {
        return guaranteeType;
    }

    /**
     * Sets the value of the guaranteeType property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setGuaranteeType(String value) {
        this.guaranteeType = value;
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
