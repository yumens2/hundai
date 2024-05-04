import java.util.List;

public class AnswerCheck {

    private List<Integer> computerNumber;
    private List<Integer> playerNumber;

    private int ball = 0;
    private int strike = 0;

    public AnswerCheck(List<Integer> computerNumber, List<Integer> playerNumber) {
        this.computerNumber = computerNumber;
        this.playerNumber = playerNumber;
    }

    public Answer checkResult() {
        for (int i = 0; i < computerNumber.size(); i++) {
            checkBall(i);
            checkStrike(i);
        }
        return new Answer(ball, strike);
    }

    private void checkStrike(int index) {
			if (computerNumber.get(index).equals(playerNumber.get(index))) {
				strike++;
			}
    }

    private void checkBall(int index) {
        for (int i = 0; i < computerNumber.size(); i++) {
					if (computerNumber.get(index).equals(playerNumber.get(i)) && index != i) {
						ball++;
					}
        }
    }
}
