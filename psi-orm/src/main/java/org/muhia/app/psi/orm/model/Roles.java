package org.muhia.app.psi.orm.model;

import javax.persistence.*;
import java.util.Date;;
import java.util.Collection;

/*
  Created by Kenneth
  Project: psi
  Package: org.muhia.apps.psi.orm.model
  Generated on: 30-Mar-17, 08:40.
 */
@Entity
@Table(name = "ADM_ROLES")
public class Roles {
    private Long id;
    private String rolename;
    private int status;
    private String createdby;
    private Date createdon;
    private String modifiedby;
    private Date modifiedon;
    private String deleteby;
    private Date deletedon;
//    private Long parentRole;
    private Roles parentRole;
    private Collection<Roles> admRolesById;
    private Collection<RolePrivileges> admRolePrivilegesById;
    private Collection<UserRoles> admUserRolesById;

    @Id
    @SequenceGenerator(name = "ADM_ROLES_ID_GENERATOR", sequenceName = "ADM_ROLES_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADM_ROLES_ID_GENERATOR")
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ROLENAME", nullable = false, length = 100)
    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
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

        Roles roles = (Roles) o;

        if (id != null ? !id.equals(roles.id) : roles.id != null) return false;
        if (rolename != null ? !rolename.equals(roles.rolename) : roles.rolename != null) return false;
        //if (status != null ? !status.equals(roles.status) : roles.status != null) return false;
        if (createdby != null ? !createdby.equals(roles.createdby) : roles.createdby != null) return false;
        if (createdon != null ? !createdon.equals(roles.createdon) : roles.createdon != null) return false;
        if (modifiedby != null ? !modifiedby.equals(roles.modifiedby) : roles.modifiedby != null) return false;
        if (modifiedon != null ? !modifiedon.equals(roles.modifiedon) : roles.modifiedon != null) return false;
        if (deleteby != null ? !deleteby.equals(roles.deleteby) : roles.deleteby != null) return false;
        if (deletedon != null ? !deletedon.equals(roles.deletedon) : roles.deletedon != null) return false;
        if (parentRole != null ? !parentRole.equals(roles.parentRole) : roles.parentRole != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (rolename != null ? rolename.hashCode() : 0);

        result = 31 * result + (createdby != null ? createdby.hashCode() : 0);
        result = 31 * result + (createdon != null ? createdon.hashCode() : 0);
        result = 31 * result + (modifiedby != null ? modifiedby.hashCode() : 0);
        result = 31 * result + (modifiedon != null ? modifiedon.hashCode() : 0);
        result = 31 * result + (deleteby != null ? deleteby.hashCode() : 0);
        result = 31 * result + (deletedon != null ? deletedon.hashCode() : 0);
        result = 31 * result + (parentRole != null ? parentRole.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "PARENT_ROLE", referencedColumnName = "ID")
    public Roles getParentRole() {
        return parentRole;
    }

    public void setParentRole(Roles admRolesByParentRole) {
        this.parentRole = admRolesByParentRole;
    }

    @OneToMany(mappedBy = "parentRole")
    public Collection<Roles> getAdmRolesById() {
        return admRolesById;
    }

    public void setAdmRolesById(Collection<Roles> admRolesById) {
        this.admRolesById = admRolesById;
    }

    @OneToMany(mappedBy = "roleid")
    public Collection<RolePrivileges> getAdmRolePrivilegesById() {
        return admRolePrivilegesById;
    }

    public void setAdmRolePrivilegesById(Collection<RolePrivileges> admRolePrivilegesById) {
        this.admRolePrivilegesById = admRolePrivilegesById;
    }

    @OneToMany(mappedBy = "roleid")
    public Collection<UserRoles> getAdmUserRolesById() {
        return admUserRolesById;
    }

    public void setAdmUserRolesById(Collection<UserRoles> admUserRolesById) {
        this.admUserRolesById = admUserRolesById;
    }
}
