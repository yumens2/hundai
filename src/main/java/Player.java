import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Player {
    private final Scanner scanner;

    public Player() {
        this.scanner = new Scanner(System.in);
    }

    public List<Integer> guess() {
        System.out.print("숫자를 입력해 주세요 : ");
        String input = scanner.nextLine();

        if (input.length() != 3 || !input.matches("[1-9]{3}")) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }

        List<Integer> guess = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            guess.add(ch - '0');
        }
        return guess;
    }
}