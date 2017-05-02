package org.muhia.app.psi.config.org.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource(value = {"file:${CONFIG_PATH}/organization.properties"})
public class OrganizationProperties {

    @Value("${org.name}")
    private String organizationName;
    @Value("${org.muhia.psi.org.site.data.applicationPropertyUrl}")
    private String applicationPropertyUrl;
    @Value("${org.muhia.psi.org.site.data.siteName}")
    private String siteName;
    @Value("${org.muhia.psi.org.site.data.greeting}")
    private String greeting;
    @Value("${org.code}")
    private String organizationCode;
    @Value("${org.prefix}")
    private String organizationPrefix;
    @Value("${org.serial}")
    private String organizationSerial;
    @Value("${org.numbering.range.imsi.mvno}")
    private String[] mvnoImsiSeries;
    @Value("${org.numbering.range.imsi.mvno.smssender}")
    private String[] mvnoImsiSmsSender;
    @Value("${org.numbering.range.imsi.conquest}")
    private String[] conquestImsiSeries;
    @Value("${org.numbering.range.imsi.conquest.smssender}")
    private String[] conquestImsiSmsSender;
    @Value("${org.validator}")
    private String organizationValidator;
    @Value("${org.sms.complex.smssender.flag}")
    private boolean complexSmsSender;
    @Value("${org.crm.selfcare.url.alt.flag}")
    private boolean altSelfcareUrl;
    @Value("${org.keystore.token}")
    private String organizationToken;
    @Value("${org.digest.message}")
    private String digestMessage;
    @Value("${org.digest.iso}")
    private String digestIso;
    @Value("${org.validation.email.pattern.prefix}")
    private String emailValidationPrefix;
    @Value("${org.validation.email.pattern.suffix}")
    private String emailValidationSuffix;
    @Value("${org.validation.password.default.message}")
    private String passwordDefaultMessage;
    @Value("${org.utils.ucip.date.format.sdf.notimezone}")
    private String simpleDateFormatNoTimezone;
    @Value("${org.utils.ucip.date.format.sdf}")
    private String simpleDateFormat;
    @Value("${org.utils.date.offset}")
    private int dateOffset;
    @Value("${org.validation.token.expiry.minutes}")
    private int validationTokenExpiryMinutes;
    @Value("${org.validation.token.admin.expiry.minutes}")
    private int adminValidationTokenExpiryMinutes;
    @Value("${org.utils.da.special.value}")
    private int specialDaValue;
    @Value("${org.utils.default.value}")
    private int defaultValue;
    @Value("${org.utils.da.regular.type}")
    private int regularDaType;
    @Value("${org.utils.da.special.type}")
    private int specialDaType;
    @Value("${org.ussd.menu.offset.flag}")
    private boolean menuOffsetFlag;
    @Value("${org.utils.order.bundle.type.buy4other.enable}")
    private int bundleTypeBuy4OtherEnable;
    @Value("${org.utils.order.bundle.type.buy4other.id}")
    private int[] bundleTypeBuy4OtherId;
    @Value("${org.utils.order.bundle.type.buy4other.cdrtag.prefix}")
    private String bundleTypeBuy4OtherCdrTagPrefix;
    @Value("${org.utils.order.bundle.type.buy4other.cdrtag.suffix}")
    private String bundleTypeBuy4OtherCdrTagSuffix;
    @Value("${org.keystore.path}")
    private String organizationPath;
    @Value("${org.muhia.app.psi.hashing.config.keySize}")
    private int hashingConfigKeysize;
    @Value("${org.muhia.app.psi.hashing.config.algorithmCbc}")
    private String hashingConfigAlgorithmCbc;
    @Value("${org.muhia.app.psi.hashing.config.algorithm}")
    private String hashingConfigAlgorithm;
    @Value("${org.muhia.app.psi.hashing.config.encoding}")
    private String hashingConfigEncoding;
    @Value("${org.muhia.psi.mailer.key.word.localhost}")
    private  String keyWordLocalhost;

