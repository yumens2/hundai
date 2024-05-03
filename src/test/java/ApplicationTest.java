import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    private void setScannerInputStream(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }

    // 스캐너 설정을 초기화합니다.
    private void resetScannerInputStream() {
        System.setIn(System.in);
    }

    @Test
    @DisplayName("3스트라이크 후 입력값이 1,2가 아닌 경우 예외 발생")
    public void testInvalidInput() {
        // Arrange
        setScannerInputStream("3\n"); // 3을 반환하도록 설정

        // Act & Assert
        try {
            int result = Application.checkAgain();
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            // 예외가 발생하면 테스트 성공
            assertEquals("입력값이 유효하지 않습니다.", e.getMessage());
        } finally {
            // 스캐너 설정을 초기화합니다.
            resetScannerInputStream();
        }
    }
}