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
}
