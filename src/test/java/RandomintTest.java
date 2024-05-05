import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;



public class RandomintTest {
    @Test
    public void testrandint() {
        Randomint r = new Randomint();
        int[] arr = new int[3];
        r.randint(arr);

        for (int i = 0; i < arr.length; i++) {
            assertTrue(arr[i] >= 1 && arr[i] <= 9);
        }//1~9까지의 숫자인지 확인

        assertTrue(arr[0]!=arr[1] && arr[1]!=arr[2] && arr[2]!=arr[0]);
        //겹치는 숫자가 없는지 확인
    }

    @Test
    public void TestintTest() {
        Randomint r2 = new Randomint();
        int[] arr2 = {1, 2, 3};
        // n 값이 범위를 벗어났을 때 IllegalArgumentException이 발생하는지 테스트
        assertThatThrownBy(() -> r2.intTest(9999, arr2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3자리수가 아닙니다.");

        assertThatThrownBy(() -> r2.intTest(10, arr2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3자리수가 아닙니다.");

        // 배열에 중복된 숫자가 있을 때 IllegalArgumentException이 발생하는지 테스트
        int[] arr3 = {1, 2, 2};
        assertThatThrownBy(() -> r2.intTest(123, arr3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 숫자입니다.");

        // 배열에 0이 포함되어 있을 때 IllegalArgumentException이 발생하는지 테스트
        int[] arr4 = {1, 0, 3};
        assertThatThrownBy(() -> r2.intTest(103, arr4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1~9 사이의 숫자가 아닙니다.");
    }

}
