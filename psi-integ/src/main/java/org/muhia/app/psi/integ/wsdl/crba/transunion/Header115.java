package org.muhia.app.psi.integ.wsdl.crba.transunion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for header115 complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="header115">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="crbName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productDisplayName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reportDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="reportType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="requestNo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="requester" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "header115", propOrder = {"crbName", "productDisplayName", "reportDate", "reportType", "requestNo", "requester"})
public class Header115 {

    protected String crbName;
    protected String productDisplayName;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar reportDate;
    protected String reportType;
    protected Integer requestNo;
    protected String requester;

    /**
     * Gets the value of the crbName property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCrbName() {
        return crbName;
    }

    /**
     * Sets the value of the crbName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCrbName(String value) {
        this.crbName = value;
    }

    /**
     * Gets the value of the productDisplayName property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getProductDisplayName() {
        return productDisplayName;
    }

    /**
     * Sets the value of the productDisplayName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setProductDisplayName(String value) {
        this.productDisplayName = value;
    }

    /**
     * Gets the value of the reportDate property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getReportDate() {
        return reportDate;
    }

    /**
     * Sets the value of the reportDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setReportDate(XMLGregorianCalendar value) {
        this.reportDate = value;
    }

    /**
     * Gets the value of the reportType property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getReportType() {
        return reportType;
    }

    /**
     * Sets the value of the reportType property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setReportType(String value) {
        this.reportType = value;
    }

    /**
     * Gets the value of the requestNo property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getRequestNo() {
        return requestNo;
    }

    /**
     * Sets the value of the requestNo property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setRequestNo(Integer value) {
        this.requestNo = value;
    }

    /**
     * Gets the value of the requester property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRequester() {
        return requester;
    }

    /**
     * Sets the value of the requester property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRequester(String value) {
        this.requester = value;
    }

}
