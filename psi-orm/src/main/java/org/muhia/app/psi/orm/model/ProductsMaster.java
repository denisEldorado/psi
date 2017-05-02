package org.muhia.app.psi.orm.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

/*
  Created by Kenneth
  Project: psi
  Package: org.muhia.apps.psi.orm.model
  Generated on: 30-Mar-17, 08:41.
 */
@Entity
@Table(name = "CFG_PRODUCTS_MASTER", schema = "PSI")
public class ProductsMaster {
    private Long id;
    private String name;
    private String description;
    private int status;
    private Long priorityCode;
    private Long createdBy;
    private Date createdOn;
    private Date activeFrom;
    private Date deactiveFrom;
//    private Long productType;
    private String forBonus;
    private Long toAutorenew;
    private ProductTypes productType;
    private SmsNotification successSms;
    private SmsNotification failureSms;
    private SmsNotification renewalSuccessSms;
    private SmsNotification renewalFailureSms;
    private Collection<ProductParameters> productParameters;
    private Collection<ProductPrvTemplates> productPrvTemplates;
    private Collection<SmsNotifCondition> smsNotifConditions;
    private Collection<OrderMaster> orderMasters;
    private Collection<PricingProfile> pricingProfiles;
    private Collection<RecurringOrders> recurringOrders;
    private Collection<BankCharges> bankChargesCollection;

