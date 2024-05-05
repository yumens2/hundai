import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class JudgeTest {

    Compare compare;
    Judge judge;

    @BeforeEach
    void setUp() {
        compare = new Compare();
        judge = new Judge();
    }

    @Test
    @DisplayName("3볼 확인")
    void ballcheak() {
        assertThat("3볼").isEqualTo(
            judge.Judgement(new int[]{3, 1, 2}, new int[]{1, 2, 3}));
    }

    @Test
    @DisplayName("3스트라이크 확인")
    void Strikecheak() {
        assertThat("3스트라이크").isEqualTo(
            judge.Judgement(new int[]{1, 2, 3}, new int[]{1, 2, 3}));
    }

    @Test
    @DisplayName("낫싱확인")
    void nothingcheck(){
        assertThat("아무것도 없어요!").isEqualTo(judge.Judgement(new int[]{1, 2, 3}, new int[]{4,5,6}));
    }
}
