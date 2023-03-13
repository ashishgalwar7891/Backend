package com.example.apigw.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Appconfig {
    @Bean
    public RouteLocator getroute(RouteLocatorBuilder builder)
    {
        return builder.routes()
                .route(p->p
                        .path("/api/user/**")
                        .uri("http://localhost:8182/*")
                )
                .route(p->p
                        .path("/api/v1/**")
                        .uri("http://localhost:8075/*"))
                .build();
    }
}
