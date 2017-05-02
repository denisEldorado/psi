package org.muhia.app.psi.orm.model;

import javax.persistence.*;
import java.util.Date;

/*
  Created by Kenneth
  Project: psi
  Package: org.muhia.apps.psi.orm.model
  Generated on: 30-Mar-17, 08:41.
 */
@Entity
@Table(name = "CFG_PRODUCT_PARAMETERS")
public class ProductParameters {
    private Long id;

    private String placeHolder1;
    private String placeHolder1Desc;
    private String placeHolder2;
    private String placeHolder2Desc;
    private String placeHolder3;
    private String placeHolder3Desc;
    private String placeHolder4;
    private String placeHolder4Desc;
    private String placeHolder5;
    private String placeHolder5Desc;
    private String placeHolder6;
    private String placeHolder6Desc;
    private String placeHolder7;
    private String placeHolder7Desc;
    private String placeHolder8;
    private String placeHolder8Desc;
    private String placeHolder9;
    private String placeHolder9Desc;
    private String placeHolder10;
    private String placeHolder10Desc;
    private Integer status;
    private Date creationDate;
    private Date lastUpdatedDate;
    private Long lastUpdatedBy;

    private String smsKeyword;
    private ProductsMaster productId;
    private ParameterTypes parameterType;

    @Id
    @SequenceGenerator(name = "CFG_PRODUCT_PARAMETERS_SEQ_GEN", sequenceName = "CFG_PRODUCT_PARAMETERS_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "CFG_PRODUCT_PARAMETERS_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Basic
    @Column(name = "PLACE_HOLDER1", nullable = true, length = 200)
    public String getPlaceHolder1() {
        return placeHolder1;
    }

    public void setPlaceHolder1(String placeHolder1) {
        this.placeHolder1 = placeHolder1;
    }

    @Basic
    @Column(name = "PLACE_HOLDER1_DESC", nullable = true, length = 200)
    public String getPlaceHolder1Desc() {
        return placeHolder1Desc;
    }

    public void setPlaceHolder1Desc(String placeHolder1Desc) {
        this.placeHolder1Desc = placeHolder1Desc;
    }

    @Basic
    @Column(name = "PLACE_HOLDER2", nullable = true, length = 100)
    public String getPlaceHolder2() {
        return placeHolder2;
    }

    public void setPlaceHolder2(String placeHolder2) {
        this.placeHolder2 = placeHolder2;
    }

    @Basic
    @Column(name = "PLACE_HOLDER2_DESC", nullable = true, length = 200)
    public String getPlaceHolder2Desc() {
        return placeHolder2Desc;
    }

    public void setPlaceHolder2Desc(String placeHolder2Desc) {
        this.placeHolder2Desc = placeHolder2Desc;
    }

    @Basic
    @Column(name = "PLACE_HOLDER3", nullable = true, length = 100)
    public String getPlaceHolder3() {
        return placeHolder3;
    }

    public void setPlaceHolder3(String placeHolder3) {
        this.placeHolder3 = placeHolder3;
    }

    @Basic
    @Column(name = "PLACE_HOLDER3_DESC", nullable = true, length = 200)
    public String getPlaceHolder3Desc() {
        return placeHolder3Desc;
    }

    public void setPlaceHolder3Desc(String placeHolder3Desc) {
        this.placeHolder3Desc = placeHolder3Desc;
    }

    @Basic
    @Column(name = "PLACE_HOLDER4", nullable = true, length = 100)
    public String getPlaceHolder4() {
        return placeHolder4;
    }

    public void setPlaceHolder4(String placeHolder4) {
        this.placeHolder4 = placeHolder4;
    }

    @Basic
    @Column(name = "PLACE_HOLDER4_DESC", nullable = true, length = 100)
    public String getPlaceHolder4Desc() {
        return placeHolder4Desc;
    }

    public void setPlaceHolder4Desc(String placeHolder4Desc) {
        this.placeHolder4Desc = placeHolder4Desc;
    }

    @Basic
    @Column(name = "PLACE_HOLDER5", nullable = true, length = 100)
    public String getPlaceHolder5() {
        return placeHolder5;
    }

    public void setPlaceHolder5(String placeHolder5) {
        this.placeHolder5 = placeHolder5;
    }

    @Basic
    @Column(name = "PLACE_HOLDER5_DESC", nullable = true, length = 200)
    public String getPlaceHolder5Desc() {
        return placeHolder5Desc;
    }

    public void setPlaceHolder5Desc(String placeHolder5Desc) {
        this.placeHolder5Desc = placeHolder5Desc;
    }

    @Basic
    @Column(name = "PLACE_HOLDER6", nullable = true, length = 100)
    public String getPlaceHolder6() {
        return placeHolder6;
    }

    public void setPlaceHolder6(String placeHolder6) {
        this.placeHolder6 = placeHolder6;
    }

    @Basic
    @Column(name = "PLACE_HOLDER6_DESC", nullable = true, length = 200)
    public String getPlaceHolder6Desc() {
        return placeHolder6Desc;
    }

    public void setPlaceHolder6Desc(String placeHolder6Desc) {
        this.placeHolder6Desc = placeHolder6Desc;
    }

    @Basic
    @Column(name = "PLACE_HOLDER7", nullable = true, length = 100)
    public String getPlaceHolder7() {
        return placeHolder7;
    }

    public void setPlaceHolder7(String placeHolder7) {
        this.placeHolder7 = placeHolder7;
    }

    @Basic
    @Column(name = "PLACE_HOLDER7_DESC", nullable = true, length = 200)
    public String getPlaceHolder7Desc() {
        return placeHolder7Desc;
    }

    public void setPlaceHolder7Desc(String placeHolder7Desc) {
        this.placeHolder7Desc = placeHolder7Desc;
    }

    @Basic
    @Column(name = "PLACE_HOLDER8", nullable = true, length = 200)
    public String getPlaceHolder8() {
        return placeHolder8;
    }

    public void setPlaceHolder8(String placeHolder8) {
        this.placeHolder8 = placeHolder8;
    }

    @Basic
    @Column(name = "PLACE_HOLDER8_DESC", nullable = true, length = 300)
    public String getPlaceHolder8Desc() {
        return placeHolder8Desc;
    }

    public void setPlaceHolder8Desc(String placeHolder8Desc) {
        this.placeHolder8Desc = placeHolder8Desc;
    }

    @Basic
    @Column(name = "PLACE_HOLDER9", nullable = true, length = 200)
    public String getPlaceHolder9() {
        return placeHolder9;
    }

    public void setPlaceHolder9(String placeHolder9) {
        this.placeHolder9 = placeHolder9;
    }

    @Basic
    @Column(name = "PLACE_HOLDER9_DESC", nullable = true, length = 300)
    public String getPlaceHolder9Desc() {
        return placeHolder9Desc;
    }

    public void setPlaceHolder9Desc(String placeHolder9Desc) {
        this.placeHolder9Desc = placeHolder9Desc;
    }

    @Basic
    @Column(name = "PLACE_HOLDER10", nullable = true, length = 100)
    public String getPlaceHolder10() {
        return placeHolder10;
    }

    public void setPlaceHolder10(String placeHolder10) {
        this.placeHolder10 = placeHolder10;
    }

    @Basic
    @Column(name = "PLACE_HOLDER10_DESC", nullable = true, length = 300)
    public String getPlaceHolder10Desc() {
        return placeHolder10Desc;
    }

    public void setPlaceHolder10Desc(String placeHolder10Desc) {
        this.placeHolder10Desc = placeHolder10Desc;
    }

    @Basic
    @Column(name = "STATUS", nullable = true, precision = 0)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
    @Column(name = "LAST_UPDATED_DATE", nullable = true)
    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    @Basic
    @Column(name = "LAST_UPDATED_BY", nullable = true, precision = 0)
    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }


    @Basic
    @Column(name = "SMS_KEYWORD", nullable = true, length = 20)
    public String getSmsKeyword() {
        return smsKeyword;
    }

    public void setSmsKeyword(String smsKeyword) {
        this.smsKeyword = smsKeyword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductParameters that = (ProductParameters) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (placeHolder1 != null ? !placeHolder1.equals(that.placeHolder1) : that.placeHolder1 != null) return false;
        if (placeHolder1Desc != null ? !placeHolder1Desc.equals(that.placeHolder1Desc) : that.placeHolder1Desc != null)
            return false;
        if (placeHolder2 != null ? !placeHolder2.equals(that.placeHolder2) : that.placeHolder2 != null) return false;
        if (placeHolder2Desc != null ? !placeHolder2Desc.equals(that.placeHolder2Desc) : that.placeHolder2Desc != null)
            return false;
        if (placeHolder3 != null ? !placeHolder3.equals(that.placeHolder3) : that.placeHolder3 != null) return false;
        if (placeHolder3Desc != null ? !placeHolder3Desc.equals(that.placeHolder3Desc) : that.placeHolder3Desc != null)
            return false;
        if (placeHolder4 != null ? !placeHolder4.equals(that.placeHolder4) : that.placeHolder4 != null) return false;
        if (placeHolder4Desc != null ? !placeHolder4Desc.equals(that.placeHolder4Desc) : that.placeHolder4Desc != null)
            return false;
        if (placeHolder5 != null ? !placeHolder5.equals(that.placeHolder5) : that.placeHolder5 != null) return false;
        if (placeHolder5Desc != null ? !placeHolder5Desc.equals(that.placeHolder5Desc) : that.placeHolder5Desc != null)
            return false;
        if (placeHolder6 != null ? !placeHolder6.equals(that.placeHolder6) : that.placeHolder6 != null) return false;
        if (placeHolder6Desc != null ? !placeHolder6Desc.equals(that.placeHolder6Desc) : that.placeHolder6Desc != null)
            return false;
        if (placeHolder7 != null ? !placeHolder7.equals(that.placeHolder7) : that.placeHolder7 != null) return false;
        if (placeHolder7Desc != null ? !placeHolder7Desc.equals(that.placeHolder7Desc) : that.placeHolder7Desc != null)
            return false;
        if (placeHolder8 != null ? !placeHolder8.equals(that.placeHolder8) : that.placeHolder8 != null) return false;
        if (placeHolder8Desc != null ? !placeHolder8Desc.equals(that.placeHolder8Desc) : that.placeHolder8Desc != null)
            return false;
        if (placeHolder9 != null ? !placeHolder9.equals(that.placeHolder9) : that.placeHolder9 != null) return false;
        if (placeHolder9Desc != null ? !placeHolder9Desc.equals(that.placeHolder9Desc) : that.placeHolder9Desc != null)
            return false;
        if (placeHolder10 != null ? !placeHolder10.equals(that.placeHolder10) : that.placeHolder10 != null)
            return false;
        if (placeHolder10Desc != null ? !placeHolder10Desc.equals(that.placeHolder10Desc) : that.placeHolder10Desc != null)
            return false;
        //if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (creationDate != null ? !creationDate.equals(that.creationDate) : that.creationDate != null) return false;
        if (lastUpdatedDate != null ? !lastUpdatedDate.equals(that.lastUpdatedDate) : that.lastUpdatedDate != null)
            return false;
        if (lastUpdatedBy != null ? !lastUpdatedBy.equals(that.lastUpdatedBy) : that.lastUpdatedBy != null)
            return false;
        if (parameterType != null ? !parameterType.equals(that.parameterType) : that.parameterType != null)
            return false;
        if (smsKeyword != null ? !smsKeyword.equals(that.smsKeyword) : that.smsKeyword != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (placeHolder1 != null ? placeHolder1.hashCode() : 0);
        result = 31 * result + (placeHolder1Desc != null ? placeHolder1Desc.hashCode() : 0);
        result = 31 * result + (placeHolder2 != null ? placeHolder2.hashCode() : 0);
        result = 31 * result + (placeHolder2Desc != null ? placeHolder2Desc.hashCode() : 0);
        result = 31 * result + (placeHolder3 != null ? placeHolder3.hashCode() : 0);
        result = 31 * result + (placeHolder3Desc != null ? placeHolder3Desc.hashCode() : 0);
        result = 31 * result + (placeHolder4 != null ? placeHolder4.hashCode() : 0);
        result = 31 * result + (placeHolder4Desc != null ? placeHolder4Desc.hashCode() : 0);
        result = 31 * result + (placeHolder5 != null ? placeHolder5.hashCode() : 0);
        result = 31 * result + (placeHolder5Desc != null ? placeHolder5Desc.hashCode() : 0);
        result = 31 * result + (placeHolder6 != null ? placeHolder6.hashCode() : 0);
        result = 31 * result + (placeHolder6Desc != null ? placeHolder6Desc.hashCode() : 0);
        result = 31 * result + (placeHolder7 != null ? placeHolder7.hashCode() : 0);
        result = 31 * result + (placeHolder7Desc != null ? placeHolder7Desc.hashCode() : 0);
        result = 31 * result + (placeHolder8 != null ? placeHolder8.hashCode() : 0);
        result = 31 * result + (placeHolder8Desc != null ? placeHolder8Desc.hashCode() : 0);
        result = 31 * result + (placeHolder9 != null ? placeHolder9.hashCode() : 0);
        result = 31 * result + (placeHolder9Desc != null ? placeHolder9Desc.hashCode() : 0);
        result = 31 * result + (placeHolder10 != null ? placeHolder10.hashCode() : 0);
        result = 31 * result + (placeHolder10Desc != null ? placeHolder10Desc.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (lastUpdatedDate != null ? lastUpdatedDate.hashCode() : 0);
        result = 31 * result + (lastUpdatedBy != null ? lastUpdatedBy.hashCode() : 0);
        result = 31 * result + (parameterType != null ? parameterType.hashCode() : 0);
        result = 31 * result + (smsKeyword != null ? smsKeyword.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID", nullable = false)
    public ProductsMaster getProductId() {
        return productId;
    }

    public void setProductId(ProductsMaster cfgProductsMasterByProductId) {
        this.productId = cfgProductsMasterByProductId;
    }

    @ManyToOne
    @JoinColumn(name = "PARAMETER_TYPE", referencedColumnName = "ID")
    public ParameterTypes getParameterType() {
        return parameterType;
    }

    public void setParameterType(ParameterTypes cfgParameterTypesByParameterType) {
        this.parameterType = cfgParameterTypesByParameterType;
    }
}
