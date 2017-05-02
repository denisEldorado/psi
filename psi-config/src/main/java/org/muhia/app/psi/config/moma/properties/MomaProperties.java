package org.muhia.app.psi.config.moma.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/*
  Created by mathenge
  Project: psi
  Package: ${PACKAGE_NAME}
  Generated on: 2/1/17, 19:46.
 */
@PropertySource(value = "file:${CONFIG_PATH}/moma.properties")
@Configuration
public class MomaProperties {
    @Value("${org.muhia.psi.config.integ.moma.from.date.sdf}")
    private String momaFromDateSdf;
    @Value("${org.muhia.psi.config.integ.moma.to.date.sdf}")
    private String momaToDateSdf;
    @Value("${org.muhia.psi.config.integ.moma.gateway.ip}")
    private String momaGatewayIp;
    @Value("${org.muhia.psi.config.integ.moma.gateway.port}")
    private String momaGatewayPort;
    @Value("${org.muhia.psi.config.integ.moma.gateway.username}")
    private String momaGatewayUsername;
    @Value("${org.muhia.psi.config.integ.moma.gateway.password}")
    private String momaGatewayPassword;
    @Value("${org.muhia.psi.config.integ.moma.gateway.gsmdataretrievalprefix}")
    private String momaGatewayGsmdataRetrievalPrefix;
    @Value("${org.muhia.psi.config.integ.moma.gateway.gsmdataretrievalmethod}")
    private String momaGatewayGsmdataRetrievalMethod;
    @Value("${org.muhia.psi.config.integ.moma.gateway.txnsummarydataretrievalmethod}")
    private String momaGatewayTxnSummarydataRetrievalMethod;
    @Value("${org.muhia.psi.config.integ.moma.gateway.amdataretrievalprefix}")
    private String momaGatewayAmDataRetrievalPrefix;
    @Value("${org.muhia.psi.config.integ.moma.gateway.amdataretrievalmethod}")
    private String momaGatewayAmDataRetrievalMethod;
    @Value("${org.muhia.psi.config.integ.moma.gateway.gsmservicedataretrievalmethod}")
    private String momaGatewayGsmServiceDataRetrievalMethod;
    @Value("${org.muhia.psi.config.integ.moma.am.byproduct.dataretrievalmethod}")
    private String momaAmByproductDataRetrievalMethod;
    @Value("${org.muhia.psi.config.integ.moma.gateway.fromdate}")
    private String momaGatewayFromDate;
    @Value("${org.muhia.psi.config.integ.moma.gateway.todate}")
    private String momaGatewayToDate;
    @Value("${org.muhia.psi.config.integ.moma.gateway.start.entrynum}")
    private String momaGatewayStartEntryNum;
    @Value("${org.muhia.psi.config.integ.moma.gateway.end.entrynum}")
    private String momaGatewayEndEntryNum;
    @Value("${org.muhia.psi.config.integ.moma.gateway.url}")
    private String momaGatewayUrl;
    @Value("${org.muhia.psi.config.integ.moma.gateway.default.encoding}")
    private String momaGatewayDefaultEncoding;
    @Value("${org.muhia.psi.config.integ.moma.gateway.url.keywords}")
    private String[] momaGatewayUrlKeywords;
    @Value("${org.muhia.psi.config.integ.moma.keyword.ip}")
    private String momaKeywordIp;
    @Value("${org.muhia.psi.config.integ.moma.keyword.port}")
    private String momaKeywordPort;
    @Value("${org.muhia.psi.config.integ.moma.keyword.userid}")
    private String momaKeywordUserid;
    @Value("${org.muhia.psi.config.integ.moma.keyword.passwd}")
    private String momaKeywordPasswd;
    @Value("${org.muhia.psi.config.integ.moma.keyword.retrievalprefix}")
    private String momaKeywordRetrievalPrefix;
    @Value("${org.muhia.psi.config.integ.moma.keyword.retrievalmethod}")
    private String momaKeywordRetrievalMethod;
    @Value("${org.muhia.psi.config.integ.moma.keyword.fromdate}")
    private String momaKeywordFromDate;
    @Value("${org.muhia.psi.config.integ.moma.keyword.todate}")
    private String momaKeywordToDate;
    @Value("${org.muhia.psi.config.integ.moma.gateway.start.entrynum.keyword}")
    private String momaGatewayStartEntryNumKeyword;
    @Value("${org.muhia.psi.config.integ.moma.gateway.end.entrynum.keyword}")
    private String momaGatewayEndEntryNumKeyword;
    @Value("${org.muhia.psi.config.integ.moma.gateway.txnsubmitresultsretrievalmethod}")
    private String momaGatewayTxnSubmitResultsRetrievalMethod;
    @Value("${org.muhia.psi.config.integ.moma.gsm.by.airtelmoneybyproductretrievalmethod}") private  String momaGsmByAirtelMoneyByProductRetrievalMethod;



