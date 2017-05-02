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
@Table(name = "LOG_MOBILE_MONEY_RESPONSES", schema = "PSI")
public class MobileMoneyResponses {
    private long id;
    private String provider;
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
    private String varParameter11;
    private String varParameter12;
    private String varParameter13;
    private String varParameter14;
    private String varParameter15;
    private String varParameter16;
    private String varParameter17;
    private String varParameter18;
    private String varParameter19;
    private String varParameter20;
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
    private String varValue11;
    private String varValue12;
    private String varValue13;
    private String varValue14;
    private String varValue15;
    private String varValue16;
    private String varValue17;
    private String varValue18;
    private String varValue19;
    private String varValue20;
    private String createdBy;
    private String modifiedBy;
    private String deletedBy;
    private Time createdon;
    private Time modifiedon;
    private Time deletedon;
    private MobileMoneyRequests request;

    @Id
    @SequenceGenerator(name = "LOG_MOBILE_MONEY_RESPONSES_SEQ_GEN", sequenceName = "LOG_MOBILE_MONEY_RESPONSES_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "LOG_MOBILE_MONEY_RESPONSES_SEQ_GEN", strategy = GenerationType.SEQUENCE)
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
    @Column(name = "VAR_PARAMETER_11")
    public String getVarParameter11() {
        return varParameter11;
    }

    public void setVarParameter11(String varParameter11) {
        this.varParameter11 = varParameter11;
    }

    @Basic
    @Column(name = "VAR_PARAMETER_12")
    public String getVarParameter12() {
        return varParameter12;
    }

    public void setVarParameter12(String varParameter12) {
        this.varParameter12 = varParameter12;
    }

    @Basic
    @Column(name = "VAR_PARAMETER_13")
    public String getVarParameter13() {
        return varParameter13;
    }

    public void setVarParameter13(String varParameter13) {
        this.varParameter13 = varParameter13;
    }

    @Basic
    @Column(name = "VAR_PARAMETER_14")
    public String getVarParameter14() {
        return varParameter14;
    }

    public void setVarParameter14(String varParameter14) {
        this.varParameter14 = varParameter14;
    }

    @Basic
    @Column(name = "VAR_PARAMETER_15")
    public String getVarParameter15() {
        return varParameter15;
    }

    public void setVarParameter15(String varParameter15) {
        this.varParameter15 = varParameter15;
    }

    @Basic
    @Column(name = "VAR_PARAMETER_16")
    public String getVarParameter16() {
        return varParameter16;
    }

    public void setVarParameter16(String varParameter16) {
        this.varParameter16 = varParameter16;
    }

    @Basic
    @Column(name = "VAR_PARAMETER_17")
    public String getVarParameter17() {
        return varParameter17;
    }

    public void setVarParameter17(String varParameter17) {
        this.varParameter17 = varParameter17;
    }

    @Basic
    @Column(name = "VAR_PARAMETER_18")
    public String getVarParameter18() {
        return varParameter18;
    }

    public void setVarParameter18(String varParameter18) {
        this.varParameter18 = varParameter18;
    }

    @Basic
    @Column(name = "VAR_PARAMETER_19")
    public String getVarParameter19() {
        return varParameter19;
    }

    public void setVarParameter19(String varParameter19) {
        this.varParameter19 = varParameter19;
    }

    @Basic
    @Column(name = "VAR_PARAMETER_20")
    public String getVarParameter20() {
        return varParameter20;
    }

    public void setVarParameter20(String varParameter20) {
        this.varParameter20 = varParameter20;
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
    @Column(name = "VAR_VALUE_11")
    public String getVarValue11() {
        return varValue11;
    }

    public void setVarValue11(String varValue11) {
        this.varValue11 = varValue11;
    }

    @Basic
    @Column(name = "VAR_VALUE_12")
    public String getVarValue12() {
        return varValue12;
    }

    public void setVarValue12(String varValue12) {
        this.varValue12 = varValue12;
    }

    @Basic
    @Column(name = "VAR_VALUE_13")
    public String getVarValue13() {
        return varValue13;
    }

    public void setVarValue13(String varValue13) {
        this.varValue13 = varValue13;
    }

    @Basic
    @Column(name = "VAR_VALUE_14")
    public String getVarValue14() {
        return varValue14;
    }

    public void setVarValue14(String varValue14) {
        this.varValue14 = varValue14;
    }

    @Basic
    @Column(name = "VAR_VALUE_15")
    public String getVarValue15() {
        return varValue15;
    }

    public void setVarValue15(String varValue15) {
        this.varValue15 = varValue15;
    }

    @Basic
    @Column(name = "VAR_VALUE_16")
    public String getVarValue16() {
        return varValue16;
    }

    public void setVarValue16(String varValue16) {
        this.varValue16 = varValue16;
    }

    @Basic
    @Column(name = "VAR_VALUE_17")
    public String getVarValue17() {
        return varValue17;
    }

    public void setVarValue17(String varValue17) {
        this.varValue17 = varValue17;
    }

    @Basic
    @Column(name = "VAR_VALUE_18")
    public String getVarValue18() {
        return varValue18;
    }

    public void setVarValue18(String varValue18) {
        this.varValue18 = varValue18;
    }

    @Basic
    @Column(name = "VAR_VALUE_19")
    public String getVarValue19() {
        return varValue19;
    }

    public void setVarValue19(String varValue19) {
        this.varValue19 = varValue19;
    }

    @Basic
    @Column(name = "VAR_VALUE_20")
    public String getVarValue20() {
        return varValue20;
    }

    public void setVarValue20(String varValue20) {
        this.varValue20 = varValue20;
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
        result = 31 * result + (varParameter11 != null ? varParameter11.hashCode() : 0);
        result = 31 * result + (varParameter12 != null ? varParameter12.hashCode() : 0);
        result = 31 * result + (varParameter13 != null ? varParameter13.hashCode() : 0);
        result = 31 * result + (varParameter14 != null ? varParameter14.hashCode() : 0);
        result = 31 * result + (varParameter15 != null ? varParameter15.hashCode() : 0);
        result = 31 * result + (varParameter16 != null ? varParameter16.hashCode() : 0);
        result = 31 * result + (varParameter17 != null ? varParameter17.hashCode() : 0);
        result = 31 * result + (varParameter18 != null ? varParameter18.hashCode() : 0);
        result = 31 * result + (varParameter19 != null ? varParameter19.hashCode() : 0);
        result = 31 * result + (varParameter20 != null ? varParameter20.hashCode() : 0);
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
        result = 31 * result + (varValue11 != null ? varValue11.hashCode() : 0);
        result = 31 * result + (varValue12 != null ? varValue12.hashCode() : 0);
        result = 31 * result + (varValue13 != null ? varValue13.hashCode() : 0);
        result = 31 * result + (varValue14 != null ? varValue14.hashCode() : 0);
        result = 31 * result + (varValue15 != null ? varValue15.hashCode() : 0);
        result = 31 * result + (varValue16 != null ? varValue16.hashCode() : 0);
        result = 31 * result + (varValue17 != null ? varValue17.hashCode() : 0);
        result = 31 * result + (varValue18 != null ? varValue18.hashCode() : 0);
        result = 31 * result + (varValue19 != null ? varValue19.hashCode() : 0);
        result = 31 * result + (varValue20 != null ? varValue20.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (modifiedBy != null ? modifiedBy.hashCode() : 0);
        result = 31 * result + (deletedBy != null ? deletedBy.hashCode() : 0);
        result = 31 * result + (createdon != null ? createdon.hashCode() : 0);
        result = 31 * result + (modifiedon != null ? modifiedon.hashCode() : 0);
        result = 31 * result + (deletedon != null ? deletedon.hashCode() : 0);
        return result;
    }


    @ManyToOne
    @JoinColumn(name = "REQUEST", referencedColumnName = "ID", nullable = false)
    public MobileMoneyRequests getRequest() {
        return request;
    }

    public void setRequest(MobileMoneyRequests request) {
        this.request = request;
    }
}
