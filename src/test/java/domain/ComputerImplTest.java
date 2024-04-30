package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ComputerImplTest {

    @Test
    public void generatedRandomNumbersTest() {
        // given
        Computer computer = new ComputerImpl();

        // when then
        for (int i = 0; i < 1000; i++) {
            List<Integer> randomNums = computer.generateRandomNumbers();
            assertNotEquals(randomNums.get(0), randomNums.get(1));
            assertNotEquals(randomNums.get(0), randomNums.get(2));
            assertNotEquals(randomNums.get(1), randomNums.get(2));
        }
    }

    @Test
    public void checkStrikeTest() {
        // given
        Computer computer = new ComputerImpl();
        List<Integer> randomNums = List.of(1, 2, 3);

        // when
        String userNumsA = "123";
        String userNumsB = "456";
        String userNumsC = "321";
        String userNumsD = "912";

        String resultA = computer.checkStrike(randomNums, userNumsA);
        String resultB = computer.checkStrike(randomNums, userNumsB);
        String resultC = computer.checkStrike(randomNums, userNumsC);
        String resultD = computer.checkStrike(randomNums, userNumsD);

        // then
        assertEquals(resultA, "3스트라이크");
        assertEquals(resultB, "낫싱");
        assertEquals(resultC, "2볼 1스트라이크");
        assertEquals(resultD, "2볼");
    }
}