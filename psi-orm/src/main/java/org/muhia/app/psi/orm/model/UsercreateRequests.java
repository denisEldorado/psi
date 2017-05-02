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
@Table(name = "DAT_USERCREATE_REQUESTS")
public class UsercreateRequests {
    private Long createid;
    private Date requestDate;
    private String userName;
    private String surname;
    private String fname;
    private String onames;
    private String email;
    private String passwd;
    private Long deptId;
    private String authKey;
    private Date dateAuthed;
    private Long authOfficer;

    @Id
    @Column(name = "CREATEID", nullable = true, precision = 0)
    public Long getCreateid() {
        return createid;
    }

    public void setCreateid(Long createid) {
        this.createid = createid;
    }

    @Basic
    @Column(name = "REQUEST_DATE", nullable = true)
    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    @Basic
    @Column(name = "USER_NAME", nullable = true, length = 300)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "SURNAME", nullable = true, length = 100)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "FNAME", nullable = true, length = 100)
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    @Basic
    @Column(name = "ONAMES", nullable = true, length = 100)
    public String getOnames() {
        return onames;
    }

    public void setOnames(String onames) {
        this.onames = onames;
    }

    @Basic
    @Column(name = "EMAIL", nullable = true, length = 400)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "PASSWD", nullable = true, length = 1000)
    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Basic
    @Column(name = "DEPT_ID", nullable = true, precision = 0)
    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    @Basic
    @Column(name = "AUTH_KEY", nullable = true, length = 4000)
    public String getAuthKey() {
        return authKey;
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }

    @Basic
    @Column(name = "DATE_AUTHED", nullable = true)
    public Date getDateAuthed() {
        return dateAuthed;
    }

    public void setDateAuthed(Date dateAuthed) {
        this.dateAuthed = dateAuthed;
    }

    @Basic
    @Column(name = "AUTH_OFFICER", nullable = true, precision = 0)
    public Long getAuthOfficer() {
        return authOfficer;
    }

    public void setAuthOfficer(Long authOfficer) {
        this.authOfficer = authOfficer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsercreateRequests that = (UsercreateRequests) o;

        if (createid != null ? !createid.equals(that.createid) : that.createid != null) return false;
        if (requestDate != null ? !requestDate.equals(that.requestDate) : that.requestDate != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (fname != null ? !fname.equals(that.fname) : that.fname != null) return false;
        if (onames != null ? !onames.equals(that.onames) : that.onames != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (passwd != null ? !passwd.equals(that.passwd) : that.passwd != null) return false;
        if (deptId != null ? !deptId.equals(that.deptId) : that.deptId != null) return false;
        if (authKey != null ? !authKey.equals(that.authKey) : that.authKey != null) return false;
        if (dateAuthed != null ? !dateAuthed.equals(that.dateAuthed) : that.dateAuthed != null) return false;
        if (authOfficer != null ? !authOfficer.equals(that.authOfficer) : that.authOfficer != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = createid != null ? createid.hashCode() : 0;
        result = 31 * result + (requestDate != null ? requestDate.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (fname != null ? fname.hashCode() : 0);
        result = 31 * result + (onames != null ? onames.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (passwd != null ? passwd.hashCode() : 0);
        result = 31 * result + (deptId != null ? deptId.hashCode() : 0);
        result = 31 * result + (authKey != null ? authKey.hashCode() : 0);
        result = 31 * result + (dateAuthed != null ? dateAuthed.hashCode() : 0);
        result = 31 * result + (authOfficer != null ? authOfficer.hashCode() : 0);
        return result;
    }
}
