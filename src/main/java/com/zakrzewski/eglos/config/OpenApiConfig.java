package com.zakrzewski.eglos.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    public OpenApiConfig() {
    }

    @Bean
    public OpenAPI apiConfig() {
        return new OpenAPI()
                .info(new Info()
                        .title("eGłos - bezpieczny głos")
                        .contact(buildContactModel())
                        .version("1.0.0")
                        .description("REST Api Dokumentacja"));
    }

    private Contact buildContactModel() {
        return new Contact()
                .name("Michał Zakrzewski")
                .email("michal.zakrzewsky@gmail.com")
                .url("https://github.com/michalzakrzewski");
    }
}
