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
@Table(name = "DAT_USERS")
public class Users {
    private Long userId;
    private Long userTypeId;
    private String username;
    private String passwd;
    private Date requestDate;
    private Date creationDate;
    private String authorizedBy;
    private Long passwdExpires;
    private Long passwdExpDuration;
    private String surname;
    private String fname;
    private String onames;
    private String email;
    private Long deptId;
    private String authKey;
    private Date dateAuthed;
    private Long authOfficer;
    private Long roleId;

    @Id
    @Column(name = "USER_ID", nullable = true, precision = 0)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "USER_TYPE_ID", nullable = true, precision = 0)
    public Long getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Long userTypeId) {
        this.userTypeId = userTypeId;
    }

    @Basic
    @Column(name = "USERNAME", nullable = true, length = 20)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "PASSWD", nullable = true, length = 128)
    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
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
    @Column(name = "CREATION_DATE", nullable = true)
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Basic
    @Column(name = "AUTHORIZED_BY", nullable = true, length = 400)
    public String getAuthorizedBy() {
        return authorizedBy;
    }

    public void setAuthorizedBy(String authorizedBy) {
        this.authorizedBy = authorizedBy;
    }

    @Basic
    @Column(name = "PASSWD_EXPIRES", nullable = true, precision = 0)
    public Long getPasswdExpires() {
        return passwdExpires;
    }

    public void setPasswdExpires(Long passwdExpires) {
        this.passwdExpires = passwdExpires;
    }

    @Basic
    @Column(name = "PASSWD_EXP_DURATION", nullable = true, precision = 0)
    public Long getPasswdExpDuration() {
        return passwdExpDuration;
    }

    public void setPasswdExpDuration(Long passwdExpDuration) {
        this.passwdExpDuration = passwdExpDuration;
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

    @Basic
    @Column(name = "ROLE_ID", nullable = true, precision = 0)
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (userId != null ? !userId.equals(users.userId) : users.userId != null) return false;
        if (userTypeId != null ? !userTypeId.equals(users.userTypeId) : users.userTypeId != null) return false;
        if (username != null ? !username.equals(users.username) : users.username != null) return false;
        if (passwd != null ? !passwd.equals(users.passwd) : users.passwd != null) return false;
        if (requestDate != null ? !requestDate.equals(users.requestDate) : users.requestDate != null) return false;
        if (creationDate != null ? !creationDate.equals(users.creationDate) : users.creationDate != null) return false;
        if (authorizedBy != null ? !authorizedBy.equals(users.authorizedBy) : users.authorizedBy != null) return false;
        if (passwdExpires != null ? !passwdExpires.equals(users.passwdExpires) : users.passwdExpires != null)
            return false;
        if (passwdExpDuration != null ? !passwdExpDuration.equals(users.passwdExpDuration) : users.passwdExpDuration != null)
            return false;
        if (surname != null ? !surname.equals(users.surname) : users.surname != null) return false;
        if (fname != null ? !fname.equals(users.fname) : users.fname != null) return false;
        if (onames != null ? !onames.equals(users.onames) : users.onames != null) return false;
        if (email != null ? !email.equals(users.email) : users.email != null) return false;
        if (deptId != null ? !deptId.equals(users.deptId) : users.deptId != null) return false;
        if (authKey != null ? !authKey.equals(users.authKey) : users.authKey != null) return false;
        if (dateAuthed != null ? !dateAuthed.equals(users.dateAuthed) : users.dateAuthed != null) return false;
        if (authOfficer != null ? !authOfficer.equals(users.authOfficer) : users.authOfficer != null) return false;
        if (roleId != null ? !roleId.equals(users.roleId) : users.roleId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userTypeId != null ? userTypeId.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (passwd != null ? passwd.hashCode() : 0);
        result = 31 * result + (requestDate != null ? requestDate.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (authorizedBy != null ? authorizedBy.hashCode() : 0);
        result = 31 * result + (passwdExpires != null ? passwdExpires.hashCode() : 0);
        result = 31 * result + (passwdExpDuration != null ? passwdExpDuration.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (fname != null ? fname.hashCode() : 0);
        result = 31 * result + (onames != null ? onames.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (deptId != null ? deptId.hashCode() : 0);
        result = 31 * result + (authKey != null ? authKey.hashCode() : 0);
        result = 31 * result + (dateAuthed != null ? dateAuthed.hashCode() : 0);
        result = 31 * result + (authOfficer != null ? authOfficer.hashCode() : 0);
        result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
        return result;
    }
}
