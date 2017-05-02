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
@Table(name = "CBM_CURRENCIES", schema = "PSI")
public class Currencies {
    private long id;
    private String currencyname;
    private String currencycode;
    private Long isactive;
    private Time createdon;
    private Time lastupdatedate;
    private String createdby;
    private String modifiedby;
    private Long valueinlocalcurrency;
    private Collection<BankAccounts> cbmBankAccountsById;
    private Collection<ExchangeRates> cbmExchangeRatesById;
    private Collection<TransactionRequests> cbmTransactionRequestsById;

    @Id
    @SequenceGenerator(name = "CBM_CURRENCIES_SEQ_GEN", sequenceName = "CBM_CURRENCIES_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "CBM_CURRENCIES_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CURRENCYNAME")
    public String getCurrencyname() {
        return currencyname;
    }

    public void setCurrencyname(String currencyname) {
        this.currencyname = currencyname;
    }

    @Basic
    @Column(name = "CURRENCYCODE")
    public String getCurrencycode() {
        return currencycode;
    }

    public void setCurrencycode(String currencycode) {
        this.currencycode = currencycode;
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
    @Column(name = "VALUEINLOCALCURRENCY")
    public Long getValueinlocalcurrency() {
        return valueinlocalcurrency;
    }

    public void setValueinlocalcurrency(Long valueinlocalcurrency) {
        this.valueinlocalcurrency = valueinlocalcurrency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Currencies that = (Currencies) o;

        return id == that.id && (currencyname != null ? currencyname.equals(that.currencyname) : that.currencyname == null) && (currencycode != null ? currencycode.equals(that.currencycode) : that.currencycode == null) && (isactive != null ? isactive.equals(that.isactive) : that.isactive == null) && (createdon != null ? createdon.equals(that.createdon) : that.createdon == null) && (lastupdatedate != null ? lastupdatedate.equals(that.lastupdatedate) : that.lastupdatedate == null) && (createdby != null ? createdby.equals(that.createdby) : that.createdby == null) && (modifiedby != null ? modifiedby.equals(that.modifiedby) : that.modifiedby == null) && (valueinlocalcurrency != null ? valueinlocalcurrency.equals(that.valueinlocalcurrency) : that.valueinlocalcurrency == null);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (currencyname != null ? currencyname.hashCode() : 0);
        result = 31 * result + (currencycode != null ? currencycode.hashCode() : 0);
        result = 31 * result + (isactive != null ? isactive.hashCode() : 0);
        result = 31 * result + (createdon != null ? createdon.hashCode() : 0);
        result = 31 * result + (lastupdatedate != null ? lastupdatedate.hashCode() : 0);
        result = 31 * result + (createdby != null ? createdby.hashCode() : 0);
        result = 31 * result + (modifiedby != null ? modifiedby.hashCode() : 0);
        result = 31 * result + (valueinlocalcurrency != null ? valueinlocalcurrency.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "currencyCode")
    public Collection<BankAccounts> getCbmBankAccountsById() {
        return cbmBankAccountsById;
    }

    public void setCbmBankAccountsById(Collection<BankAccounts> cbmBankAccountsById) {
        this.cbmBankAccountsById = cbmBankAccountsById;
    }

    @OneToMany(mappedBy = "currencyId")
    public Collection<ExchangeRates> getCbmExchangeRatesById() {
        return cbmExchangeRatesById;
    }

    public void setCbmExchangeRatesById(Collection<ExchangeRates> cbmExchangeRatesById) {
        this.cbmExchangeRatesById = cbmExchangeRatesById;
    }

    @OneToMany(mappedBy = "currencycode")
    public Collection<TransactionRequests> getCbmTransactionRequestsById() {
        return cbmTransactionRequestsById;
    }

    public void setCbmTransactionRequestsById(Collection<TransactionRequests> cbmTransactionRequestsById) {
        this.cbmTransactionRequestsById = cbmTransactionRequestsById;
    }
}
