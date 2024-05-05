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
                throw new InputMismatchException();
            }

            Validator.validateGuess(guess);
            ResultDto resultDto = GameService.getResult(answer, guess);

            View.hintView(resultDto);
        }

        int input = View.successView();
        Validator.validateReGame(input);

        return input == 1;
    }

}
