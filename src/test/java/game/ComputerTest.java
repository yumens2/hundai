package game;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ComputerTest {

    Computer computer = new Computer(() -> Arrays.asList(1, 2, 3));

    @ParameterizedTest
    @CsvSource({
        "4, 5, 6, 낫싱",
        "5, 1, 7, 1볼",
        "8, 1, 2, 2볼",
        "3, 1, 2, 3볼",
        "1, 4, 5, 1스트라이크",
        "1, 4, 3, 2스트라이크",
        "4, 2, 1, 1볼 1스트라이크",
        "3, 2, 1, 2볼 1스트라이크"
    })
    void 힌트_생성_테스트(int num1, int num2, int num3, String expectedHint) {
        String hintText = computer.getHint(Arrays.asList(num1, num2, num3)).toString();
        assertThat(hintText).isEqualTo(expectedHint);
    }
}