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
                Assertions.assertThat(randomNumbers[j]).isBetween(1, 9);
            }
        }
    }

    @Test
    void testCheckStringLength() {
        Assertions.assertThatCode(() -> Utility.checkStringLength("123"))
            .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> Utility.checkStringLength("abc"))
            .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> Utility.checkStringLength("000"))
            .doesNotThrowAnyException();
        Assertions.assertThatThrownBy(() -> Utility.checkStringLength(""))
            .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> Utility.checkStringLength("11111"))
            .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> Utility.checkStringLength("zbcda"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testCheckStringDistinct() {
        Assertions.assertThatCode(() -> Utility.checkStringDistinct("123"))
            .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> Utility.checkStringDistinct("123456789"))
            .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> Utility.checkStringDistinct("abc"))
            .doesNotThrowAnyException();
        Assertions.assertThatThrownBy(() -> Utility.checkStringDistinct("111"))
            .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> Utility.checkStringDistinct("12345678910"))
            .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> Utility.checkStringDistinct("aa"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testCheckStringDigit() {
        Assertions.assertThatCode(() -> Utility.checkStringDigit("123")).doesNotThrowAnyException();
        Assertions.assertThatCode(() -> Utility.checkStringDigit("12345678911112"))
            .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> Utility.checkStringDigit("")).doesNotThrowAnyException();
        Assertions.assertThatThrownBy(() -> Utility.checkStringDigit("1k3"))
            .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> Utility.checkStringDigit("abc"))
            .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> Utility.checkStringDigit("1111111110"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testStringToIntArray() {
        int[] temp1 = {1, 2, 3};
        Assertions.assertThat(Utility.stringToIntArray("123")).isEqualTo(temp1);
        int[] temp2 = {5, 4, 3};
        Assertions.assertThat(Utility.stringToIntArray("543")).isEqualTo(temp2);
        int[] temp3 = {2, 4, 6};
        Assertions.assertThat(Utility.stringToIntArray("246")).isEqualTo(temp3);
    }

    @Test
    void testStrikeCount() {
        int[] randomNumbers = {1, 2, 3};
        int[] userNumbers = {1, 2, 3};
        Assertions.assertThat(Utility.strikeCount(randomNumbers, userNumbers)).isEqualTo(3);
        int[] userNumbers2 = {1, 4, 3};
        Assertions.assertThat(Utility.strikeCount(randomNumbers, userNumbers2)).isEqualTo(2);
        int[] userNumbers3 = {1, 4, 5};
        Assertions.assertThat(Utility.strikeCount(randomNumbers, userNumbers3)).isEqualTo(1);
        int[] userNumbers4 = {2, 4, 5};
        Assertions.assertThat(Utility.strikeCount(randomNumbers, userNumbers4)).isEqualTo(0);
    }

    @Test
    void testBallCount() {
        int[] randomNumbers = {1, 2, 3};
        int[] userNumbers = {2, 3, 1};
        Assertions.assertThat(Utility.ballCount(randomNumbers, userNumbers)).isEqualTo(3);
        int[] userNumbers2 = {1, 3, 2};
        Assertions.assertThat(Utility.ballCount(randomNumbers, userNumbers2)).isEqualTo(2);
        int[] userNumbers3 = {5, 6, 1};
        Assertions.assertThat(Utility.ballCount(randomNumbers, userNumbers3)).isEqualTo(1);
        int[] userNumbers4 = {1, 2, 3};
        Assertions.assertThat(Utility.ballCount(randomNumbers, userNumbers4)).isEqualTo(0);
    }

    @Test
    void testGetStrikeBall() {
        Assertions.assertThat(Utility.getStrikeBall(3, 0)).isEqualTo("3스트라이크");
        Assertions.assertThat(Utility.getStrikeBall(1, 1)).isEqualTo("1볼 1스트라이크");
        Assertions.assertThat(Utility.getStrikeBall(0, 2)).isEqualTo("2볼");
        Assertions.assertThat(Utility.getStrikeBall(0, 0)).isEqualTo("낫싱");
    }
}