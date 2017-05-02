package org.muhia.app.psi.orm.model;

import javax.persistence.*;
import java.util.Date;

/*
  Created by Kenneth
  Project: psi
  Package: org.muhia.apps.psi.orm.model
  Generated on: 30-Mar-17, 08:42.
 */
@Entity
@Table(name = "FCT_MOM_REGISTRY")
public class MomRegistry {
    private Long id;
    private String accountid;
    private String accountType;
    private String totalgsmexpenditure;
    private String totalamdebit;
    private String totalamcredit;
    private String totalsms;
    private String totalussd;
    private String totalvoicecalls;
    private String totalroamingcf;
    private String totalcontentdownload;
    private String totalhybridbundles;
    private String totalmms;
    private String totalcf;
    private String totalgprs;
    private String totaldata;
    private String totalcashin;
    private String totalcashout;
    private String totalamtopup;
    private String totalmerchantpayments;
    private String totalp2P;
    private String totalwalletload;
    private String totalposwithdrawal;
    private String dateactivated;
    private String mostfrequentlocation;
    private Date createdon;

    @Id
    @SequenceGenerator(name = "FCT_MOM_REGISTRY_SEQ_GEN", sequenceName = "FCT_MOM_REGISTRY_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "FCT_MOM_REGISTRY_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ACCOUNTID", nullable = true, length = 20)
    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid;
    }

    @Basic
    @Column(name = "ACCOUNT_TYPE", nullable = true, length = 20)
    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Basic
    @Column(name = "TOTALGSMEXPENDITURE", nullable = true, length = 20)
    public String getTotalgsmexpenditure() {
        return totalgsmexpenditure;
    }

    public void setTotalgsmexpenditure(String totalgsmexpenditure) {
        this.totalgsmexpenditure = totalgsmexpenditure;
    }

    @Basic
    @Column(name = "TOTALAMDEBIT", nullable = true, length = 20)
    public String getTotalamdebit() {
        return totalamdebit;
    }

    public void setTotalamdebit(String totalamdebit) {
        this.totalamdebit = totalamdebit;
    }

    @Basic
    @Column(name = "TOTALAMCREDIT", nullable = true, length = 20)
    public String getTotalamcredit() {
        return totalamcredit;
    }

    public void setTotalamcredit(String totalamcredit) {
        this.totalamcredit = totalamcredit;
    }

    @Basic
    @Column(name = "TOTALSMS", nullable = true, length = 20)
    public String getTotalsms() {
        return totalsms;
    }

    public void setTotalsms(String totalsms) {
        this.totalsms = totalsms;
    }

    @Basic
    @Column(name = "TOTALUSSD", nullable = true, length = 20)
    public String getTotalussd() {
        return totalussd;
    }

    public void setTotalussd(String totalussd) {
        this.totalussd = totalussd;
    }

    @Basic
    @Column(name = "TOTALVOICECALLS", nullable = true, length = 20)
    public String getTotalvoicecalls() {
        return totalvoicecalls;
    }

    public void setTotalvoicecalls(String totalvoicecalls) {
        this.totalvoicecalls = totalvoicecalls;
    }

    @Basic
    @Column(name = "TOTALROAMINGCF", nullable = true, length = 20)
    public String getTotalroamingcf() {
        return totalroamingcf;
    }

    public void setTotalroamingcf(String totalroamingcf) {
        this.totalroamingcf = totalroamingcf;
    }

    @Basic
    @Column(name = "TOTALCONTENTDOWNLOAD", nullable = true, length = 20)
    public String getTotalcontentdownload() {
        return totalcontentdownload;
    }

    public void setTotalcontentdownload(String totalcontentdownload) {
        this.totalcontentdownload = totalcontentdownload;
    }

    @Basic
    @Column(name = "TOTALHYBRIDBUNDLES", nullable = true, length = 20)
    public String getTotalhybridbundles() {
        return totalhybridbundles;
    }

    public void setTotalhybridbundles(String totalhybridbundles) {
        this.totalhybridbundles = totalhybridbundles;
    }

    @Basic
    @Column(name = "TOTALMMS", nullable = true, length = 20)
    public String getTotalmms() {
        return totalmms;
    }

    public void setTotalmms(String totalmms) {
        this.totalmms = totalmms;
    }

    @Basic
    @Column(name = "TOTALCF", nullable = true, length = 20)
    public String getTotalcf() {
        return totalcf;
    }

