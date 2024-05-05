package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComputerTest {
    @Test
    @DisplayName("Computer constructor method must generate random number suitable for conditions")
    void computerConstructorTest() throws Exception {
        //given
        Computer computer = new Computer();
        int[] numbers = computer.getNumbers();

        //when & then(배열 길이 테스트)
        assertThat(numbers).hasSize(3);

        //when(숫자 범위 테스트)
        for(int number : numbers) {
            //then
            assertThat(number).isBetween(1, 9);
        }

        //when & then(중복 검사 테스트)
        assertThat(numbers).doesNotHaveDuplicates();
    }
}
