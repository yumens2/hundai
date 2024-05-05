package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("숫자야구 숫자 생성 테스트")
class BaseballNumberTest {

    @ParameterizedTest(name = "{1}은 중복원소가 존재하여 예외가 발생합니다.")
    @MethodSource("duplicateNumberListItem")
    void 중복된_숫자가_존재하면_예외를_발생시킨다(List<Integer> numbers, String numberToString) {
        assertThatThrownBy(() -> new BaseballNumber(numbers)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{1}은 생성할 수 있는 길이를 벗어났습니다.")
    @MethodSource("exceedNumberListSize")
    void 길이가_3이_아닌_경우_예외를_발생시킨다(List<Integer> numbers, String numberToString) {
        assertThatThrownBy(() -> new BaseballNumber(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 같은_숫자로_구성된_숫자야구_객체는_서로_동등하다() {
        BaseballNumber baseballNumber1 = new BaseballNumber(Arrays.asList(1, 2, 3));
        BaseballNumber baseballNumber2 = new BaseballNumber(Arrays.asList(1, 2, 3));
        assertThat(baseballNumber1).isEqualTo(baseballNumber2);
    }

    static Stream<Arguments> exceedNumberListSize() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3, 4), "1234"),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5), "12345"),
            Arguments.of(Arrays.asList(1, 2), "12")
        );
    }

    static Stream<Arguments> duplicateNumberListItem() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 2), "122"),
            Arguments.of(Arrays.asList(3, 3, 3), "333"),
            Arguments.of(Arrays.asList(9, 3, 9), "939")
        );
    }

}