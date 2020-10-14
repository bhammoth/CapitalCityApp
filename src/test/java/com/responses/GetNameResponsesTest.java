package com.responses;

import org.junit.Test;
import org.junit.gen5.api.DisplayName;

import static com.responses.GetNameResponses.validateNamePayload;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GetNameResponsesTest {
    @DisplayName("Validate response code 200 is without exception")
    @Test
    public void validateCodePayload200() {
        validateNamePayload(200);
    }

    @DisplayName("Validate exception and message for 404 status code")
    @Test
    public void validateNamePayload404() {

        String expectedSevereMessage = "No capital city can be found by that code";
        Throwable exceptionThatWasThrown = assertThrows(RuntimeException.class, () -> validateNamePayload(404));

        assertThat(exceptionThatWasThrown.getMessage(), equalTo(expectedSevereMessage));
    }

    @DisplayName("Validate exception and message for 400 status code")
    @Test
    public void validateNamePayload400() {
        String expectedSevereMessage = "Please check your input and try again";
        Throwable exceptionThatWasThrown = assertThrows(RuntimeException.class, () -> validateNamePayload(400));

        assertThat(exceptionThatWasThrown.getMessage(), equalTo(expectedSevereMessage));
    }

    @DisplayName("Validate exception and message for 500 status code")
    @Test
    public void validateNamePayloadNot500() {
        String expectedSevereMessage = "You have encountered an unknown error";
        Throwable exceptionThatWasThrown = assertThrows(RuntimeException.class, () -> validateNamePayload(500));

        assertThat(exceptionThatWasThrown.getMessage(), equalTo(expectedSevereMessage));
    }
}
