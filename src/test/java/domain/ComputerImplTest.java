package domain;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;


public class ComputerImplTest {

    @Test
    public void generatedRandomNumbersTest() {
        // given
        Computer computer = new ComputerImpl();

        // when then
        for (int i = 0; i < 1000; i++) {
            List<Integer> randomNums = computer.generateRandomNumbers();
            assertThat(randomNums.get(0)).isNotEqualTo(randomNums.get(1));
            assertThat(randomNums.get(0)).isNotEqualTo(randomNums.get(2));
            assertThat(randomNums.get(1)).isNotEqualTo(randomNums.get(2));
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
        assertThat(resultA).isEqualTo("3스트라이크");
        assertThat(resultB).isEqualTo("낫싱");
        assertThat(resultC).isEqualTo("2볼 1스트라이크");
        assertThat(resultD).isEqualTo("2볼");
    }
}