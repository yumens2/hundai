package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void calculate() {
        Result result = new Result();

        // 3스트라이크
        result.calculate("123", List.of(1, 2, 3));
        assertTrue(result.isCorrect());
        assertEquals("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료", result.toString());

        // 3볼
        result.calculate("123", List.of(2, 3, 1));
        assertFalse(result.isCorrect());
        assertEquals("3볼", result.toString());

        // 낫싱
        result.calculate("123", List.of(4, 5, 6));
        assertFalse(result.isCorrect());
        assertEquals("낫싱", result.toString());

        // 1스트라이크 1볼
        result.calculate("123", List.of(1, 3, 5));
        assertFalse(result.isCorrect());
        assertEquals("1볼 1스트라이크", result.toString());
    }

    @Test
    void reset() {
        Result result = new Result();
        result.calculate("123", List.of(1, 2, 3));

        result.reset();

        assertFalse(result.isCorrect());
        assertEquals("낫싱", result.toString());
    }
}