package org.muhia.app.psi.orm.model;

import javax.persistence.*;
import java.util.Date;;

/*
  Created by Kenneth
  Project: psi
  Package: org.muhia.apps.psi.orm.model
  Generated on: 30-Mar-17, 08:42.
 */
@Entity
@Table(name = "LOG_SITE_STATISTICS")
public class SiteStatistics {
    private Long id;
    private Date statisticsDate;
    private String ipAddress;
    private String requestMethod;
    private String queryString;
    private String requestedUriPath;
    private String requestedThreadName;
    private String protocol;
    private String responseStatus;
    private Long bytesSent;
    private Long bytesReceive;
    private Long timeToProcessRequest;
    private Long timeToCommitRequest;
    private String varFld01;
    private String varFld02;
    private String varFld03;
    private String varFld04;
    private String varFld05;
    private String varFld06;
    private String varFld07;
    private String varFld08;
    private String varFld09;
    private String varFld10;
    private int status;
    private String createdby;
    private Date createdon;
    private String modifiedby;
    private Date modifiedOn;
    private String deleteby;
    private Date deletedon;

    @Id
    @SequenceGenerator(name = "LOG_SITE_STATISTICS_SEQ_GEN", sequenceName = "LOG_SITE_STATISTICS_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "LOG_SITE_STATISTICS_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "STATISTICS_DATE", nullable = false)
    public Date getStatisticsDate() {
        return statisticsDate;
    }

    public void setStatisticsDate(Date statisticsDate) {
        this.statisticsDate = statisticsDate;
    }

    @Basic
    @Column(name = "IP_ADDRESS", nullable = false, length = 100)
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Basic
    @Column(name = "REQUEST_METHOD", nullable = false, length = 200)
    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    @Basic
    @Column(name = "QUERY_STRING", nullable = false, length = 200)
    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    @Basic
    @Column(name = "REQUESTED_URI_PATH", nullable = false, length = 500)
    public String getRequestedUriPath() {
        return requestedUriPath;
    }

    public void setRequestedUriPath(String requestedUriPath) {
        this.requestedUriPath = requestedUriPath;
    }

    @Basic
    @Column(name = "REQUESTED_THREAD_NAME", nullable = true, length = 500)
    public String getRequestedThreadName() {
        return requestedThreadName;
    }

    public void setRequestedThreadName(String requestedThreadName) {
        this.requestedThreadName = requestedThreadName;
    }

    @Basic
    @Column(name = "PROTOCOL", nullable = false, length = 100)
    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    @Basic
    @Column(name = "RESPONSE_STATUS", nullable = false, length = 10)
    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    @Basic
    @Column(name = "BYTES_SENT", precision = 3)
    public Long getintsSent() {
        return bytesSent;
    }

    public void setintsSent(Long bytesSent) {
        this.bytesSent = bytesSent;
    }

    @Basic
    @Column(name = "BYTES_RECEIVE", precision = 3)
    public Long getintsReceive() {
        return bytesReceive;
    }

    public void setintsReceive(Long bytesReceive) {
        this.bytesReceive = bytesReceive;
    }

    @Basic
    @Column(name = "TIME_TO_PROCESS_REQUEST", nullable = true, precision = 0)
    public Long getDateToProcessRequest() {
        return timeToProcessRequest;
    }

    public void setDateToProcessRequest(Long timeToProcessRequest) {
        this.timeToProcessRequest = timeToProcessRequest;
    }

    @Basic
    @Column(name = "TIME_TO_COMMIT_REQUEST", nullable = true, precision = 0)
    public Long getDateToCommitRequest() {
        return timeToCommitRequest;
    }

    public void setDateToCommitRequest(Long timeToCommitRequest) {
        this.timeToCommitRequest = timeToCommitRequest;
    }

    @Basic
    @Column(name = "VAR_FLD_01", nullable = true, length = 255)
    public String getVarFld01() {
        return varFld01;
    }

    public void setVarFld01(String varFld01) {
        this.varFld01 = varFld01;
    }

