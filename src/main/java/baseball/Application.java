package baseball;

import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        Computer computer = new Computer(random);
        User user = new User(scanner);
        Game game = new Game(user, computer, scanner);

        game.play();

        scanner.close();
    }
}
