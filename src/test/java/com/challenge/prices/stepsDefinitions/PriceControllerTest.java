package com.challenge.prices.stepsDefinitions;

import com.challenge.prices.application.infrastucture.dto.PriceDTO;
import com.challenge.prices.application.infrastucture.dto.PriceSearchDTO;
import com.challenge.prices.application.utils.DateUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PriceControllerTest {

    @LocalServerPort
    private int port;

    private PriceSearchDTO priceSearchDTO = new PriceSearchDTO();

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

    @When("execute a post request")
    public void execute_a_post_request() {
        request = given().port(port).log().all().header("Content-Type","application/json");
        response = request.when().body(priceSearchDTO).post("/prices");
    }

    @Then("The System returns a {int} HTTP Response and prices is {double}")
    public void the_system_returns_a_created_http_response(int status, Double price) {
        Assert.assertEquals(status, response.getStatusCode());
        if (response.getStatusCode() == HttpStatus.OK.value()) {
            PriceDTO currentPrice = response.then().extract().body().as(PriceDTO.class);
            Assert.assertEquals((new BigDecimal(price)).setScale(2, RoundingMode.HALF_EVEN), currentPrice.getPrice());
        }
    }

    @Given("A search with {int}, {long}, {string}")
    public void a_transaction_with(int brandId, Long productId, String date) throws ParseException {
        priceSearchDTO.setBrandId(brandId);
        priceSearchDTO.setProductId(productId);
        priceSearchDTO.setDate(DateUtils.getDateFromString(date));
    }

}
