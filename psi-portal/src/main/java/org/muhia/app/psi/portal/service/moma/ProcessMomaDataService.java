package org.muhia.app.psi.portal.service.moma;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.AsyncHttpClientConfig;
import org.asynchttpclient.DefaultAsyncHttpClientConfig;
import org.asynchttpclient.RequestBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.muhia.app.psi.config.http.properties.AsyncHttpClientConfigProperties;
import org.muhia.app.psi.config.moma.properties.MomaProperties;
import org.muhia.app.psi.config.security.HashingImplementation;
import org.muhia.app.psi.integ.moma.IMomaService;
import org.muhia.app.psi.orm.model.*;
import org.muhia.app.psi.orm.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.converter.MessageConversionException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.asynchttpclient.Dsl.asyncHttpClient;

/*
  Created by Kenneth Muhia <muhia@muhia.org>
  Project: psi
  Package: org.muhia.app.psi.portal.service.moma.impl
  Generated on: 15-Mar-17, 11:35.
 */
@Service
public class ProcessMomaDataService implements Runnable {

    private final AsyncHttpClientConfigProperties properties;
    private final MomaProperties momaProperties;
    private final ItemisedAirtelMoneyRepository itemisedAirtelMoneyRepository;
    private final MomaRegistryRepository momaRegistryRepository;
    private final GsmItemisedRepository gsmItemisedRepository;
    private final MomAmServiceDetailsRepository amServiceDetailsRepository;
    private final MomGsmServiceSummaryRepository gsmServiceSummaryRepository;
    private final MomTransactionSummaryRepository transactionSummaryRepository;
    private final IMomaService momaService;
    private final HashingImplementation hasher;
//    private AsyncHttpClient asyncHttpClient;

