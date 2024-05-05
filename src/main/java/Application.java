import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Game game = new Game(new Computer(), new User(new Scanner(System.in)), new Validator(), new CheckNum());
        game.start();
    }
}
