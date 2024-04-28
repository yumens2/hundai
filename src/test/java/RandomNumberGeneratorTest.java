import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {
    RandomNumberGenerator randomNumberGenerator;

    @BeforeEach
    void settings() {
        randomNumberGenerator = new RandomNumberGenerator();
    }

    @Test
    void appendRandomSingleDigit() {
        String randomNumber = new String("");
        randomNumberGenerator.appendRandomSingleDigit(randomNumber);
        Assertions.assertTrue(Character.isDigit(randomNumber.charAt(0)) && randomNumber.length() == 1);
    }
}