package org.muhia.app.psi.integ.wsdl.crba.transunion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for product115 complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="product115">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountList" type="{http://ws.crbws.transunion.ke.co/}account115" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="header" type="{http://ws.crbws.transunion.ke.co/}header115" minOccurs="0"/>
 *         &lt;element name="personalProfile" type="{http://ws.crbws.transunion.ke.co/}personalProfile115" minOccurs="0"/>
 *         &lt;element name="responseCode" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="scoreOutput" type="{http://ws.crbws.transunion.ke.co/}scoreOutput115" minOccurs="0"/>
 *         &lt;element name="summary" type="{http://ws.crbws.transunion.ke.co/}summary115" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "product115", propOrder = {"accountList", "header", "personalProfile", "responseCode", "scoreOutput", "summary"})
public class Product115 {

    @XmlElement(nillable = true)
    protected List<Account115> accountList;
    protected Header115 header;
    protected PersonalProfile115 personalProfile;
    protected Integer responseCode;
    protected ScoreOutput115 scoreOutput;
    protected Summary115 summary;

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
     * {@link Account115 }
     */
    public List<Account115> getAccountList() {
        if (accountList == null) {
            accountList = new ArrayList<Account115>();
        }
        return this.accountList;
    }

    /**
     * Gets the value of the header property.
     *
     * @return possible object is
     * {@link Header115 }
     */
    public Header115 getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     *
     * @param value allowed object is
     *              {@link Header115 }
     */
    public void setHeader(Header115 value) {
        this.header = value;
    }

    /**
     * Gets the value of the personalProfile property.
     *
     * @return possible object is
     * {@link PersonalProfile115 }
     */
    public PersonalProfile115 getPersonalProfile() {
        return personalProfile;
    }

    /**
     * Sets the value of the personalProfile property.
     *
     * @param value allowed object is
     *              {@link PersonalProfile115 }
     */
    public void setPersonalProfile(PersonalProfile115 value) {
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
     * {@link ScoreOutput115 }
     */
    public ScoreOutput115 getScoreOutput() {
        return scoreOutput;
    }

    /**
     * Sets the value of the scoreOutput property.
     *
     * @param value allowed object is
     *              {@link ScoreOutput115 }
     */
    public void setScoreOutput(ScoreOutput115 value) {
        this.scoreOutput = value;
    }

    /**
     * Gets the value of the summary property.
     *
     * @return possible object is
     * {@link Summary115 }
     */
    public Summary115 getSummary() {
        return summary;
    }

    /**
     * Sets the value of the summary property.
     *
     * @param value allowed object is
     *              {@link Summary115 }
     */
    public void setSummary(Summary115 value) {
        this.summary = value;
    }

}
