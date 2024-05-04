public class Answer {

	private int ball;
	private int strike;
	public Answer(int ball, int strike) {
		this.ball = ball;
		this.strike = strike;
	}

	public int getBall() {
		return ball;
	}

	public int getStrike() {
		return strike;
	}

	public boolean isFinished() {
		return getStrike() == 3;
	}
}
