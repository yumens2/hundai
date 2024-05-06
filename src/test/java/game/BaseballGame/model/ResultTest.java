package game.BaseballGame.model;

import game.gamePack.BaseballGame.model.Result;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {

    Result result = Result.getInstance();

    @Test
    @DisplayName("getOutCome 테스트")
    void getOutComeTest() {
        // given
        List<Integer> computerNumbers = List.of(1, 2, 3);
        List<Integer> guessNumbers = List.of(1, 2, 3);
        List<Integer> guessNumbers2 = List.of(1, 2, 4);
        // then
        boolean result1 = result.getOutCome(computerNumbers, guessNumbers);
        boolean result2 = result.getOutCome(computerNumbers, guessNumbers2);
        // when
        Assertions.assertEquals(false, result1);
        Assertions.assertEquals(true, result2);
    }


}
