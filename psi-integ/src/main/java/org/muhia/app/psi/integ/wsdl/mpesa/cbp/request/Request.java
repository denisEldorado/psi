
package org.muhia.app.psi.integ.wsdl.mpesa.cbp.request;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Transaction">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CommandID">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="64"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="LanguageCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="OriginatorConversationID">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="128"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="ConversationID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Remark" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="255"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="EncryptedParameters" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Parameters" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Parameter" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;extension base="{http://api-v1.gen.mm.vodafone.com/mminterface/request}ParameterType">
 *                                   &lt;/extension>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="ReferenceData" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="ReferenceItem" type="{http://api-v1.gen.mm.vodafone.com/mminterface/request}ParameterType" maxOccurs="unbounded"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Timestamp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Identity">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Caller">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="CallerType" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                             &lt;element name="ThirdPartyID">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="20"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="Password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CheckSum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ResultURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Initiator">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="IdentifierType" type="{http://api-v1.gen.mm.vodafone.com/mminterface/request}IdentifierType"/>
 *                             &lt;element name="Identifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="SecurityCredential" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="ShortCode" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="PrimaryParty" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="IdentifierType" type="{http://api-v1.gen.mm.vodafone.com/mminterface/request}IdentifierType"/>
 *                             &lt;element name="Identifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="ShortCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="ReceiverParty" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="IdentifierType" type="{http://api-v1.gen.mm.vodafone.com/mminterface/request}IdentifierType"/>
 *                             &lt;element name="Identifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="ShortCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="AccessDevice" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="IdentifierType" type="{http://api-v1.gen.mm.vodafone.com/mminterface/request}IdentifierType"/>
 *                             &lt;element name="Identifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="KeyOwner" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "request", propOrder = {
    "transaction",
    "identity",
    "keyOwner"
})
@XmlRootElement(name = "request")
public class Request {

    @XmlElement(name = "Transaction", required = true)
    protected Request.Transaction transaction;
    @XmlElement(name = "Identity", required = true)
    protected Request.Identity identity;
    @XmlElement(name = "KeyOwner", required = true)
    protected BigInteger keyOwner;

    /**
     * Gets the value of the transaction property.
     * 
     * @return
     *     possible object is
     *     {@link Request.Transaction }
     *     
     */
    public Request.Transaction getTransaction() {
        return transaction;
    }

    /**
     * Sets the value of the transaction property.
     * 
     * @param value
     *     allowed object is
     *     {@link Request.Transaction }
     *     
     */
    public void setTransaction(Request.Transaction value) {
        this.transaction = value;
    }

    /**
     * Gets the value of the identity property.
     * 
     * @return
     *     possible object is
     *     {@link Request.Identity }
     *     
     */
    public Request.Identity getIdentity() {
        return identity;
    }

    /**
     * Sets the value of the identity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Request.Identity }
     *     
     */
    public void setIdentity(Request.Identity value) {
        this.identity = value;
    }

    /**
     * Gets the value of the keyOwner property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getKeyOwner() {
        return keyOwner;
    }

    /**
     * Sets the value of the keyOwner property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setKeyOwner(BigInteger value) {
        this.keyOwner = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Caller">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="CallerType" type="{http://www.w3.org/2001/XMLSchema}integer"/>
     *                   &lt;element name="ThirdPartyID">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;maxLength value="20"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="Password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CheckSum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ResultURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Initiator">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="IdentifierType" type="{http://api-v1.gen.mm.vodafone.com/mminterface/request}IdentifierType"/>
     *                   &lt;element name="Identifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="SecurityCredential" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="ShortCode" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="PrimaryParty" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="IdentifierType" type="{http://api-v1.gen.mm.vodafone.com/mminterface/request}IdentifierType"/>
     *                   &lt;element name="Identifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="ShortCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="ReceiverParty" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="IdentifierType" type="{http://api-v1.gen.mm.vodafone.com/mminterface/request}IdentifierType"/>
     *                   &lt;element name="Identifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="ShortCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="AccessDevice" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="IdentifierType" type="{http://api-v1.gen.mm.vodafone.com/mminterface/request}IdentifierType"/>
     *                   &lt;element name="Identifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "caller",
        "initiator",
        "primaryParty",
        "receiverParty",
        "accessDevice"
    })
    public static class Identity {

        @XmlElement(name = "Caller", required = true)
        protected Request.Identity.Caller caller;
        @XmlElement(name = "Initiator", required = true)
        protected Request.Identity.Initiator initiator;
        @XmlElement(name = "PrimaryParty")
        protected PrimaryParty primaryParty;
        @XmlElement(name = "ReceiverParty")
        protected Request.Identity.ReceiverParty receiverParty;
        @XmlElement(name = "AccessDevice")
        protected Request.Identity.AccessDevice accessDevice;

        /**
         * Gets the value of the caller property.
         * 
         * @return
         *     possible object is
         *     {@link Request.Identity.Caller }
         *     
         */
        public Request.Identity.Caller getCaller() {
            return caller;
        }

