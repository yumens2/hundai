import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import java.util.stream.Stream;
import java.util.List;

public class InputValidatorTest {

  @ParameterizedTest(name = "{index}: {3}")
  @MethodSource("validateInputCases")
  @DisplayName("validate 함수 검사")
  void testValidate(String input, List<Integer> expected,
      Class<? extends Throwable> expectedException, String description) {
    Throwable thrown = catchThrowable(() -> {
      List<Integer> result = InputValidator.validate(input);
      assertThat(result).isEqualTo(expected);
    });

    if (expectedException == null) {
      assertThat(thrown).isNull();
    } else {
      assertThat(thrown).isInstanceOf(expectedException);
    }
  }

  static Stream<Arguments> validateInputCases() {
    return Stream.of(
        Arguments.of("123", List.of(1, 2, 3), null, "올바른 입력"),
        Arguments.of("abc", null, IllegalArgumentException.class, "잘못된 입력"),
        Arguments.of("4567", null, IllegalArgumentException.class, "잘못된 입력")
    );
  }

  @ParameterizedTest(name = "{index}: {1}")
  @MethodSource("provideInputsForIsValid")
  @DisplayName("isValid 함수 검사")
  void testIsValid(String input, boolean expected) {
    assertThat(InputValidator.isValid(input)).isEqualTo(expected);
  }

  static Stream<Arguments> provideInputsForIsValid() {
    return Stream.of(
        Arguments.of("123", true),
        Arguments.of("abc", false),
        Arguments.of("12", false),
        Arguments.of("113", false),
        Arguments.of("000", false)
    );
  }

  @ParameterizedTest
  @MethodSource("provideDataForStringToList")
  @DisplayName("stringToList 함수 검사")
  void testStringToList(String input, List<Integer> expected) {
    assertThat(InputValidator.stringToList(input)).isEqualTo(expected);
  }

  static Stream<Arguments> provideDataForStringToList() {
    return Stream.of(
        Arguments.of("123", List.of(1, 2, 3)),
        Arguments.of("456", List.of(4, 5, 6)),
        Arguments.of("789", List.of(7, 8, 9))
    );
  }

}
