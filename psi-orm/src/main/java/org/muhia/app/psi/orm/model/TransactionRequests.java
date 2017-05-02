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
import java.util.Date;

/**
 * Created by KennethKZMMuhia
 * Project: psi
 * Package: org.muhia.app.psi.orm.model
 * Generated on: 14-Apr-17, 22:50
 */
@Entity
@Table(name = "CBM_TRANSACTION_REQUESTS", schema = "PSI")
public class TransactionRequests {
    private long id;
    private String customername;
    private String toaccount;
    private String fromaccount;
    private Long tranamount;
    private Date paymentdate;
    private Date recordDate;
    private String teller;
    private String approvedby;
    private String narration;
    private Long requiresapproval;
    private String approver;
    private String status;
    private String reason;
    private String paymenttype;
    private String chequenumber;
    private int transactionStatus;
    private Date prepareStartDate;
    private Date prepareEndDate;
    private Date provisioningStartDate;
    private Date provisioningEndDate;
    private String provisioningTransaction;
    private int provisioningRetries;
    private int provisioningRetried;
    private Date accountingStartDate;
    private Date accountingEndDate;
    private String accountingTransaction;
    private int accountingRetries;
    private int accountingRetried;
    private Date glUpdateStartDate;
    private Date glUpdateEndDate;
    private String glUpdateTransaction;
    private int glUpdateRetries;
    private int glUpdateRetried;
    private Date crbaUpdateStartDate;
    private Date crbaUpdateEndDate;
    private String crbaUpdateTransaction;
    private int crbaUpdateRetries;
    private int crbaUpdateRetried;
    private String varField1;
    private String varField2;
    private String varField3;
    private String varField4;
    private String varField5;
    private String varField6;
    private String varField7;
    private String varField8;
    private String varField9;
    private String varField10;
    private String createdBy;
    private String modifiedBy;
    private String deletedBy;
    private Date createdon;
    private Date modifiedon;
    private Date deletedon;
    private BankAccounts accountnumber;
    private TransactionCategories trancategory;
    private Currencies currencycode;
    private ServiceRequests serviceRequest;
    private Double transactionCharges;
    private Long transactionDuration;

    @Id
    @SequenceGenerator(name = "CBM_TRANSACTION_REQUESTS_SEQ_GEN", sequenceName = "CBM_TRANSACTION_REQUESTS_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "CBM_TRANSACTION_REQUESTS_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CUSTOMERNAME")
    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    @Basic
    @Column(name = "TOACCOUNT")
    public String getToaccount() {
        return toaccount;
    }

    public void setToaccount(String toaccount) {
        this.toaccount = toaccount;
    }

    @Basic
    @Column(name = "FROMACCOUNT")
    public String getFromaccount() {
        return fromaccount;
    }

    public void setFromaccount(String fromaccount) {
        this.fromaccount = fromaccount;
    }

    @Basic
    @Column(name = "TRANAMOUNT")
    public Long getTranamount() {
        return tranamount;
    }

    public void setTranamount(Long tranamount) {
        this.tranamount = tranamount;
    }

    @Basic
    @Column(name = "PAYMENTDATE")
    public Date getPaymentdate() {
        return paymentdate;
    }

    public void setPaymentdate(Date paymentdate) {
        this.paymentdate = paymentdate;
    }

    @Basic
    @Column(name = "RECORD_DATE")
    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    @Basic
    @Column(name = "TELLER")
    public String getTeller() {
        return teller;
    }

    public void setTeller(String teller) {
        this.teller = teller;
    }

    @Basic
    @Column(name = "APPROVEDBY")
    public String getApprovedby() {
        return approvedby;
    }

    public void setApprovedby(String approvedby) {
        this.approvedby = approvedby;
    }

    @Basic
    @Column(name = "NARRATION")
    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    @Basic
    @Column(name = "REQUIRESAPPROVAL")
    public Long getRequiresapproval() {
        return requiresapproval;
    }

    public void setRequiresapproval(Long requiresapproval) {
        this.requiresapproval = requiresapproval;
    }

    @Basic
    @Column(name = "APPROVER")
    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    @Basic
    @Column(name = "STATUS")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "REASON")
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Basic
    @Column(name = "PAYMENTTYPE")
    public String getPaymenttype() {
        return paymenttype;
    }

