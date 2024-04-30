import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumValidatorTest {
    @Test
    void isCorrectLength(){
        Assertions.assertEquals(false, NumValidator.isCorrectLength("1234"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789", "234", "a3bc", "122", "134", "003"})
    void isOneToNine(String input){
        Assertions.assertEquals(NumValidator.isOneToNine(input), input.matches("[1-9]{1,3}"));
    }

}
