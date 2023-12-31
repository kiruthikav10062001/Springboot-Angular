package org.virtusa.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
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
	public Docket customerApi() {
		Docket docket=new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				.select().apis(RequestHandlerSelectors.basePackage("org.virtusa.spring.controller"))
				.build();
		return docket;
	}
	private ApiInfo apiInfo() {
		ApiInfo apiInfo=new ApiInfoBuilder().description("Boxing Api")
				.contact(new Contact("Boxing Api","http://www.fakeapi.com","fake@gmail.com"))
				.license("customer Licence").licenseUrl("http://www.fakeapi.com")
				.build();
		return apiInfo;
	}
}
