package org.petka.modules;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {

		ApiInfo apiInfo = new ApiInfo("Spring boot microservices aggregator.",
				"Spring boot microservices aggregator with swagger documentation.", "Version 0.0.1-SNAPSHOT",
				"Terms of service",
				new Contact("Petka", "https://github.com/petka5/SpringMS", "petar.georgiev@gmail.com"),
				"License of the API", "API license URL", Collections.emptyList());

		return apiInfo;
	}
}
