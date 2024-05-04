package util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberUtilTest {
    @Test
    @DisplayName("generate random number length is 3 test")
    void generateRandomNumberLengthIs3Test() throws Exception {
        int[] numbers = NumberUtil.generateRandomNumber();
        Assertions.assertThat(numbers).hasSize(3);
    }

    @Test
    @DisplayName("generateRandomNumber elements in range test")
    void generateRandomNumberElementsInRangeTest() throws Exception {
        int[] numbers = NumberUtil.generateRandomNumber();
        for(int number : numbers) {
            Assertions.assertThat(number).isBetween(1, 9);
        }
    }

    @Test
    @DisplayName("generate random number distinct elements test")
    void generateRandomNumberDistinctElementsTest() throws Exception {
        int[] numbers = NumberUtil.generateRandomNumber();
        Assertions.assertThat(numbers).doesNotHaveDuplicates();
    }
}
