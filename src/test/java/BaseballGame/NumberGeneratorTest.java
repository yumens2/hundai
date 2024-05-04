package BaseballGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumberGeneratorTest {
    NumberGenerator generator = new NumberGenerator();

    @Test
    @DisplayName("생성된 번호가 Null이 아닌지 확인")
    public void checkNotNullNumber() {
        String generatedNumber = generator.generateNumber();

        assertNotNull(generatedNumber);
    }

    @Test
    @DisplayName("생성된 번호가 세 자리인지 확인")
    public void checkLengthNumber() {
        String generatedNumber = generator.generateNumber();

        assertEquals(3, generatedNumber.length());
    }

    @Test
    @DisplayName("생성된 번호가 숫자인지 확인")
    public void testGenerateNumber() {
        String generatedNumber = generator.generateNumber();

        assertTrue(generatedNumber.matches("[0-9]+"));
    }

    @Test
    @DisplayName("생성된 번호가 중복된 숫자를 포함하지 않는지 확인")
    public void checkDuplicateNumber() {
        String generatedNumber = generator.generateNumber();

        for (int i = 0; i < generatedNumber.length(); i++) {
            for (int j = i + 1; j < generatedNumber.length(); j++) {
                assertNotEquals(generatedNumber.charAt(i), generatedNumber.charAt(j));
            }
        }
    }
}