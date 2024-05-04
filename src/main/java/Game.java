import java.io.IOException;
import java.util.List;

public class Game {

	private List<Integer> computerNumber;

	private boolean isFinished;
	private OutputView outputView;

	private AnswerCheck answerCheck;


	public void initGame() {
		NumberGenerator generator = new NumberGenerator();
		computerNumber = generator.generateAnswer();
		outputView = new OutputView();

	}

	public void runGame() throws IOException {
		isFinished = false;

		do{
			outputView.printNumberInput();
			List<Integer> playerNumber = InputView.readNumber();
			answerCheck = new AnswerCheck(computerNumber, playerNumber);
			Answer answer = answerCheck.checkResult();

			outputView.printAnswer(answer);
			isFinished = answer.isFinished();

		}while(!isFinished);
	}

	public int stateController() throws IOException {
		outputView.printCorrect();
		outputView.printRestartOrQuit();
		return InputView.readState();
	}
}