    public String getMomaKeywordIp() {
        return momaKeywordIp;
    }


    public String getMomaFromDateSdf() {
        return momaFromDateSdf;
    }

    public String getMomaToDateSdf() {
        return momaToDateSdf;
    }

    public String getMomaGatewayIp() {
        return momaGatewayIp;
    }

    public String getMomaGatewayPort() {
        return momaGatewayPort;
    }

    public String getMomaGatewayUsername() {
        return momaGatewayUsername;
    }

    public String getMomaGatewayPassword() {
        return momaGatewayPassword;
    }

    public String getMomaGatewayGsmdataRetrievalPrefix() {
        return momaGatewayGsmdataRetrievalPrefix;
    }

    public String getMomaGatewayGsmdataRetrievalMethod() {
        return momaGatewayGsmdataRetrievalMethod;
    }

    public String getMomaGatewayTxnSummarydataRetrievalMethod() {
        return momaGatewayTxnSummarydataRetrievalMethod;
    }

    public String getMomaGatewayAmDataRetrievalPrefix() {
        return momaGatewayAmDataRetrievalPrefix;
    }

    public String getMomaGatewayAmDataRetrievalMethod() {
        return momaGatewayAmDataRetrievalMethod;
    }

    public String getMomaGatewayGsmServiceDataRetrievalMethod() {
        return momaGatewayGsmServiceDataRetrievalMethod;
    }

    public String getMomaAmByproductDataRetrievalMethod() {
        return momaAmByproductDataRetrievalMethod;
    }

    public String getMomaGatewayFromDate() {
        return momaGatewayFromDate;
    }

    public String getMomaGatewayToDate() {
        return momaGatewayToDate;
    }

    public String getMomaGatewayStartEntryNum() {
        return momaGatewayStartEntryNum;
    }

    public String getMomaGatewayEndEntryNum() {
        return momaGatewayEndEntryNum;
    }

    public String getMomaGatewayUrl() {
        return momaGatewayUrl;
    }

    public String getMomaGatewayDefaultEncoding() {
        return momaGatewayDefaultEncoding;
    }

    public String[] getMomaGatewayUrlKeywords() {
        return momaGatewayUrlKeywords;
    }

    public String getMomaKeywordPort() {
        return momaKeywordPort;
    }

    public String getMomaKeywordUserid() {
        return momaKeywordUserid;
    }

    public String getMomaKeywordPasswd() {
        return momaKeywordPasswd;
    }

    public String getMomaKeywordRetrievalPrefix() {
        return momaKeywordRetrievalPrefix;
    }

    public String getMomaKeywordRetrievalMethod() {
        return momaKeywordRetrievalMethod;
    }

    public String getMomaKeywordFromDate() {
        return momaKeywordFromDate;
    }

    public String getMomaKeywordToDate() {
        return momaKeywordToDate;
    }

    public String getMomaGatewayStartEntryNumKeyword() {
        return momaGatewayStartEntryNumKeyword;
    }

    public String getMomaGatewayEndEntryNumKeyword() {
        return momaGatewayEndEntryNumKeyword;
    }

    public String getMomaGatewayTxnSubmitResultsRetrievalMethod() {
        return momaGatewayTxnSubmitResultsRetrievalMethod;
    }

    public String getMomaGsmByAirtelMoneyByProductRetrievalMethod() {
        return momaGsmByAirtelMoneyByProductRetrievalMethod;
    }
}
