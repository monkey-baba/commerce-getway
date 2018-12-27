package com.mbb.commerce.cloud.apigetway.filter.limiter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义限流之uri
 *
 * @author xiaoc
 * create 2018-12-21
 **/
public class UriKeyResolver  implements KeyResolver {
	private static final Log log = LogFactory.getLog(UriKeyResolver.class);

    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
    	log.info("UriKeyResolver.resolve()");
        return Mono.just(exchange.getRequest().getURI().getPath());
    }

}
