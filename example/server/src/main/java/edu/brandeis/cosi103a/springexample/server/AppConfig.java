package edu.brandeis.cosi103a.springexample.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import edu.brandeis.cosi103a.springexample.generator.RandomNumberGenerator;

@Configuration
public class AppConfig {

    /**
     * This class lets Spring know that it can create a new instance of RandomNumberGenerator
     * and inject it into any class that needs it.
     *
     * Alternatively, RandomNumberGenerator could be annotated with @Component, which would
     * make it a Spring-managed bean, but that would require adding a Spring dependency to the
     * generator package.
     */
    @Bean
    public RandomNumberGenerator randomNumberGenerator() {
        return new RandomNumberGenerator();
    }
}