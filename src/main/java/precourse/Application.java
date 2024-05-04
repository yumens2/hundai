package precourse;

import precourse.game.NumberBaseBall;
import precourse.game.Validator;
import precourse.input.ScannerInputManager;
import precourse.player.Player;

public class Application {
    public static void main(String[] args) {
        Player player = new Player(
                new ScannerInputManager(),
                new NumberBaseBall(new Validator()));
        player.playNumberBaseBall();
    }
}
