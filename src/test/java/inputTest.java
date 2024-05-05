import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class inputTest {

    private Input input;

    @BeforeEach
    void setUp(){
        input = new Input();
    }

    @Test
    void testIsValidWithCorrectInput(){
        // 올바른 입력 (1~9 사이의 숫자, 중복 없음, 정확히 3개)
        List<Integer> correctInput = Arrays.asList(1, 2, 3);
        assertDoesNotThrow(() -> input.isValid(correctInput));
    }

    @Test
    void testIsValidWithIncorrectSize(){
        // 크기가 잘못된 입력 (3개가 아님)
        List<Integer> incorrectSizeInput = Arrays.asList(1, 2, 3, 4);
        assertThrows(IllegalArgumentException.class, () -> input.isValid(incorrectSizeInput));
    }


    @Test
    void testIsValidWithDuplicateNumbers(){
        // 중복된 숫자가 포함된 입력
        List<Integer> duplicateNumbersInput = Arrays.asList(1, 2, 2);
        assertThrows(IllegalArgumentException.class, () -> input.isValid(duplicateNumbersInput));
    }
}
