package com.vaynerakawalo.javabaseapp.servicehealth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Clock;
import java.util.Map;

@RestController
public class ServiceStatusController {

    private final long startTime;
    private final Clock clock;

    @Value("${service.version}")
    private String version;

    public ServiceStatusController(Clock clock) {
        this.startTime = clock.millis();
        this.clock = clock;
    }

    @GetMapping(path = {"/health", "/healthcheck"})
    Map<String, String> health() {
        return Map.of("status", "OK");
    }

    @GetMapping("/info")
    Map<String, String> info() {
        return Map.of(
                "uptime", String.valueOf(clock.millis() - startTime),
                "version", version
        );
    }
}
