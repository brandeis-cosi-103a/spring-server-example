package edu.brandeis.cosi103a.springexample.server;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.brandeis.cosi103a.springexample.generator.RandomNumberGenerator;

@RestController
public class AppController {

	private RandomNumberGenerator rng;

	// A "POJO" (Plain Old Java Object) to represent a request for a random number.
	static class RandomRequest {
		private int max;
		public int getMax() {
			return max;
		}
		public void setMax(int max) {
			this.max = max;
		}
	}

	// A "POJO" (Plain Old Java Object) to represent a response containing a random number.
	static class RandomResponse {
		private int number;

		public RandomResponse(int number) {
			this.number = number;
		}

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}
	}

	public AppController(RandomNumberGenerator rng) {
		this.rng = rng;
	}

    @PostMapping(value = "/generate", consumes = "application/json", produces = "application/json")
	public RandomResponse greeting(@RequestBody RandomRequest request) {
		return new RandomResponse(rng.generateRandomNumber(request.getMax()));
	}
}