package org.dxc.swagger.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket swaggerConfiguration() { 
		  return new Docket(DocumentationType.SWAGGER_2) 
		    .select() 
		    .paths(PathSelectors.ant("/api/**")) 
		    .apis(RequestHandlerSelectors.basePackage("org.dxc.swagger"))     
		    .build() 
		    .apiInfo(apiDetails()); 
		 } 
	private ApiInfo apiDetails() { 
		  return new ApiInfo( 
		    "Topic API", 
		    "Topic API for Swagger Tutorial", 
		    "1.0", 
		    "Free to Use", 
		    new springfox.documentation.service.Contact("Abdul Muhaimin", "http://www.topic.com", "muhaimindgp@gmail.com"), 
		    "API License", 
		    "http://www.topic.com", 
		    Collections.emptyList()); 
		 }    
}