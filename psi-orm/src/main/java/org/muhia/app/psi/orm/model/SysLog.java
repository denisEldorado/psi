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
@Table(name = "DAT_SYS_LOG")
public class SysLog {
    private Long logId;
    private Long logCode;
    private String logDesc;
    private Long logLevel;
    private Long logResolved;
    private Long resolvUserid;
    private String resolvNarrative;
    private Date logResoltime;

    @Id
    @Column(name = "LOG_ID", nullable = true, precision = 0)
    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    @Basic
    @Column(name = "LOG_CODE", nullable = true, precision = 0)
    public Long getLogCode() {
        return logCode;
    }

    public void setLogCode(Long logCode) {
        this.logCode = logCode;
    }

    @Basic
    @Column(name = "LOG_DESC", nullable = true, length = 4000)
    public String getLogDesc() {
        return logDesc;
    }

    public void setLogDesc(String logDesc) {
        this.logDesc = logDesc;
    }

    @Basic
    @Column(name = "LOG_LEVEL", nullable = true, precision = 0)
    public Long getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(Long logLevel) {
        this.logLevel = logLevel;
    }

    @Basic
    @Column(name = "LOG_RESOLVED", nullable = true, precision = 0)
    public Long getLogResolved() {
        return logResolved;
    }

    public void setLogResolved(Long logResolved) {
        this.logResolved = logResolved;
    }

    @Basic
    @Column(name = "RESOLV_USERID", nullable = true, precision = 0)
    public Long getResolvUserid() {
        return resolvUserid;
    }

    public void setResolvUserid(Long resolvUserid) {
        this.resolvUserid = resolvUserid;
    }

    @Basic
    @Column(name = "RESOLV_NARRATIVE", nullable = true, length = 4000)
    public String getResolvNarrative() {
        return resolvNarrative;
    }

    public void setResolvNarrative(String resolvNarrative) {
        this.resolvNarrative = resolvNarrative;
    }

    @Basic
    @Column(name = "LOG_RESOLTIME", nullable = true)
    public Date getLogResoltime() {
        return logResoltime;
    }

    public void setLogResoltime(Date logResoltime) {
        this.logResoltime = logResoltime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysLog sysLog = (SysLog) o;

        if (logId != null ? !logId.equals(sysLog.logId) : sysLog.logId != null) return false;
        if (logCode != null ? !logCode.equals(sysLog.logCode) : sysLog.logCode != null) return false;
        if (logDesc != null ? !logDesc.equals(sysLog.logDesc) : sysLog.logDesc != null) return false;
        if (logLevel != null ? !logLevel.equals(sysLog.logLevel) : sysLog.logLevel != null) return false;
        if (logResolved != null ? !logResolved.equals(sysLog.logResolved) : sysLog.logResolved != null) return false;
        if (resolvUserid != null ? !resolvUserid.equals(sysLog.resolvUserid) : sysLog.resolvUserid != null)
            return false;
        if (resolvNarrative != null ? !resolvNarrative.equals(sysLog.resolvNarrative) : sysLog.resolvNarrative != null)
            return false;
        if (logResoltime != null ? !logResoltime.equals(sysLog.logResoltime) : sysLog.logResoltime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = logId != null ? logId.hashCode() : 0;
        result = 31 * result + (logCode != null ? logCode.hashCode() : 0);
        result = 31 * result + (logDesc != null ? logDesc.hashCode() : 0);
        result = 31 * result + (logLevel != null ? logLevel.hashCode() : 0);
        result = 31 * result + (logResolved != null ? logResolved.hashCode() : 0);
        result = 31 * result + (resolvUserid != null ? resolvUserid.hashCode() : 0);
        result = 31 * result + (resolvNarrative != null ? resolvNarrative.hashCode() : 0);
        result = 31 * result + (logResoltime != null ? logResoltime.hashCode() : 0);
        return result;
    }
}