    public void setPaymenttype(String paymenttype) {
        this.paymenttype = paymenttype;
    }

    @Basic
    @Column(name = "CHEQUENUMBER")
    public String getChequenumber() {
        return chequenumber;
    }

    public void setChequenumber(String chequenumber) {
        this.chequenumber = chequenumber;
    }

    @Basic
    @Column(name = "TRANSACTION_STATUS")
    public int getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(int transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    @Basic
    @Column(name = "PREPARE_START_DATE")
    public Date getPrepareStartDate() {
        return prepareStartDate;
    }

    public void setPrepareStartDate(Date prepareStartDate) {
        this.prepareStartDate = prepareStartDate;
    }

    @Basic
    @Column(name = "PREPARE_END_DATE")
    public Date getPrepareEndDate() {
        return prepareEndDate;
    }

    public void setPrepareEndDate(Date prepareEndDate) {
        this.prepareEndDate = prepareEndDate;
    }

    @Basic
    @Column(name = "PROVISIONING_START_DATE")
    public Date getProvisioningStartDate() {
        return provisioningStartDate;
    }

    public void setProvisioningStartDate(Date provisioningStartDate) {
        this.provisioningStartDate = provisioningStartDate;
    }

    @Basic
    @Column(name = "PROVISIONING_END_DATE")
    public Date getProvisioningEndDate() {
        return provisioningEndDate;
    }

    public void setProvisioningEndDate(Date provisioningEndDate) {
        this.provisioningEndDate = provisioningEndDate;
    }

    @Basic
    @Column(name = "PROVISIONING_TRANSACTION")
    public String getProvisioningTransaction() {
        return provisioningTransaction;
    }

    public void setProvisioningTransaction(String provisioningTransaction) {
        this.provisioningTransaction = provisioningTransaction;
    }

    @Basic
    @Column(name = "PROVISIONING_RETRIES")
    public int getProvisioningRetries() {
        return provisioningRetries;
    }

    public void setProvisioningRetries(int provisioningRetries) {
        this.provisioningRetries = provisioningRetries;
    }

    @Basic
    @Column(name = "PROVISIONING_RETRIED")
    public int getProvisioningRetried() {
        return provisioningRetried;
    }

    public void setProvisioningRetried(int provisioningRetried) {
        this.provisioningRetried = provisioningRetried;
    }

    @Basic
    @Column(name = "ACCOUNTING_START_DATE")
    public Date getAccountingStartDate() {
        return accountingStartDate;
    }

    public void setAccountingStartDate(Date accountingStartDate) {
        this.accountingStartDate = accountingStartDate;
    }

    @Basic
    @Column(name = "ACCOUNTING_END_DATE")
    public Date getAccountingEndDate() {
        return accountingEndDate;
    }

    public void setAccountingEndDate(Date accountingEndDate) {
        this.accountingEndDate = accountingEndDate;
    }

    @Basic
    @Column(name = "ACCOUNTING_TRANSACTION")
    public String getAccountingTransaction() {
        return accountingTransaction;
    }

    public void setAccountingTransaction(String accountingTransaction) {
        this.accountingTransaction = accountingTransaction;
    }

    @Basic
    @Column(name = "ACCOUNTING_RETRIES")
    public int getAccountingRetries() {
        return accountingRetries;
    }

    public void setAccountingRetries(int accountingRetries) {
        this.accountingRetries = accountingRetries;
    }

    @Basic
    @Column(name = "ACCOUNTING_RETRIED")
    public int getAccountingRetried() {
        return accountingRetried;
    }

    public void setAccountingRetried(int accountingRetried) {
        this.accountingRetried = accountingRetried;
    }

    @Basic
    @Column(name = "GL_UPDATE_START_DATE")
    public Date getGlUpdateStartDate() {
        return glUpdateStartDate;
    }

    public void setGlUpdateStartDate(Date glUpdateStartDate) {
        this.glUpdateStartDate = glUpdateStartDate;
    }

    @Basic
    @Column(name = "GL_UPDATE_END_DATE")
    public Date getGlUpdateEndDate() {
        return glUpdateEndDate;
    }

    public void setGlUpdateEndDate(Date glUpdateEndDate) {
        this.glUpdateEndDate = glUpdateEndDate;
    }

    @Basic
    @Column(name = "GL_UPDATE_TRANSACTION")
    public String getGlUpdateTransaction() {
        return glUpdateTransaction;
    }

    public void setGlUpdateTransaction(String glUpdateTransaction) {
        this.glUpdateTransaction = glUpdateTransaction;
    }

    @Basic
    @Column(name = "GL_UPDATE_RETRIES")
    public int getGlUpdateRetries() {
        return glUpdateRetries;
    }

    public void setGlUpdateRetries(int glUpdateRetries) {
        this.glUpdateRetries = glUpdateRetries;
    }

    @Basic
    @Column(name = "GL_UPDATE_RETRIED")
    public int getGlUpdateRetried() {
        return glUpdateRetried;
    }

    public void setGlUpdateRetried(int glUpdateRetried) {
        this.glUpdateRetried = glUpdateRetried;
    }

    @Basic
    @Column(name = "CRBA_UPDATE_START_DATE")
    public Date getCrbaUpdateStartDate() {
        return crbaUpdateStartDate;
    }

    public void setCrbaUpdateStartDate(Date crbaUpdateStartDate) {
        this.crbaUpdateStartDate = crbaUpdateStartDate;
    }

    @Basic
    @Column(name = "CRBA_UPDATE_END_DATE")
    public Date getCrbaUpdateEndDate() {
        return crbaUpdateEndDate;
    }

    public void setCrbaUpdateEndDate(Date crbaUpdateEndDate) {
        this.crbaUpdateEndDate = crbaUpdateEndDate;
    }

    @Basic
    @Column(name = "CRBA_UPDATE_TRANSACTION")
    public String getCrbaUpdateTransaction() {
        return crbaUpdateTransaction;
    }

    public void setCrbaUpdateTransaction(String crbaUpdateTransaction) {
        this.crbaUpdateTransaction = crbaUpdateTransaction;
    }

    @Basic
    @Column(name = "CRBA_UPDATE_RETRIES")
    public int getCrbaUpdateRetries() {
        return crbaUpdateRetries;
    }

    public void setCrbaUpdateRetries(int crbaUpdateRetries) {
        this.crbaUpdateRetries = crbaUpdateRetries;
    }

    @Basic
    @Column(name = "CRBA_UPDATE_RETRIED")
    public int getCrbaUpdateRetried() {
        return crbaUpdateRetried;
    }

    public void setCrbaUpdateRetried(int crbaUpdateRetried) {
        this.crbaUpdateRetried = crbaUpdateRetried;
    }

    @Basic
    @Column(name = "VAR_FIELD_1")
    public String getVarField1() {
        return varField1;
    }

    public void setVarField1(String varField1) {
        this.varField1 = varField1;
    }

    @Basic
    @Column(name = "VAR_FIELD_2")
    public String getVarField2() {
        return varField2;
    }

    public void setVarField2(String varField2) {
        this.varField2 = varField2;
    }

    @Basic
    @Column(name = "VAR_FIELD_3")
    public String getVarField3() {
        return varField3;
    }

    public void setVarField3(String varField3) {
        this.varField3 = varField3;
    }

    @Basic
    @Column(name = "VAR_FIELD_4")
    public String getVarField4() {
        return varField4;
    }

    public void setVarField4(String varField4) {
        this.varField4 = varField4;
    }

    @Basic
    @Column(name = "VAR_FIELD_5")
    public String getVarField5() {
        return varField5;
    }

    public void setVarField5(String varField5) {
        this.varField5 = varField5;
    }

    @Basic
    @Column(name = "VAR_FIELD_6")
    public String getVarField6() {
        return varField6;
    }

    public void setVarField6(String varField6) {
        this.varField6 = varField6;
    }

    @Basic
    @Column(name = "VAR_FIELD_7")
    public String getVarField7() {
        return varField7;
    }

    public void setVarField7(String varField7) {
        this.varField7 = varField7;
    }

    @Basic
    @Column(name = "VAR_FIELD_8")
    public String getVarField8() {
        return varField8;
    }

    public void setVarField8(String varField8) {
        this.varField8 = varField8;
    }

    @Basic
    @Column(name = "VAR_FIELD_9")
    public String getVarField9() {
        return varField9;
    }

    public void setVarField9(String varField9) {
        this.varField9 = varField9;
    }

    @Basic
    @Column(name = "VAR_FIELD_10")
    public String getVarField10() {
        return varField10;
    }

    public void setVarField10(String varField10) {
        this.varField10 = varField10;
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
    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
    }

    @Basic
    @Column(name = "MODIFIEDON")
    public Date getModifiedon() {
        return modifiedon;
    }

    public void setModifiedon(Date modifiedon) {
        this.modifiedon = modifiedon;
    }

    @Basic
    @Column(name = "DELETEDON")
    public Date getDeletedon() {
        return deletedon;
    }

    public void setDeletedon(Date deletedon) {
        this.deletedon = deletedon;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (customername != null ? customername.hashCode() : 0);
        result = 31 * result + (toaccount != null ? toaccount.hashCode() : 0);
        result = 31 * result + (fromaccount != null ? fromaccount.hashCode() : 0);
        result = 31 * result + (tranamount != null ? tranamount.hashCode() : 0);
        result = 31 * result + (paymentdate != null ? paymentdate.hashCode() : 0);
        result = 31 * result + (recordDate != null ? recordDate.hashCode() : 0);
        result = 31 * result + (teller != null ? teller.hashCode() : 0);
        result = 31 * result + (approvedby != null ? approvedby.hashCode() : 0);
        result = 31 * result + (narration != null ? narration.hashCode() : 0);
        result = 31 * result + (requiresapproval != null ? requiresapproval.hashCode() : 0);
        result = 31 * result + (approver != null ? approver.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        result = 31 * result + (paymenttype != null ? paymenttype.hashCode() : 0);
        result = 31 * result + (chequenumber != null ? chequenumber.hashCode() : 0);
        result = 31 * result + transactionStatus;
        result = 31 * result + (prepareStartDate != null ? prepareStartDate.hashCode() : 0);
        result = 31 * result + (prepareEndDate != null ? prepareEndDate.hashCode() : 0);
        result = 31 * result + (provisioningStartDate != null ? provisioningStartDate.hashCode() : 0);
        result = 31 * result + (provisioningEndDate != null ? provisioningEndDate.hashCode() : 0);
        result = 31 * result + (provisioningTransaction != null ? provisioningTransaction.hashCode() : 0);
        result = 31 * result + provisioningRetries;
        result = 31 * result + provisioningRetried;
        result = 31 * result + (accountingStartDate != null ? accountingStartDate.hashCode() : 0);
        result = 31 * result + (accountingEndDate != null ? accountingEndDate.hashCode() : 0);
        result = 31 * result + (accountingTransaction != null ? accountingTransaction.hashCode() : 0);
        result = 31 * result + accountingRetries;
        result = 31 * result + accountingRetried;
        result = 31 * result + (glUpdateStartDate != null ? glUpdateStartDate.hashCode() : 0);
        result = 31 * result + (glUpdateEndDate != null ? glUpdateEndDate.hashCode() : 0);
        result = 31 * result + (glUpdateTransaction != null ? glUpdateTransaction.hashCode() : 0);
        result = 31 * result + glUpdateRetries;
        result = 31 * result + glUpdateRetried;
        result = 31 * result + (crbaUpdateStartDate != null ? crbaUpdateStartDate.hashCode() : 0);
        result = 31 * result + (crbaUpdateEndDate != null ? crbaUpdateEndDate.hashCode() : 0);
        result = 31 * result + (crbaUpdateTransaction != null ? crbaUpdateTransaction.hashCode() : 0);
        result = 31 * result + crbaUpdateRetries;
        result = 31 * result + crbaUpdateRetried;
        result = 31 * result + (varField1 != null ? varField1.hashCode() : 0);
        result = 31 * result + (varField2 != null ? varField2.hashCode() : 0);
        result = 31 * result + (varField3 != null ? varField3.hashCode() : 0);
        result = 31 * result + (varField4 != null ? varField4.hashCode() : 0);
        result = 31 * result + (varField5 != null ? varField5.hashCode() : 0);
        result = 31 * result + (varField6 != null ? varField6.hashCode() : 0);
        result = 31 * result + (varField7 != null ? varField7.hashCode() : 0);
        result = 31 * result + (varField8 != null ? varField8.hashCode() : 0);
        result = 31 * result + (varField9 != null ? varField9.hashCode() : 0);
        result = 31 * result + (varField10 != null ? varField10.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (modifiedBy != null ? modifiedBy.hashCode() : 0);
        result = 31 * result + (deletedBy != null ? deletedBy.hashCode() : 0);
        result = 31 * result + (createdon != null ? createdon.hashCode() : 0);
        result = 31 * result + (modifiedon != null ? modifiedon.hashCode() : 0);
        result = 31 * result + (deletedon != null ? deletedon.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ACCOUNTNUMBER", referencedColumnName = "ID", nullable = false)
    public BankAccounts getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(BankAccounts accountnumber) {
        this.accountnumber = accountnumber;
    }

    @ManyToOne
    @JoinColumn(name = "TRANCATEGORY", referencedColumnName = "ID", nullable = false)
    public TransactionCategories getTrancategory() {
        return trancategory;
    }

    public void setTrancategory(TransactionCategories trancategory) {
        this.trancategory = trancategory;
    }

    @ManyToOne
    @JoinColumn(name = "CURRENCYCODE", referencedColumnName = "ID", nullable = false)
    public Currencies getCurrencycode() {
        return currencycode;
    }

    public void setCurrencycode(Currencies currencycode) {
        this.currencycode = currencycode;
    }

    @ManyToOne
    @JoinColumn(name = "SERVICE_REQUEST", referencedColumnName = "ID")
    public ServiceRequests getServiceRequest() {
        return serviceRequest;
    }

    public void setServiceRequest(ServiceRequests serviceRequest) {
        this.serviceRequest = serviceRequest;
    }

    @Basic
    @Column(name = "TRANSACTION_CHARGES", columnDefinition = "NUMBER(38,5)")
    public Double getTransactionCharges() {
        return transactionCharges;
    }

    public void setTransactionCharges(Double transactionCharges) {
        this.transactionCharges = transactionCharges;
    }

    @Basic
    @Column(name = "TRANSACTION_DURATION")
    public Long getTransactionDuration() {
        return transactionDuration;
    }

    public void setTransactionDuration(Long transactionDuration) {
        this.transactionDuration = transactionDuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionRequests that = (TransactionRequests) o;

        return (transactionCharges != null ? transactionCharges.equals(that.transactionCharges) : that.transactionCharges == null) && (transactionDuration != null ? transactionDuration.equals(that.transactionDuration) : that.transactionDuration == null);
    }
}
