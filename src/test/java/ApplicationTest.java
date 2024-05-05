import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ApplicationTest {

    @Test
    public void testCompareAndPrintResult() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Application app = new Application();
        app.computerNumber = new int[]{1, 2, 3};

        int[] userInput1 = {1, 2, 3};
        app.compareAndPrintResult(userInput1);
        assertEquals("3스트라이크 0볼\n", outContent.toString());
        outContent.reset();

        int[] userInput2 = {3, 2, 1};
        app.compareAndPrintResult(userInput2);
        assertEquals("1스트라이크 2볼\n", outContent.toString());
        outContent.reset();

        int[] userInput3 = {4, 5, 6};
        app.compareAndPrintResult(userInput3);
        assertEquals("낫싱\n", outContent.toString());
    }

}
