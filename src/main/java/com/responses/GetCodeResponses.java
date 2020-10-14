package com.responses;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static com.input.GetCodeInput.getUserCodeInput;
import static com.input.GetCodeInput.validateUserCodeInput;

public class GetCodeResponses {

    public static void getCodePayload(String path) {
        String code;
        try {
            code = validateUserCodeInput(getUserCodeInput());
            Response codeResponse = RestAssured.get(path + code);
            printCapitalCodeResponse(codeResponse);
            validateCodePayload(codeResponse.statusCode());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printCapitalCodeResponse(Response codeResponse){
        if(codeResponse.statusCode() == 200){
            String capital = codeResponse.jsonPath().get("capital");
            System.out.println(capital);
        }
    }

    public static void validateCodePayload(int codeResponse){
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
