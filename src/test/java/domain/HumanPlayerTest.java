package domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HumanPlayerTest {

    private static Method validateInputMethod;
    private final HumanPlayer humanPlayer = new HumanPlayer();

    @BeforeAll
    static void setUp() throws NoSuchMethodException {
        validateInputMethod = accessModifier("validateInput");
    }


    private static Method accessModifier(String methodName) throws NoSuchMethodException {
        Method method = HumanPlayer.class.getDeclaredMethod(methodName, String.class);
        method.setAccessible(true);
        return method;
    }

    @Test
    @DisplayName("입력은 3자리 숫자가 아니면 IllegalArgumentException을 던진다.")
    public void checkNumberSize() {
        //given
        String invalidInput = "1234";

        InvocationTargetException ex = assertThrows(
            InvocationTargetException.class,
            () -> validateInputMethod.invoke(humanPlayer, invalidInput));
        assertInstanceOf(IllegalArgumentException.class, ex.getCause());
    }


    @Test
    @DisplayName("입력은 숫자가 아니면 IllegalArgumentException을 던진다.")
    public void checkNumber() {
        //given
        String invalidInput = "12a";

        InvocationTargetException ex = assertThrows(
            InvocationTargetException.class,
            () -> validateInputMethod.invoke(humanPlayer, invalidInput));
        assertInstanceOf(IllegalArgumentException.class, ex.getCause());
    }

    @Test
    @DisplayName("입력은 중복된 숫자가 있으면 IllegalArgumentException을 던진다.")
    public void checkDuplicatedNumber() {
        String invalidInput = "112";

        InvocationTargetException ex = assertThrows(
            InvocationTargetException.class,
            () -> validateInputMethod.invoke(humanPlayer, invalidInput));
        assertInstanceOf(IllegalArgumentException.class, ex.getCause());
    }

    @Test
    @DisplayName("입력이 3자리 숫자이고 중복된 숫자가 없으면 IllegalArgumentException을 던지지 않는다.")
    public void validInput() {
        String validInput = "123";

        assertDoesNotThrow(() -> validateInputMethod.invoke(new HumanPlayer(), validInput));
    }

}

