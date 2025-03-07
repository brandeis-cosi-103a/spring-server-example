package edu.brandeis.cosi103a.springexample.server;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.ImmutableList;

import edu.brandeis.cosi103a.springexample.generator.RandomNumberGenerator;

@RestController
public class AppController {

	private RandomNumberGenerator rng;

	// A "POJO" (Plain Old Java Object) to represent a request for a random number.
	static class RandomRequest {
		private ImmutableList<Integer> maxes;

		public ImmutableList<Integer> getMaxes() {
			return maxes;
		}
		public void setMaxes(ImmutableList<Integer> maxes) {
			this.maxes = maxes;
		}
	}

	// A "POJO" (Plain Old Java Object) to represent a response containing a random number.
	static class RandomResponse {
		private ImmutableList<Integer> numbers;

		public RandomResponse(int[] numbers) {
			this.numbers = ImmutableList.copyOf(Arrays.stream(numbers).boxed().collect(Collectors.toList()));
		}

		public ImmutableList<Integer> getNumbers() {
			return numbers;
		}

		public void setNumbers(ImmutableList<Integer> numbers) {
			this.numbers = numbers;
		}
	}

	public AppController(RandomNumberGenerator rng) {
		this.rng = rng;
	}

	@PostMapping(value = "/generate", consumes = "application/json", produces = "application/json")
	public RandomResponse greeting(@RequestBody RandomRequest request) {
		ImmutableList<Integer> maxes = request.getMaxes();
		int[] builder = new int[maxes.size()];
		for (int i = 0; i < maxes.size(); i++) {
			builder[i] = rng.generateRandomNumber(maxes.get(i));
		}
		return new RandomResponse(builder);
	}
}