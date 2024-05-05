package application;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballGameServiceTest {

    private static Method validateRestartInput;
    private final BaseballGameService baseballGameService = new BaseballGameService();

    @BeforeAll
    public static void setUp() throws NoSuchMethodException {
        validateRestartInput = accessModifier("validateRestartInput"); // 올바르게 메소드를 할당
    }

    private static Method accessModifier(String methodName) throws NoSuchMethodException {
        Method method = BaseballGameService.class.getDeclaredMethod(methodName, String.class);
        method.setAccessible(true);
        return method;
    }

    @Test
    @DisplayName("재시작 입력이 1 또는 2가 아닌 경우 IllegalArgumentException이 발생한다.")
    public void inValidRestartCode() {
        String invalidInput = "3";

        InvocationTargetException ex = assertThrows(
            InvocationTargetException.class,
            () -> validateRestartInput.invoke(baseballGameService, invalidInput));
        assertInstanceOf(IllegalArgumentException.class, ex.getCause());
    }

    @Test
    @DisplayName("재시작 입력이 1 또는 2가 아닌 문자일 경우 IllegalArgumentException이 발생한다.")
    public void inValidRestartCode2() {
        String invalidInput = "a";

        InvocationTargetException ex = assertThrows(
            InvocationTargetException.class,
            () -> validateRestartInput.invoke(baseballGameService, invalidInput));
        assertInstanceOf(IllegalArgumentException.class, ex.getCause());
    }

    @Test
    @DisplayName("재시작 입력이 1 또는 2인 경우 IllegalArgumentException이 발생하지 않는다.")
    public void validRestartCode() {
        String validInput = "1";

        assertDoesNotThrow(() -> validateRestartInput.invoke(baseballGameService, validInput));
    }
}
