package org.muhia.app.psi.config.msisdn.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by mathenge on 2/14/17.
 */
@Configuration
@PropertySource(value="file:${CONFIG_PATH}/msisdn_prefix.properties")
public class MsisdnPrefixProperties {
    @Value("${org.muhia.app.psi.config.msisdn.ke.country.code}")
    private String countryCode;
    @Value("${org.muhia.app.psi.config.msisdn..ke.safaricom.prefix}")
    private String [] safaricomPrefix;

    @Value("${org.muhia.app.psi.config.msisdn..ke.airtel.prefix}")
    private String [] airtelPrefix;

    public String getCountryCode() {
        return countryCode;
    }

    public String[] getSafaricomPrefix() {
        return safaricomPrefix;
    }

    public String[] getAirtelPrefix() {
        return airtelPrefix;
    }
}
