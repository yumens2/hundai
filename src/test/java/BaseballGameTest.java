import game.BaseballGame;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.ArrayList;
import java.util.Arrays;

public class BaseballGameTest {
    @Test
    @DisplayName("정답과 입력값이 같을 때 3스트라이크인지 확인")
    public void test3strike() {
        ArrayList<Integer> targetNumbers = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> inputNumbers = new ArrayList<>(Arrays.asList(1, 2, 3));
        int strike = BaseballGame.play(targetNumbers, inputNumbers);
        if (strike == 3) {
            System.out.println("3스트라이크");
        }
    }

    @Test
    @DisplayName("정답과 입력값이 다를 때 0스트라이크인지 확인")
    public void testNothing() {
        ArrayList<Integer> targetNumbers = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> inputNumbers = new ArrayList<>(Arrays.asList(4, 5, 6));
        int strike = BaseballGame.play(targetNumbers, inputNumbers);
        if (strike == 0) {
            System.out.println("낫싱");
        }
    }

    @Test
    @DisplayName("1스트라이크인지 확인")
    public void test1Strike() {
        ArrayList<Integer> targetNumbers = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> inputNumbers = new ArrayList<>(Arrays.asList(1, 4, 5));
        int strike = BaseballGame.play(targetNumbers, inputNumbers);
        if (strike == 1) {
            System.out.println("1스트라이크");
        }
    }


}
