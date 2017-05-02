package org.muhia.app.psi.orm.model;/**
 * Copyright 2015-2016 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p>
 * <p>
 * Generated on 30-Oct-16 01:30
 */

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by KennethKZMMuhia
 * Project: psi
 * Package: org.muhia.app.psi.orm.model
 * Generated on: 14-Apr-17, 22:50
 */
@Entity
@Table(name = "REF_COUNTRY_CODES", schema = "PSI")
public class CountryCodes {
    private long countryId;
    private String countryDesc;
    private String isoCountryCode;
    private Long isoCurrCode;
    private String currDescription;
    private Collection<MobileMoneyProviders> countryIds;

    @Id
    @Column(name = "COUNTRY_ID")
    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    @Basic
    @Column(name = "COUNTRY_DESC")
    public String getCountryDesc() {
        return countryDesc;
    }

    public void setCountryDesc(String countryDesc) {
        this.countryDesc = countryDesc;
    }

    @Basic
    @Column(name = "ISO_COUNTRY_CODE")
    public String getIsoCountryCode() {
        return isoCountryCode;
    }

    public void setIsoCountryCode(String isoCountryCode) {
        this.isoCountryCode = isoCountryCode;
    }

    @Basic
    @Column(name = "ISO_CURR_CODE")
    public Long getIsoCurrCode() {
        return isoCurrCode;
    }

    public void setIsoCurrCode(Long isoCurrCode) {
        this.isoCurrCode = isoCurrCode;
    }

    @Basic
    @Column(name = "CURR_DESCRIPTION")
    public String getCurrDescription() {
        return currDescription;
    }

    public void setCurrDescription(String currDescription) {
        this.currDescription = currDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountryCodes that = (CountryCodes) o;

        return countryId == that.countryId && (countryDesc != null ? countryDesc.equals(that.countryDesc) : that.countryDesc == null) && (isoCountryCode != null ? isoCountryCode.equals(that.isoCountryCode) : that.isoCountryCode == null) && (isoCurrCode != null ? isoCurrCode.equals(that.isoCurrCode) : that.isoCurrCode == null) && (currDescription != null ? currDescription.equals(that.currDescription) : that.currDescription == null);
    }

    @Override
    public int hashCode() {
        int result = (int) (countryId ^ (countryId >>> 32));
        result = 31 * result + (countryDesc != null ? countryDesc.hashCode() : 0);
        result = 31 * result + (isoCountryCode != null ? isoCountryCode.hashCode() : 0);
        result = 31 * result + (isoCurrCode != null ? isoCurrCode.hashCode() : 0);
        result = 31 * result + (currDescription != null ? currDescription.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "country")
    public Collection<MobileMoneyProviders> getCountryIds() {
        return countryIds;
    }

    public void setCountryIds(Collection<MobileMoneyProviders> countryIds) {
        this.countryIds = countryIds;
    }
}
