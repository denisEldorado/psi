
package org.muhia.app.psi.integ.wsdl.am.merchant.query;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * <p>Java class for XMLGregorianCalendar complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="XMLGregorianCalendar">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Month" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Day" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Timezone" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Hour" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Minute" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Second" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Millisecond" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="FractionalSecond" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMLGregorianCalendar", namespace = "java:javax.xml.datatype", propOrder = {
        "month",
        "day",
        "timezone",
        "hour",
        "minute",
        "second",
        "millisecond",
        "fractionalSecond"
})
public class XMLGregorianCalendar {

    @XmlElement(name = "Month")
    protected int month;
    @XmlElement(name = "Day")
    protected int day;
    @XmlElement(name = "Timezone")
    protected int timezone;
    @XmlElement(name = "Hour")
    protected int hour;
    @XmlElement(name = "Minute")
    protected int minute;
    @XmlElement(name = "Second")
    protected int second;
    @XmlElement(name = "Millisecond")
    protected int millisecond;
    @XmlElement(name = "FractionalSecond", required = true, nillable = true)
    protected BigDecimal fractionalSecond;

    /**
     * Gets the value of the month property.
     */
    public int getMonth() {
        return month;
    }

    /**
     * Sets the value of the month property.
     */
    public void setMonth(int value) {
        this.month = value;
    }

    /**
     * Gets the value of the day property.
     */
    public int getDay() {
        return day;
    }

    /**
     * Sets the value of the day property.
     */
    public void setDay(int value) {
        this.day = value;
    }

    /**
     * Gets the value of the timezone property.
     */
    public int getTimezone() {
        return timezone;
    }

    /**
     * Sets the value of the timezone property.
     */
    public void setTimezone(int value) {
        this.timezone = value;
    }

    /**
     * Gets the value of the hour property.
     */
    public int getHour() {
        return hour;
    }

    /**
     * Sets the value of the hour property.
     */
    public void setHour(int value) {
        this.hour = value;
    }

    /**
     * Gets the value of the minute property.
     */
    public int getMinute() {
        return minute;
    }

    /**
     * Sets the value of the minute property.
     */
    public void setMinute(int value) {
        this.minute = value;
    }

    /**
     * Gets the value of the second property.
     */
    public int getSecond() {
        return second;
    }

    /**
     * Sets the value of the second property.
     */
    public void setSecond(int value) {
        this.second = value;
    }

    /**
     * Gets the value of the millisecond property.
     */
    public int getMillisecond() {
        return millisecond;
    }

    /**
     * Sets the value of the millisecond property.
     */
    public void setMillisecond(int value) {
        this.millisecond = value;
    }

    /**
     * Gets the value of the fractionalSecond property.
     *
     * @return possible object is
     * {@link BigDecimal }
     */
    public BigDecimal getFractionalSecond() {
        return fractionalSecond;
    }

    /**
     * Sets the value of the fractionalSecond property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setFractionalSecond(BigDecimal value) {
        this.fractionalSecond = value;
    }

}
