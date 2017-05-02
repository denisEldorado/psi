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
@Table(name = "CRM_RECURRING_ORDERS")
public class RecurringOrders {
    private Long id;
    private String subscriberMsisdn;
    private Date transactionDate;
    private int transactionStatus;
    private Long transactionFee;
    private Date createdOn;
    private Long transactionAmount;
    private Long maxAttempts;
    private Long failedAttempts;
    private ServiceRequests serviceRequest;
    private Principals toBill;
    private ProductsMaster orderProduct;

    @Id
    @SequenceGenerator(name = "CRM_RECURRING_ORDERS_SEQ_GEN", sequenceName = "CRM_RECURRING_ORDERS_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "CRM_RECURRING_ORDERS_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "SUBSCRIBER_MSISDN", nullable = false, length = 100)
    public String getSubscriberMsisdn() {
        return subscriberMsisdn;
    }

    public void setSubscriberMsisdn(String subscriberMsisdn) {
        this.subscriberMsisdn = subscriberMsisdn;
    }

    @Basic
    @Column(name = "TRANSACTION_DATE", nullable = true)
    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Basic
    @Column(name = "TRANSACTION_STATUS", nullable = false, precision = 0)
    public int getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(int transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    @Basic
    @Column(name = "TRANSACTION_FEE", nullable = false, precision = 2)
    public Long getTransactionFee() {
        return transactionFee;
    }

    public void setTransactionFee(Long transactionFee) {
        this.transactionFee = transactionFee;
    }

    @Basic
    @Column(name = "CREATED_ON", nullable = true)
    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @Basic
    @Column(name = "TRANSACTION_AMOUNT", nullable = false, precision = 2)
    public Long getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Long transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    @Basic
    @Column(name = "MAX_ATTEMPTS", nullable = true, precision = 0)
    public Long getMaxAttempts() {
        return maxAttempts;
    }

    public void setMaxAttempts(Long maxAttempts) {
        this.maxAttempts = maxAttempts;
    }

    @Basic
    @Column(name = "FAILED_ATTEMPTS", nullable = true, precision = 0)
    public Long getFailedAttempts() {
        return failedAttempts;
    }

    public void setFailedAttempts(Long failedAttempts) {
        this.failedAttempts = failedAttempts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecurringOrders that = (RecurringOrders) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (subscriberMsisdn != null ? !subscriberMsisdn.equals(that.subscriberMsisdn) : that.subscriberMsisdn != null)
            return false;
        if (transactionDate != null ? !transactionDate.equals(that.transactionDate) : that.transactionDate != null)
            return false;

        if (transactionFee != null ? !transactionFee.equals(that.transactionFee) : that.transactionFee != null)
            return false;
        if (createdOn != null ? !createdOn.equals(that.createdOn) : that.createdOn != null) return false;
        if (transactionAmount != null ? !transactionAmount.equals(that.transactionAmount) : that.transactionAmount != null)
            return false;
        if (maxAttempts != null ? !maxAttempts.equals(that.maxAttempts) : that.maxAttempts != null) return false;
        if (failedAttempts != null ? !failedAttempts.equals(that.failedAttempts) : that.failedAttempts != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (subscriberMsisdn != null ? subscriberMsisdn.hashCode() : 0);
        result = 31 * result + (transactionDate != null ? transactionDate.hashCode() : 0);

        result = 31 * result + (transactionFee != null ? transactionFee.hashCode() : 0);
        result = 31 * result + (createdOn != null ? createdOn.hashCode() : 0);
        result = 31 * result + (transactionAmount != null ? transactionAmount.hashCode() : 0);
        result = 31 * result + (maxAttempts != null ? maxAttempts.hashCode() : 0);
        result = 31 * result + (failedAttempts != null ? failedAttempts.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "SERVICE_REQUEST", referencedColumnName = "ID")
    public ServiceRequests getServiceRequest() {
        return serviceRequest;
    }

    public void setServiceRequest(ServiceRequests serviceRequest) {
        this.serviceRequest = serviceRequest;
    }

    @ManyToOne
    @JoinColumn(name = "TO_BILL", referencedColumnName = "ID")
    public Principals getToBill() {
        return toBill;
    }

    public void setToBill(Principals toBill) {
        this.toBill = toBill;
    }

    @ManyToOne
    @JoinColumn(name = "ORDER_PRODUCT", referencedColumnName = "ID")
    public ProductsMaster getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(ProductsMaster orderProduct) {
        this.orderProduct = orderProduct;
    }
}
