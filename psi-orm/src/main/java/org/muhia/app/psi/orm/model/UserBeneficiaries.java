package org.muhia.app.psi.orm.model;

import javax.persistence.*;
import java.util.Date;;

/*
  Created by Kenneth
  Project: psi
  Package: org.muhia.apps.psi.orm.model
  Generated on: 30-Mar-17, 08:42.
 */
@Entity
@Table(name = "DAT_USER_BENEFICIARIES")
public class UserBeneficiaries {
    private Long id;
    private String beneficiary;
    private String beneficiaryIdNumber;
    private String beneficiaryAddress;
    private String beneficiaryEmail;
    private String beneficiaryTelephone;
    private Long beneficiaryPercentage;
    private String createdby;
    private Date createdon;
    private String modifiedby;
    private Date modifiedon;
    private String validatedby;
    private Date validatedon;
    private String approvedby;
    private Date approvedon;
    private String deleteby;
    private Date deletedon;
    private String status;
    private Principals principal;
    private BeneficiaryTypes relationship;

    @Id
    @SequenceGenerator(name = "DAT_USER_BENEFICIARIES_SEQ_GEN", sequenceName = "DAT_USER_BENEFICIARIES_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "DAT_USER_BENEFICIARIES_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "BENEFICIARY", nullable = false, length = 200)
    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    @Basic
    @Column(name = "BENEFICIARY_ID_NUMBER", nullable = true, length = 200)
    public String getBeneficiaryIdNumber() {
        return beneficiaryIdNumber;
    }

    public void setBeneficiaryIdNumber(String beneficiaryIdNumber) {
        this.beneficiaryIdNumber = beneficiaryIdNumber;
    }

    @Basic
    @Column(name = "BENEFICIARY_ADDRESS", nullable = true, length = 500)
    public String getBeneficiaryAddress() {
        return beneficiaryAddress;
    }

    public void setBeneficiaryAddress(String beneficiaryAddress) {
        this.beneficiaryAddress = beneficiaryAddress;
    }

    @Basic
    @Column(name = "BENEFICIARY_EMAIL", nullable = true, length = 200)
    public String getBeneficiaryEmail() {
        return beneficiaryEmail;
    }

    public void setBeneficiaryEmail(String beneficiaryEmail) {
        this.beneficiaryEmail = beneficiaryEmail;
    }

    @Basic
    @Column(name = "BENEFICIARY_TELEPHONE", nullable = true, length = 200)
    public String getBeneficiaryTelephone() {
        return beneficiaryTelephone;
    }

    public void setBeneficiaryTelephone(String beneficiaryTelephone) {
        this.beneficiaryTelephone = beneficiaryTelephone;
    }

    @Basic
    @Column(name = "BENEFICIARY_PERCENTAGE", nullable = false, precision = 0)
    public Long getBeneficiaryPercentage() {
        return beneficiaryPercentage;
    }

