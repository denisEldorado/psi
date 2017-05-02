package org.muhia.app.psi.integ.wsdl.crba.transunion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for summary153 complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="summary153">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bouncedCheques" type="{http://ws.crbws.transunion.ke.co/}countSector" minOccurs="0"/>
 *         &lt;element name="closedAccounts" type="{http://ws.crbws.transunion.ke.co/}countSector" minOccurs="0"/>
 *         &lt;element name="creditApplications" type="{http://ws.crbws.transunion.ke.co/}countSector" minOccurs="0"/>
 *         &lt;element name="creditHistory" type="{http://ws.crbws.transunion.ke.co/}countSector" minOccurs="0"/>
 *         &lt;element name="enquiries31to60Days" type="{http://ws.crbws.transunion.ke.co/}countSector" minOccurs="0"/>
 *         &lt;element name="enquiries61to90Days" type="{http://ws.crbws.transunion.ke.co/}countSector" minOccurs="0"/>
 *         &lt;element name="enquiries91Days" type="{http://ws.crbws.transunion.ke.co/}countSector" minOccurs="0"/>
 *         &lt;element name="enquiriesLast30Days" type="{http://ws.crbws.transunion.ke.co/}countSector" minOccurs="0"/>
 *         &lt;element name="fraudulentCases" type="{http://ws.crbws.transunion.ke.co/}countSector" minOccurs="0"/>
 *         &lt;element name="lastBouncedChequeDate" type="{http://ws.crbws.transunion.ke.co/}dateSector" minOccurs="0"/>
 *         &lt;element name="lastCreditApplicationDate" type="{http://ws.crbws.transunion.ke.co/}dateSector" minOccurs="0"/>
 *         &lt;element name="lastFraudDate" type="{http://ws.crbws.transunion.ke.co/}dateSector" minOccurs="0"/>
 *         &lt;element name="lastLegalSuitDate" type="{http://ws.crbws.transunion.ke.co/}dateSector" minOccurs="0"/>
 *         &lt;element name="lastNPAListingDate" type="{http://ws.crbws.transunion.ke.co/}dateSector" minOccurs="0"/>
 *         &lt;element name="lastPAListingDate" type="{http://ws.crbws.transunion.ke.co/}dateSector" minOccurs="0"/>
 *         &lt;element name="legalSuits" type="{http://ws.crbws.transunion.ke.co/}countSector" minOccurs="0"/>
 *         &lt;element name="negativeScore" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="npaAccounts" type="{http://ws.crbws.transunion.ke.co/}countSector" minOccurs="0"/>
 *         &lt;element name="npaTotalValueList" type="{http://ws.crbws.transunion.ke.co/}moneySector" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="openAccounts" type="{http://ws.crbws.transunion.ke.co/}countSector" minOccurs="0"/>
 *         &lt;element name="paAccounts" type="{http://ws.crbws.transunion.ke.co/}countSector" minOccurs="0"/>
 *         &lt;element name="paClosedAccounts" type="{http://ws.crbws.transunion.ke.co/}countSector" minOccurs="0"/>
 *         &lt;element name="paOpenAccounts" type="{http://ws.crbws.transunion.ke.co/}countSector" minOccurs="0"/>
 *         &lt;element name="paTotalValueList" type="{http://ws.crbws.transunion.ke.co/}moneySector" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="positiveScore" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "summary153", propOrder = {"bouncedCheques", "closedAccounts", "creditApplications", "creditHistory", "enquiries31To60Days", "enquiries61To90Days", "enquiries91Days", "enquiriesLast30Days", "fraudulentCases", "lastBouncedChequeDate", "lastCreditApplicationDate", "lastFraudDate", "lastLegalSuitDate", "lastNPAListingDate", "lastPAListingDate", "legalSuits", "negativeScore", "npaAccounts", "npaTotalValueList", "openAccounts", "paAccounts", "paClosedAccounts", "paOpenAccounts", "paTotalValueList", "positiveScore"})
public class Summary153 {

