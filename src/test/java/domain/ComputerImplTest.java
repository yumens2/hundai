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

}