        /**
         * Sets the value of the caller property.
         * 
         * @param value
         *     allowed object is
         *     {@link Request.Identity.Caller }
         *     
         */
        public void setCaller(Request.Identity.Caller value) {
            this.caller = value;
        }

        /**
         * Gets the value of the initiator property.
         * 
         * @return
         *     possible object is
         *     {@link Request.Identity.Initiator }
         *     
         */
        public Request.Identity.Initiator getInitiator() {
            return initiator;
        }

        /**
         * Sets the value of the initiator property.
         * 
         * @param value
         *     allowed object is
         *     {@link Request.Identity.Initiator }
         *     
         */
        public void setInitiator(Request.Identity.Initiator value) {
            this.initiator = value;
        }

        /**
         * Gets the value of the primaryParty property.
         * 
         * @return
         *     possible object is
         *     {@link PrimaryParty }
         *     
         */
        public PrimaryParty getPrimaryParty() {
            return primaryParty;
        }

        /**
         * Sets the value of the primaryParty property.
         * 
         * @param value
         *     allowed object is
         *     {@link PrimaryParty }
         *     
         */
        public void setPrimaryParty(PrimaryParty value) {
            this.primaryParty = value;
        }

        /**
         * Gets the value of the receiverParty property.
         * 
         * @return
         *     possible object is
         *     {@link Request.Identity.ReceiverParty }
         *     
         */
        public Request.Identity.ReceiverParty getReceiverParty() {
            return receiverParty;
        }

        /**
         * Sets the value of the receiverParty property.
         * 
         * @param value
         *     allowed object is
         *     {@link Request.Identity.ReceiverParty }
         *     
         */
        public void setReceiverParty(Request.Identity.ReceiverParty value) {
            this.receiverParty = value;
        }

        /**
         * Gets the value of the accessDevice property.
         * 
         * @return
         *     possible object is
         *     {@link Request.Identity.AccessDevice }
         *     
         */
        public Request.Identity.AccessDevice getAccessDevice() {
            return accessDevice;
        }

