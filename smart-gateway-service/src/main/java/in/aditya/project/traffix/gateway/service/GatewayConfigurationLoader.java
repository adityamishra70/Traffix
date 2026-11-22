package in.aditya.project.traffix.gateway.service;

// loads all the config from api management .


import in.aditya.project.traffix.gateway.client.ManagementApiClient;
import in.aditya.project.traffix.gateway.dto.responseDto.GatewayRoute;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GatewayConfigurationLoader implements ApplicationRunner {

    private final ManagementApiClient managementApiClient;
    private final RouteRegistry routeRegistry;

    public GatewayConfigurationLoader(ManagementApiClient managementApiClient,
                                      RouteRegistry routeRegistry) {

        this.managementApiClient = managementApiClient;
        this.routeRegistry = routeRegistry;
    }

    @Override
    public void run(ApplicationArguments arguments) {
        refresh();
    }

    public void refresh() {
        List<GatewayRoute> routes = managementApiClient.fetchActiveRoutes();

        routeRegistry.replaceAll(routes);
    }
}