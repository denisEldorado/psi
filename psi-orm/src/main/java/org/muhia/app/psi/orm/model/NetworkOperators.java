package org.muhia.app.psi.orm.model;

import javax.persistence.*;

/*
  Created by Kenneth
  Project: psi
  Package: org.muhia.apps.psi.orm.model
  Generated on: 30-Mar-17, 08:43.
 */
@Entity
@Table(name = "REF_NETWORK_OPERATORS")
public class NetworkOperators {
    private Long networkId;
    private String countryCode;
    private String operatorName;
    private String mobileMoneyname;
    private Long mcc;

    @Id
    @Column(name = "NETWORK_ID", nullable = true, precision = 0)
    public Long getNetworkId() {
        return networkId;
    }

    public void setNetworkId(Long networkId) {
        this.networkId = networkId;
    }

    @Basic
    @Column(name = "COUNTRY_CODE", nullable = true, length = 10)
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Basic
    @Column(name = "OPERATOR_NAME", nullable = true, length = 200)
    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    @Basic
    @Column(name = "MOBILE_MONEYNAME", nullable = true, length = 300)
    public String getMobileMoneyname() {
        return mobileMoneyname;
    }

    public void setMobileMoneyname(String mobileMoneyname) {
        this.mobileMoneyname = mobileMoneyname;
    }

    @Basic
    @Column(name = "MCC", nullable = true, precision = 0)
    public Long getMcc() {
        return mcc;
    }

    public void setMcc(Long mcc) {
        this.mcc = mcc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NetworkOperators that = (NetworkOperators) o;

        if (networkId != null ? !networkId.equals(that.networkId) : that.networkId != null) return false;
        if (countryCode != null ? !countryCode.equals(that.countryCode) : that.countryCode != null) return false;
        if (operatorName != null ? !operatorName.equals(that.operatorName) : that.operatorName != null) return false;
        if (mobileMoneyname != null ? !mobileMoneyname.equals(that.mobileMoneyname) : that.mobileMoneyname != null)
            return false;
        if (mcc != null ? !mcc.equals(that.mcc) : that.mcc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = networkId != null ? networkId.hashCode() : 0;
        result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
        result = 31 * result + (operatorName != null ? operatorName.hashCode() : 0);
        result = 31 * result + (mobileMoneyname != null ? mobileMoneyname.hashCode() : 0);
        result = 31 * result + (mcc != null ? mcc.hashCode() : 0);
        return result;
    }
}
