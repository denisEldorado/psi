package org.muhia.app.psi.integ.wsdl.crba.transunion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for summary116 complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="summary116">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountTypeList" type="{http://ws.crbws.transunion.ke.co/}accountTypeList" minOccurs="0"/>
 *         &lt;element name="activeDisputedAccounts" type="{http://ws.crbws.transunion.ke.co/}countSector" minOccurs="0"/>
 *         &lt;element name="activeMaxPrincipalValueList" type="{http://ws.crbws.transunion.ke.co/}moneySector" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="activeTotalBalanceValueList" type="{http://ws.crbws.transunion.ke.co/}moneySector" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="activeTotalPastDueValueList" type="{http://ws.crbws.transunion.ke.co/}moneySector" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="closedAccounts" type="{http://ws.crbws.transunion.ke.co/}countSector" minOccurs="0"/>
 *         &lt;element name="collaterals" type="{http://ws.crbws.transunion.ke.co/}countSector" minOccurs="0"/>
 *         &lt;element name="enquiries31to60Days" type="{http://ws.crbws.transunion.ke.co/}countSector" minOccurs="0"/>
 *         &lt;element name="enquiries61to90Days" type="{http://ws.crbws.transunion.ke.co/}countSector" minOccurs="0"/>
 *         &lt;element name="enquiries91Days" type="{http://ws.crbws.transunion.ke.co/}countSector" minOccurs="0"/>
 *         &lt;element name="enquiriesLast30Days" type="{http://ws.crbws.transunion.ke.co/}countSector" minOccurs="0"/>
 *         &lt;element name="lastEnquiryDate" type="{http://ws.crbws.transunion.ke.co/}dateSector" minOccurs="0"/>
 *         &lt;element name="lastNPAListingDate" type="{http://ws.crbws.transunion.ke.co/}dateSector" minOccurs="0"/>
 *         &lt;element name="lastPerformingListingDate" type="{http://ws.crbws.transunion.ke.co/}dateSector" minOccurs="0"/>
 *         &lt;element name="nonPerformingClosedAccounts" type="{http://ws.crbws.transunion.ke.co/}countSector" minOccurs="0"/>
 *         &lt;element name="nonPerformingOpenAccounts" type="{http://ws.crbws.transunion.ke.co/}countSector" minOccurs="0"/>
 *         &lt;element name="openAccounts" type="{http://ws.crbws.transunion.ke.co/}countSector" minOccurs="0"/>
 *         &lt;element name="performingClosedAccounts" type="{http://ws.crbws.transunion.ke.co/}countSector" minOccurs="0"/>
 *         &lt;element name="performingClosedWDHAccounts" type="{http://ws.crbws.transunion.ke.co/}countSector" minOccurs="0"/>
 *         &lt;element name="performingOpenAccounts" type="{http://ws.crbws.transunion.ke.co/}countSector" minOccurs="0"/>
 *         &lt;element name="performingOpenWDHAccounts" type="{http://ws.crbws.transunion.ke.co/}countSector" minOccurs="0"/>
 *         &lt;element name="totalEnquiries" type="{http://ws.crbws.transunion.ke.co/}countSector" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "summary116", propOrder = {"accountTypeList", "activeDisputedAccounts", "activeMaxPrincipalValueList", "activeTotalBalanceValueList", "activeTotalPastDueValueList", "closedAccounts", "collaterals", "enquiries31To60Days", "enquiries61To90Days", "enquiries91Days", "enquiriesLast30Days", "lastEnquiryDate", "lastNPAListingDate", "lastPerformingListingDate", "nonPerformingClosedAccounts", "nonPerformingOpenAccounts", "openAccounts", "performingClosedAccounts", "performingClosedWDHAccounts", "performingOpenAccounts", "performingOpenWDHAccounts", "totalEnquiries"})
public class Summary116 {

    protected AccountTypeList accountTypeList;
    protected CountSector activeDisputedAccounts;
    @XmlElement(nillable = true)
    protected List<MoneySector> activeMaxPrincipalValueList;
    @XmlElement(nillable = true)
    protected List<MoneySector> activeTotalBalanceValueList;
    @XmlElement(nillable = true)
    protected List<MoneySector> activeTotalPastDueValueList;
    protected CountSector closedAccounts;
    protected CountSector collaterals;
    @XmlElement(name = "enquiries31to60Days")
    protected CountSector enquiries31To60Days;
    @XmlElement(name = "enquiries61to90Days")
    protected CountSector enquiries61To90Days;
    protected CountSector enquiries91Days;
    protected CountSector enquiriesLast30Days;
    protected DateSector lastEnquiryDate;
    protected DateSector lastNPAListingDate;
    protected DateSector lastPerformingListingDate;
    protected CountSector nonPerformingClosedAccounts;
    protected CountSector nonPerformingOpenAccounts;
    protected CountSector openAccounts;
    protected CountSector performingClosedAccounts;
    protected CountSector performingClosedWDHAccounts;
    protected CountSector performingOpenAccounts;
    protected CountSector performingOpenWDHAccounts;
    protected CountSector totalEnquiries;

