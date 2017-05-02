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
@Table(name = "CBM_ACCOUNT_TYPES", schema = "PSI")
public class AccountTypes {
    private long id;
    private String acctypename;
    private String acctypecode;
    private Long minimumbal;
    private Long isdebitable;
    private String description;
    private Time createdon;
    private Time lastupdatedate;
    private String createdby;
    private String modifiedby;
    private Long isactive;
    private Long minnumberofsignatories;
    private Long maxnumberofsignatories;
    private Banks bankcode;
    private Collection<BankAccounts> bankAccounts;
    private Collection<BankCharges> bankCharges;

    @Id
    @SequenceGenerator(name = "CBM_ACCOUNT_TYPES_SEQ_GEN", sequenceName = "CBM_ACCOUNT_TYPES_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "CBM_ACCOUNT_TYPES_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ACCTYPENAME")
    public String getAcctypename() {
        return acctypename;
    }

    public void setAcctypename(String acctypename) {
        this.acctypename = acctypename;
    }

    @Basic
    @Column(name = "ACCTYPECODE")
    public String getAcctypecode() {
        return acctypecode;
    }

    public void setAcctypecode(String acctypecode) {
        this.acctypecode = acctypecode;
    }

    @Basic
    @Column(name = "MINIMUMBAL")
    public Long getMinimumbal() {
        return minimumbal;
    }

    public void setMinimumbal(Long minimumbal) {
        this.minimumbal = minimumbal;
    }

    @Basic
    @Column(name = "ISDEBITABLE")
    public Long getIsdebitable() {
        return isdebitable;
    }

    public void setIsdebitable(Long isdebitable) {
        this.isdebitable = isdebitable;
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

    @Basic
    @Column(name = "ISACTIVE")
    public Long getIsactive() {
        return isactive;
    }

    public void setIsactive(Long isactive) {
        this.isactive = isactive;
    }

    @Basic
    @Column(name = "MINNUMBEROFSIGNATORIES")
    public Long getMinnumberofsignatories() {
        return minnumberofsignatories;
    }

    public void setMinnumberofsignatories(Long minnumberofsignatories) {
        this.minnumberofsignatories = minnumberofsignatories;
    }

    @Basic
    @Column(name = "MAXNUMBEROFSIGNATORIES")
    public Long getMaxnumberofsignatories() {
        return maxnumberofsignatories;
    }

    public void setMaxnumberofsignatories(Long maxnumberofsignatories) {
        this.maxnumberofsignatories = maxnumberofsignatories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountTypes that = (AccountTypes) o;

        return id == that.id && (acctypename != null ? acctypename.equals(that.acctypename) : that.acctypename == null) && (acctypecode != null ? acctypecode.equals(that.acctypecode) : that.acctypecode == null) && (minimumbal != null ? minimumbal.equals(that.minimumbal) : that.minimumbal == null) && (isdebitable != null ? isdebitable.equals(that.isdebitable) : that.isdebitable == null) && (description != null ? description.equals(that.description) : that.description == null) && (createdon != null ? createdon.equals(that.createdon) : that.createdon == null) && (lastupdatedate != null ? lastupdatedate.equals(that.lastupdatedate) : that.lastupdatedate == null) && (createdby != null ? createdby.equals(that.createdby) : that.createdby == null) && (modifiedby != null ? modifiedby.equals(that.modifiedby) : that.modifiedby == null) && (isactive != null ? isactive.equals(that.isactive) : that.isactive == null) && (minnumberofsignatories != null ? minnumberofsignatories.equals(that.minnumberofsignatories) : that.minnumberofsignatories == null) && (maxnumberofsignatories != null ? maxnumberofsignatories.equals(that.maxnumberofsignatories) : that.maxnumberofsignatories == null);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (acctypename != null ? acctypename.hashCode() : 0);
        result = 31 * result + (acctypecode != null ? acctypecode.hashCode() : 0);
        result = 31 * result + (minimumbal != null ? minimumbal.hashCode() : 0);
        result = 31 * result + (isdebitable != null ? isdebitable.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (createdon != null ? createdon.hashCode() : 0);
        result = 31 * result + (lastupdatedate != null ? lastupdatedate.hashCode() : 0);
        result = 31 * result + (createdby != null ? createdby.hashCode() : 0);
        result = 31 * result + (modifiedby != null ? modifiedby.hashCode() : 0);
        result = 31 * result + (isactive != null ? isactive.hashCode() : 0);
        result = 31 * result + (minnumberofsignatories != null ? minnumberofsignatories.hashCode() : 0);
        result = 31 * result + (maxnumberofsignatories != null ? maxnumberofsignatories.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "BANKCODE", referencedColumnName = "ID")
    public Banks getBankcode() {
        return bankcode;
    }

    public void setBankcode(Banks bankcode) {
        this.bankcode = bankcode;
    }

    @OneToMany(mappedBy = "accType")
    public Collection<BankAccounts> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(Collection<BankAccounts> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    @OneToMany(mappedBy = "accountTypes")
    public Collection<BankCharges> getBankCharges() {
        return bankCharges;
    }

    public void setBankCharges(Collection<BankCharges> bankCharges) {
        this.bankCharges = bankCharges;
    }
}
