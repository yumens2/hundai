import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
    void shouldInitCorrectly() {
        Logic logic = new Logic();
        assertThat(logic.getComputerNumber()).isIn(validNumbers);
        assertThat(logic.getComputerDigits()).isEqualTo(safeGetDigit(logic.getComputerNumber()));
    }

    @ParameterizedTest
    @ValueSource(ints = {222, 234, 345, 456, 567, 678, 789, 893, 932})
    @DisplayName("Nothing test")
    void shouldReturnNothing(int number) {
        Logic logic = new Logic(111);
        assertThat(logic.isBall(number)).isEqualTo(0);
        assertThat(logic.isStrike(number)).isEqualTo(0);
        assertThat(logic.isNothing(number)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {222, 234, 345, 456, 557, 678, 788, 898, 932})
    @DisplayName("3strike 0ball test")
    void shouldReturn3strike(int number) {
        Logic logic = new Logic(number);
        assertThat(logic.isBall(number)).isEqualTo(0);
        assertThat(logic.isStrike(number)).isEqualTo(3);
        assertThat(logic.isNothing(number)).isFalse();
    }

    @Test
    @DisplayName("1strike 2ball test")
    void shouldReturn1strike2ball() {
        Logic logic = new Logic(123);
        assertThat(logic.isBall(132)).isEqualTo(2);
        assertThat(logic.isStrike(132)).isEqualTo(1);
        assertThat(logic.isNothing(132)).isFalse();

        assertThat(logic.isBall(213)).isEqualTo(2);
        assertThat(logic.isStrike(213)).isEqualTo(1);
        assertThat(logic.isNothing(213)).isFalse();
    }

    @Test
    @DisplayName("2strike 0ball test")
    void shouldReturn2strike1ball() {
        Logic logic1 = new Logic(123);
        int[] testCase1 = {129, 923, 193};
        for (int i : testCase1) {
            assertThat(logic1.isBall(i)).isEqualTo(0);
            assertThat(logic1.isStrike(i)).isEqualTo(2);
            assertThat(logic1.isNothing(i)).isFalse();
        }

        Logic logic2 = new Logic(111);
        int[] testCase2 = {112, 121, 211};
        for (int i : testCase2) {
            assertThat(logic2.isBall(i)).isEqualTo(0);
            assertThat(logic2.isStrike(i)).isEqualTo(2);
            assertThat(logic2.isNothing(i)).isFalse();
        }
    }

    @Test
    @DisplayName("0strike 3ball test")
    void shouldReturn0strike3ball() {
        Logic logic = new Logic(123);
        int[] testCase = {231, 312};
        for (int i : testCase) {
            assertThat(logic.isBall(i)).isEqualTo(3);
            assertThat(logic.isStrike(i)).isEqualTo(0);
            assertThat(logic.isNothing(i)).isFalse();
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
}
