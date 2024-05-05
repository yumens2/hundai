import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ApplicationJUnit5Test {
    // 테스트 메서드 작성
    @Test
    void testMakeNum() {
        int[] num = Application.makeNum();
        // 3자리 수인가?
        Assertions.assertEquals(3, num.length);
        // 1~9 사이 숫자인가?
        assertTrue(num[0] >= 1 && num[0] <= 9);
        assertTrue(num[1] >= 1 && num[1] <= 9);
        assertTrue(num[2] >= 1 && num[2] <= 9);
        // 중복된 수가 있는가?
        Assertions.assertNotEquals(num[0], num[1]);
        Assertions.assertNotEquals(num[0], num[2]);
        Assertions.assertNotEquals(num[1], num[2]);
    }
    @Test
    void testPlayerInput() {
        // 정상적인 입력
        Assertions.assertArrayEquals(new int[]{1, 2, 3}, Application.playerInput("123"));

        // 길이가 3미만인 경우
        Assertions.assertThrows(IllegalArgumentException.class, () -> Application.playerInput("12"));
        // 길이가 3초과인 경우
        Assertions.assertThrows(IllegalArgumentException.class, () -> Application.playerInput("1234"));

        // 0이 포함된 경우
        Assertions.assertThrows(IllegalArgumentException.class, () -> Application.playerInput("012"));

        // 중복된 숫자가 있는 경우
        Assertions.assertThrows(IllegalArgumentException.class, () -> Application.playerInput("112"));
    }
    @Test
    void testConvert() {
        Assertions.assertArrayEquals(new int[]{1, 2, 3}, Application.convertIntArray("123"));
    }

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testCompareNum_NothingMatch() {
        int[] qNum = {1, 2, 3};
        int[] pNum = {4, 5, 6};
        boolean result = Application.compareNum(qNum, pNum);

        Assertions.assertTrue(result);
        Assertions.assertEquals("낫싱\n", outContent.toString());
    }

    @Test
    void testCompareNum_OneStrike() {
        int[] qNum = {1, 2, 3};
        int[] pNum = {1, 4, 5};
        boolean result = Application.compareNum(qNum, pNum);

        Assertions.assertTrue(result);
        Assertions.assertEquals("1스트라이크\n", outContent.toString());
    }

    @Test
    void testCompareNum_TwoBalls() {
        int[] qNum = {1, 2, 3};
        int[] pNum = {2, 3, 4};
        boolean result = Application.compareNum(qNum, pNum);

        Assertions.assertTrue(result);
        Assertions.assertEquals("2볼\n", outContent.toString());
    }

    @Test
    void testCompareNum_ThreeStrikes() {
        int[] qNum = {1, 2, 3};
        int[] pNum = {1, 2, 3};
        boolean result = Application.compareNum(qNum, pNum);

        Assertions.assertFalse(result);
    }

    @Test
    void testRestart() {
        // 1을 입력한 경우
        assertTrue(Application.restart("1"));

        // 2를 입력한 경우
        assertFalse(Application.restart("2"));

        // 잘못된 입력인 경우
        Assertions.assertThrows(IllegalArgumentException.class, () -> Application.restart("3"));
    }

}
