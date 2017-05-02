package org.muhia.app.psi.orm.model;

import javax.persistence.*;
import java.util.Date;;
import java.util.Collection;

/*
  Created by Kenneth
  Project: psi
  Package: org.muhia.apps.psi.orm.model
  Generated on: 30-Mar-17, 08:40.
 */
@Entity
@Table(name = "ADM_ORGANIZATIONS")
public class Organizations {
    private Long id;
    private String organization;
    private Integer status;
    private String createdby;
    private Date createdon;
    private String modifiedby;
    private Date modifiedon;
    private String deleteby;
    private Date deletedon;
    private Long parentOrganizations;
    private Long organizationType;
    private Collection<RegistrationDetails> datRegistrationDetailsById;
    private Collection<UssdCodes> datUssdCodesById;

    @Id
    @SequenceGenerator(name = "ADM_ORGANIZATIONS_ID_GENERATOR", sequenceName = "ADM_ORGANIZATIONS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADM_ORGANIZATIONS_ID_GENERATOR")
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ORGANIZATION", nullable = true, length = 100)
    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Basic
    @Column(name = "STATUS", nullable = true, precision = 0)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    @Basic
    @Column(name = "PARENT_ORGANIZATIONS", nullable = true, precision = 0)
    public Long getParentOrganizations() {
        return parentOrganizations;
    }

    public void setParentOrganizations(Long parentOrganizations) {
        this.parentOrganizations = parentOrganizations;
    }

    @Basic
    @Column(name = "ORGANIZATION_TYPE", nullable = true, precision = 0)
    public Long getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(Long organizationType) {
        this.organizationType = organizationType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organizations that = (Organizations) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (organization != null ? !organization.equals(that.organization) : that.organization != null) return false;
        //if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (createdby != null ? !createdby.equals(that.createdby) : that.createdby != null) return false;
        if (createdon != null ? !createdon.equals(that.createdon) : that.createdon != null) return false;
        if (modifiedby != null ? !modifiedby.equals(that.modifiedby) : that.modifiedby != null) return false;
        if (modifiedon != null ? !modifiedon.equals(that.modifiedon) : that.modifiedon != null) return false;
        if (deleteby != null ? !deleteby.equals(that.deleteby) : that.deleteby != null) return false;
        if (deletedon != null ? !deletedon.equals(that.deletedon) : that.deletedon != null) return false;
        if (parentOrganizations != null ? !parentOrganizations.equals(that.parentOrganizations) : that.parentOrganizations != null)
            return false;
        if (organizationType != null ? !organizationType.equals(that.organizationType) : that.organizationType != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (organization != null ? organization.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createdby != null ? createdby.hashCode() : 0);
        result = 31 * result + (createdon != null ? createdon.hashCode() : 0);
        result = 31 * result + (modifiedby != null ? modifiedby.hashCode() : 0);
        result = 31 * result + (modifiedon != null ? modifiedon.hashCode() : 0);
        result = 31 * result + (deleteby != null ? deleteby.hashCode() : 0);
        result = 31 * result + (deletedon != null ? deletedon.hashCode() : 0);
        result = 31 * result + (parentOrganizations != null ? parentOrganizations.hashCode() : 0);
        result = 31 * result + (organizationType != null ? organizationType.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "organisation")
    public Collection<RegistrationDetails> getDatRegistrationDetailsById() {
        return datRegistrationDetailsById;
    }

    public void setDatRegistrationDetailsById(Collection<RegistrationDetails> datRegistrationDetailsById) {
        this.datRegistrationDetailsById = datRegistrationDetailsById;
    }

    @OneToMany(mappedBy = "organization")
    public Collection<UssdCodes> getDatUssdCodesById() {
        return datUssdCodesById;
    }

    public void setDatUssdCodesById(Collection<UssdCodes> datUssdCodesById) {
        this.datUssdCodesById = datUssdCodesById;
    }
}
