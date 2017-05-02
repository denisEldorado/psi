package org.muhia.app.psi.orm.model;

import javax.persistence.*;
import java.util.Date;

/*
  Created by Kenneth
  Project: psi
  Package: org.muhia.apps.psi.orm.model
  Generated on: 30-Mar-17, 08:41.
 */
@Entity
@Table(name = "CFG_OBAPAY_ERRORCODES")
public class ObaPayErrorCode {
    private Long id;
    private String errorcode;
    private Integer status;
    private Long retryattempts;
    private Date createdon;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ERRORCODE", nullable = true, length = 20)
    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }

    @Basic
    @Column(name = "STATUS", nullable = true, precision = 0)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "RETRYATTEMPTS", nullable = true, precision = 0)
    public Long getRetryattempts() {
        return retryattempts;
    }

    public void setRetryattempts(Long retryattempts) {
        this.retryattempts = retryattempts;
    }

    @Basic
    @Column(name = "CREATEDON", nullable = true)
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

        ObaPayErrorCode that = (ObaPayErrorCode) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (errorcode != null ? !errorcode.equals(that.errorcode) : that.errorcode != null) return false;
        //if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (retryattempts != null ? !retryattempts.equals(that.retryattempts) : that.retryattempts != null)
            return false;
        if (createdon != null ? !createdon.equals(that.createdon) : that.createdon != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (errorcode != null ? errorcode.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (retryattempts != null ? retryattempts.hashCode() : 0);
        result = 31 * result + (createdon != null ? createdon.hashCode() : 0);
        return result;
    }
}
