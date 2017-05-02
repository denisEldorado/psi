package org.muhia.app.psi.integ.wsdl.crba.transunion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for product159 complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="product159">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountList" type="{http://ws.crbws.transunion.ke.co/}account159" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="corporateProfile" type="{http://ws.crbws.transunion.ke.co/}corporateProfile159" minOccurs="0"/>
 *         &lt;element name="header" type="{http://ws.crbws.transunion.ke.co/}header" minOccurs="0"/>
 *         &lt;element name="responseCode" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="summary" type="{http://ws.crbws.transunion.ke.co/}summary159" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "product159", propOrder = {"accountList", "corporateProfile", "header", "responseCode", "summary"})
public class Product159 {

    @XmlElement(nillable = true)
    protected List<Account159> accountList;
    protected CorporateProfile159 corporateProfile;
    protected Header header;
    protected Integer responseCode;
    protected Summary159 summary;

    /**
     * Gets the value of the accountList property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accountList property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccountList().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Account159 }
     */
    public List<Account159> getAccountList() {
        if (accountList == null) {
            accountList = new ArrayList<Account159>();
        }
        return this.accountList;
    }

    /**
     * Gets the value of the corporateProfile property.
     *
     * @return possible object is
     * {@link CorporateProfile159 }
     */
    public CorporateProfile159 getCorporateProfile() {
        return corporateProfile;
    }

    /**
     * Sets the value of the corporateProfile property.
     *
     * @param value allowed object is
     *              {@link CorporateProfile159 }
     */
    public void setCorporateProfile(CorporateProfile159 value) {
        this.corporateProfile = value;
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

    /**
     * Gets the value of the summary property.
     *
     * @return possible object is
     * {@link Summary159 }
     */
    public Summary159 getSummary() {
        return summary;
    }

    /**
     * Sets the value of the summary property.
     *
     * @param value allowed object is
     *              {@link Summary159 }
     */
    public void setSummary(Summary159 value) {
        this.summary = value;
    }

}
