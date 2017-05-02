/**
 * Copyright 2015-2017 the original author or authors.
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
 */
package org.muhia.app.psi.config.security;

import org.muhia.app.psi.config.org.properties.OrganizationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidParameterSpecException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KennethKZMMuhia
 */
@Component
public class AesEncryption {
    @Autowired
    private OrganizationProperties organizationProperties;

    /**
     * @param keyValue
     * @return
     */
    private  Optional<Key> generateKey(String keyValue) {
        Key key = null;
        try {
            if (keyValue != null && keyValue.length() == organizationProperties.getHashingConfigKeysize()) {
                byte[] byteKey = new byte[0];

                byteKey = keyValue.substring(0, organizationProperties.getHashingConfigKeysize()).getBytes(organizationProperties.getHashingConfigEncoding());

                key = new SecretKeySpec(byteKey, organizationProperties.getHashingConfigAlgorithm());
            } else {
                Logger.getLogger(AesEncryption.class.getName()).log(Level.SEVERE,"Failed generating the Key!! " + keyValue);

            }
        } catch (UnsupportedEncodingException e) {
            Logger.getLogger(AesEncryption.class.getName()).log(Level.SEVERE,e.getMessage(),e);
        }


        return Optional.ofNullable(key);
    }

    /**
     * @param keyValue
     * @return
     */
    public  String generateIV(String keyValue){
        final String[] iv = {null};
        Optional<Key> key = generateKey(keyValue);
        key.ifPresent(k -> {
            try {
                Cipher cipher = Cipher.getInstance(organizationProperties.getHashingConfigAlgorithmCbc());
                cipher.init(Cipher.ENCRYPT_MODE,k);
                AlgorithmParameters params = cipher.getParameters();
                iv[0] = new BASE64Encoder().encode(params.getParameterSpec(IvParameterSpec.class).getIV());
            } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidParameterSpecException e) {
                Logger.getLogger(AesEncryption.class.getName()).log(Level.SEVERE,e.getMessage(),e);
            }
        });

        return iv[0];
    }

    public  String encrypt(String encKey, String plainVal, String currentIV){
        final String[] encryptedText = {""};
        Optional<Key> key = generateKey(encKey);
        key.ifPresent(k -> {
            try {
                Cipher cipher = Cipher.getInstance(organizationProperties.getHashingConfigAlgorithmCbc());
                cipher.init(Cipher.ENCRYPT_MODE,k,new IvParameterSpec(new BASE64Decoder().decodeBuffer(currentIV)));
                byte[] encValue = cipher.doFinal(plainVal.getBytes());
                encryptedText[0] = new BASE64Encoder().encode(encValue);

            }catch (NullPointerException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | IOException | BadPaddingException | IllegalBlockSizeException e){
                Logger.getLogger(AesEncryption.class.getName()).log(Level.SEVERE,e.getMessage(),e);
                encryptedText[0]= String.format("Invalid input passed to encrypt !!keyValue=%s, IV=%s, valueToEnc=%s", encKey, currentIV, plainVal);
            }
        });
        return encryptedText[0];
    }

}
