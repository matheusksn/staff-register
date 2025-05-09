package com.matheusksn.staff_register.config.health;

import org.junit.jupiter.api.Test;
import org.springframework.boot.actuate.health.Health;

import static org.junit.jupiter.api.Assertions.*;

class ReadinessProbeTest {

    private final ReadinessProbe readinessProbe = new ReadinessProbe();

    @Test
    void testHealth() {
        Health health = readinessProbe.health();

        assertNotNull(health);
        assertEquals("UP", health.getStatus().getCode());
        assertEquals("Aplicação está pronta", health.getDetails().get("readiness"));
    }
}
