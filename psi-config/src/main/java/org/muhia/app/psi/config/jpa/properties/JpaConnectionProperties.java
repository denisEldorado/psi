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
package org.muhia.app.psi.config.jpa.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 */
@Configuration
@PropertySource(value = "file:${CONFIG_PATH}/persistence-oracle.properties")
public class JpaConnectionProperties {

    @Value("${org.muhia.psi.config.orm.hibernate.jdbc.driver.class.name}")
    private String jdbcDriverClassName;
    @Value("${org.muhia.psi.config.orm.hibernate.jdbc.url}")
    private String jdbcUrl;
    @Value("${org.muhia.psi.config.orm.hibernate.jdbc.user}")
    private String jdbcUser;
    @Value("${org.muhia.psi.config.orm.jdbc.pass}")
    private String jdbcPass;
    @Value("${org.muhia.psi.config.orm.hibernate.dialect}")
    private String hibernateDialect;
    @Value("${org.muhia.psi.config.orm.hibernate.show.sql}")
    private String hibernateShowSql;
    @Value("${org.muhia.psi.config.orm.hibernate.hbm2ddl.auto}")
    private String hibernateHbm2ddlAuto;
    @Value("${org.muhia.psi.config.orm.hibernate.pool.acquire.increment}")
    private int poolAcquireIncrement;
    @Value("${org.muhia.psi.config.orm.hibernate.pool.auto.commit.onclose}")
    private String poolAutoCommitOnclose;
    @Value("${org.muhia.psi.config.orm.hibernate.pool.initial.size}")
    private int poolInitialSize;
    @Value("${org.muhia.psi.config.orm.hibernate.pool.max.size}")
    private int poolMaxSize;
    @Value("${org.muhia.psi.config.orm.hibernate.pool.min.size}")
    private int poolMinSize;
    @Value("${org.muhia.psi.config.orm.hibernate.pool.max.idle.time}")
    private int poolMaxIdleTime;
    @Value("${org.muhia.psi.config.orm.hibernate.pool.acquire.retry.attempts}")
    private int poolAcquireRetryAttempts;
    @Value("${org.muhia.psi.config.orm.hibernate.pool.acquire.retry.delay}")
    private int poolAcquireRetryDelay;
    @Value("${org.muhia.psi.config.orm.hibernate.pool.max.connection.age}")
    private int poolMaxConnectionAge;
    @Value("${org.muhia.psi.config.orm.hibernate.pool.maxidle.timeexcess.connections}")
    private int poolMaxIdleTimeExcessConnections;
    @Value("${org.muhia.psi.config.orm.hibernate.pool.max.statements}")
    private int poolMaxStatements;
    @Value("${org.muhia.psi.config.orm.hibernate.pool.max.statements.perconnection}")
    private int poolMaxStatementsPerConnection;
    @Value("${org.muhia.psi.config.orm.hibernate.pool.preferred.test.query}")
    private String poolPreferredTestQuery;
    @Value("${org.muhia.psi.config.orm.hibernate.pool.automatic.testtable}")
    private String poolAutomaticTestTable;
    @Value("${org.muhia.psi.config.orm.hibernate.pool.idle.connection.testperiod}")
    private int poolIdleConnectionTestPeriod;
    @Value("${org.muhia.psi.config.orm.hibernate.pool.testconnection.on.checkin}")
    private String poolTestConnectionOnCheckin;
    @Value("${org.muhia.psi.config.orm.hibernate.pool.testconnection.on.checkout}")
    private String poolTestConnectionOnCheckout;
    @Value("${org.muhia.psi.config.orm.hibernate.pool.login.timeout}")
    private int poolLoginTimeout;
    @Value("${org.muhia.psi.config.orm.hibernate.pool.connection.customizer.classname}")
    private String poolConnectionCustomizerClassName;
    @Value("${org.muhia.psi.config.orm.hibernate.generate.statistics}")
    private String generateStatistics;
    @Value("${org.muhia.psi.config.orm.hibernate.spring.component.scan}")
    private String springComponentScan;
    @Value("${org.muhia.psi.config.orm.hibernate.spring.enable.jpa.repositories}")
    private String springEnableJpaRepositories;
    @Value("${org.muhia.psi.config.orm.hibernate.spring.packages.to.scan}")
    private String springPackagesToScan;
    @Value("${org.muhia.psi.config.orm.hibernate.cache.use.second.level}")
    private String cacheUseSecondLevel;
    @Value("${org.muhia.psi.config.orm.hibernate.cache.region.factory.class}")
    private String cacheRegionFactoryClass;
    @Value("${org.muhia.psi.config.orm.hibernate.cache.hazelcast.instance.name}")
    private String cacheHazelcastInstanceName;
    @Value("${org.muhia.psi.config.orm.hibernate.cache.use.query.cache}")
    private String cacheUseQueryCache;
    @Value("${org.muhia.psi.config.orm.hibernate.cache.use.minimal.puts}")
    private String cacheUseMinimalPuts;
    @Value("${org.muhia.psi.config.orm.hibernate.cache.hazelcast.use.litemember}")
    private String cacheHazelcastUseLitemember;
    @Value("${org.muhia.psi.config.orm.hibernate.cache.hazelcast.use.nativeclient}")
    private String cacheHazelcastUseNativeclient;
    @Value("${org.muhia.psi.config.orm.hibernate.cache.hazelcast.nativeclient.hostmembers}")
    private String[] cacheHazelcastNativeclientHostmembers;
    @Value("${org.muhia.psi.config.orm.hibernate.cache.hazelcast.nativeclient.group}")
    private String cacheHazelcastNativeclientGroup;
    @Value("${org.muhia.psi.config.orm.hibernate.cache.hazelcast.nativeclient.password}")
    private String cacheHazelcastNativeclientPassword;
    @Value("${org.muhia.psi.config.orm.hibernate.cache.use.structured.entries}")
    private String cacheUseStructuredEntries;
    @Value("${org.muhia.psi.config.orm.hibernate.cache.hazelcast.tcpip.enabled}")
    private String cacheHazelcastTcpipEnabled;
    @Value("${org.muhia.psi.config.orm.hibernate.cache.hazelcast.network.port}")
    private int cacheHazelcastNetworkPort;
    @Value("${org.muhia.psi.config.orm.hibernate.cache.hazelcast.networkport.autoincrement}")
    private boolean cacheHazelcastNetworkportAutoincrement;
    @Value("${org.muhia.psi.config.orm.hibernate.hibernate.id.newgenerator.mappings}")
    private String hibernateIdNewgeneratorMappings;


