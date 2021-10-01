package com.crud.java.entrypoint.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Orange Stack")
                .version("1.0,0")
                .license("Lincença: GPLv3")
                .licenseUrl("https://www.gnu.org/licenses/gpl-3.0.html")
                .contact(new Contact("Orange Stack", "Orange Stack",
                        "OrangeStack@OrangeStack.com"))
                .build();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .tags(new Tag("Product", "Product Management API."))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.crud.java.entrypoint.controller"))
                .paths(PathSelectors.any())
                .build();
    }

}
