
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JudgeTest {
    Compare compare;
    Judge judge;

    @BeforeEach
    void setUp(){
        compare = new Compare();
        judge = new Judge();
    }

    @Test
    //@DisplayName("3볼 확인")
    void ballcheak(){
        assertThat("3볼").isEqualTo(judge.judgement(Arrays.asList(3,1,2),Arrays.asList(1,2,3)));
    }

    @Test
    //@DisplayName("3스트라이크 확인")
    void strikecheck(){
        assertThat("3스트라이크").isEqualTo(judge.judgement(Arrays.asList(1,2,3),Arrays.asList(1,2,3)));
    }


    @Test
    //@DisplayName("낫싱확인")
    void nothingcheck(){
        assertThat("낫싱").isEqualTo(judge.judgement(Arrays.asList(1,2,3),Arrays.asList(4,5,6)));
    }
}