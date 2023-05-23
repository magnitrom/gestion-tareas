package com.gestiontareas;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {

	@Value("${paquete.servicios}")
	String paqueteApis;
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.OAS_30)  
        .select()                                       
        .apis(RequestHandlerSelectors.basePackage(paqueteApis))
        .paths(PathSelectors.any())                     
        .build()
        .apiInfo(apiInfo());                                        
    }
	
    public ApiInfo apiInfo() { 
        return new ApiInfoBuilder()
            .title("API Administracion de Gestion de Tareas")
            .description(
                "Api que realiza la adiministracion de la gestion de tareas.")
            .version("1.0.0")
            .build();                                        
    }
}