        /**
         * Sets the value of the accessDevice property.
         * 
         * @param value
         *     allowed object is
         *     {@link Request.Identity.AccessDevice }
         *     
         */
        public void setAccessDevice(Request.Identity.AccessDevice value) {
            this.accessDevice = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="IdentifierType" type="{http://api-v1.gen.mm.vodafone.com/mminterface/request}IdentifierType"/>
         *         &lt;element name="Identifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "identifierType",
            "identifier"
        })
        public static class AccessDevice {

            @XmlElement(name = "IdentifierType", required = true)
            protected BigInteger identifierType;
            @XmlElement(name = "Identifier", required = true)
            protected String identifier;

            /**
             * Gets the value of the identifierType property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getIdentifierType() {
                return identifierType;
            }

            /**
             * Sets the value of the identifierType property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setIdentifierType(BigInteger value) {
                this.identifierType = value;
            }

            /**
             * Gets the value of the identifier property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIdentifier() {
                return identifier;
            }

            /**
             * Sets the value of the identifier property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIdentifier(String value) {
                this.identifier = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="CallerType" type="{http://www.w3.org/2001/XMLSchema}integer"/>
         *         &lt;element name="ThirdPartyID">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;maxLength value="20"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="Password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="CheckSum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ResultURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "callerType",
            "thirdPartyID",
            "password",
            "checkSum",
            "resultURL"
        })
        public static class Caller {

            @XmlElement(name = "CallerType", required = true)
            protected BigInteger callerType;
            @XmlElement(name = "ThirdPartyID", required = true)
            protected String thirdPartyID;
            @XmlElement(name = "Password")
            protected String password;
            @XmlElement(name = "CheckSum")
            protected String checkSum;
            @XmlElement(name = "ResultURL")
            protected String resultURL;

            /**
             * Gets the value of the callerType property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getCallerType() {
                return callerType;
            }

            /**
             * Sets the value of the callerType property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setCallerType(BigInteger value) {
                this.callerType = value;
            }

            /**
             * Gets the value of the thirdPartyID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getThirdPartyID() {
                return thirdPartyID;
            }

            /**
             * Sets the value of the thirdPartyID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setThirdPartyID(String value) {
                this.thirdPartyID = value;
            }

            /**
             * Gets the value of the password property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPassword() {
                return password;
            }

            /**
             * Sets the value of the password property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPassword(String value) {
                this.password = value;
            }

            /**
             * Gets the value of the checkSum property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCheckSum() {
                return checkSum;
            }

            /**
             * Sets the value of the checkSum property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCheckSum(String value) {
                this.checkSum = value;
            }

            /**
             * Gets the value of the resultURL property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getResultURL() {
                return resultURL;
            }

            /**
             * Sets the value of the resultURL property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setResultURL(String value) {
                this.resultURL = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="IdentifierType" type="{http://api-v1.gen.mm.vodafone.com/mminterface/request}IdentifierType"/>
         *         &lt;element name="Identifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="SecurityCredential" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="ShortCode" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "identifierType",
            "identifier",
            "securityCredential",
            "shortCode"
        })
        public static class Initiator {

            @XmlElement(name = "IdentifierType", required = true)
            protected BigInteger identifierType;
            @XmlElement(name = "Identifier", required = true)
            protected String identifier;
            @XmlElement(name = "SecurityCredential", required = true)
            protected String securityCredential;
            @XmlElement(name = "ShortCode")
            protected Object shortCode;

            /**
             * Gets the value of the identifierType property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getIdentifierType() {
                return identifierType;
            }

            /**
             * Sets the value of the identifierType property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setIdentifierType(BigInteger value) {
                this.identifierType = value;
            }

            /**
             * Gets the value of the identifier property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIdentifier() {
                return identifier;
            }

            /**
             * Sets the value of the identifier property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIdentifier(String value) {
                this.identifier = value;
            }

            /**
             * Gets the value of the securityCredential property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSecurityCredential() {
                return securityCredential;
            }

            /**
             * Sets the value of the securityCredential property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSecurityCredential(String value) {
                this.securityCredential = value;
            }

            /**
             * Gets the value of the shortCode property.
             * 
             * @return
             *     possible object is
             *     {@link Object }
             *     
             */
            public Object getShortCode() {
                return shortCode;
            }

            /**
             * Sets the value of the shortCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link Object }
             *     
             */
            public void setShortCode(Object value) {
                this.shortCode = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="IdentifierType" type="{http://api-v1.gen.mm.vodafone.com/mminterface/request}IdentifierType"/>
         *         &lt;element name="Identifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="ShortCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "identifierType",
            "identifier",
            "shortCode"
        })
        public static class PrimaryParty {

            @XmlElement(name = "IdentifierType", required = true)
            protected BigInteger identifierType;
            @XmlElement(name = "Identifier", required = true)
            protected String identifier;
            @XmlElement(name = "ShortCode")
            protected String shortCode;

            /**
             * Gets the value of the identifierType property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getIdentifierType() {
                return identifierType;
            }

            /**
             * Sets the value of the identifierType property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setIdentifierType(BigInteger value) {
                this.identifierType = value;
            }

            /**
             * Gets the value of the identifier property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIdentifier() {
                return identifier;
            }

            /**
             * Sets the value of the identifier property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIdentifier(String value) {
                this.identifier = value;
            }

            /**
             * Gets the value of the shortCode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getShortCode() {
                return shortCode;
            }

            /**
             * Sets the value of the shortCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setShortCode(String value) {
                this.shortCode = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="IdentifierType" type="{http://api-v1.gen.mm.vodafone.com/mminterface/request}IdentifierType"/>
         *         &lt;element name="Identifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="ShortCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "identifierType",
            "identifier",
            "shortCode"
        })
        public static class ReceiverParty {

            @XmlElement(name = "IdentifierType", required = true)
            protected BigInteger identifierType;
            @XmlElement(name = "Identifier", required = true)
            protected String identifier;
            @XmlElement(name = "ShortCode")
            protected String shortCode;

            /**
             * Gets the value of the identifierType property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getIdentifierType() {
                return identifierType;
            }

            /**
             * Sets the value of the identifierType property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setIdentifierType(BigInteger value) {
                this.identifierType = value;
            }

            /**
             * Gets the value of the identifier property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIdentifier() {
                return identifier;
            }

            /**
             * Sets the value of the identifier property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIdentifier(String value) {
                this.identifier = value;
            }

            /**
             * Gets the value of the shortCode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getShortCode() {
                return shortCode;
            }

            /**
             * Sets the value of the shortCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setShortCode(String value) {
                this.shortCode = value;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="CommandID">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="64"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="LanguageCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="OriginatorConversationID">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="128"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="ConversationID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Remark" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="255"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="EncryptedParameters" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Parameters" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Parameter" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;extension base="{http://api-v1.gen.mm.vodafone.com/mminterface/request}ParameterType">
     *                         &lt;/extension>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="ReferenceData" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="ReferenceItem" type="{http://api-v1.gen.mm.vodafone.com/mminterface/request}ParameterType" maxOccurs="unbounded"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Timestamp" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "commandID",
        "languageCode",
        "originatorConversationID",
        "conversationID",
        "remark",
        "encryptedParameters",
        "parameters",
        "referenceData",
        "timestamp"
    })
    public static class Transaction {

        @XmlElement(name = "CommandID", required = true)
        protected String commandID;
        @XmlElement(name = "LanguageCode")
        protected String languageCode;
        @XmlElement(name = "OriginatorConversationID", required = true)
        protected String originatorConversationID;
        @XmlElement(name = "ConversationID")
        protected String conversationID;
        @XmlElement(name = "Remark")
        protected String remark;
        @XmlElement(name = "EncryptedParameters")
        protected String encryptedParameters;
        @XmlElement(name = "Parameters")
        protected Request.Transaction.Parameters parameters;
        @XmlElement(name = "ReferenceData")
        protected Request.Transaction.ReferenceData referenceData;
        @XmlElement(name = "Timestamp", required = true)
        protected String timestamp;

        /**
         * Gets the value of the commandID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCommandID() {
            return commandID;
        }

        /**
         * Sets the value of the commandID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCommandID(String value) {
            this.commandID = value;
        }

        /**
         * Gets the value of the languageCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLanguageCode() {
            return languageCode;
        }

        /**
         * Sets the value of the languageCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLanguageCode(String value) {
            this.languageCode = value;
        }

        /**
         * Gets the value of the originatorConversationID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOriginatorConversationID() {
            return originatorConversationID;
        }

        /**
         * Sets the value of the originatorConversationID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOriginatorConversationID(String value) {
            this.originatorConversationID = value;
        }

        /**
         * Gets the value of the conversationID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getConversationID() {
            return conversationID;
        }

        /**
         * Sets the value of the conversationID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setConversationID(String value) {
            this.conversationID = value;
        }

        /**
         * Gets the value of the remark property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRemark() {
            return remark;
        }

        /**
         * Sets the value of the remark property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRemark(String value) {
            this.remark = value;
        }

        /**
         * Gets the value of the encryptedParameters property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEncryptedParameters() {
            return encryptedParameters;
        }

        /**
         * Sets the value of the encryptedParameters property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEncryptedParameters(String value) {
            this.encryptedParameters = value;
        }

        /**
         * Gets the value of the parameters property.
         * 
         * @return
         *     possible object is
         *     {@link Request.Transaction.Parameters }
         *     
         */
        public Request.Transaction.Parameters getParameters() {
            return parameters;
        }

        /**
         * Sets the value of the parameters property.
         * 
         * @param value
         *     allowed object is
         *     {@link Request.Transaction.Parameters }
         *     
         */
        public void setParameters(Request.Transaction.Parameters value) {
            this.parameters = value;
        }

        /**
         * Gets the value of the referenceData property.
         * 
         * @return
         *     possible object is
         *     {@link Request.Transaction.ReferenceData }
         *     
         */
        public Request.Transaction.ReferenceData getReferenceData() {
            return referenceData;
        }

        /**
         * Sets the value of the referenceData property.
         * 
         * @param value
         *     allowed object is
         *     {@link Request.Transaction.ReferenceData }
         *     
         */
        public void setReferenceData(Request.Transaction.ReferenceData value) {
            this.referenceData = value;
        }

        /**
         * Gets the value of the timestamp property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTimestamp() {
            return timestamp;
        }

        /**
         * Sets the value of the timestamp property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTimestamp(String value) {
            this.timestamp = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="Parameter" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;extension base="{http://api-v1.gen.mm.vodafone.com/mminterface/request}ParameterType">
         *               &lt;/extension>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "parameter"
        })
        public static class Parameters {

            @XmlElement(name = "Parameter", required = true)
            protected List<Request.Transaction.Parameters.Parameter> parameter;

            /**
             * Gets the value of the parameter property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the parameter property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getParameter().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Request.Transaction.Parameters.Parameter }
             * 
             * 
             */
            public List<Request.Transaction.Parameters.Parameter> getParameter() {
                if (parameter == null) {
                    parameter = new ArrayList<Request.Transaction.Parameters.Parameter>();
                }
                return this.parameter;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;extension base="{http://api-v1.gen.mm.vodafone.com/mminterface/request}ParameterType">
             *     &lt;/extension>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Parameter
                extends ParameterType2
            {


            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="ReferenceItem" type="{http://api-v1.gen.mm.vodafone.com/mminterface/request}ParameterType" maxOccurs="unbounded"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "referenceItem"
        })
        public static class ReferenceData {

            @XmlElement(name = "ReferenceItem", required = true)
            protected List<ParameterType2> referenceItem;

            /**
             * Gets the value of the referenceItem property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the referenceItem property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getReferenceItem().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ParameterType2 }
             * 
             * 
             */
            public List<ParameterType2> getReferenceItem() {
                if (referenceItem == null) {
                    referenceItem = new ArrayList<ParameterType2>();
                }
                return this.referenceItem;
            }

        }

    }

}
