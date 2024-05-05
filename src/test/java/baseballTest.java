import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class baseballTest {

    @Test
    void testConvertInputToArrayWithValidInput() {
        String input = "123";
        int[] expected = {1, 2, 3};
        int[] result = baseball.convertInputToArray(input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testConvertInputToArrayWithInvalidInput() {
        String input = "abc";
        int[] expected = new int[0];
        int[] result = baseball.convertInputToArray(input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testCheckInputValidityWithValidInput() {
        int[] input = {1, 2, 3};
        assertTrue(baseball.checkInputValidity(input));
    }

    @Test
    void testCheckInputValidityWithInvalidInput() {
        int[] input = {1, 1, 3};
        assertFalse(baseball.checkInputValidity(input));
    }

    @Test
    void testGenerateComputerNumbers() {
        int[] computer = baseball.generateComputerNumbers();
        assertEquals(3, computer.length); // 컴퓨터가 3자리 숫자를 생성하는지 확인
        assertTrue(baseball.checkForDuplicates(computer)); // 생성된 숫자에 중복이 없는지 확인
        for (int num : computer) {
            assertTrue(num >= 1 && num <= 9); // 생성된 숫자가 1에서 9까지의 범위 안에 있는지 확인
        }
    }

    @Test
    void testStrikeCheckWithAllStrikes() {
        int[] player = {1, 2, 3};
        int[] computer = {1, 2, 3};
        assertEquals(3, baseball.strikeCheck(player, computer));
    }

    @Test
    void testBallCheckWithAllBalls() {
        int[] player = {1, 2, 3};
        int[] computer = {3, 1, 2};
        assertEquals(3, baseball.ballCheck(player, computer));
    }

    @Test
    void testResultPrintWithThreeStrikes() {
        String expected = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        assertDoesNotThrow(() -> baseball.resultPrint(3, 0));
    }

    @Test
    void testResultPrintWithStrikesAndBalls() {
        String expected = "1 스트라이크 2 볼";
        assertDoesNotThrow(() -> baseball.resultPrint(1, 2));
    }
}