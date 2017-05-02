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
@Table(name = "DAT_SACCO_REGISTRATION")
public class SaccoRegistration {
    private Long id;
    private String documentNumber;
    private String membershipNo;
    private String placeHolder1;
    private String placeHolder1Desc;
    private String placeHolder2;
    private String placeHolder2Desc;
    private String placeHolder3;
    private String placeHolder3Desc;
    private String placeHolder4;
    private String placeHolder4Desc;
    private String placeHolder5;
    private String placeHolder5Desc;
    private String createdby;
    private Date createdon;
    private String modifiedby;
    private Date modifiedon;
    private String deleteby;
    private Date deletedon;
    private Principals userId;
    private RegistrationDocs registrationDocType;
    private RegisteredSaccos sacco;

    @Id
    @SequenceGenerator(name ="DAT_SACCO_REGISTRATION_SEQ_GEN", sequenceName = "DAT_SACCO_REGISTRATION_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "DAT_SACCO_REGISTRATION_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "DOCUMENT_NUMBER", nullable = false, length = 100)
    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    @Basic
    @Column(name = "MEMBERSHIP_NO", nullable = false, length = 100)
    public String getMembershipNo() {
        return membershipNo;
    }

    public void setMembershipNo(String membershipNo) {
        this.membershipNo = membershipNo;
    }

    @Basic
    @Column(name = "PLACE_HOLDER1", nullable = true, length = 200)
    public String getPlaceHolder1() {
        return placeHolder1;
    }

    public void setPlaceHolder1(String placeHolder1) {
        this.placeHolder1 = placeHolder1;
    }

    @Basic
    @Column(name = "PLACE_HOLDER1_DESC", nullable = true, length = 200)
    public String getPlaceHolder1Desc() {
        return placeHolder1Desc;
    }

    public void setPlaceHolder1Desc(String placeHolder1Desc) {
        this.placeHolder1Desc = placeHolder1Desc;
    }

    @Basic
    @Column(name = "PLACE_HOLDER2", nullable = true, length = 100)
    public String getPlaceHolder2() {
        return placeHolder2;
    }

    public void setPlaceHolder2(String placeHolder2) {
        this.placeHolder2 = placeHolder2;
    }

    @Basic
    @Column(name = "PLACE_HOLDER2_DESC", nullable = true, length = 200)
    public String getPlaceHolder2Desc() {
        return placeHolder2Desc;
    }

    public void setPlaceHolder2Desc(String placeHolder2Desc) {
        this.placeHolder2Desc = placeHolder2Desc;
    }

    @Basic
    @Column(name = "PLACE_HOLDER3", nullable = true, length = 100)
    public String getPlaceHolder3() {
        return placeHolder3;
    }

    public void setPlaceHolder3(String placeHolder3) {
        this.placeHolder3 = placeHolder3;
    }

    @Basic
    @Column(name = "PLACE_HOLDER3_DESC", nullable = true, length = 200)
    public String getPlaceHolder3Desc() {
        return placeHolder3Desc;
    }

    public void setPlaceHolder3Desc(String placeHolder3Desc) {
        this.placeHolder3Desc = placeHolder3Desc;
    }

    @Basic
    @Column(name = "PLACE_HOLDER4", nullable = true, length = 100)
    public String getPlaceHolder4() {
        return placeHolder4;
    }

    public void setPlaceHolder4(String placeHolder4) {
        this.placeHolder4 = placeHolder4;
    }

    @Basic
    @Column(name = "PLACE_HOLDER4_DESC", nullable = true, length = 100)
    public String getPlaceHolder4Desc() {
        return placeHolder4Desc;
    }

    public void setPlaceHolder4Desc(String placeHolder4Desc) {
        this.placeHolder4Desc = placeHolder4Desc;
    }

    @Basic
    @Column(name = "PLACE_HOLDER5", nullable = true, length = 100)
    public String getPlaceHolder5() {
        return placeHolder5;
    }

    public void setPlaceHolder5(String placeHolder5) {
        this.placeHolder5 = placeHolder5;
    }

    @Basic
    @Column(name = "PLACE_HOLDER5_DESC", nullable = true, length = 200)
    public String getPlaceHolder5Desc() {
        return placeHolder5Desc;
    }

