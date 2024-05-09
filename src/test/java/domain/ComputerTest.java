package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComputerTest {

    Computer computer;
    
    @BeforeEach
    void setUp() {
        computer = new Computer();
    }
    
    @Test
    void getAnswerNumber() {
        String answerNumber = computer.getAnswerNumber();
        org.assertj.core.api.Assertions.assertThat(answerNumber.length()).isEqualTo(3);
        Assertions.assertDoesNotThrow(() -> (Integer.parseInt(answerNumber)));
        for (int i = 0; i < answerNumber.length(); i++) {
            char currentDigit = answerNumber.charAt(i);
            int digitCount = Math.toIntExact(answerNumber.chars()
                    .filter((ch) -> (ch == currentDigit))
                    .count());
            org.assertj.core.api.Assertions.assertThat(digitCount).isEqualTo(1);
        }
    }
}