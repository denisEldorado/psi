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
@Table(name = "CFG_SMS_RESPONSES")
public class SmsResponses {
    private Long id;

    private Boolean autoResopond;

    private Integer status;
    private String createdby;
    private Date createdon;
    private String modifiedby;
    private Date modifiedon;
    private String deleteby;
    private Date deletedon;
    private UssdCodes smsCode;
    private SmsNotification responseText;

    @Id
	@SequenceGenerator(name="CFG_SMS_RESPONSES_ID_GENERATOR", sequenceName="CFG_SMS_RESPONSES_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CFG_SMS_RESPONSES_ID_GENERATOR")
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    @Basic
    @Column(name = "AUTO_RESOPOND", nullable = false, precision = 0)
    public Boolean getAutoResopond() {
        return autoResopond;
    }

    public void setAutoResopond(Boolean autoResopond) {
        this.autoResopond = autoResopond;
    }

    

    @Basic
    @Column(name = "STATUS", nullable = false, precision = 0)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SmsResponses that = (SmsResponses) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (smsCode != null ? !smsCode.equals(that.smsCode) : that.smsCode != null) return false;
        if (autoResopond != null ? !autoResopond.equals(that.autoResopond) : that.autoResopond != null) return false;
        if (responseText != null ? !responseText.equals(that.responseText) : that.responseText != null) return false;
        //if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (createdby != null ? !createdby.equals(that.createdby) : that.createdby != null) return false;
        if (createdon != null ? !createdon.equals(that.createdon) : that.createdon != null) return false;
        if (modifiedby != null ? !modifiedby.equals(that.modifiedby) : that.modifiedby != null) return false;
        if (modifiedon != null ? !modifiedon.equals(that.modifiedon) : that.modifiedon != null) return false;
        if (deleteby != null ? !deleteby.equals(that.deleteby) : that.deleteby != null) return false;
        if (deletedon != null ? !deletedon.equals(that.deletedon) : that.deletedon != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (smsCode != null ? smsCode.hashCode() : 0);
        result = 31 * result + (autoResopond != null ? autoResopond.hashCode() : 0);
        result = 31 * result + (responseText != null ? responseText.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createdby != null ? createdby.hashCode() : 0);
        result = 31 * result + (createdon != null ? createdon.hashCode() : 0);
        result = 31 * result + (modifiedby != null ? modifiedby.hashCode() : 0);
        result = 31 * result + (modifiedon != null ? modifiedon.hashCode() : 0);
        result = 31 * result + (deleteby != null ? deleteby.hashCode() : 0);
        result = 31 * result + (deletedon != null ? deletedon.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "SMS_CODE", referencedColumnName = "ID")
    public UssdCodes getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(UssdCodes datUssdCodesBySmsCode) {
        this.smsCode = datUssdCodesBySmsCode;
    }

    @ManyToOne
    @JoinColumn(name = "RESPONSE_TEXT", referencedColumnName = "ID")
    public SmsNotification getResponseText() {
        return responseText;
    }

    public void setResponseText(SmsNotification cfgSmsNotificationByResponseText) {
        this.responseText = cfgSmsNotificationByResponseText;
    }
}
