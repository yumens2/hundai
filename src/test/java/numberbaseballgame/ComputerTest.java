package numberbaseballgame;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ComputerTest {
    @Test
    void setRandomAnswer() {
        Computer computer = new Computer();
        GameNumber answerNumber = computer.getAnswerNumber();
        assertTrue(answerNumber.isNumberInRange() && answerNumber.isNumberUnique());
    }

    @Test
    void returnHintString() {
        Computer computer = new Computer();
        int[][] answerDataInTest = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {3, 8, 4},
            {6, 2, 9}
        };
        int[][] inputDataInTest = {
            {1, 2, 3},  // 모든 숫자가 일치하는 경우
            {4, 6, 8},  // 숫자 2개가 일치하는 경우
            {7, 1, 2},  // 숫자 1개가 일치하는 경우
            {2, 1, 5},  // 모든 숫자가 일치하지 않는 경우
            {6, 6, 2},  // 입력 숫자에 중복이 있는 경우
        };
        String[] resultDataInTest = {
            "3스트라이크",
            "1볼 1스트라이크",
            "1스트라이크",
            "낫싱",
            "1볼 1스트라이크"
        };
        for(int i = 0; i < inputDataInTest.length; i++) {
            computer.setAnswer(answerDataInTest[i][0], answerDataInTest[i][1], answerDataInTest[i][2]);
            GameNumber gameNumber = new GameNumber(inputDataInTest[i][0], inputDataInTest[i][1], inputDataInTest[i][2]);
            assertEquals(computer.returnHintString(gameNumber), resultDataInTest[i]);
        }
    }
}