package org.muhia.app.psi.orm.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;;
import java.util.Collection;

/*
  Created by Kenneth
  Project: psi
  Package: org.muhia.apps.psi.orm.model
  Generated on: 30-Mar-17, 08:41.
 */
@Entity
@Table(name = "CFG_SMS_NOTIFICATION")
public class SmsNotification {
    private Long id;
    private String description;
    private String placeHolder1;
    private String placeHolder2;
    private String placeHolder3;
    private String placeHolder4;
    private String placeHolder5;
    private int status;
    private Date creationDate;
    private Date lastUpdateDate;
    private Long lastUpdateBy;
    private String expirydateFormat;
    private String sender;
    private Collection<ProductsMaster> productsMasterCollection;
    private Collection<ProductsMaster> productsMasterCollection1;
    private Collection<ProductsMaster> productsMasterCollection2;
    private Collection<ProductsMaster> productsMasterCollection3;
    private Collection<SmsNotifCondition> cfgSmsNotifConditionsById;
    private Collection<SmsResponses> smsResponsesCollection;

    @Id
    @SequenceGenerator(name = "CFG_SMS_NOTIFICATION_SEQ_GEN", sequenceName = "CFG_SMS_NOTIFICATION_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "CFG_SMS_NOTIFICATION_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "DESCRIPTION", nullable = true, length = 400)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "PLACE_HOLDER1", nullable = true, length = 100)
    public String getPlaceHolder1() {
        return placeHolder1;
    }

    public void setPlaceHolder1(String placeHolder1) {
        this.placeHolder1 = placeHolder1;
    }

    @Basic
    @Column(name = "PLACE_HOLDER2", nullable = true, length = 100)
    public String getPlaceHolder2() {
        return placeHolder2;
    }

    public void setPlaceHolder2(String placeHolder2) {
        this.placeHolder2 = placeHolder2;
    }

    @Basic
    @Column(name = "PLACE_HOLDER3", nullable = true, length = 100)
    public String getPlaceHolder3() {
        return placeHolder3;
    }

    public void setPlaceHolder3(String placeHolder3) {
        this.placeHolder3 = placeHolder3;
    }

    @Basic
    @Column(name = "PLACE_HOLDER4", nullable = true, length = 100)
    public String getPlaceHolder4() {
        return placeHolder4;
    }

    public void setPlaceHolder4(String placeHolder4) {
        this.placeHolder4 = placeHolder4;
    }

    @Basic
    @Column(name = "PLACE_HOLDER5", nullable = true, length = 100)
    public String getPlaceHolder5() {
        return placeHolder5;
    }

    public void setPlaceHolder5(String placeHolder5) {
        this.placeHolder5 = placeHolder5;
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
    @Column(name = "LAST_UPDATE_DATE", nullable = true)
    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Basic
    @Column(name = "LAST_UPDATE_BY", nullable = true, precision = 0)
    public Long getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(Long lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    @Basic
    @Column(name = "EXPIRYDATE_FORMAT", nullable = true, length = 20)
    public String getExpirydateFormat() {
        return expirydateFormat;
    }

    public void setExpirydateFormat(String expirydateFormat) {
        this.expirydateFormat = expirydateFormat;
    }

    @Basic
    @Column(name = "SENDER", nullable = true, length = 100)
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SmsNotification that = (SmsNotification) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (placeHolder1 != null ? !placeHolder1.equals(that.placeHolder1) : that.placeHolder1 != null) return false;
        if (placeHolder2 != null ? !placeHolder2.equals(that.placeHolder2) : that.placeHolder2 != null) return false;
        if (placeHolder3 != null ? !placeHolder3.equals(that.placeHolder3) : that.placeHolder3 != null) return false;
        if (placeHolder4 != null ? !placeHolder4.equals(that.placeHolder4) : that.placeHolder4 != null) return false;
        if (placeHolder5 != null ? !placeHolder5.equals(that.placeHolder5) : that.placeHolder5 != null) return false;

        if (creationDate != null ? !creationDate.equals(that.creationDate) : that.creationDate != null) return false;
        if (lastUpdateDate != null ? !lastUpdateDate.equals(that.lastUpdateDate) : that.lastUpdateDate != null)
            return false;
        if (lastUpdateBy != null ? !lastUpdateBy.equals(that.lastUpdateBy) : that.lastUpdateBy != null) return false;
        if (expirydateFormat != null ? !expirydateFormat.equals(that.expirydateFormat) : that.expirydateFormat != null)
            return false;
        if (sender != null ? !sender.equals(that.sender) : that.sender != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (placeHolder1 != null ? placeHolder1.hashCode() : 0);
        result = 31 * result + (placeHolder2 != null ? placeHolder2.hashCode() : 0);
        result = 31 * result + (placeHolder3 != null ? placeHolder3.hashCode() : 0);
        result = 31 * result + (placeHolder4 != null ? placeHolder4.hashCode() : 0);
        result = 31 * result + (placeHolder5 != null ? placeHolder5.hashCode() : 0);

        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
        result = 31 * result + (lastUpdateBy != null ? lastUpdateBy.hashCode() : 0);
        result = 31 * result + (expirydateFormat != null ? expirydateFormat.hashCode() : 0);
        result = 31 * result + (sender != null ? sender.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "successSms")
    @XmlTransient
    public Collection<ProductsMaster> getProductsMasterCollection() {
        return productsMasterCollection;
    }

    public void setProductsMasterCollection(Collection<ProductsMaster> cfgProductsMastersById) {
        this.productsMasterCollection = cfgProductsMastersById;
    }

    @OneToMany(mappedBy = "failureSms")
    @XmlTransient
    public Collection<ProductsMaster> getProductsMasterCollection1() {
        return productsMasterCollection1;
    }

    public void setProductsMasterCollection1(Collection<ProductsMaster> cfgProductsMastersById_0) {
        this.productsMasterCollection1 = cfgProductsMastersById_0;
    }

    @OneToMany(mappedBy = "renewalSuccessSms")
    @XmlTransient
    public Collection<ProductsMaster> getProductsMasterCollection2() {
        return productsMasterCollection2;
    }

    public void setProductsMasterCollection2(Collection<ProductsMaster> cfgProductsMastersById_1) {
        this.productsMasterCollection2 = cfgProductsMastersById_1;
    }

    @OneToMany(mappedBy = "renewalFailureSms")
    @XmlTransient
    public Collection<ProductsMaster> getProductsMasterCollection3() {
        return productsMasterCollection3;
    }

    public void setProductsMasterCollection3(Collection<ProductsMaster> cfgProductsMastersById_2) {
        this.productsMasterCollection3 = cfgProductsMastersById_2;
    }

    @OneToMany(mappedBy = "smsId")
    @XmlTransient
    public Collection<SmsNotifCondition> getCfgSmsNotifConditionsById() {
        return cfgSmsNotifConditionsById;
    }

    public void setCfgSmsNotifConditionsById(Collection<SmsNotifCondition> cfgSmsNotifConditionsById) {
        this.cfgSmsNotifConditionsById = cfgSmsNotifConditionsById;
    }

    @OneToMany(mappedBy = "responseText")
    @XmlTransient
    public Collection<SmsResponses> getSmsResponsesCollection() {
        return smsResponsesCollection;
    }

    public void setSmsResponsesCollection(Collection<SmsResponses> cfgSmsResponsesById) {
        this.smsResponsesCollection = cfgSmsResponsesById;
    }
}
