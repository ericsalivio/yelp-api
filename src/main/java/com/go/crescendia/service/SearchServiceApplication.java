package com.go.crescendia.service;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;



@SpringBootApplication
public class SearchServiceApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SearchServiceApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder application) {
        return application.sources(SearchServiceApplication.class);
    }

    @Bean
    Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.go.crescendia.service.resource"))
                .paths(paths())
                .build();
    }

     Predicate<String> paths() {

        return Predicates.and(
                PathSelectors.regex("/.*"),
                Predicates.not(PathSelectors.regex("/error.*")));
    }


     ApiInfo apiInfo() {
        return new ApiInfo(
                "Search Service API",
                "Search Service API",
                "Search Service API 1.0",
                "Terms of service",
                "Eric Jason C. Salivio",
                "ericsalivio.ccs@gmail.com",
                "sample-url.com");
    }

}
