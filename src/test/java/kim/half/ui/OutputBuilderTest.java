package kim.half.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

public class OutputBuilderTest {

    @Test
    void testPrintRequestNumberInput() {
        // Redirect System.out
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        // Test
        OutputBuilder.printRequestNumberInput();

        // Restore System.out
        System.setOut(System.out);

        // Verify
        assertEquals(OutputBuilder.REQUIRE_NUMBER_INPUT_MESSAGE, outputStreamCaptor.toString());
    }

    @Test
    void testPrintRequestResumeInput() {
        // Redirect System.out
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        // Test
        OutputBuilder.printRequestResumeInput();

        // Restore System.out
        System.setOut(System.out);

        // Verify
        assertEquals(OutputBuilder.REQUIRE_RESTART_INPUT_MESSAGE + "\n",
            outputStreamCaptor.toString());
    }

    @Test
    void testPrintBaseballGameResult() {
        // Redirect System.out
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        // Test
        OutputBuilder.printBaseballGameResult("Result");

        // Restore System.out
        System.setOut(System.out);

        // Verify
        assertEquals("Result\n", outputStreamCaptor.toString());
    }

    @Test
    void testPrintCorrectAnswer() {
        // Redirect System.out
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        // Test
        OutputBuilder.printCorrectAnswer();

        // Restore System.out
        System.setOut(System.out);

        // Verify
        assertEquals(OutputBuilder.CORRECT_ANSWER_AND_EXIT_MESSAGE + "\n",
            outputStreamCaptor.toString());
    }

    @Test
    void testPrintExceptionMessage() {
        // Redirect System.out
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        // Test
        OutputBuilder.printExceptionMessage("Exception message");

        // Restore System.out
        System.setOut(System.out);

        // Verify
        assertEquals("Exception message\n", outputStreamCaptor.toString());
    }
}
