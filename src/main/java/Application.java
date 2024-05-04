import domain.Computer;
import domain.Game;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Game game = new Game();
        Computer computer = new Computer();
        Scanner scanner = new Scanner(System.in);
        boolean checkRestart = true;
        while (checkRestart) {
            game.play(computer, scanner);
            checkRestart = game.restart(scanner);
        }
    }
}
