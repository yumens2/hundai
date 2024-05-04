import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BaseballTest {

        @Test
        @DisplayName("입력받은 숫자 중에 중복된 숫자가 있을때")
        public void error_same() {
            int error = 121 ;
            assertEquals(1, Baseball.find_same_number(error));
        }

    @Test
    @DisplayName("입력받은 숫자 중에 0이 있을때")
    public void error_zero() {
        int error = 102 ;
        assertEquals(1, Baseball.find_zero(error));
    }

    @Test
    @DisplayName("랜덤 숫자중에 오류가 있는가?")
    public void error_rand() {
        int error = Baseball.get_rand() ;
        assertEquals(0,Baseball.error_list(error) );
    }



    @Test
    @DisplayName("출력이 옳게 나오는가?")
    public void test_print() {
        BaseballVO vo = new BaseballVO(123,135);
        // 1스트 1볼 -> 110 으로 출력될 예정
        vo.make_array();
        vo.compare();
        assertEquals(110,vo.set_answer() );
    }
}
