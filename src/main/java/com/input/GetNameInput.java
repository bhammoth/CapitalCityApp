package com.input;

import java.util.Scanner;

public class GetNameInput {

    public static String getUserNameInput() {
        //take userinput for name or code(String)
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter country name");

        return myObj.nextLine();  // Read user input
    }

    public static String validateUserNameInput(String userNameInput) {
        if (userNameInput.isEmpty()) {
            throw new IllegalArgumentException("You have to enter a value");

        }
        if (userNameInput.equalsIgnoreCase("exit")) {
            System.exit(28);
        }
        if (userNameInput.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("Numbers are not allowed");
        }

        checkForSpecialChars(userNameInput);

        if (userNameInput.length() > 20) {
            throw new IllegalArgumentException("No more than 20 characters");
        }

        return userNameInput;
    }

    public static void checkForSpecialChars(String userInput) {
        int i = userInput.length();
        int a = 1;
        while (a < i) {
            String c = userInput.substring(i - 1);
            if (c.matches("[$&+,:;=\\\\?@#|/'<>.^*()%!-]")) {
                throw new IllegalArgumentException("Special Characters are not allowed");
            }
            a++;
        }
    }
}
