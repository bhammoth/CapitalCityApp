package com.input;

import java.util.Scanner;

import static com.input.GetNameInput.checkForSpecialChars;

public class GetCodeInput {
    public static String getUserCodeInput() {

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter country code");

        return myObj.nextLine();  // Read user input
    }

    public static String validateUserCodeInput(String userCodeInput) {
        if (userCodeInput.isEmpty()) {
            throw new IllegalArgumentException("You have to enter a value");

        }
        if (userCodeInput.equalsIgnoreCase("exit")) {
            System.exit(27);
        }
        if (userCodeInput.length() > 3) {
            throw new IllegalArgumentException("No more than 3 characters");
        }

        if (userCodeInput.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("Numbers are not allowed");

        }
        checkForSpecialChars(userCodeInput);

        return userCodeInput;
    }
}
