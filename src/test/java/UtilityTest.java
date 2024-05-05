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
}