package org.muhia.app.psi.orm.model;

import javax.persistence.*;
import java.util.Collection;

/*
  Created by Kenneth
  Project: psi
  Package: org.muhia.apps.psi.orm.model
  Generated on: 30-Mar-17, 08:41.
 */
@Entity
@Table(name = "CFG_WALLET_TYPES")
public class WalletTypes {
    private Long id;
    private String typeName;
    private String typeDescription;
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
    @Column(name = "TYPE_NAME", nullable = true, length = 100)
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Basic
    @Column(name = "TYPE_DESCRIPTION", nullable = true, length = 100)
    public String getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WalletTypes that = (WalletTypes) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null) return false;
        if (typeDescription != null ? !typeDescription.equals(that.typeDescription) : that.typeDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        result = 31 * result + (typeDescription != null ? typeDescription.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "walletType")
    public Collection<PricingProfile> getCrmPricingProfilesById() {
        return crmPricingProfilesById;
    }

    public void setCrmPricingProfilesById(Collection<PricingProfile> crmPricingProfilesById) {
        this.crmPricingProfilesById = crmPricingProfilesById;
    }
}
