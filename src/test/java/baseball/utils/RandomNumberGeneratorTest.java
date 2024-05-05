package baseball.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RandomNumberGeneratorTest {

    @ParameterizedTest(name = "길이가 {0}인 경우 예외를 발생시킵니다.")
    @ValueSource(ints = {0, 10})
    void 부적절한_길이_테스트(int invalidLength) {
        assertThatThrownBy(() -> {
            RandomNumberGenerator.getNonDuplicateNumbers(invalidLength);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}