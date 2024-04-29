import controller.BaseBallController;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();
        final BaseBallController baseBallController = new BaseBallController(inputView, outputView);
    }
}
