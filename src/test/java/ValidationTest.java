import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("ValidationTest")
public class ValidationTest {

    Validation validation = new Validation();

    @Test
    @DisplayName("입력 길이 초과")
    void lengthCheckFail() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                validation.validateNumber("1234");
            }).withMessage("3자리 숫자를 입력해야 합니다.");
    }

    @Test
    @DisplayName("입력 타입 오류")
    void typeCheckFail() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                validation.validateNumber("ab1");
            }).withMessage("정수 이외의 입력은 허용되지 않습니다.");
    }

    @Test
    @DisplayName("중복입력")
    void duplicationCheckFail() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                validation.validateNumber("112");
            }).withMessage("입력은 서로 다른 정수여야 합니다.");
    }

    @Test
    @DisplayName("정상입력")
    void checkSuccess() {
        validation.validateNumber("957");
    }


    @Test
    @DisplayName("입력 타입 오류")
    void intCheckFail1() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                validation.validateInt("a");
            }).withMessage("1 또는 2를 입력해야 합니다.");
    }

    @Test
    @DisplayName("입력 범위 오류")
    void intCheckFail2() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                validation.validateInt("31");
            }).withMessage("1 또는 2를 입력해야 합니다.");
    }

    @Test
    @DisplayName("정상 입력")
    void intCheckSuccess1() {
        validation.validateInt("1");
        validation.validateInt("2");
    }
}
