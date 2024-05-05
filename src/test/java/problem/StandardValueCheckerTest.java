package problem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StandardValueCheckerTest {
    private StandardValueChecker checker;

    @BeforeEach
    void setUp() {
        // 문제 값 "123"로 StandardValueChecker 인스턴스를 생성
        checker = new StandardValueChecker("123");
    }

    @Test
    void testAllStrikes() {
        // 모든 숫자와 위치가 일치할 때 (3 스트라이크)
        assertEquals("3 STRIKE", checker.determineTheValue("123"));
    }

    @Test
    void testAllBalls() {
        // 숫자는 일치하지만 위치가 다를 때 (3 볼)
        assertEquals("3 BALL", checker.determineTheValue("312"));
    }

    @Test
    void testStrikesAndBalls() {
        // 일부 숫자와 위치가 일치할 때 (1 스트라이크 1 볼)
        assertEquals("1 STRIKE 1 BALL", checker.determineTheValue("152"));
    }

    @Test
    void testNothing() {
        // 숫자와 위치가 전혀 일치하지 않을 때 (낫싱)
        assertEquals("NOTHING", checker.determineTheValue("456"));
    }
}