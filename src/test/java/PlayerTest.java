import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import java.io.*;

public class PlayerTest {

    private ByteArrayInputStream testIn;

    @Test
    @DisplayName("3자리의 유효한 숫자 입력하기")
    public void inputplayernumTest_ValidInput() {
        Player player = new Player();
        int[] playernum = new int[3];

        testIn = new ByteArrayInputStream("123".getBytes());
        System.setIn(testIn);

        //assertDoesNotThrow()는 해당 메소드가 유효한 입력에 대해 예외를 발생시키지 않는지 확인하는데 사용됩니다.
        assertDoesNotThrow(() -> {
            player.inputplayernum(playernum);
        });
        assertArrayEquals(new int[]{1, 2, 3}, playernum);
    }

    @Test
    @DisplayName("정수가 아닌 값 입력하기")
    public void inputplayernumTest_NoIntegerInput() {
        Player player = new Player();
        int[] playernum = new int[3];

        testIn = new ByteArrayInputStream("abc".getBytes());
        System.setIn(testIn);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            player.inputplayernum(playernum);
        });
        assertEquals("잘못 입력했습니다. 정수만 입력 가능합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("3자리가 아닌 정수 입력하기")
    public void inputplayernumTest_InvalidRange() {
        Player player = new Player();
        int[] playernum = new int[3];

        testIn = new ByteArrayInputStream("9999".getBytes());
        System.setIn(testIn);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            player.inputplayernum(playernum);
        });
        assertEquals("3자리 숫자가 아닙니다.", exception.getMessage());
    }

    @Test
    @DisplayName("중복된 숫자가 있는 값 입력하기")
    public void inputplayernumTest_Duplicate() {
        Player player = new Player();
        int[] playernum = new int[3];

        testIn = new ByteArrayInputStream("112".getBytes());
        System.setIn(testIn);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            player.inputplayernum(playernum);
        });
        assertEquals("중복해서 숫자를 사용하면 안됩니다.", exception.getMessage());
    }

    @Test
    @DisplayName("0이 있는 숫자 입력하기")
    public void inputplayernumTest_Zero() {
        Player player = new Player();
        int[] playernum = new int[3];

        testIn = new ByteArrayInputStream("102".getBytes());
        System.setIn(testIn);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
            () -> player.inputplayernum(playernum));
        assertEquals("0은 사용할 수 없습니다.", exception.getMessage());
    }
}
