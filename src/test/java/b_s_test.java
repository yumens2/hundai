import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class b_s_test {

    @Test
    public void testBSMethod() {
        int[] judgement = new int[2];

        // 예제: com = "123", num = "152", 예상 결과: 1B 1S
        Application.b_s("123", "152", judgement);
        assertEquals(1, judgement[0]); // 예상 결과: 1
        assertEquals(1, judgement[1]); // 예상 결과: 1

        //초기화
        judgement[0] = 0;
        judgement[1] = 0;

        Application.b_s("847", "284", judgement);
        assertEquals(2, judgement[0]); // 예상 결과: 2
        assertEquals(0, judgement[1]); // 예상 결과: 0

        //초기화
        judgement[0] = 0;
        judgement[1] = 0;

        Application.b_s("285", "137", judgement);
        assertEquals(0, judgement[0]); // 예상 결과: 0
        assertEquals(0, judgement[1]); // 예상 결과: 0

        //초기화
        judgement[0] = 0;
        judgement[1] = 0;

        Application.b_s("987", "987", judgement);
        assertEquals(0, judgement[0]); // 예상 결과: 0
        assertEquals(3, judgement[1]); // 예상 결과: 3


    }

}
