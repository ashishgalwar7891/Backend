package com.challange.SpringApiGateway.appConfig;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/api/v1/**")
                        .uri("http://authentication-service:8084/"))

                .route(p->p
                        .path("/usertrackservice/v1/**")
                        .uri("http://track-service:8081/"))
                .build();
    }

}
