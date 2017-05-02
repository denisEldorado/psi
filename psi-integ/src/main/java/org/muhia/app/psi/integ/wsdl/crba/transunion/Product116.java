package org.muhia.app.psi.integ.wsdl.crba.transunion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for product116 complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="product116">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountList" type="{http://ws.crbws.transunion.ke.co/}account116" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="collateralList" type="{http://ws.crbws.transunion.ke.co/}collateral" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="creditApplicationList" type="{http://ws.crbws.transunion.ke.co/}creditApplication" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="header" type="{http://ws.crbws.transunion.ke.co/}header" minOccurs="0"/>
 *         &lt;element name="personalProfile" type="{http://ws.crbws.transunion.ke.co/}personalProfile116" minOccurs="0"/>
 *         &lt;element name="responseCode" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="scoreOutput" type="{http://ws.crbws.transunion.ke.co/}scoreOutput116" minOccurs="0"/>
 *         &lt;element name="summary" type="{http://ws.crbws.transunion.ke.co/}summary116" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "product116", propOrder = {"accountList", "collateralList", "creditApplicationList", "header", "personalProfile", "responseCode", "scoreOutput", "summary"})
public class Product116 {

    @XmlElement(nillable = true)
    protected List<Account116> accountList;
    @XmlElement(nillable = true)
    protected List<Collateral> collateralList;
    @XmlElement(nillable = true)
    protected List<CreditApplication> creditApplicationList;
    protected Header header;
    protected PersonalProfile116 personalProfile;
    protected Integer responseCode;
    protected ScoreOutput116 scoreOutput;
    protected Summary116 summary;

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
     * {@link Account116 }
     */
    public List<Account116> getAccountList() {
        if (accountList == null) {
            accountList = new ArrayList<Account116>();
        }
        return this.accountList;
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
     * {@link PersonalProfile116 }
     */
    public PersonalProfile116 getPersonalProfile() {
        return personalProfile;
    }

    /**
     * Sets the value of the personalProfile property.
     *
     * @param value allowed object is
     *              {@link PersonalProfile116 }
     */
    public void setPersonalProfile(PersonalProfile116 value) {
        this.personalProfile = value;
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
     * {@link ScoreOutput116 }
     */
    public ScoreOutput116 getScoreOutput() {
        return scoreOutput;
    }

    /**
     * Sets the value of the scoreOutput property.
     *
     * @param value allowed object is
     *              {@link ScoreOutput116 }
     */
    public void setScoreOutput(ScoreOutput116 value) {
        this.scoreOutput = value;
    }

    /**
     * Gets the value of the summary property.
     *
     * @return possible object is
     * {@link Summary116 }
     */
    public Summary116 getSummary() {
        return summary;
    }

    /**
     * Sets the value of the summary property.
     *
     * @param value allowed object is
     *              {@link Summary116 }
     */
    public void setSummary(Summary116 value) {
        this.summary = value;
    }

}
