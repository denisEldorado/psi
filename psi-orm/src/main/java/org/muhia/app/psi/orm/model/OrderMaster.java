package org.muhia.app.psi.orm.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Collection;

/*
  Created by Kenneth
  Project: psi
  Package: org.muhia.apps.psi.orm.model
  Generated on: 30-Mar-17, 08:41.
 */
@Entity
@Table(name = "CRM_ORDER_MASTER")
public class OrderMaster {
    private Long id;

    private Date submittedDate;
    private Date processingStartDate;
    private Date processingEndDate;
    private Long requesterId;
    private Date eventbusSubmitDate;
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
    private ApplicationSrc requestorApplicationId;
    private String requestorApplicationUser;
    private Long amountCharged;
    private String requestLanguage;
    private String srcIp;
    private String srcHostname;
    private String remoteSessionId;
    private int transactionStatus;
    private String subno;
    private ProductsMaster productId;
    private Collection<ServiceRequests> crmServiceRequestsById;

    @Id
    @SequenceGenerator(name = "CRM_ORDER_MASTER_SEQ_GEN", sequenceName = "CRM_ORDER_MASTER_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "CRM_ORDER_MASTER_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    @Basic
    @Column(name = "SUBMITTED_DATE", nullable = true)
    public Date getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(Date submittedDate) {
        this.submittedDate = submittedDate;
    }

    @Basic
    @Column(name = "PROCESSING_START_DATE", nullable = true)
    public Date getProcessingStartDate() {
        return processingStartDate;
    }

    public void setProcessingStartDate(Date processingStartDate) {
        this.processingStartDate = processingStartDate;
    }

    @Basic
    @Column(name = "PROCESSING_END_DATE", nullable = true)
    public Date getProcessingEndDate() {
        return processingEndDate;
    }

    public void setProcessingEndDate(Date processingEndDate) {
        this.processingEndDate = processingEndDate;
    }

    @Basic
    @Column(name = "REQUESTER_ID", nullable = true, precision = 0)
    public Long getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(Long requesterId) {
        this.requesterId = requesterId;
    }

    @Basic
    @Column(name = "EVENTBUS_SUBMIT_DATE", nullable = true)
    public Date getEventbusSubmitDate() {
        return eventbusSubmitDate;
    }

    public void setEventbusSubmitDate(Date eventbusSubmitDate) {
        this.eventbusSubmitDate = eventbusSubmitDate;
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

    @JoinColumn(name = "REQUESTOR_APPLICATION_ID", referencedColumnName = "ID")
    @ManyToOne
    public ApplicationSrc getRequestorApplicationId() {
        return requestorApplicationId;
    }

    public void setRequestorApplicationId(ApplicationSrc requestorApplicationId) {
        this.requestorApplicationId = requestorApplicationId;
    }

    @Basic
    @Column(name = "REQUESTOR_APPLICATION_USER", nullable = true, length = 200)
    public String getRequestorApplicationUser() {
        return requestorApplicationUser;
    }

    public void setRequestorApplicationUser(String requestorApplicationUser) {
        this.requestorApplicationUser = requestorApplicationUser;
    }

    @Basic
    @Column(name = "AMOUNT_CHARGED", nullable = true, precision = 2)
    public Long getAmountCharged() {
        return amountCharged;
    }

    public void setAmountCharged(Long amountCharged) {
        this.amountCharged = amountCharged;
    }

    @Basic
    @Column(name = "REQUEST_LANGUAGE", nullable = true, length = 255)
    public String getRequestLanguage() {
        return requestLanguage;
    }

    public void setRequestLanguage(String requestLanguage) {
        this.requestLanguage = requestLanguage;
    }

    @Basic
    @Column(name = "SRC_IP", nullable = true, length = 400)
    public String getSrcIp() {
        return srcIp;
    }

    public void setSrcIp(String srcIp) {
        this.srcIp = srcIp;
    }

    @Basic
    @Column(name = "SRC_HOSTNAME", nullable = true, length = 400)
    public String getSrcHostname() {
        return srcHostname;
    }

    public void setSrcHostname(String srcHostname) {
        this.srcHostname = srcHostname;
    }

    @Basic
    @Column(name = "REMOTE_SESSION_ID", nullable = true, length = 255)
    public String getRemoteSessionId() {
        return remoteSessionId;
    }

    public void setRemoteSessionId(String remoteSessionId) {
        this.remoteSessionId = remoteSessionId;
    }

    @Basic
    @Column(name = "TRANSACTION_STATUS", nullable = true, precision = 0)
    public int getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(int transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    @Basic
    @Column(name = "SUBNO", nullable = true, length = 50)
    public String getSubno() {
        return subno;
    }

    public void setSubno(String subno) {
        this.subno = subno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderMaster that = (OrderMaster) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (submittedDate != null ? !submittedDate.equals(that.submittedDate) : that.submittedDate != null)
            return false;
        if (processingStartDate != null ? !processingStartDate.equals(that.processingStartDate) : that.processingStartDate != null)
            return false;
        if (processingEndDate != null ? !processingEndDate.equals(that.processingEndDate) : that.processingEndDate != null)
            return false;
        if (requesterId != null ? !requesterId.equals(that.requesterId) : that.requesterId != null) return false;
        if (eventbusSubmitDate != null ? !eventbusSubmitDate.equals(that.eventbusSubmitDate) : that.eventbusSubmitDate != null)
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
        if (requestorApplicationId != null ? !requestorApplicationId.equals(that.requestorApplicationId) : that.requestorApplicationId != null)
            return false;
        if (requestorApplicationUser != null ? !requestorApplicationUser.equals(that.requestorApplicationUser) : that.requestorApplicationUser != null)
            return false;
        if (amountCharged != null ? !amountCharged.equals(that.amountCharged) : that.amountCharged != null)
            return false;
        if (requestLanguage != null ? !requestLanguage.equals(that.requestLanguage) : that.requestLanguage != null)
            return false;
        if (srcIp != null ? !srcIp.equals(that.srcIp) : that.srcIp != null) return false;
        if (srcHostname != null ? !srcHostname.equals(that.srcHostname) : that.srcHostname != null) return false;
        if (remoteSessionId != null ? !remoteSessionId.equals(that.remoteSessionId) : that.remoteSessionId != null)
            return false;

        if (subno != null ? !subno.equals(that.subno) : that.subno != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (submittedDate != null ? submittedDate.hashCode() : 0);
        result = 31 * result + (processingStartDate != null ? processingStartDate.hashCode() : 0);
        result = 31 * result + (processingEndDate != null ? processingEndDate.hashCode() : 0);
        result = 31 * result + (requesterId != null ? requesterId.hashCode() : 0);
        result = 31 * result + (eventbusSubmitDate != null ? eventbusSubmitDate.hashCode() : 0);
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
        result = 31 * result + (requestorApplicationId != null ? requestorApplicationId.hashCode() : 0);
        result = 31 * result + (requestorApplicationUser != null ? requestorApplicationUser.hashCode() : 0);
        result = 31 * result + (amountCharged != null ? amountCharged.hashCode() : 0);
        result = 31 * result + (requestLanguage != null ? requestLanguage.hashCode() : 0);
        result = 31 * result + (srcIp != null ? srcIp.hashCode() : 0);
        result = 31 * result + (srcHostname != null ? srcHostname.hashCode() : 0);
        result = 31 * result + (remoteSessionId != null ? remoteSessionId.hashCode() : 0);

        result = 31 * result + (subno != null ? subno.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
    public ProductsMaster getProductId() {
        return productId;
    }

    public void setProductId(ProductsMaster cfgProductsMasterByProductId) {
        this.productId = cfgProductsMasterByProductId;
    }

    @OneToMany(mappedBy = "orderNumber")
    public Collection<ServiceRequests> getCrmServiceRequestsById() {
        return crmServiceRequestsById;
    }

    public void setCrmServiceRequestsById(Collection<ServiceRequests> crmServiceRequestsById) {
        this.crmServiceRequestsById = crmServiceRequestsById;
    }
}
