package com.meli.config;

import com.meli.controller.UiController;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.utils.SpringDocUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Value("${meli.openapi.dev-url}")
    private String devUrl;

    static {
        SpringDocUtils.getConfig().addRestControllers(UiController.class);
    }

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server()
                .url(devUrl)
                .description("Development server for API testing");
        Contact contact = new Contact()
                .name("Dorix")
                .email("dorian.arena@mercadolibre.com")
                .url("https://www.youtube.com/watch?v=xvFZjo5PgG0");
        License mitLicense = new License()
                .name("MIT License")
                .url("https://choosealicense.com/licenses/mit/");
        Info info = new Info()
                .title("Adrift Ship API")
                .version("1.0.0")
                .description("API for managing the Adrift spaceship")
                .termsOfService("https://www.youtube.com/watch?v=xvFZjo5PgG0")
                .contact(contact)
                .license(mitLicense);
        return new OpenAPI()
                .info(info)
                .servers(List.of(devServer))
                .addSecurityItem(new SecurityRequirement().addList("basicAuth"))
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("basicAuth",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("basic")));
    }
}

