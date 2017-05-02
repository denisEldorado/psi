package org.muhia.app.psi.orm.cache;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.spring.cache.HazelcastCacheManager;
import org.muhia.app.psi.config.cache.properties.HazelcastCacheProperties;
import org.muhia.app.psi.config.jpa.properties.JpaConnectionProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;

/*
  Created by Kenneth Muhia <muhia@muhia.org>
  Project: psi
  Package: org.muhia.app.psi.orm.cache
  Generated on: 12-Mar-17, 12:57.
 */
//@Configuration
//@EnableCaching
public class CachingConfiguration implements CachingConfigurer {

    private final JpaConnectionProperties jcp;
    private final HazelcastCacheProperties hcp;

    public CachingConfiguration(JpaConnectionProperties jcp, HazelcastCacheProperties hcp) {
        this.jcp = jcp;
        this.hcp = hcp;
    }

    @Override
    public CacheManager cacheManager() {
        ClientConfig config = new ClientConfig();
        config.getGroupConfig().setName(jcp.getCacheHazelcastInstanceName());
        config.getGroupConfig().setPassword(jcp.getCacheHazelcastNativeclientPassword());
        for (String hostname : jcp.getCacheHazelcastNativeclientHostmembers()) {
            config.getNetworkConfig().addAddress(String.format("%s", hostname));
        }

        HazelcastInstance client = HazelcastClient.newHazelcastClient(config);

        return new HazelcastCacheManager(client);
    }

    @Override
    public CacheResolver cacheResolver() {
        return null;
    }

    @Override
    public KeyGenerator keyGenerator() {
        return null;
    }

    @Override
    public CacheErrorHandler errorHandler() {
        return null;
    }
}
