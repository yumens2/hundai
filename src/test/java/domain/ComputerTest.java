package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ComputerTest {

    @Test
    void generateRandomNumbers() {
        Computer computer = new Computer();

        // 테스트 반복
        for (int i = 0; i < 10000; i++) {
            computer.generateRandomNumbers();

            // 생성된 숫자가 3개인지 확인
            assertEquals(3, computer.getNumber().size());

            // 생성된 숫자가 1~9 사이의 숫자인지 확인
            for (int number : computer.getNumber()) {
                assertTrue(number >= 1 && number <= 9);
            }

            // 생성된 숫자가 중복되지 않는지 확인
            assertEquals(3, computer.getNumber().stream().distinct().count());
        }
    }
}