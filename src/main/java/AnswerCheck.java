import java.util.List;

public class AnswerCheck {

	private List<Integer> computerNumber;
	private List<Integer> playerNumber;

	public AnswerCheck(List<Integer> computerNumber, List<Integer> playerNumber) {
		this.computerNumber = computerNumber;
		this.playerNumber = playerNumber;
	}

	public Answer checkResult() {
		int strike = 0, ball= 0;
		for(int i = 0; i < computerNumber.size(); i++) {
			ball = checkBall(i);
			strike = checkStrike(i);
		}
		return new Answer(ball,strike);
	}

	private int checkStrike(int index) {
		int strike = 0;
		if(computerNumber.get(index).equals(playerNumber.get(index))) strike++;
		return strike;
	}

	private int checkBall(int index) {
		int ball = 0;
		int existNumber = computerNumber.get(index);
		for(int i = 0; i < computerNumber.size(); i++) {
			if(computerNumber.get(index).equals(playerNumber.get(i)) && index != i) ball++;
		}
		return ball;
	}
}
