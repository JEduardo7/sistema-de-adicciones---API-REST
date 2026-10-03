package com.sistemaadicciones.backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI sistemaAdiccionesOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Sistema Web para la Gestión y Seguimiento de Casos de Adicciones")
                        .description("API REST para la gestión de usuarios, casos y seguimientos.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Equipo de desarrollo")));
    }
}
