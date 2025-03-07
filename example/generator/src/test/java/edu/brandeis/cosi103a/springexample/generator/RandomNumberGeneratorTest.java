package edu.brandeis.cosi103a.springexample.generator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest
{
    @Test
    public void testNumbers() {
        RandomNumberGenerator rng = new RandomNumberGenerator();
        int number = rng.generateRandomNumber(500);
        assertTrue(number >= 0 && number < 500);
    }
}
