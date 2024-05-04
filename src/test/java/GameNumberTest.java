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

    @DisplayName("두 숫자 비교 결과 테스트")
    @ParameterizedTest(name = "{3}")
    @CsvSource({
            "'123', '123', '3스트라이크', '세 자리 모두 같을 때'",
            "'123', '456', '', '세 자리 모두 다를 때'",
            "'123', '135', '1볼 1스트라이크', '그 외의 경우'"
    })
    public void numberCompareTest(GameNumber gameNumber1, GameNumber gameNumber2, String expect, String msg) {
        String result = gameNumber1.compareTo(gameNumber2).toString();
        Assertions.assertThat(result)
                .isEqualTo(expect);
    }
}
