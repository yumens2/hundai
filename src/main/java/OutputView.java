public class OutputView {

	private static final String INPUT_NUMBER_REQUEST = "숫자를 입력하세요.";
	private static final String BALL = "볼";
	private static final String STRIKE = "스트라이크";
	private static final String NOTHING = "낫싱(0 볼, 0 스트라이크) 입니다.";
	private static final String CORRECT = "정답~! 참 잘 했어요!";
	private static final String RESTART_OR_QUIT_REQUEST = "재시작은 1, 종료는 2를 입력하세요.";

	public void printNumberInput() {
		System.out.println(INPUT_NUMBER_REQUEST);
	}

	public void printCorrect() {
		System.out.println(CORRECT);
	}

	public void printRestartOrQuit() {
		System.out.println(RESTART_OR_QUIT_REQUEST);
	}

	public void printAnswer(Answer answer) {
		StringBuilder sb = new StringBuilder();

		int ball = answer.getBall();
		int strike = answer.getStrike();

		if(ball > 0)  sb.append(ball).append(BALL);
		if(strike > 0)  sb.append(strike).append(STRIKE);
		if(ball == 0 && strike == 0) sb.append(NOTHING);

		System.out.println(sb);
	}

}
