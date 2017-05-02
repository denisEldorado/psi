package org.muhia.app.psi.orm.model;

import javax.persistence.*;
import java.util.Date;;
import java.util.Collection;

/*
  Created by Kenneth
  Project: psi
  Package: org.muhia.apps.psi.orm.model
  Generated on: 30-Mar-17, 08:41.
 */
@Entity
@Table(name = "CFG_PAYBACK_PERIOD")
public class PayBackPeriod {
    private Long id;
    private Short paybackperiod;
    private Integer status;
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
    @Column(name = "PAYBACKPERIOD", nullable = false, precision = 0)
    public Short getPaybackperiod() {
        return paybackperiod;
    }

    public void setPaybackperiod(Short paybackperiod) {
        this.paybackperiod = paybackperiod;
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
    @Column(name = "CREATEDON", nullable = false)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PayBackPeriod that = (PayBackPeriod) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (paybackperiod != null ? !paybackperiod.equals(that.paybackperiod) : that.paybackperiod != null)
            return false;
        //if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (createdon != null ? !createdon.equals(that.createdon) : that.createdon != null) return false;
        if (deactivatedon != null ? !deactivatedon.equals(that.deactivatedon) : that.deactivatedon != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (paybackperiod != null ? paybackperiod.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createdon != null ? createdon.hashCode() : 0);
        result = 31 * result + (deactivatedon != null ? deactivatedon.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "paybackperiod")
    public Collection<PrincipalsLoans> getDatPrincipalsLoansById() {
        return datPrincipalsLoansById;
    }

    public void setDatPrincipalsLoansById(Collection<PrincipalsLoans> datPrincipalsLoansById) {
        this.datPrincipalsLoansById = datPrincipalsLoansById;
    }
}
