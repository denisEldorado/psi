package org.muhia.app.psi.integ.wsdl.crba.transunion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for physicalAddress complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="physicalAddress">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cell" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="constituency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="county" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="createDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="district" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="durationInMonths" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="durationInYears" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="plotNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="province" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="residenceType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sector" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="town" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="village" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "physicalAddress", propOrder = {"address", "cell", "constituency", "country", "county", "createDate", "district", "durationInMonths", "durationInYears", "plotNo", "province", "residenceType", "sector", "town", "village"})
public class PhysicalAddress {

    protected String address;
    protected String cell;
    protected String constituency;
    protected String country;
    protected String county;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createDate;
    protected String district;
    protected Integer durationInMonths;
    protected Integer durationInYears;
    protected String plotNo;
    protected String province;
    protected String residenceType;
    protected String sector;
    protected String town;
    protected String village;

    /**
     * Gets the value of the address property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the cell property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCell() {
        return cell;
    }

    /**
     * Sets the value of the cell property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCell(String value) {
        this.cell = value;
    }

    /**
     * Gets the value of the constituency property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getConstituency() {
        return constituency;
    }

    /**
     * Sets the value of the constituency property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setConstituency(String value) {
        this.constituency = value;
    }

    /**
     * Gets the value of the country property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the county property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCounty() {
        return county;
    }

    /**
     * Sets the value of the county property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCounty(String value) {
        this.county = value;
    }

    /**
     * Gets the value of the createDate property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getCreateDate() {
        return createDate;
    }

    /**
     * Sets the value of the createDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setCreateDate(XMLGregorianCalendar value) {
        this.createDate = value;
    }

    /**
     * Gets the value of the district property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDistrict() {
        return district;
    }

    /**
     * Sets the value of the district property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDistrict(String value) {
        this.district = value;
    }

    /**
     * Gets the value of the durationInMonths property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getDurationInMonths() {
        return durationInMonths;
    }

    /**
     * Sets the value of the durationInMonths property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setDurationInMonths(Integer value) {
        this.durationInMonths = value;
    }

    /**
     * Gets the value of the durationInYears property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getDurationInYears() {
        return durationInYears;
    }

    /**
     * Sets the value of the durationInYears property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setDurationInYears(Integer value) {
        this.durationInYears = value;
    }

    /**
     * Gets the value of the plotNo property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPlotNo() {
        return plotNo;
    }

    /**
     * Sets the value of the plotNo property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPlotNo(String value) {
        this.plotNo = value;
    }

    /**
     * Gets the value of the province property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getProvince() {
        return province;
    }

    /**
     * Sets the value of the province property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setProvince(String value) {
        this.province = value;
    }

    /**
     * Gets the value of the residenceType property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getResidenceType() {
        return residenceType;
    }

    /**
     * Sets the value of the residenceType property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setResidenceType(String value) {
        this.residenceType = value;
    }

    /**
     * Gets the value of the sector property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSector() {
        return sector;
    }

    /**
     * Sets the value of the sector property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSector(String value) {
        this.sector = value;
    }

    /**
     * Gets the value of the town property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTown() {
        return town;
    }

    /**
     * Sets the value of the town property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTown(String value) {
        this.town = value;
    }

    /**
     * Gets the value of the village property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVillage() {
        return village;
    }

    /**
     * Sets the value of the village property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setVillage(String value) {
        this.village = value;
    }

}
