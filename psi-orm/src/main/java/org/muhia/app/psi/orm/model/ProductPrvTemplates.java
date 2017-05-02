package org.muhia.app.psi.orm.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Collection;

/*
  Created by Kenneth
  Project: psi
  Package: org.muhia.apps.psi.orm.model
  Generated on: 30-Mar-17, 08:41.
 */
@Entity
@Table(name = "CFG_PRODUCT_PRV_TEMPLATES")
public class ProductPrvTemplates {
    private Long id;
    private String templateName;
    private String templateDesc;
    private String templateFile;
    private int status;

    private String varFld01;
    private String varFld01Desc;
    private String varFld02;
    private String varFld02Desc;
    private String varFld03;
    private String varFld03Desc;
    private String varFld04;
    private String varFld04Desc;
    private String varFld05;
    private String varFld05Desc;
    private String varFld06;
    private String varFld06Desc;
    private String varFld07;
    private String varFld07Desc;
    private String varFld08;
    private String varFld08Desc;
    private String varFld09;
    private String varFld09Desc;
    private String varFld10;
    private String varFld10Desc;

    private String cdrExtData1;
    private String cdrExtData2;
    private String cdrExtData3;
    private String cdrExtData4;
    private String refillProfileId;
    private String offerId;
    private String ucipTransactionAmount;
    private String dataDaId;
    private String dataDaVolume;
    private String validity;
    private String dataDaUnitType;
    private String usagecounterId;
    private String usagethresholdId;
    private String accumulatorId;
    private Date creationDate;
    private Date lastupdatedDate;
    private String lastupdatedBy;
    private String createdBy;
    private String varFld11;
    private String varFld11Desc;
    private String varFld12;
    private String varFld12Desc;
    private String varFld13;
    private String varFld13Desc;
    private String varFld14;
    private String varFld14Desc;
    private String varFld15;
    private String varFld15Desc;
    private String varFld16;
    private String varFld16Desc;
    private String smsDaId;
    private String smsDaValue;
    private String smsDaOnnetId;
    private String smsDaOnnetValue;
    private String smsDaOffnetId;
    private String smsDaOffnetValue;
    private String voiceDaId;
    private String voiceDaValue;
    private String voiceDaOnnetId;
    private String voiceDaOnnetValue;
    private String voiceDaOffnetId;
    private String voiceDaOffnetValue;
    private String voiceDaInternationalId;
    private String voiceDaInternationalValue;
    private String benefitsShortdesc;
    private String ussdBenefitsShortdesc;
    private String smsAccumId;
    private String smsAccumValue;
    private String smsAccumOnnetId;
    private String smsAccumOnnetValue;
    private String smsAccumOffnetId;
    private String smsAccumOffnetValue;
    private String voiceAccumId;
    private String voiceAccumValue;
    private String voiceAccumOnnetId;
    private String voiceAccumOnnetValue;
    private String voiceAccumOffnetId;
    private String voiceAccumOffnetValue;
    private String voiceAccumIntlId;
    private String voiceAccumIntlValue;
    private String originhostname;
    private ApplicationDst applicationDst;
    private ProductsMaster productId;
    private Collection<ServiceRequests> crmServiceRequestsById;

