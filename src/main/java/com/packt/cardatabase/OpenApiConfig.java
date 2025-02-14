package com.packt.cardatabase;

import io.swagger.v3.oas.models.servers.Server;
import jakarta.servlet.ServletContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import java.util.List;

@Configuration
public class OpenApiConfig {
  @Bean
  public OpenAPI carDatabaseOpenAPI(ServletContext servletContext) {
    Server server = new Server().url(servletContext.getContextPath());
    return new OpenAPI()
        .info(new Info().title("Car REST API").description("My car stock").version("1.0"))
        .servers(List.of(server));
  }
}
