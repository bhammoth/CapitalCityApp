package com.input;

import org.junit.Test;
import org.junit.gen5.api.DisplayName;

import static com.assertions.ExitAssertions.assertExits;
import static com.input.GetNameInput.validateUserNameInput;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GetNameInputTest {

    @DisplayName("Validate if user enters 'exit' as code that program ends with no exception")
    @Test
    public void validateUserNameInputTestExit(){
        assertExits(28, () -> validateUserNameInput("exit"));
    }

    @DisplayName("Validate if user enters a number user gets correct error message")
    @Test
    public void validateUserNameInputTestNumber() {
        String expectedSevereMessage = "Numbers are not allowed";
        Throwable exceptionThatWasThrown = assertThrows(IllegalArgumentException.class, () -> validateUserNameInput("1"));

        assertThat(exceptionThatWasThrown.getMessage(), equalTo(expectedSevereMessage));
    }

    @DisplayName("Validate if user enters a special user gets correct error message")
    @Test
    public void validateUserNameInputTestSpecialChars() {
        String expectedSevereMessage = "Special Characters are not allowed";
        Throwable exceptionThatWasThrown = assertThrows(IllegalArgumentException.class, () -> validateUserNameInput("****"));

        assertThat(exceptionThatWasThrown.getMessage(), equalTo(expectedSevereMessage));
    }

}
