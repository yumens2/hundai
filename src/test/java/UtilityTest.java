import java.util.HashSet;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

class UtilityTest {

    @Test
    void testMakeRandomNumbers() {
        // 난수를 체크하므로 충분히 많은 테스트를 반복
        for (int i = 0; i < 1000; i++) {
            int[] randomNumbers = Utility.makeRandomNumbers();

            Assertions.assertThat(randomNumbers).hasSize(3);

            HashSet<Integer> tempSet = new HashSet<>();
            for (int randomNumber : randomNumbers) {
                tempSet.add(randomNumber);
            }
            Assertions.assertThat(randomNumbers).hasSize(tempSet.size());

            for (int j = 0; j < 3; j++) {
                Assertions.assertThat(randomNumbers[j]).isBetween(0, 9);
            }
        }
    }

    @Test
    void testCheckStringLength() {
        Assertions.assertThat(Utility.checkStringLength("123")).isTrue();
        Assertions.assertThat(Utility.checkStringLength("12")).isFalse();
        Assertions.assertThat(Utility.checkStringLength("1")).isFalse();
        Assertions.assertThat(Utility.checkStringLength("")).isFalse();
        Assertions.assertThat(Utility.checkStringLength("1234")).isFalse();
        Assertions.assertThat(Utility.checkStringLength("12 45")).isFalse();
    }

    @Test
    void testCheckStringDistinct() {
        Assertions.assertThat(Utility.checkStringDistinct("123")).isTrue();
        Assertions.assertThat(Utility.checkStringDistinct("abc")).isTrue();
        Assertions.assertThat(Utility.checkStringDistinct("123456789")).isTrue();
        Assertions.assertThat(Utility.checkStringDistinct("112")).isFalse();
        Assertions.assertThat(Utility.checkStringDistinct("aaa")).isFalse();
        Assertions.assertThat(Utility.checkStringDistinct("99")).isFalse();
    }
}