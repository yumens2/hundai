import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.Arrays;

public class resultTest {

    compare comparing;

    @BeforeEach
    public void setUp() {
        comparing = new compare();
    }

    @Test
    @DisplayName("nothing test")
    public void nothingTest() {

        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);

        assertThat("낫싱").isEqualTo(comparing.compareNum(list1, list2));

    }

    @Test
    @DisplayName("ball test")
    public void ballTest() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(3, 1, 2);

        assertThat("3볼").isEqualTo(comparing.compareNum(list1, list2));

    }

    @Test
    @DisplayName("strike test")
    public void strikeTest() {

        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(1, 2, 3);

        assertThat("3스트라이크").isEqualTo(comparing.compareNum(list1, list2));

    }
}
