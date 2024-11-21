import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class RandomNumberTest {

    @Test
    @DisplayName("랜덤변수 생성 테스트")
    void DuplicationAndSizeTest() {
        //given
        ArrayList<Integer> list = RandomNumber.generateRandomNumber();
        Set<Integer> set = new HashSet<>(list);

        //when & then
        assertThat(set.size()).isEqualTo(3);
        assertThat(list.size()).isEqualTo(3);
    }
}
