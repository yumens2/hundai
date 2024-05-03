package com.ktc2.precourse.baseball.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class NumbersValidatorTest {
    static final String[] fails = {
            null, //null test
            "a33", "5사1", "1b9", "3a2", //not digit test
            "1", "12", "y", //less length test
            "1234", "17234", //long length test
            "112", "133", "558", //duplicate test
            "103", "084", "810" //include zero test
    };

    NumbersValidator v;

    @BeforeEach
    void setUp() {
        v = NumbersValidator.getInstance();
    }

    @Test
    void isValid() {
        //valid test
        //가능한 모든 3자리 숫자에 대해 테스트함
        String s = "123456789";
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < 9; k++) {
                    if (k == j || k == i) {
                        continue;
                    }
                    assertThat(v.isValid("" + s.charAt(i) + s.charAt(j) + s.charAt(k))).isTrue();
                }
            }
        }

        //invalid test
        for (String f: fails) {
            assertThat(v.isValid(f)).isFalse();
        }

    }
}