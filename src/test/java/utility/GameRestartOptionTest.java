package utility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

class GameRestartOptionTest {

    @BeforeEach
    void setUp() {
        InputStringReceiver.close();
    }

    @Test
    @DisplayName("isGameRestart 참 테스트")
    void isGameRestartTrue() {
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        Assertions.assertTrue(GameRestartOption.isGameRestart());
    }

    @Test
    @DisplayName("isGameRestart 거짓 테스트")
    void isGameRestartFalse() {
        System.setIn(new ByteArrayInputStream("2".getBytes()));
        Assertions.assertFalse(GameRestartOption.isGameRestart());
    }

    @ParameterizedTest
    @DisplayName("isGameRestart 예외 확인 테스트")
    @ValueSource(strings = {"0", "3", "9", "123", "466", "test", "test1"})
    void isGameRestartException(String string) {
        System.setIn(new ByteArrayInputStream(string.getBytes()));
        org.assertj.core.api.Assertions.assertThatThrownBy(GameRestartOption::isGameRestart)
                .isInstanceOf(IllegalArgumentException.class);
    }
}