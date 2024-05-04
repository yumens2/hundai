import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
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

    @Test
    @DisplayName("잘못된 입력 에러 메시지 출력 테스트")
    void printErrorMessageTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Method method = baseballGame.getClass().getDeclaredMethod("printErrorMessage");
        method.setAccessible(true);
        method.invoke(baseballGame);

        assertThat(out.toString()).isEqualTo("잘못된 형식의 입력입니다.\n게임을 종료합니다.\n");
    }
}
