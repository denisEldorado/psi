package org.muhia.app.psi.integ.wsdl.crba.transunion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for scoreOutput118 complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="scoreOutput118">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="grade" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="positiveScore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="probability" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reasonCodeAARC1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reasonCodeAARC2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reasonCodeAARC3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reasonCodeAARC4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "scoreOutput118", propOrder = {"country", "grade", "positiveScore", "probability", "reasonCodeAARC1", "reasonCodeAARC2", "reasonCodeAARC3", "reasonCodeAARC4"})
public class ScoreOutput118 {

    protected String country;
    protected String grade;
    protected String positiveScore;
    protected String probability;
    protected String reasonCodeAARC1;
    protected String reasonCodeAARC2;
    protected String reasonCodeAARC3;
    protected String reasonCodeAARC4;

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

    /**
     * Gets the value of the probability property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getProbability() {
        return probability;
    }

    /**
     * Sets the value of the probability property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setProbability(String value) {
        this.probability = value;
    }

    /**
     * Gets the value of the reasonCodeAARC1 property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getReasonCodeAARC1() {
        return reasonCodeAARC1;
    }

    /**
     * Sets the value of the reasonCodeAARC1 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setReasonCodeAARC1(String value) {
        this.reasonCodeAARC1 = value;
    }

    /**
     * Gets the value of the reasonCodeAARC2 property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getReasonCodeAARC2() {
        return reasonCodeAARC2;
    }

    /**
     * Sets the value of the reasonCodeAARC2 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setReasonCodeAARC2(String value) {
        this.reasonCodeAARC2 = value;
    }

    /**
     * Gets the value of the reasonCodeAARC3 property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getReasonCodeAARC3() {
        return reasonCodeAARC3;
    }

    /**
     * Sets the value of the reasonCodeAARC3 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setReasonCodeAARC3(String value) {
        this.reasonCodeAARC3 = value;
    }

    /**
     * Gets the value of the reasonCodeAARC4 property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getReasonCodeAARC4() {
        return reasonCodeAARC4;
    }

    /**
     * Sets the value of the reasonCodeAARC4 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setReasonCodeAARC4(String value) {
        this.reasonCodeAARC4 = value;
    }

}
