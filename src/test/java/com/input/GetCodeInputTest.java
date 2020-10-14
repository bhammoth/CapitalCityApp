package com.input;

import org.junit.Test;
import org.junit.gen5.api.DisplayName;

import static com.assertions.ExitAssertions.assertExits;
import static com.input.GetCodeInput.validateUserCodeInput;
import static com.input.GetNameInput.validateUserNameInput;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GetCodeInputTest {

    @DisplayName("Validate if user enters 'exit' as code that program ends with no exception")
    @Test
    public void validateUserCodeInputTestExit() {
        assertExits(27, () -> validateUserCodeInput("exit"));
    }

    @DisplayName("Validate if user enters a number user get correct error message")
    @Test
    public void validateUserCodeInputTestNumber() {
        String expectedSevereMessage = "Numbers are not allowed";
        Throwable exceptionThatWasThrown = assertThrows(IllegalArgumentException.class, () -> validateUserCodeInput("1"));

        assertThat(exceptionThatWasThrown.getMessage(), equalTo(expectedSevereMessage));
    }

    @DisplayName("Validate if user enters more than 3 characters user gets correct error message")
    @Test
    public void validateUserCodeInputTestLength() {
        String expectedSevereMessage = "No more than 3 characters";
        Throwable exceptionThatWasThrown = assertThrows(IllegalArgumentException.class, () -> validateUserCodeInput("aaaa"));

        assertThat(exceptionThatWasThrown.getMessage(), equalTo(expectedSevereMessage));
    }

    @DisplayName("Empty input")
    @Test
    public void validateUserCodeInputTestEmpty() {
        String expectedSevereMessage = "You have to enter a value";
        Throwable exceptionThatWasThrown = assertThrows(IllegalArgumentException.class, () -> validateUserCodeInput(""));

        assertThat(exceptionThatWasThrown.getMessage(), equalTo(expectedSevereMessage));
    }

    @DisplayName("Validate if user enters a special user gets correct error message")
    @Test
    public void validateUserCodeInputTestChars() {
        String expectedSevereMessage = "Special Characters are not allowed";
        Throwable exceptionThatWasThrown = assertThrows(IllegalArgumentException.class, () -> validateUserNameInput("****"));

        assertThat(exceptionThatWasThrown.getMessage(), equalTo(expectedSevereMessage));
    }

}
