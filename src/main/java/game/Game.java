package game;

import java.util.Objects;
import utils.UserInputChecker;
import view.View;

public class Game {

    private static UserInputChecker userInputChecker = null;

    private String answer = null;

    public Game() {
        userInputChecker = UserInputChecker.getUserInputChecker();
    }

    /**
     * 상대방(컴퓨터)가 예상한 숫자(정답)을 설정한다.
     */
    private void setAnswer() {
        answer = (new RandomAnswerGenerator()).getAnswerAsString();
    }

    /**
     * 유저가 정답을 맞혔는지 판단한다
     * @param nStrike 스트라이크의 수
     * @return 정답을 맞힌 경우 true, 아니면 false
     */
    private boolean isCorrect(int nStrike) {
        return nStrike == GameParameters.nDigit;
    }

    /**
     * 유저의 응답을 정답과 비교하여 볼과 스트라이크의 수를 센다
     * @param userGuess 유저의 응답
     * @return [0]에는 볼, [1]에는 스트라이크의 수를 담은 배열
     */
    private int[] evaluate(String userGuess) {
        int[] ballAndStrike = new int[2];

        for (int i = 0; i < GameParameters.nDigit; i++) {
            int idx = answer.indexOf(userGuess.charAt(i));
            if (idx == i) {
                ballAndStrike[1]++;
            } else if (idx != -1) {
                ballAndStrike[0]++;
            }
        }
        return ballAndStrike;
    }

    /**
     * 다음 판을 진행할 지, 게임을 종료할 지 결정한다
     * @return 다음 판을 진행하는 경우 true, 종료하는 경우 false
     */
    private boolean doNextGame() {
        View.printCorrectAndGameOver();
        String userChoice = View.getUserChoiceForNextGame();
        userInputChecker.isValidChoice(userChoice);

        return Objects.equals(userChoice, GameParameters.nextGame);
    }

    /**
     * 한 판의 숫자야구 게임을 실행한다
     * 유저가 정답을 맞출 때까지 응답을 입력받고 결과를 출력한다
     */
    private void runSingleGame() {
        String userGuess;
        while (true) {
            userGuess = View.getUserGuess();
            userInputChecker.isValidGuess(userGuess);
            int[] ballAndStrike = evaluate(userGuess);
            int nBall = ballAndStrike[0];
            int nStrike = ballAndStrike[1];
            View.printResult(nBall, nStrike);

            if (isCorrect(nStrike)) {
                break;
            }
        }
    }

    /**
     * 여러 번의 게임을 반복적으로 실행한다
     * 매 게임이 시작될 때마다 정답을 세팅한다.
     * 매 게임이 끝날 때마다 다음 게임을 시작하거나, 완전히 종료한다
     */
    public void run() {
        boolean continueGame = true;
        while (continueGame) {
            setAnswer();
            runSingleGame();
            continueGame = doNextGame();
        }
    }
}
