import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class randomNumTest {

    makeRand numMaker;

    @BeforeEach
    void setUp() {
        numMaker = new makeRand();
    }

    @Test
    @DisplayName("사이즈 테스트")
    void sizeTest() {
        List<Integer> randomNum = numMaker.makeRandNum();
        assertThat(3).isEqualTo(randomNum.size());
    }

    @Test
    @DisplayName("범위 테스트")
    void rangeTest() {
        List<Integer> randomNum = numMaker.makeRandNum();
        assertThat(randomNum.stream().allMatch(num -> num >= 1 && num <= 9)).isTrue();
    }

    @Test
    @DisplayName("유니크 테스트")
    void uniqueTest() {
        List<Integer> randomNum = numMaker.makeRandNum();
        assertThat(randomNum.get(0)).isNotEqualTo(randomNum.get(1));
        assertThat(randomNum.get(1)).isNotEqualTo(randomNum.get(2));
        assertThat(randomNum.get(0)).isNotEqualTo(randomNum.get(2));
    }
}
