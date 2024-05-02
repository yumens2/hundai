import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {
    @Test
    @DisplayName("3스트라이크 후 입력값이 1,2가 아닌 경우 예외 발생")
    public void testInvalidInput() {
        // Arrange
        Application application = new Application();
        // 3이 입력되도록 설정
        System.setIn(new ByteArrayInputStream("3\n".getBytes()));

        // Act & Assert
        try {
            application.checkAgain();
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            // 예외가 발생하면 테스트 성공
        } finally {
            // 테스트 후에는 표준 입력을 초기화
            System.setIn(System.in);
        }
    }
}