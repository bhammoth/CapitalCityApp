package com.responses;

import org.junit.Test;
import org.junit.gen5.api.DisplayName;

import static com.responses.GetCodeResponses.validateCodePayload;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GetCodeResponsesTest {
    @DisplayName("Validate response code 200 is without exception")
    @Test
    public void validateCodePayload200() {
        validateCodePayload(200);
    }

    @DisplayName("Validate response code 404 returns expected exception")
    @Test
    public void validateCodePayload404() {
        String expectedSevereMessage = "No capital city can be found by that code";
        Throwable exceptionThatWasThrown = assertThrows(RuntimeException.class, () -> validateCodePayload(404));

        assertThat(exceptionThatWasThrown.getMessage(), equalTo(expectedSevereMessage));
    }

    @DisplayName("Validate response code 400 returns expected exception")
    @Test
    public void validateCodePayload400(){
        String expectedSevereMessage = "Please check your input and try again";
        Throwable exceptionThatWasThrown = assertThrows(RuntimeException.class, () -> validateCodePayload(400));

        assertThat(exceptionThatWasThrown.getMessage(), equalTo(expectedSevereMessage));
    }

    @DisplayName("Validate response code 500 returns expected exception")
    @Test
    public void validateCodePayload500() {
        String expectedSevereMessage = "You have encountered an unknown error";
        Throwable exceptionThatWasThrown = assertThrows(RuntimeException.class, () -> validateCodePayload(500));

        assertThat(exceptionThatWasThrown.getMessage(), equalTo(expectedSevereMessage));
    }
}
