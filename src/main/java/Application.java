import model.Computer;
import model.User;
import controller.GameController;
import view.UserInterface;

public class Application {

    public static void main(String[] args) {
        User user = new User();
        Computer computer = new Computer();

        UserInterface userInterface = new UserInterface();
        GameController gameController = new GameController(user, computer);

        UserInterface.printStartingGame();
        gameController.startGame();
        UserInterface.printEndingGame();

        userInterface.closeScanner();
    }
}
