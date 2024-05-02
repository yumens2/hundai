//import baseball.utils.GenerateRandomNumber;
//import baseball.utils.StringToArrayList;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//public class UtilTest {
//
//    @Test
//    public void generate_ShouldReturnListWithCorrectLength() {
//
//        GenerateRandomNumber generator = new GenerateRandomNumber();
//
//        List<Integer> result = generator.generate();
//
//        Assertions.assertThat(result).hasSize(GenerateRandomNumber.LENGTH);
//    }
//
//    @Test
//    public void generate_ShouldContainNumbersWithinRange() {
//
//        GenerateRandomNumber generator = new GenerateRandomNumber();
//
//        List<Integer> result = generator.generate();
//
//        for (Integer number : result) {
//            Assertions.assertThat(number)
//                .isBetween(GenerateRandomNumber.MIN_NUMBER, GenerateRandomNumber.MAX_NUMBER);
//        }
//    }
//
//    @Test
//    public void generate_ShouldNotContainDuplicates() {
//
//        GenerateRandomNumber generator = new GenerateRandomNumber();
//
//        List<Integer> result = generator.generate();
//
//        Assertions.assertThat(result).doesNotHaveDuplicates();
//    }
//
//    @Test
//    public void parse_ShouldConvertEmptyStringToEmptyList() {
//        // Given
//        String input = "";
//
//        // When
//        List<Integer> result = StringToArrayList.parse(input);
//
//        // Then
//        Assertions.assertThat(result).isEmpty();
//    }
//
//    @Test
//    public void parse_ShouldConvertSingleDigitStringToList() {
//
//        String input = "5";
//
//        List<Integer> result = StringToArrayList.parse(input);
//
//        Assertions.assertThat(result).containsExactly(5);
//    }
//
//    @Test
//    public void parse_ShouldConvertMultipleDigitsStringToList() {
//
//        String input = "123";
//
//        List<Integer> result = StringToArrayList.parse(input);
//
//        Assertions.assertThat(result).containsExactly(1, 2, 3);
//    }
//
//
//}