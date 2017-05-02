package org.muhia.app.psi.integ.wsdl.crba.transunion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for shareholding complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="shareholding">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="companyCrn" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="companyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numberOfShares" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shareValue" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "shareholding", propOrder = {"companyCrn", "companyName", "numberOfShares", "shareValue"})
public class Shareholding {

    protected Integer companyCrn;
    protected String companyName;
    protected String numberOfShares;
    protected Double shareValue;

    /**
     * Gets the value of the companyCrn property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getCompanyCrn() {
        return companyCrn;
    }

    /**
     * Sets the value of the companyCrn property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setCompanyCrn(Integer value) {
        this.companyCrn = value;
    }

    /**
     * Gets the value of the companyName property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Sets the value of the companyName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCompanyName(String value) {
        this.companyName = value;
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

}
