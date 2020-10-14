package com.responses;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;
import java.util.logging.Logger;

import static com.input.GetNameInput.getUserNameInput;
import static com.input.GetNameInput.validateUserNameInput;

public class GetNameResponses {
    private final static Logger LOGGER = Logger.getLogger(GetNameResponses.class.getName());

    public static void getNamePayload(String path) {
        String name;

        try {
            name = validateUserNameInput(getUserNameInput());
            Response nameResponse = RestAssured.get(path + name);
            printCapitalNameResponse(nameResponse);
            validateNamePayload(nameResponse.statusCode());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printCapitalNameResponse(Response nameResponse) {
        if (nameResponse.statusCode() == 200) {
            //return capital cities
            List<String> capital = nameResponse.jsonPath().getList("capital");
            System.out.println(capital);
        }
    }

    public static void validateNamePayload(int codeResponse) {
        if (codeResponse == 404) {
            throw new RuntimeException("No capital city can be found by that code");
        }
        if (codeResponse == 400) {
            throw new RuntimeException("Please check your input and try again");
        } else if (codeResponse == 500) {
            throw new RuntimeException("You have encountered an unknown error");

        }
    }
}