    @Bean
    public static PropertySourcesPlaceholderConfigurer organizationPropertyConfig() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getOrganizationPrefix() {
        return organizationPrefix;
    }

    public void setOrganizationPrefix(String organizationPrefix) {
        this.organizationPrefix = organizationPrefix;
    }

    public String getOrganizationSerial() {
        return organizationSerial;
    }

    public void setOrganizationSerial(String organizationSerial) {
        this.organizationSerial = organizationSerial;
    }

    public String[] getMvnoImsiSeries() {
        return mvnoImsiSeries;
    }

    public void setMvnoImsiSeries(String[] mvnoImsiSeries) {
        this.mvnoImsiSeries = mvnoImsiSeries;
    }

    public String[] getMvnoImsiSmsSender() {
        return mvnoImsiSmsSender;
    }

    public void setMvnoImsiSmsSender(String[] mvnoImsiSmsSender) {
        this.mvnoImsiSmsSender = mvnoImsiSmsSender;
    }

    public String[] getConquestImsiSeries() {
        return conquestImsiSeries;
    }

    public void setConquestImsiSeries(String[] conquestImsiSeries) {
        this.conquestImsiSeries = conquestImsiSeries;
    }

    public String[] getConquestImsiSmsSender() {
        return conquestImsiSmsSender;
    }

    public void setConquestImsiSmsSender(String[] conquestImsiSmsSender) {
        this.conquestImsiSmsSender = conquestImsiSmsSender;
    }

    public String getOrganizationValidator() {
        return organizationValidator;
    }

    public void setOrganizationValidator(String organizationValidator) {
        this.organizationValidator = organizationValidator;
    }

    public boolean isComplexSmsSender() {
        return complexSmsSender;
    }

    public void setComplexSmsSender(boolean complexSmsSender) {
        this.complexSmsSender = complexSmsSender;
    }

    public boolean isAltSelfcareUrl() {
        return altSelfcareUrl;
    }

    public void setAltSelfcareUrl(boolean altSelfcareUrl) {
        this.altSelfcareUrl = altSelfcareUrl;
    }

    public String getOrganizationToken() {
        return organizationToken;
    }

    public void setOrganizationToken(String organizationToken) {
        this.organizationToken = organizationToken;
    }

    public String getDigestMessage() {
        return digestMessage;
    }

    public void setDigestMessage(String digestMessage) {
        this.digestMessage = digestMessage;
    }

    public String getDigestIso() {
        return digestIso;
    }

    public void setDigestIso(String digestIso) {
        this.digestIso = digestIso;
    }

    public String getEmailValidationPrefix() {
        return emailValidationPrefix;
    }

    public void setEmailValidationPrefix(String emailValidationPrefix) {
        this.emailValidationPrefix = emailValidationPrefix;
    }

    public String getEmailValidationSuffix() {
        return emailValidationSuffix;
    }

    public void setEmailValidationSuffix(String emailValidationSuffix) {
        this.emailValidationSuffix = emailValidationSuffix;
    }

    public String getPasswordDefaultMessage() {
        return passwordDefaultMessage;
    }

    public void setPasswordDefaultMessage(String passwordDefaultMessage) {
        this.passwordDefaultMessage = passwordDefaultMessage;
    }

    public String getSimpleDateFormatNoTimezone() {
        return simpleDateFormatNoTimezone;
    }

    public void setSimpleDateFormatNoTimezone(String simpleDateFormatNoTimezone) {
        this.simpleDateFormatNoTimezone = simpleDateFormatNoTimezone;
    }

    public String getSimpleDateFormat() {
        return simpleDateFormat;
    }

    public void setSimpleDateFormat(String simpleDateFormat) {
        this.simpleDateFormat = simpleDateFormat;
    }

    public int getDateOffset() {
        return dateOffset;
    }

    public void setDateOffset(int dateOffset) {
        this.dateOffset = dateOffset;
    }

