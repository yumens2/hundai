package src.game;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static src.util.Validator.checkDuplicatedDigits;

import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    // 1-9 사이 3자리 숫자
    private final Pattern VALID_NUMBER_PATTERN = Pattern.compile("^[1-9]{3}$");

    @Test
    @DisplayName("난수 생성 테스트")
    void generateRandomNumberTest() {
        //given
        int randomNumber = RandomNumberGenerator.generateRandomNumber();
        String randomNumberStr = String.valueOf(randomNumber);

        //when

        //then
        assertFalse(checkDuplicatedDigits(randomNumberStr));
        assertTrue(VALID_NUMBER_PATTERN.matcher(randomNumberStr).matches(), "숫자가 1부터 9 사이가 아닙니다.");
    }
}