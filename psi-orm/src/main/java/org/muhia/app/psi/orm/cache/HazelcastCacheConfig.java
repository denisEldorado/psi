package org.muhia.app.psi.orm.cache;

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

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.NearCacheConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.spring.cache.HazelcastCacheManager;
import org.muhia.app.psi.config.cache.properties.HazelcastCacheProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
    Created by Kenneth Muhia <muhia@muhia.org> 
    Project: phi
    Package: org.muhia.app.psi.orm.cache
    Generated on: 22-Jan-17.
*/
@Configuration
public class HazelcastCacheConfig {
    private final HazelcastCacheProperties properties;

    @Autowired
    public HazelcastCacheConfig(HazelcastCacheProperties properties) {
        this.properties = properties;
    }

    @Bean
    public CacheManager cacheManager() {
        // The Stormpath SDK knows to use the Spring CacheManager automatically
        return new HazelcastCacheManager(hazelcastInstance());
    }

    @Bean
    public HazelcastInstance hazelcastInstance() {
//        HazelcastInstance instance = Hazelcast.newHazelcastInstance(hazelCastConfig());
//        LoggingService loggingService = instance.getLoggingService();
//        loggingService


        return Hazelcast.newHazelcastInstance(hazelCastConfig());
    }

    @Bean
    public Config hazelCastConfig() {
        Config config = new Config();
//        config.set
        config.setInstanceName(properties.getDefaultInstanceName());
        config.setProperty("hazelcast.logging.type", properties.getHazelcastLoggingType());
        config.setProperty("hazelcast.diagnostics.enabled", properties.getHazelcastDiagnosticsEnabled());
        config.setProperty("hazelcast.phone.home.enabled", properties.getHazelcastPhoneHomeEnabled());

//        TcpIpConfig tcpIpConfig = new TcpIpConfig();
//        tcpIpConfig.setMembers(Arrays.asList(jcp.getCacheHazelcastNativeclientHostmembers()));
//        tcpIpConfig.setConnectionTimeoutSeconds(properties.getHazelcastTcpIpTimeout());
//        tcpIpConfig.setEnabled(properties.isHazelcastTcpIpEnabled());
//
//        config.getNetworkConfig()
//                .setPort(jcp.getCacheHazelcastNetworkPort())
//                .setPortAutoIncrement(jcp.getCacheHazelcastNetworkportAutoincrement())
//                .getJoin()
//                .setTcpIpConfig(tcpIpConfig)
//        .getMulticastConfig().setEnabled(false);
//        config.setProperty("hazelcast.logging.type", "none");

        MapConfig defaultCache = new MapConfig();
        defaultCache.setName(properties.getDefaultName());
        defaultCache.setTimeToLiveSeconds(properties.getDefaultTtl());
        defaultCache.setEvictionPolicy(EvictionPolicy.LFU);
        defaultCache.setBackupCount(properties.getDefaultBackupCount());
        defaultCache.getMaxSizeConfig().setSize(properties.getDefaultSizeMax());
        NearCacheConfig nearCacheConfig = new NearCacheConfig();

        nearCacheConfig.setMaxIdleSeconds(properties.getNearCacheMaxIdleSeconds()).setTimeToLiveSeconds(properties.getNearCacheTtl());
        defaultCache.setNearCacheConfig(nearCacheConfig);
        config.getMapConfigs().put(properties.getDefaultName(), defaultCache);


        MapConfig ussdCache = new MapConfig();
        ussdCache.setName(properties.getPostsName());
        ussdCache.setTimeToLiveSeconds(properties.getPostsTtl());
        ussdCache.setEvictionPolicy(EvictionPolicy.LFU);
        ussdCache.setBackupCount(properties.getPostsBackupCount());
        ussdCache.getMaxSizeConfig().setSize(properties.getPostsSizeMax());
        ussdCache.setNearCacheConfig(nearCacheConfig);
        config.getMapConfigs().put(properties.getPostsName(), ussdCache);

        MapConfig pagedPostsCache = new MapConfig();
        pagedPostsCache.setName(properties.getPagedPostsName());
        pagedPostsCache.setTimeToLiveSeconds(properties.getPagedPostsCacheTtl());
        pagedPostsCache.setEvictionPolicy(EvictionPolicy.LFU);
        pagedPostsCache.setBackupCount(properties.getPagedPostsBackupCount());
        pagedPostsCache.getMaxSizeConfig().setSize(properties.getPagedPostsSizeMax());
        pagedPostsCache.setNearCacheConfig(nearCacheConfig);
        config.getMapConfigs().put(properties.getPagedPostsName(), pagedPostsCache);


        return config;
    }
}
