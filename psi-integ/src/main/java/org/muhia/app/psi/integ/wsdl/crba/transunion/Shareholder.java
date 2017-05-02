package org.muhia.app.psi.integ.wsdl.crba.transunion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for shareholder complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="shareholder">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fullName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numberOfShares" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shareValue" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="shareholderCrn" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "shareholder", propOrder = {"fullName", "numberOfShares", "shareValue", "shareholderCrn"})
public class Shareholder {

    protected String fullName;
    protected String numberOfShares;
    protected Double shareValue;
    protected Integer shareholderCrn;

    /**
     * Gets the value of the fullName property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the value of the fullName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFullName(String value) {
        this.fullName = value;
    }

    /**
     * Gets the value of the numberOfShares property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNumberOfShares() {
        return numberOfShares;
    }

    /**
     * Sets the value of the numberOfShares property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNumberOfShares(String value) {
        this.numberOfShares = value;
    }

    /**
     * Gets the value of the shareValue property.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getShareValue() {
        return shareValue;
    }

    /**
     * Sets the value of the shareValue property.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setShareValue(Double value) {
        this.shareValue = value;
    }

    /**
     * Gets the value of the shareholderCrn property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getShareholderCrn() {
        return shareholderCrn;
    }

    /**
     * Sets the value of the shareholderCrn property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setShareholderCrn(Integer value) {
        this.shareholderCrn = value;
    }

}
