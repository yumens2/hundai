package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class BaseballGameTest {

    @Test //요구사항 1. 컴퓨터는 1~9 까지의 서로 다르면서, 랜덤한 수를 3개 뽑아야 한다.
    void playBaseballGame() {
        BaseballGame baseballGame = new BaseballGame();
        int[] randomComNumbers = baseballGame.getComputerThreeNum();

        assertEquals(3, randomComNumbers.length);
        assertTrue(IntStream.of(randomComNumbers).allMatch(num -> num > 0 && num < 10)); //컴퓨터 랜덤 수 배열의 int Stream의 모든 원소가 1~9 일때만 true
        assertEquals(3, IntStream.of(randomComNumbers).distinct().count()); //컴퓨터 랜덤 수 배열의 int Stream의 서로 다른 원소의 count의 수가 3일때 통과
    }


}