package org.muhia.app.psi.orm.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/*
  Created by Kenneth
  Project: psi
  Package: org.muhia.apps.psi.orm.model
  Generated on: 30-Mar-17, 08:40.
 */
@Entity
@Table(name = "ADM_PRINCIPALS", schema = "PSI")
@EntityListeners(AuditingEntityListener.class)
@XmlRootElement
public class Principals {
    private Long id;
    private String fullname;
    private String prefferredName;
    private String loginName;
    private String credentials;
    private String membershipNo;
    private String phonenumber;
    private String cellphonenumber;
    private String faxnumber;
    private String emailaddress;
    private Integer status;
    private String createdby;
    private Date createdon;
    private String modifiedby;
    private Date modifiedon;
    private String deleteby;
    private Date deletedon;
    private String passwordsConfirmation;
    private String picturepath;
    private PrincipalTypes principalType;
    private Titles title;
    private RegistrationDetails registrationDetails;
    private Collection<UserRoles> admUserRolesById;
    private Collection<UserSecurityQuestions> admUserSecurityQuestionsById;
    private Collection<UssdSessions> admUssdSessionsById;
    private Collection<RecurringOrders> crmRecurringOrdersById;
    private Collection<PrincipalsContributions> datPrincipalsContributionsById;
    private Collection<PrincipalsGuarantor> datPrincipalsGuarantorsById;
    private Collection<PrincipalsGuarantor> datPrincipalsGuarantorsById_0;
    private Collection<PrincipalsLoans> datPrincipalsLoansById;
    private Collection<PrincipalsLoans> datPrincipalsLoansById_0;
    private Collection<PrincipalsSavingsTarget> datPrincipalsSavingsTargetById;
    private Collection<SaccoRegistration> datSaccoRegistrationsById;
    private Collection<UserBeneficiaries> datUserBeneficiariesById;
    private Collection<UserRoles> admUserRolesCollection;
    private Collection<BankAccounts> bankAccounts;

    public void setId(long id) {
        this.id = id;
    }



    public void setCreatedon(Time createdon) {
        this.createdon = createdon;
    }

    public void setModifiedon(Time modifiedon) {
        this.modifiedon = modifiedon;
    }

    public void setDeletedon(Time deletedon) {
        this.deletedon = deletedon;
    }

    @Id
    @SequenceGenerator(name = "ADM_PRINCIPALS_SEQ_GEN", sequenceName = "ADM_PRINCIPALS_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "ADM_PRINCIPALS_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "FULLNAME", nullable = false, length = 500)
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Basic
    @Column(name = "PREFFERRED_NAME", length = 500)
    public String getPrefferredName() {
        return prefferredName;
    }

    public void setPrefferredName(String prefferredName) {
        this.prefferredName = prefferredName;
    }

    @Basic
    @Column(name = "LOGIN_NAME", nullable = false, length = 300)
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Basic
    @Column(name = "CREDENTIALS", nullable = false, length = 1800)
    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    @Basic
    @Column(name = "MEMBERSHIP_NO", length = 1800)
    public String getMembershipNo() {
        return membershipNo;
    }

    public void setMembershipNo(String membershipNo) {
        this.membershipNo = membershipNo;
    }

    @Basic
    @Column(name = "PHONENUMBER", length = 20)
    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Basic
    @Column(name = "CELLPHONENUMBER", length = 20)
    public String getCellphonenumber() {
        return cellphonenumber;
    }

    public void setCellphonenumber(String cellphonenumber) {
        this.cellphonenumber = cellphonenumber;
    }

    @Basic
    @Column(name = "FAXNUMBER", length = 20)
    public String getFaxnumber() {
        return faxnumber;
    }

    public void setFaxnumber(String faxnumber) {
        this.faxnumber = faxnumber;
    }

