package com.matheusksn.staff_register.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Staff Register API")
                        .version("1.0.0")
                        .description("Documentação da API do Staff Register, aplicação usada para gerenciar funcionários e departamentos."));
    }
}