import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
class CreateRandomTest {

    @DisplayName("(0~9) 랜덤 숫자 생성 테스트")
    @Test
    void createNumTest() {
        //given
        CreateRandom createRandom=new CreateRandom();

        // when
        int num = createRandom.createNum();
        // then
        Assertions.assertThat(num)
            .isGreaterThan(0)
            .isLessThan(10);
    }

    @DisplayName("랜덤 숫자 리스트 사이즈 테스트")
    @Test
    void createListSizeTest() {
        // given
        CreateRandom createRandom=new CreateRandom();
        ArrayList<Integer> list=new ArrayList<Integer>();
        // when
        list = createRandom.createList();
        // then
        Assertions.assertThat(list.size())
            .isEqualTo(3);
    }

    @DisplayName("랜덤 숫자 리스트 범위 테스트")
    @Test
    void createListRangeTest() {
        // given
        CreateRandom createRandom=new CreateRandom();
        ArrayList<Integer> list=new ArrayList<Integer>();
        // when
        list = createRandom.createList();
        // then
        Assertions.assertThat(list.stream().allMatch(n -> n >=1 && n <= 9)).isTrue();
    }

}