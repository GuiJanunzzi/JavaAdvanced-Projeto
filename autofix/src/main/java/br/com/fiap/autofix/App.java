package br.com.fiap.autofix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableCaching
@OpenAPIDefinition(info = @Info(title = "API do AutoFix", description = "API do sistema de oficinas AutoFix"))
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
