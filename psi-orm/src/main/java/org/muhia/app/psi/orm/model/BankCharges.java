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
@Table(name = "CBM_BANK_CHARGES", schema = "PSI")
public class BankCharges {
    private long id;
    private Long chargeAmount;
    private long isdebit;
    private String chargeName;
    private String createdby;
    private String modifiedby;
    private Time createdon;
    private Time modifiedon;
    private String chargedesc;
    private long isactive;
    private BankAccounts commissionAccount;
    private TransactionCategories transCategory;
    private Banks bankCode;
    private String chargeCode;
    private AccountTypes accountTypes;
    private ChargeTypes chargeType;
    private ProductsMaster productId;

    @Id
    @SequenceGenerator(name = "CBM_BANK_CHARGES_SEQ_GEN", sequenceName = "CBM_BANK_CHARGES_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "CBM_BANK_CHARGES_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CHARGE_AMOUNT")
    public Long getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(Long chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    @Basic
    @Column(name = "ISDEBIT")
    public long getIsdebit() {
        return isdebit;
    }

    public void setIsdebit(long isdebit) {
        this.isdebit = isdebit;
    }

    @Basic
    @Column(name = "CHARGE_NAME")
    public String getChargeName() {
        return chargeName;
    }

    public void setChargeName(String chargeName) {
        this.chargeName = chargeName;
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
    @Column(name = "CREATEDON")
    public Time getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Time createdon) {
        this.createdon = createdon;
    }

    @Basic
    @Column(name = "MODIFIEDON")
    public Time getModifiedon() {
        return modifiedon;
    }

    public void setModifiedon(Time modifiedon) {
        this.modifiedon = modifiedon;
    }

    @Basic
    @Column(name = "CHARGEDESC")
    public String getChargedesc() {
        return chargedesc;
    }

    public void setChargedesc(String chargedesc) {
        this.chargedesc = chargedesc;
    }

    @Basic
    @Column(name = "ISACTIVE")
    public long getIsactive() {
        return isactive;
    }

    public void setIsactive(long isactive) {
        this.isactive = isactive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankCharges that = (BankCharges) o;

        return id == that.id && isdebit == that.isdebit && isactive == that.isactive && (chargeAmount != null ? chargeAmount.equals(that.chargeAmount) : that.chargeAmount == null) && (chargeName != null ? chargeName.equals(that.chargeName) : that.chargeName == null) && (createdby != null ? createdby.equals(that.createdby) : that.createdby == null) && (modifiedby != null ? modifiedby.equals(that.modifiedby) : that.modifiedby == null) && (createdon != null ? createdon.equals(that.createdon) : that.createdon == null) && (modifiedon != null ? modifiedon.equals(that.modifiedon) : that.modifiedon == null) && (chargedesc != null ? chargedesc.equals(that.chargedesc) : that.chargedesc == null);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (chargeAmount != null ? chargeAmount.hashCode() : 0);
        result = 31 * result + (int) (isdebit ^ (isdebit >>> 32));
        result = 31 * result + (chargeName != null ? chargeName.hashCode() : 0);
        result = 31 * result + (createdby != null ? createdby.hashCode() : 0);
        result = 31 * result + (modifiedby != null ? modifiedby.hashCode() : 0);
        result = 31 * result + (createdon != null ? createdon.hashCode() : 0);
        result = 31 * result + (modifiedon != null ? modifiedon.hashCode() : 0);
        result = 31 * result + (chargedesc != null ? chargedesc.hashCode() : 0);
        result = 31 * result + (int) (isactive ^ (isactive >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "COMMISSION_ACCOUNT", referencedColumnName = "ID", nullable = false)
    public BankAccounts getCommissionAccount() {
        return commissionAccount;
    }

    public void setCommissionAccount(BankAccounts commissionAccount) {
        this.commissionAccount = commissionAccount;
    }

    @ManyToOne
    @JoinColumn(name = "TRANS_CATEGORY", referencedColumnName = "ID", nullable = false)
    public TransactionCategories getTransCategory() {
        return transCategory;
    }

    public void setTransCategory(TransactionCategories transCategory) {
        this.transCategory = transCategory;
    }

    @ManyToOne
    @JoinColumn(name = "BANK_CODE", referencedColumnName = "ID", nullable = false)
    public Banks getBankCode() {
        return bankCode;
    }

    public void setBankCode(Banks bankCode) {
        this.bankCode = bankCode;
    }

    @Basic
    @Column(name = "CHARGE_CODE")
    public String getChargeCode() {
        return chargeCode;
    }

    public void setChargeCode(String chargeCode) {
        this.chargeCode = chargeCode;
    }

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_TYPE", referencedColumnName = "ID", nullable = false)
    public AccountTypes getAccountTypes() {
        return accountTypes;
    }

    public void setAccountTypes(AccountTypes accountTypes) {
        this.accountTypes = accountTypes;
    }

    @ManyToOne
    @JoinColumn(name = "CHARGE_TYPE", referencedColumnName = "ID", nullable = false)
    public ChargeTypes getChargeType() {
        return chargeType;
    }

    public void setChargeType(ChargeTypes chargeType) {
        this.chargeType = chargeType;
    }

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID", nullable = false)
    public ProductsMaster getProductId() {
        return productId;
    }

    public void setProductId(ProductsMaster productId) {
        this.productId = productId;
    }
}
