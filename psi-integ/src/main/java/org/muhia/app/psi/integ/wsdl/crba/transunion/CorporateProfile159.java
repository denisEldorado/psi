package org.muhia.app.psi.integ.wsdl.crba.transunion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for corporateProfile159 complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="corporateProfile159">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="companyCeaseDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="companyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="companyRegDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="companyRegNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="companyStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="companyType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="crn" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="industry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taxNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vatNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "corporateProfile159", propOrder = {"companyCeaseDate", "companyName", "companyRegDate", "companyRegNo", "companyStatus", "companyType", "crn", "industry", "taxNo", "vatNo"})
public class CorporateProfile159 {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar companyCeaseDate;
    protected String companyName;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar companyRegDate;
    protected String companyRegNo;
    protected String companyStatus;
    protected String companyType;
    protected Integer crn;
    protected String industry;
    protected String taxNo;
    protected String vatNo;

    /**
     * Gets the value of the companyCeaseDate property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getCompanyCeaseDate() {
        return companyCeaseDate;
    }

    /**
     * Sets the value of the companyCeaseDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setCompanyCeaseDate(XMLGregorianCalendar value) {
        this.companyCeaseDate = value;
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
     * Gets the value of the companyStatus property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCompanyStatus() {
        return companyStatus;
    }

    /**
     * Sets the value of the companyStatus property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCompanyStatus(String value) {
        this.companyStatus = value;
    }

    /**
     * Gets the value of the companyType property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCompanyType() {
        return companyType;
    }

    /**
     * Sets the value of the companyType property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCompanyType(String value) {
        this.companyType = value;
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
     * Gets the value of the industry property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getIndustry() {
        return industry;
    }

    /**
     * Sets the value of the industry property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setIndustry(String value) {
        this.industry = value;
    }

    /**
     * Gets the value of the taxNo property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTaxNo() {
        return taxNo;
    }

    /**
     * Sets the value of the taxNo property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTaxNo(String value) {
        this.taxNo = value;
    }

    /**
     * Gets the value of the vatNo property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVatNo() {
        return vatNo;
    }

    /**
     * Sets the value of the vatNo property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setVatNo(String value) {
        this.vatNo = value;
    }

}
