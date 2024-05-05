import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RefereeTest {

    @Test
    public void 심판_볼판정_테스트(){
        Referee referee = new Referee();
        JudgeDTO judgeDTO = referee.judge(List.of(1,2,3), List.of(2,3,1));

        Assertions.assertEquals(judgeDTO.getBallCount(), 3);
    }

    @Test
    public void 심판_스트라이크판정_테스트(){
        Referee referee = new Referee();
        JudgeDTO judgeDTO = referee.judge(List.of(1,2,3), List.of(3,2,1));

        Assertions.assertEquals(judgeDTO.getStrikeCount(), 1);
    }

    @Test
    public void 심판_낫싱판정_테스트(){
        Referee referee = new Referee();
        JudgeDTO judgeDTO = referee.judge(List.of(1,2,3), List.of(4,5,6));

        Assertions.assertEquals(judgeDTO.getStrikeCount(), 0);
        Assertions.assertEquals(judgeDTO.getBallCount(), 0);
    }
}
