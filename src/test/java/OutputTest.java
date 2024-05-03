package View;


import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OutputTest {
    @Test
    void printResult() {
        int strikes = 1;
        int balls = 2;
        String result = Output.printResult(strikes, balls);
        assertEquals("1 스트라이크, 2 볼", result);
    }
}