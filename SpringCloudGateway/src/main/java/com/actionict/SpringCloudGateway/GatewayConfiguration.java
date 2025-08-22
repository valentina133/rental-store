package com.actionict.SpringCloudGateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {

        return builder.routes()
                .route(p -> p.path("/customers/**").uri("lb://CUSTOMER"))
                .build();
    }
}

