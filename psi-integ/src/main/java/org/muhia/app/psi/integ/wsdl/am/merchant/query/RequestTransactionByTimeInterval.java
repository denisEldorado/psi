
package org.muhia.app.psi.integ.wsdl.am.merchant.query;

import javax.xml.bind.annotation.*;


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
 *         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="passWord" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="timeFrom" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="timeTo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "userName",
        "passWord",
        "timeFrom",
        "timeTo"
})
@XmlRootElement(name = "RequestTransactionByTimeInterval")
public class RequestTransactionByTimeInterval {

    @XmlElement(required = true)
    protected String userName;
    @XmlElement(required = true)
    protected String passWord;
    @XmlElement(required = true)
    protected String timeFrom;
    @XmlElement(required = true)
    protected String timeTo;

    /**
     * Gets the value of the userName property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUserName(String value) {
        this.userName = value;
    }

    /**
     * Gets the value of the passWord property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * Sets the value of the passWord property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPassWord(String value) {
        this.passWord = value;
    }

    /**
     * Gets the value of the timeFrom property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTimeFrom() {
        return timeFrom;
    }

    /**
     * Sets the value of the timeFrom property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTimeFrom(String value) {
        this.timeFrom = value;
    }

    /**
     * Gets the value of the timeTo property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTimeTo() {
        return timeTo;
    }

    /**
     * Sets the value of the timeTo property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTimeTo(String value) {
        this.timeTo = value;
    }

}
