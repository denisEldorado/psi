package org.muhia.app.psi.integ.wsdl.crba.transunion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for employment complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="employment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="designation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="employerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="physicalAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="postalAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="profession" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "employment", propOrder = {"designation", "employerName", "physicalAddress", "postalAddress", "profession"})
public class Employment {

    protected String designation;
    protected String employerName;
    protected String physicalAddress;
    protected String postalAddress;
    protected String profession;

    /**
     * Gets the value of the designation property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Sets the value of the designation property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDesignation(String value) {
        this.designation = value;
    }

    /**
     * Gets the value of the employerName property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getEmployerName() {
        return employerName;
    }

    /**
     * Sets the value of the employerName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEmployerName(String value) {
        this.employerName = value;
    }

    /**
     * Gets the value of the physicalAddress property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPhysicalAddress() {
        return physicalAddress;
    }

    /**
     * Sets the value of the physicalAddress property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPhysicalAddress(String value) {
        this.physicalAddress = value;
    }

    /**
     * Gets the value of the postalAddress property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPostalAddress() {
        return postalAddress;
    }

    /**
     * Sets the value of the postalAddress property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPostalAddress(String value) {
        this.postalAddress = value;
    }

    /**
     * Gets the value of the profession property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getProfession() {
        return profession;
    }

    /**
     * Sets the value of the profession property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setProfession(String value) {
        this.profession = value;
    }

}
