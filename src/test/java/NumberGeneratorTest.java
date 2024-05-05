import static org.assertj.core.api.Assertions.assertThat;

import game.NumberGenerator;
import game.RandomNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NumberGeneratorTest {
    NumberGenerator numberGenerator = new RandomNumberGenerator();
    List<Integer> numbers;

    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 9;
    static final int EXPECTED_NUMBER_LENGTH = 3;

    @BeforeEach
    void setUp() {
        numbers = numberGenerator.generateNumbers();
    }

    @Test
    void 생성번호_자리수_테스트() {
        assertThat(numbers.size()).isEqualTo(EXPECTED_NUMBER_LENGTH);
    }

    @Test
    void 생성번호_범위_테스트() {
        assertThat(isInRange(numbers)).isTrue();
    }

    @Test
    void 수_중복_테스트() {
        long distinctCount = numbers.stream().distinct().count();
        assertThat(distinctCount).isEqualTo(numbers.size());
    }

    private boolean isInRange(List<Integer> numbers) {
        for(int n : numbers) {
            if(n < MIN_NUMBER || n > MAX_NUMBER) {
                return false;
            }
        }
        return true;
    }
}