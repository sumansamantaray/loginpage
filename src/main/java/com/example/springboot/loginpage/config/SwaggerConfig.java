/**
 * 
 */
package com.example.springboot.loginpage.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author samasu5
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/*@Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("public-api")
                .apiInfo(apiInfo())
                .select()
                .paths(postPaths())
                .build();
    }

    private Predicate<String> postPaths() {
        return or(
                regex("/api/posts.*"),
                regex("/api/comments.*")
        );
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringMVC Example API")
                .description("SpringMVC Example API reference for developers")
                .termsOfServiceUrl("http://suman.blogspot.com")
                .contact("Suman Samantaray")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
                .version("2.0")
                .build();
    }*/
	
	public static final Contact DEFAULT_CONTACT = new Contact(
		      "Suman Samantaray", "http://www.loginpage.com", "suman.samantaray@suman.com");
		  
		  public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Login Page", "Login page application", "2.0", "URL", DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", Collections.EMPTY_LIST);
				  /*new ApiInfo(
		      "Awesome API Title", "Awesome API Description", "1.0",
		      "urn:tos", DEFAULT_CONTACT, 
		      "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");*/

		  private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = 
		      new HashSet<String>(Arrays.asList("application/json",
		          "application/xml"));

		  @Bean
		  public Docket api() {
		    return new Docket(DocumentationType.SWAGGER_2)
		        .apiInfo(DEFAULT_API_INFO)
		        .produces(DEFAULT_PRODUCES_AND_CONSUMES)
		        .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
		  }
}
