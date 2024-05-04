import java.util.List;
import util.Casting;
import view.InputView;

public class BaseBallGame {
    private InputView inputView = new InputView();
    private Computer computer;

    public void gameStart() {
        initComputer();
        while(true) {
            List<Integer> playerNumbers = inputPlayerNumber();
        }
    }

    private void initComputer() {
        computer = new Computer();
    }

    private List<Integer> inputPlayerNumber() {
        return Casting.stringToIntegerList(inputView.inputPlayerNumber());
    }
}