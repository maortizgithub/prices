package com.challenge.prices.stepsDefinitions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@ActiveProfiles("test")
@CucumberContextConfiguration
@SpringBootTest(classes = com.challenge.prices.PricesApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = com.challenge.prices.PricesApplication.class,
        loader = SpringBootContextLoader.class)
public class CucumberSpringConfiguration {

}
