package kim.half.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputScannerTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final ByteArrayInputStream inputStreamCaptor = new ByteArrayInputStream(
        "123".getBytes());

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setIn(System.in);
    }

    @Test
    void testScanInputNumbers() {
        // Redirect input
        InputStream originalInput = System.in;
        System.setIn(inputStreamCaptor);

        // Test
        String input = InputScanner.scanInputNumbers();

        // Restore original input
        System.setIn(originalInput);

        // Verify
        assertEquals("123", input);
    }

    @Test
    void testScanResumeChoice() {
        // Redirect input
        InputStream originalInput = System.in;
        System.setIn(inputStreamCaptor);

        // Test
        String choice = InputScanner.scanResumeChoice();

        // Restore original input
        System.setIn(originalInput);

        // Verify
        assertEquals("123", choice);
    }
}