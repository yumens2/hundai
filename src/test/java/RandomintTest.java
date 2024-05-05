import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.*;


public class RandomintTest {
    @Test
    public void testRandomint() {
        Randomint r = new Randomint();
        int[] arr = new int[3];
        r.randint(arr);

        for (int i = 0; i < arr.length; i++) {
            assertTrue(arr[i] >= 1 && arr[i] <= 9);
        }//1~9까지의 숫자인지 확인

        assertTrue(arr[0]!=arr[1] && arr[1]!=arr[2] && arr[2]!=arr[0]);
        //겹치는 숫자가 없는지 확인
    }

}
