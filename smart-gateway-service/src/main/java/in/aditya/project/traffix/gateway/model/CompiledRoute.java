package in.aditya.project.traffix.gateway.model;

import in.aditya.project.traffix.gateway.dto.responseDto.GatewayRoute;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.util.pattern.PathPattern;

@Getter
@AllArgsConstructor
public class CompiledRoute {

    private GatewayRoute gatewayRoute;
    private PathPattern pathPattern;
    private String sourcePathPrefix;
}

// path pattern used to match the request