    public String getJdbcDriverClassName() {
        return jdbcDriverClassName;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public String getJdbcUser() {
        return jdbcUser;
    }

    public String getJdbcPass() {
        return jdbcPass;
    }

    public String getHibernateDialect() {
        return hibernateDialect;
    }

    public String getHibernateShowSql() {
        return hibernateShowSql;
    }

    public String getHibernateHbm2ddlAuto() {
        return hibernateHbm2ddlAuto;
    }

    public int getPoolAcquireIncrement() {
        return poolAcquireIncrement;
    }

    public String getPoolAutoCommitOnclose() {
        return poolAutoCommitOnclose;
    }

    public int getPoolInitialSize() {
        return poolInitialSize;
    }

    public int getPoolMaxSize() {
        return poolMaxSize;
    }

    public int getPoolMinSize() {
        return poolMinSize;
    }

    public int getPoolMaxIdleTime() {
        return poolMaxIdleTime;
    }

    public int getPoolAcquireRetryAttempts() {
        return poolAcquireRetryAttempts;
    }

    public int getPoolAcquireRetryDelay() {
        return poolAcquireRetryDelay;
    }

    public int getPoolMaxConnectionAge() {
        return poolMaxConnectionAge;
    }

    public int getPoolMaxIdleTimeExcessConnections() {
        return poolMaxIdleTimeExcessConnections;
    }

    public int getPoolMaxStatements() {
        return poolMaxStatements;
    }

    public int getPoolMaxStatementsPerConnection() {
        return poolMaxStatementsPerConnection;
    }

    public String getPoolPreferredTestQuery() {
        return poolPreferredTestQuery;
    }

    public String getPoolAutomaticTestTable() {
        return poolAutomaticTestTable;
    }

    public int getPoolIdleConnectionTestPeriod() {
        return poolIdleConnectionTestPeriod;
    }

    public String getPoolTestConnectionOnCheckin() {
        return poolTestConnectionOnCheckin;
    }

    public String getPoolTestConnectionOnCheckout() {
        return poolTestConnectionOnCheckout;
    }

    public int getPoolLoginTimeout() {
        return poolLoginTimeout;
    }

    public String getPoolConnectionCustomizerClassName() {
        return poolConnectionCustomizerClassName;
    }

    public String getGenerateStatistics() {
        return generateStatistics;
    }

    public String getSpringComponentScan() {
        return springComponentScan;
    }

    public String getSpringEnableJpaRepositories() {
        return springEnableJpaRepositories;
    }

    public String getSpringPackagesToScan() {
        return springPackagesToScan;
    }

    public String getCacheUseSecondLevel() {
        return cacheUseSecondLevel;
    }

    public String getCacheRegionFactoryClass() {
        return cacheRegionFactoryClass;
    }

    public String getCacheHazelcastInstanceName() {
        return cacheHazelcastInstanceName;
    }

    public String getCacheUseQueryCache() {
        return cacheUseQueryCache;
    }

    public String getCacheUseMinimalPuts() {
        return cacheUseMinimalPuts;
    }

    public String getCacheHazelcastUseLitemember() {
        return cacheHazelcastUseLitemember;
    }

    public String getCacheHazelcastUseNativeclient() {
        return cacheHazelcastUseNativeclient;
    }

    public String[] getCacheHazelcastNativeclientHostmembers() {
        return cacheHazelcastNativeclientHostmembers;
    }

    public String getCacheHazelcastNativeclientGroup() {
        return cacheHazelcastNativeclientGroup;
    }

    public String getCacheHazelcastNativeclientPassword() {
        return cacheHazelcastNativeclientPassword;
    }

    public String getCacheUseStructuredEntries() {
        return cacheUseStructuredEntries;
    }

    public String getCacheHazelcastTcpipEnabled() {
        return cacheHazelcastTcpipEnabled;
    }

    public int getCacheHazelcastNetworkPort() {
        return cacheHazelcastNetworkPort;
    }

    public boolean getCacheHazelcastNetworkportAutoincrement() {
        return cacheHazelcastNetworkportAutoincrement;
    }

    public String getHibernateIdNewgeneratorMappings() {
        return hibernateIdNewgeneratorMappings;
    }
}
