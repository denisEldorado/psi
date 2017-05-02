package org.muhia.app.psi.orm.model;

import javax.persistence.*;
import java.util.Date;

/*
  Created by Kenneth
  Project: psi
  Package: org.muhia.apps.psi.orm.model
  Generated on: 30-Mar-17, 08:40.
 */
@Entity
@Table(name = "CFG_APPLICABILITY_TYPES")
public class ApplicabilityTypes {
    private Long id;
    private String applicabilityType;
    private String applicabilityTypeDesc;
    private Date creationDate;
    private Date deactiveDate;
    private Date lastUpdatedDate;
    private Long lastUpdatedBy;
    private Boolean active;

    @Id
    @SequenceGenerator(name = "CFG_APPLICABILITY_TYPES_SEQ_GEN", sequenceName ="CFG_APPLICABILITY_TYPES_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "CFG_APPLICABILITY_TYPES_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "APPLICABILITY_TYPE", nullable = true, length = 300)
    public String getApplicabilityType() {
        return applicabilityType;
    }

    public void setApplicabilityType(String applicabilityType) {
        this.applicabilityType = applicabilityType;
    }

    @Basic
    @Column(name = "APPLICABILITY_TYPE_DESC", nullable = true, length = 300)
    public String getApplicabilityTypeDesc() {
        return applicabilityTypeDesc;
    }

    public void setApplicabilityTypeDesc(String applicabilityTypeDesc) {
        this.applicabilityTypeDesc = applicabilityTypeDesc;
    }

    @Basic
    @Column(name = "CREATION_DATE", nullable = true)
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Basic
    @Column(name = "DEACTIVE_DATE", nullable = true)
    public Date getDeactiveDate() {
        return deactiveDate;
    }

    public void setDeactiveDate(Date deactiveDate) {
        this.deactiveDate = deactiveDate;
    }

    @Basic
    @Column(name = "LAST_UPDATED_DATE", nullable = true)
    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    @Basic
    @Column(name = "LAST_UPDATED_BY", nullable = true, precision = 0)
    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    @Basic
    @Column(name = "ACTIVE", nullable = true, precision = 0)
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApplicabilityTypes that = (ApplicabilityTypes) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (applicabilityType != null ? !applicabilityType.equals(that.applicabilityType) : that.applicabilityType != null)
            return false;
        if (applicabilityTypeDesc != null ? !applicabilityTypeDesc.equals(that.applicabilityTypeDesc) : that.applicabilityTypeDesc != null)
            return false;
        if (creationDate != null ? !creationDate.equals(that.creationDate) : that.creationDate != null) return false;
        if (deactiveDate != null ? !deactiveDate.equals(that.deactiveDate) : that.deactiveDate != null) return false;
        if (lastUpdatedDate != null ? !lastUpdatedDate.equals(that.lastUpdatedDate) : that.lastUpdatedDate != null)
            return false;
        if (lastUpdatedBy != null ? !lastUpdatedBy.equals(that.lastUpdatedBy) : that.lastUpdatedBy != null)
            return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (applicabilityType != null ? applicabilityType.hashCode() : 0);
        result = 31 * result + (applicabilityTypeDesc != null ? applicabilityTypeDesc.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (deactiveDate != null ? deactiveDate.hashCode() : 0);
        result = 31 * result + (lastUpdatedDate != null ? lastUpdatedDate.hashCode() : 0);
        result = 31 * result + (lastUpdatedBy != null ? lastUpdatedBy.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        return result;
    }
}
