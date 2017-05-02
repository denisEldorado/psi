package org.muhia.app.psi.orm.config;

/*
  Copyright 2015-2017 the original author or authors.
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
  
*/

import com.google.common.base.Preconditions;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.muhia.app.psi.config.jpa.properties.JpaConnectionProperties;
import org.muhia.app.psi.config.security.HashingImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
    Created by Kenneth Muhia <muhia@muhia.org> 
    Project: psi
    Package: org.muhia.app.psi.orm
    Generated on: 08-Jan-17.
*/
@Configuration
@EnableTransactionManagement(mode = AdviceMode.PROXY)
//@ComponentScan(basePackages = {"org.muhia.app.taus.orm"})
@EnableJpaRepositories(basePackages = {"org.muhia.app.psi.orm.repo"}, entityManagerFactoryRef = "entityManagerFactoryBean")
public class HibernateJpaConfiguration {
    /**
     * TODO: Disable Jpa Validation by wiring in the relevant property, none works for now, but any word would
     */
    private final JpaConnectionProperties jcp;
    private final HashingImplementation hashingImplementation;

    @Autowired
    public HibernateJpaConfiguration(JpaConnectionProperties jcp, HashingImplementation hashingImplementation) {
        this.jcp = jcp;
        this.hashingImplementation = hashingImplementation;
    }


//    public HibernateJpaConfiguration() {
//        super();
//    }


    @Bean
    public JpaTransactionManager transactionManager() {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        try {
            HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
            vendorAdapter.setGenerateDdl(true);
            vendorAdapter.setShowSql(false);

            final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
            em.setJpaProperties(hibernateAdditionalProperties());

            em.setDataSource(dataSource());
            em.setPackagesToScan(jcp.getSpringPackagesToScan());

            em.setJpaVendorAdapter(vendorAdapter);

            return em;
        } catch (Exception e) {
            Logger.getLogger(HibernateJpaConfiguration.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new LocalContainerEntityManagerFactoryBean();
        }

    }

/*
    TODO: Implement the cleanup method
 */

//      private void cleanup(DataSource ds) throws SQLException {
//        /*
//            make sure it's a c3p0 PooledDataSource
//        */
//        if (ds instanceof PooledDataSource) {
//            PooledDataSource pds = (PooledDataSource) ds;
//            pds.close();
//        } else {
//            Logger.getLogger(HibernateJpaConfiguration.class.getName()).log(Level.INFO, "Not a c3p0 PooledDataSource!");
//        }
//
//    }


    @Bean(name = "datasource")
    @Primary
    public DataSource dataSource() {
        final ComboPooledDataSource pooledDataSource = new ComboPooledDataSource();
        try {
            pooledDataSource.setDriverClass(Preconditions.checkNotNull(jcp.getJdbcDriverClassName().trim()));
            pooledDataSource.setJdbcUrl(Preconditions.checkNotNull(jcp.getJdbcUrl().trim()));
            pooledDataSource.setUser(Preconditions.checkNotNull(hashingImplementation.getDecryptedValue(jcp.getJdbcUser().trim())));
            pooledDataSource.setPassword(Preconditions.checkNotNull(hashingImplementation.getDecryptedValue(jcp.getJdbcPass().trim())));
            pooledDataSource.setInitialPoolSize(Preconditions.checkNotNull(jcp.getPoolInitialSize()));
            pooledDataSource.setMaxIdleTime(Preconditions.checkNotNull(jcp.getPoolMaxIdleTime()));
            pooledDataSource.setMinPoolSize(Preconditions.checkNotNull(jcp.getPoolMinSize()));
            pooledDataSource.setMaxPoolSize(Preconditions.checkNotNull(jcp.getPoolMaxSize()));
            pooledDataSource.setAcquireIncrement(Preconditions.checkNotNull(jcp.getPoolAcquireIncrement()));
            pooledDataSource.setAcquireRetryAttempts(Preconditions.checkNotNull(jcp.getPoolAcquireRetryAttempts()));
            pooledDataSource.setAcquireRetryDelay(Preconditions.checkNotNull(jcp.getPoolAcquireRetryDelay()));
            pooledDataSource.setMaxConnectionAge(Preconditions.checkNotNull(jcp.getPoolMaxConnectionAge()));
            pooledDataSource.setMaxStatements(Preconditions.checkNotNull(jcp.getPoolMaxStatements()));
            pooledDataSource.setMaxStatementsPerConnection(Preconditions.checkNotNull(jcp.getPoolMaxStatementsPerConnection()));
            pooledDataSource.setPreferredTestQuery(Preconditions.checkNotNull(jcp.getPoolPreferredTestQuery().trim()));
        } catch (PropertyVetoException ex) {
            Logger.getLogger(HibernateJpaConfiguration.class.getName()).log(Level.SEVERE, null, ex);
        }
//        finally {
//            try {
//                DataSources.destroy(pooledDataSource);
//            } catch (SQLException e) {
//                Logger.getLogger(HibernateJpaConfiguration.class.getName()).log(Level.SEVERE, e.getMessage(), e);
//            }
//        }

        return pooledDataSource;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    private Properties hibernateAdditionalProperties() {
        Properties results = new Properties();
        //hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        results.setProperty("hibernate.dialect", jcp.getHibernateDialect());
        // hibernateProperties.setProperty("hibernate.globally_quoted_identifiers", "true");
        results.setProperty("hibernate.hbm2ddl.auto", jcp.getHibernateHbm2ddlAuto());
        results.setProperty("hibernate.show_sql", jcp.getHibernateShowSql());
        results.setProperty("hibernate.format_sql", jcp.getHibernateShowSql());
        results.setProperty("hibernate.use_sql_comments", jcp.getHibernateShowSql());
        results.setProperty("hibernate.cache.use_second_level_cache", jcp.getCacheUseSecondLevel());
        results.setProperty("hibernate.cache.region.factory_class", jcp.getCacheRegionFactoryClass());
        results.setProperty("hibernate.cache.hazelcast.instance_name", jcp.getCacheHazelcastInstanceName());
        results.setProperty("hibernate.cache.use_query_cache", jcp.getCacheUseQueryCache());
        results.setProperty("hibernate.cache.use_minimal_puts", jcp.getCacheUseMinimalPuts());
        results.setProperty("hibernate.cache.hazelcast.use_native_client", jcp.getCacheHazelcastUseNativeclient());
        results.setProperty("hibernate.cache.use_structured_entries", jcp.getCacheUseStructuredEntries());
        results.setProperty("hibernate.generate_statistics", jcp.getGenerateStatistics());
        results.setProperty("hibernate.cache.hazelcast.use_lite_member", jcp.getCacheHazelcastUseLitemember());

        /*
         * TODO: To be externalise
         */
        results.setProperty("hibernate.id.new_generator_mappings", jcp.getHibernateIdNewgeneratorMappings());
        return results;
    }
}
