import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CNumTest {
    // 컴퓨터가 생성하는 숫자 개수가 3개인지, 각 자리수의 숫자가 서로 다른지 테스트
    @Test
    void testCNum() {
        CreateCnum createCnum = new CreateCnum();
        List<Integer> num = createCnum.ComputerNumber();
        assertEquals(3, num.size());
        assertTrue(num.get(0) != num.get(1) && num.get(1) != num.get(2) && num.get(2) != num.get(0));
    }

}
