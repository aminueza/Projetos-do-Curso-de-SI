package br.edu.cesed.facisa.si.tap.logic;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan(basePackageClasses = {
		PacienteController.class
})

@EnableSwagger2
@EnableAutoConfiguration
public class Application extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("springboot")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/.*"))
                .build();
    }
     
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Prontuário Eletrônico API com REST e Swagger")
                .description("Projeto para disciplina de TAP")
                .contact("amanda.minueza@gmail.com")
                .license("Cesed.br")
                .licenseUrl("http://www.cesed.br/portal/")
                .build();
    }
}
