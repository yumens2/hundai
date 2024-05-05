package com.ktc2.precourse.baseball.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RetryValidatorTest {
    static RetryValidator v = RetryValidator.getInstance();

    @Test
    void isValid() {
        assertThat(v.isValid("1")).isTrue();
        assertThat(v.isValid("2")).isTrue();

        String[] fails = {
                null, "", "12", "a", "123", "21", "8", "exit"
        };

        for (String f: fails) {
            assertThat(v.isValid(f)).isFalse();
        }
    }
}