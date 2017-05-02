package org.muhia.app.psi.integ.wsdl.crba.transunion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for countSector complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="countSector">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mySector" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="otherSectors" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "countSector", propOrder = {"mySector", "otherSectors"})
public class CountSector {

    protected Integer mySector;
    protected Integer otherSectors;

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
     * Gets the value of the otherSectors property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getOtherSectors() {
        return otherSectors;
    }

    /**
     * Sets the value of the otherSectors property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setOtherSectors(Integer value) {
        this.otherSectors = value;
    }

}
