import game.Game;
import game.RandomGame;
import io.ConsoleInput;
import io.ConsoleOutput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new RandomGame(
                new ConsoleInput(new Scanner(System.in)),
                new ConsoleOutput());
        game.play();
    }
}
