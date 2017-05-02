package org.muhia.app.psi.integ.wsdl.crba.transunion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for personalProfile114 complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="personalProfile114">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="alienID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="crn" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="dateOfBirth" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="drivingLicenseNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fullName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nationalID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="otherNames" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="passportNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="salutation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serviceID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="surname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "personalProfile114", propOrder = {"alienID", "crn", "dateOfBirth", "drivingLicenseNo", "fullName", "nationalID", "otherNames", "passportNo", "salutation", "serviceID", "surname"})
public class PersonalProfile114 {

    protected String alienID;
    protected Integer crn;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateOfBirth;
    protected String drivingLicenseNo;
    protected String fullName;
    protected String nationalID;
    protected String otherNames;
    protected String passportNo;
    protected String salutation;
    protected String serviceID;
    protected String surname;

    /**
     * Gets the value of the alienID property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAlienID() {
        return alienID;
    }

    /**
     * Sets the value of the alienID property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAlienID(String value) {
        this.alienID = value;
    }

    /**
     * Gets the value of the crn property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getCrn() {
        return crn;
    }

    /**
     * Sets the value of the crn property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setCrn(Integer value) {
        this.crn = value;
    }

    /**
     * Gets the value of the dateOfBirth property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the value of the dateOfBirth property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setDateOfBirth(XMLGregorianCalendar value) {
        this.dateOfBirth = value;
    }

    /**
     * Gets the value of the drivingLicenseNo property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDrivingLicenseNo() {
        return drivingLicenseNo;
    }

    /**
     * Sets the value of the drivingLicenseNo property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDrivingLicenseNo(String value) {
        this.drivingLicenseNo = value;
    }

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
     * Gets the value of the nationalID property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNationalID() {
        return nationalID;
    }

    /**
     * Sets the value of the nationalID property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNationalID(String value) {
        this.nationalID = value;
    }

    /**
     * Gets the value of the otherNames property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getOtherNames() {
        return otherNames;
    }

    /**
     * Sets the value of the otherNames property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setOtherNames(String value) {
        this.otherNames = value;
    }

    /**
     * Gets the value of the passportNo property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPassportNo() {
        return passportNo;
    }

    /**
     * Sets the value of the passportNo property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPassportNo(String value) {
        this.passportNo = value;
    }

    /**
     * Gets the value of the salutation property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSalutation() {
        return salutation;
    }

    /**
     * Sets the value of the salutation property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSalutation(String value) {
        this.salutation = value;
    }

    /**
     * Gets the value of the serviceID property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getServiceID() {
        return serviceID;
    }

    /**
     * Sets the value of the serviceID property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setServiceID(String value) {
        this.serviceID = value;
    }

    /**
     * Gets the value of the surname property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the value of the surname property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSurname(String value) {
        this.surname = value;
    }

}
