package com.xlkj.website.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration // 启动时就要加载
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket createRestApi() {
		ParameterBuilder ticketPar = new ParameterBuilder();
		List<Parameter> pars = new ArrayList<Parameter>();
		ticketPar.name("Authorization").description("token")
				.modelRef(new ModelRef("string")).parameterType("header")
				.required(false).build(); //header中的ticket参数非必填，传空也可以
		pars.add(ticketPar.build());    //根据每个方法名也知道当前方法在设置什么参数
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("auth")
				.genericModelSubstitutes(DeferredResult.class)
				.useDefaultResponseMessages(false)
				.apiInfo(apiInfo())
				.pathMapping("/")
				.select()
				.apis(RequestHandlerSelectors.basePackage("auth.controller"))
				.paths(PathSelectors.any())
				.build()
				.globalOperationParameters(pars);

	}

	private ApiInfo apiInfo(){

		return new ApiInfoBuilder().title("用户权限API接口")
				.description("swagger用户权限API接口")
				.termsOfServiceUrl("http://www.zkkjgs.com/")
				.version("1.0").build();
	}
}
