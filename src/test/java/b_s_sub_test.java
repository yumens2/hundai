import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class b_s_sub_test {

    @Test
    public void testBSSUBTest() {
        int[] judgement = {0, 0};
        String com = "123";
        String num = "321";
        Application.b_s_sub(0, com, num, judgement);
        Application.b_s_sub(1, com, num, judgement);
        Application.b_s_sub(2, com, num, judgement);

        //최종 결과
        assertEquals(2, judgement[0]); // 예상 결과: 2볼
        assertEquals(1, judgement[1]); // 예상 결과: 1스트라이크


    }

    @Test
    public void testBSSUBTest2() {
        int[] judgement = {0, 0};
        String com = "946";
        String num = "321";
        Application.b_s_sub(0, com, num, judgement);
        Application.b_s_sub(1, com, num, judgement);
        Application.b_s_sub(2, com, num, judgement);

        //최종 결과
        assertEquals(0, judgement[0]); // 예상 결과: 0볼
        assertEquals(0, judgement[1]); // 예상 결과: 0스트라이크


    }
}
