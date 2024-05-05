import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BaseballTest {

    @Test
    public void testMakeNumber_NoDuplicates() { //만들어진 수가 중복되었는지 테스트
        int[] arr;

        // Act
        Application.makeNumber();
        arr = Application.arr;

        // Assert
        assertNotEquals(arr[0], arr[1]);
        assertNotEquals(arr[1], arr[2]);
        assertNotEquals(arr[0], arr[2]);
    }

    @Test
    public void testMakeNumber_WithinRange() { // 만들어진 수가 1 ~ 9 범위인지 테스트
        // Arrange
        int[] arr;

        // Act
        Application.makeNumber();
        arr = Application.arr;

        // Assert
        assertTrue(arr[0] >= 1 && arr[0] <= 9);
        assertTrue(arr[1] >= 1 && arr[1] <= 9);
        assertTrue(arr[2] >= 1 && arr[2] <= 9);
    }

    @Test
    public void testSetNum_ValidInput() { // 유효한 입력 값에 대해 setNum 메서드가 예외를 던지지 않는지 테스트
        // Arrange
        int validInput = 123;

        // Act
        try {
            Application.setNum(validInput);
        } catch (IllegalArgumentException e) {
            // Assert
            fail("Unexpected IllegalArgumentException for valid input: " + e.getMessage());
        }
    }

    @Test
    public void testSetNum_InvalidInput() { // 유효하지 않은 입력 값에 대해 setNum 메서드가 예외를 던지는지 테스트
        // Arrange
        int invalidInput = 1000;

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> Application.setNum(invalidInput));
    }

    @Test
    public void testPrint_NoStrikesNoBalls() { //0 스트라이크 0 볼 일때 출력 테스트
        // Arrange
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Act
        Application.strike = 0;
        Application.ball = 0;
        Application.print();

        // Assert
        assertEquals("낫싱", outputStream.toString().trim());
    }

    @Test
    public void testPrint_1Strike0Balls() { // N 스트라이크 0볼 일때 출력 테스트
        // Arrange
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Act
        Application.strike = 1;
        Application.ball = 0;
        Application.print();

        // Assert
        assertEquals("1스트라이크", outputStream.toString().trim());
    }

    @Test
    public void testPrint_0Strikes2Balls() { //0 스트라이크 N 볼 일때 출력 테스트
        // Arrange
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Act
        Application.strike = 0;
        Application.ball = 2;
        Application.print();

        // Assert
        assertEquals("2볼", outputStream.toString().trim());
    }

    @Test
    public void testPrint_2Strikes2Balls() { // N 스트라이크 N 볼 일때 출력 테스트
        // Arrange
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Act
        Application.strike = 2;
        Application.ball = 2;
        Application.print();

        // Assert
        assertEquals("2스트라이크2볼", outputStream.toString().trim());
    }

    @Test
    public void testPrint_3Strikes_GameOver() { // 3 스트라이크로 정답일때 출력 테스트
        // Arrange
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outputStream));

        // Act
        Application.strike = 3;
        Application.ball = 0;
        Application.print();

        // Assert
        assertEquals("3스트라이크\r\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\r\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.",outputStream.toString().trim());
    }
}
