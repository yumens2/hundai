package model;

import java.util.List;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNonZeroNumberGeneratorTest {

    @Test
    @DisplayName("1에서 9까지 서로 다른 임의의 수 생성")
    void generate() {
        // given
        NumberGenerator generator = new RandomNonZeroNumberGenerator();

        // when
        List<Integer> numbers = generator.generate();

        // then
        assertThat(numbers.size()).isEqualTo(3);
        assertThat(numbers).doesNotContain(0);
        assertThat(numbers).doesNotHaveDuplicates();
    }
}