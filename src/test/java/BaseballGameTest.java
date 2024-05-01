import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class BaseballGameTest {
    private BaseballGame baseballGame;

    @BeforeEach
    void setUp() {
        baseballGame = new BaseballGame();

    }

    //generateComputerNumbers() 메서드를 호출하여 컴퓨터가 생성한 숫자 배열이 올바르게 생성되는지 확인
    //생성된 배열의 길이가 3이고, 각 숫자가 1부터 9 사이의 값인지 확인
    @Test
    void generateComputerNumbersTest() {
        int[] generatedNumbers = baseballGame.generateComputerNumbers();
        assertNotNull(generatedNumbers);
        assertEquals(3, generatedNumbers.length);
        for (int number : generatedNumbers) {
            assertTrue(number >= 1 && number <= 9);
        }
    }

    //유효한 입력과 유효하지 않은 입력에 대해 parseUserInput() 메서드를 호출하여 사용자 입력을 파싱하는 기능
    //유효하지 않은 입력에 대해서는 IllegalArgumentException이 발생하는지 확인
    @Test
    void parseUserInputTest() {
        String validInput = "123";
        String invalidInput = "1234";

        int[] validNumbers = baseballGame.parseUserInput(validInput);
        assertNotNull(validNumbers);
        assertArrayEquals(new int[]{1, 2, 3}, validNumbers);

        assertThrows(IllegalArgumentException.class, () -> baseballGame.parseUserInput(invalidInput));
    }


    //calculateResult() 메서드를 호출하여 컴퓨터가 생성한 숫자와 사용자가 입력한 숫자의 결과를 계산하는 기능을 검증
    //예를 들어, 3스트라이크인 경우는 [3, 0]이 반환되어야 하고, 볼이나 스트라이크가 없는 경우는 [0, 0]이 반환되어야 함
    @Test
    void calculateResultTest() {
        int[] computerNumbers = {1, 2, 3};

        int[] result1 = baseballGame.calculateResult(computerNumbers, new int[]{1, 2, 3});
        assertArrayEquals(new int[]{3, 0}, result1);

        int[] result2 = baseballGame.calculateResult(computerNumbers, new int[]{4, 5, 6});
        assertArrayEquals(new int[]{0, 0}, result2);

        int[] result3 = baseballGame.calculateResult(computerNumbers, new int[]{1, 3, 2});
        assertArrayEquals(new int[]{1, 2}, result3);
    }


}