    public void setTotalcf(String totalcf) {
        this.totalcf = totalcf;
    }

    @Basic
    @Column(name = "TOTALGPRS", nullable = true, length = 20)
    public String getTotalgprs() {
        return totalgprs;
    }

    public void setTotalgprs(String totalgprs) {
        this.totalgprs = totalgprs;
    }

    @Basic
    @Column(name = "TOTALDATA", nullable = true, length = 20)
    public String getTotaldata() {
        return totaldata;
    }

    public void setTotaldata(String totaldata) {
        this.totaldata = totaldata;
    }

    @Basic
    @Column(name = "TOTALCASHIN", nullable = true, length = 20)
    public String getTotalcashin() {
        return totalcashin;
    }

    public void setTotalcashin(String totalcashin) {
        this.totalcashin = totalcashin;
    }

    @Basic
    @Column(name = "TOTALCASHOUT", nullable = true, length = 20)
    public String getTotalcashout() {
        return totalcashout;
    }

    public void setTotalcashout(String totalcashout) {
        this.totalcashout = totalcashout;
    }

    @Basic
    @Column(name = "TOTALAMTOPUP", nullable = true, length = 20)
    public String getTotalamtopup() {
        return totalamtopup;
    }

    public void setTotalamtopup(String totalamtopup) {
        this.totalamtopup = totalamtopup;
    }

    @Basic
    @Column(name = "TOTALMERCHANTPAYMENTS", nullable = true, length = 20)
    public String getTotalmerchantpayments() {
        return totalmerchantpayments;
    }

    public void setTotalmerchantpayments(String totalmerchantpayments) {
        this.totalmerchantpayments = totalmerchantpayments;
    }

    @Basic
    @Column(name = "TOTALP2P", nullable = true, length = 20)
    public String getTotalp2P() {
        return totalp2P;
    }

    public void setTotalp2P(String totalp2P) {
        this.totalp2P = totalp2P;
    }

    @Basic
    @Column(name = "TOTALWALLETLOAD", nullable = true, length = 20)
    public String getTotalwalletload() {
        return totalwalletload;
    }

    public void setTotalwalletload(String totalwalletload) {
        this.totalwalletload = totalwalletload;
    }

    @Basic
    @Column(name = "TOTALPOSWITHDRAWAL", nullable = true, length = 20)
    public String getTotalposwithdrawal() {
        return totalposwithdrawal;
    }

    public void setTotalposwithdrawal(String totalposwithdrawal) {
        this.totalposwithdrawal = totalposwithdrawal;
    }

    @Basic
    @Column(name = "DATEACTIVATED", nullable = true, length = 200)
    public String getDateactivated() {
        return dateactivated;
    }

    public void setDateactivated(String dateactivated) {
        this.dateactivated = dateactivated;
    }

    @Basic
    @Column(name = "MOSTFREQUENTLOCATION", nullable = true, length = 20)
    public String getMostfrequentlocation() {
        return mostfrequentlocation;
    }

    public void setMostfrequentlocation(String mostfrequentlocation) {
        this.mostfrequentlocation = mostfrequentlocation;
    }

