package common.module;

import static domain.BaseballGame.MAX_NUMBER;
import static domain.BaseballGame.MIN_NUMBER;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @Test
    @DisplayName("주어진 범위 내에서 랜덤한 숫자를 생성한다.")
    public void computerGenerateNumber() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        int number = randomNumberGenerator.generateRandomNumberInRange(MIN_NUMBER, MAX_NUMBER);
        assertTrue(number >= MIN_NUMBER && number <= MAX_NUMBER);
    }
}
