package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserTest {

    @Test
    @DisplayName("사용자를 정상적으로 생성한다.")
    void createUserSuccess() {
        // given
        final String userInput = "123";

        // when
        final User user = User.from(userInput);

        // then
        final List<Integer> numbers = user.getNumbers();
        assertSoftly(softly -> {
            softly.assertThat(numbers).hasSize(3);
            softly.assertThat(numbers).usingRecursiveComparison().isEqualTo(List.of(1, 2, 3));
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", "12", "112", "120", "a12"})
    @DisplayName("사용자 생성 시 입력이 1~9사이의 서로 다른 3자리 숫자가 아닌 경우 예외가 발생한다.")
    void createUserFail(final String userInput) {
        // when, then
        assertThatThrownBy(() -> User.from(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1~9사이의 서로 다른 3자리 숫자만 가능합니다.");
    }
}
