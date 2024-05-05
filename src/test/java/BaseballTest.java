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
}
