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
@Table(name = "ADM_PRINCIPAL_TYPES")
public class PrincipalTypes {
    private Long id;
    private String principalType;
    private int status;
    private String createdby;
    private Date createdon;
    private String modifiedby;
    private Date modifiedon;
    private String deleteby;
    private Date deletedon;

    private Collection<Principals> principalsCollection;
    private PrincipalTypes parentPrincipalType;
    private Collection<PrincipalTypes> principalTypesCollecption;

    @Id
    @SequenceGenerator(name = "ADM_PRINCIPAL_TYPES_SEQ_GEN", sequenceName = "ADM_PRINCIPAL_TYPES_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "ADM_PRINCIPAL_TYPES_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PRINCIPAL_TYPE", nullable = false, length = 100)
    public String getPrincipalType() {
        return principalType;
    }

    public void setPrincipalType(String principalType) {
        this.principalType = principalType;
    }

    @Basic
    @Column(name = "STATUS", nullable = false, precision = 0)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrincipalTypes that = (PrincipalTypes) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (principalType != null ? !principalType.equals(that.principalType) : that.principalType != null)
            return false;
        //if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (createdby != null ? !createdby.equals(that.createdby) : that.createdby != null) return false;
        if (createdon != null ? !createdon.equals(that.createdon) : that.createdon != null) return false;
        if (modifiedby != null ? !modifiedby.equals(that.modifiedby) : that.modifiedby != null) return false;
        if (modifiedon != null ? !modifiedon.equals(that.modifiedon) : that.modifiedon != null) return false;
        if (deleteby != null ? !deleteby.equals(that.deleteby) : that.deleteby != null) return false;
        if (deletedon != null ? !deletedon.equals(that.deletedon) : that.deletedon != null) return false;
        if (parentPrincipalType != null ? !parentPrincipalType.equals(that.parentPrincipalType) : that.parentPrincipalType != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (principalType != null ? principalType.hashCode() : 0);

        result = 31 * result + (createdby != null ? createdby.hashCode() : 0);
        result = 31 * result + (createdon != null ? createdon.hashCode() : 0);
        result = 31 * result + (modifiedby != null ? modifiedby.hashCode() : 0);
        result = 31 * result + (modifiedon != null ? modifiedon.hashCode() : 0);
        result = 31 * result + (deleteby != null ? deleteby.hashCode() : 0);
        result = 31 * result + (deletedon != null ? deletedon.hashCode() : 0);
        result = 31 * result + (parentPrincipalType != null ? parentPrincipalType.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "principalType")
    public Collection<Principals> getPrincipalsCollection() {
        return principalsCollection;
    }

    public void setPrincipalsCollection(Collection<Principals> admPrincipalsById) {
        this.principalsCollection = admPrincipalsById;
    }

    @ManyToOne
    @JoinColumn(name = "PARENT_PRINCIPAL_TYPE", referencedColumnName = "ID")
    public PrincipalTypes getParentPrincipalType() {
        return parentPrincipalType;
    }

    public void setParentPrincipalType(PrincipalTypes admPrincipalTypesByParentPrincipalType) {
        this.parentPrincipalType = admPrincipalTypesByParentPrincipalType;
    }

    @OneToMany(mappedBy = "parentPrincipalType")
    public Collection<PrincipalTypes> getPrincipalTypesCollecption() {
        return principalTypesCollecption;
    }

    public void setPrincipalTypesCollecption(Collection<PrincipalTypes> admPrincipalTypesById) {
        this.principalTypesCollecption = admPrincipalTypesById;
    }
}
