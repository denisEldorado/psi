package org.muhia.app.psi.integ.wsdl.crba.transunion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for account complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="account">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountClosedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="accountNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountOpeningDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="accountOwner" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="arrearAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="arrearDays" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="balanceAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="disputed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="groupName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="groupNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isMyAccount" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="joinLoanParticipants" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="lastPaymentDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="listingDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="maturityDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="pastDueDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="principalAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="repaymentDuration" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="repaymentTerm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="scheduledPaymentAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="tradeSector" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="worstArrear" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "account", propOrder = {"accountClosedDate", "accountNo", "accountOpeningDate", "accountOwner", "accountStatus", "accountType", "arrearAmount", "arrearDays", "balanceAmount", "currency", "disputed", "groupName", "groupNumber", "isMyAccount", "joinLoanParticipants", "lastPaymentDate", "listingDate", "maturityDate", "pastDueDate", "principalAmount", "repaymentDuration", "repaymentTerm", "scheduledPaymentAmount", "tradeSector", "worstArrear"})
public class Account {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar accountClosedDate;
    protected String accountNo;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar accountOpeningDate;
    protected String accountOwner;
    protected String accountStatus;
    protected String accountType;
    protected Double arrearAmount;
    protected Integer arrearDays;
    protected Double balanceAmount;
    protected String currency;
    protected String disputed;
    protected String groupName;
    protected String groupNumber;
    protected Boolean isMyAccount;
    protected Integer joinLoanParticipants;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastPaymentDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar listingDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar maturityDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar pastDueDate;
    protected Double principalAmount;
    protected Integer repaymentDuration;
    protected String repaymentTerm;
    protected Double scheduledPaymentAmount;
    protected String tradeSector;
    protected Integer worstArrear;

    /**
     * Gets the value of the accountClosedDate property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getAccountClosedDate() {
        return accountClosedDate;
    }

    /**
     * Sets the value of the accountClosedDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setAccountClosedDate(XMLGregorianCalendar value) {
        this.accountClosedDate = value;
    }

    /**
     * Gets the value of the accountNo property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * Sets the value of the accountNo property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAccountNo(String value) {
        this.accountNo = value;
    }

    /**
     * Gets the value of the accountOpeningDate property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getAccountOpeningDate() {
        return accountOpeningDate;
    }

    /**
     * Sets the value of the accountOpeningDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setAccountOpeningDate(XMLGregorianCalendar value) {
        this.accountOpeningDate = value;
    }

    /**
     * Gets the value of the accountOwner property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAccountOwner() {
        return accountOwner;
    }

    /**
     * Sets the value of the accountOwner property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAccountOwner(String value) {
        this.accountOwner = value;
    }

    /**
     * Gets the value of the accountStatus property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAccountStatus() {
        return accountStatus;
    }

    /**
     * Sets the value of the accountStatus property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAccountStatus(String value) {
        this.accountStatus = value;
    }

    /**
     * Gets the value of the accountType property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * Sets the value of the accountType property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAccountType(String value) {
        this.accountType = value;
    }

    /**
     * Gets the value of the arrearAmount property.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getArrearAmount() {
        return arrearAmount;
    }

    /**
     * Sets the value of the arrearAmount property.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setArrearAmount(Double value) {
        this.arrearAmount = value;
    }

    /**
     * Gets the value of the arrearDays property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getArrearDays() {
        return arrearDays;
    }

    /**
     * Sets the value of the arrearDays property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setArrearDays(Integer value) {
        this.arrearDays = value;
    }

    /**
     * Gets the value of the balanceAmount property.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getBalanceAmount() {
        return balanceAmount;
    }

    /**
     * Sets the value of the balanceAmount property.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setBalanceAmount(Double value) {
        this.balanceAmount = value;
    }

    /**
     * Gets the value of the currency property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * Gets the value of the disputed property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDisputed() {
        return disputed;
    }

    /**
     * Sets the value of the disputed property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDisputed(String value) {
        this.disputed = value;
    }

    /**
     * Gets the value of the groupName property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * Sets the value of the groupName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setGroupName(String value) {
        this.groupName = value;
    }

    /**
     * Gets the value of the groupNumber property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getGroupNumber() {
        return groupNumber;
    }

    /**
     * Sets the value of the groupNumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setGroupNumber(String value) {
        this.groupNumber = value;
    }

    /**
     * Gets the value of the isMyAccount property.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public Boolean isIsMyAccount() {
        return isMyAccount;
    }

    /**
     * Sets the value of the isMyAccount property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setIsMyAccount(Boolean value) {
        this.isMyAccount = value;
    }

    /**
     * Gets the value of the joinLoanParticipants property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getJoinLoanParticipants() {
        return joinLoanParticipants;
    }

    /**
     * Sets the value of the joinLoanParticipants property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setJoinLoanParticipants(Integer value) {
        this.joinLoanParticipants = value;
    }

    /**
     * Gets the value of the lastPaymentDate property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getLastPaymentDate() {
        return lastPaymentDate;
    }

    /**
     * Sets the value of the lastPaymentDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setLastPaymentDate(XMLGregorianCalendar value) {
        this.lastPaymentDate = value;
    }

    /**
     * Gets the value of the listingDate property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getListingDate() {
        return listingDate;
    }

    /**
     * Sets the value of the listingDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setListingDate(XMLGregorianCalendar value) {
        this.listingDate = value;
    }

    /**
     * Gets the value of the maturityDate property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getMaturityDate() {
        return maturityDate;
    }

    /**
     * Sets the value of the maturityDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setMaturityDate(XMLGregorianCalendar value) {
        this.maturityDate = value;
    }

    /**
     * Gets the value of the pastDueDate property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getPastDueDate() {
        return pastDueDate;
    }

    /**
     * Sets the value of the pastDueDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setPastDueDate(XMLGregorianCalendar value) {
        this.pastDueDate = value;
    }

    /**
     * Gets the value of the principalAmount property.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getPrincipalAmount() {
        return principalAmount;
    }

    /**
     * Sets the value of the principalAmount property.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setPrincipalAmount(Double value) {
        this.principalAmount = value;
    }

    /**
     * Gets the value of the repaymentDuration property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getRepaymentDuration() {
        return repaymentDuration;
    }

    /**
     * Sets the value of the repaymentDuration property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setRepaymentDuration(Integer value) {
        this.repaymentDuration = value;
    }

    /**
     * Gets the value of the repaymentTerm property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRepaymentTerm() {
        return repaymentTerm;
    }

    /**
     * Sets the value of the repaymentTerm property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRepaymentTerm(String value) {
        this.repaymentTerm = value;
    }

    /**
     * Gets the value of the scheduledPaymentAmount property.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getScheduledPaymentAmount() {
        return scheduledPaymentAmount;
    }

    /**
     * Sets the value of the scheduledPaymentAmount property.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setScheduledPaymentAmount(Double value) {
        this.scheduledPaymentAmount = value;
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

    /**
     * Gets the value of the worstArrear property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getWorstArrear() {
        return worstArrear;
    }

    /**
     * Sets the value of the worstArrear property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setWorstArrear(Integer value) {
        this.worstArrear = value;
    }

}