    public void setBeneficiaryPercentage(Long beneficiaryPercentage) {
        this.beneficiaryPercentage = beneficiaryPercentage;
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
    @Column(name = "MODIFIEDON", nullable = true)
    public Date getModifiedon() {
        return modifiedon;
    }

    public void setModifiedon(Date modifiedon) {
        this.modifiedon = modifiedon;
    }

    @Basic
    @Column(name = "VALIDATEDBY", nullable = true, length = 100)
    public String getValidatedby() {
        return validatedby;
    }

    public void setValidatedby(String validatedby) {
        this.validatedby = validatedby;
    }

    @Basic
    @Column(name = "VALIDATEDON", nullable = true)
    public Date getValidatedon() {
        return validatedon;
    }

    public void setValidatedon(Date validatedon) {
        this.validatedon = validatedon;
    }

    @Basic
    @Column(name = "APPROVEDBY", nullable = true, length = 100)
    public String getApprovedby() {
        return approvedby;
    }

    public void setApprovedby(String approvedby) {
        this.approvedby = approvedby;
    }

    @Basic
    @Column(name = "APPROVEDON", nullable = true)
    public Date getApprovedon() {
        return approvedon;
    }

    public void setApprovedon(Date approvedon) {
        this.approvedon = approvedon;
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

    @Basic
    @Column(name = "STATUS", nullable = true, length = 30)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserBeneficiaries that = (UserBeneficiaries) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (beneficiary != null ? !beneficiary.equals(that.beneficiary) : that.beneficiary != null) return false;
        if (beneficiaryIdNumber != null ? !beneficiaryIdNumber.equals(that.beneficiaryIdNumber) : that.beneficiaryIdNumber != null)
            return false;
        if (beneficiaryAddress != null ? !beneficiaryAddress.equals(that.beneficiaryAddress) : that.beneficiaryAddress != null)
            return false;
        if (beneficiaryEmail != null ? !beneficiaryEmail.equals(that.beneficiaryEmail) : that.beneficiaryEmail != null)
            return false;
        if (beneficiaryTelephone != null ? !beneficiaryTelephone.equals(that.beneficiaryTelephone) : that.beneficiaryTelephone != null)
            return false;
        if (beneficiaryPercentage != null ? !beneficiaryPercentage.equals(that.beneficiaryPercentage) : that.beneficiaryPercentage != null)
            return false;
        if (createdby != null ? !createdby.equals(that.createdby) : that.createdby != null) return false;
        if (createdon != null ? !createdon.equals(that.createdon) : that.createdon != null) return false;
        if (modifiedby != null ? !modifiedby.equals(that.modifiedby) : that.modifiedby != null) return false;
        if (modifiedon != null ? !modifiedon.equals(that.modifiedon) : that.modifiedon != null) return false;
        if (validatedby != null ? !validatedby.equals(that.validatedby) : that.validatedby != null) return false;
        if (validatedon != null ? !validatedon.equals(that.validatedon) : that.validatedon != null) return false;
        if (approvedby != null ? !approvedby.equals(that.approvedby) : that.approvedby != null) return false;
        if (approvedon != null ? !approvedon.equals(that.approvedon) : that.approvedon != null) return false;
        if (deleteby != null ? !deleteby.equals(that.deleteby) : that.deleteby != null) return false;
        if (deletedon != null ? !deletedon.equals(that.deletedon) : that.deletedon != null) return false;
        //if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (beneficiary != null ? beneficiary.hashCode() : 0);
        result = 31 * result + (beneficiaryIdNumber != null ? beneficiaryIdNumber.hashCode() : 0);
        result = 31 * result + (beneficiaryAddress != null ? beneficiaryAddress.hashCode() : 0);
        result = 31 * result + (beneficiaryEmail != null ? beneficiaryEmail.hashCode() : 0);
        result = 31 * result + (beneficiaryTelephone != null ? beneficiaryTelephone.hashCode() : 0);
        result = 31 * result + (beneficiaryPercentage != null ? beneficiaryPercentage.hashCode() : 0);
        result = 31 * result + (createdby != null ? createdby.hashCode() : 0);
        result = 31 * result + (createdon != null ? createdon.hashCode() : 0);
        result = 31 * result + (modifiedby != null ? modifiedby.hashCode() : 0);
        result = 31 * result + (modifiedon != null ? modifiedon.hashCode() : 0);
        result = 31 * result + (validatedby != null ? validatedby.hashCode() : 0);
        result = 31 * result + (validatedon != null ? validatedon.hashCode() : 0);
        result = 31 * result + (approvedby != null ? approvedby.hashCode() : 0);
        result = 31 * result + (approvedon != null ? approvedon.hashCode() : 0);
        result = 31 * result + (deleteby != null ? deleteby.hashCode() : 0);
        result = 31 * result + (deletedon != null ? deletedon.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "PRINCIPAL", referencedColumnName = "ID")
    public Principals getPrincipal() {
        return principal;
    }

    public void setPrincipal(Principals principal) {
        this.principal = principal;
    }

    @ManyToOne
    @JoinColumn(name = "RELATIONSHIP", referencedColumnName = "ID")
    public BeneficiaryTypes getRelationship() {
        return relationship;
    }

    public void setRelationship(BeneficiaryTypes relationship) {
        this.relationship = relationship;
    }
}
