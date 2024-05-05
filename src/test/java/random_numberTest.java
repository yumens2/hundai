import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class random_numberTest {

    @Test
    public void testRandomNumber() {
        // 여러 번 테스트하여 랜덤한 서로 다른 세 자리 수가 잘 생성되는지 확인
        for (int i = 0; i < 100; i++) {
            String randomNumber = BaseballGame.random_number();

            // 생성된 숫자가 세 자리인지 확인
            assertEquals(3, randomNumber.length());

            // 생성된 숫자가 서로 다른 세 자리 수인지 확인
            assertTrue(BaseballGame.UniqueDigits(randomNumber));
        }
    }

}
