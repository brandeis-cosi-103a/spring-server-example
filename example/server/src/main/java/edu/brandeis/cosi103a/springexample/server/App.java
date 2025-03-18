package edu.brandeis.cosi103a.springexample.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

	/**
	* To test:
	* curl -X POST -H "Content-Type: application/json" -d '{"maxes": [500, 10]}' http://localhost:8080/generate
	*/
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}