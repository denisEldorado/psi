package org.muhia.app.psi.orm.model;

import javax.persistence.*;
import java.util.Date;

/*
  Created by Kenneth
  Project: psi
  Package: org.muhia.apps.psi.orm.model
  Generated on: 30-Mar-17, 08:41.
 */
@Entity
@Table(name = "CFG_SMS_NOTIF_CONDITION")
public class SmsNotifCondition {
    private Long id;
//    private Long productId;
    private Long conditionRuleId;
//    private Long smsId;
    private int status;
    private Date creationDate;
    private Date lastUpdatedDate;
    private Date lastUpdatedBy;
    private Date deactiveDate;
    private ProductsMaster productId;
    private SmsNotification smsId;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    @Basic
    @Column(name = "CONDITION_RULE_ID", nullable = true, precision = 0)
    public Long getConditionRuleId() {
        return conditionRuleId;
    }

    public void setConditionRuleId(Long conditionRuleId) {
        this.conditionRuleId = conditionRuleId;
    }



    @Basic
    @Column(name = "STATUS", nullable = true, precision = 0)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
    @Column(name = "LAST_UPDATED_DATE", nullable = true)
    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    @Basic
    @Column(name = "LAST_UPDATED_BY", nullable = true)
    public Date getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Date lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    @Basic
    @Column(name = "DEACTIVE_DATE", nullable = true)
    public Date getDeactiveDate() {
        return deactiveDate;
    }

    public void setDeactiveDate(Date deactiveDate) {
        this.deactiveDate = deactiveDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SmsNotifCondition that = (SmsNotifCondition) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (conditionRuleId != null ? !conditionRuleId.equals(that.conditionRuleId) : that.conditionRuleId != null)
            return false;
        if (smsId != null ? !smsId.equals(that.smsId) : that.smsId != null) return false;
        //if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (creationDate != null ? !creationDate.equals(that.creationDate) : that.creationDate != null) return false;
        if (lastUpdatedDate != null ? !lastUpdatedDate.equals(that.lastUpdatedDate) : that.lastUpdatedDate != null)
            return false;
        if (lastUpdatedBy != null ? !lastUpdatedBy.equals(that.lastUpdatedBy) : that.lastUpdatedBy != null)
            return false;
        if (deactiveDate != null ? !deactiveDate.equals(that.deactiveDate) : that.deactiveDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (conditionRuleId != null ? conditionRuleId.hashCode() : 0);
        result = 31 * result + (smsId != null ? smsId.hashCode() : 0);

        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (lastUpdatedDate != null ? lastUpdatedDate.hashCode() : 0);
        result = 31 * result + (lastUpdatedBy != null ? lastUpdatedBy.hashCode() : 0);
        result = 31 * result + (deactiveDate != null ? deactiveDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID", nullable = false)
    public ProductsMaster getProductId() {
        return productId;
    }

    public void setProductId(ProductsMaster cfgProductsMasterByProductId) {
        this.productId = cfgProductsMasterByProductId;
    }

    @ManyToOne
    @JoinColumn(name = "SMS_ID", referencedColumnName = "ID")
    public SmsNotification getSmsId() {
        return smsId;
    }

    public void setSmsId(SmsNotification cfgSmsNotificationBySmsId) {
        this.smsId = cfgSmsNotificationBySmsId;
    }
}
