package org.muhia.app.psi.orm.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Collection;

/*
  Created by Kenneth
  Project: psi
  Package: org.muhia.apps.psi.orm.model
  Generated on: 30-Mar-17, 08:41.
 */
@Entity
@Table(name = "CFG_MAPPING_SUB_GROUPS")
public class MappingSubGroups {
    private Long id;
    private String description;
    private Date creationDate;
    private Long createdBy;
    private Date lastUpdateDate;
    private Long lastUpdatedBy;
    private Integer status;

    private Collection<MappingGroupsItems> cfgMappingGroupsItemsById;
    private ApplicationSrc applicationSrc;
    private Collection<PricingProfile> crmPricingProfilesById;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "DESCRIPTION", nullable = true, length = 300)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    @Column(name = "CREATED_BY", nullable = true, precision = 0)
    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    @Basic
    @Column(name = "LAST_UPDATE_DATE", nullable = true)
    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
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
    @Column(name = "STATUS", nullable = true, precision = 0)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MappingSubGroups that = (MappingSubGroups) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (creationDate != null ? !creationDate.equals(that.creationDate) : that.creationDate != null) return false;
        if (createdBy != null ? !createdBy.equals(that.createdBy) : that.createdBy != null) return false;
        if (lastUpdateDate != null ? !lastUpdateDate.equals(that.lastUpdateDate) : that.lastUpdateDate != null)
            return false;
        if (lastUpdatedBy != null ? !lastUpdatedBy.equals(that.lastUpdatedBy) : that.lastUpdatedBy != null)
            return false;
        //if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (applicationSrc != null ? !applicationSrc.equals(that.applicationSrc) : that.applicationSrc != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
        result = 31 * result + (lastUpdatedBy != null ? lastUpdatedBy.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (applicationSrc != null ? applicationSrc.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "subGroup")
    public Collection<MappingGroupsItems> getCfgMappingGroupsItemsById() {
        return cfgMappingGroupsItemsById;
    }

    public void setCfgMappingGroupsItemsById(Collection<MappingGroupsItems> cfgMappingGroupsItemsById) {
        this.cfgMappingGroupsItemsById = cfgMappingGroupsItemsById;
    }

    @ManyToOne
    @JoinColumn(name = "APPLICATION_SRC", referencedColumnName = "ID")
    public ApplicationSrc getApplicationSrc() {
        return applicationSrc;
    }

    public void setApplicationSrc(ApplicationSrc cfgApplicationSrcByApplicationSrc) {
        this.applicationSrc = cfgApplicationSrcByApplicationSrc;
    }

    @OneToMany(mappedBy = "mappingSubGroup")
    public Collection<PricingProfile> getCrmPricingProfilesById() {
        return crmPricingProfilesById;
    }

    public void setCrmPricingProfilesById(Collection<PricingProfile> crmPricingProfilesById) {
        this.crmPricingProfilesById = crmPricingProfilesById;
    }
}
