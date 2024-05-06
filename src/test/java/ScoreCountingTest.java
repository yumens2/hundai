import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ScoreCountingTest {

    @Test
    @DisplayName("점수 집계 테스트")
    public void count(){
        //given
        List<Integer> userInputs = new ArrayList<>();
        userInputs.add(1);
        userInputs.add(5);
        userInputs.add(8);
        List<Integer> randInts = new ArrayList<>();
        randInts.add(8);
        randInts.add(5);
        randInts.add(3);
        ScoreCounting counting = new ScoreCounting();

        //when
        boolean result = counting.count(userInputs,randInts);

        //then
        Assertions.assertFalse(result);
    }
}
