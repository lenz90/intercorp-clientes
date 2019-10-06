package com.intercorp.lizardo.intercorpclientes.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final Contact DEFAULT_CONTACT = new Contact("Lizardo Enrique Mamani Sanchez",
            "https://github.com/lenz90",
            "lenz.90@gmail.com");

    @SuppressWarnings("rawtypes")
    public static final ApiInfo DEFAULT_API_INFO
            = new ApiInfo("Api Clientes Documentación",
            "Api para la creacion y visualizacion de los datos de clientes",
            "1.0", "PRIMIUM", DEFAULT_CONTACT, "Apache 2.0",
            "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                /*.select()
                .apis(RequestHandlerSelectors.basePackage("com.intercorp.lizardo.intercorpclientes.infrastructure.controller"))
                .paths(PathSelectors.any())
                .build()*/
                .apiInfo(DEFAULT_API_INFO);
    }
}
