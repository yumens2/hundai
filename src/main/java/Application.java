import controller.GameController;
import java.io.IOException;
import service.GameService;
import view.GameView;

public class Application {

    public static void main(String[] args) throws IOException {
        GameView view = new GameView(System.in);
        GameService service = new GameService();
        GameController controller = new GameController(view, service);

        controller.startGame();
    }

}
