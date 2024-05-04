import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class DuplicateCheckingTest {

    @Test
    @DisplayName("중복 확인하기")
    public void testExistDuplicate() {
        DuplicateChecking dc = new DuplicateChecking();
        int[] numArray = {1, 2, 3, 4, 2};

        //주어진 조건이 false로 평가되는지 확인한다.
        //조건이 false이면 테스트가 통과된다.
        //numArray에서 인덱스 3에서 중복 항목을 확인할 때 false를 반환해야 한다.
        assertFalse(dc.ExistDuplicate(numArray, 3));

        //주어진 조건이 true로 평가되는지 확인한다.
        //조건이 true이면 테스트가 통과된다.
        //numArray에서 인덱스 4에서 중복 항목을 확인할 때 true를 반환해야 한다.
        assertTrue(dc.ExistDuplicate(numArray, 4));
    }
}
