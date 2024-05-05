package game;

import java.util.Objects;
import utils.UserInputChecker;
import view.View;

public class Game {

    private static UserInputChecker userInputChecker = null;

    private String answer = null;
    private int nBall;
    private int nStrike;

    public Game() {
        userInputChecker = UserInputChecker.getUserInputChecker();
        nBall = 0;
        nStrike = 0;
    }

    /**
     * 상대방(컴퓨터)가 예상한 숫자(정답)을 설정한다.
     */
    private void setAnswer() {
        answer = (new RandomAnswerGenerator()).getAnswerAsString();
    }

    /**
     * 유저가 정답을 맞혔는지 판단한다
     *
     * @return 정답을 맞힌 경우 true, 아니면 false
     */
    private boolean isCorrect() {
        return nStrike == GameParameters.nDigit;
    }

    /**
     * 유저의 응답을 정답과 비교하여 볼과 스트라이크의 수를 세고 nBall과 nStrike를 업데이트한다.
     *
     * @param userGuess 유저의 응답
     */
    private void evaluate(String userGuess) {
        nBall = 0;
        nStrike = 0;
        for (int i = 0; i < GameParameters.nDigit; i++) {
            int idx = answer.indexOf(userGuess.charAt(i));
            if (idx == i) {
                nStrike++;
            } else if (idx != -1) {
                nBall++;
            }
        }
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
            evaluate(userGuess);
            View.printResult(nBall, nStrike);

            if (isCorrect()) {
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
            System.out.println(answer);
            runSingleGame();
            continueGame = doNextGame();
        }
    }
}
