/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.muhia.app.psi.portal.service.sms.impl;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.muhia.app.psi.config.CustomUtilities;
import org.muhia.app.psi.config.http.CustomHttpClientUtilities;
import org.muhia.app.psi.config.integ.ke.africastalkingproperties.AfricasTalkingProperties;
import org.muhia.app.psi.config.org.properties.OrganizationProperties;
import org.muhia.app.psi.config.security.HashingImplementation;
import org.muhia.app.psi.config.sms.properties.SmsKannelConnectorProperties;
import org.muhia.app.psi.integ.sms.africastalking.AfricasTalkingGateway;
import org.muhia.app.psi.orm.model.ServiceRequests;
import org.muhia.app.psi.orm.model.SmsRegistry;
import org.muhia.app.psi.orm.model.SmsResponses;
import org.muhia.app.psi.orm.model.UssdCodes;
import org.muhia.app.psi.orm.repo.SmsRegistryRepository;
import org.muhia.app.psi.orm.repo.SmsResponsesRepository;
import org.muhia.app.psi.orm.repo.UssdCodesRepository;

import org.muhia.app.psi.portal.service.sms.ISmsBrokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 *         <p>
 *         Class Service implementation of Sms sending
 *         <p>
 *         Creates the properties of the SMS body
 */
@Service
public class SmsBrokerService implements ISmsBrokerService {

    private final SmsKannelConnectorProperties sp;
    private final SmsRegistryRepository smsRegistryRepository;
    private final HashingImplementation encryptdecrypt;
    private final OrganizationProperties op;
    private final AfricasTalkingGateway africasTalkingGateway;
    private final AfricasTalkingProperties africasTalkingProperties;
    //    @Autowired
//    private SmsResponseBuilder smsResponseBuilder;
    private final CustomUtilities utilities;

    private final CustomHttpClientUtilities httpClient;

    private final UssdCodesRepository ussdCodesRepository;

    private final SmsResponsesRepository smsResponsesRepository;

    @Autowired
    public SmsBrokerService(SmsKannelConnectorProperties sp, SmsRegistryRepository smsRegistryRepository, HashingImplementation encryptdecrypt, OrganizationProperties op, AfricasTalkingGateway africasTalkingGateway, AfricasTalkingProperties africasTalkingProperties, CustomUtilities utilities, CustomHttpClientUtilities httpClient, UssdCodesRepository ussdCodesRepository, SmsResponsesRepository smsResponsesRepository) {
        this.sp = sp;
        this.smsRegistryRepository = smsRegistryRepository;
        this.encryptdecrypt = encryptdecrypt;
        this.op = op;
        this.africasTalkingGateway = africasTalkingGateway;
        this.africasTalkingProperties = africasTalkingProperties;
        this.utilities = utilities;
        this.httpClient = httpClient;
        this.ussdCodesRepository = ussdCodesRepository;
        this.smsResponsesRepository = smsResponsesRepository;
    }


    @Override
    public Optional<UssdCodes> fetchUssdCodesByUssdCode(String ussdCode) {
        return ussdCodesRepository.findUssdCodesByUssdCode(ussdCode);
    }

    @Override
    public Optional<SmsResponses> fetchSmsResponsesBySmsCode(UssdCodes smsCode) {
        return smsResponsesRepository.findSmsResponsesBySmsCode(smsCode);
    }

    @Override
    public SmsRegistry registerIncomingSms(SmsRegistry smsRegistry) {
        return smsRegistryRepository.save(smsRegistry);
    }

