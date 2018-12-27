package com.mbb.commerce.cloud.apigetway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import com.mbb.commerce.cloud.apigetway.filter.RequestTimeGatewayFilterFactory;
import com.mbb.commerce.cloud.apigetway.filter.TokenFilter;



@SpringBootApplication
@RestController
//@EnableEurekaClient      //服务注册
public class CloudGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudGatewayApplication.class, args);
    }
    
    /**
     * 匹配指定的url,过滤器中添加请求头
     */
  @Bean
  public RouteLocator myRoutes(RouteLocatorBuilder builder) {
      String httpUri = "http://httpbin.org:80";
      return builder.routes()
          .route(p -> p
              .path("/get")
              .filters(f -> f.addRequestHeader("Hello", "World"))
              .uri(httpUri))
          .route(p -> p
              .host("*.hystrix.com")
              .filters(f -> f
                  .hystrix(config -> config
                      .setName("mycmd")
                      .setFallbackUri("forward:/fallback")))
              .uri(httpUri))
          .build();
  }

  /**
   * 自定义过滤器
   * @param builder
   * @return
   */
//	@Bean
//	public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
//	    return builder.routes()
//	            .route(r -> r.path("/customer/**")
//	                    .filters(f -> f.filter(new RequestTimeFilter())
//	                            .addResponseHeader("X-Response-Default-Foo", "Default-Bar"))
//	                    .uri("http://httpbin.org:80/get")
//	                    .order(0)
//	                    .id("customer_filter_router")
//	            )
//	            .build();
//	}
	
	/**
	 * 自定义全局过滤器
	 */
	@Bean
	public TokenFilter tokenFilter(){
	    return new TokenFilter();
	}
	
	/**
	 * 自定义过滤器工厂bean
	 */
	@Bean
	public RequestTimeGatewayFilterFactory elapsedGatewayFilterFactory() {
	    return new RequestTimeGatewayFilterFactory();
	}


}




