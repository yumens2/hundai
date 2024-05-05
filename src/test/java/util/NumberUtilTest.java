package util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberUtilTest {
    @Test
    @DisplayName("generate random number length is 3 test")
    void generateRandomNumberLengthIs3Test() throws Exception {
        int[] numbers = NumberUtil.generateRandomNumber();
        assertThat(numbers).hasSize(3);
    }

    @Test
    @DisplayName("generateRandomNumber elements in range test")
    void generateRandomNumberElementsInRangeTest() throws Exception {
        int[] numbers = NumberUtil.generateRandomNumber();
        for(int number : numbers) {
            assertThat(number).isBetween(1, 9);
        }
    }

    @Test
    @DisplayName("generate random number distinct elements test")
    void generateRandomNumberDistinctElementsTest() throws Exception {
        int[] numbers = NumberUtil.generateRandomNumber();
        assertThat(numbers).doesNotHaveDuplicates();
    }

    @DisplayName("parseStringToNumbers invalid input test")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings =  {
        "12316",
        "13",
        "7",
        "",
        "-156",
        "-12",
        "abc",
        "a",
        "abcd"
    })
    void parseStringToNumbersInvalidInputTest(String input) throws Exception {
        //given

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            NumberUtil.parseStringToNumbers(input);
        });
    }

    @DisplayName("parseStringToNumbers feature test")
    @ParameterizedTest
    @ValueSource(strings = {
        "123",
        "134",
        "738",
        "541",
        "000"
    })
    void parseStringToNumbersFeatureTest(String input) throws Exception {
        //given

        //when
        int[] result = NumberUtil.parseStringToNumbers(input);

        int firstDigit = Character.getNumericValue(input.charAt(0));
        int secondDigit = Character.getNumericValue(input.charAt(1));
        int thirdDigit = Character.getNumericValue(input.charAt(2));

        //then
        assertThat(result[0]).isEqualTo(firstDigit);
        assertThat(result[1]).isEqualTo(secondDigit);
        assertThat(result[2]).isEqualTo(thirdDigit);
    }

    @Test
    @DisplayName("isDistinctNumbers test")
    void isDistinctNumbersTest() throws Exception {
        //given
        int[] distinctNumbers = {1, 2, 3};
        int[] nonDistinctNumbers = {1, 2, 2};
        int[] outOfRangeNumbers = {0, 1, 2};
        
        //when
        boolean result1 = NumberUtil.isDistinctNumbers(distinctNumbers);
        boolean result2 = NumberUtil.isDistinctNumbers(nonDistinctNumbers);
        boolean result3 = NumberUtil.isDistinctNumbers(outOfRangeNumbers);
        
        //then
        assertThat(result1).isTrue();
        assertThat(result2).isFalse();
        assertThat(result3).isFalse();
    }
}
