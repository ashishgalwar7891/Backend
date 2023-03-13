package com.APIGATEWAY.Apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Appconfig {
    @Bean
    public RouteLocator getRoute(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p->p
                        .path("/api/v1/**")
//                        .uri("http://authService:4444/*"))
                        .uri("lb://authService:4444/*"))
                .route(p->p
                        .path("/product/**")
//                        .uri("http://userTrackService:5555/*"))
                        .uri("lb://userTrackService:5555/*"))
                .build();
    }
}
