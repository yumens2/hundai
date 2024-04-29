import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BaseballGameTest {
    private BaseballGame game;
    @BeforeEach
    public void setGame(){
        game = new BaseballGame();
    }
    @Test
    @DisplayName("2 스트라이크 확인")
    public void testCompareNum_checkStrike() {

        List<Integer> userNum = Arrays.asList(1, 2, 3);
        List<Integer> cpuNum = Arrays.asList(1, 2, 5);
        game.compareNum(userNum, cpuNum);
        assertEquals(2, game.strike);
        assertEquals(0, game.ball);
    }

    @Test
    @DisplayName("3볼 확인")
    public void testCompareNum_checkThreeBall() {
        List<Integer> userNum = Arrays.asList(1, 2, 3);
        List<Integer> cpuNum = Arrays.asList(2, 3, 1);
        game.compareNum(userNum, cpuNum);
        assertEquals(0, game.strike);
        assertEquals(3, game.ball);
    }

    @Test
    @DisplayName("1볼 1스트라이크 확인")
    public void testCompareNum_checkStrikeAndBall() {
        List<Integer> userNum = Arrays.asList(1, 2, 3);
        List<Integer> cpuNum = Arrays.asList(1, 3, 4);
        game.compareNum(userNum, cpuNum);
        assertEquals(1, game.strike);
        assertEquals(1, game.ball);
    }
    @Test
    @DisplayName("낫싱 확인")
    public void testCompareNum_checkNothing() {
        List<Integer> userNum = Arrays.asList(1, 2, 3);
        List<Integer> cpuNum = Arrays.asList(4, 5, 6);
        game.compareNum(userNum, cpuNum);
        assertEquals(0, game.strike);
        assertEquals(0, game.ball);
    }

    @Test
    @DisplayName("게임 재시작 혹은 게임 종료 선택 시 1,2 외의 숫자가 들어갔을때 확인")
    public void testIsValidRestartOrGameOverNum_checkValid() {
        BaseballGame game = new BaseballGame();
        assertThrows(IllegalArgumentException.class, () -> {
            game.isValidRestartOrGameOverNum(3);
        });
    }
}
