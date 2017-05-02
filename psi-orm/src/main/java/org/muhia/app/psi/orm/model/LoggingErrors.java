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
@Table(name = "LOG_LOGGING_ERRORS")
public class LoggingErrors {
    private Long logId;
    private Long logCode;
    private Date logDate;
    private String logMessage;
    private String logger;

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
    @Column(name = "LOG_TIMESTAMP", nullable = true)
    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    @Basic
    @Column(name = "LOG_MESSAGE", nullable = true, length = 4000)
    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    @Basic
    @Column(name = "LOGGER", nullable = true, length = 300)
    public String getLogger() {
        return logger;
    }

    public void setLogger(String logger) {
        this.logger = logger;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoggingErrors that = (LoggingErrors) o;

        if (logId != null ? !logId.equals(that.logId) : that.logId != null) return false;
        if (logCode != null ? !logCode.equals(that.logCode) : that.logCode != null) return false;
        if (logDate != null ? !logDate.equals(that.logDate) : that.logDate != null) return false;
        if (logMessage != null ? !logMessage.equals(that.logMessage) : that.logMessage != null) return false;
        if (logger != null ? !logger.equals(that.logger) : that.logger != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = logId != null ? logId.hashCode() : 0;
        result = 31 * result + (logCode != null ? logCode.hashCode() : 0);
        result = 31 * result + (logDate != null ? logDate.hashCode() : 0);
        result = 31 * result + (logMessage != null ? logMessage.hashCode() : 0);
        result = 31 * result + (logger != null ? logger.hashCode() : 0);
        return result;
    }
}