    @Id
    @SequenceGenerator(name = "CFG_PRODUCTS_MASTER_SEQ_GEN", sequenceName = "CFG_PRODUCTS_MASTER_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "CFG_PRODUCTS_MASTER_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME", length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "DESCRIPTION", length = 300)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "STATUS")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "PRIORITY_CODE")
    public Long getPriorityCode() {
        return priorityCode;
    }

    public void setPriorityCode(Long priorityCode) {
        this.priorityCode = priorityCode;
    }

    @Basic
    @Column(name = "CREATED_BY")
    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    @Basic
    @Column(name = "CREATED_ON")
    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @Basic
    @Column(name = "ACTIVE_FROM")
    public Date getActiveFrom() {
        return activeFrom;
    }

    public void setActiveFrom(Date activeFrom) {
        this.activeFrom = activeFrom;
    }

    @Basic
    @Column(name = "DEACTIVE_FROM", nullable = true)
    public Date getDeactiveFrom() {
        return deactiveFrom;
    }

    public void setDeactiveFrom(Date deactiveFrom) {
        this.deactiveFrom = deactiveFrom;
    }

    @Basic
    @Column(name = "FOR_BONUS", nullable = true, length = 2)
    public String getForBonus() {
        return forBonus;
    }

    public void setForBonus(String forBonus) {
        this.forBonus = forBonus;
    }

    @Basic
    @Column(name = "TO_AUTORENEW", nullable = true, precision = 0)
    public Long getToAutorenew() {
        return toAutorenew;
    }

    public void setToAutorenew(Long toAutorenew) {
        this.toAutorenew = toAutorenew;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductsMaster that = (ProductsMaster) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        if (priorityCode != null ? !priorityCode.equals(that.priorityCode) : that.priorityCode != null) return false;
        if (createdBy != null ? !createdBy.equals(that.createdBy) : that.createdBy != null) return false;
        if (createdOn != null ? !createdOn.equals(that.createdOn) : that.createdOn != null) return false;
        if (activeFrom != null ? !activeFrom.equals(that.activeFrom) : that.activeFrom != null) return false;
        if (deactiveFrom != null ? !deactiveFrom.equals(that.deactiveFrom) : that.deactiveFrom != null) return false;
        if (productType != null ? !productType.equals(that.productType) : that.productType != null) return false;
        if (successSms != null ? !successSms.equals(that.successSms) : that.successSms != null) return false;
        if (failureSms != null ? !failureSms.equals(that.failureSms) : that.failureSms != null) return false;
        if (forBonus != null ? !forBonus.equals(that.forBonus) : that.forBonus != null) return false;
        if (renewalSuccessSms != null ? !renewalSuccessSms.equals(that.renewalSuccessSms) : that.renewalSuccessSms != null)
            return false;
        if (renewalFailureSms != null ? !renewalFailureSms.equals(that.renewalFailureSms) : that.renewalFailureSms != null)
            return false;
        return toAutorenew != null ? toAutorenew.equals(that.toAutorenew) : that.toAutorenew == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);

        result = 31 * result + (priorityCode != null ? priorityCode.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (createdOn != null ? createdOn.hashCode() : 0);
        result = 31 * result + (activeFrom != null ? activeFrom.hashCode() : 0);
        result = 31 * result + (deactiveFrom != null ? deactiveFrom.hashCode() : 0);
        result = 31 * result + (productType != null ? productType.hashCode() : 0);
        result = 31 * result + (successSms != null ? successSms.hashCode() : 0);
        result = 31 * result + (failureSms != null ? failureSms.hashCode() : 0);
        result = 31 * result + (forBonus != null ? forBonus.hashCode() : 0);
        result = 31 * result + (renewalSuccessSms != null ? renewalSuccessSms.hashCode() : 0);
        result = 31 * result + (renewalFailureSms != null ? renewalFailureSms.hashCode() : 0);
        result = 31 * result + (toAutorenew != null ? toAutorenew.hashCode() : 0);
        return result;
    }

    @JoinColumn(name = "PRODUCT_TYPE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    public ProductTypes getProductType() {
        return productType;
    }

    public void setProductType(ProductTypes cfgProductTypesByProductType) {
        this.productType = cfgProductTypesByProductType;
    }

    @ManyToOne
    @JoinColumn(name = "SUCCESS_SMS", referencedColumnName = "ID")
    public SmsNotification getSuccessSms() {
        return successSms;
    }

    public void setSuccessSms(SmsNotification cfgSmsNotificationBySuccessSms) {
        this.successSms = cfgSmsNotificationBySuccessSms;
    }

    @ManyToOne
    @JoinColumn(name = "FAILURE_SMS", referencedColumnName = "ID")
    public SmsNotification getFailureSms() {
        return failureSms;
    }

    public void setFailureSms(SmsNotification cfgSmsNotificationByFailureSms) {
        this.failureSms = cfgSmsNotificationByFailureSms;
    }

    @ManyToOne
    @JoinColumn(name = "RENEWAL_SUCCESS_SMS", referencedColumnName = "ID")
    public SmsNotification getRenewalSuccessSms() {
        return renewalSuccessSms;
    }

    public void setRenewalSuccessSms(SmsNotification cfgSmsNotificationByRenewalSuccessSms) {
        this.renewalSuccessSms = cfgSmsNotificationByRenewalSuccessSms;
    }

    @ManyToOne
    @JoinColumn(name = "RENEWAL_FAILURE_SMS", referencedColumnName = "ID")
    public SmsNotification getRenewalFailureSms() {
        return renewalFailureSms;
    }

    public void setRenewalFailureSms(SmsNotification cfgSmsNotificationByRenewalFailureSms) {
        this.renewalFailureSms = cfgSmsNotificationByRenewalFailureSms;
    }

    @OneToMany(mappedBy = "productId")
    public Collection<ProductParameters> getProductParameters() {
        return productParameters;
    }

    public void setProductParameters(Collection<ProductParameters> cfgProductParametersById) {
        this.productParameters = cfgProductParametersById;
    }

    @OneToMany(mappedBy = "productId")
    public Collection<ProductPrvTemplates> getProductPrvTemplates() {
        return productPrvTemplates;
    }

    public void setProductPrvTemplates(Collection<ProductPrvTemplates> cfgProductPrvTemplatesById) {
        this.productPrvTemplates = cfgProductPrvTemplatesById;
    }

    @OneToMany(mappedBy = "productId")
    public Collection<SmsNotifCondition> getSmsNotifConditions() {
        return smsNotifConditions;
    }

    public void setSmsNotifConditions(Collection<SmsNotifCondition> cfgSmsNotifConditionsById) {
        this.smsNotifConditions = cfgSmsNotifConditionsById;
    }

    @OneToMany(mappedBy = "productId")
    public Collection<OrderMaster> getOrderMasters() {
        return orderMasters;
    }

    public void setOrderMasters(Collection<OrderMaster> crmOrderMastersById) {
        this.orderMasters = crmOrderMastersById;
    }

    @OneToMany(mappedBy = "productId")
    public Collection<PricingProfile> getPricingProfiles() {
        return pricingProfiles;
    }

    public void setPricingProfiles(Collection<PricingProfile> crmPricingProfilesById) {
        this.pricingProfiles = crmPricingProfilesById;
    }

    @OneToMany(mappedBy = "orderProduct")
    public Collection<RecurringOrders> getRecurringOrders() {
        return recurringOrders;
    }

    public void setRecurringOrders(Collection<RecurringOrders> crmRecurringOrdersById) {
        this.recurringOrders = crmRecurringOrdersById;
    }

    @OneToMany(mappedBy = "productId")
    public Collection<BankCharges> getBankChargesCollection() {
        return bankChargesCollection;
    }

    public void setBankChargesCollection(Collection<BankCharges> bankChargesCollection) {
        this.bankChargesCollection = bankChargesCollection;
    }
}
