package org.muhia.app.psi.integ.wsdl.crba.transunion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for product118 complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="product118">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountList" type="{http://ws.crbws.transunion.ke.co/}account" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="alsoKnownAsList" type="{http://ws.crbws.transunion.ke.co/}alsoKnownAsConsumer" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bouncedChequeList" type="{http://ws.crbws.transunion.ke.co/}bouncedCheque" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="collateralList" type="{http://ws.crbws.transunion.ke.co/}collateral" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="creditApplicationList" type="{http://ws.crbws.transunion.ke.co/}creditApplication" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="directorshipList" type="{http://ws.crbws.transunion.ke.co/}directorShip" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="disputeStatementList" type="{http://ws.crbws.transunion.ke.co/}disputeStatement" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="emailList" type="{http://ws.crbws.transunion.ke.co/}email" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="employmentList" type="{http://ws.crbws.transunion.ke.co/}employment" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="fraudList" type="{http://ws.crbws.transunion.ke.co/}fraud" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="header" type="{http://ws.crbws.transunion.ke.co/}header" minOccurs="0"/>
 *         &lt;element name="personalProfile" type="{http://ws.crbws.transunion.ke.co/}personalProfile" minOccurs="0"/>
 *         &lt;element name="phoneList" type="{http://ws.crbws.transunion.ke.co/}phone" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="physicalAddressList" type="{http://ws.crbws.transunion.ke.co/}physicalAddress" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="postalAddressList" type="{http://ws.crbws.transunion.ke.co/}postalAddress" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="recentEnquiryList" type="{http://ws.crbws.transunion.ke.co/}recentEnquiry" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="responseCode" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="scoreOutput" type="{http://ws.crbws.transunion.ke.co/}scoreOutput118" minOccurs="0"/>
 *         &lt;element name="shareholdingList" type="{http://ws.crbws.transunion.ke.co/}shareholding" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="summary" type="{http://ws.crbws.transunion.ke.co/}summary118" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "product118", propOrder = {"accountList", "alsoKnownAsList", "bouncedChequeList", "collateralList", "creditApplicationList", "directorshipList", "disputeStatementList", "emailList", "employmentList", "fraudList", "header", "personalProfile", "phoneList", "physicalAddressList", "postalAddressList", "recentEnquiryList", "responseCode", "scoreOutput", "shareholdingList", "summary"})
public class Product118 {

    @XmlElement(nillable = true)
    protected List<Account> accountList;
    @XmlElement(nillable = true)
    protected List<AlsoKnownAsConsumer> alsoKnownAsList;
    @XmlElement(nillable = true)
    protected List<BouncedCheque> bouncedChequeList;
    @XmlElement(nillable = true)
    protected List<Collateral> collateralList;
    @XmlElement(nillable = true)
    protected List<CreditApplication> creditApplicationList;
    @XmlElement(nillable = true)
    protected List<DirectorShip> directorshipList;
    @XmlElement(nillable = true)
    protected List<DisputeStatement> disputeStatementList;
    @XmlElement(nillable = true)
    protected List<Email> emailList;
    @XmlElement(nillable = true)
    protected List<Employment> employmentList;
    @XmlElement(nillable = true)
    protected List<Fraud> fraudList;
    protected Header header;
    protected PersonalProfile personalProfile;
    @XmlElement(nillable = true)
    protected List<Phone> phoneList;
    @XmlElement(nillable = true)
    protected List<PhysicalAddress> physicalAddressList;
    @XmlElement(nillable = true)
    protected List<PostalAddress> postalAddressList;
    @XmlElement(nillable = true)
    protected List<RecentEnquiry> recentEnquiryList;
    protected Integer responseCode;
    protected ScoreOutput118 scoreOutput;
    @XmlElement(nillable = true)
    protected List<Shareholding> shareholdingList;
    protected Summary118 summary;

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
     * Gets the value of the collateralList property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the collateralList property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCollateralList().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Collateral }
     */
    public List<Collateral> getCollateralList() {
        if (collateralList == null) {
            collateralList = new ArrayList<Collateral>();
        }
        return this.collateralList;
    }

    /**
     * Gets the value of the creditApplicationList property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the creditApplicationList property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCreditApplicationList().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CreditApplication }
     */
    public List<CreditApplication> getCreditApplicationList() {
        if (creditApplicationList == null) {
            creditApplicationList = new ArrayList<CreditApplication>();
        }
        return this.creditApplicationList;
    }

    /**
     * Gets the value of the directorshipList property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the directorshipList property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDirectorshipList().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DirectorShip }
     */
    public List<DirectorShip> getDirectorshipList() {
        if (directorshipList == null) {
            directorshipList = new ArrayList<DirectorShip>();
        }
        return this.directorshipList;
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
     * Gets the value of the emailList property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the emailList property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEmailList().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Email }
     */
    public List<Email> getEmailList() {
        if (emailList == null) {
            emailList = new ArrayList<Email>();
        }
        return this.emailList;
    }

    /**
     * Gets the value of the employmentList property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the employmentList property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEmploymentList().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Employment }
     */
    public List<Employment> getEmploymentList() {
        if (employmentList == null) {
            employmentList = new ArrayList<Employment>();
        }
        return this.employmentList;
    }

    /**
     * Gets the value of the fraudList property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fraudList property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFraudList().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Fraud }
     */
    public List<Fraud> getFraudList() {
        if (fraudList == null) {
            fraudList = new ArrayList<Fraud>();
        }
        return this.fraudList;
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
     * Gets the value of the scoreOutput property.
     *
     * @return possible object is
     * {@link ScoreOutput118 }
     */
    public ScoreOutput118 getScoreOutput() {
        return scoreOutput;
    }

    /**
     * Sets the value of the scoreOutput property.
     *
     * @param value allowed object is
     *              {@link ScoreOutput118 }
     */
    public void setScoreOutput(ScoreOutput118 value) {
        this.scoreOutput = value;
    }

    /**
     * Gets the value of the shareholdingList property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shareholdingList property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShareholdingList().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Shareholding }
     */
    public List<Shareholding> getShareholdingList() {
        if (shareholdingList == null) {
            shareholdingList = new ArrayList<Shareholding>();
        }
        return this.shareholdingList;
    }

    /**
     * Gets the value of the summary property.
     *
     * @return possible object is
     * {@link Summary118 }
     */
    public Summary118 getSummary() {
        return summary;
    }

    /**
     * Sets the value of the summary property.
     *
     * @param value allowed object is
     *              {@link Summary118 }
     */
    public void setSummary(Summary118 value) {
        this.summary = value;
    }

}
