package org.muhia.app.psi.integ.wsdl.crba.transunion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for moneySector complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="moneySector">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mySector" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="otherSectors" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "moneySector", propOrder = {"currency", "mySector", "otherSectors"})
public class MoneySector {

    protected String currency;
    protected Double mySector;
    protected Double otherSectors;

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
     * Gets the value of the mySector property.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getMySector() {
        return mySector;
    }

    /**
     * Sets the value of the mySector property.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setMySector(Double value) {
        this.mySector = value;
    }

    /**
     * Gets the value of the otherSectors property.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getOtherSectors() {
        return otherSectors;
    }

    /**
     * Sets the value of the otherSectors property.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setOtherSectors(Double value) {
        this.otherSectors = value;
    }

}
