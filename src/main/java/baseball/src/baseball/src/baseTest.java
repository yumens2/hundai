package baseball.src;



import baseball.src.Main;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class baseTest {
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
    private static final String VALID_INPUT = "123" + LINE_SEPARATOR;
    private static final String INVALID_LENGTH_INPUT = "12" + LINE_SEPARATOR;
    private static final String INVALID_RANGE_INPUT = "102" + LINE_SEPARATOR;

    private static final int[] COMPUTER_NUMBERS = {1, 2, 3};
    private static final int[] USER_NUMBERS_ALL_MATCH = {1, 2, 3};
    private static final int[] USER_NUMBERS_PARTIAL_MATCH = {1, 4, 2};
    private static final int[] USER_NUMBERS_NO_MATCH = {4, 5, 6};

    private static ByteArrayInputStream validInputStream;
    private static ByteArrayInputStream invalidLengthInputStream;
    private static ByteArrayInputStream invalidRangeInputStream;

    @BeforeAll
    static void setUpStreams() {
        validInputStream = new ByteArrayInputStream(VALID_INPUT.getBytes());
        invalidLengthInputStream = new ByteArrayInputStream(INVALID_LENGTH_INPUT.getBytes());
        invalidRangeInputStream = new ByteArrayInputStream(INVALID_RANGE_INPUT.getBytes());
    }

    @AfterAll
    static void closeStreams() {
        validInputStream = null;
        invalidLengthInputStream = null;
        invalidRangeInputStream = null;
    }

    @Test
    void testGenerateComputerNumbers() {
        int[] numbers = Main.generateComputerNumbers();
        assertEquals(3, numbers.length, "생성된 숫자 배열의 길이가 3이어야 합니다.");
        for (int number : numbers) {
            assertTrue(number >= Main.MIN_NUMBER && number <= Main.MAX_NUMBER, "숫자 범위 확인");
        }
    }

    @Test
    void testGetUserNumbers() {
        System.setIn(validInputStream);
        int[] userNumbers = Main.getUserNumbers(new Scanner(System.in));
        assertNotNull(userNumbers, "유효한 입력이 제대로 처리되어야 합니다.");

        System.setIn(invalidLengthInputStream);
        assertThrows(IllegalArgumentException.class, () -> Main.getUserNumbers(new Scanner(System.in)),
                "올바르지 않은 길이의 입력이 예외를 발생시켜야 합니다.");

        System.setIn(invalidRangeInputStream);
        assertThrows(IllegalArgumentException.class, () -> Main.getUserNumbers(new Scanner(System.in)),
                "올바르지 않은 범위의 입력이 예외를 발생시켜야 합니다.");
    }

    @Test
    void testCheckMatch() {
        assertFalse(Main.checkMatch(COMPUTER_NUMBERS, USER_NUMBERS_NO_MATCH), "일치하는 숫자가 없으면 false를 반환해야 합니다.");
        assertTrue(Main.checkMatch(COMPUTER_NUMBERS, USER_NUMBERS_ALL_MATCH), "모든 숫자가 일치하면 true를 반환해야 합니다.");
        assertFalse(Main.checkMatch(COMPUTER_NUMBERS, USER_NUMBERS_PARTIAL_MATCH), "부분적으로 일치하면 false를 반환해야 합니다.");
    }

    @Test
    void testGameRestartChoice() {
        // 다시 시작 선택
        System.setIn(new ByteArrayInputStream("1\n".getBytes()));
        assertTrue(Main.gameRestartChoice(new Scanner(System.in)), "1을 입력하면 true를 반환해야 합니다.");

        // 종료 선택
        System.setIn(new ByteArrayInputStream("2\n".getBytes()));
        assertFalse(Main.gameRestartChoice(new Scanner(System.in)), "2를 입력하면 false를 반환해야 합니다.");
    }
}
