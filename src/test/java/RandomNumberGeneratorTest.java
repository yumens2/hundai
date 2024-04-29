import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @Test
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