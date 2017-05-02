package org.muhia.app.psi.orm.model;

import javax.persistence.*;
import java.util.Date;;
import java.util.Collection;

/*
  Created by Kenneth
  Project: psi
  Package: org.muhia.apps.psi.orm.model
  Generated on: 30-Mar-17, 08:42.
 */
@Entity
@Table(name = "DAT_USSD_CODES")
public class UssdCodes {
    private Long id;
    private String ussdCode;
    private int status;
    private String createdby;
    private Date createdon;
    private String modifiedby;
    private Date modifiedon;
    private String deleteby;
    private Date deletedon;
    private Collection<SmsResponses> cfgSmsResponsesById;
    private Collection<SubscriberWhitelist> datSubscriberWhitelistsById;
    private Organizations organization;
    private Collection<UssdCodeImsi> datUssdCodeImsisById;

    @Id
    @SequenceGenerator(name = "DAT_USSD_CODES_ID_GENERATOR", sequenceName = "DAT_USSD_CODES_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DAT_USSD_CODES_ID_GENERATOR")
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "USSD_CODE", nullable = false, length = 20)
    public String getUssdCode() {
        return ussdCode;
    }

    public void setUssdCode(String ussdCode) {
        this.ussdCode = ussdCode;
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

        UssdCodes ussdCodes = (UssdCodes) o;

        if (id != null ? !id.equals(ussdCodes.id) : ussdCodes.id != null) return false;
        if (ussdCode != null ? !ussdCode.equals(ussdCodes.ussdCode) : ussdCodes.ussdCode != null) return false;
        //if (status != null ? !status.equals(ussdCodes.status) : ussdCodes.status != null) return false;
        if (createdby != null ? !createdby.equals(ussdCodes.createdby) : ussdCodes.createdby != null) return false;
        if (createdon != null ? !createdon.equals(ussdCodes.createdon) : ussdCodes.createdon != null) return false;
        if (modifiedby != null ? !modifiedby.equals(ussdCodes.modifiedby) : ussdCodes.modifiedby != null) return false;
        if (modifiedon != null ? !modifiedon.equals(ussdCodes.modifiedon) : ussdCodes.modifiedon != null) return false;
        if (deleteby != null ? !deleteby.equals(ussdCodes.deleteby) : ussdCodes.deleteby != null) return false;
        if (deletedon != null ? !deletedon.equals(ussdCodes.deletedon) : ussdCodes.deletedon != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (ussdCode != null ? ussdCode.hashCode() : 0);

        result = 31 * result + (createdby != null ? createdby.hashCode() : 0);
        result = 31 * result + (createdon != null ? createdon.hashCode() : 0);
        result = 31 * result + (modifiedby != null ? modifiedby.hashCode() : 0);
        result = 31 * result + (modifiedon != null ? modifiedon.hashCode() : 0);
        result = 31 * result + (deleteby != null ? deleteby.hashCode() : 0);
        result = 31 * result + (deletedon != null ? deletedon.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "smsCode")
    public Collection<SmsResponses> getCfgSmsResponsesById() {
        return cfgSmsResponsesById;
    }

    public void setCfgSmsResponsesById(Collection<SmsResponses> cfgSmsResponsesById) {
        this.cfgSmsResponsesById = cfgSmsResponsesById;
    }

    @OneToMany(mappedBy = "code")
    public Collection<SubscriberWhitelist> getDatSubscriberWhitelistsById() {
        return datSubscriberWhitelistsById;
    }

    public void setDatSubscriberWhitelistsById(Collection<SubscriberWhitelist> datSubscriberWhitelistsById) {
        this.datSubscriberWhitelistsById = datSubscriberWhitelistsById;
    }

    @ManyToOne
    @JoinColumn(name = "ORGANIZATION", referencedColumnName = "ID", nullable = false)
    public Organizations getOrganization() {
        return organization;
    }

    public void setOrganization(Organizations organization) {
        this.organization = organization;
    }

    @OneToMany(mappedBy = "ussdCode")
    public Collection<UssdCodeImsi> getDatUssdCodeImsisById() {
        return datUssdCodeImsisById;
    }

    public void setDatUssdCodeImsisById(Collection<UssdCodeImsi> datUssdCodeImsisById) {
        this.datUssdCodeImsisById = datUssdCodeImsisById;
    }
}
