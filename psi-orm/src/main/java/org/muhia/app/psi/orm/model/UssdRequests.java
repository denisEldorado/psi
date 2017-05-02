package org.muhia.app.psi.orm.model;

import javax.persistence.*;
import java.util.Date;

/*
  Created by Kenneth
  Project: psi
  Package: org.muhia.apps.psi.orm.model
  Generated on: 30-Mar-17, 08:43.
 */
@Entity
@Table(name = "LOG_USSD_REQUESTS")
public class UssdRequests {
    private Long id;
    private String requestUserid;
    private String requestPassword;
    private String code;
    private String requestInput;
    private String sessionid;
    private String msisdn;
    private String transactionid;
    private String imsi;
    private String newrequest;
    private String clean;
    private String status;
    private String requestIp;
    private Date requestDate;
    private String varFld1;
    private String varFld2;
    private String varFld3;
    private String varFld4;
    private String varFld5;
    private String varFld6;
    private String varFld7;
    private String varFld8;
    private String varFld9;
    private String varFld10;
    private String varFld11;
    private String varFld12;
    private String varFld13;
    private String varFld14;
    private String varFld15;

    @Id
    @SequenceGenerator(name = "LOG_USSD_REQUESTS_SEQ_GEN", sequenceName = "LOG_USSD_REQUESTS_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "LOG_USSD_REQUESTS_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "REQUEST_USERID", nullable = true, length = 200)
    public String getRequestUserid() {
        return requestUserid;
    }

    public void setRequestUserid(String requestUserid) {
        this.requestUserid = requestUserid;
    }

    @Basic
    @Column(name = "REQUEST_PASSWORD", nullable = true, length = 500)
    public String getRequestPassword() {
        return requestPassword;
    }

    public void setRequestPassword(String requestPassword) {
        this.requestPassword = requestPassword;
    }

