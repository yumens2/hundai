import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import validate.InputValidator;
import Exception.*;
import validate.RestartValidator;

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
    public void checkStrikeTest() {
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
    public void checkBallTest() {
        int predictNumber = 134;
        List<Integer> randomNumberList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            randomNumberList.add(i + 1);
        }
        int count = game.checkBall(randomNumberList, predictNumber);
        assertThat(count).isEqualTo(2);
    }

    @Test
    @DisplayName("숫자 입출력 확인")
    public void InputOutputTest() {  // 테스트에서는 입력값을 직접 쳐서 넣어주지 못한다!
        String input = "123\n"; // 테스트용 입력
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        int predictNumber = game.inputNumber(scanner);
        List<Integer> randomNumber = computer.makeRandomNumber();
        boolean checkCorrect = game.printResult(randomNumber, predictNumber);
    }

    @Test
    @DisplayName("중복된 숫자 예외 체크")
    public void duplicatedInputExceptionTest() {
        assertThatThrownBy(() -> InputValidator.checkDuplicate(122))
            .isInstanceOf(DuplicateException.class);
    }

    @Test
    @DisplayName("범위를 벗어난 숫자 예외 체크")
    public void InvalidLengthExceptionTest() {
        assertThatThrownBy(() -> InputValidator.checkInvalidLength(1222))
            .isInstanceOf(InvalidLengthException.class);
    }

    @Test
    @DisplayName("유효하지 않은 재시작 값 예외 체크")
    public void InvalidInputExceptionTest() {
        assertThatThrownBy(() -> RestartValidator.checkRestartNumber(3))
            .isInstanceOf(RestartNumberException.class);
    }
}
