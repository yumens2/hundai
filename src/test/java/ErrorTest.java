import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErrorTest {

    @Test
    //check this is 3-digit number
    void detectErrorTrue() {
        Error error = new Error();
        assertEquals(error.detectError("123"), 1);

    }

    @Test
    //check 3-digit number
    void detectErrorFalse() {
        Error error = new Error();
        assertEquals(error.detectError("1234"), 2);

    }

    @Test
    //check redundant number
    void isValidDataRedundant() {
        Error error = new Error();
        assertEquals(error.isValidData("112"), true);
    }

    @Test
    //check not number like String
    void isValidDataString() {
        Error error = new Error();
        assertEquals(error.isValidData("1h3"), true);
    }
}