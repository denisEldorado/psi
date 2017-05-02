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
@Table(name = "BAT_MOBILE_MONEY_REQUESTS", schema = "PSI")
public class MobileMoneyRequests {
    private long id;
    private String provider;
    private String fromSubno;
    private String toSubno;
    private long ammount;
    private String varParameter1;
    private String varParameter2;
    private String varParameter3;
    private String varParameter4;
    private String varParameter5;
    private String varParameter6;
    private String varParameter7;
    private String varParameter8;
    private String varParameter9;
    private String varParameter10;
    private String varValue1;
    private String varValue2;
    private String varValue3;
    private String varValue4;
    private String varValue5;
    private String varValue6;
    private String varValue7;
    private String varValue8;
    private String varValue9;
    private String varValue10;
    private String createdBy;
    private String modifiedBy;
    private String deletedBy;
    private Time createdon;
    private Time modifiedon;
    private Time deletedon;
    private TransactionCategories transactionType;
    private MobileMoneyResponses responsesById;
    private Collection<MobileMoneyResponses> mobileMoneyResponses;

    @Id
    @SequenceGenerator(name = "BAT_MOBILE_MONEY_REQUESTS_SEQ_GEN", sequenceName = "BAT_MOBILE_MONEY_REQUESTS_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "BAT_MOBILE_MONEY_REQUESTS_SEQ_GEN", strategy = GenerationType.SEQUENCE)
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
    @Column(name = "FROM_SUBNO")
    public String getFromSubno() {
        return fromSubno;
    }

    public void setFromSubno(String fromSubno) {
        this.fromSubno = fromSubno;
    }

    @Basic
    @Column(name = "TO_SUBNO")
    public String getToSubno() {
        return toSubno;
    }

    public void setToSubno(String toSubno) {
        this.toSubno = toSubno;
    }

    @Basic
    @Column(name = "AMMOUNT")
    public long getAmmount() {
        return ammount;
    }

    public void setAmmount(long ammount) {
        this.ammount = ammount;
    }

    @Basic
    @Column(name = "VAR_PARAMETER_1")
    public String getVarParameter1() {
        return varParameter1;
    }

    public void setVarParameter1(String varParameter1) {
        this.varParameter1 = varParameter1;
    }

    @Basic
    @Column(name = "VAR_PARAMETER_2")
    public String getVarParameter2() {
        return varParameter2;
    }

    public void setVarParameter2(String varParameter2) {
        this.varParameter2 = varParameter2;
    }

    @Basic
    @Column(name = "VAR_PARAMETER_3")
    public String getVarParameter3() {
        return varParameter3;
    }

    public void setVarParameter3(String varParameter3) {
        this.varParameter3 = varParameter3;
    }

    @Basic
    @Column(name = "VAR_PARAMETER_4")
    public String getVarParameter4() {
        return varParameter4;
    }

    public void setVarParameter4(String varParameter4) {
        this.varParameter4 = varParameter4;
    }

    @Basic
    @Column(name = "VAR_PARAMETER_5")
    public String getVarParameter5() {
        return varParameter5;
    }

    public void setVarParameter5(String varParameter5) {
        this.varParameter5 = varParameter5;
    }

    @Basic
    @Column(name = "VAR_PARAMETER_6")
    public String getVarParameter6() {
        return varParameter6;
    }

    public void setVarParameter6(String varParameter6) {
        this.varParameter6 = varParameter6;
    }

    @Basic
    @Column(name = "VAR_PARAMETER_7")
    public String getVarParameter7() {
        return varParameter7;
    }

    public void setVarParameter7(String varParameter7) {
        this.varParameter7 = varParameter7;
    }

    @Basic
    @Column(name = "VAR_PARAMETER_8")
    public String getVarParameter8() {
        return varParameter8;
    }

    public void setVarParameter8(String varParameter8) {
        this.varParameter8 = varParameter8;
    }

    @Basic
    @Column(name = "VAR_PARAMETER_9")
    public String getVarParameter9() {
        return varParameter9;
    }

    public void setVarParameter9(String varParameter9) {
        this.varParameter9 = varParameter9;
    }

    @Basic
    @Column(name = "VAR_PARAMETER_10")
    public String getVarParameter10() {
        return varParameter10;
    }

    public void setVarParameter10(String varParameter10) {
        this.varParameter10 = varParameter10;
    }

    @Basic
    @Column(name = "VAR_VALUE_1")
    public String getVarValue1() {
        return varValue1;
    }

    public void setVarValue1(String varValue1) {
        this.varValue1 = varValue1;
    }

    @Basic
    @Column(name = "VAR_VALUE_2")
    public String getVarValue2() {
        return varValue2;
    }

    public void setVarValue2(String varValue2) {
        this.varValue2 = varValue2;
    }

    @Basic
    @Column(name = "VAR_VALUE_3")
    public String getVarValue3() {
        return varValue3;
    }

    public void setVarValue3(String varValue3) {
        this.varValue3 = varValue3;
    }

    @Basic
    @Column(name = "VAR_VALUE_4")
    public String getVarValue4() {
        return varValue4;
    }

    public void setVarValue4(String varValue4) {
        this.varValue4 = varValue4;
    }

    @Basic
    @Column(name = "VAR_VALUE_5")
    public String getVarValue5() {
        return varValue5;
    }

    public void setVarValue5(String varValue5) {
        this.varValue5 = varValue5;
    }

    @Basic
    @Column(name = "VAR_VALUE_6")
    public String getVarValue6() {
        return varValue6;
    }

    public void setVarValue6(String varValue6) {
        this.varValue6 = varValue6;
    }

    @Basic
    @Column(name = "VAR_VALUE_7")
    public String getVarValue7() {
        return varValue7;
    }

    public void setVarValue7(String varValue7) {
        this.varValue7 = varValue7;
    }

    @Basic
    @Column(name = "VAR_VALUE_8")
    public String getVarValue8() {
        return varValue8;
    }

    public void setVarValue8(String varValue8) {
        this.varValue8 = varValue8;
    }

    @Basic
    @Column(name = "VAR_VALUE_9")
    public String getVarValue9() {
        return varValue9;
    }

    public void setVarValue9(String varValue9) {
        this.varValue9 = varValue9;
    }

    @Basic
    @Column(name = "VAR_VALUE_10")
    public String getVarValue10() {
        return varValue10;
    }

    public void setVarValue10(String varValue10) {
        this.varValue10 = varValue10;
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
    @Column(name = "DELETEDON")
    public Time getDeletedon() {
        return deletedon;
    }

    public void setDeletedon(Time deletedon) {
        this.deletedon = deletedon;
    }



    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (provider != null ? provider.hashCode() : 0);
        result = 31 * result + (fromSubno != null ? fromSubno.hashCode() : 0);
        result = 31 * result + (toSubno != null ? toSubno.hashCode() : 0);
        result = 31 * result + (int) (ammount ^ (ammount >>> 32));
        result = 31 * result + (varParameter1 != null ? varParameter1.hashCode() : 0);
        result = 31 * result + (varParameter2 != null ? varParameter2.hashCode() : 0);
        result = 31 * result + (varParameter3 != null ? varParameter3.hashCode() : 0);
        result = 31 * result + (varParameter4 != null ? varParameter4.hashCode() : 0);
        result = 31 * result + (varParameter5 != null ? varParameter5.hashCode() : 0);
        result = 31 * result + (varParameter6 != null ? varParameter6.hashCode() : 0);
        result = 31 * result + (varParameter7 != null ? varParameter7.hashCode() : 0);
        result = 31 * result + (varParameter8 != null ? varParameter8.hashCode() : 0);
        result = 31 * result + (varParameter9 != null ? varParameter9.hashCode() : 0);
        result = 31 * result + (varParameter10 != null ? varParameter10.hashCode() : 0);
        result = 31 * result + (varValue1 != null ? varValue1.hashCode() : 0);
        result = 31 * result + (varValue2 != null ? varValue2.hashCode() : 0);
        result = 31 * result + (varValue3 != null ? varValue3.hashCode() : 0);
        result = 31 * result + (varValue4 != null ? varValue4.hashCode() : 0);
        result = 31 * result + (varValue5 != null ? varValue5.hashCode() : 0);
        result = 31 * result + (varValue6 != null ? varValue6.hashCode() : 0);
        result = 31 * result + (varValue7 != null ? varValue7.hashCode() : 0);
        result = 31 * result + (varValue8 != null ? varValue8.hashCode() : 0);
        result = 31 * result + (varValue9 != null ? varValue9.hashCode() : 0);
        result = 31 * result + (varValue10 != null ? varValue10.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (modifiedBy != null ? modifiedBy.hashCode() : 0);
        result = 31 * result + (deletedBy != null ? deletedBy.hashCode() : 0);
        result = 31 * result + (createdon != null ? createdon.hashCode() : 0);
        result = 31 * result + (modifiedon != null ? modifiedon.hashCode() : 0);
        result = 31 * result + (deletedon != null ? deletedon.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "TRANSACTION_TYPE", referencedColumnName = "ID", nullable = false)
    public TransactionCategories getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionCategories transactionType) {
        this.transactionType = transactionType;
    }

    @OneToMany(mappedBy = "request")
    public Collection<MobileMoneyResponses> getMobileMoneyResponses() {
        return mobileMoneyResponses;
    }

    public void setMobileMoneyResponses(Collection<MobileMoneyResponses> mobileMoneyRequests) {
        this.mobileMoneyResponses = mobileMoneyRequests;
    }
}
