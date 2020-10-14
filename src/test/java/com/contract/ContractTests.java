package com.contract;

import io.restassured.RestAssured;
import org.junit.Test;
import org.junit.gen5.api.DisplayName;

public class ContractTests {

    @DisplayName("Test to verify 200 is returned when given a valid code")
    @Test
    public void validCode() {
        String path = "https://restcountries.eu/rest/v2/alpha/co";
        RestAssured.get(path).then().statusCode(200);
    }

    @DisplayName("Test to verify 200 is returned when given a valid name")
    @Test
    public void validName() {
        String path = "https://restcountries.eu/rest/v2/name/united";
        RestAssured.get(path).then().statusCode(200);
    }

    @DisplayName("Test to verify 400 is returned when given a invalid code")
    @Test
    public void invalidCodeBadRequest() {
        String path = "https://restcountries.eu/rest/v2/alpha/1";
        RestAssured.get(path).then().statusCode(400);
    }

    @DisplayName("Test to verify 404 is returned when given a invalid name")
    @Test
    public void invalidNameNotFound() {
        String path = "https://restcountries.eu/rest/v2/name/1";
        RestAssured.get(path).then().statusCode(404);

    }

    @DisplayName("Test to verify 404 is returned when given a invalid code")
    @Test
    public void invalidCodeNotFound() {
        String path = "https://restcountries.eu/rest/v2/alpha/asz";
        RestAssured.get(path).then().statusCode(404);
    }
}
