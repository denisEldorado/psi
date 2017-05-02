package org.muhia.app.psi.integ.wsdl.crba.transunion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for accountTypeList complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="accountTypeList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="closedNonPerformingAccountType" type="{http://ws.crbws.transunion.ke.co/}accountTypeSector" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="closedPerformingAccountType" type="{http://ws.crbws.transunion.ke.co/}accountTypeSector" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="closedPerformingWDHAccountType" type="{http://ws.crbws.transunion.ke.co/}accountTypeSector" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="openNonPerformingAccountType" type="{http://ws.crbws.transunion.ke.co/}accountTypeSector" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="openPerformingAccountType" type="{http://ws.crbws.transunion.ke.co/}accountTypeSector" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="openPerformingWDHAccountType" type="{http://ws.crbws.transunion.ke.co/}accountTypeSector" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountTypeList", propOrder = {"closedNonPerformingAccountType", "closedPerformingAccountType", "closedPerformingWDHAccountType", "openNonPerformingAccountType", "openPerformingAccountType", "openPerformingWDHAccountType"})
public class AccountTypeList {

    @XmlElement(nillable = true)
    protected List<AccountTypeSector> closedNonPerformingAccountType;
    @XmlElement(nillable = true)
    protected List<AccountTypeSector> closedPerformingAccountType;
    @XmlElement(nillable = true)
    protected List<AccountTypeSector> closedPerformingWDHAccountType;
    @XmlElement(nillable = true)
    protected List<AccountTypeSector> openNonPerformingAccountType;
    @XmlElement(nillable = true)
    protected List<AccountTypeSector> openPerformingAccountType;
    @XmlElement(nillable = true)
    protected List<AccountTypeSector> openPerformingWDHAccountType;

    /**
     * Gets the value of the closedNonPerformingAccountType property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the closedNonPerformingAccountType property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClosedNonPerformingAccountType().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccountTypeSector }
     */
    public List<AccountTypeSector> getClosedNonPerformingAccountType() {
        if (closedNonPerformingAccountType == null) {
            closedNonPerformingAccountType = new ArrayList<AccountTypeSector>();
        }
        return this.closedNonPerformingAccountType;
    }

    /**
     * Gets the value of the closedPerformingAccountType property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the closedPerformingAccountType property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClosedPerformingAccountType().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccountTypeSector }
     */
    public List<AccountTypeSector> getClosedPerformingAccountType() {
        if (closedPerformingAccountType == null) {
            closedPerformingAccountType = new ArrayList<AccountTypeSector>();
        }
        return this.closedPerformingAccountType;
    }

    /**
     * Gets the value of the closedPerformingWDHAccountType property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the closedPerformingWDHAccountType property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClosedPerformingWDHAccountType().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccountTypeSector }
     */
    public List<AccountTypeSector> getClosedPerformingWDHAccountType() {
        if (closedPerformingWDHAccountType == null) {
            closedPerformingWDHAccountType = new ArrayList<AccountTypeSector>();
        }
        return this.closedPerformingWDHAccountType;
    }

    /**
     * Gets the value of the openNonPerformingAccountType property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the openNonPerformingAccountType property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOpenNonPerformingAccountType().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccountTypeSector }
     */
    public List<AccountTypeSector> getOpenNonPerformingAccountType() {
        if (openNonPerformingAccountType == null) {
            openNonPerformingAccountType = new ArrayList<AccountTypeSector>();
        }
        return this.openNonPerformingAccountType;
    }

    /**
     * Gets the value of the openPerformingAccountType property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the openPerformingAccountType property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOpenPerformingAccountType().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccountTypeSector }
     */
    public List<AccountTypeSector> getOpenPerformingAccountType() {
        if (openPerformingAccountType == null) {
            openPerformingAccountType = new ArrayList<AccountTypeSector>();
        }
        return this.openPerformingAccountType;
    }

    /**
     * Gets the value of the openPerformingWDHAccountType property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the openPerformingWDHAccountType property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOpenPerformingWDHAccountType().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccountTypeSector }
     */
    public List<AccountTypeSector> getOpenPerformingWDHAccountType() {
        if (openPerformingWDHAccountType == null) {
            openPerformingWDHAccountType = new ArrayList<AccountTypeSector>();
        }
        return this.openPerformingWDHAccountType;
    }

}
