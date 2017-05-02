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
@Table(name = "DAT_SAVINGS_INTERVAL")
public class SavingsInterval {
    private Long id;
    private String interval;
    private int status;
    private Date createdon;
    private String createdby;
    private String modifiedby;
    private Date modifiedon;
    private String deletedby;
    private Date deletedon;
    private Collection<PrincipalsSavingsTarget> datPrincipalsSavingsTargetById;

    @Id
    @SequenceGenerator(name = "DAT_SAVINGS_INTERVAL_SEQ_GEN", sequenceName = "DAT_SAVINGS_INTERVAL_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "DAT_SAVINGS_INTERVAL_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "INTERVAL", nullable = true, length = 100)
    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
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
    @Column(name = "CREATEDON", nullable = true)
    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
    }

    @Basic
    @Column(name = "CREATEDBY", nullable = true, length = 20)
    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    @Basic
    @Column(name = "MODIFIEDBY", nullable = true, length = 20)
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
    @Column(name = "DELETEDBY", nullable = true, length = 20)
    public String getDeletedby() {
        return deletedby;
    }

    public void setDeletedby(String deletedby) {
        this.deletedby = deletedby;
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

        SavingsInterval that = (SavingsInterval) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (interval != null ? !interval.equals(that.interval) : that.interval != null) return false;
        //if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (createdon != null ? !createdon.equals(that.createdon) : that.createdon != null) return false;
        if (createdby != null ? !createdby.equals(that.createdby) : that.createdby != null) return false;
        if (modifiedby != null ? !modifiedby.equals(that.modifiedby) : that.modifiedby != null) return false;
        if (modifiedon != null ? !modifiedon.equals(that.modifiedon) : that.modifiedon != null) return false;
        if (deletedby != null ? !deletedby.equals(that.deletedby) : that.deletedby != null) return false;
        if (deletedon != null ? !deletedon.equals(that.deletedon) : that.deletedon != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (interval != null ? interval.hashCode() : 0);

        result = 31 * result + (createdon != null ? createdon.hashCode() : 0);
        result = 31 * result + (createdby != null ? createdby.hashCode() : 0);
        result = 31 * result + (modifiedby != null ? modifiedby.hashCode() : 0);
        result = 31 * result + (modifiedon != null ? modifiedon.hashCode() : 0);
        result = 31 * result + (deletedby != null ? deletedby.hashCode() : 0);
        result = 31 * result + (deletedon != null ? deletedon.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "interval")
    public Collection<PrincipalsSavingsTarget> getDatPrincipalsSavingsTargetById() {
        return datPrincipalsSavingsTargetById;
    }

    public void setDatPrincipalsSavingsTargetById(Collection<PrincipalsSavingsTarget> datPrincipalsSavingsTargetById) {
        this.datPrincipalsSavingsTargetById = datPrincipalsSavingsTargetById;
    }
}
