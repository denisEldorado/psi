package org.muhia.app.psi.orm.model;

import javax.persistence.*;

/*
  Created by Kenneth
  Project: psi
  Package: org.muhia.apps.psi.orm.model
  Generated on: 30-Mar-17, 08:41.
 */
@Entity
@Table(name = "CRM_PRICING_PROFILE")
public class PricingProfile {
    private Long id;
    private String wallet;
    private Long walletValue;
    private String walletDesc;
    private Long priority;
    private int status;
    private ApplicationDst applicationDst;
    private WalletTypes walletType;
    private PricingProfileTier pricingProfileTier;
    private ProductsMaster productId;
    private ApplicationSrc applicationSrc;
    private MappingSubGroups mappingSubGroup;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CRM_PRICING_PROFILE_ID_GEN")
    @SequenceGenerator(name = "CRM_PRICING_PROFILE_ID_GEN", sequenceName = "CRM_PRICING_PROFILE_SEQ")
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "WALLET", nullable = true, length = 300)
    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }

    @Basic
    @Column(name = "WALLET_VALUE", nullable = true, precision = 4)
    public Long getWalletValue() {
        return walletValue;
    }

    public void setWalletValue(Long walletValue) {
        this.walletValue = walletValue;
    }

    @Basic
    @Column(name = "WALLET_DESC", nullable = true, length = 100)
    public String getWalletDesc() {
        return walletDesc;
    }

    public void setWalletDesc(String walletDesc) {
        this.walletDesc = walletDesc;
    }

    @Basic
    @Column(name = "PRIORITY", nullable = true, precision = 0)
    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    @Basic
    @Column(name = "STATUS", nullable = true, precision = 0)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PricingProfile that = (PricingProfile) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (wallet != null ? !wallet.equals(that.wallet) : that.wallet != null) return false;
        if (walletValue != null ? !walletValue.equals(that.walletValue) : that.walletValue != null) return false;
        if (walletDesc != null ? !walletDesc.equals(that.walletDesc) : that.walletDesc != null) return false;
        if (priority != null ? !priority.equals(that.priority) : that.priority != null) return false;


        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (wallet != null ? wallet.hashCode() : 0);
        result = 31 * result + (walletValue != null ? walletValue.hashCode() : 0);
        result = 31 * result + (walletDesc != null ? walletDesc.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);

        return result;
    }

    @ManyToOne
    @JoinColumn(name = "APPLICATION_DST", referencedColumnName = "ID")
    public ApplicationDst getApplicationDst() {
        return applicationDst;
    }

    public void setApplicationDst(ApplicationDst applicationDst) {
        this.applicationDst = applicationDst;
    }

    @ManyToOne
    @JoinColumn(name = "WALLET_TYPE", referencedColumnName = "ID", nullable = false)
    public WalletTypes getWalletType() {
        return walletType;
    }

    public void setWalletType(WalletTypes walletType) {
        this.walletType = walletType;
    }

    @ManyToOne
    @JoinColumn(name = "PRICING_PROFILE_TIER", referencedColumnName = "ID", nullable = false)
    public PricingProfileTier getPricingProfileTier() {
        return pricingProfileTier;
    }

    public void setPricingProfileTier(PricingProfileTier pricingProfileTier) {
        this.pricingProfileTier = pricingProfileTier;
    }

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID", nullable = false)
    public ProductsMaster getProductId() {
        return productId;
    }

    public void setProductId(ProductsMaster productId) {
        this.productId = productId;
    }

    @ManyToOne
    @JoinColumn(name = "APPLICATION_SRC", referencedColumnName = "ID")
    public ApplicationSrc getApplicationSrc() {
        return applicationSrc;
    }

    public void setApplicationSrc(ApplicationSrc applicationSrc) {
        this.applicationSrc = applicationSrc;
    }

    @ManyToOne
    @JoinColumn(name = "MAPPING_SUB_GROUP", referencedColumnName = "ID", nullable = false)
    public MappingSubGroups getMappingSubGroup() {
        return mappingSubGroup;
    }

    public void setMappingSubGroup(MappingSubGroups mappingSubGroup) {
        this.mappingSubGroup = mappingSubGroup;
    }
}
