package org.muhia.app.psi.integ.wsdl.crba.transunion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for scoreOutput116 complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="scoreOutput116">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="grade" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="positiveScore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "scoreOutput116", propOrder = {"country", "grade", "positiveScore"})
public class ScoreOutput116 {

    protected String country;
    protected String grade;
    protected String positiveScore;

    /**
     * Gets the value of the country property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the grade property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getGrade() {
        return grade;
    }

    /**
     * Sets the value of the grade property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setGrade(String value) {
        this.grade = value;
    }

    /**
     * Gets the value of the positiveScore property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPositiveScore() {
        return positiveScore;
    }

    /**
     * Sets the value of the positiveScore property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPositiveScore(String value) {
        this.positiveScore = value;
    }

}
