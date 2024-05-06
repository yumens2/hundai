package IO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputTest {
    private InputStream systemIn;

    @BeforeEach
    void setUp() {
        systemIn = System.in;
    }

    @AfterEach
    void tearDown() {
        System.setIn(systemIn);
    }

    @Test
    void inputStartGame() {
        String input = "2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int choice = Input.inputStartGame();

        assertEquals(2, choice);
    }

    @Test
    void inputGameNumber() {
        String input = "456\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int[] guess = Input.inputGameNumber();

        assertArrayEquals(new int[]{4, 5, 6}, guess);
    }
}