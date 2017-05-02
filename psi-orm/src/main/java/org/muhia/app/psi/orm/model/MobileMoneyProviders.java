package org.muhia.app.psi.orm.model;/**
 * Copyright 2015-2016 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p>
 * <p>
 * Generated on 30-Oct-16 01:30
 */

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by KennethKZMMuhia
 * Project: psi
 * Package: org.muhia.app.psi.orm.model
 * Generated on: 14-Apr-17, 22:50
 */
@Entity
@Table(name = "CFG_MOBILE_MONEY_PROVIDERS", schema = "PSI")
public class MobileMoneyProviders {
    private long id;
    private String provider;
    private long status;
    private String mnc;
    private String mcc;
    private String cc;
    private String ndc;
    private String createdBy;
    private String modifiedBy;
    private String deletedBy;
    private Time createdOn;
    private Time modifiedOn;
    private Time deletedOn;
    private CountryCodes country;

    @Id
    @SequenceGenerator(name = "CFG_MOBILE_MONEY_PROVIDERS_SEQ_GEN", sequenceName = "CFG_MOBILE_MONEY_PROVIDERS_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "CFG_MOBILE_MONEY_PROVIDERS_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PROVIDER")
    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    @Basic
    @Column(name = "STATUS")
    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    @Basic
    @Column(name = "MNC")
    public String getMnc() {
        return mnc;
    }

    public void setMnc(String mnc) {
        this.mnc = mnc;
    }

    @Basic
    @Column(name = "MCC")
    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    @Basic
    @Column(name = "CC")
    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    @Basic
    @Column(name = "NDC")
    public String getNdc() {
        return ndc;
    }

    public void setNdc(String ndc) {
        this.ndc = ndc;
    }

    @Basic
    @Column(name = "CREATED_BY")
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Basic
    @Column(name = "MODIFIED_BY")
    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Basic
    @Column(name = "DELETED_BY")
    public String getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    @Basic
    @Column(name = "CREATED_ON")
    public Time getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Time createdOn) {
        this.createdOn = createdOn;
    }

    @Basic
    @Column(name = "MODIFIED_ON")
    public Time getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Time modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    @Basic
    @Column(name = "DELETED_ON")
    public Time getDeletedOn() {
        return deletedOn;
    }

    public void setDeletedOn(Time deletedOn) {
        this.deletedOn = deletedOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MobileMoneyProviders that = (MobileMoneyProviders) o;

        return id == that.id && status == that.status && (provider != null ? provider.equals(that.provider) : that.provider == null) && (mnc != null ? mnc.equals(that.mnc) : that.mnc == null) && (mcc != null ? mcc.equals(that.mcc) : that.mcc == null) && (cc != null ? cc.equals(that.cc) : that.cc == null) && (ndc != null ? ndc.equals(that.ndc) : that.ndc == null) && (createdBy != null ? createdBy.equals(that.createdBy) : that.createdBy == null) && (modifiedBy != null ? modifiedBy.equals(that.modifiedBy) : that.modifiedBy == null) && (deletedBy != null ? deletedBy.equals(that.deletedBy) : that.deletedBy == null) && (createdOn != null ? createdOn.equals(that.createdOn) : that.createdOn == null) && (modifiedOn != null ? modifiedOn.equals(that.modifiedOn) : that.modifiedOn == null) && (deletedOn != null ? deletedOn.equals(that.deletedOn) : that.deletedOn == null);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (provider != null ? provider.hashCode() : 0);
        result = 31 * result + (int) (status ^ (status >>> 32));
        result = 31 * result + (mnc != null ? mnc.hashCode() : 0);
        result = 31 * result + (mcc != null ? mcc.hashCode() : 0);
        result = 31 * result + (cc != null ? cc.hashCode() : 0);
        result = 31 * result + (ndc != null ? ndc.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (modifiedBy != null ? modifiedBy.hashCode() : 0);
        result = 31 * result + (deletedBy != null ? deletedBy.hashCode() : 0);
        result = 31 * result + (createdOn != null ? createdOn.hashCode() : 0);
        result = 31 * result + (modifiedOn != null ? modifiedOn.hashCode() : 0);
        result = 31 * result + (deletedOn != null ? deletedOn.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "COUNTRY", referencedColumnName = "COUNTRY_ID", nullable = false)
    public CountryCodes getCountry() {
        return country;
    }

    public void setCountry(CountryCodes country) {
        this.country = country;
    }
}
