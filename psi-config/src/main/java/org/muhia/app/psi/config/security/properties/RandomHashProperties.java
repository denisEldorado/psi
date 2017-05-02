/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.config.security.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 *
 * @author KennethKZMMuhia
 */
@Configuration
@PropertySource(value = {"file:${CONFIG_PATH}/random-password.properties"})
public class RandomHashProperties {

    @Value("${org.muhia.psi.password.random.alphacaps}")
    private String alphaCaps;
    @Value("${org.muhia.psi.password.random.alpha}")
    private String alpha;
    @Value("${org.muhia.psi.password.random.num}")
    private String digits;
    @Value("${org.muhia.psi.password.random.specialchrs}")
    private String specialChars;
    @Value("${org.muhia.psi.password.random.minlenth}")
    private int minLenth;
    @Value("${org.muhia.psi.password.random.maxlength}")
    private int maxLength;
    @Value("${org.muhia.psi.password.random.alphacapscount}")
    private int alphaCapsCount;
    @Value("${org.muhia.psi.password.random.alphacount}")
    private int alphaCount;
    @Value("${org.muhia.psi.password.random.digitscount}")
    private int digitsCount;
    @Value("${org.muhia.psi.password.random.specialchrscount}")
    private int specialCharsCount;
    @Value("${org.muhia.psi.password.random.validitymins}")
    private int validityMins;
    @Value("${org.muhia.psi.password.random.smsid}")
    private String smsid;

    public String getAlphaCaps() {
        return alphaCaps;
    }

    public void setAlphaCaps(String alphaCaps) {
        this.alphaCaps = alphaCaps;
    }

    public String getAlpha() {
        return alpha;
    }

    public void setAlpha(String alpha) {
        this.alpha = alpha;
    }

    public String getDigits() {
        return digits;
    }

    public void setDigits(String digits) {
        this.digits = digits;
    }

    public String getSpecialChars() {
        return specialChars;
    }

    public void setSpecialChars(String specialChars) {
        this.specialChars = specialChars;
    }

    public int getMinLenth() {
        return minLenth;
    }

    public void setMinLenth(int minLenth) {
        this.minLenth = minLenth;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public int getAlphaCapsCount() {
        return alphaCapsCount;
    }

    public void setAlphaCapsCount(int alphaCapsCount) {
        this.alphaCapsCount = alphaCapsCount;
    }

    public int getAlphaCount() {
        return alphaCount;
    }

    public void setAlphaCount(int alphaCount) {
        this.alphaCount = alphaCount;
    }

    public int getDigitsCount() {
        return digitsCount;
    }

    public void setDigitsCount(int digitsCount) {
        this.digitsCount = digitsCount;
    }

    public int getSpecialCharsCount() {
        return specialCharsCount;
    }

    public void setSpecialCharsCount(int specialCharsCount) {
        this.specialCharsCount = specialCharsCount;
    }

    public int getValidityMins() {
        return validityMins;
    }

    public void setValidityMins(int validityMins) {
        this.validityMins = validityMins;
    }

    public String getSmsid() {
        return smsid;
    }

    public void setSmsid(String smsid) {
        this.smsid = smsid;
    }

}
