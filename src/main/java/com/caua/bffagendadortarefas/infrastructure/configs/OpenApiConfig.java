package com.caua.bffagendadortarefas.infrastructure.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("BFF Agendador de Tarefas API")
                        .version("1.0.0")
                        .description("API Backend for Frontend para gerenciamento de usuários e tarefas")
                        .contact(new Contact()
                                .name("Cauã Sean")
                                .email("carreiracaua1@gmail.com")))
                // --- ADD THIS LINE BELOW ---
                .addSecurityItem(new io.swagger.v3.oas.models.security.SecurityRequirement().addList("bearer-jwt"))
                // ---------------------------
                .components(new Components()
                        .addSecuritySchemes("bearer-jwt", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                                .description("JWT token obtained from /usuario/login endpoint")));
    }
}

