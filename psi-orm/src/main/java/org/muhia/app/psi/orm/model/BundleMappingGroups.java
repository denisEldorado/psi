package org.muhia.app.psi.orm.model;

import javax.persistence.*;

/*
  Created by Kenneth
  Project: psi
  Package: org.muhia.apps.psi.orm.model
  Generated on: 30-Mar-17, 08:40.
 */
@Entity
@Table(name = "CFG_BUNDLE_MAPPING_GROUPS")
public class BundleMappingGroups {
    private Long id;
    private String name;

    private Boolean status;
    private MappingGroupsTypes mappingGroupType;

    @Id
    @SequenceGenerator(name = "CFG_BUNDLE_MAPPING_GROUPS_SEQ_GEN", sequenceName = "CFG_BUNDLE_MAPPING_GROUPS_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "CFG_BUNDLE_MAPPING_GROUPS_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME", nullable = false, length = 200)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Basic
    @Column(name = "STATUS", nullable = true, precision = 0)
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BundleMappingGroups that = (BundleMappingGroups) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (mappingGroupType != null ? !mappingGroupType.equals(that.mappingGroupType) : that.mappingGroupType != null)
            return false;
        //if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (mappingGroupType != null ? mappingGroupType.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "MAPPING_GROUP_TYPE", referencedColumnName = "ID", nullable = false)
    public MappingGroupsTypes getMappingGroupType() {
        return mappingGroupType;
    }

    public void setMappingGroupType(MappingGroupsTypes cfgMappingGroupsTypesByMappingGroupType) {
        this.mappingGroupType = cfgMappingGroupsTypesByMappingGroupType;
    }
}
