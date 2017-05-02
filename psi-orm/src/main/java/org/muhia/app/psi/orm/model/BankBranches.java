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
@Table(name = "CBM_BANK_BRANCHES", schema = "PSI")
public class BankBranches {
    private long id;
    private String branchname;
    private String location;
    private Long isactive;
    private Time createdon;
    private Time lastupdatedate;
    private String createdby;
    private String modifiedby;
    private String branchvaultaccnumber;
    private Collection<BankAccounts> bankAccounts;
    private Banks bankcode;

    @Id
    @SequenceGenerator(name = "CBM_BANK_BRANCHES_SEQ_GEN", sequenceName = "CBM_BANK_BRANCHES_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "CBM_BANK_BRANCHES_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "BRANCHNAME")
    public String getBranchname() {
        return branchname;
    }

    public void setBranchname(String branchname) {
        this.branchname = branchname;
    }

    @Basic
    @Column(name = "LOCATION")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
    @Column(name = "BRANCHVAULTACCNUMBER")
    public String getBranchvaultaccnumber() {
        return branchvaultaccnumber;
    }

    public void setBranchvaultaccnumber(String branchvaultaccnumber) {
        this.branchvaultaccnumber = branchvaultaccnumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankBranches that = (BankBranches) o;

        return id == that.id && (branchname != null ? branchname.equals(that.branchname) : that.branchname == null) && (location != null ? location.equals(that.location) : that.location == null) && (isactive != null ? isactive.equals(that.isactive) : that.isactive == null) && (createdon != null ? createdon.equals(that.createdon) : that.createdon == null) && (lastupdatedate != null ? lastupdatedate.equals(that.lastupdatedate) : that.lastupdatedate == null) && (createdby != null ? createdby.equals(that.createdby) : that.createdby == null) && (modifiedby != null ? modifiedby.equals(that.modifiedby) : that.modifiedby == null) && (branchvaultaccnumber != null ? branchvaultaccnumber.equals(that.branchvaultaccnumber) : that.branchvaultaccnumber == null);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (branchname != null ? branchname.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (isactive != null ? isactive.hashCode() : 0);
        result = 31 * result + (createdon != null ? createdon.hashCode() : 0);
        result = 31 * result + (lastupdatedate != null ? lastupdatedate.hashCode() : 0);
        result = 31 * result + (createdby != null ? createdby.hashCode() : 0);
        result = 31 * result + (modifiedby != null ? modifiedby.hashCode() : 0);
        result = 31 * result + (branchvaultaccnumber != null ? branchvaultaccnumber.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "branchCode")
    public Collection<BankAccounts> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(Collection<BankAccounts> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    @ManyToOne
    @JoinColumn(name = "BANKCODE", referencedColumnName = "ID", nullable = false)
    public Banks getBankcode() {
        return bankcode;
    }

    public void setBankcode(Banks bankcode) {
        this.bankcode = bankcode;
    }
}