    /**
     * Gets the value of the accountTypeList property.
     *
     * @return possible object is
     * {@link AccountTypeList }
     */
    public AccountTypeList getAccountTypeList() {
        return accountTypeList;
    }

    /**
     * Sets the value of the accountTypeList property.
     *
     * @param value allowed object is
     *              {@link AccountTypeList }
     */
    public void setAccountTypeList(AccountTypeList value) {
        this.accountTypeList = value;
    }

    /**
     * Gets the value of the activeDisputedAccounts property.
     *
     * @return possible object is
     * {@link CountSector }
     */
    public CountSector getActiveDisputedAccounts() {
        return activeDisputedAccounts;
    }

    /**
     * Sets the value of the activeDisputedAccounts property.
     *
     * @param value allowed object is
     *              {@link CountSector }
     */
    public void setActiveDisputedAccounts(CountSector value) {
        this.activeDisputedAccounts = value;
    }

    /**
     * Gets the value of the activeMaxPrincipalValueList property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the activeMaxPrincipalValueList property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActiveMaxPrincipalValueList().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MoneySector }
     */
    public List<MoneySector> getActiveMaxPrincipalValueList() {
        if (activeMaxPrincipalValueList == null) {
            activeMaxPrincipalValueList = new ArrayList<MoneySector>();
        }
        return this.activeMaxPrincipalValueList;
    }

    /**
     * Gets the value of the activeTotalBalanceValueList property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the activeTotalBalanceValueList property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActiveTotalBalanceValueList().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MoneySector }
     */
    public List<MoneySector> getActiveTotalBalanceValueList() {
        if (activeTotalBalanceValueList == null) {
            activeTotalBalanceValueList = new ArrayList<MoneySector>();
        }
        return this.activeTotalBalanceValueList;
    }

    /**
     * Gets the value of the activeTotalPastDueValueList property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the activeTotalPastDueValueList property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActiveTotalPastDueValueList().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MoneySector }
     */
    public List<MoneySector> getActiveTotalPastDueValueList() {
        if (activeTotalPastDueValueList == null) {
            activeTotalPastDueValueList = new ArrayList<MoneySector>();
        }
        return this.activeTotalPastDueValueList;
    }

    /**
     * Gets the value of the closedAccounts property.
     *
     * @return possible object is
     * {@link CountSector }
     */
    public CountSector getClosedAccounts() {
        return closedAccounts;
    }

    /**
     * Sets the value of the closedAccounts property.
     *
     * @param value allowed object is
     *              {@link CountSector }
     */
    public void setClosedAccounts(CountSector value) {
        this.closedAccounts = value;
    }

    /**
     * Gets the value of the collaterals property.
     *
     * @return possible object is
     * {@link CountSector }
     */
    public CountSector getCollaterals() {
        return collaterals;
    }

    /**
     * Sets the value of the collaterals property.
     *
     * @param value allowed object is
     *              {@link CountSector }
     */
    public void setCollaterals(CountSector value) {
        this.collaterals = value;
    }

    /**
     * Gets the value of the enquiries31To60Days property.
     *
     * @return possible object is
     * {@link CountSector }
     */
    public CountSector getEnquiries31To60Days() {
        return enquiries31To60Days;
    }

    /**
     * Sets the value of the enquiries31To60Days property.
     *
     * @param value allowed object is
     *              {@link CountSector }
     */
    public void setEnquiries31To60Days(CountSector value) {
        this.enquiries31To60Days = value;
    }

    /**
     * Gets the value of the enquiries61To90Days property.
     *
     * @return possible object is
     * {@link CountSector }
     */
    public CountSector getEnquiries61To90Days() {
        return enquiries61To90Days;
    }

    /**
     * Sets the value of the enquiries61To90Days property.
     *
     * @param value allowed object is
     *              {@link CountSector }
     */
    public void setEnquiries61To90Days(CountSector value) {
        this.enquiries61To90Days = value;
    }

    /**
     * Gets the value of the enquiries91Days property.
     *
     * @return possible object is
     * {@link CountSector }
     */
    public CountSector getEnquiries91Days() {
        return enquiries91Days;
    }

    /**
     * Sets the value of the enquiries91Days property.
     *
     * @param value allowed object is
     *              {@link CountSector }
     */
    public void setEnquiries91Days(CountSector value) {
        this.enquiries91Days = value;
    }

    /**
     * Gets the value of the enquiriesLast30Days property.
     *
     * @return possible object is
     * {@link CountSector }
     */
    public CountSector getEnquiriesLast30Days() {
        return enquiriesLast30Days;
    }

    /**
     * Sets the value of the enquiriesLast30Days property.
     *
     * @param value allowed object is
     *              {@link CountSector }
     */
    public void setEnquiriesLast30Days(CountSector value) {
        this.enquiriesLast30Days = value;
    }

    /**
     * Gets the value of the lastEnquiryDate property.
     *
     * @return possible object is
     * {@link DateSector }
     */
    public DateSector getLastEnquiryDate() {
        return lastEnquiryDate;
    }

