import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserInputTest {
    @DisplayName("사용자 입력 값 확인")
    @Test
    void input() {
        // given
        String input = "123\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        UserInput userInput = new UserInput();

        // when
        List<String> result = userInput.input();

        // then
        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals("1", result.get(0));
        assertEquals("2", result.get(1));
        assertEquals("3", result.get(2));
    }

    @DisplayName("유효성 검증 : 길이가 3보다 짧을때")
    @Test
    void isValidInput_LenghtIsLessThan3() {
        // Given
        String[] input = {"1", "2"};

        // When
        boolean result = new UserInput().isValidInput(input);

        // Then
        assertFalse(result);
    }

    @DisplayName("유효성 검증 : 길이가 3보다 길때")
    @Test
    void isValidInput_LenghtIsMoreThan3() {
        // Given
        String[] input = {"1", "2", "3", "4"};

        // When
        boolean result = new UserInput().isValidInput(input);

        // Then
        assertFalse(result);
    }

    @DisplayName("유효성 검증 : 중복된 수가 있을 때")
    @Test
    void isValidInput_DuplicationNumber() {
        // Given
        String[] input = {"1", "1", "3"};

        // When
        boolean result = new UserInput().isValidInput(input);

        // Then
        assertFalse(result);
    }

    @DisplayName("유효성 검증 : 정상 출력")
    @Test
    void isValidInput_ReturnTrue() {
        // Given
        String[] input = {"1", "2", "3"};

        // When
        boolean result = new UserInput().isValidInput(input);

        // Then
        assertTrue(result);
    }
}