package org.muhia.app.psi.integ.wsdl.crba.transunion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getProduct402 complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="getProduct402">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="infinityCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="documentNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="names" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="phoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reportSector" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="reportReason" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getProduct402", propOrder = {"username", "password", "code", "infinityCode", "documentNumber", "names", "phoneNumber", "reportSector", "reportReason"})
public class GetProduct402 {

    protected String username;
    protected String password;
    protected String code;
    protected String infinityCode;
    protected String documentNumber;
    protected String names;
    protected String phoneNumber;
    protected int reportSector;
    protected int reportReason;

    /**
     * Gets the value of the username property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * Gets the value of the password property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the code property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the infinityCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getInfinityCode() {
        return infinityCode;
    }

    /**
     * Sets the value of the infinityCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setInfinityCode(String value) {
        this.infinityCode = value;
    }

    /**
     * Gets the value of the documentNumber property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDocumentNumber() {
        return documentNumber;
    }

    /**
     * Sets the value of the documentNumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDocumentNumber(String value) {
        this.documentNumber = value;
    }

    /**
     * Gets the value of the names property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNames() {
        return names;
    }

    /**
     * Sets the value of the names property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNames(String value) {
        this.names = value;
    }

    /**
     * Gets the value of the phoneNumber property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the value of the phoneNumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    /**
     * Gets the value of the reportSector property.
     */
    public int getReportSector() {
        return reportSector;
    }

    /**
     * Sets the value of the reportSector property.
     */
    public void setReportSector(int value) {
        this.reportSector = value;
    }

    /**
     * Gets the value of the reportReason property.
     */
    public int getReportReason() {
        return reportReason;
    }

    /**
     * Sets the value of the reportReason property.
     */
    public void setReportReason(int value) {
        this.reportReason = value;
    }

}
