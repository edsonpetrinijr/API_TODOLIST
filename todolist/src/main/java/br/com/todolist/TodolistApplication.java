package br.com.todolist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class TodolistApplication {
	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

	@Bean
	CommandLineRunner criarTarefasFake(TodoRepository todoRepository) {
		return args -> {
			todoRepository.deleteAll();

			Todo todo1 = new Todo(
					"Configurar JDK",
					"Preciso aprender a configurar o JDK corretamente",
					StatusEnum.NOT_STARTED
			);
			Todo todo2 = new Todo(
					"Estudar Java",
					"Estudar Java para aprender programação",
					StatusEnum.IN_PROGRESS
			);
			Todo todo3 = new Todo(
					"Estudar HTML",
					"Estudar HTML para desenvolver sites",
					StatusEnum.FINISHED
			);

			todoRepository.save(todo1);
			todoRepository.save(todo2);
			todoRepository.save(todo3);
		};
	}
}
