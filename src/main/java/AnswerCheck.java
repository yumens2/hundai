import java.util.List;

public class AnswerCheck {

	private List<Integer> playerNumber;
	private List<Integer> computerNumber;

	public AnswerCheck(List<Integer> playerNumber) {
		this.playerNumber = playerNumber;
	}

	public void checkResult(List<Integer> computerNumber, List<Integer> playerNumber) {
		int strike, ball;
		for(int i = 0; i < computerNumber.size(); i++) {
			ball = checkBall(computerNumber, playerNumber, i);
			strike = checkStrike(computerNumber, playerNumber, i);
		}
	}

	private int checkStrike(List<Integer> computerNumber, List<Integer> playerNumber, int index) {
		int strike = 0;
		if(computerNumber.get(index).equals(playerNumber.get(index))) strike++;
		return strike;
	}

	private int checkBall(List<Integer> computerNumber, List<Integer> playerNumber, int index) {
		int ball = 0;
		int existNumber = computerNumber.get(index);
		for(int i = 0; i < computerNumber.size(); i++) {
			if(computerNumber.get(index).equals(playerNumber.get(i)) && index != i) ball++;
		}
		return ball;
	}
}
