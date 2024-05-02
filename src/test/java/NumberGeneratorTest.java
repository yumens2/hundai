import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberGeneratorTest {

    @Test
    @DisplayName("랜덤으로 생성한 숫자의 길이가 3인지 테스트")
    void createRandomNumbers_isLength3() {
        //given
        NumberGenerator computer = new NumberGenerator();

        //when
        List<Integer> numbers = computer.createRandomNumbers();

        //then
        assertThat(numbers.size()).isEqualTo(3);
    }
}