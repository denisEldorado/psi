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
@Table(name = "CFG_APPLICATION_DST")
public class ApplicationDst {
    private Long id;
    private String application;
    private String varFld1;
    private String varFld2;
    private String varFld3;
    private String varFld4;
    private String varFld5;
    private String description;
    private String protocol;
    private String hostName;
    private Boolean active;
    private Collection<ProductPrvTemplates> cfgProductPrvTemplatesById;
    private Collection<PricingProfile> crmPricingProfilesById;

    @Id
    @SequenceGenerator(name = "CFG_APPLICATION_DST_SEQ_GEN", sequenceName = "CFG_APPLICATION_DST_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "CFG_APPLICATION_DST_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "APPLICATION", nullable = true, length = 100)
    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    @Basic
    @Column(name = "VAR_FLD_1", nullable = true, length = 100)
    public String getVarFld1() {
        return varFld1;
    }

    public void setVarFld1(String varFld1) {
        this.varFld1 = varFld1;
    }

    @Basic
    @Column(name = "VAR_FLD_2", nullable = true, length = 100)
    public String getVarFld2() {
        return varFld2;
    }

    public void setVarFld2(String varFld2) {
        this.varFld2 = varFld2;
    }

    @Basic
    @Column(name = "VAR_FLD_3", nullable = true, length = 100)
    public String getVarFld3() {
        return varFld3;
    }

    public void setVarFld3(String varFld3) {
        this.varFld3 = varFld3;
    }

    @Basic
    @Column(name = "VAR_FLD_4", nullable = true, length = 100)
    public String getVarFld4() {
        return varFld4;
    }

    public void setVarFld4(String varFld4) {
        this.varFld4 = varFld4;
    }

    @Basic
    @Column(name = "VAR_FLD_5", nullable = true, length = 100)
    public String getVarFld5() {
        return varFld5;
    }

    public void setVarFld5(String varFld5) {
        this.varFld5 = varFld5;
    }

    @Basic
    @Column(name = "DESCRIPTION", nullable = true, length = 200)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "PROTOCOL", nullable = true, length = 50)
    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    @Basic
    @Column(name = "HOST_NAME", nullable = true, length = 50)
    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
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

        ApplicationDst that = (ApplicationDst) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (application != null ? !application.equals(that.application) : that.application != null) return false;
        if (varFld1 != null ? !varFld1.equals(that.varFld1) : that.varFld1 != null) return false;
        if (varFld2 != null ? !varFld2.equals(that.varFld2) : that.varFld2 != null) return false;
        if (varFld3 != null ? !varFld3.equals(that.varFld3) : that.varFld3 != null) return false;
        if (varFld4 != null ? !varFld4.equals(that.varFld4) : that.varFld4 != null) return false;
        if (varFld5 != null ? !varFld5.equals(that.varFld5) : that.varFld5 != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (protocol != null ? !protocol.equals(that.protocol) : that.protocol != null) return false;
        if (hostName != null ? !hostName.equals(that.hostName) : that.hostName != null) return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (application != null ? application.hashCode() : 0);
        result = 31 * result + (varFld1 != null ? varFld1.hashCode() : 0);
        result = 31 * result + (varFld2 != null ? varFld2.hashCode() : 0);
        result = 31 * result + (varFld3 != null ? varFld3.hashCode() : 0);
        result = 31 * result + (varFld4 != null ? varFld4.hashCode() : 0);
        result = 31 * result + (varFld5 != null ? varFld5.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (protocol != null ? protocol.hashCode() : 0);
        result = 31 * result + (hostName != null ? hostName.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "applicationDst")
    public Collection<ProductPrvTemplates> getCfgProductPrvTemplatesById() {
        return cfgProductPrvTemplatesById;
    }

    public void setCfgProductPrvTemplatesById(Collection<ProductPrvTemplates> cfgProductPrvTemplatesById) {
        this.cfgProductPrvTemplatesById = cfgProductPrvTemplatesById;
    }

    @OneToMany(mappedBy = "applicationDst")
    public Collection<PricingProfile> getCrmPricingProfilesById() {
        return crmPricingProfilesById;
    }

    public void setCrmPricingProfilesById(Collection<PricingProfile> crmPricingProfilesById) {
        this.crmPricingProfilesById = crmPricingProfilesById;
    }
}
