import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BaseballGame {
    private final Scanner scanner = new Scanner(System.in);
    private final List<Integer> computerNumbers = new ArrayList<>();

    public void gamePlay() {

        boolean continuePlaying = true;

        while (continuePlaying) {
            computerGenerateNumbers();
            System.out.println(computerNumbers);
            boolean correctNumber = false;
            while (!correctNumber) {
                System.out.print("숫자를 입력해 주세요 : ");
                try {
                    String input = scanner.nextLine();
                    correctNumber = true;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    return;
                }
            }
            continuePlaying = false;
        }
    }

    private void computerGenerateNumbers() {
        computerNumbers.clear();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        for (int i = 0; i < 3; i++) {
            computerNumbers.add(numbers.get(i));
        }
    }
}