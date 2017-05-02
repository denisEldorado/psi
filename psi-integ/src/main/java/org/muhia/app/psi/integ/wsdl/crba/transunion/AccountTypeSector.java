package org.muhia.app.psi.integ.wsdl.crba.transunion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for accountTypeSector complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="accountTypeSector">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mySector" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="otherSector" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountTypeSector", propOrder = {"accountType", "mySector", "otherSector"})
public class AccountTypeSector {

    protected String accountType;
    protected Integer mySector;
    protected Integer otherSector;

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
     * Gets the value of the mySector property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getMySector() {
        return mySector;
    }

    /**
     * Sets the value of the mySector property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setMySector(Integer value) {
        this.mySector = value;
    }

    /**
     * Gets the value of the otherSector property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getOtherSector() {
        return otherSector;
    }

    /**
     * Sets the value of the otherSector property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setOtherSector(Integer value) {
        this.otherSector = value;
    }

}
