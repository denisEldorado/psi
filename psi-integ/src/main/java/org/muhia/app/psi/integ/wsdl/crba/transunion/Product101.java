package org.muhia.app.psi.integ.wsdl.crba.transunion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for product101 complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="product101">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountList" type="{http://ws.crbws.transunion.ke.co/}account" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="alsoKnownAsList" type="{http://ws.crbws.transunion.ke.co/}alsoKnownAsConsumer" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bouncedChequeList" type="{http://ws.crbws.transunion.ke.co/}bouncedCheque" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="disputeStatementList" type="{http://ws.crbws.transunion.ke.co/}disputeStatement" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="header" type="{http://ws.crbws.transunion.ke.co/}header" minOccurs="0"/>
 *         &lt;element name="personalProfile" type="{http://ws.crbws.transunion.ke.co/}personalProfile" minOccurs="0"/>
 *         &lt;element name="recentEnquiryList" type="{http://ws.crbws.transunion.ke.co/}recentEnquiry" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="responseCode" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="summary" type="{http://ws.crbws.transunion.ke.co/}summary101" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "product101", propOrder = {"accountList", "alsoKnownAsList", "bouncedChequeList", "disputeStatementList", "header", "personalProfile", "recentEnquiryList", "responseCode", "summary"})
public class Product101 {

    @XmlElement(nillable = true)
    protected List<Account> accountList;
    @XmlElement(nillable = true)
    protected List<AlsoKnownAsConsumer> alsoKnownAsList;
    @XmlElement(nillable = true)
    protected List<BouncedCheque> bouncedChequeList;
    @XmlElement(nillable = true)
    protected List<DisputeStatement> disputeStatementList;
    protected Header header;
    protected PersonalProfile personalProfile;
    @XmlElement(nillable = true)
    protected List<RecentEnquiry> recentEnquiryList;
    protected Integer responseCode;
    protected Summary101 summary;

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
     * {@link Account }
     */
    public List<Account> getAccountList() {
        if (accountList == null) {
            accountList = new ArrayList<Account>();
        }
        return this.accountList;
    }

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
     * Gets the value of the bouncedChequeList property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bouncedChequeList property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBouncedChequeList().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BouncedCheque }
     */
    public List<BouncedCheque> getBouncedChequeList() {
        if (bouncedChequeList == null) {
            bouncedChequeList = new ArrayList<BouncedCheque>();
        }
        return this.bouncedChequeList;
    }

    /**
     * Gets the value of the disputeStatementList property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the disputeStatementList property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDisputeStatementList().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DisputeStatement }
     */
    public List<DisputeStatement> getDisputeStatementList() {
        if (disputeStatementList == null) {
            disputeStatementList = new ArrayList<DisputeStatement>();
        }
        return this.disputeStatementList;
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
     * Gets the value of the recentEnquiryList property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recentEnquiryList property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecentEnquiryList().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RecentEnquiry }
     */
    public List<RecentEnquiry> getRecentEnquiryList() {
        if (recentEnquiryList == null) {
            recentEnquiryList = new ArrayList<RecentEnquiry>();
        }
        return this.recentEnquiryList;
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
     * {@link Summary101 }
     */
    public Summary101 getSummary() {
        return summary;
    }

    /**
     * Sets the value of the summary property.
     *
     * @param value allowed object is
     *              {@link Summary101 }
     */
    public void setSummary(Summary101 value) {
        this.summary = value;
    }

}
