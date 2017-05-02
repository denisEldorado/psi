package org.muhia.app.psi.orm.model;

import javax.persistence.*;
import java.util.Date;;
import java.util.Collection;

/*
  Created by Kenneth
  Project: psi
  Package: org.muhia.apps.psi.orm.model
  Generated on: 30-Mar-17, 08:42.
 */
@Entity
@Table(name = "DAT_REGISTRATION_DETAILS")
public class RegistrationDetails {
    private Long id;
    private int acceptedTerms;
    private Date acceptedTermsDate;
    private String firstName;
    private String lastName;
    private String middleName;
    private String userPin;
    private String userMsisdn;
    private String userIdNumber;
    private Integer userRegistrationStatus;
    private Date registrationDate;
    private Date iprsValidationDate;
    private Date loginActivationDate;
    private String accountNumber;
    private String varTextField1;
    private String varTextField2;
    private String varTextField3;
    private String varTextField4;
    private String varTextField5;
    private String varTextField6;
    private String varTextField7;
    private String varTextField8;
    private String varTextField9;
    private String varTextField10;
    private Integer version;
    private String createdby;
    private Date createdon;
    private String modifiedby;
    private Date modifiedOn;
    private String deleteby;
    private Date deletedon;
    private Collection<Principals> admPrincipalsById;
    private RegistrationDocs userIdDocType;
    private ServiceRequests serviceRequest;
    private Organizations organisation;

