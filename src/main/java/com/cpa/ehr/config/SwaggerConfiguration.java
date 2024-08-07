package com.cpa.ehr.config;
import static com.google.common.collect.Lists.newArrayList;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("ehr").select()
        		.apis(RequestHandlerSelectors.basePackage("com.cpa.ehr.web.rest")).paths(PathSelectors.ant("/api/rest/*")).build().apiInfo(apiInfo()).useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, newArrayList(new ResponseMessageBuilder().code(500).message("500 message").responseModel(new ModelRef("Error")).build(), new ResponseMessageBuilder().code(403).message("Forbidden!!!!!").build()));
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("EHR API", "API List for the Ehr Application.", "1.0.0", "Terms of service", new Contact("CPA Development Team", "http://www.cloudpointamerica.com", "admin@cloudpointamerica.com"), "License of API", "API license URL", Collections.emptyList());
        return apiInfo;
    }
}
