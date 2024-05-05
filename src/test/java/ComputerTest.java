import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComputerTest {

    @Test
    public void testMakeRandom() {
        // Given
        Computer computer = new Computer();

        // When
        int randomNumber = computer.makeRandom();

        // Then
        // 각 자릿수가 서로 다른지 확인
        int[] digits = new int[3];
        digits[0] = randomNumber / 100;
        digits[1] = (randomNumber / 10) % 10;
        digits[2] = randomNumber % 10;

        assertTrue(digits[0] != digits[1]);
        assertTrue(digits[0] != digits[2]);
        assertTrue(digits[1] != digits[2]);

        // 숫자가 1부터 9까지의 범위 내에 있는지 확인
        assertTrue(randomNumber >= 123 && randomNumber <= 987);
    }
}
