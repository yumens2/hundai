import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class BaseballGameTest {

    @Test
    public void testGenerateGameNumber() {
        BaseballGame game = new BaseballGame();
        int[] gameNumber = game.generateGameNumber();

        // 게임 번호를 생성하는 메소드를 테스트
        // 게임 번호의 길이가 3이어야 합니다.
        Assertions.assertThat(gameNumber).hasSize(3);

        // 게임 번호의 각 자리 숫자는 1부터 9까지의 범위 내에 있어야함
        for (int number : gameNumber) {
            Assertions.assertThat(number).isBetween(1, 9);
        }

        // 게임 번호에 중복된 숫자가 없어야함
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : gameNumber) {
            uniqueNumbers.add(number);
        }
        Assertions.assertThat(uniqueNumbers.size()).isEqualTo(3);
    }

    @Test
    public void testIsDuplication() {
        BaseballGame game = new BaseballGame();

        // 중복되지 않은 배열에 대해 false를 반환해야함
        int[] testNumbers1 = {1, 2, 3};
        Assertions.assertThat(game.isDuplication(testNumbers1, 2)).isFalse();

        // 중복된 배열에 대해 true를 반환해야함
        int[] testNumbers2 = {1, 2, 1};
        Assertions.assertThat(game.isDuplication(testNumbers2, 2)).isTrue();
    }

    @Test
    public void testGetGuess() {
        BaseballGame game = new BaseballGame();
        int input = 123;
        int[] expected = {1, 2, 3};

        // 사용자로부터 입력된 숫자를 배열로 변환하여 반환해야함
        Assertions.assertThat(game.getGuess(new java.util.Scanner(String.valueOf(input)))).isEqualTo(expected);
    }

    @Test
    public void testCheckResult() {
        BaseballGame game = new BaseballGame();
        int[] gameNumber = {1, 2, 3};

        // 정답과 추측한 숫자가 모두 같은 경우 스트라이크가 3이 되어야함
        int[] guess1 = {1, 2, 3};
        int[] result1 = game.checkResult(gameNumber, guess1);
        Assertions.assertThat(result1).containsExactly(3, 0);

        // 정답과 추측한 숫자가 모두 다른 경우 낫싱이 되어야함
        int[] guess2 = {4, 5, 6};
        int[] result2 = game.checkResult(gameNumber, guess2);
        Assertions.assertThat(result2).containsExactly(0, 0);

        // 정답과 추측한 숫자 중 값이 같고 순서가 다른 경우 볼과 스트라이크가 계산되어야함
        int[] guess3 = {1, 3, 2};
        int[] result3 = game.checkResult(gameNumber, guess3);
        Assertions.assertThat(result3).containsExactly(1, 2);
    }

}
