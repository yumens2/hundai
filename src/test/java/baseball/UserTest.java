package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

class UserTest {

    @Test
    @DisplayName("정상적인 입력값 테스트")
    void validateNum_validateInput() {
        // given
        String input = "123";

        // when
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(inputStream);
        User user = new User(scanner);

        // then
        assertThat(user.makeGuess()).isEqualTo(input);
    }

    @Test
    @DisplayName("0을 포함한 잘못된 입력값 테스트")
    void validateNum_invalidateInput_includeZero() {
        // given
        String input = "012";

        // when
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(inputStream);
        User user = new User(scanner);

        // then
        assertThatThrownBy(user::makeGuess)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("길이가 3이 아닌 잘못된 입력값 테스트")
    void validateNum_invalidateInput_wrongLength() {
        // given
        String input = "1245";

        // when
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(inputStream);
        User user = new User(scanner);

        // then
        assertThatThrownBy(user::makeGuess)
                .isInstanceOf(IllegalArgumentException.class);
    }
}