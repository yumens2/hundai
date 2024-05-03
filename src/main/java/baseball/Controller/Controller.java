package baseball.Controller;

import baseball.model.Score;
import baseball.utils.ValidateAnswer;
import baseball.utils.ValidateRestart;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

import static baseball.model.Computer.getComputerNumbers;

public class Controller {

    public static void run() {
        do {
            playGame();
        } while(decideRestart());
    }

    public static void playGame() {
        List<Integer> computerNumbers = getComputerNumbers();
        System.out.println(computerNumbers);
        Score score;
        do {
            score = guessNumber(computerNumbers);
            //System.out.println(score.getBallCount());
            OutputView.printResult(score.getStrikeCount(), score.getBallCount());
        } while (!guessCorrect(score));
    }
    public static boolean guessCorrect(Score score) {
        return ValidateAnswer.isCorrect(score.getStrikeCount());
    }
    public static Score guessNumber(List<Integer> computerNumbers){
        String userNumbers = null;

//        userNumbers = InputView.printGameStart();
        try {
            userNumbers = InputView.printGameStart();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return Score.getResults(userNumbers, computerNumbers);
    }

    public static boolean decideRestart() {
        OutputView.printGameEnd();
        int signal = InputView.printRestartRequest();
        return ValidateRestart.restartGame(signal);
    }



}
