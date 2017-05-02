package org.muhia.app.psi.integ.wsdl.crba.transunion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for recentEnquiry complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="recentEnquiry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="enquiryDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="enquiryReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tradeSector" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "recentEnquiry", propOrder = {"enquiryDate", "enquiryReason", "tradeSector"})
public class RecentEnquiry {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar enquiryDate;
    protected String enquiryReason;
    protected String tradeSector;

    /**
     * Gets the value of the enquiryDate property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getEnquiryDate() {
        return enquiryDate;
    }

    /**
     * Sets the value of the enquiryDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setEnquiryDate(XMLGregorianCalendar value) {
        this.enquiryDate = value;
    }

    /**
     * Gets the value of the enquiryReason property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getEnquiryReason() {
        return enquiryReason;
    }

    /**
     * Sets the value of the enquiryReason property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEnquiryReason(String value) {
        this.enquiryReason = value;
    }

    /**
     * Gets the value of the tradeSector property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTradeSector() {
        return tradeSector;
    }

    /**
     * Sets the value of the tradeSector property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTradeSector(String value) {
        this.tradeSector = value;
    }

}
