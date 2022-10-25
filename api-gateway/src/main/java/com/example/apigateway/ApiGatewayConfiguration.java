package com.example.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r -> r.path("/get")
                        .filters(p-> p
                                .addRequestHeader("token", "hghghhhgjghghas")
                                .addRequestParameter("cpf", "89009844390"))
                        .uri("http://httpbin.org:80"))
                .route(p-> p
                        .path("/immunobiological/**")
                        .uri("lb://immunobiological-service"))
                .route(p-> p
                        .path("/vaccine-registry/**")
                        .uri("lb://vaccine-service"))
                .build();
    }
}