    @Id
    @SequenceGenerator(name = "CFG_PRODUCT_PRV_TEMPLATES_SEQ_GEN", sequenceName = "CFG_PRODUCT_PRV_TEMPLATES_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "CFG_PRODUCT_PRV_TEMPLATES_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TEMPLATE_NAME", nullable = true, length = 100)
    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    @Basic
    @Column(name = "TEMPLATE_DESC", nullable = true, length = 300)
    public String getTemplateDesc() {
        return templateDesc;
    }

    public void setTemplateDesc(String templateDesc) {
        this.templateDesc = templateDesc;
    }

    @Basic
    @Column(name = "TEMPLATE_FILE", nullable = true, length = 500)
    public String getTemplateFile() {
        return templateFile;
    }

    public void setTemplateFile(String templateFile) {
        this.templateFile = templateFile;
    }

    @Basic
    @Column(name = "STATUS", nullable = true, precision = 0)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    @Basic
    @Column(name = "VAR_FLD_01", nullable = true, length = 100)
    public String getVarFld01() {
        return varFld01;
    }

    public void setVarFld01(String varFld01) {
        this.varFld01 = varFld01;
    }

    @Basic
    @Column(name = "VAR_FLD_01_DESC", nullable = true, length = 300)
    public String getVarFld01Desc() {
        return varFld01Desc;
    }

    public void setVarFld01Desc(String varFld01Desc) {
        this.varFld01Desc = varFld01Desc;
    }

    @Basic
    @Column(name = "VAR_FLD_02", nullable = true, length = 100)
    public String getVarFld02() {
        return varFld02;
    }

    public void setVarFld02(String varFld02) {
        this.varFld02 = varFld02;
    }

    @Basic
    @Column(name = "VAR_FLD_02_DESC", nullable = true, length = 300)
    public String getVarFld02Desc() {
        return varFld02Desc;
    }

    public void setVarFld02Desc(String varFld02Desc) {
        this.varFld02Desc = varFld02Desc;
    }

    @Basic
    @Column(name = "VAR_FLD_03", nullable = true, length = 100)
    public String getVarFld03() {
        return varFld03;
    }

    public void setVarFld03(String varFld03) {
        this.varFld03 = varFld03;
    }

    @Basic
    @Column(name = "VAR_FLD_03_DESC", nullable = true, length = 300)
    public String getVarFld03Desc() {
        return varFld03Desc;
    }

    public void setVarFld03Desc(String varFld03Desc) {
        this.varFld03Desc = varFld03Desc;
    }

    @Basic
    @Column(name = "VAR_FLD_04", nullable = true, length = 100)
    public String getVarFld04() {
        return varFld04;
    }

    public void setVarFld04(String varFld04) {
        this.varFld04 = varFld04;
    }

    @Basic
    @Column(name = "VAR_FLD_04_DESC", nullable = true, length = 300)
    public String getVarFld04Desc() {
        return varFld04Desc;
    }

    public void setVarFld04Desc(String varFld04Desc) {
        this.varFld04Desc = varFld04Desc;
    }

    @Basic
    @Column(name = "VAR_FLD_05", nullable = true, length = 100)
    public String getVarFld05() {
        return varFld05;
    }

    public void setVarFld05(String varFld05) {
        this.varFld05 = varFld05;
    }

    @Basic
    @Column(name = "VAR_FLD_05_DESC", nullable = true, length = 300)
    public String getVarFld05Desc() {
        return varFld05Desc;
    }

    public void setVarFld05Desc(String varFld05Desc) {
        this.varFld05Desc = varFld05Desc;
    }

    @Basic
    @Column(name = "VAR_FLD_06", nullable = true, length = 100)
    public String getVarFld06() {
        return varFld06;
    }

    public void setVarFld06(String varFld06) {
        this.varFld06 = varFld06;
    }

    @Basic
    @Column(name = "VAR_FLD_06_DESC", nullable = true, length = 300)
    public String getVarFld06Desc() {
        return varFld06Desc;
    }

    public void setVarFld06Desc(String varFld06Desc) {
        this.varFld06Desc = varFld06Desc;
    }

    @Basic
    @Column(name = "VAR_FLD_07", nullable = true, length = 100)
    public String getVarFld07() {
        return varFld07;
    }

    public void setVarFld07(String varFld07) {
        this.varFld07 = varFld07;
    }

    @Basic
    @Column(name = "VAR_FLD_07_DESC", nullable = true, length = 300)
    public String getVarFld07Desc() {
        return varFld07Desc;
    }

    public void setVarFld07Desc(String varFld07Desc) {
        this.varFld07Desc = varFld07Desc;
    }

    @Basic
    @Column(name = "VAR_FLD_08", nullable = true, length = 100)
    public String getVarFld08() {
        return varFld08;
    }

    public void setVarFld08(String varFld08) {
        this.varFld08 = varFld08;
    }

    @Basic
    @Column(name = "VAR_FLD_08_DESC", nullable = true, length = 300)
    public String getVarFld08Desc() {
        return varFld08Desc;
    }

    public void setVarFld08Desc(String varFld08Desc) {
        this.varFld08Desc = varFld08Desc;
    }

    @Basic
    @Column(name = "VAR_FLD_09", nullable = true, length = 100)
    public String getVarFld09() {
        return varFld09;
    }

    public void setVarFld09(String varFld09) {
        this.varFld09 = varFld09;
    }

    @Basic
    @Column(name = "VAR_FLD_09_DESC", nullable = true, length = 300)
    public String getVarFld09Desc() {
        return varFld09Desc;
    }

    public void setVarFld09Desc(String varFld09Desc) {
        this.varFld09Desc = varFld09Desc;
    }

    @Basic
    @Column(name = "VAR_FLD_10", nullable = true, length = 100)
    public String getVarFld10() {
        return varFld10;
    }

    public void setVarFld10(String varFld10) {
        this.varFld10 = varFld10;
    }

    @Basic
    @Column(name = "VAR_FLD_10_DESC", nullable = true, length = 300)
    public String getVarFld10Desc() {
        return varFld10Desc;
    }

    public void setVarFld10Desc(String varFld10Desc) {
        this.varFld10Desc = varFld10Desc;
    }


    @Basic
    @Column(name = "CDR_EXT_DATA1", nullable = true, length = 100)
    public String getCdrExtData1() {
        return cdrExtData1;
    }

    public void setCdrExtData1(String cdrExtData1) {
        this.cdrExtData1 = cdrExtData1;
    }

    @Basic
    @Column(name = "CDR_EXT_DATA2", nullable = true, length = 100)
    public String getCdrExtData2() {
        return cdrExtData2;
    }

    public void setCdrExtData2(String cdrExtData2) {
        this.cdrExtData2 = cdrExtData2;
    }

    @Basic
    @Column(name = "CDR_EXT_DATA3", nullable = true, length = 100)
    public String getCdrExtData3() {
        return cdrExtData3;
    }

    public void setCdrExtData3(String cdrExtData3) {
        this.cdrExtData3 = cdrExtData3;
    }

    @Basic
    @Column(name = "CDR_EXT_DATA4", nullable = true, length = 100)
    public String getCdrExtData4() {
        return cdrExtData4;
    }

    public void setCdrExtData4(String cdrExtData4) {
        this.cdrExtData4 = cdrExtData4;
    }

    @Basic
    @Column(name = "REFILL_PROFILE_ID", nullable = true, length = 10)
    public String getRefillProfileId() {
        return refillProfileId;
    }

    public void setRefillProfileId(String refillProfileId) {
        this.refillProfileId = refillProfileId;
    }

    @Basic
    @Column(name = "OFFER_ID", nullable = true, length = 10)
    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    @Basic
    @Column(name = "UCIP_TRANSACTION_AMOUNT", nullable = true, length = 10)
    public String getUcipTransactionAmount() {
        return ucipTransactionAmount;
    }

    public void setUcipTransactionAmount(String ucipTransactionAmount) {
        this.ucipTransactionAmount = ucipTransactionAmount;
    }

    @Basic
    @Column(name = "DATA_DA_ID", nullable = true, length = 20)
    public String getDataDaId() {
        return dataDaId;
    }

    public void setDataDaId(String dataDaId) {
        this.dataDaId = dataDaId;
    }

    @Basic
    @Column(name = "DATA_DA_VOLUME", nullable = true, length = 20)
    public String getDataDaVolume() {
        return dataDaVolume;
    }

    public void setDataDaVolume(String dataDaVolume) {
        this.dataDaVolume = dataDaVolume;
    }

    @Basic
    @Column(name = "VALIDITY", nullable = true, length = 10)
    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    @Basic
    @Column(name = "DATA_DA_UNIT_TYPE", nullable = true, length = 100)
    public String getDataDaUnitType() {
        return dataDaUnitType;
    }

    public void setDataDaUnitType(String dataDaUnitType) {
        this.dataDaUnitType = dataDaUnitType;
    }

    @Basic
    @Column(name = "USAGECOUNTER_ID", nullable = true, length = 20)
    public String getUsagecounterId() {
        return usagecounterId;
    }

    public void setUsagecounterId(String usagecounterId) {
        this.usagecounterId = usagecounterId;
    }

    @Basic
    @Column(name = "USAGETHRESHOLD_ID", nullable = true, length = 20)
    public String getUsagethresholdId() {
        return usagethresholdId;
    }

    public void setUsagethresholdId(String usagethresholdId) {
        this.usagethresholdId = usagethresholdId;
    }

    @Basic
    @Column(name = "ACCUMULATOR_ID", nullable = true, length = 20)
    public String getAccumulatorId() {
        return accumulatorId;
    }

    public void setAccumulatorId(String accumulatorId) {
        this.accumulatorId = accumulatorId;
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
    @Column(name = "LASTUPDATED_DATE", nullable = true)
    public Date getLastupdatedDate() {
        return lastupdatedDate;
    }

    public void setLastupdatedDate(Date lastupdatedDate) {
        this.lastupdatedDate = lastupdatedDate;
    }

    @Basic
    @Column(name = "LASTUPDATED_BY", nullable = true, length = 100)
    public String getLastupdatedBy() {
        return lastupdatedBy;
    }

    public void setLastupdatedBy(String lastupdatedBy) {
        this.lastupdatedBy = lastupdatedBy;
    }

    @Basic
    @Column(name = "CREATED_BY", nullable = true, length = 100)
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Basic
    @Column(name = "VAR_FLD_11", nullable = true, length = 100)
    public String getVarFld11() {
        return varFld11;
    }

    public void setVarFld11(String varFld11) {
        this.varFld11 = varFld11;
    }

    @Basic
    @Column(name = "VAR_FLD_11_DESC", nullable = true, length = 300)
    public String getVarFld11Desc() {
        return varFld11Desc;
    }

    public void setVarFld11Desc(String varFld11Desc) {
        this.varFld11Desc = varFld11Desc;
    }

    @Basic
    @Column(name = "VAR_FLD_12", nullable = true, length = 100)
    public String getVarFld12() {
        return varFld12;
    }

    public void setVarFld12(String varFld12) {
        this.varFld12 = varFld12;
    }

    @Basic
    @Column(name = "VAR_FLD_12_DESC", nullable = true, length = 300)
    public String getVarFld12Desc() {
        return varFld12Desc;
    }

    public void setVarFld12Desc(String varFld12Desc) {
        this.varFld12Desc = varFld12Desc;
    }

    @Basic
    @Column(name = "VAR_FLD_13", nullable = true, length = 100)
    public String getVarFld13() {
        return varFld13;
    }

    public void setVarFld13(String varFld13) {
        this.varFld13 = varFld13;
    }

    @Basic
    @Column(name = "VAR_FLD_13_DESC", nullable = true, length = 300)
    public String getVarFld13Desc() {
        return varFld13Desc;
    }

    public void setVarFld13Desc(String varFld13Desc) {
        this.varFld13Desc = varFld13Desc;
    }

    @Basic
    @Column(name = "VAR_FLD_14", nullable = true, length = 100)
    public String getVarFld14() {
        return varFld14;
    }

    public void setVarFld14(String varFld14) {
        this.varFld14 = varFld14;
    }

    @Basic
    @Column(name = "VAR_FLD_14_DESC", nullable = true, length = 300)
    public String getVarFld14Desc() {
        return varFld14Desc;
    }

    public void setVarFld14Desc(String varFld14Desc) {
        this.varFld14Desc = varFld14Desc;
    }

    @Basic
    @Column(name = "VAR_FLD_15", nullable = true, length = 100)
    public String getVarFld15() {
        return varFld15;
    }

    public void setVarFld15(String varFld15) {
        this.varFld15 = varFld15;
    }

    @Basic
    @Column(name = "VAR_FLD_15_DESC", nullable = true, length = 300)
    public String getVarFld15Desc() {
        return varFld15Desc;
    }

    public void setVarFld15Desc(String varFld15Desc) {
        this.varFld15Desc = varFld15Desc;
    }

    @Basic
    @Column(name = "VAR_FLD_16", nullable = true, length = 100)
    public String getVarFld16() {
        return varFld16;
    }

    public void setVarFld16(String varFld16) {
        this.varFld16 = varFld16;
    }

    @Basic
    @Column(name = "VAR_FLD_16_DESC", nullable = true, length = 300)
    public String getVarFld16Desc() {
        return varFld16Desc;
    }

    public void setVarFld16Desc(String varFld16Desc) {
        this.varFld16Desc = varFld16Desc;
    }

    @Basic
    @Column(name = "SMS_DA_ID", nullable = true, length = 100)
    public String getSmsDaId() {
        return smsDaId;
    }

    public void setSmsDaId(String smsDaId) {
        this.smsDaId = smsDaId;
    }

    @Basic
    @Column(name = "SMS_DA_VALUE", nullable = true, length = 300)
    public String getSmsDaValue() {
        return smsDaValue;
    }

    public void setSmsDaValue(String smsDaValue) {
        this.smsDaValue = smsDaValue;
    }

    @Basic
    @Column(name = "SMS_DA_ONNET_ID", nullable = true, length = 3001)
    public String getSmsDaOnnetId() {
        return smsDaOnnetId;
    }

    public void setSmsDaOnnetId(String smsDaOnnetId) {
        this.smsDaOnnetId = smsDaOnnetId;
    }

    @Basic
    @Column(name = "SMS_DA_ONNET_VALUE", nullable = true, length = 300)
    public String getSmsDaOnnetValue() {
        return smsDaOnnetValue;
    }

    public void setSmsDaOnnetValue(String smsDaOnnetValue) {
        this.smsDaOnnetValue = smsDaOnnetValue;
    }

    @Basic
    @Column(name = "SMS_DA_OFFNET_ID", nullable = true, length = 100)
    public String getSmsDaOffnetId() {
        return smsDaOffnetId;
    }

    public void setSmsDaOffnetId(String smsDaOffnetId) {
        this.smsDaOffnetId = smsDaOffnetId;
    }

    @Basic
    @Column(name = "SMS_DA_OFFNET_VALUE", nullable = true, length = 300)
    public String getSmsDaOffnetValue() {
        return smsDaOffnetValue;
    }

    public void setSmsDaOffnetValue(String smsDaOffnetValue) {
        this.smsDaOffnetValue = smsDaOffnetValue;
    }

    @Basic
    @Column(name = "VOICE_DA_ID", nullable = true, length = 100)
    public String getVoiceDaId() {
        return voiceDaId;
    }

    public void setVoiceDaId(String voiceDaId) {
        this.voiceDaId = voiceDaId;
    }

    @Basic
    @Column(name = "VOICE_DA_VALUE", nullable = true, length = 300)
    public String getVoiceDaValue() {
        return voiceDaValue;
    }

    public void setVoiceDaValue(String voiceDaValue) {
        this.voiceDaValue = voiceDaValue;
    }

    @Basic
    @Column(name = "VOICE_DA_ONNET_ID", nullable = true, length = 100)
    public String getVoiceDaOnnetId() {
        return voiceDaOnnetId;
    }

    public void setVoiceDaOnnetId(String voiceDaOnnetId) {
        this.voiceDaOnnetId = voiceDaOnnetId;
    }

    @Basic
    @Column(name = "VOICE_DA_ONNET_VALUE", nullable = true, length = 300)
    public String getVoiceDaOnnetValue() {
        return voiceDaOnnetValue;
    }

    public void setVoiceDaOnnetValue(String voiceDaOnnetValue) {
        this.voiceDaOnnetValue = voiceDaOnnetValue;
    }

    @Basic
    @Column(name = "VOICE_DA_OFFNET_ID", nullable = true, length = 100)
    public String getVoiceDaOffnetId() {
        return voiceDaOffnetId;
    }

    public void setVoiceDaOffnetId(String voiceDaOffnetId) {
        this.voiceDaOffnetId = voiceDaOffnetId;
    }

    @Basic
    @Column(name = "VOICE_DA_OFFNET_VALUE", nullable = true, length = 300)
    public String getVoiceDaOffnetValue() {
        return voiceDaOffnetValue;
    }

    public void setVoiceDaOffnetValue(String voiceDaOffnetValue) {
        this.voiceDaOffnetValue = voiceDaOffnetValue;
    }

    @Basic
    @Column(name = "VOICE_DA_INTERNATIONAL_ID", nullable = true, length = 100)
    public String getVoiceDaInternationalId() {
        return voiceDaInternationalId;
    }

    public void setVoiceDaInternationalId(String voiceDaInternationalId) {
        this.voiceDaInternationalId = voiceDaInternationalId;
    }

    @Basic
    @Column(name = "VOICE_DA_INTERNATIONAL_VALUE", nullable = true, length = 300)
    public String getVoiceDaInternationalValue() {
        return voiceDaInternationalValue;
    }

    public void setVoiceDaInternationalValue(String voiceDaInternationalValue) {
        this.voiceDaInternationalValue = voiceDaInternationalValue;
    }

    @Basic
    @Column(name = "BENEFITS_SHORTDESC", nullable = true, length = 200)
    public String getBenefitsShortdesc() {
        return benefitsShortdesc;
    }

    public void setBenefitsShortdesc(String benefitsShortdesc) {
        this.benefitsShortdesc = benefitsShortdesc;
    }

    @Basic
    @Column(name = "USSD_BENEFITS_SHORTDESC", nullable = true, length = 200)
    public String getUssdBenefitsShortdesc() {
        return ussdBenefitsShortdesc;
    }

    public void setUssdBenefitsShortdesc(String ussdBenefitsShortdesc) {
        this.ussdBenefitsShortdesc = ussdBenefitsShortdesc;
    }

    @Basic
    @Column(name = "SMS_ACCUM_ID", nullable = true, length = 200)
    public String getSmsAccumId() {
        return smsAccumId;
    }

    public void setSmsAccumId(String smsAccumId) {
        this.smsAccumId = smsAccumId;
    }

    @Basic
    @Column(name = "SMS_ACCUM_VALUE", nullable = true, length = 200)
    public String getSmsAccumValue() {
        return smsAccumValue;
    }

    public void setSmsAccumValue(String smsAccumValue) {
        this.smsAccumValue = smsAccumValue;
    }

    @Basic
    @Column(name = "SMS_ACCUM_ONNET_ID", nullable = true, length = 200)
    public String getSmsAccumOnnetId() {
        return smsAccumOnnetId;
    }

    public void setSmsAccumOnnetId(String smsAccumOnnetId) {
        this.smsAccumOnnetId = smsAccumOnnetId;
    }

    @Basic
    @Column(name = "SMS_ACCUM_ONNET_VALUE", nullable = true, length = 300)
    public String getSmsAccumOnnetValue() {
        return smsAccumOnnetValue;
    }

    public void setSmsAccumOnnetValue(String smsAccumOnnetValue) {
        this.smsAccumOnnetValue = smsAccumOnnetValue;
    }

    @Basic
    @Column(name = "SMS_ACCUM_OFFNET_ID", nullable = true, length = 200)
    public String getSmsAccumOffnetId() {
        return smsAccumOffnetId;
    }

    public void setSmsAccumOffnetId(String smsAccumOffnetId) {
        this.smsAccumOffnetId = smsAccumOffnetId;
    }

    @Basic
    @Column(name = "SMS_ACCUM_OFFNET_VALUE", nullable = true, length = 300)
    public String getSmsAccumOffnetValue() {
        return smsAccumOffnetValue;
    }

    public void setSmsAccumOffnetValue(String smsAccumOffnetValue) {
        this.smsAccumOffnetValue = smsAccumOffnetValue;
    }

    @Basic
    @Column(name = "VOICE_ACCUM_ID", nullable = true, length = 200)
    public String getVoiceAccumId() {
        return voiceAccumId;
    }

    public void setVoiceAccumId(String voiceAccumId) {
        this.voiceAccumId = voiceAccumId;
    }

    @Basic
    @Column(name = "VOICE_ACCUM_VALUE", nullable = true, length = 300)
    public String getVoiceAccumValue() {
        return voiceAccumValue;
    }

    public void setVoiceAccumValue(String voiceAccumValue) {
        this.voiceAccumValue = voiceAccumValue;
    }

    @Basic
    @Column(name = "VOICE_ACCUM_ONNET_ID", nullable = true, length = 200)
    public String getVoiceAccumOnnetId() {
        return voiceAccumOnnetId;
    }

    public void setVoiceAccumOnnetId(String voiceAccumOnnetId) {
        this.voiceAccumOnnetId = voiceAccumOnnetId;
    }

    @Basic
    @Column(name = "VOICE_ACCUM_ONNET_VALUE", nullable = true, length = 300)
    public String getVoiceAccumOnnetValue() {
        return voiceAccumOnnetValue;
    }

    public void setVoiceAccumOnnetValue(String voiceAccumOnnetValue) {
        this.voiceAccumOnnetValue = voiceAccumOnnetValue;
    }

    @Basic
    @Column(name = "VOICE_ACCUM_OFFNET_ID", nullable = true, length = 200)
    public String getVoiceAccumOffnetId() {
        return voiceAccumOffnetId;
    }

    public void setVoiceAccumOffnetId(String voiceAccumOffnetId) {
        this.voiceAccumOffnetId = voiceAccumOffnetId;
    }

    @Basic
    @Column(name = "VOICE_ACCUM_OFFNET_VALUE", nullable = true, length = 300)
    public String getVoiceAccumOffnetValue() {
        return voiceAccumOffnetValue;
    }

    public void setVoiceAccumOffnetValue(String voiceAccumOffnetValue) {
        this.voiceAccumOffnetValue = voiceAccumOffnetValue;
    }

    @Basic
    @Column(name = "VOICE_ACCUM_INTL_ID", nullable = true, length = 200)
    public String getVoiceAccumIntlId() {
        return voiceAccumIntlId;
    }

    public void setVoiceAccumIntlId(String voiceAccumIntlId) {
        this.voiceAccumIntlId = voiceAccumIntlId;
    }

    @Basic
    @Column(name = "VOICE_ACCUM_INTL_VALUE", nullable = true, length = 300)
    public String getVoiceAccumIntlValue() {
        return voiceAccumIntlValue;
    }

    public void setVoiceAccumIntlValue(String voiceAccumIntlValue) {
        this.voiceAccumIntlValue = voiceAccumIntlValue;
    }

    @Basic
    @Column(name = "ORIGINHOSTNAME", nullable = true, length = 300)
    public String getOriginhostname() {
        return originhostname;
    }

    public void setOriginhostname(String originhostname) {
        this.originhostname = originhostname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductPrvTemplates that = (ProductPrvTemplates) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (templateName != null ? !templateName.equals(that.templateName) : that.templateName != null) return false;
        if (templateDesc != null ? !templateDesc.equals(that.templateDesc) : that.templateDesc != null) return false;
        if (templateFile != null ? !templateFile.equals(that.templateFile) : that.templateFile != null) return false;

        if (applicationDst != null ? !applicationDst.equals(that.applicationDst) : that.applicationDst != null)
            return false;
        if (varFld01 != null ? !varFld01.equals(that.varFld01) : that.varFld01 != null) return false;
        if (varFld01Desc != null ? !varFld01Desc.equals(that.varFld01Desc) : that.varFld01Desc != null) return false;
        if (varFld02 != null ? !varFld02.equals(that.varFld02) : that.varFld02 != null) return false;
        if (varFld02Desc != null ? !varFld02Desc.equals(that.varFld02Desc) : that.varFld02Desc != null) return false;
        if (varFld03 != null ? !varFld03.equals(that.varFld03) : that.varFld03 != null) return false;
        if (varFld03Desc != null ? !varFld03Desc.equals(that.varFld03Desc) : that.varFld03Desc != null) return false;
        if (varFld04 != null ? !varFld04.equals(that.varFld04) : that.varFld04 != null) return false;
        if (varFld04Desc != null ? !varFld04Desc.equals(that.varFld04Desc) : that.varFld04Desc != null) return false;
        if (varFld05 != null ? !varFld05.equals(that.varFld05) : that.varFld05 != null) return false;
        if (varFld05Desc != null ? !varFld05Desc.equals(that.varFld05Desc) : that.varFld05Desc != null) return false;
        if (varFld06 != null ? !varFld06.equals(that.varFld06) : that.varFld06 != null) return false;
        if (varFld06Desc != null ? !varFld06Desc.equals(that.varFld06Desc) : that.varFld06Desc != null) return false;
        if (varFld07 != null ? !varFld07.equals(that.varFld07) : that.varFld07 != null) return false;
        if (varFld07Desc != null ? !varFld07Desc.equals(that.varFld07Desc) : that.varFld07Desc != null) return false;
        if (varFld08 != null ? !varFld08.equals(that.varFld08) : that.varFld08 != null) return false;
        if (varFld08Desc != null ? !varFld08Desc.equals(that.varFld08Desc) : that.varFld08Desc != null) return false;
        if (varFld09 != null ? !varFld09.equals(that.varFld09) : that.varFld09 != null) return false;
        if (varFld09Desc != null ? !varFld09Desc.equals(that.varFld09Desc) : that.varFld09Desc != null) return false;
        if (varFld10 != null ? !varFld10.equals(that.varFld10) : that.varFld10 != null) return false;
        if (varFld10Desc != null ? !varFld10Desc.equals(that.varFld10Desc) : that.varFld10Desc != null) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (cdrExtData1 != null ? !cdrExtData1.equals(that.cdrExtData1) : that.cdrExtData1 != null) return false;
        if (cdrExtData2 != null ? !cdrExtData2.equals(that.cdrExtData2) : that.cdrExtData2 != null) return false;
        if (cdrExtData3 != null ? !cdrExtData3.equals(that.cdrExtData3) : that.cdrExtData3 != null) return false;
        if (cdrExtData4 != null ? !cdrExtData4.equals(that.cdrExtData4) : that.cdrExtData4 != null) return false;
        if (refillProfileId != null ? !refillProfileId.equals(that.refillProfileId) : that.refillProfileId != null)
            return false;
        if (offerId != null ? !offerId.equals(that.offerId) : that.offerId != null) return false;
        if (ucipTransactionAmount != null ? !ucipTransactionAmount.equals(that.ucipTransactionAmount) : that.ucipTransactionAmount != null)
            return false;
        if (dataDaId != null ? !dataDaId.equals(that.dataDaId) : that.dataDaId != null) return false;
        if (dataDaVolume != null ? !dataDaVolume.equals(that.dataDaVolume) : that.dataDaVolume != null) return false;
        if (validity != null ? !validity.equals(that.validity) : that.validity != null) return false;
        if (dataDaUnitType != null ? !dataDaUnitType.equals(that.dataDaUnitType) : that.dataDaUnitType != null)
            return false;
        if (usagecounterId != null ? !usagecounterId.equals(that.usagecounterId) : that.usagecounterId != null)
            return false;
        if (usagethresholdId != null ? !usagethresholdId.equals(that.usagethresholdId) : that.usagethresholdId != null)
            return false;
        if (accumulatorId != null ? !accumulatorId.equals(that.accumulatorId) : that.accumulatorId != null)
            return false;
        if (creationDate != null ? !creationDate.equals(that.creationDate) : that.creationDate != null) return false;
        if (lastupdatedDate != null ? !lastupdatedDate.equals(that.lastupdatedDate) : that.lastupdatedDate != null)
            return false;
        if (lastupdatedBy != null ? !lastupdatedBy.equals(that.lastupdatedBy) : that.lastupdatedBy != null)
            return false;
        if (createdBy != null ? !createdBy.equals(that.createdBy) : that.createdBy != null) return false;
        if (varFld11 != null ? !varFld11.equals(that.varFld11) : that.varFld11 != null) return false;
        if (varFld11Desc != null ? !varFld11Desc.equals(that.varFld11Desc) : that.varFld11Desc != null) return false;
        if (varFld12 != null ? !varFld12.equals(that.varFld12) : that.varFld12 != null) return false;
        if (varFld12Desc != null ? !varFld12Desc.equals(that.varFld12Desc) : that.varFld12Desc != null) return false;
        if (varFld13 != null ? !varFld13.equals(that.varFld13) : that.varFld13 != null) return false;
        if (varFld13Desc != null ? !varFld13Desc.equals(that.varFld13Desc) : that.varFld13Desc != null) return false;
        if (varFld14 != null ? !varFld14.equals(that.varFld14) : that.varFld14 != null) return false;
        if (varFld14Desc != null ? !varFld14Desc.equals(that.varFld14Desc) : that.varFld14Desc != null) return false;
        if (varFld15 != null ? !varFld15.equals(that.varFld15) : that.varFld15 != null) return false;
        if (varFld15Desc != null ? !varFld15Desc.equals(that.varFld15Desc) : that.varFld15Desc != null) return false;
        if (varFld16 != null ? !varFld16.equals(that.varFld16) : that.varFld16 != null) return false;
        if (varFld16Desc != null ? !varFld16Desc.equals(that.varFld16Desc) : that.varFld16Desc != null) return false;
        if (smsDaId != null ? !smsDaId.equals(that.smsDaId) : that.smsDaId != null) return false;
        if (smsDaValue != null ? !smsDaValue.equals(that.smsDaValue) : that.smsDaValue != null) return false;
        if (smsDaOnnetId != null ? !smsDaOnnetId.equals(that.smsDaOnnetId) : that.smsDaOnnetId != null) return false;
        if (smsDaOnnetValue != null ? !smsDaOnnetValue.equals(that.smsDaOnnetValue) : that.smsDaOnnetValue != null)
            return false;
        if (smsDaOffnetId != null ? !smsDaOffnetId.equals(that.smsDaOffnetId) : that.smsDaOffnetId != null)
            return false;
        if (smsDaOffnetValue != null ? !smsDaOffnetValue.equals(that.smsDaOffnetValue) : that.smsDaOffnetValue != null)
            return false;
        if (voiceDaId != null ? !voiceDaId.equals(that.voiceDaId) : that.voiceDaId != null) return false;
        if (voiceDaValue != null ? !voiceDaValue.equals(that.voiceDaValue) : that.voiceDaValue != null) return false;
        if (voiceDaOnnetId != null ? !voiceDaOnnetId.equals(that.voiceDaOnnetId) : that.voiceDaOnnetId != null)
            return false;
        if (voiceDaOnnetValue != null ? !voiceDaOnnetValue.equals(that.voiceDaOnnetValue) : that.voiceDaOnnetValue != null)
            return false;
        if (voiceDaOffnetId != null ? !voiceDaOffnetId.equals(that.voiceDaOffnetId) : that.voiceDaOffnetId != null)
            return false;
        if (voiceDaOffnetValue != null ? !voiceDaOffnetValue.equals(that.voiceDaOffnetValue) : that.voiceDaOffnetValue != null)
            return false;
        if (voiceDaInternationalId != null ? !voiceDaInternationalId.equals(that.voiceDaInternationalId) : that.voiceDaInternationalId != null)
            return false;
        if (voiceDaInternationalValue != null ? !voiceDaInternationalValue.equals(that.voiceDaInternationalValue) : that.voiceDaInternationalValue != null)
            return false;
        if (benefitsShortdesc != null ? !benefitsShortdesc.equals(that.benefitsShortdesc) : that.benefitsShortdesc != null)
            return false;
        if (ussdBenefitsShortdesc != null ? !ussdBenefitsShortdesc.equals(that.ussdBenefitsShortdesc) : that.ussdBenefitsShortdesc != null)
            return false;
        if (smsAccumId != null ? !smsAccumId.equals(that.smsAccumId) : that.smsAccumId != null) return false;
        if (smsAccumValue != null ? !smsAccumValue.equals(that.smsAccumValue) : that.smsAccumValue != null)
            return false;
        if (smsAccumOnnetId != null ? !smsAccumOnnetId.equals(that.smsAccumOnnetId) : that.smsAccumOnnetId != null)
            return false;
        if (smsAccumOnnetValue != null ? !smsAccumOnnetValue.equals(that.smsAccumOnnetValue) : that.smsAccumOnnetValue != null)
            return false;
        if (smsAccumOffnetId != null ? !smsAccumOffnetId.equals(that.smsAccumOffnetId) : that.smsAccumOffnetId != null)
            return false;
        if (smsAccumOffnetValue != null ? !smsAccumOffnetValue.equals(that.smsAccumOffnetValue) : that.smsAccumOffnetValue != null)
            return false;
        if (voiceAccumId != null ? !voiceAccumId.equals(that.voiceAccumId) : that.voiceAccumId != null) return false;
        if (voiceAccumValue != null ? !voiceAccumValue.equals(that.voiceAccumValue) : that.voiceAccumValue != null)
            return false;
        if (voiceAccumOnnetId != null ? !voiceAccumOnnetId.equals(that.voiceAccumOnnetId) : that.voiceAccumOnnetId != null)
            return false;
        if (voiceAccumOnnetValue != null ? !voiceAccumOnnetValue.equals(that.voiceAccumOnnetValue) : that.voiceAccumOnnetValue != null)
            return false;
        if (voiceAccumOffnetId != null ? !voiceAccumOffnetId.equals(that.voiceAccumOffnetId) : that.voiceAccumOffnetId != null)
            return false;
        if (voiceAccumOffnetValue != null ? !voiceAccumOffnetValue.equals(that.voiceAccumOffnetValue) : that.voiceAccumOffnetValue != null)
            return false;
        if (voiceAccumIntlId != null ? !voiceAccumIntlId.equals(that.voiceAccumIntlId) : that.voiceAccumIntlId != null)
            return false;
        if (voiceAccumIntlValue != null ? !voiceAccumIntlValue.equals(that.voiceAccumIntlValue) : that.voiceAccumIntlValue != null)
            return false;
        if (originhostname != null ? !originhostname.equals(that.originhostname) : that.originhostname != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (templateName != null ? templateName.hashCode() : 0);
        result = 31 * result + (templateDesc != null ? templateDesc.hashCode() : 0);
        result = 31 * result + (templateFile != null ? templateFile.hashCode() : 0);

        result = 31 * result + (applicationDst != null ? applicationDst.hashCode() : 0);
        result = 31 * result + (varFld01 != null ? varFld01.hashCode() : 0);
        result = 31 * result + (varFld01Desc != null ? varFld01Desc.hashCode() : 0);
        result = 31 * result + (varFld02 != null ? varFld02.hashCode() : 0);
        result = 31 * result + (varFld02Desc != null ? varFld02Desc.hashCode() : 0);
        result = 31 * result + (varFld03 != null ? varFld03.hashCode() : 0);
        result = 31 * result + (varFld03Desc != null ? varFld03Desc.hashCode() : 0);
        result = 31 * result + (varFld04 != null ? varFld04.hashCode() : 0);
        result = 31 * result + (varFld04Desc != null ? varFld04Desc.hashCode() : 0);
        result = 31 * result + (varFld05 != null ? varFld05.hashCode() : 0);
        result = 31 * result + (varFld05Desc != null ? varFld05Desc.hashCode() : 0);
        result = 31 * result + (varFld06 != null ? varFld06.hashCode() : 0);
        result = 31 * result + (varFld06Desc != null ? varFld06Desc.hashCode() : 0);
        result = 31 * result + (varFld07 != null ? varFld07.hashCode() : 0);
        result = 31 * result + (varFld07Desc != null ? varFld07Desc.hashCode() : 0);
        result = 31 * result + (varFld08 != null ? varFld08.hashCode() : 0);
        result = 31 * result + (varFld08Desc != null ? varFld08Desc.hashCode() : 0);
        result = 31 * result + (varFld09 != null ? varFld09.hashCode() : 0);
        result = 31 * result + (varFld09Desc != null ? varFld09Desc.hashCode() : 0);
        result = 31 * result + (varFld10 != null ? varFld10.hashCode() : 0);
        result = 31 * result + (varFld10Desc != null ? varFld10Desc.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (cdrExtData1 != null ? cdrExtData1.hashCode() : 0);
        result = 31 * result + (cdrExtData2 != null ? cdrExtData2.hashCode() : 0);
        result = 31 * result + (cdrExtData3 != null ? cdrExtData3.hashCode() : 0);
        result = 31 * result + (cdrExtData4 != null ? cdrExtData4.hashCode() : 0);
        result = 31 * result + (refillProfileId != null ? refillProfileId.hashCode() : 0);
        result = 31 * result + (offerId != null ? offerId.hashCode() : 0);
        result = 31 * result + (ucipTransactionAmount != null ? ucipTransactionAmount.hashCode() : 0);
        result = 31 * result + (dataDaId != null ? dataDaId.hashCode() : 0);
        result = 31 * result + (dataDaVolume != null ? dataDaVolume.hashCode() : 0);
        result = 31 * result + (validity != null ? validity.hashCode() : 0);
        result = 31 * result + (dataDaUnitType != null ? dataDaUnitType.hashCode() : 0);
        result = 31 * result + (usagecounterId != null ? usagecounterId.hashCode() : 0);
        result = 31 * result + (usagethresholdId != null ? usagethresholdId.hashCode() : 0);
        result = 31 * result + (accumulatorId != null ? accumulatorId.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (lastupdatedDate != null ? lastupdatedDate.hashCode() : 0);
        result = 31 * result + (lastupdatedBy != null ? lastupdatedBy.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (varFld11 != null ? varFld11.hashCode() : 0);
        result = 31 * result + (varFld11Desc != null ? varFld11Desc.hashCode() : 0);
        result = 31 * result + (varFld12 != null ? varFld12.hashCode() : 0);
        result = 31 * result + (varFld12Desc != null ? varFld12Desc.hashCode() : 0);
        result = 31 * result + (varFld13 != null ? varFld13.hashCode() : 0);
        result = 31 * result + (varFld13Desc != null ? varFld13Desc.hashCode() : 0);
        result = 31 * result + (varFld14 != null ? varFld14.hashCode() : 0);
        result = 31 * result + (varFld14Desc != null ? varFld14Desc.hashCode() : 0);
        result = 31 * result + (varFld15 != null ? varFld15.hashCode() : 0);
        result = 31 * result + (varFld15Desc != null ? varFld15Desc.hashCode() : 0);
        result = 31 * result + (varFld16 != null ? varFld16.hashCode() : 0);
        result = 31 * result + (varFld16Desc != null ? varFld16Desc.hashCode() : 0);
        result = 31 * result + (smsDaId != null ? smsDaId.hashCode() : 0);
        result = 31 * result + (smsDaValue != null ? smsDaValue.hashCode() : 0);
        result = 31 * result + (smsDaOnnetId != null ? smsDaOnnetId.hashCode() : 0);
        result = 31 * result + (smsDaOnnetValue != null ? smsDaOnnetValue.hashCode() : 0);
        result = 31 * result + (smsDaOffnetId != null ? smsDaOffnetId.hashCode() : 0);
        result = 31 * result + (smsDaOffnetValue != null ? smsDaOffnetValue.hashCode() : 0);
        result = 31 * result + (voiceDaId != null ? voiceDaId.hashCode() : 0);
        result = 31 * result + (voiceDaValue != null ? voiceDaValue.hashCode() : 0);
        result = 31 * result + (voiceDaOnnetId != null ? voiceDaOnnetId.hashCode() : 0);
        result = 31 * result + (voiceDaOnnetValue != null ? voiceDaOnnetValue.hashCode() : 0);
        result = 31 * result + (voiceDaOffnetId != null ? voiceDaOffnetId.hashCode() : 0);
        result = 31 * result + (voiceDaOffnetValue != null ? voiceDaOffnetValue.hashCode() : 0);
        result = 31 * result + (voiceDaInternationalId != null ? voiceDaInternationalId.hashCode() : 0);
        result = 31 * result + (voiceDaInternationalValue != null ? voiceDaInternationalValue.hashCode() : 0);
        result = 31 * result + (benefitsShortdesc != null ? benefitsShortdesc.hashCode() : 0);
        result = 31 * result + (ussdBenefitsShortdesc != null ? ussdBenefitsShortdesc.hashCode() : 0);
        result = 31 * result + (smsAccumId != null ? smsAccumId.hashCode() : 0);
        result = 31 * result + (smsAccumValue != null ? smsAccumValue.hashCode() : 0);
        result = 31 * result + (smsAccumOnnetId != null ? smsAccumOnnetId.hashCode() : 0);
        result = 31 * result + (smsAccumOnnetValue != null ? smsAccumOnnetValue.hashCode() : 0);
        result = 31 * result + (smsAccumOffnetId != null ? smsAccumOffnetId.hashCode() : 0);
        result = 31 * result + (smsAccumOffnetValue != null ? smsAccumOffnetValue.hashCode() : 0);
        result = 31 * result + (voiceAccumId != null ? voiceAccumId.hashCode() : 0);
        result = 31 * result + (voiceAccumValue != null ? voiceAccumValue.hashCode() : 0);
        result = 31 * result + (voiceAccumOnnetId != null ? voiceAccumOnnetId.hashCode() : 0);
        result = 31 * result + (voiceAccumOnnetValue != null ? voiceAccumOnnetValue.hashCode() : 0);
        result = 31 * result + (voiceAccumOffnetId != null ? voiceAccumOffnetId.hashCode() : 0);
        result = 31 * result + (voiceAccumOffnetValue != null ? voiceAccumOffnetValue.hashCode() : 0);
        result = 31 * result + (voiceAccumIntlId != null ? voiceAccumIntlId.hashCode() : 0);
        result = 31 * result + (voiceAccumIntlValue != null ? voiceAccumIntlValue.hashCode() : 0);
        result = 31 * result + (originhostname != null ? originhostname.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "APPLICATION_DST", referencedColumnName = "ID")
    public ApplicationDst getApplicationDst() {
        return applicationDst;
    }

    public void setApplicationDst(ApplicationDst cfgApplicationDstByApplicationDst) {
        this.applicationDst = cfgApplicationDstByApplicationDst;
    }

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID", nullable = false)
    public ProductsMaster getProductId() {
        return productId;
    }

    public void setProductId(ProductsMaster cfgProductsMasterByProductId) {
        this.productId = cfgProductsMasterByProductId;
    }

    @OneToMany(mappedBy = "prvTemplate")
    public Collection<ServiceRequests> getCrmServiceRequestsById() {
        return crmServiceRequestsById;
    }

    public void setCrmServiceRequestsById(Collection<ServiceRequests> crmServiceRequestsById) {
        this.crmServiceRequestsById = crmServiceRequestsById;
    }
}
