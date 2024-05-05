package domain;

import static domain.BaseballGame.NUMBER_SIZE;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballGameTest {

    final private BaseballGame baseballGame = new BaseballGame();

    @Test
    @DisplayName("서로 자리가 같을 때는 스트라이크")
    void comparePosition() {
        // given
        Integer playerNumber = 1;

        ArrayList<Integer> computerNumber = new ArrayList<>();
        computerNumber.add(1);
        computerNumber.add(2);
        computerNumber.add(3);

        // when
        GameResult result = baseballGame.comparePosition(0, playerNumber, computerNumber);

        // then
        assertEquals(GameResult.STRIKE, result);
    }

    @Test
    @DisplayName("서로 자리가 다를 때는 볼")
    void comparePosition1() {
        // given
        Integer playerNumber = 1;

        ArrayList<Integer> computerNumber = new ArrayList<>();
        computerNumber.add(2);
        computerNumber.add(1);
        computerNumber.add(3);

        // when
        GameResult result = baseballGame.comparePosition(0, playerNumber, computerNumber);

        // then
        assertEquals(GameResult.BALL, result);
    }

    @Test
    @DisplayName("서로 자리와 숫자가 다를 때는 NONE")
    public void comparePosition2() throws Exception {
        //given
        Integer playerNumber = 1;

        ArrayList<Integer> computerNumber = new ArrayList<>();
        computerNumber.add(4);
        computerNumber.add(5);
        computerNumber.add(6);

        //when
        GameResult result = baseballGame.comparePosition(0, playerNumber, computerNumber);

        //then
        assertEquals(GameResult.NONE, result);
    }

    @Test
    @DisplayName("사용자와 컴퓨터의 숫자가 모두 같을 때")
    void compareNumbers() {
        // given
        ArrayList<Integer> humanNumbers = new ArrayList<>();
        humanNumbers.add(1);
        humanNumbers.add(2);
        humanNumbers.add(3);

        ArrayList<Integer> computerNumbers = new ArrayList<>();
        computerNumbers.add(1);
        computerNumbers.add(2);
        computerNumbers.add(3);

        // when
        baseballGame.compareNumbers(humanNumbers, computerNumbers);

        // then
        assertEquals(NUMBER_SIZE, baseballGame.getStrikes());

        assertEquals(0, baseballGame.getBalls());
    }

    @Test
    @DisplayName("사용자와 컴퓨터의 숫자가 모두 다를 때")
    void compareNumbers1() {

        // given
        ArrayList<Integer> humanNumbers = new ArrayList<>();
        humanNumbers.add(1);
        humanNumbers.add(2);
        humanNumbers.add(3);

        ArrayList<Integer> computerNumbers = new ArrayList<>();
        computerNumbers.add(4);
        computerNumbers.add(5);
        computerNumbers.add(6);

        // when
        baseballGame.compareNumbers(humanNumbers, computerNumbers);

        // then
        assertEquals(baseballGame.getBalls(), 0);
        assertEquals(baseballGame.getStrikes(), 0);
    }

    @Test
    @DisplayName("사용자와 컴퓨터의 숫자가 일부만 같을 때")
    void compareNumbers2() {

        // given
        ArrayList<Integer> humanNumbers = new ArrayList<>();
        humanNumbers.add(1);
        humanNumbers.add(2);
        humanNumbers.add(3);

        ArrayList<Integer> computerNumbers = new ArrayList<>();
        computerNumbers.add(1);
        computerNumbers.add(3);
        computerNumbers.add(5);

        // when
        baseballGame.compareNumbers(humanNumbers, computerNumbers);

        // then
        assertEquals(baseballGame.getBalls(), 1);
        assertEquals(baseballGame.getStrikes(), 1);
    }
}
