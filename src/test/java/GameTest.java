import static org.assertj.core.api.Assertions.assertThat;
import baseball.controller.NumberCompare;
import baseball.model.ComputerNumGenerator;
import baseball.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {
    @Test
    @DisplayName("랜덤 숫자 테스트")
    void randomNumberTest(){
        int[] computerNums = new ComputerNumGenerator().NUMS;
        assertThat(computerNums[0]).isBetween(1, 9);
        assertThat(computerNums[1]).isBetween(1, 9);
        assertThat(computerNums[2]).isBetween(1, 9);
    }

    @Test
    @DisplayName("볼 수 확인")
    void count(){
        NumberCompare compare = new NumberCompare(new int[]{1, 2, 3}, new int[]{2, 3, 4});
        assertThat(2).isEqualTo(compare.BALL_COUNT);
    }

    @Test
    @DisplayName("스트라이크 수 확인")
    void strike(){
        NumberCompare compare = new NumberCompare(new int[]{1, 2, 3}, new int[]{1, 2, 4});
        assertThat(2).isEqualTo(compare.STRIKE_COUNT);
    }

    @Test
    @DisplayName("3볼 확인")
    void ballcheak(){
        NumberCompare compare = new NumberCompare(new int[]{1, 2, 3}, new int[]{2, 3, 1});
        OutputView output = new OutputView(compare);
        assertThat("3볼").isEqualTo(output.makeResult());
    }

    @Test
    @DisplayName("3스트라이크 확인")
    void strikecheck(){
        NumberCompare compare = new NumberCompare(new int[]{1, 2, 3}, new int[]{1, 2, 3});
        OutputView output = new OutputView(compare);
        System.out.println(output.makeResult());
        assertThat("3스트라이크").isEqualTo(output.makeResult());
    }


    @Test
    @DisplayName("낫싱확인")
    void nothingcheck(){
        NumberCompare compare = new NumberCompare(new int[]{1, 2, 3}, new int[]{4, 5, 6});
        OutputView output = new OutputView(compare);
        assertThat("낫싱").isEqualTo(output.makeResult());
    }
}