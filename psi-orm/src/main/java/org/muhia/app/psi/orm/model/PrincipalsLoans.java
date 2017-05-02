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
@Table(name = "DAT_PRINCIPALS_LOANS")
public class PrincipalsLoans {
    private Long id;
    private Long amountloaned;
    private Long paybackamount;
    private int status;
    private String createdby;
    private Date createdon;
    private Date loanedapprovedon;
    private String modifiedby;
    private Date modifiedon;
    private String deletedby;
    private Date deletedon;
    private String placeholder1;
    private String placeholder1Desc;
    private String placeholder2;
    private String placeholder2Desc;
    private String placeholder3;
    private String placeholder3Desc;
    private String placeholder4;
    private String placeholder4Desc;
    private String placeholder5;
    private String placeholder5Desc;
    private Collection<PrincipalsGuarantor> datPrincipalsGuarantorsById;
    private Principals principal;
    private PayBackPeriod paybackperiod;
    private InterestRate interest;
    private Principals lender;
    private MaxLimit maxLimit;
    private ServiceRequests sr;

    @Id
    @SequenceGenerator(name = "DAT_PRINCIPALS_LOANS_SEQ_GEN", sequenceName = "DAT_PRINCIPALS_LOANS_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "DAT_PRINCIPALS_LOANS_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "AMOUNTLOANED", nullable = false, precision = 0)
    public Long getAmountloaned() {
        return amountloaned;
    }

    public void setAmountloaned(Long amountloaned) {
        this.amountloaned = amountloaned;
    }

    @Basic
    @Column(name = "PAYBACKAMOUNT", nullable = true, precision = 0)
    public Long getPaybackamount() {
        return paybackamount;
    }

