package in.aditya.project.traffix.gateway.controller;


import in.aditya.project.traffix.gateway.service.GatewayService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {

    private final GatewayService gatewayService;

    public GatewayController(GatewayService gatewayService) {
        this.gatewayService = gatewayService;
    }

    @RequestMapping("/**")
    public ResponseEntity<byte[]> proxy(HttpServletRequest request) {
        return gatewayService.handle(request);
    }
}
// every request can be entertained by HttpServletRequest
// we don't know about the response so return type is stream of bytes

// only 1 controller to receive request from our client