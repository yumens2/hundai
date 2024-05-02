package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerExceptionTest {
    Computer computer;
    @BeforeEach
    void setComputer(){
        computer = new Computer(3, List.of(1,2,3));
    }

    @Test
    @DisplayName("Computer 초기화 시 다른 사이즈의 Random Array 주입 시 Exception 처리")
    void wrongSizeRandomArrayInjectionTest(){
        //given
        List<Integer> randomArray = List.of(1,2,3,4);
        int capacity = 3;

        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            computer = new Computer(capacity, randomArray);
        });

        //then
        assertInstanceOf(IllegalArgumentException.class, exception);
        assertEquals(exception.getMessage(), "컴퓨터의 랜덤값의 자리수와 주어진 자리수가 일치하지 않습니다.");
    }

    @Test
    @DisplayName("HumanValue 가 ComputerValue와 자리수 불일치")
    void wrongSizeHumanValueTest(){
        //given
        List<Integer> humanValues = List.of(1,2,3,4);

        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            int ball = computer.countStrike(humanValues);
        });

        //then
        assertInstanceOf(IllegalArgumentException.class, exception);
        assertEquals(exception.getMessage(), "숫자가 자릿수가 일치하지 않습니다.");
    }
}