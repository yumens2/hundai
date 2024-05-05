import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class check_start_test {

    @Test
    public void testCheckStartRetry() {
        String result = BaseballGame.check_start(1, "123");
        assertNotNull(result);
        assertNotEquals("123", result); //랜덤 난수를 다시 받아왔으므로 123과 같지 않아야 하고
        result = BaseballGame.check_start(2, "123"); //start에 1 대입되는 수가 1이 아니라면
        assertTrue(BaseballGame.UniqueDigits(result)); // 123을 그대로 리턴해야한다.
    }

    @Test
    public void testCheckStartNoRetry() {
        String result = BaseballGame.check_start(0, "123");
        assertEquals("123", result);
    }


}
