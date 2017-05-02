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
@Table(name = "CBM_BANKS", schema = "PSI")
public class Banks {
    private long id;
    private String bankname;
    private String bankcode;
    private String bankcontactemail;
    private String bankpassword;
    private String isactive;
    private Time createdon;
    private Time lastupdatedate;
    private String createdby;
    private String modifiedby;
    private String pathtologoimage;
    private String pathtopublickey;
    private String themecolor;
    private String navbartextcolor;
    private String bankvaultaccnumber;
    private Collection<AccountTypes> accountTypes;
    private Collection<BankAccounts> bankAccounts;
    private Collection<BankBranches> bankBranches;
    private Collection<BankCharges> bankCharges;

    @Id
    @SequenceGenerator(name = "CBM_BANKS_SEQ_GEN", sequenceName = "CBM_BANKS_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "CBM_BANKS_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "BANKNAME")
    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    @Basic
    @Column(name = "BANKCODE")
    public String getBankcode() {
        return bankcode;
    }

    public void setBankcode(String bankcode) {
        this.bankcode = bankcode;
    }

    @Basic
    @Column(name = "BANKCONTACTEMAIL")
    public String getBankcontactemail() {
        return bankcontactemail;
    }

    public void setBankcontactemail(String bankcontactemail) {
        this.bankcontactemail = bankcontactemail;
    }

    @Basic
    @Column(name = "BANKPASSWORD")
    public String getBankpassword() {
        return bankpassword;
    }

    public void setBankpassword(String bankpassword) {
        this.bankpassword = bankpassword;
    }

    @Basic
    @Column(name = "ISACTIVE")
    public String getIsactive() {
        return isactive;
    }

    public void setIsactive(String isactive) {
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
    @Column(name = "PATHTOLOGOIMAGE")
    public String getPathtologoimage() {
        return pathtologoimage;
    }

    public void setPathtologoimage(String pathtologoimage) {
        this.pathtologoimage = pathtologoimage;
    }

    @Basic
    @Column(name = "PATHTOPUBLICKEY")
    public String getPathtopublickey() {
        return pathtopublickey;
    }

    public void setPathtopublickey(String pathtopublickey) {
        this.pathtopublickey = pathtopublickey;
    }

    @Basic
    @Column(name = "THEMECOLOR")
    public String getThemecolor() {
        return themecolor;
    }

    public void setThemecolor(String themecolor) {
        this.themecolor = themecolor;
    }

    @Basic
    @Column(name = "NAVBARTEXTCOLOR")
    public String getNavbartextcolor() {
        return navbartextcolor;
    }

    public void setNavbartextcolor(String navbartextcolor) {
        this.navbartextcolor = navbartextcolor;
    }

    @Basic
    @Column(name = "BANKVAULTACCNUMBER")
    public String getBankvaultaccnumber() {
        return bankvaultaccnumber;
    }

    public void setBankvaultaccnumber(String bankvaultaccnumber) {
        this.bankvaultaccnumber = bankvaultaccnumber;
    }



    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (bankname != null ? bankname.hashCode() : 0);
        result = 31 * result + (bankcode != null ? bankcode.hashCode() : 0);
        result = 31 * result + (bankcontactemail != null ? bankcontactemail.hashCode() : 0);
        result = 31 * result + (bankpassword != null ? bankpassword.hashCode() : 0);
        result = 31 * result + (isactive != null ? isactive.hashCode() : 0);
        result = 31 * result + (createdon != null ? createdon.hashCode() : 0);
        result = 31 * result + (lastupdatedate != null ? lastupdatedate.hashCode() : 0);
        result = 31 * result + (createdby != null ? createdby.hashCode() : 0);
        result = 31 * result + (modifiedby != null ? modifiedby.hashCode() : 0);
        result = 31 * result + (pathtologoimage != null ? pathtologoimage.hashCode() : 0);
        result = 31 * result + (pathtopublickey != null ? pathtopublickey.hashCode() : 0);
        result = 31 * result + (themecolor != null ? themecolor.hashCode() : 0);
        result = 31 * result + (navbartextcolor != null ? navbartextcolor.hashCode() : 0);
        result = 31 * result + (bankvaultaccnumber != null ? bankvaultaccnumber.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "bankcode")
    public Collection<AccountTypes> getAccountTypes() {
        return accountTypes;
    }

    public void setAccountTypes(Collection<AccountTypes> accountTypes) {
        this.accountTypes = accountTypes;
    }

    @OneToMany(mappedBy = "bankCode")
    public Collection<BankAccounts> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(Collection<BankAccounts> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    @OneToMany(mappedBy = "bankcode")
    public Collection<BankBranches> getBankBranches() {
        return bankBranches;
    }

    public void setBankBranches(Collection<BankBranches> bankBranches) {
        this.bankBranches = bankBranches;
    }

    @OneToMany(mappedBy = "bankCode")
    public Collection<BankCharges> getBankCharges() {
        return bankCharges;
    }

    public void setBankCharges(Collection<BankCharges> bankCharges) {
        this.bankCharges = bankCharges;
    }
}
