package org.muhia.app.psi.config.cache.properties;

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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/*
    Created by Kenneth Muhia <muhia@muhia.org> 
    Project: phi
    Package: org.muhia.app.phi.config
    Generated on: 22-Jan-17.
*/
@Configuration
@PropertySource(value = {"file:${CONFIG_PATH}/hazelcast-cache.properties"})
public class HazelcastCacheProperties {
    @Value("${org.muhia.phi.cache.hazelcast.default.instance.name}")
    private String defaultInstanceName;
    @Value("${org.muhia.phi.cache.hazelcast.default.name}")
    private String defaultName;
    @Value("${org.muhia.phi.cache.hazelcast.default.ttl}")
    private int defaultTtl;
    @Value("${org.muhia.phi.cache.hazelcast.posts.name}")
    private String postsName;
    @Value("${org.muhia.phi.cache.hazelcast.posts.ttl}")
    private int postsTtl;
    @Value("${org.muhia.phi.cache.hazelcast.paged.posts.name}")
    private String pagedPostsName;
    @Value("${org.muhia.phi.cache.hazelcast.pagedPosts.cache.ttl}")
    private int pagedPostsCacheTtl;
    @Value("${org.muhia.phi.cache.hazelcast.site.statistics.name}")
    private String siteStatisticsName;
    @Value("${org.muhia.phi.cache.hazelcast.site.statistics.ttl}")
    private int siteStatisticsTtl;
    @Value("${org.muhia.phi.cache.hazelcast.default.backup.count}")
    private int defaultBackupCount;
    @Value("${org.muhia.phi.cache.hazelcast.posts.backup.count}")
    private int postsBackupCount;
    @Value("${org.muhia.phi.cache.hazelcast.paged.posts.backup.count}")
    private int pagedPostsBackupCount;
    @Value("${org.muhia.phi.cache.hazelcast.site.statistics.backup.count}")
    private int siteStatisticsBackupCount;
    @Value("${org.muhia.phi.cache.hazelcast.default.size.max}")
    private int defaultSizeMax;
    @Value("${org.muhia.phi.cache.hazelcast.posts.ttl.size.max}")
    private int postsTtlSizeMax;
    @Value("${org.muhia.phi.cache.hazelcast.paged.posts.size.max}")
    private int pagedPostsSizeMax;
    @Value("${org.muhia.phi.cache.hazelcast.site.statistics.size.max}")
    private int siteStatisticsSizeMax;
    @Value("${org.muhia.phi.cache.hazelcast.near.cache.max.size}")
    private int nearCacheMaxSize;
    @Value("${org.muhia.phi.cache.hazelcast.nearCache.max.idle.seconds}")
    private int nearCacheMaxIdleSeconds;
    @Value("${org.muhia.phi.cache.hazelcast.near.cache.ttl}")
    private int nearCacheTtl;
    @Value("${org.muhia.phi.cache.hazelcast.posts.size.max}")
    private int postsSizeMax;
    @Value("${org.muhia.phi.cache.hazelcast.logging.type}")
    private String hazelcastLoggingType;
    @Value("${org.muhia.phi.cache.hazelcast.tcp.ip.timeout}")
    private int hazelcastTcpIpTimeout;
    @Value("${org.muhia.phi.cache.hazelcast.tcp.ip.enabled}")
    private boolean hazelcastTcpIpEnabled;
    @Value("${org.muhia.phi.cache.hazelcast.phone.home.enabled}")
    private String hazelcastPhoneHomeEnabled;
    @Value("${org.muhia.phi.cache.hazelcast.diagnostics.enabled}")
    private String hazelcastDiagnosticsEnabled;


    public String getDefaultInstanceName() {
        return defaultInstanceName;
    }

    public String getDefaultName() {
        return defaultName;
    }

    public int getDefaultTtl() {
        return defaultTtl;
    }

    public String getPostsName() {
        return postsName;
    }

    public int getPostsTtl() {
        return postsTtl;
    }

    public String getPagedPostsName() {
        return pagedPostsName;
    }

    public int getPagedPostsCacheTtl() {
        return pagedPostsCacheTtl;
    }

    public String getSiteStatisticsName() {
        return siteStatisticsName;
    }

    public int getSiteStatisticsTtl() {
        return siteStatisticsTtl;
    }


    public int getDefaultBackupCount() {
        return defaultBackupCount;
    }

    public int getPostsBackupCount() {
        return postsBackupCount;
    }

    public int getPagedPostsBackupCount() {
        return pagedPostsBackupCount;
    }

    public int getSiteStatisticsBackupCount() {
        return siteStatisticsBackupCount;
    }

    public int getDefaultSizeMax() {
        return defaultSizeMax;
    }

    public int getPostsTtlSizeMax() {
        return postsTtlSizeMax;
    }

    public int getPagedPostsSizeMax() {
        return pagedPostsSizeMax;
    }

    public int getSiteStatisticsSizeMax() {
        return siteStatisticsSizeMax;
    }

    public int getNearCacheMaxSize() {
        return nearCacheMaxSize;
    }

    public int getNearCacheMaxIdleSeconds() {
        return nearCacheMaxIdleSeconds;
    }

    public int getNearCacheTtl() {
        return nearCacheTtl;
    }

    public int getPostsSizeMax() {
        return postsSizeMax;
    }

    public String getHazelcastLoggingType() {
        return hazelcastLoggingType;
    }


    public int getHazelcastTcpIpTimeout() {
        return hazelcastTcpIpTimeout;
    }

    public boolean isHazelcastTcpIpEnabled() {
        return hazelcastTcpIpEnabled;
    }


    public String getHazelcastPhoneHomeEnabled() {
        return hazelcastPhoneHomeEnabled;
    }

    public String getHazelcastDiagnosticsEnabled() {
        return hazelcastDiagnosticsEnabled;
    }
}