    @Autowired
    public ProcessMomaDataService(AsyncHttpClientConfigProperties properties, MomaProperties momaProperties, ItemisedAirtelMoneyRepository itemisedAirtelMoneyRepository, MomaRegistryRepository momaRegistryRepository, GsmItemisedRepository gsmItemisedRepository, MomAmServiceDetailsRepository amServiceDetailsRepository, MomGsmServiceSummaryRepository gsmServiceSummaryRepository, MomTransactionSummaryRepository transactionSummaryRepository, IMomaService momaService, HashingImplementation hasher) {
        this.properties = properties;

        this.momaProperties = momaProperties;
        this.itemisedAirtelMoneyRepository = itemisedAirtelMoneyRepository;
        this.momaRegistryRepository = momaRegistryRepository;
        this.gsmItemisedRepository = gsmItemisedRepository;
        this.amServiceDetailsRepository = amServiceDetailsRepository;
        this.gsmServiceSummaryRepository = gsmServiceSummaryRepository;
        this.transactionSummaryRepository = transactionSummaryRepository;
        this.momaService = momaService;
        this.hasher = hasher;
    }

//    private void processItemisedAirtelMoneyDataRequest() {
//        try {
//            AsyncHttpClientConfig cf = new DefaultAsyncHttpClientConfig.Builder()
//                    .setCompressionEnforced(properties.isAsynchttpclientCompressionEnforced())
//                    .setPooledConnectionIdleTimeout(properties.getAsynchttpclientPooledConnectionIdleTimeout())
//                    .setRequestTimeout(properties.getAsynchttpclientRequestTimeout())
//                    .setMaxConnectionsPerHost(properties.getAsynchttpclientMaxConnectionsPerHost())
//                    .setRequestTimeout(properties.getAsynchttpclientRequestTimeout())
////                    .setSslContext((SslContext) sslContextFactory.createSslContext().getClientSessionContext())
//                    .build();
//
//
//            ObjectMapper mapper = new ObjectMapper();
//            String url = momaProperties.getMomaGatewayUrl();
//            String replaceUrl = momaService.urlSubstitution(url, momaProperties, momaProperties.getMomaGatewayAmDataRetrievalPrefix(), momaProperties.getMomaGatewayAmDataRetrievalMethod());
//
//
//            try (AsyncHttpClient asyncHttpClient = asyncHttpClient(cf)) {
//
//                SimpleDateFormat toDateSdf = new SimpleDateFormat(momaProperties.getMomaToDateSdf());
//                SimpleDateFormat fromDateSdf = new SimpleDateFormat(momaProperties.getMomaFromDateSdf());
//                RequestBuilder requestBuilder = new RequestBuilder("POST");
//                requestBuilder
//                        .setUrl(replaceUrl)
//                        .addFormParam(momaProperties.getMomaKeywordUserid(), hasher.getDecryptedValue(momaProperties.getMomaGatewayUsername()))
//                        .addFormParam(momaProperties.getMomaKeywordPasswd(), hasher.getDecryptedValue(momaProperties.getMomaGatewayPassword()))
//                        .addFormParam(momaProperties.getMomaKeywordFromDate(), fromDateSdf.format(new Date()))
//                        .addFormParam(momaProperties.getMomaKeywordToDate(), toDateSdf.format(new Date()))
//                        .addFormParam(momaProperties.getMomaGatewayStartEntryNumKeyword(), momaProperties.getMomaGatewayStartEntryNum())
//                        .addFormParam(momaProperties.getMomaGatewayEndEntryNumKeyword(), momaProperties.getMomaGatewayEndEntryNum())
//                        .addHeader("Content-Type", "application/x-www-form-urlencoded")
////                        .addHeader("Transfer-Encoding"," chunked")
//                        .build();
//
//                AtomicInteger counter = new AtomicInteger(0);
//                asyncHttpClient
//                        .executeRequest(requestBuilder)
//                        .toCompletableFuture()
//                        .thenApply(response -> {
//                            try {
//                                if (response.getStatusCode() != properties.getAsynchttpclientResponseStatusSuccess()) {
//                                    Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("Received [HttpStatus = %d, URL = %s] processing halted!", response.getStatusCode(), replaceUrl));
//                                } else {
////                                List<MomItemisedAirtelMoney> itemisedAirtelMonies = response.getResponseBody()
//                                    JSONArray ja = new JSONArray(response.getResponseBody());
//                                    for (int i = 0; i < ja.length(); i++) {
//                                        JSONObject jo = ja.getJSONObject(i);
//
//                                        MomItemisedAirtelMoney momaData = mapper.readValue(jo.toString(), MomItemisedAirtelMoney.class);
//
//
//                                        momaData = itemisedAirtelMoneyRepository.save(momaData);
//                                        counter.incrementAndGet();
//                                        Logger.getLogger(this.getClass().getName()).log(Level.FINE, momaData.toString());
//
//
////                                    return response;
//
//                                    }
//                                    Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("Received [HttpStatus = %d, URL = %s] processed %d records!", response.getStatusCode(), replaceUrl, counter.get()));
//                                }
//                            } catch (JSONException | IOException e) {
//                                String pattern = "(?i)(username=)(.+?)(&)";
//
//                                String hashedUrl = replaceUrl.replaceFirst(pattern, "********");
//                                pattern = "(?i)(password=)(.+?)";
//                                hashedUrl = hashedUrl.replaceFirst(pattern, "********");
////                                return null;
////                                Logger.getLogger(this.getClass().getName()).log(Level.INFO, e.getMessage(), e);
//                                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, String.format("JSON Processing failed, [Message= %s, URL= %s]", e.getMessage(), hashedUrl));
//                            }
//                            return response;
//
//                        })
//                        .thenAccept(u -> Logger.getLogger(this.getClass().getName()).log(Level.FINE, u.toString()))
//                        .join();
//
//
//            } catch (IOException e) {
//                Logger.getLogger(this.getClass().getName()).log(Level.INFO, e.getMessage(), e);
//            }
//        } catch (Exception e) {
//            Logger.getLogger(this.getClass().getName()).log(Level.INFO, e.getMessage(), e);
//        }
//    }

