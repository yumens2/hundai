
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class BaseballGameTest {
    private BaseballGame baseballGame;

    @BeforeEach
    public void setUp() {
        baseballGame = new BaseballGame();
    }

    @Test
    @DisplayName("랜덤한 숫자를 생성하는 테스트")
    // 랜덤한 숫자를 생성하고, 그 숫자가 유효한 범위 내에 있는지, 그리고 중복되지 않는지 테스트합니다.
    public void testGenerateRandomNumbers() {
        int[] numbers = baseballGame.generateRandomNumbers();
        assertThat(numbers.length).isEqualTo(3);
        assertThat(numbers[0]).isBetween(1, 9);
        assertThat(numbers[1]).isBetween(1, 9);
        assertThat(numbers[2]).isBetween(1, 9);
        assertThat(numbers[0]).isNotEqualTo(numbers[1]);
        assertThat(numbers[0]).isNotEqualTo(numbers[2]);
        assertThat(numbers[1]).isNotEqualTo(numbers[2]);
    }

    @Test
    @DisplayName("문자열을 숫자 배열로 변환하는 테스트")
    // 사용자가 입력한 문자열을 숫자 배열로 변환하는 기능을 테스트합니다.
    public void testConvertToIntArray() {
        int[] numbers = baseballGame.convertToIntArray("123");
        assertThat(numbers).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("스트라이크 개수를 세는 테스트")
    // 사용자의 추측과 컴퓨터의 숫자를 비교하여 스트라이크의 개수를 세는 기능을 테스트합니다.
    public void testCountStrikes() {
        int[] computerNumbers = {1, 2, 3};
        int[] guessNumbers = {1, 4, 5};
        baseballGame.computerNumbers = computerNumbers;
        assertThat(baseballGame.countStrikes(guessNumbers)).isEqualTo(1);
    }

    @Test
    @DisplayName("볼 개수를 세는 테스트")
    // 사용자의 추측과 컴퓨터의 숫자를 비교하여 볼의 개수를 세는 기능을 테스트합니다.
    public void testCountBalls() {
        int[] computerNumbers = {1, 2, 3};
        int[] guessNumbers = {3, 1, 5};
        baseballGame.computerNumbers = computerNumbers;
        assertThat(baseballGame.countBalls(guessNumbers)).isEqualTo(2);
    }
}