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
    void appendRandomSingleDigit() {
        List<String> randomNumberList = new ArrayList<>();
        randomNumberGenerator.appendRandomSingleDigit(randomNumberList);
        Assertions.assertTrue(Character.isDigit(randomNumberList.get(0).charAt(0)) && randomNumberList.size() == 1);
    }
}