package org.muhia.app.psi.integ.wsdl.crba.transunion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for getProduct150 complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="getProduct150">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="infinityCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="companyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="companyRegNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taxID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vatID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="companyRegDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="postalBoxNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="postalTown" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="postalCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="telephoneNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="faxNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="websiteAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "getProduct150", propOrder = {"username", "password", "code", "infinityCode", "companyName", "companyRegNo", "taxID", "vatID", "companyRegDate", "postalBoxNo", "postalTown", "postalCountry", "telephoneNo", "faxNo", "websiteAddress", "physicalAddress", "physicalTown", "physicalCountry", "reportSector", "reportReason"})
public class GetProduct150 {

    protected String username;
    protected String password;
    protected String code;
    protected String infinityCode;
    protected String companyName;
    protected String companyRegNo;
    protected String taxID;
    protected String vatID;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar companyRegDate;
    protected String postalBoxNo;
    protected String postalTown;
    protected String postalCountry;
    protected String telephoneNo;
    protected String faxNo;
    protected String websiteAddress;
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
     * Gets the value of the companyRegNo property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCompanyRegNo() {
        return companyRegNo;
    }

    /**
     * Sets the value of the companyRegNo property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCompanyRegNo(String value) {
        this.companyRegNo = value;
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
     * Gets the value of the vatID property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVatID() {
        return vatID;
    }

    /**
     * Sets the value of the vatID property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setVatID(String value) {
        this.vatID = value;
    }

    /**
     * Gets the value of the companyRegDate property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getCompanyRegDate() {
        return companyRegDate;
    }

    /**
     * Sets the value of the companyRegDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setCompanyRegDate(XMLGregorianCalendar value) {
        this.companyRegDate = value;
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
     * Gets the value of the telephoneNo property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTelephoneNo() {
        return telephoneNo;
    }

    /**
     * Sets the value of the telephoneNo property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTelephoneNo(String value) {
        this.telephoneNo = value;
    }

    /**
     * Gets the value of the faxNo property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFaxNo() {
        return faxNo;
    }

    /**
     * Sets the value of the faxNo property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFaxNo(String value) {
        this.faxNo = value;
    }

    /**
     * Gets the value of the websiteAddress property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getWebsiteAddress() {
        return websiteAddress;
    }

    /**
     * Sets the value of the websiteAddress property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setWebsiteAddress(String value) {
        this.websiteAddress = value;
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