    private void extecuteMomaRequest(AsyncHttpClientConfigProperties asyncHttpClientConfigProperties, MomaProperties momaproperties, String prefix, String method, String httpMethod, String dataClass) {
        try {
            AsyncHttpClientConfig cf = new DefaultAsyncHttpClientConfig.Builder()
                    .setCompressionEnforced(asyncHttpClientConfigProperties.isAsynchttpclientCompressionEnforced())
                    .setPooledConnectionIdleTimeout(asyncHttpClientConfigProperties.getAsynchttpclientPooledConnectionIdleTimeout())
                    .setRequestTimeout(asyncHttpClientConfigProperties.getAsynchttpclientRequestTimeout())
                    .setMaxConnectionsPerHost(asyncHttpClientConfigProperties.getAsynchttpclientMaxConnectionsPerHost())
                    .setRequestTimeout(asyncHttpClientConfigProperties.getAsynchttpclientRequestTimeout())
//                    .setSslContext((SslContext) sslContextFactory.createSslContext().getClientSessionContext())
                    .build();


            ObjectMapper mapper = new ObjectMapper();
            String url = momaproperties.getMomaGatewayUrl();
            String replaceUrl = momaService.urlSubstitution(url, momaproperties, prefix, method);


            try (AsyncHttpClient client = asyncHttpClient(cf)) {

                SimpleDateFormat toDateSdf = new SimpleDateFormat(momaproperties.getMomaToDateSdf());
                SimpleDateFormat fromDateSdf = new SimpleDateFormat(momaproperties.getMomaFromDateSdf());
                RequestBuilder builder = new RequestBuilder(httpMethod);
                LocalTime start = LocalTime.now();
                builder
                        .setUrl(replaceUrl)
                        .addFormParam(momaproperties.getMomaKeywordUserid(), hasher.getDecryptedValue(momaproperties.getMomaGatewayUsername()))
                        .addFormParam(momaproperties.getMomaKeywordPasswd(), hasher.getDecryptedValue(momaproperties.getMomaGatewayPassword()))
                        .addFormParam(momaproperties.getMomaKeywordFromDate(), fromDateSdf.format(new Date()))
                        .addFormParam(momaproperties.getMomaKeywordToDate(), toDateSdf.format(new Date()))
                        .addFormParam(momaproperties.getMomaGatewayStartEntryNumKeyword(), momaproperties.getMomaGatewayStartEntryNum())
                        .addFormParam(momaproperties.getMomaGatewayEndEntryNumKeyword(), momaproperties.getMomaGatewayEndEntryNum())
                        .addHeader("Content-Type", "application/x-www-form-urlencoded")
//                        .addHeader("Transfer-Encoding"," chunked")
                        .build();

                AtomicInteger counter = new AtomicInteger(0);
                client
                        .executeRequest(builder)
                        .toCompletableFuture()
                        .thenApply(momaResponse -> {
                            try {
                                if (momaResponse.getStatusCode() != asyncHttpClientConfigProperties.getAsynchttpclientResponseStatusSuccess()) {
                                    Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("Received [HttpStatus = %d, Text = %s, URL = %s] processing halted!", momaResponse.getStatusCode(), momaResponse.getStatusText(), replaceUrl));
                                } else {
                                    JSONArray ja = new JSONArray(momaResponse.getResponseBody());
                                    for (int i = 0; i < ja.length(); i++) {
                                        JSONObject jo = new JSONObject();
                                        try {
                                            jo = ja.getJSONObject(i);

                                            switch (dataClass) {
                                                case "MomItemisedAirtelMoney":

                                                    MomItemisedAirtelMoney momaData = mapper.readValue(jo.toString(), MomItemisedAirtelMoney.class);
                                                    momaData = itemisedAirtelMoneyRepository.save(momaData);

                                                    Logger.getLogger(this.getClass().getName()).log(Level.FINE, momaData.toString());
                                                    break;

                                                case "MomRegistry":
                                                    MomRegistry momRegistry = mapper.readValue(jo.toString(), MomRegistry.class);
                                                    momRegistry = momaRegistryRepository.save(momRegistry);
                                                    Logger.getLogger(this.getClass().getName()).log(Level.FINE, momRegistry.toString());
                                                    break;
                                                case "MomGsmItemised":
                                                    MomGsmItemised momGsmItemised = mapper.readValue(jo.toString(), MomGsmItemised.class);
                                                    momGsmItemised = gsmItemisedRepository.save(momGsmItemised);
                                                    Logger.getLogger(this.getClass().getName()).log(Level.FINE, momGsmItemised.toString());
                                                    break;
                                                case "MomAmServiceDetails":
                                                    MomAmServiceDetails amServiceDetails = mapper.readValue(jo.toString(), MomAmServiceDetails.class);
                                                    amServiceDetails = amServiceDetailsRepository.save(amServiceDetails);
                                                    Logger.getLogger(this.getClass().getName()).log(Level.FINE, amServiceDetails.toString());
                                                    break;
                                                case "MomGsmServiceSummary":
                                                    MomGsmServiceSummary gsmServiceSummary = mapper.readValue(jo.toString(), MomGsmServiceSummary.class);
                                                    gsmServiceSummary = gsmServiceSummaryRepository.save(gsmServiceSummary);
                                                    Logger.getLogger(this.getClass().getName()).log(Level.FINE, gsmServiceSummary.toString());
                                                    break;
                                                case "MomTransactionSummary":
                                                    MomTransactionSummary transactionSummary = mapper.readValue(jo.toString(), MomTransactionSummary.class);
                                                    transactionSummary = transactionSummaryRepository.save(transactionSummary);
                                                    Logger.getLogger(this.getClass().getName()).log(Level.FINE, transactionSummary.toString());
                                                    break;
                                                default:
                                                    Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("Invalid Method %s invoked, configuration required!", dataClass));
                                                    break;

                                            }

                                            counter.incrementAndGet();
                                        } catch (MessageConversionException | JSONException e) {
                                            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), String.format("Record Processing failed for %s", jo.toString()));
                                        }

                                    }
                                    Duration timeTaken = Duration.between(start, LocalTime.now());
                                    Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("Received [HttpStatus = %d, Text = %s, URL = %s] processed %d records in %d seconds!", momaResponse.getStatusCode(), momaResponse.getStatusText(), replaceUrl, counter.get(), timeTaken.getSeconds()));
                                }
                            } catch (IOException | JSONException e) {
                                String pattern = "(?i)(username=)(.+?)(&)";

                                String hashedUrl = replaceUrl.replaceFirst(pattern, "********");
                                pattern = "(?i)(password=)(.+?)";
                                hashedUrl = hashedUrl.replaceFirst(pattern, "********");
//                                return null;
//                                Logger.getLogger(this.getClass().getName()).log(Level.INFO, e.getMessage(), e);
                                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, String.format("JSON Processing failed, [Message= %s, URL= %s]", e.getMessage(), hashedUrl));
                            }
                            return momaResponse;

                        })
                        .thenAccept(u -> Logger.getLogger(this.getClass().getName()).log(Level.FINE, u.toString()))
                        .join();


            } catch (IOException e) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, String.format("Connection failed, [Message= %s, URL= %s]", e.getMessage(), replaceUrl));
            }
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, e.getMessage(), e);
        }
    }

    @Override
    public void run() {
//        processItemisedAirtelMoneyDataRequest();
        extecuteMomaRequest(properties, momaProperties, momaProperties.getMomaGatewayAmDataRetrievalPrefix(), momaProperties.getMomaGatewayAmDataRetrievalMethod(), "POST", "MomItemisedAirtelMoney");
        extecuteMomaRequest(properties, momaProperties, momaProperties.getMomaGatewayAmDataRetrievalPrefix(), momaProperties.getMomaGsmByAirtelMoneyByProductRetrievalMethod(), "POST", "MomAmServiceDetails");
        extecuteMomaRequest(properties, momaProperties, momaProperties.getMomaGatewayGsmdataRetrievalPrefix(), momaProperties.getMomaGatewayGsmdataRetrievalMethod(), "POST", "MomGsmItemised");
        extecuteMomaRequest(properties, momaProperties, momaProperties.getMomaGatewayGsmdataRetrievalPrefix(), momaProperties.getMomaGatewayGsmServiceDataRetrievalMethod(), "POST", "MomGsmServiceSummary");
        extecuteMomaRequest(properties, momaProperties, momaProperties.getMomaGatewayGsmdataRetrievalPrefix(), momaProperties.getMomaGatewayTxnSummarydataRetrievalMethod(), "POST", "MomTransactionSummary");


    }
}
