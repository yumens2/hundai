import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class RandomNumberGeneratorTest {
    RandomNumberGenerator randomNumberGenerator;

    @BeforeEach
    void settings() {
        randomNumberGenerator = new RandomNumberGenerator();
    }

    @Test
    void getRandomNumber() {
        String randomNumber = randomNumberGenerator.getRandomNumber();
        org.assertj.core.api.Assertions.assertThat(randomNumber.length()).isEqualTo(3);
        Assertions.assertDoesNotThrow(() -> (Integer.parseInt(randomNumber)));
        for (int i = 0; i < randomNumber.length(); i++) {
            char currentDigit = randomNumber.charAt(i);
            int digitCount = Math.toIntExact(randomNumber.chars()
                    .filter((ch) -> (ch == currentDigit))
                    .count());
            org.assertj.core.api.Assertions.assertThat(digitCount).isEqualTo(1);
        }
    }

    @Test
    void appendRandomSingleDigit() {
        List<String> randomNumberList = new ArrayList<>();
        randomNumberGenerator.appendRandomSingleDigit(randomNumberList);
        Assertions.assertTrue(Character.isDigit(randomNumberList.get(0).charAt(0)) && randomNumberList.size() == 1);
    }
}