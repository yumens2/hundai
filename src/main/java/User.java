import java.util.Scanner;

public class User {
    private static final int GAME_NUM = GameNum.GAME_NUM.getGameNum();

    private final Scanner scanner;

    public User(Scanner scanner) {
        this.scanner = scanner;
    }
    public String readNumber(){
        return scanner.next();
    }
    public int[] toArray(String userInput){
        return userInput.chars()
            .map(Character::getNumericValue)
            .toArray();
    }
}