    public void setPaybackamount(Long paybackamount) {
        this.paybackamount = paybackamount;
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
    @Column(name = "CREATEDBY", nullable = true, length = 20)
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
    @Column(name = "LOANEDAPPROVEDON", nullable = true)
    public Date getLoanedapprovedon() {
        return loanedapprovedon;
    }

    public void setLoanedapprovedon(Date loanedapprovedon) {
        this.loanedapprovedon = loanedapprovedon;
    }

    @Basic
    @Column(name = "MODIFIEDBY", nullable = true, length = 20)
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
    @Column(name = "DELETEDBY", nullable = true, length = 20)
    public String getDeletedby() {
        return deletedby;
    }

    public void setDeletedby(String deletedby) {
        this.deletedby = deletedby;
    }

    @Basic
    @Column(name = "DELETEDON", nullable = true)
    public Date getDeletedon() {
        return deletedon;
    }

    public void setDeletedon(Date deletedon) {
        this.deletedon = deletedon;
    }

    @Basic
    @Column(name = "PLACEHOLDER1", nullable = true, length = 100)
    public String getPlaceholder1() {
        return placeholder1;
    }

    public void setPlaceholder1(String placeholder1) {
        this.placeholder1 = placeholder1;
    }

    @Basic
    @Column(name = "PLACEHOLDER1_DESC", nullable = true, length = 200)
    public String getPlaceholder1Desc() {
        return placeholder1Desc;
    }

    public void setPlaceholder1Desc(String placeholder1Desc) {
        this.placeholder1Desc = placeholder1Desc;
    }

    @Basic
    @Column(name = "PLACEHOLDER2", nullable = true, length = 100)
    public String getPlaceholder2() {
        return placeholder2;
    }

    public void setPlaceholder2(String placeholder2) {
        this.placeholder2 = placeholder2;
    }

    @Basic
    @Column(name = "PLACEHOLDER2_DESC", nullable = true, length = 200)
    public String getPlaceholder2Desc() {
        return placeholder2Desc;
    }

    public void setPlaceholder2Desc(String placeholder2Desc) {
        this.placeholder2Desc = placeholder2Desc;
    }

    @Basic
    @Column(name = "PLACEHOLDER3", nullable = true, length = 100)
    public String getPlaceholder3() {
        return placeholder3;
    }

    public void setPlaceholder3(String placeholder3) {
        this.placeholder3 = placeholder3;
    }

    @Basic
    @Column(name = "PLACEHOLDER3_DESC", nullable = true, length = 200)
    public String getPlaceholder3Desc() {
        return placeholder3Desc;
    }

    public void setPlaceholder3Desc(String placeholder3Desc) {
        this.placeholder3Desc = placeholder3Desc;
    }

    @Basic
    @Column(name = "PLACEHOLDER4", nullable = true, length = 100)
    public String getPlaceholder4() {
        return placeholder4;
    }

    public void setPlaceholder4(String placeholder4) {
        this.placeholder4 = placeholder4;
    }

    @Basic
    @Column(name = "PLACEHOLDER4_DESC", nullable = true, length = 200)
    public String getPlaceholder4Desc() {
        return placeholder4Desc;
    }

    public void setPlaceholder4Desc(String placeholder4Desc) {
        this.placeholder4Desc = placeholder4Desc;
    }

    @Basic
    @Column(name = "PLACEHOLDER5", nullable = true, length = 100)
    public String getPlaceholder5() {
        return placeholder5;
    }

    public void setPlaceholder5(String placeholder5) {
        this.placeholder5 = placeholder5;
    }

    @Basic
    @Column(name = "PLACEHOLDER5_DESC", nullable = true, length = 200)
    public String getPlaceholder5Desc() {
        return placeholder5Desc;
    }

    public void setPlaceholder5Desc(String placeholder5Desc) {
        this.placeholder5Desc = placeholder5Desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrincipalsLoans that = (PrincipalsLoans) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (amountloaned != null ? !amountloaned.equals(that.amountloaned) : that.amountloaned != null) return false;
        if (paybackamount != null ? !paybackamount.equals(that.paybackamount) : that.paybackamount != null)
            return false;
        //if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (createdby != null ? !createdby.equals(that.createdby) : that.createdby != null) return false;
        if (createdon != null ? !createdon.equals(that.createdon) : that.createdon != null) return false;
        if (loanedapprovedon != null ? !loanedapprovedon.equals(that.loanedapprovedon) : that.loanedapprovedon != null)
            return false;
        if (modifiedby != null ? !modifiedby.equals(that.modifiedby) : that.modifiedby != null) return false;
        if (modifiedon != null ? !modifiedon.equals(that.modifiedon) : that.modifiedon != null) return false;
        if (deletedby != null ? !deletedby.equals(that.deletedby) : that.deletedby != null) return false;
        if (deletedon != null ? !deletedon.equals(that.deletedon) : that.deletedon != null) return false;
        if (placeholder1 != null ? !placeholder1.equals(that.placeholder1) : that.placeholder1 != null) return false;
        if (placeholder1Desc != null ? !placeholder1Desc.equals(that.placeholder1Desc) : that.placeholder1Desc != null)
            return false;
        if (placeholder2 != null ? !placeholder2.equals(that.placeholder2) : that.placeholder2 != null) return false;
        if (placeholder2Desc != null ? !placeholder2Desc.equals(that.placeholder2Desc) : that.placeholder2Desc != null)
            return false;
        if (placeholder3 != null ? !placeholder3.equals(that.placeholder3) : that.placeholder3 != null) return false;
        if (placeholder3Desc != null ? !placeholder3Desc.equals(that.placeholder3Desc) : that.placeholder3Desc != null)
            return false;
        if (placeholder4 != null ? !placeholder4.equals(that.placeholder4) : that.placeholder4 != null) return false;
        if (placeholder4Desc != null ? !placeholder4Desc.equals(that.placeholder4Desc) : that.placeholder4Desc != null)
            return false;
        if (placeholder5 != null ? !placeholder5.equals(that.placeholder5) : that.placeholder5 != null) return false;
        if (placeholder5Desc != null ? !placeholder5Desc.equals(that.placeholder5Desc) : that.placeholder5Desc != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (amountloaned != null ? amountloaned.hashCode() : 0);
        result = 31 * result + (paybackamount != null ? paybackamount.hashCode() : 0);

        result = 31 * result + (createdby != null ? createdby.hashCode() : 0);
        result = 31 * result + (createdon != null ? createdon.hashCode() : 0);
        result = 31 * result + (loanedapprovedon != null ? loanedapprovedon.hashCode() : 0);
        result = 31 * result + (modifiedby != null ? modifiedby.hashCode() : 0);
        result = 31 * result + (modifiedon != null ? modifiedon.hashCode() : 0);
        result = 31 * result + (deletedby != null ? deletedby.hashCode() : 0);
        result = 31 * result + (deletedon != null ? deletedon.hashCode() : 0);
        result = 31 * result + (placeholder1 != null ? placeholder1.hashCode() : 0);
        result = 31 * result + (placeholder1Desc != null ? placeholder1Desc.hashCode() : 0);
        result = 31 * result + (placeholder2 != null ? placeholder2.hashCode() : 0);
        result = 31 * result + (placeholder2Desc != null ? placeholder2Desc.hashCode() : 0);
        result = 31 * result + (placeholder3 != null ? placeholder3.hashCode() : 0);
        result = 31 * result + (placeholder3Desc != null ? placeholder3Desc.hashCode() : 0);
        result = 31 * result + (placeholder4 != null ? placeholder4.hashCode() : 0);
        result = 31 * result + (placeholder4Desc != null ? placeholder4Desc.hashCode() : 0);
        result = 31 * result + (placeholder5 != null ? placeholder5.hashCode() : 0);
        result = 31 * result + (placeholder5Desc != null ? placeholder5Desc.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "loan")
    public Collection<PrincipalsGuarantor> getDatPrincipalsGuarantorsById() {
        return datPrincipalsGuarantorsById;
    }

    public void setDatPrincipalsGuarantorsById(Collection<PrincipalsGuarantor> datPrincipalsGuarantorsById) {
        this.datPrincipalsGuarantorsById = datPrincipalsGuarantorsById;
    }

    @ManyToOne
    @JoinColumn(name = "PRINCIPAL", referencedColumnName = "ID", nullable = false)
    public Principals getPrincipal() {
        return principal;
    }

    public void setPrincipal(Principals principal) {
        this.principal = principal;
    }

    @ManyToOne
    @JoinColumn(name = "PAYBACKPERIOD", referencedColumnName = "ID", nullable = false)
    public PayBackPeriod getPaybackperiod() {
        return paybackperiod;
    }

    public void setPaybackperiod(PayBackPeriod paybackperiod) {
        this.paybackperiod = paybackperiod;
    }

    @ManyToOne
    @JoinColumn(name = "INTEREST", referencedColumnName = "ID")
    public InterestRate getInterest() {
        return interest;
    }

    public void setInterest(InterestRate interest) {
        this.interest = interest;
    }

    @ManyToOne
    @JoinColumn(name = "LENDER", referencedColumnName = "ID")
    public Principals getLender() {
        return lender;
    }

    public void setLender(Principals lender) {
        this.lender = lender;
    }

    @ManyToOne
    @JoinColumn(name = "MAXLIMIT", referencedColumnName = "ID")
    public MaxLimit getMaxLimit() {
        return maxLimit;
    }

    public void setMaxLimit(MaxLimit maxLimit) {
        this.maxLimit = maxLimit;
    }

    @ManyToOne
    @JoinColumn(name = "SERVICEREQUEST", referencedColumnName = "ID")
    public ServiceRequests getSr() {
        return sr;
    }

    public void setSr(ServiceRequests servicerequest) {
        this.sr = servicerequest;
    }
}
