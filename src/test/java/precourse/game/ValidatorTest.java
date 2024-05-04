package precourse.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @ParameterizedTest
    @MethodSource("provide4TestValidatingStartRoundInput")
    @DisplayName("라운드 시작 메서드의 숫자 길이 검증 테스트")
    void testValidatingStartRoundInput(int numberLength, boolean shouldThrow){
        //g
        Validator validator = new Validator();
        Executable testMethod = ()->validator.validateStartRoundInput(numberLength);
        //w & t
        if (shouldThrow) {
            Exception e = assertThrows(IllegalArgumentException.class, testMethod);
            assertEquals(e.getMessage(), Messages.INVALID_NUMBER_LENGTH.getMessage());
        }else{
            assertDoesNotThrow(testMethod);
        }
    }
    static Stream<Arguments> provide4TestValidatingStartRoundInput(){
        return Stream.of(
                Arguments.of(0, true),
                Arguments.of(1, false),
                Arguments.of(5, false),
                Arguments.of(9, false),
                Arguments.of(10, true)
        );
    }

    @ParameterizedTest
    @MethodSource("provide4TestValidatingPlayTurnInput")
    void testValidatingPlayTurnInput(String numbers, String userNumbers, boolean shouldThrow, String expectedExceptionMessage){
        //g
        Validator validator = new Validator();
        Executable testMethod = () -> validator.validatePlayTurnInput(numbers, userNumbers);
        //w & t
        if (shouldThrow){
            Exception e = assertThrows(IllegalArgumentException.class, testMethod);
            assertEquals(e.getMessage(), expectedExceptionMessage);
        }else{
            assertDoesNotThrow(testMethod);
        }
    }

    static Stream<Arguments> provide4TestValidatingPlayTurnInput(){
        return Stream.of(
                Arguments.of("123", "1234", true, Messages.NOT_MATCHED_LENGTH.getMessage()),
                Arguments.of("123", "-23", true, Messages.INVALID_NUMBER.getMessage()),
                Arguments.of("123", "223", true, Messages.NOT_UNIQUE_DIGITS.getMessage()),
                Arguments.of("123", "123", false, null)
        );
    }

}
