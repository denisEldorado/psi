package org.muhia.app.psi.orm.model;

import javax.persistence.*;
import java.util.Date;;

/*
  Created by Kenneth
  Project: psi
  Package: org.muhia.apps.psi.orm.model
  Generated on: 30-Mar-17, 08:43.
 */
@Entity
@Table(name = "LOG_SMS_REGISTRY")
public class SmsRegistry {
    private Long id;
    private String subno;
    private String kannelResponse;
    private Long deliveryStatus;
    private String sender;
    private String direction;
    private Date receivedDate;
    private Date sentDate;
    private String messageText;
    private String responseMessage;
    private Date creationDate;
    private String subImsi;
    private String shortCode;
    private Long retryAttempts;
    private Long retried;
    private ServiceRequests serviceRequest;

    @Id
    @SequenceGenerator(name = "LOG_SMS_REGISTRY_SEQ_GEN", sequenceName = "LOG_SMS_REGISTRY_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "LOG_SMS_REGISTRY_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "SUBNO", nullable = true, length = 100)
    public String getSubno() {
        return subno;
    }

    public void setSubno(String subno) {
        this.subno = subno;
    }

    @Basic
    @Column(name = "KANNEL_RESPONSE", nullable = true, length = 300)
    public String getKannelResponse() {
        return kannelResponse;
    }

    public void setKannelResponse(String kannelResponse) {
        this.kannelResponse = kannelResponse;
    }

    @Basic
    @Column(name = "DELIVERY_STATUS", nullable = true, precision = 0)
    public Long getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(Long deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    @Basic
    @Column(name = "SENDER", nullable = true, length = 50)
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Basic
    @Column(name = "DIRECTION", nullable = true, length = 50)
    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Basic
    @Column(name = "RECEIVED_TIME", nullable = true)
    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    @Basic
    @Column(name = "SENT_TIME", nullable = true)
    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    @Basic
    @Column(name = "MESSAGE_TEXT", nullable = true, length = 500)
    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    @Basic
    @Column(name = "RESPONSE_MESSAGE", nullable = true, length = 500)
    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    @Basic
    @Column(name = "CREATION_DATE", nullable = true)
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Basic
    @Column(name = "SUB_IMSI", nullable = true, length = 1000)
    public String getSubImsi() {
        return subImsi;
    }

    public void setSubImsi(String subImsi) {
        this.subImsi = subImsi;
    }

    @Basic
    @Column(name = "SHORT_CODE", nullable = true, length = 100)
    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    @Basic
    @Column(name = "RETRY_ATTEMPTS", nullable = true, precision = 0)
    public Long getRetryAttempts() {
        return retryAttempts;
    }

    public void setRetryAttempts(Long retryAttempts) {
        this.retryAttempts = retryAttempts;
    }

    @Basic
    @Column(name = "RETRIED", nullable = true, precision = 0)
    public Long getRetried() {
        return retried;
    }

    public void setRetried(Long retried) {
        this.retried = retried;
    }

    @ManyToOne
    @JoinColumn(name = "SERVICE_REQUEST", referencedColumnName = "ID", nullable = true)
    public ServiceRequests getServiceRequest() {
        return serviceRequest;
    }

    public void setServiceRequest(ServiceRequests serviceRequest) {
        this.serviceRequest = serviceRequest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SmsRegistry that = (SmsRegistry) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (subno != null ? !subno.equals(that.subno) : that.subno != null) return false;
        if (kannelResponse != null ? !kannelResponse.equals(that.kannelResponse) : that.kannelResponse != null)
            return false;
        if (deliveryStatus != null ? !deliveryStatus.equals(that.deliveryStatus) : that.deliveryStatus != null)
            return false;
        if (sender != null ? !sender.equals(that.sender) : that.sender != null) return false;
        if (direction != null ? !direction.equals(that.direction) : that.direction != null) return false;
        if (receivedDate != null ? !receivedDate.equals(that.receivedDate) : that.receivedDate != null) return false;
        if (sentDate != null ? !sentDate.equals(that.sentDate) : that.sentDate != null) return false;
        if (messageText != null ? !messageText.equals(that.messageText) : that.messageText != null) return false;
        if (responseMessage != null ? !responseMessage.equals(that.responseMessage) : that.responseMessage != null)
            return false;
        if (creationDate != null ? !creationDate.equals(that.creationDate) : that.creationDate != null) return false;
        if (subImsi != null ? !subImsi.equals(that.subImsi) : that.subImsi != null) return false;
        if (shortCode != null ? !shortCode.equals(that.shortCode) : that.shortCode != null) return false;
        if (retryAttempts != null ? !retryAttempts.equals(that.retryAttempts) : that.retryAttempts != null)
            return false;
        if (retried != null ? !retried.equals(that.retried) : that.retried != null) return false;
        if (serviceRequest != null ? !serviceRequest.equals(that.serviceRequest) : that.serviceRequest != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (subno != null ? subno.hashCode() : 0);
        result = 31 * result + (kannelResponse != null ? kannelResponse.hashCode() : 0);
        result = 31 * result + (deliveryStatus != null ? deliveryStatus.hashCode() : 0);
        result = 31 * result + (sender != null ? sender.hashCode() : 0);
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        result = 31 * result + (receivedDate != null ? receivedDate.hashCode() : 0);
        result = 31 * result + (sentDate != null ? sentDate.hashCode() : 0);
        result = 31 * result + (messageText != null ? messageText.hashCode() : 0);
        result = 31 * result + (responseMessage != null ? responseMessage.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (subImsi != null ? subImsi.hashCode() : 0);
        result = 31 * result + (shortCode != null ? shortCode.hashCode() : 0);
        result = 31 * result + (retryAttempts != null ? retryAttempts.hashCode() : 0);
        result = 31 * result + (retried != null ? retried.hashCode() : 0);
        result = 31 * result + (serviceRequest != null ? serviceRequest.hashCode() : 0);
        return result;
    }
    public String toString() {
        return "SmsRegistry [id=" + id + ", text=" + messageText + ", subscriber=" + subno + ", retryAttempts=" + retryAttempts + ", Direction=" + direction +", retried=" + retried +", status=" + deliveryStatus + "]";
    }

    @PrePersist
    protected void onCreate() {
        if (retried== null) retried = 0L;
    }
}
