package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.GameService;
import view.GameView;

class GameControllerTest {
    private GameView view;
    private GameService service;
    private ITestGameController controller;

    @BeforeEach
    void setUp() {
        view = new GameView(System.in);
        service = new GameService();
        controller = new GameController(view, service);
    }

    @Test
    @DisplayName("GameController dependencies test")
    void gameControllerDependenciesTest() throws Exception {
        //then
        assertNotNull(controller.getView());
        assertNotNull(controller.getService());
    }

    @Test
    @DisplayName("startGame should activate the game")
    void isGameActiveTest() throws Exception {
        //then
        assertFalse(controller.isGameActive());
        controller.startGame();
        assertTrue(controller.isGameActive());
    }
}