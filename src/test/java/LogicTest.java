import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LogicTest {

    private ArrayList<Integer> validNumbers;

    /**
     * Set up the valid numbers for testing
     */
    @BeforeEach
    void setUp() {
        validNumbers = generateValidNumbers();
    }

    /**
     * Generate valid numbers for testing<br> This numbers follow below rules<br> - 3 digits<br> -
     * All digits are different<br> - No digit is 0<br>
     *
     * @return list of valid numbers
     */
    ArrayList<Integer> generateValidNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 111; i <= 999; i++) {
            if (i % 111 == 0) { // skip numbers with all digits the same
                continue;
            }
            if ((i % 100) % 11 == 0 || (i / 10) % 11 == 0
                || i / 100 == i % 10) { // skip numbers with two digits the same
                continue;
            }
            if (i % 10 != 0 && i / 10 % 10 != 0) { // skip numbers with 0
                numbers.add(i);
            }
        }
        return numbers;
    }

    @Test
    void shouldGenerateValidNumbers() {
        for (int number : validNumbers) {
            assertThat(number).isBetween(111, 999);
            int[] digits = safeGetDigit(number);
            assertThat(digits[0]).isNotEqualTo(digits[1]);
            assertThat(digits[1]).isNotEqualTo(digits[2]);
            assertThat(digits[2]).isNotEqualTo(digits[0]);
            assertThat(digits[0]).isNotEqualTo(0);
            assertThat(digits[1]).isNotEqualTo(0);
            assertThat(digits[2]).isNotEqualTo(0);
        }
    }

    @Test
    void shuldModifyNumberCorrectly() {
        assertThat(modifyNumber(123, 0)).isEqualTo(213);
        assertThat(modifyNumber(123, 1)).isEqualTo(132);
        assertThat(modifyNumber(123, 2)).isEqualTo(123);
    }

    @Test
    void shouldSetComputerNumberCorrectly() {
        Logic logic = new Logic(123);
        assertThat(logic.getComputerNumber()).isEqualTo(123);
    }

    @Test
    void shouldCalculateStrikesCorrectly() {
        Logic edgeCaseLogic = new Logic(111);
        assertThat(edgeCaseLogic.isStrike(111)).isEqualTo(3);
        for (Integer number : validNumbers) {
            Logic logic = new Logic(number);
            assertThat(logic.isStrike(number)).isEqualTo(3);
            for (int j = 0; j < 3; j++) {
                int modifiedNumber = modifyNumber(number, j);
                logic.setComputerNumber(modifiedNumber);
                assertThat(logic.isStrike(number)).isEqualTo(1);
            }
        }
    }

    /**
     * Extracts each digit from a three-digit integer and returns them as an array. This method
     * operates independently from {@link Utils#getDigits} and is guaranteed to function correctly
     * with three-digit numbers.
     *
     * @param number number to get digits
     * @return array of digits
     */
    private int[] safeGetDigit(int number) {
        int[] ret = new int[3];
        ret[0] = number / 100;
        ret[1] = number / 10 % 10;
        ret[2] = number % 10;
        return ret;
    }


    /**
     * Adjust the numbers to match the 2 balls, 1 strike condition. swap the idx-th digit with the
     * (idx + 1) % 3-th digit.
     *
     * @param number number to modify
     * @param index  index of the digit to increment by 1
     * @return modified number
     */
    private int modifyNumber(int number, int index) {
        int[] digits = safeGetDigit(number);
        int tmp = digits[index];
        digits[index] = digits[(index + 1) % 3];
        digits[(index + 1) % 3] = tmp;
        return digits[0] * 100 + digits[1] * 10 + digits[2];
    }
}