    @Id
    @SequenceGenerator(name = "DAT_REGISTRATION_DETAILS_SEQ_GEN", sequenceName = "DAT_REGISTRATION_DETAILS_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "DAT_REGISTRATION_DETAILS_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ACCEPTED_TERMS", nullable = false, precision = 0)
    public int getAcceptedTerms() {
        return acceptedTerms;
    }

    public void setAcceptedTerms(int acceptedTerms) {
        this.acceptedTerms = acceptedTerms;
    }

    @Basic
    @Column(name = "ACCEPTED_TERMS_DATE", nullable = true)
    public Date getAcceptedTermsDate() {
        return acceptedTermsDate;
    }

    public void setAcceptedTermsDate(Date acceptedTermsDate) {
        this.acceptedTermsDate = acceptedTermsDate;
    }

    @Basic
    @Column(name = "FIRST_NAME", nullable = false, length = 250)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "LAST_NAME", nullable = false, length = 250)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "MIDDLE_NAME", nullable = false, length = 250)
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Basic
    @Column(name = "USER_PIN", nullable = true, length = 35)
    public String getUserPin() {
        return userPin;
    }

    public void setUserPin(String userPin) {
        this.userPin = userPin;
    }

    @Basic
    @Column(name = "USER_MSISDN", nullable = false, length = 35)
    public String getUserMsisdn() {
        return userMsisdn;
    }

    public void setUserMsisdn(String userMsisdn) {
        this.userMsisdn = userMsisdn;
    }

    @Basic
    @Column(name = "USER_ID_NUMBER", nullable = false, length = 20)
    public String getUserIdNumber() {
        return userIdNumber;
    }

    public void setUserIdNumber(String userIdNumber) {
        this.userIdNumber = userIdNumber;
    }

    @Basic
    @Column(name = "USER_REGISTRATION_STATUS", nullable = false, precision = 0)
    public Integer getUserRegistrationStatus() {
        return userRegistrationStatus;
    }

    public void setUserRegistrationStatus(Integer userRegistrationStatus) {
        this.userRegistrationStatus = userRegistrationStatus;
    }

    @Basic
    @Column(name = "REGISTRATION_DATE", nullable = false)
    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Basic
    @Column(name = "IPRS_VALIDATION_DATE", nullable = true)
    public Date getIprsValidationDate() {
        return iprsValidationDate;
    }

    public void setIprsValidationDate(Date iprsValidationDate) {
        this.iprsValidationDate = iprsValidationDate;
    }

    @Basic
    @Column(name = "LOGIN_ACTIVATION_DATE", nullable = true)
    public Date getLoginActivationDate() {
        return loginActivationDate;
    }

    public void setLoginActivationDate(Date loginActivationDate) {
        this.loginActivationDate = loginActivationDate;
    }

    @Basic
    @Column(name = "ACCOUNT_NUMBER", nullable = true, length = 350)
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Basic
    @Column(name = "VAR_TEXT_FIELD_1", nullable = true, length = 350)
    public String getVarTextField1() {
        return varTextField1;
    }

    public void setVarTextField1(String varTextField1) {
        this.varTextField1 = varTextField1;
    }

    @Basic
    @Column(name = "VAR_TEXT_FIELD_2", nullable = true, length = 350)
    public String getVarTextField2() {
        return varTextField2;
    }

    public void setVarTextField2(String varTextField2) {
        this.varTextField2 = varTextField2;
    }

    @Basic
    @Column(name = "VAR_TEXT_FIELD_3", nullable = true, length = 350)
    public String getVarTextField3() {
        return varTextField3;
    }

    public void setVarTextField3(String varTextField3) {
        this.varTextField3 = varTextField3;
    }

    @Basic
    @Column(name = "VAR_TEXT_FIELD_4", nullable = true, length = 350)
    public String getVarTextField4() {
        return varTextField4;
    }

    public void setVarTextField4(String varTextField4) {
        this.varTextField4 = varTextField4;
    }

    @Basic
    @Column(name = "VAR_TEXT_FIELD_5", nullable = true, length = 350)
    public String getVarTextField5() {
        return varTextField5;
    }

    public void setVarTextField5(String varTextField5) {
        this.varTextField5 = varTextField5;
    }

    @Basic
    @Column(name = "VAR_TEXT_FIELD_6", nullable = true, length = 350)
    public String getVarTextField6() {
        return varTextField6;
    }

    public void setVarTextField6(String varTextField6) {
        this.varTextField6 = varTextField6;
    }

    @Basic
    @Column(name = "VAR_TEXT_FIELD_7", nullable = true, length = 350)
    public String getVarTextField7() {
        return varTextField7;
    }

    public void setVarTextField7(String varTextField7) {
        this.varTextField7 = varTextField7;
    }

    @Basic
    @Column(name = "VAR_TEXT_FIELD_8", nullable = true, length = 350)
    public String getVarTextField8() {
        return varTextField8;
    }

    public void setVarTextField8(String varTextField8) {
        this.varTextField8 = varTextField8;
    }

    @Basic
    @Column(name = "VAR_TEXT_FIELD_9", nullable = true, length = 350)
    public String getVarTextField9() {
        return varTextField9;
    }

    public void setVarTextField9(String varTextField9) {
        this.varTextField9 = varTextField9;
    }

    @Basic
    @Column(name = "VAR_TEXT_FIELD_10", nullable = true, length = 350)
    public String getVarTextField10() {
        return varTextField10;
    }

    public void setVarTextField10(String varTextField10) {
        this.varTextField10 = varTextField10;
    }

    @Basic
    @Column(name = "VERSION", nullable = false, precision = 0)
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Basic
    @Column(name = "CREATEDBY", nullable = true, length = 100)
    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    @Basic
    @Column(name = "CREATEDON", nullable = true)
    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
    }

    @Basic
    @Column(name = "MODIFIEDBY", nullable = true, length = 100)
    public String getModifiedby() {
        return modifiedby;
    }

    public void setModifiedby(String modifiedby) {
        this.modifiedby = modifiedby;
    }

    @Basic
    @Column(name = "MODIFIED_ON", nullable = true)
    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    @Basic
    @Column(name = "DELETEBY", nullable = true, length = 100)
    public String getDeleteby() {
        return deleteby;
    }

    public void setDeleteby(String deleteby) {
        this.deleteby = deleteby;
    }

    @Basic
    @Column(name = "DELETEDON", nullable = true)
    public Date getDeletedon() {
        return deletedon;
    }

    public void setDeletedon(Date deletedon) {
        this.deletedon = deletedon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegistrationDetails that = (RegistrationDetails) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (acceptedTermsDate != null ? !acceptedTermsDate.equals(that.acceptedTermsDate) : that.acceptedTermsDate != null)
            return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (middleName != null ? !middleName.equals(that.middleName) : that.middleName != null) return false;
        if (userPin != null ? !userPin.equals(that.userPin) : that.userPin != null) return false;
        if (userMsisdn != null ? !userMsisdn.equals(that.userMsisdn) : that.userMsisdn != null) return false;
        if (userIdNumber != null ? !userIdNumber.equals(that.userIdNumber) : that.userIdNumber != null) return false;
        if (userRegistrationStatus != null ? !userRegistrationStatus.equals(that.userRegistrationStatus) : that.userRegistrationStatus != null)
            return false;
        if (registrationDate != null ? !registrationDate.equals(that.registrationDate) : that.registrationDate != null)
            return false;
        if (iprsValidationDate != null ? !iprsValidationDate.equals(that.iprsValidationDate) : that.iprsValidationDate != null)
            return false;
        if (loginActivationDate != null ? !loginActivationDate.equals(that.loginActivationDate) : that.loginActivationDate != null)
            return false;
        if (accountNumber != null ? !accountNumber.equals(that.accountNumber) : that.accountNumber != null)
            return false;
        if (varTextField1 != null ? !varTextField1.equals(that.varTextField1) : that.varTextField1 != null)
            return false;
        if (varTextField2 != null ? !varTextField2.equals(that.varTextField2) : that.varTextField2 != null)
            return false;
        if (varTextField3 != null ? !varTextField3.equals(that.varTextField3) : that.varTextField3 != null)
            return false;
        if (varTextField4 != null ? !varTextField4.equals(that.varTextField4) : that.varTextField4 != null)
            return false;
        if (varTextField5 != null ? !varTextField5.equals(that.varTextField5) : that.varTextField5 != null)
            return false;
        if (varTextField6 != null ? !varTextField6.equals(that.varTextField6) : that.varTextField6 != null)
            return false;
        if (varTextField7 != null ? !varTextField7.equals(that.varTextField7) : that.varTextField7 != null)
            return false;
        if (varTextField8 != null ? !varTextField8.equals(that.varTextField8) : that.varTextField8 != null)
            return false;
        if (varTextField9 != null ? !varTextField9.equals(that.varTextField9) : that.varTextField9 != null)
            return false;
        if (varTextField10 != null ? !varTextField10.equals(that.varTextField10) : that.varTextField10 != null)
            return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;
        if (createdby != null ? !createdby.equals(that.createdby) : that.createdby != null) return false;
        if (createdon != null ? !createdon.equals(that.createdon) : that.createdon != null) return false;
        if (modifiedby != null ? !modifiedby.equals(that.modifiedby) : that.modifiedby != null) return false;
        if (modifiedOn != null ? !modifiedOn.equals(that.modifiedOn) : that.modifiedOn != null) return false;
        if (deleteby != null ? !deleteby.equals(that.deleteby) : that.deleteby != null) return false;
        if (deletedon != null ? !deletedon.equals(that.deletedon) : that.deletedon != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;

        result = 31 * result + (acceptedTermsDate != null ? acceptedTermsDate.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (userPin != null ? userPin.hashCode() : 0);
        result = 31 * result + (userMsisdn != null ? userMsisdn.hashCode() : 0);
        result = 31 * result + (userIdNumber != null ? userIdNumber.hashCode() : 0);
        result = 31 * result + (userRegistrationStatus != null ? userRegistrationStatus.hashCode() : 0);
        result = 31 * result + (registrationDate != null ? registrationDate.hashCode() : 0);
        result = 31 * result + (iprsValidationDate != null ? iprsValidationDate.hashCode() : 0);
        result = 31 * result + (loginActivationDate != null ? loginActivationDate.hashCode() : 0);
        result = 31 * result + (accountNumber != null ? accountNumber.hashCode() : 0);
        result = 31 * result + (varTextField1 != null ? varTextField1.hashCode() : 0);
        result = 31 * result + (varTextField2 != null ? varTextField2.hashCode() : 0);
        result = 31 * result + (varTextField3 != null ? varTextField3.hashCode() : 0);
        result = 31 * result + (varTextField4 != null ? varTextField4.hashCode() : 0);
        result = 31 * result + (varTextField5 != null ? varTextField5.hashCode() : 0);
        result = 31 * result + (varTextField6 != null ? varTextField6.hashCode() : 0);
        result = 31 * result + (varTextField7 != null ? varTextField7.hashCode() : 0);
        result = 31 * result + (varTextField8 != null ? varTextField8.hashCode() : 0);
        result = 31 * result + (varTextField9 != null ? varTextField9.hashCode() : 0);
        result = 31 * result + (varTextField10 != null ? varTextField10.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (createdby != null ? createdby.hashCode() : 0);
        result = 31 * result + (createdon != null ? createdon.hashCode() : 0);
        result = 31 * result + (modifiedby != null ? modifiedby.hashCode() : 0);
        result = 31 * result + (modifiedOn != null ? modifiedOn.hashCode() : 0);
        result = 31 * result + (deleteby != null ? deleteby.hashCode() : 0);
        result = 31 * result + (deletedon != null ? deletedon.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "registrationDetails")
    public Collection<Principals> getAdmPrincipalsById() {
        return admPrincipalsById;
    }

    public void setAdmPrincipalsById(Collection<Principals> admPrincipalsById) {
        this.admPrincipalsById = admPrincipalsById;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID_DOC_TYPE", referencedColumnName = "ID", nullable = false)
    public RegistrationDocs getUserIdDocType() {
        return userIdDocType;
    }

    public void setUserIdDocType(RegistrationDocs userIdDocType) {
        this.userIdDocType = userIdDocType;
    }

    @ManyToOne
    @JoinColumn(name = "SERVICE_REQUEST", referencedColumnName = "ID", nullable = false)
    public ServiceRequests getServiceRequest() {
        return serviceRequest;
    }

    public void setServiceRequest(ServiceRequests serviceRequest) {
        this.serviceRequest = serviceRequest;
    }

    @ManyToOne
    @JoinColumn(name = "ORGANISATION", referencedColumnName = "ID")
    public Organizations getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organizations organisation) {
        this.organisation = organisation;
    }
}