    protected CountSector bouncedCheques;
    protected CountSector closedAccounts;
    protected CountSector creditApplications;
    protected CountSector creditHistory;
    @XmlElement(name = "enquiries31to60Days")
    protected CountSector enquiries31To60Days;
    @XmlElement(name = "enquiries61to90Days")
    protected CountSector enquiries61To90Days;
    protected CountSector enquiries91Days;
    protected CountSector enquiriesLast30Days;
    protected CountSector fraudulentCases;
    protected DateSector lastBouncedChequeDate;
    protected DateSector lastCreditApplicationDate;
    protected DateSector lastFraudDate;
    protected DateSector lastLegalSuitDate;
    protected DateSector lastNPAListingDate;
    protected DateSector lastPAListingDate;
    protected CountSector legalSuits;
    protected Integer negativeScore;
    protected CountSector npaAccounts;
    @XmlElement(nillable = true)
    protected List<MoneySector> npaTotalValueList;
    protected CountSector openAccounts;
    protected CountSector paAccounts;
    protected CountSector paClosedAccounts;
    protected CountSector paOpenAccounts;
    @XmlElement(nillable = true)
    protected List<MoneySector> paTotalValueList;
    protected Integer positiveScore;

    /**
     * Gets the value of the bouncedCheques property.
     *
     * @return possible object is
     * {@link CountSector }
     */
    public CountSector getBouncedCheques() {
        return bouncedCheques;
    }

