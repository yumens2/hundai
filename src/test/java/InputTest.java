import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import View.Input;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class InputTest {

    @AfterEach
    public void restoreSystemInput() {
        System.setIn(System.in);
    }

    @Test
    void getInputFromUser() {
        String testUserInput = "123";
        System.setIn(new ByteArrayInputStream(testUserInput.getBytes()));
        List<Integer> numbers = Input.getInputFromUser(testUserInput);
        assertEquals(Arrays.asList(1, 2, 3), numbers);
    }
    @Test
    void getInputWrongFromUser() {
        String testUserInput = "1234";
        System.setIn(new ByteArrayInputStream(testUserInput.getBytes()));
        List<Integer> numbers = Input.getInputFromUser(testUserInput);
        assertEquals(Arrays.asList(-1, 0, 0), numbers);

    }

    @Test
    void checkInputValid() {
        List<Integer> result = Input.checkInput("123");
        assertEquals(List.of(1, 2, 3), result);
    }

    @Test
    void checkInputLength() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Input.checkInput("12");
        });
        assertEquals(exception.getMessage(), "숫자는 3자리여야 합니다.");
    }

    @Test
    void checkInputNumeric() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Input.checkInput("1a3");
        });
        assertEquals(exception.getMessage(), "숫자만 입력할 수 있습니다.");
    }


    @Test
    void validateNumbers() {
        assertDoesNotThrow(() -> Input.validateNumbers(Arrays.asList(1, 2, 3)));
    }

    @Test
    void validateNumbersOutOfRange() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Input.validateNumbers(Arrays.asList(0, 10, 11));
        });
        assertEquals(exception.getMessage(), "숫자는 1~9사이여야 합니다.");
    }

    @Test
    void validateNumbersDuplicate() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Input.validateNumbers(Arrays.asList(1, 2, 1));
        });
        assertEquals(exception.getMessage(), "숫자가 서로 달라야 합니다.");
    }
}