package com.ktc2.precourse.baseball.logic;

import com.ktc2.precourse.baseball.object.Numbers;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DuplicateCheckerTest {

    @Test
    void check() {
        DuplicateChecker<Integer> dc1 = new DuplicateChecker<>();
        for (Integer i: new Integer[]{ 5, 4, 7, 929, 19, 8 }) {
            assertThat(dc1.check(i)).isFalse();
        }
        assertThat(dc1.check(19)).isTrue();

        DuplicateChecker<String> dc2 = new DuplicateChecker<>();
        for (String s: new String[]{ "ab", "abc", "bc", "a", "cd" }) {
            assertThat(dc2.check(s)).isFalse();
        }
        assertThat(dc2.check("abc")).isTrue();

        DuplicateChecker<Numbers> dc3 = new DuplicateChecker<>();
        Numbers[] n = {
                new Numbers(1, 2, 3),
                new Numbers(1, 2, 4),
                new Numbers(5, 6, 8),
                new Numbers(4, 1, 9)
        };

        for (Numbers numbers : n) {
            assertThat(dc3.check(numbers)).isFalse();
        }
        assertThat(dc3.check(new Numbers(1, 2, 3))).isTrue();
    }
}