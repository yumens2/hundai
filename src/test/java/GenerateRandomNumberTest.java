import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GenerateRandomNumberTest {
    @DisplayName("랜덤 수 생성")
    @Test
    void randomNum() {
        // given
        GenerateRandomNumber generator = new GenerateRandomNumber();

        // when
        StringBuilder randomNum1 = generator.randomNum();
        StringBuilder randomNum2 = generator.randomNum();

        // then
            // 생성된 수가 null이 아닌가?
        assertNotNull(randomNum1);
        assertNotNull(randomNum2);

            // 생성된 두 수가 다른가?
        assertNotEquals(randomNum1.toString(), randomNum2.toString());

            // 생성된 두 수의 길이가 3인가?
        assertEquals(3, randomNum1.length());
        assertEquals(3, randomNum2.length());
    }

}