    public void setPlaceHolder5Desc(String placeHolder5Desc) {
        this.placeHolder5Desc = placeHolder5Desc;
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

        SaccoRegistration that = (SaccoRegistration) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (documentNumber != null ? !documentNumber.equals(that.documentNumber) : that.documentNumber != null)
            return false;
        if (membershipNo != null ? !membershipNo.equals(that.membershipNo) : that.membershipNo != null) return false;
        if (placeHolder1 != null ? !placeHolder1.equals(that.placeHolder1) : that.placeHolder1 != null) return false;
        if (placeHolder1Desc != null ? !placeHolder1Desc.equals(that.placeHolder1Desc) : that.placeHolder1Desc != null)
            return false;
        if (placeHolder2 != null ? !placeHolder2.equals(that.placeHolder2) : that.placeHolder2 != null) return false;
        if (placeHolder2Desc != null ? !placeHolder2Desc.equals(that.placeHolder2Desc) : that.placeHolder2Desc != null)
            return false;
        if (placeHolder3 != null ? !placeHolder3.equals(that.placeHolder3) : that.placeHolder3 != null) return false;
        if (placeHolder3Desc != null ? !placeHolder3Desc.equals(that.placeHolder3Desc) : that.placeHolder3Desc != null)
            return false;
        if (placeHolder4 != null ? !placeHolder4.equals(that.placeHolder4) : that.placeHolder4 != null) return false;
        if (placeHolder4Desc != null ? !placeHolder4Desc.equals(that.placeHolder4Desc) : that.placeHolder4Desc != null)
            return false;
        if (placeHolder5 != null ? !placeHolder5.equals(that.placeHolder5) : that.placeHolder5 != null) return false;
        if (placeHolder5Desc != null ? !placeHolder5Desc.equals(that.placeHolder5Desc) : that.placeHolder5Desc != null)
            return false;
        if (createdby != null ? !createdby.equals(that.createdby) : that.createdby != null) return false;
        if (createdon != null ? !createdon.equals(that.createdon) : that.createdon != null) return false;
        if (modifiedby != null ? !modifiedby.equals(that.modifiedby) : that.modifiedby != null) return false;
        if (modifiedon != null ? !modifiedon.equals(that.modifiedon) : that.modifiedon != null) return false;
        if (deleteby != null ? !deleteby.equals(that.deleteby) : that.deleteby != null) return false;
        if (deletedon != null ? !deletedon.equals(that.deletedon) : that.deletedon != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (documentNumber != null ? documentNumber.hashCode() : 0);
        result = 31 * result + (membershipNo != null ? membershipNo.hashCode() : 0);
        result = 31 * result + (placeHolder1 != null ? placeHolder1.hashCode() : 0);
        result = 31 * result + (placeHolder1Desc != null ? placeHolder1Desc.hashCode() : 0);
        result = 31 * result + (placeHolder2 != null ? placeHolder2.hashCode() : 0);
        result = 31 * result + (placeHolder2Desc != null ? placeHolder2Desc.hashCode() : 0);
        result = 31 * result + (placeHolder3 != null ? placeHolder3.hashCode() : 0);
        result = 31 * result + (placeHolder3Desc != null ? placeHolder3Desc.hashCode() : 0);
        result = 31 * result + (placeHolder4 != null ? placeHolder4.hashCode() : 0);
        result = 31 * result + (placeHolder4Desc != null ? placeHolder4Desc.hashCode() : 0);
        result = 31 * result + (placeHolder5 != null ? placeHolder5.hashCode() : 0);
        result = 31 * result + (placeHolder5Desc != null ? placeHolder5Desc.hashCode() : 0);
        result = 31 * result + (createdby != null ? createdby.hashCode() : 0);
        result = 31 * result + (createdon != null ? createdon.hashCode() : 0);
        result = 31 * result + (modifiedby != null ? modifiedby.hashCode() : 0);
        result = 31 * result + (modifiedon != null ? modifiedon.hashCode() : 0);
        result = 31 * result + (deleteby != null ? deleteby.hashCode() : 0);
        result = 31 * result + (deletedon != null ? deletedon.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    public Principals getUserId() {
        return userId;
    }

    public void setUserId(Principals userId) {
        this.userId = userId;
    }

    @ManyToOne
    @JoinColumn(name = "REGISTRATION_DOC_TYPE", referencedColumnName = "ID", nullable = false)
    public RegistrationDocs getRegistrationDocType() {
        return registrationDocType;
    }

    public void setRegistrationDocType(RegistrationDocs registrationDocType) {
        this.registrationDocType = registrationDocType;
    }

    @ManyToOne
    @JoinColumn(name = "SACCO", referencedColumnName = "ID")
    public RegisteredSaccos getSacco() {
        return sacco;
    }

    public void setSacco(RegisteredSaccos sacco) {
        this.sacco = sacco;
    }
}
