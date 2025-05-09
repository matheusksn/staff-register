package com.matheusksn.staff_register.config.health;


import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class LivenessProbe implements HealthIndicator {

    @Override
    public Health health() {
        return Health.up().withDetail("liveness", "Aplicação está viva").build();
    }
}