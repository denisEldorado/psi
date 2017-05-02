package org.muhia.app.psi.integ.wsdl.crba.transunion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for product103 complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="product103">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="alsoKnownAsList" type="{http://ws.crbws.transunion.ke.co/}alsoKnownAsConsumer" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="header" type="{http://ws.crbws.transunion.ke.co/}header" minOccurs="0"/>
 *         &lt;element name="personalProfile" type="{http://ws.crbws.transunion.ke.co/}personalProfile" minOccurs="0"/>
 *         &lt;element name="phoneList" type="{http://ws.crbws.transunion.ke.co/}phone" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="physicalAddressList" type="{http://ws.crbws.transunion.ke.co/}physicalAddress" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="postalAddressList" type="{http://ws.crbws.transunion.ke.co/}postalAddress" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="responseCode" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "product103", propOrder = {"alsoKnownAsList", "header", "personalProfile", "phoneList", "physicalAddressList", "postalAddressList", "responseCode"})
public class Product103 {

    @XmlElement(nillable = true)
    protected List<AlsoKnownAsConsumer> alsoKnownAsList;
    protected Header header;
    protected PersonalProfile personalProfile;
    @XmlElement(nillable = true)
    protected List<Phone> phoneList;
    @XmlElement(nillable = true)
    protected List<PhysicalAddress> physicalAddressList;
    @XmlElement(nillable = true)
    protected List<PostalAddress> postalAddressList;
    protected Integer responseCode;

    /**
     * Gets the value of the alsoKnownAsList property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the alsoKnownAsList property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAlsoKnownAsList().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AlsoKnownAsConsumer }
     */
    public List<AlsoKnownAsConsumer> getAlsoKnownAsList() {
        if (alsoKnownAsList == null) {
            alsoKnownAsList = new ArrayList<AlsoKnownAsConsumer>();
        }
        return this.alsoKnownAsList;
    }

    /**
     * Gets the value of the header property.
     *
     * @return possible object is
     * {@link Header }
     */
    public Header getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     *
     * @param value allowed object is
     *              {@link Header }
     */
    public void setHeader(Header value) {
        this.header = value;
    }

    /**
     * Gets the value of the personalProfile property.
     *
     * @return possible object is
     * {@link PersonalProfile }
     */
    public PersonalProfile getPersonalProfile() {
        return personalProfile;
    }

    /**
     * Sets the value of the personalProfile property.
     *
     * @param value allowed object is
     *              {@link PersonalProfile }
     */
    public void setPersonalProfile(PersonalProfile value) {
        this.personalProfile = value;
    }

    /**
     * Gets the value of the phoneList property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the phoneList property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPhoneList().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Phone }
     */
    public List<Phone> getPhoneList() {
        if (phoneList == null) {
            phoneList = new ArrayList<Phone>();
        }
        return this.phoneList;
    }

    /**
     * Gets the value of the physicalAddressList property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the physicalAddressList property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPhysicalAddressList().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PhysicalAddress }
     */
    public List<PhysicalAddress> getPhysicalAddressList() {
        if (physicalAddressList == null) {
            physicalAddressList = new ArrayList<PhysicalAddress>();
        }
        return this.physicalAddressList;
    }

    /**
     * Gets the value of the postalAddressList property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the postalAddressList property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPostalAddressList().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PostalAddress }
     */
    public List<PostalAddress> getPostalAddressList() {
        if (postalAddressList == null) {
            postalAddressList = new ArrayList<PostalAddress>();
        }
        return this.postalAddressList;
    }

    /**
     * Gets the value of the responseCode property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getResponseCode() {
        return responseCode;
    }

    /**
     * Sets the value of the responseCode property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setResponseCode(Integer value) {
        this.responseCode = value;
    }

}
