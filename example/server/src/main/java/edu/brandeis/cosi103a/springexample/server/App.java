package edu.brandeis.cosi103a.springexample.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.databind.Module;

@SpringBootApplication
public class App {

	/**
	 * To test:
	 * curl -X POST -H "Content-Type: application/json" -d '{"max": 500}' http://localhost:8080/generate
	 */
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	/**
	 * This registers the Guava module with the Jac
	 * kson JSON mapper.
	 * This allows Jackson to serialize and deserialize Guava types,
	 * such as ImmutableList.
	 */
	@Bean
	public Module guavaModule() {
      return new GuavaModule();
  }
}