package org.muhia.app.psi.orm.model;

import javax.persistence.*;
import java.util.Date;;

/*
  Created by Kenneth
  Project: psi
  Package: org.muhia.apps.psi.orm.model
  Generated on: 30-Mar-17, 08:40.
 */
@Entity
@Table(name = "ADM_USER_ROLES")
public class UserRoles {
    private Long id;


    private Integer status;
    private String createdby;
    private Date createdon;
    private String modifiedby;
    private Date modifiedon;
    private String deleteby;
    private Date deletedon;
    private Principals userid;
    private Roles roleid;

    public UserRoles(Long id) {
        this.id = id;
    }

    public UserRoles(Long id, int status) {
        this.id = id;
        this.status = status;
    }

    public UserRoles(Principals userid, Roles roleid, int status){
        this.userid = userid;
        this.roleid = roleid;
        this.status = status;
    }

    public UserRoles() {
    }

    @Id
    @SequenceGenerator(name = "ADM_USER_ROLES_SEQ_GEN", sequenceName = "ADM_USER_ROLES_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "ADM_USER_ROLES_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

        UserRoles userRoles = (UserRoles) o;

        if (id != null ? !id.equals(userRoles.id) : userRoles.id != null) return false;
        if (userid != null ? !userid.equals(userRoles.userid) : userRoles.userid != null) return false;
        if (roleid != null ? !roleid.equals(userRoles.roleid) : userRoles.roleid != null) return false;
        //if (status != null ? !status.equals(userRoles.status) : userRoles.status != null) return false;
        if (createdby != null ? !createdby.equals(userRoles.createdby) : userRoles.createdby != null) return false;
        if (createdon != null ? !createdon.equals(userRoles.createdon) : userRoles.createdon != null) return false;
        if (modifiedby != null ? !modifiedby.equals(userRoles.modifiedby) : userRoles.modifiedby != null) return false;
        if (modifiedon != null ? !modifiedon.equals(userRoles.modifiedon) : userRoles.modifiedon != null) return false;
        if (deleteby != null ? !deleteby.equals(userRoles.deleteby) : userRoles.deleteby != null) return false;
        if (deletedon != null ? !deletedon.equals(userRoles.deletedon) : userRoles.deletedon != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (roleid != null ? roleid.hashCode() : 0);
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
    @JoinColumn(name = "USERID", referencedColumnName = "ID")
    public Principals getUserid() {
        return userid;
    }

    public void setUserid(Principals admPrincipalsByUserid) {
        this.userid = admPrincipalsByUserid;
    }

    @ManyToOne
    @JoinColumn(name = "ROLEID", referencedColumnName = "ID")
    public Roles getRoleid() {
        return roleid;
    }

    public void setRoleid(Roles admRolesByRoleid) {
        this.roleid = admRolesByRoleid;
    }
}
