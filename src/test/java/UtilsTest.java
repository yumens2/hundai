import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UtilsTest {

    @Test
    void getDigits() {
        int[] digits = Utils.getDigits(123);
        assertArrayEquals(new int[]{1, 2, 3}, digits);
        digits = Utils.getDigits(111);
        assertArrayEquals(new int[]{1, 1, 1}, digits);
        digits = Utils.getDigits(122);
        assertArrayEquals(new int[]{1, 2, 2}, digits);
    }
}