    @Basic
    @Column(name = "CREATEDON", nullable = false)
    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MomRegistry that = (MomRegistry) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (accountid != null ? !accountid.equals(that.accountid) : that.accountid != null) return false;
        if (accountType != null ? !accountType.equals(that.accountType) : that.accountType != null) return false;
        if (totalgsmexpenditure != null ? !totalgsmexpenditure.equals(that.totalgsmexpenditure) : that.totalgsmexpenditure != null)
            return false;
        if (totalamdebit != null ? !totalamdebit.equals(that.totalamdebit) : that.totalamdebit != null) return false;
        if (totalamcredit != null ? !totalamcredit.equals(that.totalamcredit) : that.totalamcredit != null)
            return false;
        if (totalsms != null ? !totalsms.equals(that.totalsms) : that.totalsms != null) return false;
        if (totalussd != null ? !totalussd.equals(that.totalussd) : that.totalussd != null) return false;
        if (totalvoicecalls != null ? !totalvoicecalls.equals(that.totalvoicecalls) : that.totalvoicecalls != null)
            return false;
        if (totalroamingcf != null ? !totalroamingcf.equals(that.totalroamingcf) : that.totalroamingcf != null)
            return false;
        if (totalcontentdownload != null ? !totalcontentdownload.equals(that.totalcontentdownload) : that.totalcontentdownload != null)
            return false;
        if (totalhybridbundles != null ? !totalhybridbundles.equals(that.totalhybridbundles) : that.totalhybridbundles != null)
            return false;
        if (totalmms != null ? !totalmms.equals(that.totalmms) : that.totalmms != null) return false;
        if (totalcf != null ? !totalcf.equals(that.totalcf) : that.totalcf != null) return false;
        if (totalgprs != null ? !totalgprs.equals(that.totalgprs) : that.totalgprs != null) return false;
        if (totaldata != null ? !totaldata.equals(that.totaldata) : that.totaldata != null) return false;
        if (totalcashin != null ? !totalcashin.equals(that.totalcashin) : that.totalcashin != null) return false;
        if (totalcashout != null ? !totalcashout.equals(that.totalcashout) : that.totalcashout != null) return false;
        if (totalamtopup != null ? !totalamtopup.equals(that.totalamtopup) : that.totalamtopup != null) return false;
        if (totalmerchantpayments != null ? !totalmerchantpayments.equals(that.totalmerchantpayments) : that.totalmerchantpayments != null)
            return false;
        if (totalp2P != null ? !totalp2P.equals(that.totalp2P) : that.totalp2P != null) return false;
        if (totalwalletload != null ? !totalwalletload.equals(that.totalwalletload) : that.totalwalletload != null)
            return false;
        if (totalposwithdrawal != null ? !totalposwithdrawal.equals(that.totalposwithdrawal) : that.totalposwithdrawal != null)
            return false;
        if (dateactivated != null ? !dateactivated.equals(that.dateactivated) : that.dateactivated != null)
            return false;
        if (mostfrequentlocation != null ? !mostfrequentlocation.equals(that.mostfrequentlocation) : that.mostfrequentlocation != null)
            return false;
        if (createdon != null ? !createdon.equals(that.createdon) : that.createdon != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (accountid != null ? accountid.hashCode() : 0);
        result = 31 * result + (accountType != null ? accountType.hashCode() : 0);
        result = 31 * result + (totalgsmexpenditure != null ? totalgsmexpenditure.hashCode() : 0);
        result = 31 * result + (totalamdebit != null ? totalamdebit.hashCode() : 0);
        result = 31 * result + (totalamcredit != null ? totalamcredit.hashCode() : 0);
        result = 31 * result + (totalsms != null ? totalsms.hashCode() : 0);
        result = 31 * result + (totalussd != null ? totalussd.hashCode() : 0);
        result = 31 * result + (totalvoicecalls != null ? totalvoicecalls.hashCode() : 0);
        result = 31 * result + (totalroamingcf != null ? totalroamingcf.hashCode() : 0);
        result = 31 * result + (totalcontentdownload != null ? totalcontentdownload.hashCode() : 0);
        result = 31 * result + (totalhybridbundles != null ? totalhybridbundles.hashCode() : 0);
        result = 31 * result + (totalmms != null ? totalmms.hashCode() : 0);
        result = 31 * result + (totalcf != null ? totalcf.hashCode() : 0);
        result = 31 * result + (totalgprs != null ? totalgprs.hashCode() : 0);
        result = 31 * result + (totaldata != null ? totaldata.hashCode() : 0);
        result = 31 * result + (totalcashin != null ? totalcashin.hashCode() : 0);
        result = 31 * result + (totalcashout != null ? totalcashout.hashCode() : 0);
        result = 31 * result + (totalamtopup != null ? totalamtopup.hashCode() : 0);
        result = 31 * result + (totalmerchantpayments != null ? totalmerchantpayments.hashCode() : 0);
        result = 31 * result + (totalp2P != null ? totalp2P.hashCode() : 0);
        result = 31 * result + (totalwalletload != null ? totalwalletload.hashCode() : 0);
        result = 31 * result + (totalposwithdrawal != null ? totalposwithdrawal.hashCode() : 0);
        result = 31 * result + (dateactivated != null ? dateactivated.hashCode() : 0);
        result = 31 * result + (mostfrequentlocation != null ? mostfrequentlocation.hashCode() : 0);
        result = 31 * result + (createdon != null ? createdon.hashCode() : 0);
        return result;
    }

    @PrePersist
    protected void onCreate() {
        if (createdon== null) createdon = new Date();
    }
}
