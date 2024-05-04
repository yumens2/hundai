package precourse.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;


class NumberBaseBallTest {
    NumberBaseBall numberBaseBall;
    private static class FakeValidator extends Validator{
        @Override
        public void validateStartRoundInput(int numberLength) {}
        @Override
        public void validatePlayTurnInput(String numbers, String userNumbers) {}
    }
    @BeforeEach
    void setUp(){
        numberBaseBall = new NumberBaseBall(new FakeValidator());
    }

    @Test
    @DisplayName("게임 상태 업데이트")
    void testUpdateGameStatus() throws Exception {
        //g
        Method reflectedMethod = NumberBaseBall.class.getDeclaredMethod("updateGameStatus", GameStatus.class);
        reflectedMethod.setAccessible(true);
        Field reflectedField = NumberBaseBall.class.getDeclaredField("gameStatus");
        reflectedField.setAccessible(true);
        //w
        reflectedMethod.invoke(numberBaseBall, GameStatus.NOT_STARTED);
        //t
        assertEquals(GameStatus.NOT_STARTED, reflectedField.get(numberBaseBall));
    }

    @ParameterizedTest(name = "조건이 참이면 예외를 던짐")
    @ValueSource(booleans = {true, false})
    void testCheckTrueOrThrow(boolean bool) throws Exception{
        //g
        Method reflectedMethod = NumberBaseBall.class.getDeclaredMethod("checkTrueOrThrow", boolean.class, Supplier.class);
        reflectedMethod.setAccessible(true);
        Executable testMethod = ()-> reflectedMethod.invoke(numberBaseBall, bool, (Supplier<String>) ()->"예외 발생");
        //w & t
        if (!bool)
            try {
                reflectedMethod.invoke(numberBaseBall, bool, (Supplier<String>) () -> "예외 발생");
                throw new Exception("테스트 실패");
            }catch(InvocationTargetException e){
                assertInstanceOf(IllegalArgumentException.class, e.getCause());
            }
        else
            assertDoesNotThrow(testMethod);
    }

}
