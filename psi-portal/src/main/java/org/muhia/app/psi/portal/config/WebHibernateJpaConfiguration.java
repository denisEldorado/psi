/*

* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.

*/
package org.muhia.app.psi.portal.config;

import org.muhia.app.psi.config.jpa.properties.JpaConnectionProperties;
import org.muhia.app.psi.config.security.HashingImplementation;
import org.muhia.app.psi.orm.config.HibernateJpaConfiguration;
import org.muhia.app.psi.orm.model.auditors.AuditingDateTimeProvider;
import org.muhia.app.psi.orm.model.auditors.IDateTimeService;
import org.muhia.app.psi.portal.security.auditors.UsernameAuditorAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@EnableJpaAuditing(dateTimeProviderRef = "dateTimeProvider")
public class WebHibernateJpaConfiguration extends HibernateJpaConfiguration {

    private final JpaConnectionProperties jcp;
    private final HashingImplementation hashingImplementation;

    @Autowired
    public WebHibernateJpaConfiguration(JpaConnectionProperties jcp, HashingImplementation hashingImplementation) {
        super(jcp, hashingImplementation);
        this.jcp = jcp;
        this.hashingImplementation = hashingImplementation;

    }


    @Bean
    AuditorAware<String> auditorProvider() {
        return new UsernameAuditorAware();
    }

    @Bean
    DateTimeProvider dateTimeProvider(IDateTimeService dateTimeService) {
        return new AuditingDateTimeProvider(dateTimeService);
    }
}
