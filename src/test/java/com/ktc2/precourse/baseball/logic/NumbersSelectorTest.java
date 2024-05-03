package com.ktc2.precourse.baseball.logic;

import com.ktc2.precourse.baseball.object.Numbers;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersSelectorTest {

    @Test
    void get() {
        for (int i = 0; i < 5000; i++) {
            assertThat(isValid(NumbersSelector.get())).isTrue();
        }
    }

    boolean isValid(Numbers n) {
        DuplicateChecker<Integer> dc = new DuplicateChecker<>();

        for (int i = 0; i < Numbers.LENGTH; i++) {
            if (!(1 <= n.get(i) && n.get(i) <= 9)) {
                return false;
            }
            if (dc.check(n.get(i))) {
                return false;
            }
        }

        return true;
    }
}