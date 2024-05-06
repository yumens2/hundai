import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ComputerTest {
    // 난수 생성 점검
    @Test
    public void testMakeRandomNumber() {
        String number = Computer.makeRandomNumber();
        assertTrue(number.matches("\\d{3}")); // 3자리 숫자인지 확인
        assertTrue(number.chars().distinct().count() == 3); // 중복 숫자가 없는지 확인
    }

    // 스트라이크, 볼 계산 점검
    @Test
    public void testCheckScore_AllStrikes() {
        char[] answer = {'1', '2', '3'};
        char[] guess = {'1', '2', '3'};
        int[] vis = {0, 1, 1, 1, 0, 0, 0 ,0, 0 ,0};
        int[] score = Computer.checkScore(answer, guess, vis);
        assertArrayEquals(new int[]{3, 0}, score); // 3 스트라이크, 0 볼
    }

    @Test
    public void testCheckScore_NoMatches() {
        char[] answer = {'1', '2', '3'};
        char[] guess = {'4', '5', '6'};
        int[] vis = {0, 1, 1, 1, 0, 0, 0 ,0, 0 ,0};
        int[] score = Computer.checkScore(answer, guess, vis);
        assertArrayEquals(new int[]{0, 0}, score); // 낫싱
    }

    @Test
    public void testCheckScore_Mixed() {
        char[] answer = {'1', '2', '3'};
        char[] guess = {'3', '2', '1'};
        int[] vis = {0, 1, 1, 1, 0, 0, 0 ,0, 0 ,0};
        int[] score = Computer.checkScore(answer, guess, vis);
        assertArrayEquals(new int[]{1, 2}, score); // 1 스트라이크, 2 볼
    }
}
