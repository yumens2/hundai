import game.BaseballGame;
import game.Computer;
import game.NumberGenerator;
import game.RandomNumberGenerator;
import view.ConsoleInputView;
import view.ConsoleOutputView;
import view.InputView;
import view.OutputView;

public class AppConfig {
    public BaseballGame baseballGame() {
        return new BaseballGame(inputView(), outputView(), computer());
    }

    public Computer computer() {
        return new Computer(numberGenerator());
    }

    public NumberGenerator numberGenerator() {
        return new RandomNumberGenerator();
    }

    public InputView inputView() {
        return new ConsoleInputView();
    }

    public OutputView outputView() {
        return new ConsoleOutputView();
    }
}
