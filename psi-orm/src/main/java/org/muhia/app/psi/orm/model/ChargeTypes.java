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
@Table(name = "CBM_CHARGE_TYPES", schema = "PSI")
public class ChargeTypes {
    private long id;
    private String chargeTypeCode;
    private String chargeTypeName;
    private long isactive;
    private Time createdon;
    private Time lastupdatedate;
    private String createdby;
    private String modifiedby;
    private String description;
    private Collection<BankCharges> bankChargesCollection1;
    private Collection<BankCharges> bankChargesCollection2;

    @Id
    @SequenceGenerator(name = "CBM_CHARGE_TYPES_SEQ_GEN", sequenceName = "CBM_CHARGE_TYPES_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "CBM_CHARGE_TYPES_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CHARGE_TYPE_CODE")
    public String getChargeTypeCode() {
        return chargeTypeCode;
    }

    public void setChargeTypeCode(String chargeTypeCode) {
        this.chargeTypeCode = chargeTypeCode;
    }

    @Basic
    @Column(name = "CHARGE_TYPE_NAME")
    public String getChargeTypeName() {
        return chargeTypeName;
    }

    public void setChargeTypeName(String chargeTypeName) {
        this.chargeTypeName = chargeTypeName;
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

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChargeTypes that = (ChargeTypes) o;

        return id == that.id && isactive == that.isactive && (chargeTypeCode != null ? chargeTypeCode.equals(that.chargeTypeCode) : that.chargeTypeCode == null) && (chargeTypeName != null ? chargeTypeName.equals(that.chargeTypeName) : that.chargeTypeName == null) && (createdon != null ? createdon.equals(that.createdon) : that.createdon == null) && (lastupdatedate != null ? lastupdatedate.equals(that.lastupdatedate) : that.lastupdatedate == null) && (createdby != null ? createdby.equals(that.createdby) : that.createdby == null) && (modifiedby != null ? modifiedby.equals(that.modifiedby) : that.modifiedby == null) && (description != null ? description.equals(that.description) : that.description == null);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (chargeTypeCode != null ? chargeTypeCode.hashCode() : 0);
        result = 31 * result + (chargeTypeName != null ? chargeTypeName.hashCode() : 0);
        result = 31 * result + (int) (isactive ^ (isactive >>> 32));
        result = 31 * result + (createdon != null ? createdon.hashCode() : 0);
        result = 31 * result + (lastupdatedate != null ? lastupdatedate.hashCode() : 0);
        result = 31 * result + (createdby != null ? createdby.hashCode() : 0);
        result = 31 * result + (modifiedby != null ? modifiedby.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "chargeCode")
    public Collection<BankCharges> getBankChargesCollection1() {
        return bankChargesCollection1;
    }

    public void setBankChargesCollection1(Collection<BankCharges> bankChargesCollection1) {
        this.bankChargesCollection1 = bankChargesCollection1;
    }

    @OneToMany(mappedBy = "chargeType")
    public Collection<BankCharges> getBankChargesCollection2() {
        return bankChargesCollection2;
    }

    public void setBankChargesCollection2(Collection<BankCharges> bankChargesCollection2) {
        this.bankChargesCollection2 = bankChargesCollection2;
    }
}
