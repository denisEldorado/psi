package org.muhia.app.psi.orm.model;

import javax.persistence.*;
import java.util.Date;;
import java.util.Collection;

/*
  Created by Kenneth
  Project: psi
  Package: org.muhia.apps.psi.orm.model
  Generated on: 30-Mar-17, 08:43.
 */
@Entity
@Table(name = "REF_TITLES")
public class Titles {
    private Long id;
    private String title;
    private int status;
    private String createdby;
    private Date createdon;
    private String modifiedby;
    private Date modifiedon;
    private String deleteby;
    private Date deletedon;
    private Collection<Principals> admPrincipalsById;

    public Titles() {
    }

    public Titles(Long id) {
        this.id = id;
    }

    public Titles(Long id, String title, int status) {
        this.id = id;
        this.title = title;
        this.status = status;
    }

    @Id
    @SequenceGenerator(name = "REF_TITLES_SEQ_GEN", sequenceName = "REF_TITLES_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "REF_TITLES_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TITLE", nullable = false, length = 200)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

        Titles titles = (Titles) o;

        if (id != null ? !id.equals(titles.id) : titles.id != null) return false;
        if (title != null ? !title.equals(titles.title) : titles.title != null) return false;
        //if (status != null ? !status.equals(titles.status) : titles.status != null) return false;
        if (createdby != null ? !createdby.equals(titles.createdby) : titles.createdby != null) return false;
        if (createdon != null ? !createdon.equals(titles.createdon) : titles.createdon != null) return false;
        if (modifiedby != null ? !modifiedby.equals(titles.modifiedby) : titles.modifiedby != null) return false;
        if (modifiedon != null ? !modifiedon.equals(titles.modifiedon) : titles.modifiedon != null) return false;
        if (deleteby != null ? !deleteby.equals(titles.deleteby) : titles.deleteby != null) return false;
        if (deletedon != null ? !deletedon.equals(titles.deletedon) : titles.deletedon != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);

        result = 31 * result + (createdby != null ? createdby.hashCode() : 0);
        result = 31 * result + (createdon != null ? createdon.hashCode() : 0);
        result = 31 * result + (modifiedby != null ? modifiedby.hashCode() : 0);
        result = 31 * result + (modifiedon != null ? modifiedon.hashCode() : 0);
        result = 31 * result + (deleteby != null ? deleteby.hashCode() : 0);
        result = 31 * result + (deletedon != null ? deletedon.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "title")
    public Collection<Principals> getAdmPrincipalsById() {
        return admPrincipalsById;
    }

    public void setAdmPrincipalsById(Collection<Principals> admPrincipalsById) {
        this.admPrincipalsById = admPrincipalsById;
    }
}
