import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BallCountTest {
    // 컴퓨터 숫자를 123이라고 가정할 때 볼카운트의 계산에 대한 테스트
    @Test
    void testBallCount() {
        BallCount ballCount = new BallCount();
        List<Integer> Cnum = List.of(1, 2, 3);
        assertTrue(ballCount.Count("123",Cnum));
        assertFalse(ballCount.Count("234", Cnum));

    }

}
