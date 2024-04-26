import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest {
    @Test
    @DisplayName("정상적인 값이 입력되었을때")
    void normalInput() {
        Assertions.assertThat(Application.isFinish("123", "321")).isFalse();
        Assertions.assertThat(Application.isFinish("321", "321")).isTrue();
    }

    @Test
    @DisplayName("영어가 입력되는 등 잘못된 값이 입력되었을때")
    void englishInput() {
        Assertions.assertThatThrownBy(() -> Application.isFinish("abc", "321")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("길이가 3을 초과하는 잘못된 값이 입력되었을때")
    void longInput() {
        Assertions.assertThatThrownBy(() -> Application.isFinish("abc", "321")).isInstanceOf(IllegalArgumentException.class);
    }
}