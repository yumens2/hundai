import java.util.InputMismatchException;

public class Game {

    public static void start() {
        Game game = new Game();
        boolean flag = true;

        while (flag) {
            flag = game.play();
        }

    }

    int answer;

    public boolean play() {
        answer = GameService.getNewAnswer();
        int guess = 0;

        while (answer != guess) {
            try {
                guess = View.guessView();
            } catch (InputMismatchException e) {
                throw new IllegalArgumentException("숫자를 입력해야합니다.");
            } catch (Exception e) {
                throw new IllegalArgumentException();
            }

            Validator.validateGuess(guess);
            ResultDto resultDto = GameService.getResult(answer, guess);

            View.hintView(resultDto);
        }

        int input;
        try {
            input = View.successView();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        Validator.validateReGame(input);

        return input == 1;
    }

}
