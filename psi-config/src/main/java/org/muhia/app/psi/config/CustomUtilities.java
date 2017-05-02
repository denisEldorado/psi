package org.muhia.app.psi.config;
/*
  Copyright 2015-2016 the original author or authors.
  <p>
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
  <p>
  http://www.apache.org/licenses/LICENSE-2.0
  <p>
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
  <p>
  <p>
  Generated on 30-Oct-16 01:14
 */

import org.muhia.app.psi.config.order.properties.OrderProcessingProperties;
import org.muhia.app.psi.config.security.HashingImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Kenneth Muhia <muhia@muhia.org> on 30-Oct-16.
 *         for package org.muhia.app.psi.config
 */
@SuppressWarnings("ALL")
@Configuration
public class CustomUtilities {

    @Autowired
    private HashingImplementation encryptDecrypt;

    @Autowired
    private OrderProcessingProperties orderProcessingProperties;

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(.\\d+)?");
    }

    /**
     * Gets the current date and time from the application host
     * Date format is outlined in yyyy-mm-dd
     * Time format is outlined in hh:mm:ss
     *
     * @return gets a specific recorded time during usage
     */
    public static Date getTimestamp(String timeStamp) {
        Date timestamp = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date parsedDate = dateFormat.parse(timeStamp);
            timestamp = new java.sql.Timestamp(parsedDate.getTime());
        } catch (Exception ex) {
            Logger.getLogger(CustomUtilities.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }

        return timestamp;
    }

    public static String getDateFromOffset(Date prevDate, int offset) {
        Date dt = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(prevDate);
        c.add(Calendar.DATE, offset);
        return dateFormat.format(c.getTime());
    }

    /**
     * Represents a record of a specific time of access and the date
     *
     * @return Timestamp gets the most recent time of access
     */
    public static Timestamp getTimestamp(int daysOffset) {

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -daysOffset);
        return new Timestamp(cal.getTime().getTime());
    }

    public static Timestamp getTimestampAtMidnight(int daysOffset) {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.add(Calendar.DATE, -daysOffset);
        return new Timestamp(cal.getTime().getTime());
    }

    public static Timestamp getCurrentTimestamp() {
        Calendar calendar = Calendar.getInstance();
        return new Timestamp(calendar.getTime().getTime());
    }

    /**
     * Gets a value for any property stored in an encrypted configuration file
     *
     * @param propertyName       - property name whose value will be returned
     * @param encryptionPass     (optional) - jasypt password used to encrypt the
     *                           value if any.
     * @param configFileLocation - name that has been encrypted gets stored under this file location
     * @return
     */
    public static String getEncryptedProperty(String propertyName,
                                              String encryptionPass, String configFileLocation) {

        /*StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        if (!encryptionPass.isEmpty()) {
            encryptor.setPassword(encryptionPass);
        }

        Properties props = new EncryptableProperties(encryptor);
        try {
            props.load(new FileInputStream(configFileLocation));
            propertyValue = props.getProperty(propertyName);
        } catch (FileNotFoundException e) {
            LoggerFactory.getLogger(CustomUtilities.class).error(e.getMessage(), e);
        } catch (IOException e) {
            LoggerFactory.getLogger(CustomUtilities.class).error(e.getMessage(), e);
        }*/
        return null;
    }

    public String formatMsisdn(String subnoIn, int requiredLength, String countryCode) {
        String formatedMsisdn;
        formatedMsisdn = countryCode + subnoIn.substring(subnoIn.length() - requiredLength);
        return formatedMsisdn;

    }

    public Date calculateExpiryDate(Date start, final int expiryTimeInMinutes) {
        /*
            DONE: Expiry date is not working
         */
        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(start.getTime());
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }

    /**
     * Calls and initializes the url name
     */
    public String urlSubstitutions(String url, String paramsClass, String theKeyword) {
        String replaceUrl = "";
        try {
            Class<?> c = Class.forName(paramsClass);
            String[] keywords = (String[]) c.getMethod(theKeyword, (Class<?>) null).invoke(c, (Object) null);
            for (String keyword : keywords) {
                for (Field declaredField : c.getDeclaredFields()) {
                    /**
                     * Check if decryption is required
                     */
                    if (declaredField.getName().startsWith("enc")) {
                        if (declaredField.getName().startsWith("sub")) {

                            String methodName = "get" + declaredField.getName().substring(0, 1).toUpperCase() + declaredField.getName().substring(1);
                            replaceUrl = url.replace(keyword, encryptDecrypt.getDecryptedValue((String) c.getDeclaredMethod(methodName, (Class<?>) null).invoke(c, (Object) null)));
                            url = replaceUrl;
                        }
                    } else if (declaredField.getName().startsWith("sub")) {

                        String methodName = "get" + declaredField.getName().substring(0, 1).toUpperCase() + declaredField.getName().substring(1);
                        replaceUrl = url.replace(keyword, (String) c.getDeclaredMethod(methodName, (Class<?>) null).invoke(c, (Object) null));
                        url = replaceUrl;
                    }

                }
            }

        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(CustomUtilities.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }

        return url;
    }

    /**
     * The hashing here identifies the names and numbers in the url and updates the exiting ones
     * This is done on the tables created
     */
    public HashMap<String, String> arraysToHashMap(String[] keyArray, String[] valArray) {
        HashMap<String, String> someReplaceHash = new HashMap<>();
        for (int i = 0; i < keyArray.length; i++) {
            someReplaceHash.put(keyArray[i], valArray[i]);
        }
        return someReplaceHash;
    }

    /**
     * The class gets date from the host and converts it to the specified format
     *
     * @return the date expected that has been converted
     */
    public String getDateFromOffset(int offset) {
        Date dt = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, offset);
        return dateFormat.format(c.getTime());
    }

    public String addParametersToMessage(String message, Object[] input, Map<String, String> params) {

        MessageFormat formater = new MessageFormat(message);
        try {

            final String[] results = {formater.format(input)};
            params.forEach((pk, pv) -> {
                if (pk != null) {
                    if (pv != null) results[0] = results[0].replace(pk, pv);
                }
            });

            return results[0];
        } catch (NullPointerException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            return formater.format(input);
        }
    }

    public String addParametersToMessage(String message, Object[] input) {
        MessageFormat formater = new MessageFormat(message);
        try {

//            final String results =
            return formater.format(input);
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            return message;
        }
    }

    public String generateTransactionNumber() {
        String results = "";
        SimpleDateFormat sdf = new SimpleDateFormat(orderProcessingProperties.getTransactionNoFormatString());
        try {
            results = sdf.format(new Date());
            Logger.getLogger(this.getClass().getName()).log(Level.FINE, results);

        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }

        return results;
    }
}
