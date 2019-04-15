package com.valtech.carassignment.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
    public Docket productApi() {
    	  return new Docket(DocumentationType.SWAGGER_2)
                  .select().apis(RequestHandlerSelectors.basePackage("com.valtech.carassignment"))
                  .paths(regex("/reservations.*"))
                  .paths(PathSelectors.ant("/reservations/*"))
                  .build()
                  .apiInfo(metaData());
    }
	
	  private ApiInfo metaData() {
	        return new ApiInfoBuilder()
	                .title("TEST DRIVE VALTECH")
	                .description("Aplicacion que permite la reservas y cancelaciones para probar el nuevo prototipo de nuestro auto")
	                .version("1.0")
	                .licenseUrl("")
	                .contact(new Contact("Pablo Ilich",
	                		"https://github.com/pabloilich/valtech-Testdrive", 
	                		"pablo.ilich@gmail.com"))
	                .build();
	    }
}
