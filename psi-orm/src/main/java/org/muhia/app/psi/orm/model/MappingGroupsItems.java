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
@Table(name = "CFG_MAPPING_GROUPS_ITEMS")
public class MappingGroupsItems {
    private Long id;

    private String mainItem;
    private String progressState;
    private String varFld01;
    private String varFld02;
    private String varFld03;
    private String varFld04;
    private String varFld05;
    private Boolean subItem1;
    private Date creationDate;
    private Long createdBy;
    private Date lastUpdateDate;
    private Long lastUpdatedBy;
    private Boolean active;
    private String subItem2;
    private MappingSubGroups subGroup;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Basic
    @Column(name = "MAIN_ITEM", nullable = true, length = 200)
    public String getMainItem() {
        return mainItem;
    }

    public void setMainItem(String mainItem) {
        this.mainItem = mainItem;
    }

    @Basic
    @Column(name = "PROGRESS_STATE", nullable = true, length = 100)
    public String getProgressState() {
        return progressState;
    }

    public void setProgressState(String progressState) {
        this.progressState = progressState;
    }

    @Basic
    @Column(name = "VAR_FLD_01", nullable = true, length = 100)
    public String getVarFld01() {
        return varFld01;
    }

    public void setVarFld01(String varFld01) {
        this.varFld01 = varFld01;
    }

    @Basic
    @Column(name = "VAR_FLD_02", nullable = true, length = 100)
    public String getVarFld02() {
        return varFld02;
    }

    public void setVarFld02(String varFld02) {
        this.varFld02 = varFld02;
    }

    @Basic
    @Column(name = "VAR_FLD_03", nullable = true, length = 100)
    public String getVarFld03() {
        return varFld03;
    }

    public void setVarFld03(String varFld03) {
        this.varFld03 = varFld03;
    }

    @Basic
    @Column(name = "VAR_FLD_04", nullable = true, length = 100)
    public String getVarFld04() {
        return varFld04;
    }

    public void setVarFld04(String varFld04) {
        this.varFld04 = varFld04;
    }

    @Basic
    @Column(name = "VAR_FLD_05", nullable = true, length = 100)
    public String getVarFld05() {
        return varFld05;
    }

    public void setVarFld05(String varFld05) {
        this.varFld05 = varFld05;
    }

    @Basic
    @Column(name = "SUB_ITEM_1", nullable = true, precision = 0)
    public Boolean getSubItem1() {
        return subItem1;
    }

    public void setSubItem1(Boolean subItem1) {
        this.subItem1 = subItem1;
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
    @Column(name = "ACTIVE", nullable = true, precision = 0)
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Basic
    @Column(name = "SUB_ITEM_2", nullable = true, length = 100)
    public String getSubItem2() {
        return subItem2;
    }

    public void setSubItem2(String subItem2) {
        this.subItem2 = subItem2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MappingGroupsItems that = (MappingGroupsItems) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (subGroup != null ? !subGroup.equals(that.subGroup) : that.subGroup != null) return false;
        if (mainItem != null ? !mainItem.equals(that.mainItem) : that.mainItem != null) return false;
        if (progressState != null ? !progressState.equals(that.progressState) : that.progressState != null)
            return false;
        if (varFld01 != null ? !varFld01.equals(that.varFld01) : that.varFld01 != null) return false;
        if (varFld02 != null ? !varFld02.equals(that.varFld02) : that.varFld02 != null) return false;
        if (varFld03 != null ? !varFld03.equals(that.varFld03) : that.varFld03 != null) return false;
        if (varFld04 != null ? !varFld04.equals(that.varFld04) : that.varFld04 != null) return false;
        if (varFld05 != null ? !varFld05.equals(that.varFld05) : that.varFld05 != null) return false;
        if (subItem1 != null ? !subItem1.equals(that.subItem1) : that.subItem1 != null) return false;
        if (creationDate != null ? !creationDate.equals(that.creationDate) : that.creationDate != null) return false;
        if (createdBy != null ? !createdBy.equals(that.createdBy) : that.createdBy != null) return false;
        if (lastUpdateDate != null ? !lastUpdateDate.equals(that.lastUpdateDate) : that.lastUpdateDate != null)
            return false;
        if (lastUpdatedBy != null ? !lastUpdatedBy.equals(that.lastUpdatedBy) : that.lastUpdatedBy != null)
            return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;
        if (subItem2 != null ? !subItem2.equals(that.subItem2) : that.subItem2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (subGroup != null ? subGroup.hashCode() : 0);
        result = 31 * result + (mainItem != null ? mainItem.hashCode() : 0);
        result = 31 * result + (progressState != null ? progressState.hashCode() : 0);
        result = 31 * result + (varFld01 != null ? varFld01.hashCode() : 0);
        result = 31 * result + (varFld02 != null ? varFld02.hashCode() : 0);
        result = 31 * result + (varFld03 != null ? varFld03.hashCode() : 0);
        result = 31 * result + (varFld04 != null ? varFld04.hashCode() : 0);
        result = 31 * result + (varFld05 != null ? varFld05.hashCode() : 0);
        result = 31 * result + (subItem1 != null ? subItem1.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
        result = 31 * result + (lastUpdatedBy != null ? lastUpdatedBy.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (subItem2 != null ? subItem2.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "SUB_GROUP", referencedColumnName = "ID", nullable = false)
    public MappingSubGroups getSubGroup() {
        return subGroup;
    }

    public void setSubGroup(MappingSubGroups cfgMappingSubGroupsBySubGroup) {
        this.subGroup = cfgMappingSubGroupsBySubGroup;
    }
}
