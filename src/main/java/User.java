import java.util.Scanner;

public class User {
    private static final int GAME_NUM = 3;

    private final Scanner scanner;

    public User(Scanner scanner) {
        this.scanner = scanner;
    }
    public String readNumber(){
        return scanner.next();
    }
}
