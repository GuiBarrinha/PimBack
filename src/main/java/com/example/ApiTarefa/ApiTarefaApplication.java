package com.example.ApiTarefa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Documentação API Tarefas",
				version = "1.0",
				description = "Documentação de uso dos endpoints API Tarefas",
				contact = @Contact(name="Guilherme", email="guilhermebarrinhams@gmail.com", url="https://github.com/GuiBarrinha/estagioStefanini")
				)		
		)

public class ApiTarefaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTarefaApplication.class, args);
	}

}
