package com.thinkgem.jeesite.common.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebMvc
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket myDocket() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
		ApiInfo apiInfo = new ApiInfoBuilder().title("API接口文档").description("").contact(new Contact("", "", ""))
				.version("1.0").build();
		docket.apiInfo(apiInfo);
		// 设置只生成被Api这个注解注解过的Ctrl类中有ApiOperation注解的api接口的文档
		docket.enable(true).select().apis(RequestHandlerSelectors.basePackage("com.thinkgem.jeesite.modules")).paths(PathSelectors.any()).build();
		return docket;
	}
}