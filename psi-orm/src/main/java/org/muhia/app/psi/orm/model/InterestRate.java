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
@Table(name = "CFG_INTEREST_RATE")
public class InterestRate {
    private Long id;
    private float rate;
    private Date createdon;
    private Date deactivateddate;
    private int status;
    private Collection<PrincipalsLoans> datPrincipalsLoansById;

    @Id
    @SequenceGenerator(name = "CFG_INTEREST_RATE_SEQ_GEN", sequenceName = "CFG_INTEREST_RATE_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "CFG_INTEREST_RATE_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "RATE", nullable = false, precision = 0)
    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    @Basic
    @Column(name = "CREATEDON", nullable = false)
    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
    }

    @Basic
    @Column(name = "DEACTIVATEDDATE", nullable = true)
    public Date getDeactivateddate() {
        return deactivateddate;
    }

    public void setDeactivateddate(Date deactivateddate) {
        this.deactivateddate = deactivateddate;
    }

    @Basic
    @Column(name = "STATUS", nullable = false, precision = 0)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InterestRate that = (InterestRate) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        if (createdon != null ? !createdon.equals(that.createdon) : that.createdon != null) return false;
        if (deactivateddate != null ? !deactivateddate.equals(that.deactivateddate) : that.deactivateddate != null)
            return false;
        //if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        
        result = 31 * result + (createdon != null ? createdon.hashCode() : 0);
        result = 31 * result + (deactivateddate != null ? deactivateddate.hashCode() : 0);

        return result;
    }

    @OneToMany(mappedBy = "interest")
    public Collection<PrincipalsLoans> getDatPrincipalsLoansById() {
        return datPrincipalsLoansById;
    }

    public void setDatPrincipalsLoansById(Collection<PrincipalsLoans> datPrincipalsLoansById) {
        this.datPrincipalsLoansById = datPrincipalsLoansById;
    }
}
