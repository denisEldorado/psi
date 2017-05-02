package org.muhia.app.psi.orm.model;

import javax.persistence.*;
import java.util.Date;;

/*
  Created by Kenneth
  Project: psi
  Package: org.muhia.apps.psi.orm.model
  Generated on: 30-Mar-17, 08:42.
 */
@Entity
@Table(name = "FCT_MOM_AM_SERVICE_DETAILS")
public class MomAmServiceDetails {
    private Long id;
    private String accountid;
    private String transactiontype;
    private String grossamount;
    private Date createdon;

    @Id
    @SequenceGenerator(name = "FCT_MOM_AM_SERVICE_DETAILS_SEQ_GEN", sequenceName = "FCT_MOM_AM_SERVICE_DETAILS_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "FCT_MOM_AM_SERVICE_DETAILS_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ACCOUNTID", nullable = true, length = 250)
    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid;
    }

    @Basic
    @Column(name = "TRANSACTIONTYPE", nullable = true, length = 500)
    public String getTransactiontype() {
        return transactiontype;
    }

    public void setTransactiontype(String transactiontype) {
        this.transactiontype = transactiontype;
    }

    @Basic
    @Column(name = "GROSSAMOUNT", nullable = true, length = 350)
    public String getGrossamount() {
        return grossamount;
    }

    public void setGrossamount(String grossamount) {
        this.grossamount = grossamount;
    }

    @Basic
    @Column(name = "CREATEDON", nullable = false)
    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MomAmServiceDetails that = (MomAmServiceDetails) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (accountid != null ? !accountid.equals(that.accountid) : that.accountid != null) return false;
        if (transactiontype != null ? !transactiontype.equals(that.transactiontype) : that.transactiontype != null)
            return false;
        if (grossamount != null ? !grossamount.equals(that.grossamount) : that.grossamount != null) return false;
        if (createdon != null ? !createdon.equals(that.createdon) : that.createdon != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (accountid != null ? accountid.hashCode() : 0);
        result = 31 * result + (transactiontype != null ? transactiontype.hashCode() : 0);
        result = 31 * result + (grossamount != null ? grossamount.hashCode() : 0);
        result = 31 * result + (createdon != null ? createdon.hashCode() : 0);
        return result;
    }
    @PrePersist
    protected void onCreate() {
        if (createdon== null) createdon = new Date();
    }
}
