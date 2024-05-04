import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameTests {
    BaseballGame baseballGame;

    @BeforeEach
    void createInstance() {
        baseballGame = new BaseballGame();
    }

    @Test
    @DisplayName("게임 재시작/종료 테스트")
    void retryGameTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = baseballGame.getClass().getDeclaredMethod("retryGame", int.class);
        method.setAccessible(true);
        assertThat((boolean)method.invoke(baseballGame, 1)).isEqualTo(true);
        assertThat((boolean)method.invoke(baseballGame, 2)).isEqualTo(false);
    }
}
