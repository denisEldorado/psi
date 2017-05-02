
package org.muhia.app.psi.integ.wsdl.mpesa.paymentvalidationandconfirmation.paymentvalidationandconfirmation;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TransType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TransID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TransTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TransAmount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BusinessShortCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BillRefNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InvoiceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrgAccountBalance" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ThirdPartyTransID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MSISDN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="KYCInfo" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="KYCName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="KYCValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "transType",
        "transID",
        "transTime",
        "transAmount",
        "businessShortCode",
        "billRefNumber",
        "invoiceNumber",
        "orgAccountBalance",
        "thirdPartyTransID",
        "msisdn",
        "kycInfo"
})
@XmlRootElement(name = "C2BPaymentConfirmationRequest")
public class C2BPaymentConfirmationRequest {

    @XmlElement(name = "TransType", required = true)
    protected String transType;
    @XmlElement(name = "TransID", required = true)
    protected String transID;
    @XmlElement(name = "TransTime", required = true)
    protected String transTime;
    @XmlElement(name = "TransAmount", required = true)
    protected String transAmount;
    @XmlElement(name = "BusinessShortCode", required = true)
    protected String businessShortCode;
    @XmlElement(name = "BillRefNumber")
    protected String billRefNumber;
    @XmlElement(name = "InvoiceNumber")
    protected String invoiceNumber;
    @XmlElement(name = "OrgAccountBalance", required = true)
    protected String orgAccountBalance;
    @XmlElement(name = "ThirdPartyTransID")
    protected String thirdPartyTransID;
    @XmlElement(name = "MSISDN", required = true)
    protected String msisdn;
    @XmlElement(name = "KYCInfo")
    protected List<C2BPaymentConfirmationRequest.KYCInfo> kycInfo;

    /**
     * Gets the value of the transType property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTransType() {
        return transType;
    }

    /**
     * Sets the value of the transType property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTransType(String value) {
        this.transType = value;
    }

    /**
     * Gets the value of the transID property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTransID() {
        return transID;
    }

    /**
     * Sets the value of the transID property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTransID(String value) {
        this.transID = value;
    }

    /**
     * Gets the value of the transTime property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTransTime() {
        return transTime;
    }

    /**
     * Sets the value of the transTime property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTransTime(String value) {
        this.transTime = value;
    }

    /**
     * Gets the value of the transAmount property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTransAmount() {
        return transAmount;
    }

    /**
     * Sets the value of the transAmount property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTransAmount(String value) {
        this.transAmount = value;
    }

    /**
     * Gets the value of the businessShortCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBusinessShortCode() {
        return businessShortCode;
    }

    /**
     * Sets the value of the businessShortCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBusinessShortCode(String value) {
        this.businessShortCode = value;
    }

    /**
     * Gets the value of the billRefNumber property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBillRefNumber() {
        return billRefNumber;
    }

    /**
     * Sets the value of the billRefNumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBillRefNumber(String value) {
        this.billRefNumber = value;
    }

    /**
     * Gets the value of the invoiceNumber property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    /**
     * Sets the value of the invoiceNumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setInvoiceNumber(String value) {
        this.invoiceNumber = value;
    }

    /**
     * Gets the value of the orgAccountBalance property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getOrgAccountBalance() {
        return orgAccountBalance;
    }

    /**
     * Sets the value of the orgAccountBalance property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setOrgAccountBalance(String value) {
        this.orgAccountBalance = value;
    }

    /**
     * Gets the value of the thirdPartyTransID property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getThirdPartyTransID() {
        return thirdPartyTransID;
    }

    /**
     * Sets the value of the thirdPartyTransID property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setThirdPartyTransID(String value) {
        this.thirdPartyTransID = value;
    }

    /**
     * Gets the value of the msisdn property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getMSISDN() {
        return msisdn;
    }

    /**
     * Sets the value of the msisdn property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMSISDN(String value) {
        this.msisdn = value;
    }

    /**
     * Gets the value of the kycInfo property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the kycInfo property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKYCInfo().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link C2BPaymentConfirmationRequest.KYCInfo }
     */
    public List<C2BPaymentConfirmationRequest.KYCInfo> getKYCInfo() {
        if (kycInfo == null) {
            kycInfo = new ArrayList<C2BPaymentConfirmationRequest.KYCInfo>();
        }
        return this.kycInfo;
    }


    /**
     * <p>Java class for anonymous complex type.
     * <p>
     * <p>The following schema fragment specifies the expected content contained within this class.
     * <p>
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="KYCName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="KYCValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "kycName",
            "kycValue"
    })
    public static class KYCInfo {

        @XmlElement(name = "KYCName", required = true)
        protected String kycName;
        @XmlElement(name = "KYCValue", required = true)
        protected String kycValue;

        /**
         * Gets the value of the kycName property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getKYCName() {
            return kycName;
        }

        /**
         * Sets the value of the kycName property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setKYCName(String value) {
            this.kycName = value;
        }

        /**
         * Gets the value of the kycValue property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getKYCValue() {
            return kycValue;
        }

        /**
         * Sets the value of the kycValue property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setKYCValue(String value) {
            this.kycValue = value;
        }

    }

}
