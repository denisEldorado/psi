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
@Table(name = "CBM_BANK_ACCOUNTS", schema = "PSI")
public class BankAccounts {
    private long id;
    private Long accBalance;
    private String accNumber;
    private int isActive;
    private String approvedBy;
    private Time approvedDate;
    private Time createdon;
    private Time lastupdatedate;
    private String createdby;
    private String modifiedby;
    private AccountTypes accType;
    private Banks bankCode;
    private BankBranches branchCode;
    private Currencies currencyCode;
    private Principals userId;
    private Collection<BankCharges> bankCharges;
    private Collection<TransactionRequests> transactionRequests;

    @Id
    @SequenceGenerator(name = "CBM_BANK_ACCOUNTS_SEQ_GEN", sequenceName = "CBM_BANK_ACCOUNTS_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "CBM_BANK_ACCOUNTS_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ACC_BALANCE")
    public Long getAccBalance() {
        return accBalance;
    }

    public void setAccBalance(Long accBalance) {
        this.accBalance = accBalance;
    }

    @Basic
    @Column(name = "ACC_NUMBER")
    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    @Basic
    @Column(name = "IS_ACTIVE")
    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    @Basic
    @Column(name = "APPROVED_BY")
    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    @Basic
    @Column(name = "APPROVED_DATE")
    public Time getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Time approvedDate) {
        this.approvedDate = approvedDate;
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

        BankAccounts that = (BankAccounts) o;

        return id == that.id && (accBalance != null ? accBalance.equals(that.accBalance) : that.accBalance == null) && (accNumber != null ? accNumber.equals(that.accNumber) : that.accNumber == null) && (approvedBy != null ? approvedBy.equals(that.approvedBy) : that.approvedBy == null) && (approvedDate != null ? approvedDate.equals(that.approvedDate) : that.approvedDate == null) && (createdon != null ? createdon.equals(that.createdon) : that.createdon == null) && (lastupdatedate != null ? lastupdatedate.equals(that.lastupdatedate) : that.lastupdatedate == null) && (createdby != null ? createdby.equals(that.createdby) : that.createdby == null) && (modifiedby != null ? modifiedby.equals(that.modifiedby) : that.modifiedby == null);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (accBalance != null ? accBalance.hashCode() : 0);
        result = 31 * result + (accNumber != null ? accNumber.hashCode() : 0);

        result = 31 * result + (approvedBy != null ? approvedBy.hashCode() : 0);
        result = 31 * result + (approvedDate != null ? approvedDate.hashCode() : 0);
        result = 31 * result + (createdon != null ? createdon.hashCode() : 0);
        result = 31 * result + (lastupdatedate != null ? lastupdatedate.hashCode() : 0);
        result = 31 * result + (createdby != null ? createdby.hashCode() : 0);
        result = 31 * result + (modifiedby != null ? modifiedby.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ACC_TYPE", referencedColumnName = "ID", nullable = false)
    public AccountTypes getAccType() {
        return accType;
    }

    public void setAccType(AccountTypes accType) {
        this.accType = accType;
    }

    @ManyToOne
    @JoinColumn(name = "BANK_CODE", referencedColumnName = "ID", nullable = false)
    public Banks getBankCode() {
        return bankCode;
    }

    public void setBankCode(Banks bankCode) {
        this.bankCode = bankCode;
    }

    @ManyToOne
    @JoinColumn(name = "BRANCH_CODE", referencedColumnName = "ID", nullable = false)
    public BankBranches getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(BankBranches branchCode) {
        this.branchCode = branchCode;
    }

    @ManyToOne
    @JoinColumn(name = "CURRENCY_CODE", referencedColumnName = "ID", nullable = false)
    public Currencies getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(Currencies currencyCode) {
        this.currencyCode = currencyCode;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID", nullable = false)
    public Principals getUserId() {
        return userId;
    }

    public void setUserId(Principals userId) {
        this.userId = userId;
    }

    @OneToMany(mappedBy = "commissionAccount")
    public Collection<BankCharges> getBankCharges() {
        return bankCharges;
    }

    public void setBankCharges(Collection<BankCharges> bankCharges) {
        this.bankCharges = bankCharges;
    }

    @OneToMany(mappedBy = "accountnumber")
    public Collection<TransactionRequests> getTransactionRequests() {
        return transactionRequests;
    }

    public void setTransactionRequests(Collection<TransactionRequests> transactionRequests) {
        this.transactionRequests = transactionRequests;
    }
}
