package com.matheusksn.staff_register.config.health;

import org.junit.jupiter.api.Test;
import org.springframework.boot.actuate.health.Health;

import static org.junit.jupiter.api.Assertions.*;

class LivenessProbeTest {

    private final LivenessProbe livenessProbe = new LivenessProbe();

    @Test
    void testHealth() {
        Health health = livenessProbe.health();

        assertNotNull(health);
        assertEquals("UP", health.getStatus().getCode());
        assertEquals("Aplicação está viva", health.getDetails().get("liveness"));
    }
}
