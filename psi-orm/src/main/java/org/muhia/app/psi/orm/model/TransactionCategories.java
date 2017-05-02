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
import java.util.Collection;

/**
 * Created by KennethKZMMuhia
 * Project: psi
 * Package: org.muhia.app.psi.orm.model
 * Generated on: 14-Apr-17, 22:50
 */
@Entity
@Table(name = "CFG_TRANSACTION_CATEGORIES", schema = "PSI")
public class TransactionCategories {
    private long id;
    private String trantype;
    private String description;
    private long isactive;
    private Time createdon;
    private Time lastupdatedate;
    private String createdby;
    private String modifiedby;
    private Collection<MobileMoneyRequests> mobileMoneyRequests;
    private Collection<BankCharges> bankCharges;
    private Collection<TransactionRequests> transactionRequests;

    @Id
    @SequenceGenerator(name = "CFG_TRANSACTION_CATEGORIES_SEQ_GEN", sequenceName = "CFG_TRANSACTION_CATEGORIES_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "CFG_TRANSACTION_CATEGORIES_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TRANTYPE")
    public String getTrantype() {
        return trantype;
    }

    public void setTrantype(String trantype) {
        this.trantype = trantype;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "ISACTIVE")
    public long getIsactive() {
        return isactive;
    }

    public void setIsactive(long isactive) {
        this.isactive = isactive;
    }

    @Basic
    @Column(name = "CREATEDON")
    public Time getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Time createdon) {
        this.createdon = createdon;
    }

    @Basic
    @Column(name = "LASTUPDATEDATE")
    public Time getLastupdatedate() {
        return lastupdatedate;
    }

    public void setLastupdatedate(Time lastupdatedate) {
        this.lastupdatedate = lastupdatedate;
    }

    @Basic
    @Column(name = "CREATEDBY")
    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    @Basic
    @Column(name = "MODIFIEDBY")
    public String getModifiedby() {
        return modifiedby;
    }

    public void setModifiedby(String modifiedby) {
        this.modifiedby = modifiedby;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionCategories that = (TransactionCategories) o;

        if (id != that.id) return false;
        if (isactive != that.isactive) return false;
        if (trantype != null ? !trantype.equals(that.trantype) : that.trantype != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (createdon != null ? !createdon.equals(that.createdon) : that.createdon != null) return false;
        if (lastupdatedate != null ? !lastupdatedate.equals(that.lastupdatedate) : that.lastupdatedate != null)
            return false;
        if (createdby != null ? !createdby.equals(that.createdby) : that.createdby != null) return false;
        return modifiedby != null ? modifiedby.equals(that.modifiedby) : that.modifiedby == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (trantype != null ? trantype.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (int) (isactive ^ (isactive >>> 32));
        result = 31 * result + (createdon != null ? createdon.hashCode() : 0);
        result = 31 * result + (lastupdatedate != null ? lastupdatedate.hashCode() : 0);
        result = 31 * result + (createdby != null ? createdby.hashCode() : 0);
        result = 31 * result + (modifiedby != null ? modifiedby.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "transactionType")
    public Collection<MobileMoneyRequests> getMobileMoneyRequests() {
        return mobileMoneyRequests;
    }

    public void setMobileMoneyRequests(Collection<MobileMoneyRequests> mobileMoneyRequests) {
        this.mobileMoneyRequests = mobileMoneyRequests;
    }

    @OneToMany(mappedBy = "transCategory")
    public Collection<BankCharges> getBankCharges() {
        return bankCharges;
    }

    public void setBankCharges(Collection<BankCharges> bankCharges) {
        this.bankCharges = bankCharges;
    }

    @OneToMany(mappedBy = "trancategory")
    public Collection<TransactionRequests> getTransactionRequests() {
        return transactionRequests;
    }

    public void setTransactionRequests(Collection<TransactionRequests> transactionRequests) {
        this.transactionRequests = transactionRequests;
    }
}
