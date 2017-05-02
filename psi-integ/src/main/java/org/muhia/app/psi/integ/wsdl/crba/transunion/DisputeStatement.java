package org.muhia.app.psi.integ.wsdl.crba.transunion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for disputeStatement complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="disputeStatement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="disputeDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="statement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "disputeStatement", propOrder = {"disputeDate", "statement"})
public class DisputeStatement {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar disputeDate;
    protected String statement;

    /**
     * Gets the value of the disputeDate property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getDisputeDate() {
        return disputeDate;
    }

    /**
     * Sets the value of the disputeDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setDisputeDate(XMLGregorianCalendar value) {
        this.disputeDate = value;
    }

    /**
     * Gets the value of the statement property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getStatement() {
        return statement;
    }

    /**
     * Sets the value of the statement property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStatement(String value) {
        this.statement = value;
    }

}
