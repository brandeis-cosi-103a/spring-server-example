package edu.brandeis.cosi103a.springexample.generator;

public class RandomNumberGenerator {
    public int generateRandomNumber(int max) {
        return (int) (Math.random() * max);
    }
}