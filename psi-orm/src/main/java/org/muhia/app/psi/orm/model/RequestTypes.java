package org.muhia.app.psi.orm.model;

import javax.persistence.*;
import java.util.Date;;

/*
  Created by Kenneth
  Project: psi
  Package: org.muhia.apps.psi.orm.model
  Generated on: 30-Mar-17, 08:41.
 */
@Entity
@Table(name = "CRM_REQUEST_TYPES")
public class RequestTypes {
    private Long id;
    private String requestsRequestName;
    private String requestMethodName;
    private String requestsRequestDescription;
    private int status;
    private String requestMethodParam1;
    private String requestMethodParam2;
    private String requestMethodParam4;
    private String requestMethodParam5;
    private String requestMethodParam6;
    private String requestMethodParam7;
    private String requestMethodParam8;
    private String createdby;
    private Date createdon;
    private String modifiedby;
    private Date modifiedon;
    private String deleteby;
    private Date deletedon;
    private String varFld1;
    private String varFld2;
    private String varFld3;
    private String varFld4;
    private String varFld5;
    private String varFld6;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "REQUESTS_REQUEST_NAME", nullable = true, length = 500)
    public String getRequestsRequestName() {
        return requestsRequestName;
    }

    public void setRequestsRequestName(String requestsRequestName) {
        this.requestsRequestName = requestsRequestName;
    }

    @Basic
    @Column(name = "REQUEST_METHOD_NAME", nullable = false, length = 100)
    public String getRequestMethodName() {
        return requestMethodName;
    }

    public void setRequestMethodName(String requestMethodName) {
        this.requestMethodName = requestMethodName;
    }

    @Basic
    @Column(name = "REQUESTS_REQUEST_DESCRIPTION", nullable = true, length = 500)
    public String getRequestsRequestDescription() {
        return requestsRequestDescription;
    }

    public void setRequestsRequestDescription(String requestsRequestDescription) {
        this.requestsRequestDescription = requestsRequestDescription;
    }

    @Basic
    @Column(name = "STATUS", nullable = false, precision = 0)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "REQUEST_METHOD_PARAM_1", nullable = true, length = 100)
    public String getRequestMethodParam1() {
        return requestMethodParam1;
    }

    public void setRequestMethodParam1(String requestMethodParam1) {
        this.requestMethodParam1 = requestMethodParam1;
    }

    @Basic
    @Column(name = "REQUEST_METHOD_PARAM_2", nullable = true, length = 100)
    public String getRequestMethodParam2() {
        return requestMethodParam2;
    }

    public void setRequestMethodParam2(String requestMethodParam2) {
        this.requestMethodParam2 = requestMethodParam2;
    }

    @Basic
    @Column(name = "REQUEST_METHOD_PARAM_4", nullable = true, length = 100)
    public String getRequestMethodParam4() {
        return requestMethodParam4;
    }

    public void setRequestMethodParam4(String requestMethodParam4) {
        this.requestMethodParam4 = requestMethodParam4;
    }

    @Basic
    @Column(name = "REQUEST_METHOD_PARAM_5", nullable = true, length = 100)
    public String getRequestMethodParam5() {
        return requestMethodParam5;
    }

    public void setRequestMethodParam5(String requestMethodParam5) {
        this.requestMethodParam5 = requestMethodParam5;
    }

    @Basic
    @Column(name = "REQUEST_METHOD_PARAM_6", nullable = true, length = 100)
    public String getRequestMethodParam6() {
        return requestMethodParam6;
    }

    public void setRequestMethodParam6(String requestMethodParam6) {
        this.requestMethodParam6 = requestMethodParam6;
    }

    @Basic
    @Column(name = "REQUEST_METHOD_PARAM_7", nullable = true, length = 100)
    public String getRequestMethodParam7() {
        return requestMethodParam7;
    }

    public void setRequestMethodParam7(String requestMethodParam7) {
        this.requestMethodParam7 = requestMethodParam7;
    }

    @Basic
    @Column(name = "REQUEST_METHOD_PARAM_8", nullable = true, length = 100)
    public String getRequestMethodParam8() {
        return requestMethodParam8;
    }

    public void setRequestMethodParam8(String requestMethodParam8) {
        this.requestMethodParam8 = requestMethodParam8;
    }

    @Basic
    @Column(name = "CREATEDBY", nullable = true, length = 100)
    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    @Basic
    @Column(name = "CREATEDON", nullable = true)
    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
    }

    @Basic
    @Column(name = "MODIFIEDBY", nullable = true, length = 100)
    public String getModifiedby() {
        return modifiedby;
    }

    public void setModifiedby(String modifiedby) {
        this.modifiedby = modifiedby;
    }

    @Basic
    @Column(name = "MODIFIEDON", nullable = true)
    public Date getModifiedon() {
        return modifiedon;
    }

    public void setModifiedon(Date modifiedon) {
        this.modifiedon = modifiedon;
    }

    @Basic
    @Column(name = "DELETEBY", nullable = true, length = 100)
    public String getDeleteby() {
        return deleteby;
    }

    public void setDeleteby(String deleteby) {
        this.deleteby = deleteby;
    }

    @Basic
    @Column(name = "DELETEDON", nullable = true)
    public Date getDeletedon() {
        return deletedon;
    }

    public void setDeletedon(Date deletedon) {
        this.deletedon = deletedon;
    }

    @Basic
    @Column(name = "VAR_FLD_1", nullable = true, length = 100)
    public String getVarFld1() {
        return varFld1;
    }

    public void setVarFld1(String varFld1) {
        this.varFld1 = varFld1;
    }

    @Basic
    @Column(name = "VAR_FLD_2", nullable = true, length = 100)
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
    @Column(name = "VAR_FLD_4", nullable = true, length = 100)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RequestTypes that = (RequestTypes) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (requestsRequestName != null ? !requestsRequestName.equals(that.requestsRequestName) : that.requestsRequestName != null)
            return false;
        if (requestMethodName != null ? !requestMethodName.equals(that.requestMethodName) : that.requestMethodName != null)
            return false;
        if (requestsRequestDescription != null ? !requestsRequestDescription.equals(that.requestsRequestDescription) : that.requestsRequestDescription != null)
            return false;
        //if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (requestMethodParam1 != null ? !requestMethodParam1.equals(that.requestMethodParam1) : that.requestMethodParam1 != null)
            return false;
        if (requestMethodParam2 != null ? !requestMethodParam2.equals(that.requestMethodParam2) : that.requestMethodParam2 != null)
            return false;
        if (requestMethodParam4 != null ? !requestMethodParam4.equals(that.requestMethodParam4) : that.requestMethodParam4 != null)
            return false;
        if (requestMethodParam5 != null ? !requestMethodParam5.equals(that.requestMethodParam5) : that.requestMethodParam5 != null)
            return false;
        if (requestMethodParam6 != null ? !requestMethodParam6.equals(that.requestMethodParam6) : that.requestMethodParam6 != null)
            return false;
        if (requestMethodParam7 != null ? !requestMethodParam7.equals(that.requestMethodParam7) : that.requestMethodParam7 != null)
            return false;
        if (requestMethodParam8 != null ? !requestMethodParam8.equals(that.requestMethodParam8) : that.requestMethodParam8 != null)
            return false;
        if (createdby != null ? !createdby.equals(that.createdby) : that.createdby != null) return false;
        if (createdon != null ? !createdon.equals(that.createdon) : that.createdon != null) return false;
        if (modifiedby != null ? !modifiedby.equals(that.modifiedby) : that.modifiedby != null) return false;
        if (modifiedon != null ? !modifiedon.equals(that.modifiedon) : that.modifiedon != null) return false;
        if (deleteby != null ? !deleteby.equals(that.deleteby) : that.deleteby != null) return false;
        if (deletedon != null ? !deletedon.equals(that.deletedon) : that.deletedon != null) return false;
        if (varFld1 != null ? !varFld1.equals(that.varFld1) : that.varFld1 != null) return false;
        if (varFld2 != null ? !varFld2.equals(that.varFld2) : that.varFld2 != null) return false;
        if (varFld3 != null ? !varFld3.equals(that.varFld3) : that.varFld3 != null) return false;
        if (varFld4 != null ? !varFld4.equals(that.varFld4) : that.varFld4 != null) return false;
        if (varFld5 != null ? !varFld5.equals(that.varFld5) : that.varFld5 != null) return false;
        if (varFld6 != null ? !varFld6.equals(that.varFld6) : that.varFld6 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (requestsRequestName != null ? requestsRequestName.hashCode() : 0);
        result = 31 * result + (requestMethodName != null ? requestMethodName.hashCode() : 0);
        result = 31 * result + (requestsRequestDescription != null ? requestsRequestDescription.hashCode() : 0);

        result = 31 * result + (requestMethodParam1 != null ? requestMethodParam1.hashCode() : 0);
        result = 31 * result + (requestMethodParam2 != null ? requestMethodParam2.hashCode() : 0);
        result = 31 * result + (requestMethodParam4 != null ? requestMethodParam4.hashCode() : 0);
        result = 31 * result + (requestMethodParam5 != null ? requestMethodParam5.hashCode() : 0);
        result = 31 * result + (requestMethodParam6 != null ? requestMethodParam6.hashCode() : 0);
        result = 31 * result + (requestMethodParam7 != null ? requestMethodParam7.hashCode() : 0);
        result = 31 * result + (requestMethodParam8 != null ? requestMethodParam8.hashCode() : 0);
        result = 31 * result + (createdby != null ? createdby.hashCode() : 0);
        result = 31 * result + (createdon != null ? createdon.hashCode() : 0);
        result = 31 * result + (modifiedby != null ? modifiedby.hashCode() : 0);
        result = 31 * result + (modifiedon != null ? modifiedon.hashCode() : 0);
        result = 31 * result + (deleteby != null ? deleteby.hashCode() : 0);
        result = 31 * result + (deletedon != null ? deletedon.hashCode() : 0);
        result = 31 * result + (varFld1 != null ? varFld1.hashCode() : 0);
        result = 31 * result + (varFld2 != null ? varFld2.hashCode() : 0);
        result = 31 * result + (varFld3 != null ? varFld3.hashCode() : 0);
        result = 31 * result + (varFld4 != null ? varFld4.hashCode() : 0);
        result = 31 * result + (varFld5 != null ? varFld5.hashCode() : 0);
        result = 31 * result + (varFld6 != null ? varFld6.hashCode() : 0);
        return result;
    }
}
