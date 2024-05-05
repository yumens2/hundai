
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CompareTest {
    Compare compare;

    @BeforeEach
    void setUp(){
        compare = new Compare();
    }

    @Test
    void count(){
        assertThat(3).isEqualTo(compare.howMany(Arrays.asList(1,2,3), Arrays.asList(3,1,2)));
    }

    @Test
    void strike(){
        assertThat(1).isEqualTo(compare.countStrike(Arrays.asList(3,2,4),Arrays.asList(3,1,2)));
    }
}
