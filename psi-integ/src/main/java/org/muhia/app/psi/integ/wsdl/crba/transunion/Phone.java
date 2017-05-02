package org.muhia.app.psi.integ.wsdl.crba.transunion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for phone complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="phone">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="createDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="phoneExchange" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="phoneNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="phoneType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "phone", propOrder = {"createDate", "phoneExchange", "phoneNo", "phoneType"})
public class Phone {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createDate;
    protected String phoneExchange;
    protected String phoneNo;
    protected String phoneType;

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
     * Gets the value of the phoneExchange property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPhoneExchange() {
        return phoneExchange;
    }

    /**
     * Sets the value of the phoneExchange property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPhoneExchange(String value) {
        this.phoneExchange = value;
    }

    /**
     * Gets the value of the phoneNo property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * Sets the value of the phoneNo property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPhoneNo(String value) {
        this.phoneNo = value;
    }

    /**
     * Gets the value of the phoneType property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPhoneType() {
        return phoneType;
    }

    /**
     * Sets the value of the phoneType property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPhoneType(String value) {
        this.phoneType = value;
    }

}
