import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class ValidatorTest {
    Validator validator = new Validator();
    @Test
    void isUserInputValid() {
        // 3자리 확인
        assertThat(validator.isUserInputValid("1234")).isEqualTo(false);
        assertThat(validator.isUserInputValid("123")).isEqualTo(true);
        // 숫자 확인
        assertThat(validator.isUserInputValid("12t")).isEqualTo(false);
        assertThat(validator.isUserInputValid("123")).isEqualTo(true);
        // 중복 숫자
        assertThat(validator.isUserInputValid("122")).isEqualTo(false);
        assertThat(validator.isUserInputValid("123")).isEqualTo(true);
    }

    @Test
    void isRestartInputValid() {
        // 1자리 확인
        assertThat(validator.isRestartInputValid("12")).isEqualTo(false);
        assertThat(validator.isRestartInputValid("1")).isEqualTo(true);
        // 숫자 확인
        assertThat(validator.isRestartInputValid("o")).isEqualTo(false);
        assertThat(validator.isRestartInputValid("2")).isEqualTo(true);
        // 1 또는 2
        assertThat(validator.isRestartInputValid("3")).isEqualTo(false);
        assertThat(validator.isRestartInputValid("1")).isEqualTo(true);
        assertThat(validator.isRestartInputValid("2")).isEqualTo(true);
    }
}