    @Basic
    @Column(name = "CODE", nullable = true, length = 200)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "REQUEST_INPUT", nullable = true, length = 200)
    public String getRequestInput() {
        return requestInput;
    }

    public void setRequestInput(String requestInput) {
        this.requestInput = requestInput;
    }

    @Basic
    @Column(name = "SESSIONID", nullable = true, length = 200)
    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }

    @Basic
    @Column(name = "MSISDN", nullable = true, length = 200)
    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    @Basic
    @Column(name = "TRANSACTIONID", nullable = true, length = 200)
    public String getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid;
    }

    @Basic
    @Column(name = "IMSI", nullable = true, length = 200)
    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    @Basic
    @Column(name = "NEWREQUEST", nullable = true, length = 20)
    public String getNewrequest() {
        return newrequest;
    }

    public void setNewrequest(String newrequest) {
        this.newrequest = newrequest;
    }

    @Basic
    @Column(name = "CLEAN", nullable = true, length = 100)
    public String getClean() {
        return clean;
    }

    public void setClean(String clean) {
        this.clean = clean;
    }

    @Basic
    @Column(name = "STATUS", nullable = true, length = 200)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "REQUEST_IP", nullable = true, length = 100)
    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp;
    }

    @Basic
    @Column(name = "REQUEST_DATE", nullable = true)
    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    @Basic
    @Column(name = "VAR_FLD_1", nullable = true, length = 300)
    public String getVarFld1() {
        return varFld1;
    }

    public void setVarFld1(String varFld1) {
        this.varFld1 = varFld1;
    }

    @Basic
    @Column(name = "VAR_FLD_2", nullable = true, length = 200)
    public String getVarFld2() {
        return varFld2;
    }

    public void setVarFld2(String varFld2) {
        this.varFld2 = varFld2;
    }

    @Basic
    @Column(name = "VAR_FLD_3", nullable = true, length = 100)
    public String getVarFld3() {
        return varFld3;
    }

    public void setVarFld3(String varFld3) {
        this.varFld3 = varFld3;
    }

    @Basic
    @Column(name = "VAR_FLD_4", nullable = true, length = 200)
    public String getVarFld4() {
        return varFld4;
    }

    public void setVarFld4(String varFld4) {
        this.varFld4 = varFld4;
    }

    @Basic
    @Column(name = "VAR_FLD_5", nullable = true, length = 100)
    public String getVarFld5() {
        return varFld5;
    }

    public void setVarFld5(String varFld5) {
        this.varFld5 = varFld5;
    }

    @Basic
    @Column(name = "VAR_FLD_6", nullable = true, length = 100)
    public String getVarFld6() {
        return varFld6;
    }

    public void setVarFld6(String varFld6) {
        this.varFld6 = varFld6;
    }

    @Basic
    @Column(name = "VAR_FLD_7", nullable = true, length = 200)
    public String getVarFld7() {
        return varFld7;
    }

    public void setVarFld7(String varFld7) {
        this.varFld7 = varFld7;
    }

    @Basic
    @Column(name = "VAR_FLD_8", nullable = true, length = 200)
    public String getVarFld8() {
        return varFld8;
    }

    public void setVarFld8(String varFld8) {
        this.varFld8 = varFld8;
    }

    @Basic
    @Column(name = "VAR_FLD_9", nullable = true, length = 200)
    public String getVarFld9() {
        return varFld9;
    }

    public void setVarFld9(String varFld9) {
        this.varFld9 = varFld9;
    }

    @Basic
    @Column(name = "VAR_FLD_10", nullable = true, length = 200)
    public String getVarFld10() {
        return varFld10;
    }

    public void setVarFld10(String varFld10) {
        this.varFld10 = varFld10;
    }

    @Basic
    @Column(name = "VAR_FLD_11", nullable = true, length = 200)
    public String getVarFld11() {
        return varFld11;
    }

    public void setVarFld11(String varFld11) {
        this.varFld11 = varFld11;
    }

    @Basic
    @Column(name = "VAR_FLD_12", nullable = true, length = 200)
    public String getVarFld12() {
        return varFld12;
    }

    public void setVarFld12(String varFld12) {
        this.varFld12 = varFld12;
    }

    @Basic
    @Column(name = "VAR_FLD_13", nullable = true, length = 200)
    public String getVarFld13() {
        return varFld13;
    }

    public void setVarFld13(String varFld13) {
        this.varFld13 = varFld13;
    }

    @Basic
    @Column(name = "VAR_FLD_14", nullable = true, length = 200)
    public String getVarFld14() {
        return varFld14;
    }

    public void setVarFld14(String varFld14) {
        this.varFld14 = varFld14;
    }

    @Basic
    @Column(name = "VAR_FLD_15", nullable = true, length = 200)
    public String getVarFld15() {
        return varFld15;
    }

    public void setVarFld15(String varFld15) {
        this.varFld15 = varFld15;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UssdRequests that = (UssdRequests) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (requestUserid != null ? !requestUserid.equals(that.requestUserid) : that.requestUserid != null)
            return false;
        if (requestPassword != null ? !requestPassword.equals(that.requestPassword) : that.requestPassword != null)
            return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (requestInput != null ? !requestInput.equals(that.requestInput) : that.requestInput != null) return false;
        if (sessionid != null ? !sessionid.equals(that.sessionid) : that.sessionid != null) return false;
        if (msisdn != null ? !msisdn.equals(that.msisdn) : that.msisdn != null) return false;
        if (transactionid != null ? !transactionid.equals(that.transactionid) : that.transactionid != null)
            return false;
        if (imsi != null ? !imsi.equals(that.imsi) : that.imsi != null) return false;
        if (newrequest != null ? !newrequest.equals(that.newrequest) : that.newrequest != null) return false;
        if (clean != null ? !clean.equals(that.clean) : that.clean != null) return false;
        //if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (requestIp != null ? !requestIp.equals(that.requestIp) : that.requestIp != null) return false;
        if (requestDate != null ? !requestDate.equals(that.requestDate) : that.requestDate != null) return false;
        if (varFld1 != null ? !varFld1.equals(that.varFld1) : that.varFld1 != null) return false;
        if (varFld2 != null ? !varFld2.equals(that.varFld2) : that.varFld2 != null) return false;
        if (varFld3 != null ? !varFld3.equals(that.varFld3) : that.varFld3 != null) return false;
        if (varFld4 != null ? !varFld4.equals(that.varFld4) : that.varFld4 != null) return false;
        if (varFld5 != null ? !varFld5.equals(that.varFld5) : that.varFld5 != null) return false;
        if (varFld6 != null ? !varFld6.equals(that.varFld6) : that.varFld6 != null) return false;
        if (varFld7 != null ? !varFld7.equals(that.varFld7) : that.varFld7 != null) return false;
        if (varFld8 != null ? !varFld8.equals(that.varFld8) : that.varFld8 != null) return false;
        if (varFld9 != null ? !varFld9.equals(that.varFld9) : that.varFld9 != null) return false;
        if (varFld10 != null ? !varFld10.equals(that.varFld10) : that.varFld10 != null) return false;
        if (varFld11 != null ? !varFld11.equals(that.varFld11) : that.varFld11 != null) return false;
        if (varFld12 != null ? !varFld12.equals(that.varFld12) : that.varFld12 != null) return false;
        if (varFld13 != null ? !varFld13.equals(that.varFld13) : that.varFld13 != null) return false;
        if (varFld14 != null ? !varFld14.equals(that.varFld14) : that.varFld14 != null) return false;
        if (varFld15 != null ? !varFld15.equals(that.varFld15) : that.varFld15 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (requestUserid != null ? requestUserid.hashCode() : 0);
        result = 31 * result + (requestPassword != null ? requestPassword.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (requestInput != null ? requestInput.hashCode() : 0);
        result = 31 * result + (sessionid != null ? sessionid.hashCode() : 0);
        result = 31 * result + (msisdn != null ? msisdn.hashCode() : 0);
        result = 31 * result + (transactionid != null ? transactionid.hashCode() : 0);
        result = 31 * result + (imsi != null ? imsi.hashCode() : 0);
        result = 31 * result + (newrequest != null ? newrequest.hashCode() : 0);
        result = 31 * result + (clean != null ? clean.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (requestIp != null ? requestIp.hashCode() : 0);
        result = 31 * result + (requestDate != null ? requestDate.hashCode() : 0);
        result = 31 * result + (varFld1 != null ? varFld1.hashCode() : 0);
        result = 31 * result + (varFld2 != null ? varFld2.hashCode() : 0);
        result = 31 * result + (varFld3 != null ? varFld3.hashCode() : 0);
        result = 31 * result + (varFld4 != null ? varFld4.hashCode() : 0);
        result = 31 * result + (varFld5 != null ? varFld5.hashCode() : 0);
        result = 31 * result + (varFld6 != null ? varFld6.hashCode() : 0);
        result = 31 * result + (varFld7 != null ? varFld7.hashCode() : 0);
        result = 31 * result + (varFld8 != null ? varFld8.hashCode() : 0);
        result = 31 * result + (varFld9 != null ? varFld9.hashCode() : 0);
        result = 31 * result + (varFld10 != null ? varFld10.hashCode() : 0);
        result = 31 * result + (varFld11 != null ? varFld11.hashCode() : 0);
        result = 31 * result + (varFld12 != null ? varFld12.hashCode() : 0);
        result = 31 * result + (varFld13 != null ? varFld13.hashCode() : 0);
        result = 31 * result + (varFld14 != null ? varFld14.hashCode() : 0);
        result = 31 * result + (varFld15 != null ? varFld15.hashCode() : 0);
        return result;
    }
}
