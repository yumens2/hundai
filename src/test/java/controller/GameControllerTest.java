package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.GameView;

class GameControllerTest {

    @Test
    @DisplayName("GameController dependencies test")
    void gameControllerDependenciesTest() throws Exception {
        //given
        GameView view = new GameView(System.in);
        GameService service = new GameService();

        //when
        GameController controller = new GameController(view, service);

        //then
        assertNotNull(controller.getView());
        assertNotNull(controller.getService());
    }
}