    /**
     * Sets the value of the lastEnquiryDate property.
     *
     * @param value allowed object is
     *              {@link DateSector }
     */
    public void setLastEnquiryDate(DateSector value) {
        this.lastEnquiryDate = value;
    }

    /**
     * Gets the value of the lastNPAListingDate property.
     *
     * @return possible object is
     * {@link DateSector }
     */
    public DateSector getLastNPAListingDate() {
        return lastNPAListingDate;
    }

    /**
     * Sets the value of the lastNPAListingDate property.
     *
     * @param value allowed object is
     *              {@link DateSector }
     */
    public void setLastNPAListingDate(DateSector value) {
        this.lastNPAListingDate = value;
    }

    /**
     * Gets the value of the lastPerformingListingDate property.
     *
     * @return possible object is
     * {@link DateSector }
     */
    public DateSector getLastPerformingListingDate() {
        return lastPerformingListingDate;
    }

    /**
     * Sets the value of the lastPerformingListingDate property.
     *
     * @param value allowed object is
     *              {@link DateSector }
     */
    public void setLastPerformingListingDate(DateSector value) {
        this.lastPerformingListingDate = value;
    }

    /**
     * Gets the value of the nonPerformingClosedAccounts property.
     *
     * @return possible object is
     * {@link CountSector }
     */
    public CountSector getNonPerformingClosedAccounts() {
        return nonPerformingClosedAccounts;
    }

    /**
     * Sets the value of the nonPerformingClosedAccounts property.
     *
     * @param value allowed object is
     *              {@link CountSector }
     */
    public void setNonPerformingClosedAccounts(CountSector value) {
        this.nonPerformingClosedAccounts = value;
    }

    /**
     * Gets the value of the nonPerformingOpenAccounts property.
     *
     * @return possible object is
     * {@link CountSector }
     */
    public CountSector getNonPerformingOpenAccounts() {
        return nonPerformingOpenAccounts;
    }

    /**
     * Sets the value of the nonPerformingOpenAccounts property.
     *
     * @param value allowed object is
     *              {@link CountSector }
     */
    public void setNonPerformingOpenAccounts(CountSector value) {
        this.nonPerformingOpenAccounts = value;
    }

    /**
     * Gets the value of the openAccounts property.
     *
     * @return possible object is
     * {@link CountSector }
     */
    public CountSector getOpenAccounts() {
        return openAccounts;
    }

    /**
     * Sets the value of the openAccounts property.
     *
     * @param value allowed object is
     *              {@link CountSector }
     */
    public void setOpenAccounts(CountSector value) {
        this.openAccounts = value;
    }

    /**
     * Gets the value of the performingClosedAccounts property.
     *
     * @return possible object is
     * {@link CountSector }
     */
    public CountSector getPerformingClosedAccounts() {
        return performingClosedAccounts;
    }

    /**
     * Sets the value of the performingClosedAccounts property.
     *
     * @param value allowed object is
     *              {@link CountSector }
     */
    public void setPerformingClosedAccounts(CountSector value) {
        this.performingClosedAccounts = value;
    }

    /**
     * Gets the value of the performingClosedWDHAccounts property.
     *
     * @return possible object is
     * {@link CountSector }
     */
    public CountSector getPerformingClosedWDHAccounts() {
        return performingClosedWDHAccounts;
    }

    /**
     * Sets the value of the performingClosedWDHAccounts property.
     *
     * @param value allowed object is
     *              {@link CountSector }
     */
    public void setPerformingClosedWDHAccounts(CountSector value) {
        this.performingClosedWDHAccounts = value;
    }

    /**
     * Gets the value of the performingOpenAccounts property.
     *
     * @return possible object is
     * {@link CountSector }
     */
    public CountSector getPerformingOpenAccounts() {
        return performingOpenAccounts;
    }

    /**
     * Sets the value of the performingOpenAccounts property.
     *
     * @param value allowed object is
     *              {@link CountSector }
     */
    public void setPerformingOpenAccounts(CountSector value) {
        this.performingOpenAccounts = value;
    }

    /**
     * Gets the value of the performingOpenWDHAccounts property.
     *
     * @return possible object is
     * {@link CountSector }
     */
    public CountSector getPerformingOpenWDHAccounts() {
        return performingOpenWDHAccounts;
    }

    /**
     * Sets the value of the performingOpenWDHAccounts property.
     *
     * @param value allowed object is
     *              {@link CountSector }
     */
    public void setPerformingOpenWDHAccounts(CountSector value) {
        this.performingOpenWDHAccounts = value;
    }

    /**
     * Gets the value of the totalEnquiries property.
     *
     * @return possible object is
     * {@link CountSector }
     */
    public CountSector getTotalEnquiries() {
        return totalEnquiries;
    }

    /**
     * Sets the value of the totalEnquiries property.
     *
     * @param value allowed object is
     *              {@link CountSector }
     */
    public void setTotalEnquiries(CountSector value) {
        this.totalEnquiries = value;
    }

}
