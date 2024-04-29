import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class GameTest {

    Computer computer = new Computer();
    Game game = new Game();
    List<Integer> numberList = new ArrayList<>();

    @BeforeEach
    public void init() {
        numberList = computer.makeRandomNumber();
    }

    @Test
    @DisplayName("생성한 숫자의 자릿수 확인")
    public void numberLengthTest() {
        assertThat(numberList.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("생성한 숫자가 전부 다른 숫자인지 확인")
    public void numberUniqueTest() {
        assertThat(numberList.get(0)).isNotEqualTo(numberList.get(1));
        assertThat(numberList.get(1)).isNotEqualTo(numberList.get(2));
        assertThat(numberList.get(0)).isNotEqualTo(numberList.get(2));
    }

    @Test
    @DisplayName("스트라이크 갯수 확인")
    public void checkStrike() {
        int predictNumber = 124;
        List<Integer> randomNumberList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            randomNumberList.add(i + 1);
        }
        int count = game.checkStrike(randomNumberList, predictNumber);
        assertThat(count).isEqualTo(2);
    }

    @Test
    @DisplayName("볼 갯수 확인")
    public void checkBall() {
        int predictNumber = 134;
        List<Integer> randomNumberList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            randomNumberList.add(i + 1);
        }
        int count = game.checkBall(randomNumberList, predictNumber);
        assertThat(count).isEqualTo(2);
    }
}
