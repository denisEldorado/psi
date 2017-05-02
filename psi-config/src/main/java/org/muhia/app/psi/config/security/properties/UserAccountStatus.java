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
package org.muhia.app.psi.config.security.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 *
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@Configuration
@PropertySource(value = {"file:${CONFIG_PATH}/account-status.properties"})
public class UserAccountStatus {

    /**
     * Based on Principals.status
     *  0: Disabled
     *  1: Enabled
     *  5: AccountExpired
     *  6:CredentialsExpired
     *  7: AccountsLocked
     */
    @Value("${org.muhia.psi.spring.user.status.disabled}")
    private int disabled;
    @Value("${org.muhia.psi.spring.user.status.enabled}")
    private int enabled;
    @Value("${org.muhia.psi.spring.user.status.accountExpired}")
    private int accountExpired;
    @Value("${org.muhia.psi.spring.user.status.credentialsExpired}")
    private int credentialsExpired;
    @Value("${org.muhia.psi.spring.user.status.accountsLocked}")
    private int accountsLocked;

    /**
     * @return the disabled
     */
    public int getDisabled() {
        return disabled;
    }

    /**
     * @param disabled the disabled to set
     */
    public void setDisabled(int disabled) {
        this.disabled = disabled;
    }

    /**
     * @return the enabled
     */
    public int getEnabled() {
        return enabled;
    }

    /**
     * @param enabled the enabled to set
     */
    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    /**
     * @return the accountExpired
     */
    public int getAccountExpired() {
        return accountExpired;
    }

    /**
     * @param accountExpired the accountExpired to set
     */
    public void setAccountExpired(int accountExpired) {
        this.accountExpired = accountExpired;
    }

    /**
     * @return the credentialsExpired
     */
    public int getCredentialsExpired() {
        return credentialsExpired;
    }

    /**
     * @param credentialsExpired the credentialsExpired to set
     */
    public void setCredentialsExpired(int credentialsExpired) {
        this.credentialsExpired = credentialsExpired;
    }

    /**
     * @return the accountsLocked
     */
    public int getAccountsLocked() {
        return accountsLocked;
    }

    /**
     * @param accountsLocked the accountsLocked to set
     */
    public void setAccountsLocked(int accountsLocked) {
        this.accountsLocked = accountsLocked;
    }

}
