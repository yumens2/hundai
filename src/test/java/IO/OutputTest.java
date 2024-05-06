package IO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class OutputTest {
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
    @DisplayName("낫싱")
    void printGameResult() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Output.printGameResult(0, 0);

        assertEquals("낫싱\n", output.toString());
    }

}