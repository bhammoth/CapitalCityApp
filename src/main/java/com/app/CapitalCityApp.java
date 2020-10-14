package com.app;

import static com.responses.GetCodeResponses.getCodePayload;
import static com.responses.GetNameResponses.getNamePayload;

/**
 * Using the provide REST service, create a program that returns, at minimum, capital city based on user input for name or code.
 * Write several tests that validate positive and negative scenario’s
 * User input can be done in any format, including but not limited to prompts and console entries.
 * Program must continue running until the user exits the program.
 * Note: Do not use any other web services or data other then the one provide.
 * https://restcountries.eu/#similar-projects
 **/
public class CapitalCityApp {

    public static void main(String[] args) {
        while(true) {
            System.out.println("Enter 'exit' when you are finish using the app");
            getCodePayload("https://restcountries.eu/rest/v2/alpha/");
            getNamePayload("https://restcountries.eu/rest/v2/name/");
        }
    }
}
