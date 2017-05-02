package org.muhia.app.psi.orm.model;

import javax.persistence.*;
import java.util.Collection;

/*
  Created by Kenneth
  Project: psi
  Package: org.muhia.apps.psi.orm.model
  Generated on: 30-Mar-17, 08:40.
 */
@Entity
@Table(name = "CFG_APPLICATION_SRC")
public class ApplicationSrc {
    private Long id;
    private Long accessAllowed;
    private String application;
    private String varFld1;
    private String varFld1Desc;
    private String varFld2;
    private String varFld2Desc;
    private String varFld3;
    private String varFld3Desc;
    private String hostIp;
    private String hostName;
    private String subnoPrefix;
    private String subnoReplace;
    private String protocol;
    private Collection<MappingSubGroups> cfgMappingSubGroupsById;
    private Collection<PricingProfile> crmPricingProfilesById;

    @Id
    @SequenceGenerator(name = "CFG_APPLICATION_SRC_SEQ_GEN", sequenceName = "CFG_APPLICATION_SRC_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "CFG_APPLICATION_SRC_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ACCESS_ALLOWED", nullable = true, precision = 2)
    public Long getAccessAllowed() {
        return accessAllowed;
    }

    public void setAccessAllowed(Long accessAllowed) {
        this.accessAllowed = accessAllowed;
    }

    @Basic
    @Column(name = "APPLICATION", nullable = true, length = 255)
    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    @Basic
    @Column(name = "VAR_FLD_1", nullable = true, length = 255)
    public String getVarFld1() {
        return varFld1;
    }

    public void setVarFld1(String varFld1) {
        this.varFld1 = varFld1;
    }

    @Basic
    @Column(name = "VAR_FLD_1_DESC", nullable = true, length = 255)
    public String getVarFld1Desc() {
        return varFld1Desc;
    }

    public void setVarFld1Desc(String varFld1Desc) {
        this.varFld1Desc = varFld1Desc;
    }

    @Basic
    @Column(name = "VAR_FLD_2", nullable = true, length = 255)
    public String getVarFld2() {
        return varFld2;
    }

    public void setVarFld2(String varFld2) {
        this.varFld2 = varFld2;
    }

    @Basic
    @Column(name = "VAR_FLD_2_DESC", nullable = true, length = 255)
    public String getVarFld2Desc() {
        return varFld2Desc;
    }

    public void setVarFld2Desc(String varFld2Desc) {
        this.varFld2Desc = varFld2Desc;
    }

    @Basic
    @Column(name = "VAR_FLD_3", nullable = true, length = 255)
    public String getVarFld3() {
        return varFld3;
    }

    public void setVarFld3(String varFld3) {
        this.varFld3 = varFld3;
    }

    @Basic
    @Column(name = "VAR_FLD_3_DESC", nullable = true, length = 255)
    public String getVarFld3Desc() {
        return varFld3Desc;
    }

    public void setVarFld3Desc(String varFld3Desc) {
        this.varFld3Desc = varFld3Desc;
    }

    @Basic
    @Column(name = "HOST_IP", nullable = true, length = 255)
    public String getHostIp() {
        return hostIp;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    @Basic
    @Column(name = "HOST_NAME", nullable = true, length = 255)
    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    @Basic
    @Column(name = "SUBNO_PREFIX", nullable = true, length = 255)
    public String getSubnoPrefix() {
        return subnoPrefix;
    }

    public void setSubnoPrefix(String subnoPrefix) {
        this.subnoPrefix = subnoPrefix;
    }

    @Basic
    @Column(name = "SUBNO_REPLACE", nullable = true, length = 255)
    public String getSubnoReplace() {
        return subnoReplace;
    }

    public void setSubnoReplace(String subnoReplace) {
        this.subnoReplace = subnoReplace;
    }

    @Basic
    @Column(name = "PROTOCOL", nullable = true, length = 255)
    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApplicationSrc that = (ApplicationSrc) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (accessAllowed != null ? !accessAllowed.equals(that.accessAllowed) : that.accessAllowed != null)
            return false;
        if (application != null ? !application.equals(that.application) : that.application != null) return false;
        if (varFld1 != null ? !varFld1.equals(that.varFld1) : that.varFld1 != null) return false;
        if (varFld1Desc != null ? !varFld1Desc.equals(that.varFld1Desc) : that.varFld1Desc != null) return false;
        if (varFld2 != null ? !varFld2.equals(that.varFld2) : that.varFld2 != null) return false;
        if (varFld2Desc != null ? !varFld2Desc.equals(that.varFld2Desc) : that.varFld2Desc != null) return false;
        if (varFld3 != null ? !varFld3.equals(that.varFld3) : that.varFld3 != null) return false;
        if (varFld3Desc != null ? !varFld3Desc.equals(that.varFld3Desc) : that.varFld3Desc != null) return false;
        if (hostIp != null ? !hostIp.equals(that.hostIp) : that.hostIp != null) return false;
        if (hostName != null ? !hostName.equals(that.hostName) : that.hostName != null) return false;
        if (subnoPrefix != null ? !subnoPrefix.equals(that.subnoPrefix) : that.subnoPrefix != null) return false;
        if (subnoReplace != null ? !subnoReplace.equals(that.subnoReplace) : that.subnoReplace != null) return false;
        if (protocol != null ? !protocol.equals(that.protocol) : that.protocol != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (accessAllowed != null ? accessAllowed.hashCode() : 0);
        result = 31 * result + (application != null ? application.hashCode() : 0);
        result = 31 * result + (varFld1 != null ? varFld1.hashCode() : 0);
        result = 31 * result + (varFld1Desc != null ? varFld1Desc.hashCode() : 0);
        result = 31 * result + (varFld2 != null ? varFld2.hashCode() : 0);
        result = 31 * result + (varFld2Desc != null ? varFld2Desc.hashCode() : 0);
        result = 31 * result + (varFld3 != null ? varFld3.hashCode() : 0);
        result = 31 * result + (varFld3Desc != null ? varFld3Desc.hashCode() : 0);
        result = 31 * result + (hostIp != null ? hostIp.hashCode() : 0);
        result = 31 * result + (hostName != null ? hostName.hashCode() : 0);
        result = 31 * result + (subnoPrefix != null ? subnoPrefix.hashCode() : 0);
        result = 31 * result + (subnoReplace != null ? subnoReplace.hashCode() : 0);
        result = 31 * result + (protocol != null ? protocol.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "applicationSrc")
    public Collection<MappingSubGroups> getCfgMappingSubGroupsById() {
        return cfgMappingSubGroupsById;
    }

    public void setCfgMappingSubGroupsById(Collection<MappingSubGroups> cfgMappingSubGroupsById) {
        this.cfgMappingSubGroupsById = cfgMappingSubGroupsById;
    }

    @OneToMany(mappedBy = "applicationSrc")
    public Collection<PricingProfile> getCrmPricingProfilesById() {
        return crmPricingProfilesById;
    }

    public void setCrmPricingProfilesById(Collection<PricingProfile> crmPricingProfilesById) {
        this.crmPricingProfilesById = crmPricingProfilesById;
    }
}
