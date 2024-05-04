package precourse.game;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class TurnResultTest {
    @ParameterizedTest(name = "맞는 결과가 나오는지 확인")
    @MethodSource("provide4TestOf")
    void testOf(String numbers, String userNumbers, int ball, int strike){
        //g
        //w
        TurnResult turnResult = TurnResult.of(numbers, userNumbers);

        //t
        assertSame(turnResult.ball(), ball);
        assertSame(turnResult.strike(), strike);
    }
    static Stream<Arguments> provide4TestOf(){
        return Stream.of(
                Arguments.of("1234", "4321", 4, 0),
                Arguments.of("1234", "1234", 0, 4),
                Arguments.of("1234", "1111", 3, 1),
                Arguments.of("1234", "5678", 0, 0)
        );
    }

    @ParameterizedTest(name = "맞는 결과가 나오는지 확인")
    @MethodSource("provide4ToString")
    void testToString(int numberLength, int ball, int strike, String resultToCompare){
        //g
        TurnResult turnResult = new TurnResult(numberLength, ball, strike);
        String stringTurnResult = turnResult.toString();
        //w
        //t
        assertEquals(stringTurnResult, resultToCompare);
    }
    static Stream<Arguments> provide4ToString(){
        return Stream.of(
                Arguments.of(4, 4, 0, "4볼 "),
                Arguments.of(4, 0, 4, "4스트라이크"),
                Arguments.of(4, 3, 1, "3볼 1스트라이크"),
                Arguments.of(4, 0, 0, "낫싱")
        );
    }
}
