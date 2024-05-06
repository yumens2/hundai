import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    void validateGuessSuccess() {
        int guess = 123;
        Assertions.assertThatCode(() -> Validator.validateGuess(guess)).doesNotThrowAnyException();
    }

    @Test
    void validateGuessTwoDigit() {
        int guess = 13;
        Assertions.assertThatThrownBy(() -> Validator.validateGuess(guess))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateGuessSameDigit() {
        int guess = 112;
        Assertions.assertThatThrownBy(() -> Validator.validateGuess(guess))
            .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void validateReGameSucess() {
        int num = 1;
        Assertions.assertThatCode(() -> Validator.validateReGame(num)).doesNotThrowAnyException();
    }

    @Test
    void validateReGameFail() {
        int num = 3;
        Assertions.assertThatThrownBy(() -> Validator.validateReGame(num))
            .isInstanceOf(IllegalArgumentException.class);
    }
}