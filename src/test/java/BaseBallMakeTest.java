import static org.assertj.core.api.Assertions.assertThat;

import baseball.BaseballMaker;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class BaseBallMakeTest {
    @DisplayName("야구게임 생성 사이즈 테스트")
    @Test
    void baseballMakeTest(){
        final BaseballMaker baseballMaker=new BaseballMaker();

        final List<Integer> game =baseballMaker.makeBaseball();

        assertThat(game.size()).isEqualTo(3);
    }

    @DisplayName("야구게임 범위 테스트")
    @Test
    void baseballRangeTest(){
        final BaseballMaker baseballMaker=new BaseballMaker();

        final List<Integer> game =baseballMaker.makeBaseball();

        assertThat(game.stream().allMatch(n->n>=1&&n<=9)).isTrue();
    }
}
