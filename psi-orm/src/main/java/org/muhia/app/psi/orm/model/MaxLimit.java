package org.muhia.app.psi.orm.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

;

/*
  Created by Kenneth
  Project: psi
  Package: org.muhia.apps.psi.orm.model
  Generated on: 30-Mar-17, 08:41.
 */
@Entity
@Table(name = "CFG_MAXLIMIT")
public class MaxLimit {
    private Long id;
    private float maxlimit;
    private int status;
    private Date createdon;
    private Date deactivatedon;
    private Collection<PrincipalsLoans> datPrincipalsLoansById;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "MAXLIMIT", nullable = false, precision = 0)
    public float getMaxlimit() {
        return maxlimit;
    }

    public void setMaxlimit(float maxlimit) {
        this.maxlimit = maxlimit;
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
    @Column(name = "CREATEDON", nullable = true)
    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
    }

    @Basic
    @Column(name = "DEACTIVATEDON", nullable = true)
    public Date getDeactivatedon() {
        return deactivatedon;
    }

    public void setDeactivatedon(Date deactivatedon) {
        this.deactivatedon = deactivatedon;
    }



    @OneToMany(mappedBy = "maxLimit")
    public Collection<PrincipalsLoans> getDatPrincipalsLoansById() {
        return datPrincipalsLoansById;
    }

    public void setDatPrincipalsLoansById(Collection<PrincipalsLoans> datPrincipalsLoansById) {
        this.datPrincipalsLoansById = datPrincipalsLoansById;
    }
}
