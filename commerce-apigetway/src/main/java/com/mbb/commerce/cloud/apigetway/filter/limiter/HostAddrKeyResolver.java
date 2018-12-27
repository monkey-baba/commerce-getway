package com.mbb.commerce.cloud.apigetway.filter.limiter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义限流之地址
 *
 * @author xiaoc
 * create 2018-12-21
 **/
public class HostAddrKeyResolver implements KeyResolver {

	private static final Log log = LogFactory.getLog(HostAddrKeyResolver.class);
	
    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
    	log.info("HostAddrKeyResolver.resolve()");
        return Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
    }

}