    @Basic
    @Column(name = "VAR_FLD_02", nullable = true, length = 255)
    public String getVarFld02() {
        return varFld02;
    }

    public void setVarFld02(String varFld02) {
        this.varFld02 = varFld02;
    }

    @Basic
    @Column(name = "VAR_FLD_03", nullable = true, length = 255)
    public String getVarFld03() {
        return varFld03;
    }

    public void setVarFld03(String varFld03) {
        this.varFld03 = varFld03;
    }

    @Basic
    @Column(name = "VAR_FLD_04", nullable = true, length = 255)
    public String getVarFld04() {
        return varFld04;
    }

    public void setVarFld04(String varFld04) {
        this.varFld04 = varFld04;
    }

    @Basic
    @Column(name = "VAR_FLD_05", nullable = true, length = 255)
    public String getVarFld05() {
        return varFld05;
    }

    public void setVarFld05(String varFld05) {
        this.varFld05 = varFld05;
    }

    @Basic
    @Column(name = "VAR_FLD_06", nullable = true, length = 4000)
    public String getVarFld06() {
        return varFld06;
    }

    public void setVarFld06(String varFld06) {
        this.varFld06 = varFld06;
    }

    @Basic
    @Column(name = "VAR_FLD_07", nullable = true, length = 255)
    public String getVarFld07() {
        return varFld07;
    }

    public void setVarFld07(String varFld07) {
        this.varFld07 = varFld07;
    }

    @Basic
    @Column(name = "VAR_FLD_08", nullable = true, length = 255)
    public String getVarFld08() {
        return varFld08;
    }

    public void setVarFld08(String varFld08) {
        this.varFld08 = varFld08;
    }

    @Basic
    @Column(name = "VAR_FLD_09", nullable = true, length = 255)
    public String getVarFld09() {
        return varFld09;
    }

    public void setVarFld09(String varFld09) {
        this.varFld09 = varFld09;
    }

    @Basic
    @Column(name = "VAR_FLD_10", nullable = true, length = 255)
    public String getVarFld10() {
        return varFld10;
    }

