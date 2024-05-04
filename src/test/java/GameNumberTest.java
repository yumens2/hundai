import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GameNumberTest {
    @DisplayName("유효하지 않은 입력에 대한 예외 발생 테스트")
    @ParameterizedTest(name = "{1}")
    @CsvSource({
            "df3, '숫자가 아닌 문자가 포함된 경우'",
            "3521, '세자리 숫자가 아닌 경우'",
            "171, '중복된 숫자가 존재하는 경우'"
    })
    public void exceptionTest(String gameNumber, String msg) {

        Assertions.assertThatThrownBy(() -> {
            new GameNumber(gameNumber);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }
}
