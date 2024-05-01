package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberComparatorTest {

    @Test
    void compare_3strike() {
        String input = "123";
        String answer = "123";

        System.out.println(NumberComparator.compare(input, answer)); // [3 스트라이크]

        assertEquals(3, NumberComparator.compare(input, answer).get(0).getCount());
        assertEquals("스트라이크", NumberComparator.compare(input, answer).get(0).getJudgement());
    }

    @Test
    void compare_1strike_2ball() {
        String input = "132";
        String answer = "123";

        System.out.println(NumberComparator.compare(input, answer));

        assertEquals(2, NumberComparator.compare(input, answer).get(0).getCount());
        assertEquals("볼", NumberComparator.compare(input, answer).get(0).getJudgement());

        assertEquals(1, NumberComparator.compare(input, answer).get(1).getCount());
        assertEquals("스트라이크", NumberComparator.compare(input, answer).get(1).getJudgement());
    }

    @Test
    void compare_2ball() {
        String input = "314";
        String answer = "123";

        System.out.println(NumberComparator.compare(input, answer));

        assertEquals(2, NumberComparator.compare(input, answer).get(0).getCount());
        assertEquals("볼", NumberComparator.compare(input, answer).get(0).getJudgement());
    }

    @Test
    void compare_nothing() {
        String input = "456";
        String answer = "123";

        System.out.println(NumberComparator.compare(input, answer));

        assertEquals(1, NumberComparator.compare(input, answer).get(0).getCount());
        assertEquals("낫싱", NumberComparator.compare(input, answer).get(0).getJudgement());
    }
}