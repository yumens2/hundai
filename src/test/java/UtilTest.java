import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import jdk.jfr.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {

    Util util = new Util();

    @Test
    @DisplayName("정수인지 검사(참)")
    void testIsNumWithNumber() {
        //  give
        String test = "123";

        //  when

        //  then
        // 숫자를 입력했을 때 예외가 발생하지 않는지 확인
        assertDoesNotThrow(() -> {
            util.isNum(test);
        });
    }

    @Test
    @DisplayName("정수인지 검사(실패)")
    void testIsNumWithNonNumber() {
        //  give
        String test = "1aa";

        //  when

        //  then
        // 숫자가 아닌 값을 입력했을 때 IllegalArgumentException이 발생하는지 확인
        assertThrows(IllegalArgumentException.class, () -> {
            util.isNum(test);
        });
    }

    @Test
    @DisplayName("중복검사(중복됨)")
    void testIsDuplicate() {
        //  give
        String[] test = "111".split("");

        //  when

        //  then
        // 숫자가 아닌 값을 입력했을 때 IllegalArgumentException이 발생하는지 확인
        assertThrows(IllegalArgumentException.class, () -> {
            util.isDuplicate(test);
        });
    }

    @Test
    @DisplayName("중복검사(참)")
    void testNoneIsDuplicate() {
        //  give
        String[] test = "123".split("");

        //  when

        //  then
        // 숫자가 아닌 값을 입력했을 때 IllegalArgumentException이 발생하는지 확인
        assertDoesNotThrow(() -> {
            util.isDuplicate(test);
        });
    }


    @Test
    @DisplayName("출력검사(볼,스트라이크)")
    void testBallStrikePrintCount() {
        // given
        int ball = 2;
        int strike = 1;

        // Capture System.out
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        // when
        util.printCount(strike, ball);

        // then
        String expectedOutput = "2볼 1스트라이크";
        assertLinesMatch(Arrays.asList(expectedOutput),
            Arrays.asList(outputStreamCaptor.toString().trim()));

    }

    @Test
    @DisplayName("출력검사(볼)")
    void testBallPrintCount() {
        // given
        int ball = 2;
        int strike = 0;

        // Capture System.out
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        // when
        util.printCount(strike, ball);

        // then
        String expectedOutput = "2볼";
        assertLinesMatch(Arrays.asList(expectedOutput),
            Arrays.asList(outputStreamCaptor.toString().trim()));

    }

    @Test
    @DisplayName("출력검사(스트라이크)")
    void testStrikePrintCount() {
        // given
        int ball = 0;
        int strike = 1;

        // Capture System.out
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        // when
        util.printCount(strike, ball);

        // then
        String expectedOutput = "1스트라이크";
        assertLinesMatch(Arrays.asList(expectedOutput),
            Arrays.asList(outputStreamCaptor.toString().trim()));

    }

    @Test
    @DisplayName("출력검사(볼)")
    void testNothingPrintCount() {
        // given
        int ball = 0;
        int strike = 0;

        // Capture System.out
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        // when
        util.printCount(strike, ball);

        // then
        String expectedOutput = "낫싱";
        assertLinesMatch(Arrays.asList(expectedOutput),
            Arrays.asList(outputStreamCaptor.toString().trim()));

    }
}