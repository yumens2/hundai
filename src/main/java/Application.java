import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        //wholegame();
        try {
            wholegame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }


    }
    public static void wholegame() {
        boolean continueGame = true;
        do {
            Game game = new Game();
            continueGame = game.playGame();
        } while (continueGame);
    }
}
