package UserInput;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserPredictNumberTest {

    @DisplayName("User Predict Input Success Test")
    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789", "012", "345"})
    void predictInputSuccess(String input) {
        System.setIn(new ByteArrayInputStream((input).getBytes()));
        List<Integer> result = UserPredictNumber.predictInput();
        assertEquals(
            Arrays.stream(input.split("")).map(Integer::parseInt).collect(Collectors.toList()),
            result
        );
    }

    @DisplayName("User Predict Input Not Equal Length Test")
    @ParameterizedTest
    @ValueSource(strings = {"1234", "12345", "123456", "1234567", "0", "12"})
    void predictInputNotEqualLength(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThrows(IllegalArgumentException.class, UserPredictNumber::predictInput);
    }

    @DisplayName("User Predict Input Not Number Test")
    @ParameterizedTest
    @ValueSource(strings = {"1a3", "1b3", "1e3", "\\\b", "1\n2", "aaa"})
    void predictInputNotNumber(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThrows(IllegalArgumentException.class, UserPredictNumber::predictInput);
    }

    @DisplayName("User Predict Input Same Number Test")
    @ParameterizedTest
    @ValueSource(strings = {"111", "222", "333", "444", "525"})
    void predictInputSameNumber(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThrows(IllegalArgumentException.class, UserPredictNumber::predictInput);
    }
}