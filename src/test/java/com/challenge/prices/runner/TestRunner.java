package com.challenge.prices.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.challenge.prices.stepsDefinitions", "CucumberSpringConfiguration"}
)
public class TestRunner {
}
