package domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.reflect.Method;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HumanPlayerTest {

    private static Method validateInputMethod;

    @BeforeAll
    static void setUp() throws NoSuchMethodException {
        accessModifier("validateInput");
    }


    private final HumanPlayer humanPlayer = new HumanPlayer();

    private static Method accessModifier(String methodName) throws NoSuchMethodException {
        Method method = HumanPlayer.class.getDeclaredMethod(methodName, String.class);
        method.setAccessible(true); // 접근 허용
        return method;
    }

    @Test
    @DisplayName("입력은 3자리 숫자가 아니면 IllegalArgumentException을 던진다.")
    public void checkNumberSize() {
        //given
        String invalidInput = "1234";

        assertThrows(Exception.class, () -> validateInputMethod.invoke(humanPlayer, invalidInput));
    }


    @Test
    @DisplayName("입력은 숫자가 아니면 IllegalArgumentException을 던진다.")
    public void checkNumber() {
        //given
        String invalidInput = "12a";

        assertThrows(Exception.class, () -> validateInputMethod.invoke(humanPlayer, invalidInput));
    }

    @Test
    @DisplayName("입력은 중복된 숫자가 있으면 IllegalArgumentException을 던진다.")
    public void checkDuplicatedNumber() {
        //given
        String invalidInput = "112";

        assertThrows(Exception.class, () -> validateInputMethod.invoke(humanPlayer, invalidInput));
    }


}

