import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ApplicationTest {

    private Application application;

    @BeforeEach
    public void setUp() {
        application = new Application();
    }

    @Test
    public void testGenerateRandomNumbers() {
        List<Integer> numbers = application.generateRandomNumbers();
        assertEquals(3, numbers.size());
        assertTrue(numbers.stream().distinct().count() == 3,
            "Generated numbers should not have duplicates");
    }

    @Test
    public void testValidateUserInput_validInput() {
        String validInput = "123";
        assertDoesNotThrow(() -> application.validateUserInput(validInput));
    }

    @Test
    public void testValidateUserInput_invalidInputLength() {
        String invalidInput = "12"; // Less than 3 digits
        Executable executable = () -> application.validateUserInput(invalidInput);
        assertThrows(IllegalArgumentException.class, executable, "입력은 3자리여야 합니다.");
    }

    @Test
    public void testValidateUserInput_nonNumericInput() {
        String invalidInput = "12a"; // Contains non-numeric character
        Executable executable = () -> application.validateUserInput(invalidInput);
        assertThrows(IllegalArgumentException.class, executable, "입력은 숫자여야 합니다.");
    }

    @Test
    public void testValidateUserInput_containsDuplicate() {
        String invalidInput = "122"; // Contains duplicate digits
        Executable executable = () -> application.validateUserInput(invalidInput);
        assertThrows(IllegalArgumentException.class, executable, "중복되지 않은 3자리 숫자를 입력하세요.");
    }

    @Test
    public void testCompareNumbers() {
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> userNumbers = Arrays.asList(1, 4, 3);
        Application.Result result = application.compareNumbers(computerNumbers, userNumbers);
        assertEquals(2, result.strikes); // '1' and '3' are in the correct position
        assertEquals(0, result.balls); // No balls
    }

    @Test
    public void testGameIsFinished() {
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        // 테스트용으로 사용자의 입력을 시뮬레이션하기 위해 Scanner에 문자열을 전달
        Scanner testScanner = new Scanner("123\n");
        boolean isFinished = application.gameIsFinished(computerNumbers, testScanner);

        assertTrue(isFinished, "3개의 스트라이크로 인해 게임이 종료되어야 합니다.");
    }

    @Test
    public void testStrikesAndBalls() {
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> userNumbers1 = Arrays.asList(1, 4, 3);
        List<Integer> userNumbers2 = Arrays.asList(4, 5, 6);

        Application.Result result1 = application.compareNumbers(computerNumbers, userNumbers1);
        assertEquals(2, result1.strikes); // '1'과 '3'은 스트라이크
        assertEquals(0, result1.balls); // 볼 없음

        Application.Result result2 = application.compareNumbers(computerNumbers, userNumbers2);
        assertEquals(0, result2.strikes); // 스트라이크 없음
        assertEquals(0, result2.balls); // 볼 없음
    }

    @Test
    public void testInvalidUserInput() {
        Executable tooShortInput = () -> application.validateUserInput("12");
        Executable nonNumericInput = () -> application.validateUserInput("12a");
        Executable duplicateDigits = () -> application.validateUserInput("122");

        assertThrows(IllegalArgumentException.class, tooShortInput, "입력은 3자리여야 합니다.");
        assertThrows(IllegalArgumentException.class, nonNumericInput, "입력은 숫자여야 합니다.");
        assertThrows(IllegalArgumentException.class, duplicateDigits, "중복되지 않은 3자리 숫자를 입력하세요.");
    }

    @Test
    public void testValidateUserInput() {
        // 올바른 입력을 확인하기 위해 AssertJ 사용
        assertThatCode(() -> application.validateUserInput("123"))
            .doesNotThrowAnyException(); // 예외가 발생하지 않아야 함

        // 잘못된 입력을 확인하기 위해 AssertJ 사용
        assertThatThrownBy(() -> application.validateUserInput("12")) // 3자리 이하
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("3자리");

        assertThatThrownBy(() -> application.validateUserInput("12a")) // 비숫자 입력
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("숫자여야");

        assertThatThrownBy(() -> application.validateUserInput("122")) // 중복된 입력
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("중복되지 않은");
    }

}