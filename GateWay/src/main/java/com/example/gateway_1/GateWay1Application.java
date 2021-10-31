package com.example.gateway_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GateWay1Application {

    public static void main(String[] args) {

        SpringApplication.run(GateWay1Application.class, args);
    }

   // @Bean
    //methode non dynamique ici on connait le nom de micro-services ou dans qui machine sont ces micro-services
    RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route((r)->r.path("/customers/**").uri("lb://CUSTOMERS-SERVICE"))
                .route((r)-> r.path("/products/**").uri("lb://INVENTORY-SERVICE"))
                .build();

    }

    @Bean
    DiscoveryClientRouteDefinitionLocator dynamicRoutes(ReactiveDiscoveryClient rdc,
                                                        DiscoveryLocatorProperties dlp){

        return new DiscoveryClientRouteDefinitionLocator(rdc,dlp);

    }
}
