package game;

public class Evaluator {

    private String answer;
    private int nBall;
    private int nStrike;

    public Evaluator() {
        nBall = 0;
        nStrike = 0;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getNBall() {
        return nBall;
    }

    public int getNStrike() {
        return nStrike;
    }

    /**
     * 유저가 정답을 맞혔는지 판단한다
     *
     * @return 정답을 맞힌 경우 true, 아니면 false
     */
    public boolean isCorrect() {
        return nStrike == GameParameters.nDigit;
    }

    /**
     * 유저의 응답을 정답과 비교하여 볼과 스트라이크의 수를 세고 nBall과 nStrike를 업데이트한다.
     *
     * @param userGuess 유저의 응답
     */
    public void evaluate(String userGuess) {
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
}
