package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {
    Computer computer;
    @BeforeEach
    void setComputer(){
        computer = new Computer(3, List.of(1,2,3));
    }

    @Test
    @DisplayName("Strike 개수 반환 테스트")
    void countStrikeTest(){
        //given
        List<Integer> humanValue = List.of(1,5,3);

        //when
        int strike = computer.countStrike(humanValue);

        //then
        assertEquals(strike, 2);
    }

    @Test
    @DisplayName("Ball 개수 반환 테스트")
    void countBallTest(){

        //given
        List<Integer> humanValue = List.of(2,1,3);

        //when
        int ball = computer.countBall(humanValue);

        //then
        assertEquals(ball, 2);
    }
}