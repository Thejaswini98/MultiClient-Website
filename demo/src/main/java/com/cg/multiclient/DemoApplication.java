package com.cg.multiclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static springfox.documentation.builders.PathSelectors.regex;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@SpringBootApplication
@EnableSwagger2
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		
	}
	@Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(metadata()).select().paths(regex("/multi_client.*")).build();
    }

 

    @SuppressWarnings("deprecation")
    private ApiInfo metadata() {
        return new ApiInfoBuilder().title("Multiclient Service Application").description("API reference guide for Product Order module of Multiclient Service Application")
                .termsOfServiceUrl("https://www.javamulticlientapps.com/").contact("Thejaswini S").version("2.0").build();    
    }

}
