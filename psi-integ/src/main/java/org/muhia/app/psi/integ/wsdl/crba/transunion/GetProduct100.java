package org.muhia.app.psi.integ.wsdl.crba.transunion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for getProduct100 complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="getProduct100">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="infinityCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nationalID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="passportNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serviceID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="alienID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taxID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateOfBirth" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="postalBoxNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="postalTown" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="postalCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="telephoneWork" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="telephoneHome" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="telephoneMobile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="physicalAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="physicalTown" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="physicalCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reportSector" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="reportReason" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getProduct100", propOrder = {"username", "password", "code", "infinityCode", "name1", "name2", "name3", "name4", "nationalID", "passportNo", "serviceID", "alienID", "taxID", "dateOfBirth", "postalBoxNo", "postalTown", "postalCountry", "telephoneWork", "telephoneHome", "telephoneMobile", "physicalAddress", "physicalTown", "physicalCountry", "reportSector", "reportReason"})
public class GetProduct100 {

    protected String username;
    protected String password;
    protected String code;
    protected String infinityCode;
    protected String name1;
    protected String name2;
    protected String name3;
    protected String name4;
    protected String nationalID;
    protected String passportNo;
    protected String serviceID;
    protected String alienID;
    protected String taxID;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateOfBirth;
    protected String postalBoxNo;
    protected String postalTown;
    protected String postalCountry;
    protected String telephoneWork;
    protected String telephoneHome;
    protected String telephoneMobile;
    protected String physicalAddress;
    protected String physicalTown;
    protected String physicalCountry;
    protected int reportSector;
    protected int reportReason;

    /**
     * Gets the value of the username property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * Gets the value of the password property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the code property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the infinityCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getInfinityCode() {
        return infinityCode;
    }

    /**
     * Sets the value of the infinityCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setInfinityCode(String value) {
        this.infinityCode = value;
    }

    /**
     * Gets the value of the name1 property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getName1() {
        return name1;
    }

    /**
     * Sets the value of the name1 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName1(String value) {
        this.name1 = value;
    }

    /**
     * Gets the value of the name2 property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getName2() {
        return name2;
    }

    /**
     * Sets the value of the name2 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName2(String value) {
        this.name2 = value;
    }

    /**
     * Gets the value of the name3 property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getName3() {
        return name3;
    }

    /**
     * Sets the value of the name3 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName3(String value) {
        this.name3 = value;
    }

    /**
     * Gets the value of the name4 property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getName4() {
        return name4;
    }

    /**
     * Sets the value of the name4 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName4(String value) {
        this.name4 = value;
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
     * Gets the value of the taxID property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTaxID() {
        return taxID;
    }

    /**
     * Sets the value of the taxID property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTaxID(String value) {
        this.taxID = value;
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
     * Gets the value of the postalBoxNo property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPostalBoxNo() {
        return postalBoxNo;
    }

    /**
     * Sets the value of the postalBoxNo property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPostalBoxNo(String value) {
        this.postalBoxNo = value;
    }

    /**
     * Gets the value of the postalTown property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPostalTown() {
        return postalTown;
    }

    /**
     * Sets the value of the postalTown property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPostalTown(String value) {
        this.postalTown = value;
    }

    /**
     * Gets the value of the postalCountry property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPostalCountry() {
        return postalCountry;
    }

    /**
     * Sets the value of the postalCountry property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPostalCountry(String value) {
        this.postalCountry = value;
    }

    /**
     * Gets the value of the telephoneWork property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTelephoneWork() {
        return telephoneWork;
    }

    /**
     * Sets the value of the telephoneWork property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTelephoneWork(String value) {
        this.telephoneWork = value;
    }

    /**
     * Gets the value of the telephoneHome property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTelephoneHome() {
        return telephoneHome;
    }

    /**
     * Sets the value of the telephoneHome property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTelephoneHome(String value) {
        this.telephoneHome = value;
    }

    /**
     * Gets the value of the telephoneMobile property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTelephoneMobile() {
        return telephoneMobile;
    }

    /**
     * Sets the value of the telephoneMobile property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTelephoneMobile(String value) {
        this.telephoneMobile = value;
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
     * Gets the value of the physicalTown property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPhysicalTown() {
        return physicalTown;
    }

    /**
     * Sets the value of the physicalTown property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPhysicalTown(String value) {
        this.physicalTown = value;
    }

    /**
     * Gets the value of the physicalCountry property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPhysicalCountry() {
        return physicalCountry;
    }

    /**
     * Sets the value of the physicalCountry property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPhysicalCountry(String value) {
        this.physicalCountry = value;
    }

    /**
     * Gets the value of the reportSector property.
     */
    public int getReportSector() {
        return reportSector;
    }

    /**
     * Sets the value of the reportSector property.
     */
    public void setReportSector(int value) {
        this.reportSector = value;
    }

    /**
     * Gets the value of the reportReason property.
     */
    public int getReportReason() {
        return reportReason;
    }

    /**
     * Sets the value of the reportReason property.
     */
    public void setReportReason(int value) {
        this.reportReason = value;
    }

}
