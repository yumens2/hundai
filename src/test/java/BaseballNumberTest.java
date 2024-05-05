import domain.BaseballNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import util.Constants;

public class BaseballNumberTest {

    private BaseballNumber baseballNumber;

    @BeforeEach
    void setUp() {
        baseballNumber = new BaseballNumber();
    }

    @Test
    @DisplayName("정상적인 숫자 입력 테스트")
    void setNumberWithValidInput() {
        baseballNumber.setNumber("123");
        assertThat(baseballNumber.getDigit(0)).isEqualTo(1);
        assertThat(baseballNumber.getDigit(1)).isEqualTo(2);
        assertThat(baseballNumber.getDigit(2)).isEqualTo(3);
    }

    @Test
    @DisplayName("입력 길이가 잘못된 경우 예외 발생")
    void setNumberWithInvalidLength() {
        assertThatThrownBy(() -> baseballNumber.setNumber("1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("세 개의 숫자를 입력해야 합니다.");
    }

    @Test
    @DisplayName("숫자가 아닌 문자 포함 입력시 예외 발생")
    void setNumberWithNonNumericInput() {
        assertThatThrownBy(() -> baseballNumber.setNumber("12a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력할 수 있습니다");
    }

    @Test
    @DisplayName("중복된 숫자 입력시 예외 발생")
    void setNumberWithDuplicateNumbers() {
        assertThatThrownBy(() -> baseballNumber.setNumber("112"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("각 자리의 수는 서로 달라야 합니다.");
    }
}