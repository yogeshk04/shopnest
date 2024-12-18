package com.auth.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;

import reactor.core.publisher.Mono;

@SpringBootApplication
public class ShopnestGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopnestGatewayApplication.class, args);
	}

	@Bean
	public KeyResolver userKeyResolver() {
		return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
	}
}
