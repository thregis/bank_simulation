package com.example.bank_simulation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.bank_simulation.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo());
}

    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Bank Simulation project",
                "Simulation Rest API",
                "1.0",
                "Terms of Service",
                new Contact("Thiago Regis", null, "..."),
                "License",
                "url", new ArrayList<>()
        );
        return apiInfo;
    }
    }
//http://localhost:8080/swagger-ui/index.html#/
// //// http://localhost:8080/v2/api-docs