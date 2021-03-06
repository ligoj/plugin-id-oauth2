/*
 * Licensed under MIT (https://github.com/ligoj/ligoj/blob/master/LICENSE)
 */
package org.ligoj.app.plugin.id.oauth2.resource;

import java.util.function.Function;

import org.ligoj.bootstrap.resource.system.cache.CacheManagerAware;
import org.springframework.stereotype.Component;

import com.hazelcast.cache.HazelcastCacheManager;
import com.hazelcast.config.CacheConfig;

/**
 * Cache configuration for LDAP.
 */
@Component
public class IdSqlCache implements CacheManagerAware {

	@Override
	public void onCreate(final HazelcastCacheManager cacheManager, final Function<String, CacheConfig<?, ?>> provider) {
		cacheManager.createCache("id-sql-configuration", provider.apply("id-sql-configuration"));
		cacheManager.createCache("id-sql-data", provider.apply("id-sql-data"));
	}

}
