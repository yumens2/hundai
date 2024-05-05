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
        Assertions.assertThatCode(() -> Utility.checkStringLength("123")).doesNotThrowAnyException();
        Assertions.assertThatCode(() -> Utility.checkStringLength("abc")).doesNotThrowAnyException();
        Assertions.assertThatCode(() -> Utility.checkStringLength("000")).doesNotThrowAnyException();
        Assertions.assertThatThrownBy(() -> Utility.checkStringLength("")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> Utility.checkStringLength("11111")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> Utility.checkStringLength("zbcda")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testCheckStringDistinct() {
        Assertions.assertThatCode(() -> Utility.checkStringDistinct("123")).doesNotThrowAnyException();
        Assertions.assertThatCode(() -> Utility.checkStringDistinct("123456789")).doesNotThrowAnyException();
        Assertions.assertThatCode(() -> Utility.checkStringDistinct("abc")).doesNotThrowAnyException();
        Assertions.assertThatThrownBy(() -> Utility.checkStringDistinct("111")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> Utility.checkStringDistinct("12345678910")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> Utility.checkStringDistinct("aa")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testCheckStringDigit() {
        Assertions.assertThatCode(() -> Utility.checkStringDigit("123")).doesNotThrowAnyException();
        Assertions.assertThatCode(() -> Utility.checkStringDigit("123456789101112")).doesNotThrowAnyException();
        Assertions.assertThatCode(() -> Utility.checkStringDigit("")).doesNotThrowAnyException();
        Assertions.assertThatThrownBy(() -> Utility.checkStringDigit("1k3")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> Utility.checkStringDigit("abc")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> Utility.checkStringDigit("111111111a")).isInstanceOf(IllegalArgumentException.class);
    }
}