package com.challenge.prices.stepsDefinitions;

import com.challenge.prices.application.infrastucture.dto.PriceDTO;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PriceControllerTest {

    @LocalServerPort
    private int port;

    private RequestSpecification request;
    private Response response;

    @Given("A request")
    public void a_request() {
        request = given().port(port).log().all().header("Content-Type","application/json");
    }

    @Then("The System returns a list of prices")
    public void the_system_returns_a_list_of_prices() {
        response = request.when().get("/prices");
        List<PriceDTO> list = response.then().extract().body().jsonPath().getList(".",PriceDTO.class);
        Assert.assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        Assert.assertFalse(list.isEmpty());
    }

    @Then("The System returns a HTTP Response with {int}")
    public void the_system_returns_a_created_http_response(int status) {
        Assert.assertEquals(status, response.getStatusCode());
    }

}
