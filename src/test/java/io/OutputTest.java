package io;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputTest {
    
    @Test
    @DisplayName("3스트라이크가 나온 경우(정답)")
    void testPrintOutput_3Strikes() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Output.printOutput(3, 0);

        assertEquals("3스트라이크\n", output.toString());
    }

    @Test
    @DisplayName("스트라이크와 볼이 모두 나온 경우")
    void testPrintOutput_StrikeBall() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Output.printOutput(2, 1);

        assertEquals("1볼 2스트라이크\n", output.toString());
    }

    @Test
    @DisplayName("스트라이크만 나온 경우(정답은 아님)")
    void testPrintOutput_Strike() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Output.printOutput(2, 0);

        assertEquals("2스트라이크\n", output.toString());
    }

    @Test
    @DisplayName("볼만 나온 경우")
    void testPrintOutput_Ball() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Output.printOutput(0, 2);

        assertEquals("2볼\n", output.toString());
    }

    @Test
    @DisplayName("낫싱인 경우")
    void testPrintOutput_Nothing() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Output.printOutput(0, 0);

        assertEquals("낫싱\n", output.toString());
    }
}