    @Override
    public String sendSmsMessage(SmsRegistry smsRegistry) {
        String result = "";
//        String user = "";
//        String credentials = "";
        String urlStr;
        String replaceUrl;
        String hashedUrl = "";
//        HashMap senderMap = new HashMap<>();

        try {
//            user = encryptdecrypt.getDecryptedValue(sp.getUser());
//            credentials = encryptdecrypt.getDecryptedValue(sp.getCredentials());
            urlStr = sp.getKannelUrl();

            replaceUrl = urlSubstitutions(urlStr, sp, smsRegistry);

            /*
              We need to Hash the url for logging
              http://ip:port/cgi-bin/sendsms?username=user&password=passwd&to=destination&from=sender&text=message;
             */
            String pattern = "(?i)(username=)(.+?)(&)";

            hashedUrl = replaceUrl.replaceFirst(pattern, "********");
            pattern = "(?i)(password=)(.+?)(&)";
            hashedUrl = hashedUrl.replaceFirst(pattern, "********");

            result = httpClient.doGetWithResponseHandler(replaceUrl);
            Logger.getLogger(SmsBrokerService.class.getName()).log(Level.INFO, "Url {0} returned response: {1}", new Object[]{hashedUrl, result});
        } catch (Exception ex) {
            Logger.getLogger(SmsBrokerService.class.getName()).log(Level.INFO, "Url {0} returned response: {1}", new Object[]{hashedUrl, ex.getMessage()});
            Logger.getLogger(SmsBrokerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    private String urlSubstitutions(String url, SmsKannelConnectorProperties sp, SmsRegistry smsRegistry) {
        String replaceUrl = "";
        String user = encryptdecrypt.getDecryptedValue(sp.getUser());
        String credentials = encryptdecrypt.getDecryptedValue(sp.getCredentials());
        for (String kannelUrlKeyword : sp.getKannelUrlKeywords()) {
            /*
              ip,port,user,passwd,destination,sender,message
             */
            
            /*
            DONE: Encode each item to ensure URL is valid
            TODO: Externalise
            */
            try {
                switch (kannelUrlKeyword) {
                    case "ip":
                        replaceUrl = url.replace(kannelUrlKeyword, URLEncoder.encode(sp.getIp(), sp.getDefaultEncoding()));

                        break;
                    case "port":
                        replaceUrl = url.replace(kannelUrlKeyword, URLEncoder.encode(sp.getPort(), sp.getDefaultEncoding()));
                        break;
                    case "userid":
                        replaceUrl = url.replace(kannelUrlKeyword, URLEncoder.encode(user, sp.getDefaultEncoding()));
                        break;
                    case "passwd":
                        replaceUrl = url.replace(kannelUrlKeyword, URLEncoder.encode(credentials, sp.getDefaultEncoding()));
                        break;
                    case "destination":
                        replaceUrl = url.replace(kannelUrlKeyword, URLEncoder.encode(smsRegistry.getSubno(), sp.getDefaultEncoding()));
                        break;
                    case "sender":
                        if (op.isComplexSmsSender()) {
                        /*
                          OPCO Has multiple senders based on IMSI series
                         */
                            if (smsRegistry.getSubImsi() == null) {
                            /*
                              Use the default sender
                             */
                                replaceUrl = url.replace(kannelUrlKeyword, URLEncoder.encode(sp.getSender(), sp.getDefaultEncoding()));
                            } else {
                                HashMap<String, String> senderMap = utilities.arraysToHashMap(op.getMvnoImsiSeries(), op.getMvnoImsiSmsSender());
                                for (String prefix : op.getMvnoImsiSeries()) {
                                    if (smsRegistry.getSubImsi().startsWith(prefix)) {
                                        replaceUrl = url.replace(kannelUrlKeyword, URLEncoder.encode(senderMap.get(prefix), sp.getDefaultEncoding()));
                                        break;
                                    }
                                }

                            }
                        } else {
                        /*
                          Use the default sender
                         */
                            replaceUrl = url.replace(kannelUrlKeyword, URLEncoder.encode(sp.getSender(), sp.getDefaultEncoding()));
                        }

                        break;
                    case "message":
                        replaceUrl = url.replace(kannelUrlKeyword, URLEncoder.encode(smsRegistry.getMessageText(), sp.getDefaultEncoding()));
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid parameter for kannel keywords: " + kannelUrlKeyword);

                }
            } catch (UnsupportedEncodingException | IllegalArgumentException e) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
            url = replaceUrl;
        }

        return url;

    }


    @Override
    public SmsRegistry registerSmsForSending(String msg, String subno, String code, String direction, Date smsTime, int smsStatus, ServiceRequests orderMaster) {
        SimpleDateFormat sdf = new SimpleDateFormat(sp.getLogStandardDateFormat());
        SmsRegistry sr = new SmsRegistry();

        try {
            sr.setSubno(subno);
            sr.setDirection(direction);
            sr.setMessageText(msg);
            sr.setReceivedDate(smsTime);
            sr.setShortCode(code);
            sr.setDeliveryStatus((long) smsStatus);
            sr.setServiceRequest(orderMaster);
            sr.setRetryAttempts((long) sp.getMaxRetry());
            sr.setCreationDate(new Date());
//            sr.setOrderTransaction(orderMaster);
            sr.setDeliveryStatus((long) sp.getSmsOutInitStatus());

            smsRegistryRepository.save(sr);

        } catch (Exception ex) {
            Logger.getLogger(SmsBrokerService.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Logger.getLogger(SmsBrokerService.class.getName()).log(Level.INFO, "SMS_OUT: {0}, {1}, {2}, {3}, {4}, {5} status:{6}", new Object[]{sr.getId() != null ? sr.getId() : sp.getDefaultSmsOutNotification(), sdf.format(smsTime), "", subno, code, msg, sp.getSmsOutInitStatus()});
        } catch (Exception ex) {
            Logger.getLogger(SmsBrokerService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sr;
    }

    @Override
    public SmsRegistry logOutgoingSmsAfterSendAttempt(String msg, Date smsTime, int smsStatus, String gwstatus, SmsRegistry smsRegistry) {

        SimpleDateFormat sdf = new SimpleDateFormat(sp.getLogStandardDateFormat());

        try {
            smsRegistry.setKannelResponse(gwstatus);
            smsRegistry.setDeliveryStatus((long) smsStatus);
            smsRegistry.setResponseMessage(msg);
            smsRegistry.setSentDate(smsTime);
            smsRegistry.setRetried(smsRegistry.getRetried() + 1);


            smsRegistryRepository.save(smsRegistry);
        } catch (Exception ex) {
            Logger.getLogger(SmsBrokerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Logger.getLogger(SmsBrokerService.class.getName()).log(Level.INFO, "SMS_OUT: {0}, {1}, {2}, {3}, {4}, {5} status:{6}", new Object[]{smsRegistry.getId(), sdf.format(smsRegistry.getCreationDate()), sdf.format(smsTime), smsRegistry.getSubno(), smsRegistry.getSender(), msg, gwstatus});
        } catch (Exception ex) {
            Logger.getLogger(SmsBrokerService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return smsRegistry;
    }

    @Override
    public List<SmsRegistry> logOutgoingSmsAfterSendAttempt(List<SmsRegistry> smsRegistries) {

        return smsRegistryRepository.save(smsRegistries);

    }

    @Override
    public SmsRegistry logOutgoingSmsAfterSendAttempt(SmsRegistry smsRegistries) {
        return smsRegistryRepository.save(smsRegistries);
    }

    @Override
    public List<SmsRegistry> findSmsRegistryByDirectionAndDeliveryStatusAndRetried(String direction, long deliveryStatus) {
        return smsRegistryRepository.findSmsRegistryByDirectionAndDeliveryStatusAndRetry(direction, deliveryStatus).orElse(null);
    }

    @Override
    public SmsRegistry registerSmsForSending(String msg, String subno, String code, String direction, Date smsTime, int smsStatus) {
        SimpleDateFormat sdf = new SimpleDateFormat(sp.getLogStandardDateFormat());
        SmsRegistry sr = new SmsRegistry();

        try {
            sr.setSubno(subno);
            sr.setDirection(direction);
            sr.setMessageText(msg);
            sr.setReceivedDate(smsTime);
            sr.setShortCode(code);
            sr.setDeliveryStatus((long) smsStatus);
//            sr.setServiceRequest(orderMaster);
//            sr.setOrderTransaction(orderMaster);
            sr.setDeliveryStatus((long) sp.getSmsOutInitStatus());
            sr.setRetryAttempts((long) sp.getMaxRetry());

            smsRegistryRepository.save(sr);

        } catch (Exception ex) {
            Logger.getLogger(SmsBrokerService.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Logger.getLogger(SmsBrokerService.class.getName()).log(Level.INFO, "SMS_OUT: {0}, {1}, {2}, {3}, {4}, {5} status:{6}", new Object[]{sr.getId() != null ? sr.getId() : sp.getDefaultSmsOutNotification(), sdf.format(smsTime), "", subno, code, msg, sp.getSmsOutInitStatus()});
        } catch (Exception ex) {
            Logger.getLogger(SmsBrokerService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sr;
    }

//    public SmsResponseBuilder getSmsResponseBuilder() {
//        try {
//            if (smsResponseBuilder == null) {
//                Logger.getLogger(SmsBrokerService.class.getName()).log(Level.FINE, "Config File path: {0}", sp.getResponseFile());
//                Resource resource = new FileSystemResource(sp.getResponseFile());
//                smsResponseBuilder = new SmsResponseBuilder(resource.getInputStream());
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(SmsBrokerService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return smsResponseBuilder;
//    }

    @Override
    public String sendBulkSmsFromCsv(MultipartFile file, Boolean single, String message) {
        //to read Csv file, save it with random name,get data and use custom utililies to do get
        String result;
        String url;
        StringBuilder csvUrl = new StringBuilder();
        if (single) {
            url = sp.getSingleSmsBulkUrl();
            try {
                csvUrl = new StringBuilder("&message=" + URLEncoder.encode(message, sp.getBulkEncoding()) + "&msisdn=");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            url = sp.getBulkUrl();
        }
        String user = encryptdecrypt.getDecryptedValue(sp.getBulkUser());
        String pass = encryptdecrypt.getDecryptedValue(sp.getBulkPassword());
        String send = sp.getBulkSender();
        url = url.replace("usr", user);
        url = url.replace("passwd", pass);
        url = url.replace("snd", send);

        try {

            CsvMapper mapper = new CsvMapper();
            CsvSchema schema = CsvSchema.emptySchema().withHeader(); // use first row as header; otherwise defaults are fine
            MappingIterator<Map<String, String>> it = mapper.readerFor(Map.class)
                    .with(schema)
                    .readValues(new InputStreamReader(file.getInputStream()));
            while (it.hasNext()) {
                Map<String, String> rowAsMap = it.next();
                // access by column name, as defined in the header row...

                if (single) {
                    //form url
                    csvUrl.append(URLEncoder.encode(rowAsMap.get("msisdn") + ",", sp.getBulkEncoding()));
                } else {
                    csvUrl.append("%0a").append(URLEncoder.encode("\"" + rowAsMap.get("msisdn") + "\",\"" + rowAsMap.get("message") + "\"", sp.getBulkEncoding()));
                }
            }
//            url=URLEncoder.encode(url,sp.getDefaultEncoding());
            url += csvUrl;
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, MessageFormat.format("Encoded output {0} ", url));
            result = httpClient.doSimpleGet(url);
            Logger.getLogger(SmsBrokerService.class.getName()).log(Level.INFO, "Url {0} returned response: {1}", new Object[]{url, result});
        } catch (IOException | IllegalStateException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }

        return "String";
    }

    @Override
    public String sendBulkSmsFromCsvAfrica(MultipartFile file, Boolean single, String message) {
        String sender = africasTalkingProperties.getIntegSender();
        StringBuilder recipients = new StringBuilder();
        try {

            CsvMapper mapper = new CsvMapper();
            CsvSchema schema = CsvSchema.emptySchema().withHeader(); // use first row as header; otherwise defaults are fine
            MappingIterator<Map<String, String>> it = mapper.readerFor(Map.class)
                    .with(schema)
                    .readValues(new InputStreamReader(file.getInputStream()));
            while (it.hasNext()) {
                Map<String, String> rowAsMap = it.next();
                // access by column name, as defined in the header row...
                if (single) {
                    //form url
                    if (it.hasNext()) {
                        String number = rowAsMap.get("msisdn");
                        String numb;
                        numb = number.startsWith("0") ? "+254" + number.substring(1) : rowAsMap.get("msisdn");
                        recipients.append(numb).append(",");
                    } else {
                        String number = rowAsMap.get("msisdn");
                        String numb;
                        if (number.startsWith("0")) {
                            numb = "+254" + number.substring(1);
                        } else {
                            numb = rowAsMap.get("msisdn");
                        }
                        recipients.append(numb);
                    }
                } else {

                }
            }


            JSONArray results = africasTalkingGateway.sendMessage(recipients.toString(), message, sender);
            for (int i = 0; i < results.length(); i++) {
                JSONObject result = results.getJSONObject(i);
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("SMS OUT Result [status= %s, Phone= %s, MessageId= %s, Cost= %s]", result.getString("status"), result.getString("phone"), result.getString("messageId"), result.getString("cost")));

            }
//            Logger.getLogger(this.getClass().getName()).log(Level.INFO, MessageFormat.format("Message Length {0} ", message.length()));
//            Logger.getLogger(this.getClass().getName()).log(Level.INFO, MessageFormat.format("Recipients {0} ", recipients.toString()));
        } catch (JSONException | IOException ex) {
//            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("SMS OUT Result [status= %s, Phone= %s, MessageId= %s, Cost= %s]", ex.getMessage(), recipients.toString(), sender, 0));
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("SMS OUT Result [status= %s, Phone= %s, MessageId= %s, Cost= %s]", e.getMessage(), recipients.toString(), sender, 0));
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }

        return "sent";
    }


    @Override
    public String sendSmsUsingAficasTalking(SmsRegistry smsRegistry) {

        String response = "";
        try {
//            JSONArray results = africasTalkingGateway.sendMessage(smsRegistry.getSubno().startsWith("+")?smsRegistry.getSubno():"+"+smsRegistry.getSubno(), smsRegistry.getMessageText(), smsRegistry.getShortCode());
            JSONArray results = africasTalkingGateway.sendMessage(smsRegistry.getSubno(), smsRegistry.getMessageText(), smsRegistry.getShortCode());
            for (int i = 0; i < results.length(); i++) {
                JSONObject result = results.getJSONObject(i);
                response = String.format("%s %s", response, String.format("SMS OUT Result [status= %s, Phone= %s, MessageId= %s, Cost= %s]", result.getString("status"), result.getString("number"), result.getString("messageId"), result.getString("cost")));
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, response);
            }
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, MessageFormat.format("Message Length {0} ", smsRegistry.getMessageText().length()));
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, MessageFormat.format("Recipients {0} ", smsRegistry.getSubno()));
        } catch (Exception e) {
            response = String.format("SMS OUT Result [status= %s, Phone= %s, MessageId= %s, Cost= %s]", e.getMessage(), smsRegistry.getSubno(), smsRegistry.getSender(), 0);
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, response);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return response;
    }


}
