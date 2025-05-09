package com.matheusksn.staff_register.config.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class ReadinessProbe implements HealthIndicator {

    @Override
    public Health health() {
        return Health.up().withDetail("readiness", "Aplicação está pronta").build();
    }
}
