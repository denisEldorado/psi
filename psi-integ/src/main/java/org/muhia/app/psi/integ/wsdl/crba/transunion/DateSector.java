package org.muhia.app.psi.integ.wsdl.crba.transunion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for dateSector complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="dateSector">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mySector" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="otherSectors" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dateSector", propOrder = {"mySector", "otherSectors"})
public class DateSector {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar mySector;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar otherSectors;

    /**
     * Gets the value of the mySector property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getMySector() {
        return mySector;
    }

    /**
     * Sets the value of the mySector property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setMySector(XMLGregorianCalendar value) {
        this.mySector = value;
    }

    /**
     * Gets the value of the otherSectors property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getOtherSectors() {
        return otherSectors;
    }

    /**
     * Sets the value of the otherSectors property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setOtherSectors(XMLGregorianCalendar value) {
        this.otherSectors = value;
    }

}
