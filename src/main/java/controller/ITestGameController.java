package controller;

import java.io.IOException;
import service.GameService;
import view.GameView;

public interface ITestGameController {
    boolean isGameActive();
    GameView getView();
    GameService getService();
    void startGame() throws IOException;
}
