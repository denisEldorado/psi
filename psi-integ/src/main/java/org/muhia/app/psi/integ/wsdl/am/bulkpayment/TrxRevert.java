
package org.muhia.app.psi.integ.wsdl.am.bulkpayment;

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
 *         &lt;element name="referenceid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="narration" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nickname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "referenceid",
        "narration",
        "nickname",
        "username",
        "password"
})
@XmlRootElement(name = "TrxRevert")
public class TrxRevert {

    @XmlElement(required = true)
    protected String referenceid;
    @XmlElement(required = true)
    protected String narration;
    @XmlElement(required = true)
    protected String nickname;
    @XmlElement(required = true)
    protected String username;
    @XmlElement(required = true)
    protected String password;

    /**
     * Gets the value of the referenceid property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getReferenceid() {
        return referenceid;
    }

    /**
     * Sets the value of the referenceid property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setReferenceid(String value) {
        this.referenceid = value;
    }

    /**
     * Gets the value of the narration property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNarration() {
        return narration;
    }

    /**
     * Sets the value of the narration property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNarration(String value) {
        this.narration = value;
    }

    /**
     * Gets the value of the nickname property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Sets the value of the nickname property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNickname(String value) {
        this.nickname = value;
    }

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

}
