package game;

import java.util.Objects;
import utils.UserInputChecker;
import view.View;

public class Game {

    private static UserInputChecker userInputChecker = null;
    private Evaluator evaluator;

    public Game() {
        userInputChecker = UserInputChecker.getUserInputChecker();
        evaluator = new Evaluator();
    }

    /**
     * 상대방(컴퓨터)가 예상한 숫자(정답)을 설정한다.
     */
    private void setAnswer() {
        String answer = (new RandomAnswerGenerator()).getAnswerAsString();
        evaluator.setAnswer(answer);
    }

    /**
     * 다음 판을 진행할 지, 게임을 종료할 지 결정한다
     *
     * @return 다음 판을 진행하는 경우 true, 종료하는 경우 false
     */
    private boolean doNextGame() {
        View.printCorrectAndGameOver();
        String userChoice = View.getUserChoiceForNextGame();
        userInputChecker.isValidChoice(userChoice);

        return Objects.equals(userChoice, GameParameters.nextGame);
    }

    /**
     * 한 판의 숫자야구 게임을 실행한다 유저가 정답을 맞출 때까지 응답을 입력받고 결과를 출력한다
     */
    private void runSingleGame() {
        String userGuess;
        while (true) {
            userGuess = View.getUserGuess();
            userInputChecker.isValidGuess(userGuess);
            evaluator.evaluate(userGuess);
            View.printResult(evaluator.getNBall(), evaluator.getNStrike());

            if (evaluator.isCorrect()) {
                break;
            }
        }
    }

    /**
     * 여러 번의 게임을 반복적으로 실행한다 매 게임이 시작될 때마다 정답을 세팅한다. 매 게임이 끝날 때마다 다음 게임을 시작하거나, 완전히 종료한다
     */
    public void run() {
        boolean continueGame = true;
        while (continueGame) {
            setAnswer();
            System.out.println(evaluator.getAnswer());
            runSingleGame();
            continueGame = doNextGame();
        }
    }
}
