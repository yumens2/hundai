package service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

class GameServiceTest {

    private final GameService gameService;

    public GameServiceTest() {
        this.gameService = new GameService(new RandomGenerator());
    }

    @Test
    void nonIntegerInputTest() {
        InputStream in = System.in;
        String input = "문자열 입력\n";
        GameService.setScanner(new Scanner(new ByteArrayInputStream(input.getBytes())));

        assertThrowsExactly(IllegalArgumentException.class,
            () -> gameService.getInput());

        System.setIn(in);
    }

    @Test
    void wrongInputTest() {
        assertThrowsExactly(IllegalArgumentException.class,
            () -> gameService.checkingCondition(0));
        assertThrowsExactly(IllegalArgumentException.class,
            () -> gameService.checkingCondition(111));
        assertThrowsExactly(IllegalArgumentException.class,
            () -> gameService.checkingCondition(1234));
    }

    @Test
    void answerTest() {
        assertTrue(gameService.isAnswered(gameService.compareNumbers
            (new int[]{1, 2, 3}, new int[]{1, 2, 3}))); //정답
        assertFalse(gameService.isAnswered(gameService.compareNumbers
            (new int[]{1, 2, 3}, new int[]{1, 2, 4}))); //정답 아님
    }

    @Test
    void hintCaseTest() {
        assertTrue(gameService.compareNumbers(
            new int[]{1, 2, 3}, new int[]{1, 4, 5}).hasStrikes()); //스트라이크
        assertTrue(gameService.compareNumbers(
            new int[]{1, 2, 3}, new int[]{2, 3, 1}).hasBalls()); //볼
        assertTrue(gameService.compareNumbers(
            new int[]{1, 2, 3}, new int[]{1, 3, 2}).hasStrikesAndBalls()); //스트라이크 & 볼
        assertTrue(gameService.compareNumbers(
            new int[]{1, 2, 3}, new int[]{4, 5, 6}).hasNothing()); //낫씽
    }


}