    public void setVarFld10(String varFld10) {
        this.varFld10 = varFld10;
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
    @Column(name = "MODIFIED_ON", nullable = true)
    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SiteStatistics that = (SiteStatistics) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (statisticsDate != null ? !statisticsDate.equals(that.statisticsDate) : that.statisticsDate != null)
            return false;
        if (ipAddress != null ? !ipAddress.equals(that.ipAddress) : that.ipAddress != null) return false;
        if (requestMethod != null ? !requestMethod.equals(that.requestMethod) : that.requestMethod != null)
            return false;
        if (queryString != null ? !queryString.equals(that.queryString) : that.queryString != null) return false;
        if (requestedUriPath != null ? !requestedUriPath.equals(that.requestedUriPath) : that.requestedUriPath != null)
            return false;
        if (requestedThreadName != null ? !requestedThreadName.equals(that.requestedThreadName) : that.requestedThreadName != null)
            return false;
        if (protocol != null ? !protocol.equals(that.protocol) : that.protocol != null) return false;
        if (responseStatus != null ? !responseStatus.equals(that.responseStatus) : that.responseStatus != null)
            return false;
        if (bytesSent != null ? !bytesSent.equals(that.bytesSent) : that.bytesSent != null) return false;
        if (bytesReceive != null ? !bytesReceive.equals(that.bytesReceive) : that.bytesReceive != null) return false;
        if (timeToProcessRequest != null ? !timeToProcessRequest.equals(that.timeToProcessRequest) : that.timeToProcessRequest != null)
            return false;
        if (timeToCommitRequest != null ? !timeToCommitRequest.equals(that.timeToCommitRequest) : that.timeToCommitRequest != null)
            return false;
        if (varFld01 != null ? !varFld01.equals(that.varFld01) : that.varFld01 != null) return false;
        if (varFld02 != null ? !varFld02.equals(that.varFld02) : that.varFld02 != null) return false;
        if (varFld03 != null ? !varFld03.equals(that.varFld03) : that.varFld03 != null) return false;
        if (varFld04 != null ? !varFld04.equals(that.varFld04) : that.varFld04 != null) return false;
        if (varFld05 != null ? !varFld05.equals(that.varFld05) : that.varFld05 != null) return false;
        if (varFld06 != null ? !varFld06.equals(that.varFld06) : that.varFld06 != null) return false;
        if (varFld07 != null ? !varFld07.equals(that.varFld07) : that.varFld07 != null) return false;
        if (varFld08 != null ? !varFld08.equals(that.varFld08) : that.varFld08 != null) return false;
        if (varFld09 != null ? !varFld09.equals(that.varFld09) : that.varFld09 != null) return false;
        if (varFld10 != null ? !varFld10.equals(that.varFld10) : that.varFld10 != null) return false;
        //if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (createdby != null ? !createdby.equals(that.createdby) : that.createdby != null) return false;
        if (createdon != null ? !createdon.equals(that.createdon) : that.createdon != null) return false;
        if (modifiedby != null ? !modifiedby.equals(that.modifiedby) : that.modifiedby != null) return false;
        if (modifiedOn != null ? !modifiedOn.equals(that.modifiedOn) : that.modifiedOn != null) return false;
        if (deleteby != null ? !deleteby.equals(that.deleteby) : that.deleteby != null) return false;
        if (deletedon != null ? !deletedon.equals(that.deletedon) : that.deletedon != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (statisticsDate != null ? statisticsDate.hashCode() : 0);
        result = 31 * result + (ipAddress != null ? ipAddress.hashCode() : 0);
        result = 31 * result + (requestMethod != null ? requestMethod.hashCode() : 0);
        result = 31 * result + (queryString != null ? queryString.hashCode() : 0);
        result = 31 * result + (requestedUriPath != null ? requestedUriPath.hashCode() : 0);
        result = 31 * result + (requestedThreadName != null ? requestedThreadName.hashCode() : 0);
        result = 31 * result + (protocol != null ? protocol.hashCode() : 0);
        result = 31 * result + (responseStatus != null ? responseStatus.hashCode() : 0);
        result = 31 * result + (bytesSent != null ? bytesSent.hashCode() : 0);
        result = 31 * result + (bytesReceive != null ? bytesReceive.hashCode() : 0);
        result = 31 * result + (timeToProcessRequest != null ? timeToProcessRequest.hashCode() : 0);
        result = 31 * result + (timeToCommitRequest != null ? timeToCommitRequest.hashCode() : 0);
        result = 31 * result + (varFld01 != null ? varFld01.hashCode() : 0);
        result = 31 * result + (varFld02 != null ? varFld02.hashCode() : 0);
        result = 31 * result + (varFld03 != null ? varFld03.hashCode() : 0);
        result = 31 * result + (varFld04 != null ? varFld04.hashCode() : 0);
        result = 31 * result + (varFld05 != null ? varFld05.hashCode() : 0);
        result = 31 * result + (varFld06 != null ? varFld06.hashCode() : 0);
        result = 31 * result + (varFld07 != null ? varFld07.hashCode() : 0);
        result = 31 * result + (varFld08 != null ? varFld08.hashCode() : 0);
        result = 31 * result + (varFld09 != null ? varFld09.hashCode() : 0);
        result = 31 * result + (varFld10 != null ? varFld10.hashCode() : 0);

        result = 31 * result + (createdby != null ? createdby.hashCode() : 0);
        result = 31 * result + (createdon != null ? createdon.hashCode() : 0);
        result = 31 * result + (modifiedby != null ? modifiedby.hashCode() : 0);
        result = 31 * result + (modifiedOn != null ? modifiedOn.hashCode() : 0);
        result = 31 * result + (deleteby != null ? deleteby.hashCode() : 0);
        result = 31 * result + (deletedon != null ? deletedon.hashCode() : 0);
        return result;
    }
}