    /**
     * Sets the value of the bouncedCheques property.
     *
     * @param value allowed object is
     *              {@link CountSector }
     */
    public void setBouncedCheques(CountSector value) {
        this.bouncedCheques = value;
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
     * Gets the value of the creditApplications property.
     *
     * @return possible object is
     * {@link CountSector }
     */
    public CountSector getCreditApplications() {
        return creditApplications;
    }

    /**
     * Sets the value of the creditApplications property.
     *
     * @param value allowed object is
     *              {@link CountSector }
     */
    public void setCreditApplications(CountSector value) {
        this.creditApplications = value;
    }

    /**
     * Gets the value of the creditHistory property.
     *
     * @return possible object is
     * {@link CountSector }
     */
    public CountSector getCreditHistory() {
        return creditHistory;
    }

    /**
     * Sets the value of the creditHistory property.
     *
     * @param value allowed object is
     *              {@link CountSector }
     */
    public void setCreditHistory(CountSector value) {
        this.creditHistory = value;
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
     * Gets the value of the fraudulentCases property.
     *
     * @return possible object is
     * {@link CountSector }
     */
    public CountSector getFraudulentCases() {
        return fraudulentCases;
    }

    /**
     * Sets the value of the fraudulentCases property.
     *
     * @param value allowed object is
     *              {@link CountSector }
     */
    public void setFraudulentCases(CountSector value) {
        this.fraudulentCases = value;
    }

    /**
     * Gets the value of the lastBouncedChequeDate property.
     *
     * @return possible object is
     * {@link DateSector }
     */
    public DateSector getLastBouncedChequeDate() {
        return lastBouncedChequeDate;
    }

    /**
     * Sets the value of the lastBouncedChequeDate property.
     *
     * @param value allowed object is
     *              {@link DateSector }
     */
    public void setLastBouncedChequeDate(DateSector value) {
        this.lastBouncedChequeDate = value;
    }

    /**
     * Gets the value of the lastCreditApplicationDate property.
     *
     * @return possible object is
     * {@link DateSector }
     */
    public DateSector getLastCreditApplicationDate() {
        return lastCreditApplicationDate;
    }

    /**
     * Sets the value of the lastCreditApplicationDate property.
     *
     * @param value allowed object is
     *              {@link DateSector }
     */
    public void setLastCreditApplicationDate(DateSector value) {
        this.lastCreditApplicationDate = value;
    }

    /**
     * Gets the value of the lastFraudDate property.
     *
     * @return possible object is
     * {@link DateSector }
     */
    public DateSector getLastFraudDate() {
        return lastFraudDate;
    }

    /**
     * Sets the value of the lastFraudDate property.
     *
     * @param value allowed object is
     *              {@link DateSector }
     */
    public void setLastFraudDate(DateSector value) {
        this.lastFraudDate = value;
    }

    /**
     * Gets the value of the lastLegalSuitDate property.
     *
     * @return possible object is
     * {@link DateSector }
     */
    public DateSector getLastLegalSuitDate() {
        return lastLegalSuitDate;
    }

    /**
     * Sets the value of the lastLegalSuitDate property.
     *
     * @param value allowed object is
     *              {@link DateSector }
     */
    public void setLastLegalSuitDate(DateSector value) {
        this.lastLegalSuitDate = value;
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
     * Gets the value of the lastPAListingDate property.
     *
     * @return possible object is
     * {@link DateSector }
     */
    public DateSector getLastPAListingDate() {
        return lastPAListingDate;
    }

    /**
     * Sets the value of the lastPAListingDate property.
     *
     * @param value allowed object is
     *              {@link DateSector }
     */
    public void setLastPAListingDate(DateSector value) {
        this.lastPAListingDate = value;
    }

    /**
     * Gets the value of the legalSuits property.
     *
     * @return possible object is
     * {@link CountSector }
     */
    public CountSector getLegalSuits() {
        return legalSuits;
    }

    /**
     * Sets the value of the legalSuits property.
     *
     * @param value allowed object is
     *              {@link CountSector }
     */
    public void setLegalSuits(CountSector value) {
        this.legalSuits = value;
    }

    /**
     * Gets the value of the negativeScore property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getNegativeScore() {
        return negativeScore;
    }

    /**
     * Sets the value of the negativeScore property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setNegativeScore(Integer value) {
        this.negativeScore = value;
    }

    /**
     * Gets the value of the npaAccounts property.
     *
     * @return possible object is
     * {@link CountSector }
     */
    public CountSector getNpaAccounts() {
        return npaAccounts;
    }

    /**
     * Sets the value of the npaAccounts property.
     *
     * @param value allowed object is
     *              {@link CountSector }
     */
    public void setNpaAccounts(CountSector value) {
        this.npaAccounts = value;
    }

    /**
     * Gets the value of the npaTotalValueList property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the npaTotalValueList property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNpaTotalValueList().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MoneySector }
     */
    public List<MoneySector> getNpaTotalValueList() {
        if (npaTotalValueList == null) {
            npaTotalValueList = new ArrayList<MoneySector>();
        }
        return this.npaTotalValueList;
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
     * Gets the value of the paAccounts property.
     *
     * @return possible object is
     * {@link CountSector }
     */
    public CountSector getPaAccounts() {
        return paAccounts;
    }

    /**
     * Sets the value of the paAccounts property.
     *
     * @param value allowed object is
     *              {@link CountSector }
     */
    public void setPaAccounts(CountSector value) {
        this.paAccounts = value;
    }

    /**
     * Gets the value of the paClosedAccounts property.
     *
     * @return possible object is
     * {@link CountSector }
     */
    public CountSector getPaClosedAccounts() {
        return paClosedAccounts;
    }

    /**
     * Sets the value of the paClosedAccounts property.
     *
     * @param value allowed object is
     *              {@link CountSector }
     */
    public void setPaClosedAccounts(CountSector value) {
        this.paClosedAccounts = value;
    }

    /**
     * Gets the value of the paOpenAccounts property.
     *
     * @return possible object is
     * {@link CountSector }
     */
    public CountSector getPaOpenAccounts() {
        return paOpenAccounts;
    }

    /**
     * Sets the value of the paOpenAccounts property.
     *
     * @param value allowed object is
     *              {@link CountSector }
     */
    public void setPaOpenAccounts(CountSector value) {
        this.paOpenAccounts = value;
    }

    /**
     * Gets the value of the paTotalValueList property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paTotalValueList property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaTotalValueList().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MoneySector }
     */
    public List<MoneySector> getPaTotalValueList() {
        if (paTotalValueList == null) {
            paTotalValueList = new ArrayList<MoneySector>();
        }
        return this.paTotalValueList;
    }

    /**
     * Gets the value of the positiveScore property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getPositiveScore() {
        return positiveScore;
    }

    /**
     * Sets the value of the positiveScore property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setPositiveScore(Integer value) {
        this.positiveScore = value;
    }

}
