package utility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @Test
    @DisplayName("생성된 숫자 형식 확인 테스트")
    void getRandomNumber() {
        String randomNumber = RandomNumberGenerator.getRandomNumber();
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
}