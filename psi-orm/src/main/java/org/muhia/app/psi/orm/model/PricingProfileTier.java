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
@Table(name = "CFG_PRICING_PROFILE_TIER")
public class PricingProfileTier {
    private Long id;
    private String tierDescription;
    private Collection<PricingProfile> crmPricingProfilesById;

    @Id
    @SequenceGenerator(name = "CFG_PRICING_PROFILE_TIER_SEQ_GEN",sequenceName = "CFG_PRICING_PROFILE_TIER_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "CFG_PRICING_PROFILE_TIER_SEQ_GEN",strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TIER_DESCRIPTION", nullable = false, length = 300)
    public String getTierDescription() {
        return tierDescription;
    }

    public void setTierDescription(String tierDescription) {
        this.tierDescription = tierDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PricingProfileTier that = (PricingProfileTier) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (tierDescription != null ? !tierDescription.equals(that.tierDescription) : that.tierDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (tierDescription != null ? tierDescription.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "pricingProfileTier")
    public Collection<PricingProfile> getCrmPricingProfilesById() {
        return crmPricingProfilesById;
    }

    public void setCrmPricingProfilesById(Collection<PricingProfile> crmPricingProfilesById) {
        this.crmPricingProfilesById = crmPricingProfilesById;
    }
}