    @Basic
    @Column(name = "EMAILADDRESS", length = 256)
    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    @Basic
    @Column(name = "STATUS", nullable = false)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "CREATEDBY", length = 100)
    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATEDON")
    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
    }

    @Basic
    @Column(name = "MODIFIEDBY", length = 100)
    public String getModifiedby() {
        return modifiedby;
    }

    public void setModifiedby(String modifiedby) {
        this.modifiedby = modifiedby;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFIEDON")
    public Date getModifiedon() {
        return modifiedon;
    }

    public void setModifiedon(Date modifiedon) {
        this.modifiedon = modifiedon;
    }

    @Basic
    @Column(name = "DELETEBY", length = 100)
    public String getDeleteby() {
        return deleteby;
    }

    public void setDeleteby(String deleteby) {
        this.deleteby = deleteby;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DELETEDON")
    public Date getDeletedon() {
        return deletedon;
    }

    public void setDeletedon(Date deletedon) {
        this.deletedon = deletedon;
    }

    @Basic
    @Column(name = "PASSWORDS_CONFIRMATION", length = 1800)
    public String getPasswordsConfirmation() {
        return passwordsConfirmation;
    }

    public void setPasswordsConfirmation(String passwordsConfirmation) {
        this.passwordsConfirmation = passwordsConfirmation;
    }

    @Basic
    @Column(name = "PICTUREPATH", length = 100)
    public String getPicturepath() {
        return picturepath;
    }

    public void setPicturepath(String picturepath) {
        this.picturepath = picturepath;
    }

    @ManyToOne
    @JoinColumn(name = "PRINCIPAL_TYPE", referencedColumnName = "ID", nullable = false)
    public PrincipalTypes getPrincipalType() {
        return principalType;
    }

    public void setPrincipalType(PrincipalTypes admPrincipalTypesByPrincipalType) {
        this.principalType = admPrincipalTypesByPrincipalType;
    }

    @ManyToOne
    @JoinColumn(name = "TITLE", referencedColumnName = "ID")
    public Titles getTitle() {
        return title;
    }

    public void setTitle(Titles refTitlesByTitle) {
        this.title = refTitlesByTitle;
    }

    @ManyToOne
    @JoinColumn(name = "REGISTRATION_DETAILS", referencedColumnName = "ID")
    public RegistrationDetails getRegistrationDetails() {
        return registrationDetails;
    }

    public void setRegistrationDetails(RegistrationDetails datRegistrationDetailsByRegistrationDetails) {
        this.registrationDetails = datRegistrationDetailsByRegistrationDetails;
    }

    @OneToMany(mappedBy = "userid")
    public Collection<UserRoles> getAdmUserRolesById() {
        return admUserRolesById;
    }

    public void setAdmUserRolesById(Collection<UserRoles> admUserRolesById) {
        this.admUserRolesById = admUserRolesById;
    }

    @OneToMany(mappedBy = "userId")
    public Collection<UserSecurityQuestions> getAdmUserSecurityQuestionsById() {
        return admUserSecurityQuestionsById;
    }

    public void setAdmUserSecurityQuestionsById(Collection<UserSecurityQuestions> admUserSecurityQuestionsById) {
        this.admUserSecurityQuestionsById = admUserSecurityQuestionsById;
    }

    @OneToMany(mappedBy = "userId")
    public Collection<UssdSessions> getAdmUssdSessionsById() {
        return admUssdSessionsById;
    }

    public void setAdmUssdSessionsById(Collection<UssdSessions> admUssdSessionsById) {
        this.admUssdSessionsById = admUssdSessionsById;
    }

    @OneToMany(mappedBy = "toBill")
    public Collection<RecurringOrders> getCrmRecurringOrdersById() {
        return crmRecurringOrdersById;
    }

    public void setCrmRecurringOrdersById(Collection<RecurringOrders> crmRecurringOrdersById) {
        this.crmRecurringOrdersById = crmRecurringOrdersById;
    }

    @OneToMany(mappedBy = "principal")
    public Collection<PrincipalsContributions> getDatPrincipalsContributionsById() {
        return datPrincipalsContributionsById;
    }

    public void setDatPrincipalsContributionsById(Collection<PrincipalsContributions> datPrincipalsContributionsById) {
        this.datPrincipalsContributionsById = datPrincipalsContributionsById;
    }

    @OneToMany(mappedBy = "principal")
    public Collection<PrincipalsGuarantor> getDatPrincipalsGuarantorsById() {
        return datPrincipalsGuarantorsById;
    }

    public void setDatPrincipalsGuarantorsById(Collection<PrincipalsGuarantor> datPrincipalsGuarantorsById) {
        this.datPrincipalsGuarantorsById = datPrincipalsGuarantorsById;
    }

    @OneToMany(mappedBy = "guarantor")
    public Collection<PrincipalsGuarantor> getDatPrincipalsGuarantorsById_0() {
        return datPrincipalsGuarantorsById_0;
    }

    public void setDatPrincipalsGuarantorsById_0(Collection<PrincipalsGuarantor> datPrincipalsGuarantorsById_0) {
        this.datPrincipalsGuarantorsById_0 = datPrincipalsGuarantorsById_0;
    }

    @OneToMany(mappedBy = "principal")
    public Collection<PrincipalsLoans> getDatPrincipalsLoansById() {
        return datPrincipalsLoansById;
    }

    public void setDatPrincipalsLoansById(Collection<PrincipalsLoans> datPrincipalsLoansById) {
        this.datPrincipalsLoansById = datPrincipalsLoansById;
    }

    @OneToMany(mappedBy = "lender")
    public Collection<PrincipalsLoans> getDatPrincipalsLoansById_0() {
        return datPrincipalsLoansById_0;
    }

    public void setDatPrincipalsLoansById_0(Collection<PrincipalsLoans> datPrincipalsLoansById_0) {
        this.datPrincipalsLoansById_0 = datPrincipalsLoansById_0;
    }

    @OneToMany(mappedBy = "principal")
    public Collection<PrincipalsSavingsTarget> getDatPrincipalsSavingsTargetById() {
        return datPrincipalsSavingsTargetById;
    }

    public void setDatPrincipalsSavingsTargetById(Collection<PrincipalsSavingsTarget> datPrincipalsSavingsTargetById) {
        this.datPrincipalsSavingsTargetById = datPrincipalsSavingsTargetById;
    }

    @OneToMany(mappedBy = "userId")
    public Collection<SaccoRegistration> getDatSaccoRegistrationsById() {
        return datSaccoRegistrationsById;
    }

    public void setDatSaccoRegistrationsById(Collection<SaccoRegistration> datSaccoRegistrationsById) {
        this.datSaccoRegistrationsById = datSaccoRegistrationsById;
    }

    @OneToMany(mappedBy = "principal")
    public Collection<UserBeneficiaries> getDatUserBeneficiariesById() {
        return datUserBeneficiariesById;
    }

    public void setDatUserBeneficiariesById(Collection<UserBeneficiaries> datUserBeneficiariesById) {
        this.datUserBeneficiariesById = datUserBeneficiariesById;
    }

    @OneToMany(mappedBy = "userid", fetch = FetchType.EAGER)
    public Collection<UserRoles> getAdmUserRolesCollection() {
        return admUserRolesCollection;
    }

    public void setAdmUserRolesCollection(Collection<UserRoles> admUserRolesCollection) {
        this.admUserRolesCollection = admUserRolesCollection;
    }

    @Transient
    public Collection<GrantedAuthority> getGrantedAuthorities() {
        final Collection<GrantedAuthority> authorities = new ArrayList<>();
        this.getAdmUserRolesCollection().forEach(userRoles -> authorities.add(new SimpleGrantedAuthority(userRoles.getRoleid().getRolename())));

        return authorities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Principals that = (Principals) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (fullname != null ? !fullname.equals(that.fullname) : that.fullname != null) return false;
        if (prefferredName != null ? !prefferredName.equals(that.prefferredName) : that.prefferredName != null)
            return false;
        if (loginName != null ? !loginName.equals(that.loginName) : that.loginName != null) return false;
        if (credentials != null ? !credentials.equals(that.credentials) : that.credentials != null) return false;
        if (membershipNo != null ? !membershipNo.equals(that.membershipNo) : that.membershipNo != null) return false;
        if (phonenumber != null ? !phonenumber.equals(that.phonenumber) : that.phonenumber != null) return false;
        if (cellphonenumber != null ? !cellphonenumber.equals(that.cellphonenumber) : that.cellphonenumber != null)
            return false;
        if (faxnumber != null ? !faxnumber.equals(that.faxnumber) : that.faxnumber != null) return false;
        if (emailaddress != null ? !emailaddress.equals(that.emailaddress) : that.emailaddress != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (createdby != null ? !createdby.equals(that.createdby) : that.createdby != null) return false;
        if (createdon != null ? !createdon.equals(that.createdon) : that.createdon != null) return false;
        if (modifiedby != null ? !modifiedby.equals(that.modifiedby) : that.modifiedby != null) return false;
        if (modifiedon != null ? !modifiedon.equals(that.modifiedon) : that.modifiedon != null) return false;
        if (deleteby != null ? !deleteby.equals(that.deleteby) : that.deleteby != null) return false;
        if (deletedon != null ? !deletedon.equals(that.deletedon) : that.deletedon != null) return false;
        if (passwordsConfirmation != null ? !passwordsConfirmation.equals(that.passwordsConfirmation) : that.passwordsConfirmation != null)
            return false;
        if (picturepath != null ? !picturepath.equals(that.picturepath) : that.picturepath != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
        result = 31 * result + (prefferredName != null ? prefferredName.hashCode() : 0);
        result = 31 * result + (loginName != null ? loginName.hashCode() : 0);
        result = 31 * result + (credentials != null ? credentials.hashCode() : 0);
        result = 31 * result + (membershipNo != null ? membershipNo.hashCode() : 0);
        result = 31 * result + (phonenumber != null ? phonenumber.hashCode() : 0);
        result = 31 * result + (cellphonenumber != null ? cellphonenumber.hashCode() : 0);
        result = 31 * result + (faxnumber != null ? faxnumber.hashCode() : 0);
        result = 31 * result + (emailaddress != null ? emailaddress.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createdby != null ? createdby.hashCode() : 0);
        result = 31 * result + (createdon != null ? createdon.hashCode() : 0);
        result = 31 * result + (modifiedby != null ? modifiedby.hashCode() : 0);
        result = 31 * result + (modifiedon != null ? modifiedon.hashCode() : 0);
        result = 31 * result + (deleteby != null ? deleteby.hashCode() : 0);
        result = 31 * result + (deletedon != null ? deletedon.hashCode() : 0);
        result = 31 * result + (passwordsConfirmation != null ? passwordsConfirmation.hashCode() : 0);
        result = 31 * result + (picturepath != null ? picturepath.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userId")
    public Collection<BankAccounts> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(Collection<BankAccounts> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}
