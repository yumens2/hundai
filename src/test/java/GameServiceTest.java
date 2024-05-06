import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GameServiceTest {

    @Test
    void getNewAnswer() {
        int answer = GameService.getNewAnswer();
        Assertions.assertThatCode(() -> Validator.validateGuess(answer)).doesNotThrowAnyException();
    }

    @Test
    void getResult() {
        int answer = 123;
        int guess = 135;

        ResultDto resultDto = GameService.getResult(answer, guess);

        Assertions.assertThat(resultDto.getBall()).isEqualTo(1);
        Assertions.assertThat(resultDto.getStrike()).isEqualTo(1);
    }
}