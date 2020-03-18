package com.oddchecker.oddsrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.oddchecker.oddsrestapi.controller.OddController;
import com.oddchecker.oddsrestapi.entity.Odd;

import io.swagger.annotations.Contact;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;



@SpringBootApplication
@EnableSwagger2WebMvc
public class OddsRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OddsRestApiApplication.class, args);
	}

}
