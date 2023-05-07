package com.gulliver.projeto.usuario.projetogulliverusuario.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("API Projeto Gulliver")
                        .description("Projeto Gulliver - API - Usuários")
                        .termsOfService("terms")
                        .license(new License().name("GNU"))
                        .version("1.0")
                );
    }
}