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
@Table(name = "CBM_EXCHANGE_RATES", schema = "PSI")
public class ExchangeRates {
    private long id;
    private long exchangeRate;
    private Time rateStartDate;
    private Time rateEndDate;
    private long isactive;
    private Time createdon;
    private Time lastupdatedate;
    private String createdby;
    private String modifiedby;
    private Currencies currencyId;

    @Id
    @SequenceGenerator(name = "CBM_EXCHANGE_RATES_SEQ_GEN", sequenceName = "CBM_EXCHANGE_RATES_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "CBM_EXCHANGE_RATES_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "EXCHANGE_RATE")
    public long getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(long exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Basic
    @Column(name = "RATE_START_DATE")
    public Time getRateStartDate() {
        return rateStartDate;
    }

    public void setRateStartDate(Time rateStartDate) {
        this.rateStartDate = rateStartDate;
    }

    @Basic
    @Column(name = "RATE_END_DATE")
    public Time getRateEndDate() {
        return rateEndDate;
    }

    public void setRateEndDate(Time rateEndDate) {
        this.rateEndDate = rateEndDate;
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

        ExchangeRates that = (ExchangeRates) o;

        return id == that.id && exchangeRate == that.exchangeRate && isactive == that.isactive && (rateStartDate != null ? rateStartDate.equals(that.rateStartDate) : that.rateStartDate == null) && (rateEndDate != null ? rateEndDate.equals(that.rateEndDate) : that.rateEndDate == null) && (createdon != null ? createdon.equals(that.createdon) : that.createdon == null) && (lastupdatedate != null ? lastupdatedate.equals(that.lastupdatedate) : that.lastupdatedate == null) && (createdby != null ? createdby.equals(that.createdby) : that.createdby == null) && (modifiedby != null ? modifiedby.equals(that.modifiedby) : that.modifiedby == null);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (exchangeRate ^ (exchangeRate >>> 32));
        result = 31 * result + (rateStartDate != null ? rateStartDate.hashCode() : 0);
        result = 31 * result + (rateEndDate != null ? rateEndDate.hashCode() : 0);
        result = 31 * result + (int) (isactive ^ (isactive >>> 32));
        result = 31 * result + (createdon != null ? createdon.hashCode() : 0);
        result = 31 * result + (lastupdatedate != null ? lastupdatedate.hashCode() : 0);
        result = 31 * result + (createdby != null ? createdby.hashCode() : 0);
        result = 31 * result + (modifiedby != null ? modifiedby.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CURRENCY_ID", referencedColumnName = "ID")
    public Currencies getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Currencies currencyId) {
        this.currencyId = currencyId;
    }
}