    public int getSpecialDaValue() {
        return specialDaValue;
    }

    public void setSpecialDaValue(int specialDaValue) {
        this.specialDaValue = specialDaValue;
    }

    public int getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(int defaultValue) {
        this.defaultValue = defaultValue;
    }

    public int getRegularDaType() {
        return regularDaType;
    }

    public void setRegularDaType(int regularDaType) {
        this.regularDaType = regularDaType;
    }

    public int getSpecialDaType() {
        return specialDaType;
    }

    public void setSpecialDaType(int specialDaType) {
        this.specialDaType = specialDaType;
    }

    public boolean isMenuOffsetFlag() {
        return menuOffsetFlag;
    }

    public void setMenuOffsetFlag(boolean menuOffsetFlag) {
        this.menuOffsetFlag = menuOffsetFlag;
    }

    public int getBundleTypeBuy4OtherEnable() {
        return bundleTypeBuy4OtherEnable;
    }

    public void setBundleTypeBuy4OtherEnable(int bundleTypeBuy4OtherEnable) {
        this.bundleTypeBuy4OtherEnable = bundleTypeBuy4OtherEnable;
    }

    public int[] getBundleTypeBuy4OtherId() {
        return bundleTypeBuy4OtherId;
    }

    public void setBundleTypeBuy4OtherId(int[] bundleTypeBuy4OtherId) {
        this.bundleTypeBuy4OtherId = bundleTypeBuy4OtherId;
    }

    public String getBundleTypeBuy4OtherCdrTagPrefix() {
        return bundleTypeBuy4OtherCdrTagPrefix;
    }

    public void setBundleTypeBuy4OtherCdrTagPrefix(String bundleTypeBuy4OtherCdrTagPrefix) {
        this.bundleTypeBuy4OtherCdrTagPrefix = bundleTypeBuy4OtherCdrTagPrefix;
    }

    public String getBundleTypeBuy4OtherCdrTagSuffix() {
        return bundleTypeBuy4OtherCdrTagSuffix;
    }

    public void setBundleTypeBuy4OtherCdrTagSuffix(String bundleTypeBuy4OtherCdrTagSuffix) {
        this.bundleTypeBuy4OtherCdrTagSuffix = bundleTypeBuy4OtherCdrTagSuffix;
    }

    public String getOrganizationPath() {
        return organizationPath;
    }

    public void setOrganizationPath(String organizationPath) {
        this.organizationPath = organizationPath;
    }

    /**
     * @return the validationTokenExpiryMinutes
     */
    public int getValidationTokenExpiryMinutes() {
        return validationTokenExpiryMinutes;
    }

    /**
     * @param validationTokenExpiryMinutes the validationTokenExpiryMinutes to
     *                                     set
     */
    public void setValidationTokenExpiryMinutes(int validationTokenExpiryMinutes) {
        this.validationTokenExpiryMinutes = validationTokenExpiryMinutes;
    }


    public int getHashingConfigKeysize() {
        return hashingConfigKeysize;
    }

    public String getHashingConfigAlgorithmCbc() {
        return hashingConfigAlgorithmCbc;
    }

    public String getHashingConfigAlgorithm() {
        return hashingConfigAlgorithm;
    }

    public String getHashingConfigEncoding() {
        return hashingConfigEncoding;
    }

    public int getAdminValidationTokenExpiryMinutes() {
        return adminValidationTokenExpiryMinutes;
    }

    public void setAdminValidationTokenExpiryMinutes(int adminValidationTokenExpiryMinutes) {
        this.adminValidationTokenExpiryMinutes = adminValidationTokenExpiryMinutes;
    }

    public String getApplicationPropertyUrl() {
        return applicationPropertyUrl;
    }

    public String getSiteName() {
        return siteName;
    }

    public String getGreeting() {
        return greeting;
    }
    public String getKeyWordLocalhost() {
        return keyWordLocalhost;
    }
}
